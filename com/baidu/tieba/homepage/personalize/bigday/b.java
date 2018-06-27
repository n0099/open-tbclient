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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes2.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.b awQ;
    private g.a awR;
    private g.c awS;
    private TbImageView dVe;
    private LottieAnimationView dVf;
    private ImageView dVg;
    private TextView dVh;
    private com.baidu.tbadk.core.bigday.a dVi;
    private String dVj;
    private String dVk;
    private String dVl;
    private String dVm;

    public b(Context context) {
        super(context);
        this.awQ = null;
        this.awR = null;
        this.awS = null;
        if (context != null) {
            this.dVj = context.getText(d.k.adp_pull_to_refresh).toString();
            this.dVk = context.getText(d.k.bigday_refreshing).toString();
            this.dVl = context.getText(d.k.bigday_release_to_refresh).toString();
            this.dVm = context.getText(d.k.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.awQ = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.awR = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.c cVar) {
        this.awS = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nn() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.bigday_pull_view, (ViewGroup) null, false);
        this.dVe = (TbImageView) inflate.findViewById(d.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.bigday_close);
        this.dVf = (LottieAnimationView) inflate.findViewById(d.g.bigday_lotti);
        this.dVg = (ImageView) inflate.findViewById(d.g.text_mask);
        this.dVh = (TextView) inflate.findViewById(d.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds25));
        }
        this.dVe.setAutoChangeStyle(false);
        this.dVh.setText(this.dVj);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.tI()) {
            this.dVi = aVar;
        }
        if (aVar.ade == 1) {
            this.dVh.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_i_alpha60));
            this.dVg.setBackgroundResource(d.f.bigday_text_mask_black);
            this.dVf.setAnimation(d.j.lottie_refresh_light);
        } else {
            this.dVh.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_b_alpha40));
            this.dVg.setBackgroundResource(d.f.bigday_text_mask_white);
            this.dVf.setAnimation(d.j.lottie_refresh_dark);
        }
        this.dVf.setFrame(0);
        this.dVe.startLoad(aVar.imgUrl, 41, false);
        this.dVe.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.dVe.getBdImage() == null && b.this.dVi != null && !ap.isEmpty(b.this.dVi.imgUrl)) {
                    b.this.dVe.startLoad(b.this.dVi.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aDD() {
        return this.dVi;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        setAlpha(1.0f);
        this.dVh.setText(this.dVj);
        if (this.awS != null) {
            this.awS.aV(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void no() {
        this.dVh.setText(this.dVl);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void np() {
        setAlpha(1.0f);
        this.dVh.setText(this.dVk);
        this.dVf.setAlpha(1.0f);
        this.dVf.setMinAndMaxFrame(8, 58);
        this.dVf.k(true);
        this.dVf.ba();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ab(boolean z) {
        if (this.awQ != null) {
            this.awQ.aU(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        this.dVh.setText("");
        this.dVf.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        setAlpha(1.0f);
        this.dVf.setAlpha(1.0f);
        this.dVh.setText(this.dVj);
        if (this.awR != null) {
            this.awR.c(getView(), z);
        }
        this.dVf.bb();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aDA() {
        this.dVh.setText(this.dVm);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aDB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.dVh.animate().alpha(0.0f).setDuration(200L).start();
        this.dVg.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aDC() {
        if (this.dVi != null && this.dVi.tI()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.dVi.imgUrl, this.dVi.adc, this.dVi.adf)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aDz() {
        return (int) (l.aj(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void k(float f, float f2) {
        float f3 = 0.0f;
        super.k(f, f2);
        float dimension = getView().getResources().getDimension(d.e.tbds120);
        float dimension2 = getView().getResources().getDimension(d.e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.dVf.setProgress(f3);
            return;
        }
        this.dVf.setAlpha(1.0f - ((f4 - dimension2) / (aDz() - dimension2)));
    }

    private void setAlpha(float f) {
        this.dVh.setAlpha(f);
        this.dVg.setAlpha(f);
        if (this.dVg.getBackground() == null && this.dVi != null) {
            if (this.dVi.ade == 1) {
                this.dVg.setBackgroundResource(d.f.bigday_text_mask_black);
            } else {
                this.dVg.setBackgroundResource(d.f.bigday_text_mask_white);
            }
        }
    }
}
