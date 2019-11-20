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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes4.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private h.c cpa;
    private h.b cpb;
    private h.d cpc;
    private h.a cpd;
    private com.baidu.tbadk.core.bigday.a glA;
    private String glB;
    private String glC;
    private String glD;
    private String glE;
    private TbImageView glw;
    private LottieAnimationView glx;
    private ImageView gly;
    private TextView glz;

    public b(Context context) {
        super(context);
        this.cpa = null;
        this.cpb = null;
        this.cpc = null;
        this.cpd = null;
        if (context != null) {
            this.glB = context.getText(R.string.adp_pull_to_refresh).toString();
            this.glC = context.getText(R.string.bigday_refreshing).toString();
            this.glD = context.getText(R.string.bigday_release_to_refresh).toString();
            this.glE = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.cpa = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.cpb = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.cpc = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.cpd = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.glw = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.glx = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gly = (ImageView) inflate.findViewById(R.id.text_mask);
        this.glz = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.glw.setAutoChangeStyle(false);
        this.glz.setText(this.glB);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.agv()) {
            this.glA = aVar;
        }
        if (aVar.bVm == 1) {
            this.glz.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.gly.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.glx.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.glz.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gly.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.glx.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.glx.setFrame(0);
        this.glw.startLoad(aVar.imgUrl, 41, false);
        this.glw.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.glw.getBdImage() == null && b.this.glA != null && !aq.isEmpty(b.this.glA.imgUrl)) {
                    b.this.glw.startLoad(b.this.glA.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bve() {
        return this.glA;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.glz.setText(this.glB);
        if (this.cpc != null) {
            this.cpc.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.glz.setText(this.glD);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.glz.setText(this.glC);
        this.glx.setAlpha(1.0f);
        this.glx.setMinAndMaxFrame(8, 58);
        this.glx.loop(true);
        this.glx.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.cpa != null) {
            this.cpa.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.glz.setText("");
        this.glx.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.glx.setAlpha(1.0f);
        this.glz.setText(this.glB);
        if (this.cpd != null) {
            this.cpd.anU();
        }
        if (this.cpb != null) {
            this.cpb.onListPullRefreshFinished(getView(), z);
        }
        this.glx.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bvb() {
        this.glz.setText(this.glE);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bvc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.glz.animate().alpha(0.0f).setDuration(200L).start();
        this.gly.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bvd() {
        if (this.glA != null && this.glA.agv()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.glA.imgUrl, this.glA.bVl, this.glA.bVn)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bva() {
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
            this.glx.setProgress(f3);
            return;
        }
        this.glx.setAlpha(1.0f - ((f4 - dimension2) / (bva() - dimension2)));
    }

    private void setAlpha(float f) {
        this.glz.setAlpha(f);
        this.gly.setAlpha(f);
        if (this.gly.getBackground() == null && this.glA != null) {
            if (this.glA.bVm == 1) {
                this.gly.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gly.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
