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
    private g.b aww;
    private g.a awx;
    private g.c awy;
    private TbImageView dYW;
    private LottieAnimationView dYX;
    private ImageView dYY;
    private TextView dYZ;
    private com.baidu.tbadk.core.bigday.a dZa;
    private String dZb;
    private String dZc;
    private String dZd;
    private String dZe;

    public b(Context context) {
        super(context);
        this.aww = null;
        this.awx = null;
        this.awy = null;
        if (context != null) {
            this.dZb = context.getText(d.j.adp_pull_to_refresh).toString();
            this.dZc = context.getText(d.j.bigday_refreshing).toString();
            this.dZd = context.getText(d.j.bigday_release_to_refresh).toString();
            this.dZe = context.getText(d.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.aww = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.awx = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.c cVar) {
        this.awy = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.bigday_pull_view, (ViewGroup) null, false);
        this.dYW = (TbImageView) inflate.findViewById(d.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.bigday_close);
        this.dYX = (LottieAnimationView) inflate.findViewById(d.g.bigday_lotti);
        this.dYY = (ImageView) inflate.findViewById(d.g.text_mask);
        this.dYZ = (TextView) inflate.findViewById(d.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds25));
        }
        this.dYW.setAutoChangeStyle(false);
        this.dYZ.setText(this.dZb);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.tu()) {
            this.dZa = aVar;
        }
        if (aVar.acH == 1) {
            this.dYZ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_i_alpha60));
            this.dYY.setBackgroundResource(d.f.bigday_text_mask_black);
            this.dYX.setAnimation(d.i.lottie_refresh_light);
        } else {
            this.dYZ.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_b_alpha40));
            this.dYY.setBackgroundResource(d.f.bigday_text_mask_white);
            this.dYX.setAnimation(d.i.lottie_refresh_dark);
        }
        this.dYX.setFrame(0);
        this.dYW.startLoad(aVar.imgUrl, 41, false);
        this.dYW.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.dYW.getBdImage() == null && b.this.dZa != null && !ap.isEmpty(b.this.dZa.imgUrl)) {
                    b.this.dYW.startLoad(b.this.dZa.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aED() {
        return this.dZa;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        setAlpha(1.0f);
        this.dYZ.setText(this.dZb);
        if (this.awy != null) {
            this.awy.aT(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        this.dYZ.setText(this.dZd);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nr() {
        setAlpha(1.0f);
        this.dYZ.setText(this.dZc);
        this.dYX.setAlpha(1.0f);
        this.dYX.setMinAndMaxFrame(8, 58);
        this.dYX.i(true);
        this.dYX.aX();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        if (this.aww != null) {
            this.aww.aS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ns() {
        this.dYZ.setText("");
        this.dYX.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        setAlpha(1.0f);
        this.dYX.setAlpha(1.0f);
        this.dYZ.setText(this.dZb);
        if (this.awx != null) {
            this.awx.b(getView(), z);
        }
        this.dYX.aY();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEA() {
        this.dYZ.setText(this.dZe);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.dYZ.animate().alpha(0.0f).setDuration(200L).start();
        this.dYY.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEC() {
        if (this.dZa != null && this.dZa.tu()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.dZa.imgUrl, this.dZa.acG, this.dZa.acI)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aEz() {
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
            this.dYX.setProgress(f3);
            return;
        }
        this.dYX.setAlpha(1.0f - ((f4 - dimension2) / (aEz() - dimension2)));
    }

    private void setAlpha(float f) {
        this.dYZ.setAlpha(f);
        this.dYY.setAlpha(f);
        if (this.dYY.getBackground() == null && this.dZa != null) {
            if (this.dZa.acH == 1) {
                this.dYY.setBackgroundResource(d.f.bigday_text_mask_black);
            } else {
                this.dYY.setBackgroundResource(d.f.bigday_text_mask_white);
            }
        }
    }
}
