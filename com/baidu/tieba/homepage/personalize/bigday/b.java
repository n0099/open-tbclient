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
    private j.b aJi;
    private j.a aJj;
    private j.c aJk;
    private TbImageView eAb;
    private LottieAnimationView eAc;
    private ImageView eAd;
    private TextView eAe;
    private com.baidu.tbadk.core.bigday.a eAf;
    private String eAg;
    private String eAh;
    private String eAi;
    private String eAj;

    public b(Context context) {
        super(context);
        this.aJi = null;
        this.aJj = null;
        this.aJk = null;
        if (context != null) {
            this.eAg = context.getText(e.j.adp_pull_to_refresh).toString();
            this.eAh = context.getText(e.j.bigday_refreshing).toString();
            this.eAi = context.getText(e.j.bigday_release_to_refresh).toString();
            this.eAj = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aJi = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aJj = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aJk = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oH() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.eAb = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.eAc = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.eAd = (ImageView) inflate.findViewById(e.g.text_mask);
        this.eAe = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds25));
        }
        this.eAb.setAutoChangeStyle(false);
        this.eAe.setText(this.eAg);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.ye()) {
            this.eAf = aVar;
        }
        if (aVar.aoY == 1) {
            this.eAe.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.eAd.setBackgroundResource(e.f.bigday_text_mask_black);
            this.eAc.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.eAe.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.eAd.setBackgroundResource(e.f.bigday_text_mask_white);
            this.eAc.setAnimation(e.i.lottie_refresh_dark);
        }
        this.eAc.setFrame(0);
        this.eAb.startLoad(aVar.imgUrl, 41, false);
        this.eAb.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.eAb.getBdImage() == null && b.this.eAf != null && !ao.isEmpty(b.this.eAf.imgUrl)) {
                    b.this.eAb.startLoad(b.this.eAf.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aMK() {
        return this.eAf;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        setAlpha(1.0f);
        this.eAe.setText(this.eAg);
        if (this.aJk != null) {
            this.aJk.bJ(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.eAe.setText(this.eAi);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.eAe.setText(this.eAh);
        this.eAc.setAlpha(1.0f);
        this.eAc.setMinAndMaxFrame(8, 58);
        this.eAc.G(true);
        this.eAc.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aJi != null) {
            this.aJi.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oI() {
        this.eAe.setText("");
        this.eAc.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.eAc.setAlpha(1.0f);
        this.eAe.setText(this.eAg);
        if (this.aJj != null) {
            this.aJj.b(getView(), z);
        }
        this.eAc.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMH() {
        this.eAe.setText(this.eAj);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.eAe.animate().alpha(0.0f).setDuration(200L).start();
        this.eAd.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aMJ() {
        if (this.eAf != null && this.eAf.ye()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.eAf.imgUrl, this.eAf.aoX, this.eAf.aoZ)));
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
            this.eAc.setProgress(f3);
            return;
        }
        this.eAc.setAlpha(1.0f - ((f4 - dimension2) / (aMG() - dimension2)));
    }

    private void setAlpha(float f) {
        this.eAe.setAlpha(f);
        this.eAd.setAlpha(f);
        if (this.eAd.getBackground() == null && this.eAf != null) {
            if (this.eAf.aoY == 1) {
                this.eAd.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.eAd.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
