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
    private g.c dHd;
    private g.b dHe;
    private g.d dHf;
    private g.a dHg;
    private TbImageView hPQ;
    private LottieAnimationView hPR;
    private ImageView hPS;
    private TextView hPT;
    private com.baidu.tbadk.core.bigday.a hPU;
    private String hPV;
    private String hPW;
    private String hPX;
    private String hPY;

    public b(Context context) {
        super(context);
        this.dHd = null;
        this.dHe = null;
        this.dHf = null;
        this.dHg = null;
        if (context != null) {
            this.hPV = context.getText(R.string.adp_pull_to_refresh).toString();
            this.hPW = context.getText(R.string.bigday_refreshing).toString();
            this.hPX = context.getText(R.string.bigday_release_to_refresh).toString();
            this.hPY = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dHd = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dHe = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dHf = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dHg = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.hPQ = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.hPR = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.hPS = (ImageView) inflate.findViewById(R.id.text_mask);
        this.hPT = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.hPQ.setAutoChangeStyle(false);
        this.hPT.setText(this.hPV);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aIl()) {
            this.hPU = aVar;
        }
        if (aVar.dlk == 1) {
            this.hPT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.hPS.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.hPR.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.hPT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.hPS.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.hPR.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.hPR.setFrame(0);
        this.hPQ.startLoad(aVar.imgUrl, 41, false);
        this.hPQ.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.hPQ.getBdImage() == null && b.this.hPU != null && !aq.isEmpty(b.this.hPU.imgUrl)) {
                    b.this.hPQ.startLoad(b.this.hPU.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bZU() {
        return this.hPU;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.hPT.setText(this.hPV);
        if (this.dHf != null) {
            this.dHf.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.hPT.setText(this.hPX);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.hPT.setText(this.hPW);
        this.hPR.setAlpha(1.0f);
        this.hPR.setMinAndMaxFrame(8, 58);
        this.hPR.loop(true);
        this.hPR.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dHd != null) {
            this.dHd.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.hPT.setText("");
        this.hPR.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.hPR.setAlpha(1.0f);
        this.hPT.setText(this.hPV);
        if (this.dHg != null) {
            this.dHg.aQy();
        }
        if (this.dHe != null) {
            this.dHe.onListPullRefreshFinished(getView(), z);
        }
        this.hPR.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZR() {
        this.hPT.setText(this.hPY);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.hPT.animate().alpha(0.0f).setDuration(200L).start();
        this.hPS.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZT() {
        if (this.hPU != null && this.hPU.aIl()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.hPU.imgUrl, this.hPU.aqV, this.hPU.dll)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bZQ() {
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
            this.hPR.setProgress(f3);
            return;
        }
        this.hPR.setAlpha(1.0f - ((f4 - dimension2) / (bZQ() - dimension2)));
    }

    private void setAlpha(float f) {
        this.hPT.setAlpha(f);
        this.hPS.setAlpha(f);
        if (this.hPS.getBackground() == null && this.hPU != null) {
            if (this.hPU.dlk == 1) {
                this.hPS.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.hPS.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
