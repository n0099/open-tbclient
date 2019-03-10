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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes4.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private h.c bRF;
    private h.b bRG;
    private h.d bRH;
    private h.a bRI;
    private TbImageView fMX;
    private LottieAnimationView fMY;
    private ImageView fMZ;
    private TextView fNa;
    private com.baidu.tbadk.core.bigday.a fNb;
    private String fNc;
    private String fNd;
    private String fNe;
    private String fNf;

    public b(Context context) {
        super(context);
        this.bRF = null;
        this.bRG = null;
        this.bRH = null;
        this.bRI = null;
        if (context != null) {
            this.fNc = context.getText(d.j.adp_pull_to_refresh).toString();
            this.fNd = context.getText(d.j.bigday_refreshing).toString();
            this.fNe = context.getText(d.j.bigday_release_to_refresh).toString();
            this.fNf = context.getText(d.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.bRF = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.bRG = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.bRH = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.bRI = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.bigday_pull_view, (ViewGroup) null, false);
        this.fMX = (TbImageView) inflate.findViewById(d.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.bigday_close);
        this.fMY = (LottieAnimationView) inflate.findViewById(d.g.bigday_lotti);
        this.fMZ = (ImageView) inflate.findViewById(d.g.text_mask);
        this.fNa = (TextView) inflate.findViewById(d.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds25));
        }
        this.fMX.setAutoChangeStyle(false);
        this.fNa.setText(this.fNc);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.WL()) {
            this.fNb = aVar;
        }
        if (aVar.bvH == 1) {
            this.fNa.setTextColor(getContext().getResources().getColor(d.C0236d.cp_btn_a));
            this.fMZ.setBackgroundResource(d.f.bigday_text_mask_black);
            this.fMY.setAnimation(d.i.lottie_refresh_light);
        } else {
            this.fNa.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_b_alpha40));
            this.fMZ.setBackgroundResource(d.f.bigday_text_mask_white);
            this.fMY.setAnimation(d.i.lottie_refresh_dark);
        }
        this.fMY.setFrame(0);
        this.fMX.startLoad(aVar.imgUrl, 41, false);
        this.fMX.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.fMX.getBdImage() == null && b.this.fNb != null && !ap.isEmpty(b.this.fNb.imgUrl)) {
                    b.this.fMX.startLoad(b.this.fNb.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bmU() {
        return this.fNb;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.fNa.setText(this.fNc);
        if (this.bRH != null) {
            this.bRH.dS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.fNa.setText(this.fNe);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.fNa.setText(this.fNd);
        this.fMY.setAlpha(1.0f);
        this.fMY.setMinAndMaxFrame(8, 58);
        this.fMY.G(true);
        this.fMY.cu();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRF != null) {
            this.bRF.dR(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        this.fNa.setText("");
        this.fMY.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        setAlpha(1.0f);
        this.fMY.setAlpha(1.0f);
        this.fNa.setText(this.fNc);
        if (this.bRI != null) {
            this.bRI.aeT();
        }
        if (this.bRG != null) {
            this.bRG.f(getView(), z);
        }
        this.fMY.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmR() {
        this.fNa.setText(this.fNf);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.fNa.animate().alpha(0.0f).setDuration(200L).start();
        this.fMZ.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmT() {
        if (this.fNb != null && this.fNb.WL()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.fNb.imgUrl, this.fNb.bvG, this.fNb.bvI)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bmQ() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(d.e.tbds120);
        float dimension2 = getView().getResources().getDimension(d.e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.fMY.setProgress(f3);
            return;
        }
        this.fMY.setAlpha(1.0f - ((f4 - dimension2) / (bmQ() - dimension2)));
    }

    private void setAlpha(float f) {
        this.fNa.setAlpha(f);
        this.fMZ.setAlpha(f);
        if (this.fMZ.getBackground() == null && this.fNb != null) {
            if (this.fNb.bvH == 1) {
                this.fMZ.setBackgroundResource(d.f.bigday_text_mask_black);
            } else {
                this.fMZ.setBackgroundResource(d.f.bigday_text_mask_white);
            }
        }
    }
}
