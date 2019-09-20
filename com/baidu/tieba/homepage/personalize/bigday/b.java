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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
/* loaded from: classes4.dex */
public class b extends c implements PersonalizePageView.a, BigdaySwipeRefreshLayout.a {
    private h.c cbC;
    private h.b cbD;
    private h.d cbE;
    private h.a cbF;
    private TbImageView gmP;
    private LottieAnimationView gmQ;
    private ImageView gmR;
    private TextView gmS;
    private com.baidu.tbadk.core.bigday.a gmT;
    private String gmU;
    private String gmV;
    private String gmW;
    private String gmX;

    public b(Context context) {
        super(context);
        this.cbC = null;
        this.cbD = null;
        this.cbE = null;
        this.cbF = null;
        if (context != null) {
            this.gmU = context.getText(R.string.adp_pull_to_refresh).toString();
            this.gmV = context.getText(R.string.bigday_refreshing).toString();
            this.gmW = context.getText(R.string.bigday_release_to_refresh).toString();
            this.gmX = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void setListPullRefreshListener(h.c cVar) {
        this.cbC = cVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.b bVar) {
        this.cbD = bVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.d dVar) {
        this.cbE = dVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.a
    public void a(h.a aVar) {
        this.cbF = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nZ() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.gmP = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.gmQ = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.gmR = (ImageView) inflate.findViewById(R.id.text_mask);
        this.gmS = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.gmP.setAutoChangeStyle(false);
        this.gmS.setText(this.gmU);
        return inflate;
    }

    public void a(com.baidu.tbadk.core.bigday.a aVar) {
        if (aVar.acr()) {
            this.gmT = aVar;
        }
        if (aVar.bEm == 1) {
            this.gmS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_a));
            this.gmR.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.gmQ.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.gmS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.gmR.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.gmQ.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.gmQ.setFrame(0);
        this.gmP.startLoad(aVar.imgUrl, 41, false);
        this.gmP.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.homepage.personalize.bigday.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                if (b.this.gmP.getBdImage() == null && b.this.gmT != null && !aq.isEmpty(b.this.gmT.imgUrl)) {
                    b.this.gmP.startLoad(b.this.gmT.imgUrl, 41, false);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        });
    }

    public com.baidu.tbadk.core.bigday.a byc() {
        return this.gmT;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        setAlpha(1.0f);
        this.gmS.setText(this.gmU);
        if (this.cbE != null) {
            this.cbE.ev(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        this.gmS.setText(this.gmW);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        setAlpha(1.0f);
        this.gmS.setText(this.gmV);
        this.gmQ.setAlpha(1.0f);
        this.gmQ.setMinAndMaxFrame(8, 58);
        this.gmQ.y(true);
        this.gmQ.br();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void at(boolean z) {
        if (this.cbC != null) {
            this.cbC.eu(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oa() {
        this.gmS.setText("");
        this.gmQ.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        setAlpha(1.0f);
        this.gmQ.setAlpha(1.0f);
        this.gmS.setText(this.gmU);
        if (this.cbF != null) {
            this.cbF.ali();
        }
        if (this.cbD != null) {
            this.cbD.f(getView(), z);
        }
        this.gmQ.cancelAnimation();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bxZ() {
        this.gmS.setText(this.gmX);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void bya() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, false));
        this.gmS.animate().alpha(0.0f).setDuration(200L).start();
        this.gmR.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public void byb() {
        if (this.gmT != null && this.gmT.acr()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(getContext(), this.gmT.imgUrl, this.gmT.bEl, this.gmT.bEn)));
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.a
    public int bxY() {
        return (int) (l.ah(getContext()) * 0.3d);
    }

    public void release() {
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
        float f3 = 0.0f;
        super.n(f, f2);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = dimension2 * f;
        if (f4 < dimension2) {
            float f5 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f5 >= 0.0f) {
                f3 = f5 > 0.09090909f ? 0.09090909f : f5;
            }
            this.gmQ.setProgress(f3);
            return;
        }
        this.gmQ.setAlpha(1.0f - ((f4 - dimension2) / (bxY() - dimension2)));
    }

    private void setAlpha(float f) {
        this.gmS.setAlpha(f);
        this.gmR.setAlpha(f);
        if (this.gmR.getBackground() == null && this.gmT != null) {
            if (this.gmT.bEm == 1) {
                this.gmR.setBackgroundResource(R.drawable.bigday_text_mask_black);
            } else {
                this.gmR.setBackgroundResource(R.drawable.bigday_text_mask_white);
            }
        }
    }
}
