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
/* loaded from: classes2.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private j.b azG;
    private j.a azH;
    private j.c azI;
    private TbImageView egp;
    private LottieAnimationView egq;
    private ImageView egr;
    private TextView egs;
    private com.baidu.tbadk.core.bigday.a egt;
    private String egu;
    private String egv;
    private String egw;
    private String egx;

    public b(Context context) {
        super(context);
        this.azG = null;
        this.azH = null;
        this.azI = null;
        if (context != null) {
            this.egu = context.getText(e.j.adp_pull_to_refresh).toString();
            this.egv = context.getText(e.j.bigday_refreshing).toString();
            this.egw = context.getText(e.j.bigday_release_to_refresh).toString();
            this.egx = context.getText(e.j.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.b bVar) {
        this.azG = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.a aVar) {
        this.azH = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(j.c cVar) {
        this.azI = cVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ov() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.bigday_pull_view, (ViewGroup) null, false);
        this.egp = (TbImageView) inflate.findViewById(e.g.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.bigday_close);
        this.egq = (LottieAnimationView) inflate.findViewById(e.g.bigday_lotti);
        this.egr = (ImageView) inflate.findViewById(e.g.text_mask);
        this.egs = (TextView) inflate.findViewById(e.g.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(e.C0141e.ds25));
        }
        this.egp.setAutoChangeStyle(false);
        this.egs.setText(this.egu);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.uw()) {
            this.egt = aVar;
        }
        if (aVar.afj == 1) {
            this.egs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_i_alpha60));
            this.egr.setBackgroundResource(e.f.bigday_text_mask_black);
            this.egq.setAnimation(e.i.lottie_refresh_light);
        } else {
            this.egs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b_alpha40));
            this.egr.setBackgroundResource(e.f.bigday_text_mask_white);
            this.egq.setAnimation(e.i.lottie_refresh_dark);
        }
        this.egq.setFrame(0);
        this.egp.startLoad(aVar.imgUrl, 41, false);
        this.egp.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.egp.getBdImage() == null && b.this.egt != null && !ao.isEmpty(b.this.egt.imgUrl)) {
                    b.this.egp.startLoad(b.this.egt.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a aGP() {
        return this.egt;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ai(boolean z) {
        setAlpha(1.0f);
        this.egs.setText(this.egu);
        if (this.azI != null) {
            this.azI.bg(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.egs.setText(this.egw);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.egs.setText(this.egv);
        this.egq.setAlpha(1.0f);
        this.egq.setMinAndMaxFrame(8, 58);
        this.egq.s(true);
        this.egq.ce();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ak(boolean z) {
        if (this.azG != null) {
            this.azG.bf(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ow() {
        this.egs.setText("");
        this.egq.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aj(boolean z) {
        setAlpha(1.0f);
        this.egq.setAlpha(1.0f);
        this.egs.setText(this.egu);
        if (this.azH != null) {
            this.azH.b(getView(), z);
        }
        this.egq.cf();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aGM() {
        this.egs.setText(this.egx);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aGN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.egs.animate().alpha(0.0f).setDuration(200L).start();
        this.egr.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void aGO() {
        if (this.egt != null && this.egt.uw()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.egt.imgUrl, this.egt.afi, this.egt.afk)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int aGL() {
        return (int) (l.aQ(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void k(float f, float f2) {
        float f3 = 0.0f;
        super.k(f, f2);
        float dimension = getView().getResources().getDimension(e.C0141e.tbds120);
        float dimension2 = getView().getResources().getDimension(e.C0141e.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.egq.setProgress(f3);
            return;
        }
        this.egq.setAlpha(1.0f - ((f4 - dimension2) / (aGL() - dimension2)));
    }

    private void setAlpha(float f) {
        this.egs.setAlpha(f);
        this.egr.setAlpha(f);
        if (this.egr.getBackground() == null && this.egt != null) {
            if (this.egt.afj == 1) {
                this.egr.setBackgroundResource(e.f.bigday_text_mask_black);
            } else {
                this.egr.setBackgroundResource(e.f.bigday_text_mask_white);
            }
        }
    }
}
