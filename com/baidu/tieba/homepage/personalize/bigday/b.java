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
    private h.c cpS;
    private h.b cpT;
    private h.d cpU;
    private h.a cpV;
    private TbImageView gmn;
    private LottieAnimationView gmo;
    private ImageView gmp;
    private TextView gmq;
    private com.baidu.tbadk.core.bigday.a gmr;
    private String gms;
    private String gmt;
    private String gmu;
    private String gmv;

    public b(Context context) {
        super(context);
        this.cpS = null;
        this.cpT = null;
        this.cpU = null;
        this.cpV = null;
        if (context != null) {
            this.gms = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gmt = context.getText(R.string.bigday_refreshing).toString();
            this.gmu = context.getText(R.string.bigday_release_to_refresh).toString();
            this.gmv = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.cpS = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.cpT = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.cpU = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.cpV = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gmn = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gmo = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gmp = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gmq = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gmn.setAutoChangeStyle(false);
        this.gmq.setText(this.gms);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.agx()) {
            this.gmr = aVar;
        }
        if (aVar.bWd == 1) {
            this.gmq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.gmp.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gmo.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gmq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gmp.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gmo.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gmo.setFrame(0);
        this.gmn.startLoad(aVar.imgUrl, 41, false);
        this.gmn.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gmn.getBdImage() == null && b.this.gmr != null && !aq.isEmpty(b.this.gmr.imgUrl)) {
                    b.this.gmn.startLoad(b.this.gmr.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bvg() {
        return this.gmr;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        setAlpha(1.0f);
        this.gmq.setText(this.gms);
        if (this.cpU != null) {
            this.cpU.onListPullToRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gmq.setText(this.gmu);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gmq.setText(this.gmt);
        this.gmo.setAlpha(1.0f);
        this.gmo.setMinAndMaxFrame(8, 58);
        this.gmo.loop(true);
        this.gmo.playAnimation();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onRefresh(boolean z) {
        if (this.cpS != null) {
            this.cpS.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onCompletePullRefresh() {
        this.gmq.setText("");
        this.gmo.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        setAlpha(1.0f);
        this.gmo.setAlpha(1.0f);
        this.gmq.setText(this.gms);
        if (this.cpV != null) {
            this.cpV.anW();
        }
        if (this.cpT != null) {
            this.cpT.onListPullRefreshFinished(getView(), z);
        }
        this.gmo.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bvd() {
        this.gmq.setText(this.gmv);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bve() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gmq.animate().alpha(0.0f).setDuration(200L).start();
        this.gmp.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bvf() {
        if (this.gmr != null && this.gmr.agx()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigdayActivityConfig(getContext(), this.gmr.imgUrl, this.gmr.bWc, this.gmr.bWe)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bvc() {
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
            this.gmo.setProgress(f3);
            return;
        }
        this.gmo.setAlpha(1.0f - ((f4 - dimension2) / (bvc() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gmq.setAlpha(f);
        this.gmp.setAlpha(f);
        if (this.gmp.getBackground() == null && this.gmr != null) {
            if (this.gmr.bWd == 1) {
                this.gmp.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gmp.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
