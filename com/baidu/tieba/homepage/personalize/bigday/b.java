package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes9.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.c dgI;
    private g.b dgJ;
    private g.d dgK;
    private g.a dgL;
    private TbImageView heA;
    private LottieAnimationView heB;
    private ImageView heC;
    private TextView heD;
    private com.baidu.tbadk.core.bigday.a heE;
    private String heF;
    private String heG;
    private String heH;
    private String heI;

    public b(Context context) {
        super(context);
        this.dgI = null;
        this.dgJ = null;
        this.dgK = null;
        this.dgL = null;
        if (context != null) {
            this.heF = context.getText(R.string.adp_pull_to_refresh).toString();
            this.heG = context.getText(R.string.bigday_refreshing).toString();
            this.heH = context.getText(R.string.bigday_release_to_refresh).toString();
            this.heI = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dgI = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dgJ = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dgK = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dgL = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.heA = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.heB = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.heC = (ImageView) inflate.findViewById(R.id.text_mask);
        this.heD = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.heA.setAutoChangeStyle(false);
        this.heD.setText(this.heF);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.azV()) {
            this.heE = aVar;
        }
        if (aVar.cLS == 1) {
            this.heD.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.heC.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.heB.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.heD.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.heC.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.heB.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.heB.setFrame(0);
        this.heA.startLoad(aVar.imgUrl, 41, false);
        this.heA.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.heA.getBdImage() == null && b.this.heE != null && !aq.isEmpty(b.this.heE.imgUrl)) {
                    b.this.heA.startLoad(b.this.heE.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bPe() {
        return this.heE;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.heD.setText(this.heF);
        if (this.dgK != null) {
            this.dgK.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.heD.setText(this.heH);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.heD.setText(this.heG);
        this.heB.setAlpha(1.0f);
        this.heB.setMinAndMaxFrame(8, 58);
        this.heB.loop(true);
        this.heB.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dgI != null) {
            this.dgI.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.heD.setText("");
        this.heB.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.heB.setAlpha(1.0f);
        this.heD.setText(this.heF);
        if (this.dgL != null) {
            this.dgL.aHX();
        }
        if (this.dgJ != null) {
            this.dgJ.onListPullRefreshFinished(getView(), z);
        }
        this.heB.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPb() {
        this.heD.setText(this.heI);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.heD.animate().alpha(0.0f).setDuration(200L).start();
        this.heC.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPd() {
        if (this.heE != null && this.heE.azV()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.heE.imgUrl, this.heE.cLR, this.heE.cLT)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bPa() {
        return (int) (l.getEquipmentHeight(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
        float f3 = 0.0f;
        super.onPullPercentChange(f, f2);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.heB.setProgress(f3);
            return;
        }
        this.heB.setAlpha(1.0f - ((f4 - dimension2) / (bPa() - dimension2)));
    }

    private void setAlpha(float f) {
        this.heD.setAlpha(f);
        this.heC.setAlpha(f);
        if (this.heC.getBackground() == null && this.heE != null) {
            if (this.heE.cLS == 1) {
                this.heC.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.heC.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
