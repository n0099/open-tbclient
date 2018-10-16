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
    private j.b aEo;
    private j.a aEp;
    private j.c aEq;
    private TbImageView eoj;
    private LottieAnimationView eok;
    private ImageView eol;
    private TextView eom;
    private com.baidu.tbadk.core.bigday.a eon;
    private String eoo;
    private String eop;
    private String eoq;
    private String eor;

    public b(Context context) {
        super(context);
        this.aEo = null;
        this.aEp = null;
        this.aEq = null;
        if (context != null) {
            this.eoo = context.getText(e.j.adp_pull_to_refresh).toString();
            this.eop = context.getText(e.j.bigday_refreshing).toString();
            this.eoq = context.getText(e.j.bigday_release_to_refresh).toString();
            this.eor = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.aEo = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.aEp = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.aEq = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oG() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.eoj = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.eok = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.eol = (ImageView) inflate.findViewById(e.g.text_mask);
        this.eom = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds25));
        }
        this.eoj.setAutoChangeStyle(false);
        this.eom.setText(this.eoo);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.wF()) {
            this.eon = aVar;
        }
        if (aVar.akg == 1) {
            this.eom.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.eol.setBackgroundResource(e.f.bigday_text_mask_black);
            this.eok.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.eom.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.eol.setBackgroundResource(e.f.bigday_text_mask_white);
            this.eok.setAnimation(e.i.lottie_refresh_dark);
        }
        this.eok.setFrame(0);
        this.eoj.startLoad(aVar.imgUrl, 41, false);
        this.eoj.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.eoj.getBdImage() == null && b.this.eon != null && !ao.isEmpty(b.this.eon.imgUrl)) {
                    b.this.eoj.startLoad(b.this.eon.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aKh() {
        return this.eon;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ah(boolean z) {
        setAlpha(1.0f);
        this.eom.setText(this.eoo);
        if (this.aEq != null) {
            this.aEq.bq(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.eom.setText(this.eoq);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.eom.setText(this.eop);
        this.eok.setAlpha(1.0f);
        this.eok.setMinAndMaxFrame(8, 58);
        this.eok.s(true);
        this.eok.cv();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aj(boolean z) {
        if (this.aEo != null) {
            this.aEo.bp(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oH() {
        this.eom.setText("");
        this.eok.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ai(boolean z) {
        setAlpha(1.0f);
        this.eok.setAlpha(1.0f);
        this.eom.setText(this.eoo);
        if (this.aEp != null) {
            this.aEp.b(getView(), z);
        }
        this.eok.cx();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aKe() {
        this.eom.setText(this.eor);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aKf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.eom.animate().alpha(0.0f).setDuration(200L).start();
        this.eol.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aKg() {
        if (this.eon != null && this.eon.wF()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.eon.imgUrl, this.eon.akf, this.eon.akh)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aKd() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void k(float f, float f2) {
        float f3 = 0.0f;
        super.k(f, f2);
        float dimension = getView().getResources().getDimension(e.C0175e.tbds120);
        float dimension2 = getView().getResources().getDimension(e.C0175e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.eok.setProgress(f3);
            return;
        }
        this.eok.setAlpha(1.0f - ((f4 - dimension2) / (aKd() - dimension2)));
    }

    private void setAlpha(float f) {
        this.eom.setAlpha(f);
        this.eol.setAlpha(f);
        if (this.eol.getBackground() == null && this.eon != null) {
            if (this.eon.akg == 1) {
                this.eol.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.eol.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
