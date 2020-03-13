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
    private g.c dgV;
    private g.b dgW;
    private g.d dgX;
    private g.a dgY;
    private TbImageView heM;
    private LottieAnimationView heN;
    private ImageView heO;
    private TextView heP;
    private com.baidu.tbadk.core.bigday.a heQ;
    private String heR;
    private String heS;
    private String heT;
    private String heU;

    public b(Context context) {
        super(context);
        this.dgV = null;
        this.dgW = null;
        this.dgX = null;
        this.dgY = null;
        if (context != null) {
            this.heR = context.getText(R.string.adp_pull_to_refresh).toString();
            this.heS = context.getText(R.string.bigday_refreshing).toString();
            this.heT = context.getText(R.string.bigday_release_to_refresh).toString();
            this.heU = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dgV = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dgW = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dgX = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dgY = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.heM = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.heN = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.heO = (ImageView) inflate.findViewById(R.id.text_mask);
        this.heP = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.heM.setAutoChangeStyle(false);
        this.heP.setText(this.heR);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.azV()) {
            this.heQ = aVar;
        }
        if (aVar.cLT == 1) {
            this.heP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.heO.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.heN.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.heP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.heO.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.heN.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.heN.setFrame(0);
        this.heM.startLoad(aVar.imgUrl, 41, false);
        this.heM.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.heM.getBdImage() == null && b.this.heQ != null && !aq.isEmpty(b.this.heQ.imgUrl)) {
                    b.this.heM.startLoad(b.this.heQ.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bPf() {
        return this.heQ;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.heP.setText(this.heR);
        if (this.dgX != null) {
            this.dgX.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.heP.setText(this.heT);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.heP.setText(this.heS);
        this.heN.setAlpha(1.0f);
        this.heN.setMinAndMaxFrame(8, 58);
        this.heN.loop(true);
        this.heN.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dgV != null) {
            this.dgV.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.heP.setText("");
        this.heN.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.heN.setAlpha(1.0f);
        this.heP.setText(this.heR);
        if (this.dgY != null) {
            this.dgY.aHY();
        }
        if (this.dgW != null) {
            this.dgW.onListPullRefreshFinished(getView(), z);
        }
        this.heN.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPc() {
        this.heP.setText(this.heU);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.heP.animate().alpha(0.0f).setDuration(200L).start();
        this.heO.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bPe() {
        if (this.heQ != null && this.heQ.azV()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.heQ.imgUrl, this.heQ.cLS, this.heQ.cLU)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bPb() {
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
            this.heN.setProgress(f3);
            return;
        }
        this.heN.setAlpha(1.0f - ((f4 - dimension2) / (bPb() - dimension2)));
    }

    private void setAlpha(float f) {
        this.heP.setAlpha(f);
        this.heO.setAlpha(f);
        if (this.heO.getBackground() == null && this.heQ != null) {
            if (this.heQ.cLT == 1) {
                this.heO.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.heO.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
