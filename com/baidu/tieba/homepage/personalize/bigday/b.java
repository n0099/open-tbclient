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
    private j.b aFe;
    private j.a aFf;
    private j.c aFg;
    private TbImageView epD;
    private LottieAnimationView epE;
    private ImageView epF;
    private TextView epG;
    private com.baidu.tbadk.core.bigday.a epH;
    private String epI;
    private String epJ;
    private String epK;
    private String epL;

    public b(Context context) {
        super(context);
        this.aFe = null;
        this.aFf = null;
        this.aFg = null;
        if (context != null) {
            this.epI = context.getText(e.j.adp_pull_to_refresh).toString();
            this.epJ = context.getText(e.j.bigday_refreshing).toString();
            this.epK = context.getText(e.j.bigday_release_to_refresh).toString();
            this.epL = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aFe = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aFf = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aFg = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oE() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.epD = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.epE = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.epF = (ImageView) inflate.findViewById(e.g.text_mask);
        this.epG = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.ds25));
        }
        this.epD.setAutoChangeStyle(false);
        this.epG.setText(this.epI);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.wN()) {
            this.epH = aVar;
        }
        if (aVar.akT == 1) {
            this.epG.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.epF.setBackgroundResource(e.f.bigday_text_mask_black);
            this.epE.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.epG.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.epF.setBackgroundResource(e.f.bigday_text_mask_white);
            this.epE.setAnimation(e.i.lottie_refresh_dark);
        }
        this.epE.setFrame(0);
        this.epD.startLoad(aVar.imgUrl, 41, false);
        this.epD.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.epD.getBdImage() == null && b.this.epH != null && !ao.isEmpty(b.this.epH.imgUrl)) {
                    b.this.epD.startLoad(b.this.epH.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aJF() {
        return this.epH;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        setAlpha(1.0f);
        this.epG.setText(this.epI);
        if (this.aFg != null) {
            this.aFg.bH(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.epG.setText(this.epK);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.epG.setText(this.epJ);
        this.epE.setAlpha(1.0f);
        this.epE.setMinAndMaxFrame(8, 58);
        this.epE.G(true);
        this.epE.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aFe != null) {
            this.aFe.bG(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oF() {
        this.epG.setText("");
        this.epE.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.epE.setAlpha(1.0f);
        this.epG.setText(this.epI);
        if (this.aFf != null) {
            this.aFf.b(getView(), z);
        }
        this.epE.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aJC() {
        this.epG.setText(this.epL);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aJD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.epG.animate().alpha(0.0f).setDuration(200L).start();
        this.epF.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aJE() {
        if (this.epH != null && this.epH.wN()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.epH.imgUrl, this.epH.akS, this.epH.akU)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aJB() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(e.C0200e.tbds120);
        float dimension2 = getView().getResources().getDimension(e.C0200e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.epE.setProgress(f3);
            return;
        }
        this.epE.setAlpha(1.0f - ((f4 - dimension2) / (aJB() - dimension2)));
    }

    private void setAlpha(float f) {
        this.epG.setAlpha(f);
        this.epF.setAlpha(f);
        if (this.epF.getBackground() == null && this.epH != null) {
            if (this.epH.akT == 1) {
                this.epF.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.epF.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
