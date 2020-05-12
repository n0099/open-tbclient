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
    private g.c dHh;
    private g.b dHi;
    private g.d dHj;
    private g.a dHk;
    private TbImageView hPW;
    private LottieAnimationView hPX;
    private ImageView hPY;
    private TextView hPZ;
    private com.baidu.tbadk.core.bigday.a hQa;
    private String hQb;
    private String hQc;
    private String hQd;
    private String hQe;

    public b(Context context) {
        super(context);
        this.dHh = null;
        this.dHi = null;
        this.dHj = null;
        this.dHk = null;
        if (context != null) {
            this.hQb = context.getText(R.string.adp_pull_to_refresh).toString();
            this.hQc = context.getText(R.string.bigday_refreshing).toString();
            this.hQd = context.getText(R.string.bigday_release_to_refresh).toString();
            this.hQe = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(g.c cVar) {
        this.dHh = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.dHi = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.d dVar) {
        this.dHj = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.dHk = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.hPW = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.hPX = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.hPY = (ImageView) inflate.findViewById(R.id.text_mask);
        this.hPZ = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.hPW.setAutoChangeStyle(false);
        this.hPZ.setText(this.hQb);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.aIj()) {
            this.hQa = aVar;
        }
        if (aVar.dlo == 1) {
            this.hPZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.hPY.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.hPX.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.hPZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.hPY.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.hPX.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.hPX.setFrame(0);
        this.hPW.startLoad(aVar.imgUrl, 41, false);
        this.hPW.setOnDrawListener(new TbImageView.c() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.hPW.getBdImage() == null && b.this.hQa != null && !aq.isEmpty(b.this.hQa.imgUrl)) {
                    b.this.hPW.startLoad(b.this.hQa.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bZT() {
        return this.hQa;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.hPZ.setText(this.hQb);
        if (this.dHj != null) {
            this.dHj.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.hPZ.setText(this.hQd);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.hPZ.setText(this.hQc);
        this.hPX.setAlpha(1.0f);
        this.hPX.setMinAndMaxFrame(8, 58);
        this.hPX.loop(true);
        this.hPX.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.dHh != null) {
            this.dHh.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.hPZ.setText("");
        this.hPX.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.hPX.setAlpha(1.0f);
        this.hPZ.setText(this.hQb);
        if (this.dHk != null) {
            this.dHk.aQv();
        }
        if (this.dHi != null) {
            this.dHi.onListPullRefreshFinished(getView(), z);
        }
        this.hPX.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZQ() {
        this.hPZ.setText(this.hQe);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.hPZ.animate().alpha(0.0f).setDuration(200L).start();
        this.hPY.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bZS() {
        if (this.hQa != null && this.hQa.aIj()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.hQa.imgUrl, this.hQa.arb, this.hQa.dlp)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bZP() {
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
            this.hPX.setProgress(f3);
            return;
        }
        this.hPX.setAlpha(1.0f - ((f4 - dimension2) / (bZP() - dimension2)));
    }

    private void setAlpha(float f) {
        this.hPZ.setAlpha(f);
        this.hPY.setAlpha(f);
        if (this.hPY.getBackground() == null && this.hQa != null) {
            if (this.hQa.dlo == 1) {
                this.hPY.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.hPY.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
