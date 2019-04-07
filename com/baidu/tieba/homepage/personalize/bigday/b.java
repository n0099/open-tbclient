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
    private h.c bRI;
    private h.b bRJ;
    private h.d bRK;
    private h.a bRL;
    private TbImageView fMK;
    private LottieAnimationView fML;
    private ImageView fMM;
    private TextView fMN;
    private com.baidu.tbadk.core.bigday.a fMO;
    private String fMP;
    private String fMQ;
    private String fMR;
    private String fMS;

    public b(Context context) {
        super(context);
        this.bRI = null;
        this.bRJ = null;
        this.bRK = null;
        this.bRL = null;
        if (context != null) {
            this.fMP = context.getText(d.j.adp_pull_to_refresh).toString();
            this.fMQ = context.getText(d.j.bigday_refreshing).toString();
            this.fMR = context.getText(d.j.bigday_release_to_refresh).toString();
            this.fMS = context.getText(d.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.bRI = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.bRJ = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.bRK = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.bRL = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oM() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.bigday_pull_view, (ViewGroup) null, false);
        this.fMK = (TbImageView) inflate.findViewById(d.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.bigday_close);
        this.fML = (LottieAnimationView) inflate.findViewById(d.g.bigday_lotti);
        this.fMM = (ImageView) inflate.findViewById(d.g.text_mask);
        this.fMN = (TextView) inflate.findViewById(d.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds25));
        }
        this.fMK.setAutoChangeStyle(false);
        this.fMN.setText(this.fMP);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.WI()) {
            this.fMO = aVar;
        }
        if (aVar.bvM == 1) {
            this.fMN.setTextColor(getContext().getResources().getColor(d.C0277d.cp_btn_a));
            this.fMM.setBackgroundResource(d.f.bigday_text_mask_black);
            this.fML.setAnimation(d.i.lottie_refresh_light);
        } else {
            this.fMN.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_b_alpha40));
            this.fMM.setBackgroundResource(d.f.bigday_text_mask_white);
            this.fML.setAnimation(d.i.lottie_refresh_dark);
        }
        this.fML.setFrame(0);
        this.fMK.startLoad(aVar.imgUrl, 41, false);
        this.fMK.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.fMK.getBdImage() == null && b.this.fMO != null && !ap.isEmpty(b.this.fMO.imgUrl)) {
                    b.this.fMK.startLoad(b.this.fMO.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a bmQ() {
        return this.fMO;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        setAlpha(1.0f);
        this.fMN.setText(this.fMP);
        if (this.bRK != null) {
            this.bRK.dS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.fMN.setText(this.fMR);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.fMN.setText(this.fMQ);
        this.fML.setAlpha(1.0f);
        this.fML.setMinAndMaxFrame(8, 58);
        this.fML.G(true);
        this.fML.cu();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ay(boolean z) {
        if (this.bRI != null) {
            this.bRI.dR(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oN() {
        this.fMN.setText("");
        this.fML.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        setAlpha(1.0f);
        this.fML.setAlpha(1.0f);
        this.fMN.setText(this.fMP);
        if (this.bRL != null) {
            this.bRL.aeQ();
        }
        if (this.bRJ != null) {
            this.bRJ.f(getView(), z);
        }
        this.fML.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmN() {
        this.fMN.setText(this.fMS);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.fMN.animate().alpha(0.0f).setDuration(200L).start();
        this.fMM.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bmP() {
        if (this.fMO != null && this.fMO.WI()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.fMO.imgUrl, this.fMO.bvL, this.fMO.bvN)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bmM() {
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
            this.fML.setProgress(f3);
            return;
        }
        this.fML.setAlpha(1.0f - ((f4 - dimension2) / (bmM() - dimension2)));
    }

    private void setAlpha(float f) {
        this.fMN.setAlpha(f);
        this.fMM.setAlpha(f);
        if (this.fMM.getBackground() == null && this.fMO != null) {
            if (this.fMO.bvM == 1) {
                this.fMM.setBackgroundResource(d.f.bigday_text_mask_black);
            } else {
                this.fMM.setBackgroundResource(d.f.bigday_text_mask_white);
            }
        }
    }
}
