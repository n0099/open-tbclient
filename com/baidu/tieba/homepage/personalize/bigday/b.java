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
    private h.c bRG;
    private h.b bRH;
    private h.d bRI;
    private h.a bRJ;
    private TbImageView fMW;
    private LottieAnimationView fMX;
    private ImageView fMY;
    private TextView fMZ;
    private com.baidu.tbadk.core.bigday.a fNa;
    private String fNb;
    private String fNc;
    private String fNd;
    private String fNe;

    public b(Context context) {
        super(context);
        this.bRG = null;
        this.bRH = null;
        this.bRI = null;
        this.bRJ = null;
        if (context != null) {
            this.fNb = context.getText(d.j.adp_pull_to_refresh).toString();
            this.fNc = context.getText(d.j.bigday_refreshing).toString();
            this.fNd = context.getText(d.j.bigday_release_to_refresh).toString();
            this.fNe = context.getText(d.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.bRG = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.bRH = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.bRI = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.bRJ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.bigday_pull_view, (ViewGroup) null, false);
        this.fMW = (TbImageView) inflate.findViewById(d.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.bigday_close);
        this.fMX = (LottieAnimationView) inflate.findViewById(d.g.bigday_lotti);
        this.fMY = (ImageView) inflate.findViewById(d.g.text_mask);
        this.fMZ = (TextView) inflate.findViewById(d.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds25));
        }
        this.fMW.setAutoChangeStyle(false);
        this.fMZ.setText(this.fNb);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.WL()) {
            this.fNa = aVar;
        }
        if (aVar.bvJ == 1) {
            this.fMZ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_btn_a));
            this.fMY.setBackgroundResource(d.f.bigday_text_mask_black);
            this.fMX.setAnimation(d.i.lottie_refresh_light);
        } else {
            this.fMZ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_b_alpha40));
            this.fMY.setBackgroundResource(d.f.bigday_text_mask_white);
            this.fMX.setAnimation(d.i.lottie_refresh_dark);
        }
        this.fMX.setFrame(0);
        this.fMW.startLoad(aVar.imgUrl, 41, false);
        this.fMW.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.fMW.getBdImage() == null && b.this.fNa != null && !ap.isEmpty(b.this.fNa.imgUrl)) {
                    b.this.fMW.startLoad(b.this.fNa.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bmT() {
        return this.fNa;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.fMZ.setText(this.fNb);
        if (this.bRI != null) {
            this.bRI.dS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.fMZ.setText(this.fNd);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.fMZ.setText(this.fNc);
        this.fMX.setAlpha(1.0f);
        this.fMX.setMinAndMaxFrame(8, 58);
        this.fMX.G(true);
        this.fMX.cu();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRG != null) {
            this.bRG.dR(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        this.fMZ.setText("");
        this.fMX.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        setAlpha(1.0f);
        this.fMX.setAlpha(1.0f);
        this.fMZ.setText(this.fNb);
        if (this.bRJ != null) {
            this.bRJ.aeT();
        }
        if (this.bRH != null) {
            this.bRH.f(getView(), z);
        }
        this.fMX.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmQ() {
        this.fMZ.setText(this.fNe);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.fMZ.animate().alpha(0.0f).setDuration(200L).start();
        this.fMY.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmS() {
        if (this.fNa != null && this.fNa.WL()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.fNa.imgUrl, this.fNa.bvI, this.fNa.bvK)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bmP() {
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
            this.fMX.setProgress(f3);
            return;
        }
        this.fMX.setAlpha(1.0f - ((f4 - dimension2) / (bmP() - dimension2)));
    }

    private void setAlpha(float f) {
        this.fMZ.setAlpha(f);
        this.fMY.setAlpha(f);
        if (this.fMY.getBackground() == null && this.fNa != null) {
            if (this.fNa.bvJ == 1) {
                this.fMY.setBackgroundResource(d.f.bigday_text_mask_black);
            } else {
                this.fMY.setBackgroundResource(d.f.bigday_text_mask_white);
            }
        }
    }
}
