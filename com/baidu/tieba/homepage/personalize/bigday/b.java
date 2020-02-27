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
    private g.c dgH;
    private g.b dgI;
    private g.d dgJ;
    private g.a dgK;
    private ImageView heA;
    private TextView heB;
    private com.baidu.tbadk.core.bigday.a heC;
    private String heD;
    private String heE;
    private String heF;
    private String heG;
    private TbImageView hey;
    private LottieAnimationView hez;

    public b(Context context) {
        super(context);
        this.dgH = null;
        this.dgI = null;
        this.dgJ = null;
        this.dgK = null;
        if (context != null) {
            this.heD = context.getText(R.string.adp_pull_to_refresh).toString();
            this.heE = context.getText(R.string.bigday_refreshing).toString();
            this.heF = context.getText(R.string.bigday_release_to_refresh).toString();
            this.heG = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dgH = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dgI = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dgJ = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dgK = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.hey = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.hez = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.heA = (ImageView) inflate.findViewById(R.id.text_mask);
        this.heB = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.hey.setAutoChangeStyle(false);
        this.heB.setText(this.heD);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.azT()) {
            this.heC = aVar;
        }
        if (aVar.cLR == 1) {
            this.heB.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.heA.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.hez.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.heB.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.heA.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.hez.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.hez.setFrame(0);
        this.hey.startLoad(aVar.imgUrl, 41, false);
        this.hey.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.hey.getBdImage() == null && b.this.heC != null && !aq.isEmpty(b.this.heC.imgUrl)) {
                    b.this.hey.startLoad(b.this.heC.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bPc() {
        return this.heC;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.heB.setText(this.heD);
        if (this.dgJ != null) {
            this.dgJ.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.heB.setText(this.heF);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.heB.setText(this.heE);
        this.hez.setAlpha(1.0f);
        this.hez.setMinAndMaxFrame(8, 58);
        this.hez.loop(true);
        this.hez.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dgH != null) {
            this.dgH.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.heB.setText("");
        this.hez.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.hez.setAlpha(1.0f);
        this.heB.setText(this.heD);
        if (this.dgK != null) {
            this.dgK.aHV();
        }
        if (this.dgI != null) {
            this.dgI.onListPullRefreshFinished(getView(), z);
        }
        this.hez.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bOZ() {
        this.heB.setText(this.heG);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPa() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.heB.animate().alpha(0.0f).setDuration(200L).start();
        this.heA.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPb() {
        if (this.heC != null && this.heC.azT()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.heC.imgUrl, this.heC.cLQ, this.heC.cLS)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bOY() {
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
            this.hez.setProgress(f3);
            return;
        }
        this.hez.setAlpha(1.0f - ((f4 - dimension2) / (bOY() - dimension2)));
    }

    private void setAlpha(float f) {
        this.heB.setAlpha(f);
        this.heA.setAlpha(f);
        if (this.heA.getBackground() == null && this.heC != null) {
            if (this.heC.cLR == 1) {
                this.heA.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.heA.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
