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
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes2.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private g.b awt;
    private g.a awu;
    private g.c awv;
    private TbImageView dYT;
    private LottieAnimationView dYU;
    private ImageView dYV;
    private TextView dYW;
    private com.baidu.tbadk.core.bigday.a dYX;
    private String dYY;
    private String dYZ;
    private String dZa;
    private String dZb;

    public b(Context context) {
        super(context);
        this.awt = null;
        this.awu = null;
        this.awv = null;
        if (context != null) {
            this.dYY = context.getText(f.j.adp_pull_to_refresh).toString();
            this.dYZ = context.getText(f.j.bigday_refreshing).toString();
            this.dZa = context.getText(f.j.bigday_release_to_refresh).toString();
            this.dZb = context.getText(f.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.b bVar) {
        this.awt = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.a aVar) {
        this.awu = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(g.c cVar) {
        this.awv = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.h.bigday_pull_view, (ViewGroup) null, false);
        this.dYT = (TbImageView) inflate.findViewById(f.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(f.g.bigday_close);
        this.dYU = (LottieAnimationView) inflate.findViewById(f.g.bigday_lotti);
        this.dYV = (ImageView) inflate.findViewById(f.g.text_mask);
        this.dYW = (TextView) inflate.findViewById(f.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(f.e.ds25));
        }
        this.dYT.setAutoChangeStyle(false);
        this.dYW.setText(this.dYY);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.tt()) {
            this.dYX = aVar;
        }
        if (aVar.acI == 1) {
            this.dYW.setTextColor(getContext().getResources().getColor(f.d.cp_cont_i_alpha60));
            this.dYV.setBackgroundResource(f.C0146f.bigday_text_mask_black);
            this.dYU.setAnimation(f.i.lottie_refresh_light);
        } else {
            this.dYW.setTextColor(getContext().getResources().getColor(f.d.cp_cont_b_alpha40));
            this.dYV.setBackgroundResource(f.C0146f.bigday_text_mask_white);
            this.dYU.setAnimation(f.i.lottie_refresh_dark);
        }
        this.dYU.setFrame(0);
        this.dYT.startLoad(aVar.imgUrl, 41, false);
        this.dYT.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.dYT.getBdImage() == null && b.this.dYX != null && !ap.isEmpty(b.this.dYX.imgUrl)) {
                    b.this.dYT.startLoad(b.this.dYX.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aEA() {
        return this.dYX;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        setAlpha(1.0f);
        this.dYW.setText(this.dYY);
        if (this.awv != null) {
            this.awv.aU(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.dYW.setText(this.dZa);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.dYW.setText(this.dYZ);
        this.dYU.setAlpha(1.0f);
        this.dYU.setMinAndMaxFrame(8, 58);
        this.dYU.i(true);
        this.dYU.aX();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        if (this.awt != null) {
            this.awt.aT(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        this.dYW.setText("");
        this.dYU.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        setAlpha(1.0f);
        this.dYU.setAlpha(1.0f);
        this.dYW.setText(this.dYY);
        if (this.awu != null) {
            this.awu.b(getView(), z);
        }
        this.dYU.aY();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEx() {
        this.dYW.setText(this.dZb);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.dYW.animate().alpha(0.0f).setDuration(200L).start();
        this.dYV.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aEz() {
        if (this.dYX != null && this.dYX.tt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.dYX.imgUrl, this.dYX.acH, this.dYX.acJ)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aEw() {
        return (int) (l.aj(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void k(float f, float f2) {
        float f3 = 0.0f;
        super.k(f, f2);
        float dimension = getView().getResources().getDimension(f.e.tbds120);
        float dimension2 = getView().getResources().getDimension(f.e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.dYU.setProgress(f3);
            return;
        }
        this.dYU.setAlpha(1.0f - ((f4 - dimension2) / (aEw() - dimension2)));
    }

    private void setAlpha(float f) {
        this.dYW.setAlpha(f);
        this.dYV.setAlpha(f);
        if (this.dYV.getBackground() == null && this.dYX != null) {
            if (this.dYX.acI == 1) {
                this.dYV.setBackgroundResource(f.C0146f.bigday_text_mask_black);
            } else {
                this.dYV.setBackgroundResource(f.C0146f.bigday_text_mask_white);
            }
        }
    }
}
