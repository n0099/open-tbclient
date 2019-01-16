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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes6.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private j.b aJh;
    private j.a aJi;
    private j.c aJj;
    private TbImageView eAa;
    private LottieAnimationView eAb;
    private ImageView eAc;
    private TextView eAd;
    private com.baidu.tbadk.core.bigday.a eAe;
    private String eAf;
    private String eAg;
    private String eAh;
    private String eAi;

    public b(Context context) {
        super(context);
        this.aJh = null;
        this.aJi = null;
        this.aJj = null;
        if (context != null) {
            this.eAf = context.getText(e.j.adp_pull_to_refresh).toString();
            this.eAg = context.getText(e.j.bigday_refreshing).toString();
            this.eAh = context.getText(e.j.bigday_release_to_refresh).toString();
            this.eAi = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aJh = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aJi = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aJj = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oH() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.eAa = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.eAb = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.eAc = (ImageView) inflate.findViewById(e.g.text_mask);
        this.eAd = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds25));
        }
        this.eAa.setAutoChangeStyle(false);
        this.eAd.setText(this.eAf);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.ye()) {
            this.eAe = aVar;
        }
        if (aVar.aoX == 1) {
            this.eAd.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.eAc.setBackgroundResource(e.f.bigday_text_mask_black);
            this.eAb.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.eAd.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.eAc.setBackgroundResource(e.f.bigday_text_mask_white);
            this.eAb.setAnimation(e.i.lottie_refresh_dark);
        }
        this.eAb.setFrame(0);
        this.eAa.startLoad(aVar.imgUrl, 41, false);
        this.eAa.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.eAa.getBdImage() == null && b.this.eAe != null && !ao.isEmpty(b.this.eAe.imgUrl)) {
                    b.this.eAa.startLoad(b.this.eAe.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aMK() {
        return this.eAe;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        setAlpha(1.0f);
        this.eAd.setText(this.eAf);
        if (this.aJj != null) {
            this.aJj.bJ(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.eAd.setText(this.eAh);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.eAd.setText(this.eAg);
        this.eAb.setAlpha(1.0f);
        this.eAb.setMinAndMaxFrame(8, 58);
        this.eAb.G(true);
        this.eAb.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aJh != null) {
            this.aJh.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oI() {
        this.eAd.setText("");
        this.eAb.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.eAb.setAlpha(1.0f);
        this.eAd.setText(this.eAf);
        if (this.aJi != null) {
            this.aJi.b(getView(), z);
        }
        this.eAb.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMH() {
        this.eAd.setText(this.eAi);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.eAd.animate().alpha(0.0f).setDuration(200L).start();
        this.eAc.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMJ() {
        if (this.eAe != null && this.eAe.ye()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.eAe.imgUrl, this.eAe.aoW, this.eAe.aoY)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aMG() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(e.C0210e.tbds120);
        float dimension2 = getView().getResources().getDimension(e.C0210e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.eAb.setProgress(f3);
            return;
        }
        this.eAb.setAlpha(1.0f - ((f4 - dimension2) / (aMG() - dimension2)));
    }

    private void setAlpha(float f) {
        this.eAd.setAlpha(f);
        this.eAc.setAlpha(f);
        if (this.eAc.getBackground() == null && this.eAe != null) {
            if (this.eAe.aoX == 1) {
                this.eAc.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.eAc.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
