package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BazhuHeadView extends HeadPendantView {
    private TbImageView etZ;

    public BazhuHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BazhuHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BazhuHeadView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void init() {
        super.init();
        int g = l.g(getContext(), R.dimen.tbds92);
        int g2 = l.g(getContext(), R.dimen.tbds82);
        if (getPendantView() != null) {
            getPendantView().setLayoutParams(new RelativeLayout.LayoutParams(g, g2));
        }
        this.etZ = new TbImageView(getContext());
        this.etZ.setDefaultBgResource(0);
        this.etZ.setDefaultResource(0);
        this.etZ.setDefaultErrorResource(0);
        this.etZ.setImageDrawable(null);
        int g3 = l.g(getContext(), R.dimen.tbds115);
        int g4 = l.g(getContext(), R.dimen.tbds34);
        int g5 = l.g(getContext(), R.dimen.tbds154);
        int g6 = l.g(getContext(), R.dimen.tbds32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g3, g4);
        layoutParams.topMargin = g5;
        layoutParams.leftMargin = g6;
        this.etZ.setLayoutParams(layoutParams);
        this.etZ.setVisibility(8);
        addView(this.etZ);
    }

    public void setBawuLogoView(int i) {
        if (i == 0) {
            this.etZ.setVisibility(8);
            return;
        }
        this.etZ.setImageResource(i);
        this.etZ.setVisibility(0);
    }

    public void in(boolean z) {
        if (z) {
            int g = l.g(getContext(), R.dimen.tbds5);
            int g2 = l.g(getContext(), R.dimen.tbds130);
            int g3 = l.g(getContext(), R.dimen.tbds26);
            int g4 = l.g(getContext(), R.dimen.tbds44);
            getHeadView().setBorderWidth(g);
            getHeadView().setBorderColor(com.baidu.tieba.lego.card.d.a.parseColor("#FCD442"));
            getHeadView().setDrawBorder(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.leftMargin = g3;
            layoutParams.topMargin = g4;
            getHeadView().setLayoutParams(layoutParams);
            return;
        }
        int g5 = l.g(getContext(), R.dimen.tbds90);
        getHeadView().setBorderWidth(0);
        getHeadView().setDrawBorder(false);
        getHeadView().setLayoutParams(new RelativeLayout.LayoutParams(g5, g5));
        if (this.etZ != null) {
            this.etZ.setVisibility(8);
        }
        if (getPendantView() != null) {
            getPendantView().setVisibility(8);
        }
    }

    public void setPendantView(int i) {
        if (getPendantView() != null) {
            if (i == 0) {
                getPendantView().setVisibility(8);
                return;
            }
            getPendantView().setVisibility(0);
            getPendantView().setImageResource(i);
        }
    }

    public TbImageView getBawuLogoView() {
        return this.etZ;
    }
}
