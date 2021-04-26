package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.j1.o.k.b;
/* loaded from: classes4.dex */
public class BazhuHeadView extends HeadPendantView {
    public TbImageView q;

    public BazhuHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void d() {
        super.d();
        int g2 = l.g(getContext(), R.dimen.tbds92);
        int g3 = l.g(getContext(), R.dimen.tbds82);
        if (getPendantView() != null) {
            getPendantView().setLayoutParams(new RelativeLayout.LayoutParams(g2, g3));
        }
        TbImageView tbImageView = new TbImageView(getContext());
        this.q = tbImageView;
        tbImageView.setDefaultBgResource(0);
        this.q.setDefaultResource(0);
        this.q.setImageDrawable(null);
        int g4 = l.g(getContext(), R.dimen.tbds115);
        int g5 = l.g(getContext(), R.dimen.tbds34);
        int g6 = l.g(getContext(), R.dimen.tbds154);
        int g7 = l.g(getContext(), R.dimen.tbds32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g4, g5);
        layoutParams.topMargin = g6;
        layoutParams.leftMargin = g7;
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
    }

    public TbImageView getBawuLogoView() {
        return this.q;
    }

    public void n(boolean z) {
        if (z) {
            int g2 = l.g(getContext(), R.dimen.tbds5);
            int g3 = l.g(getContext(), R.dimen.tbds130);
            int g4 = l.g(getContext(), R.dimen.tbds26);
            int g5 = l.g(getContext(), R.dimen.tbds44);
            getHeadView().setBorderWidth(g2);
            getHeadView().setBorderColor(b.b("#FCD442"));
            getHeadView().setDrawBorder(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g3, g3);
            layoutParams.leftMargin = g4;
            layoutParams.topMargin = g5;
            getHeadView().setLayoutParams(layoutParams);
            return;
        }
        int g6 = l.g(getContext(), R.dimen.tbds90);
        getHeadView().setBorderWidth(0);
        getHeadView().setDrawBorder(false);
        getHeadView().setLayoutParams(new RelativeLayout.LayoutParams(g6, g6));
        TbImageView tbImageView = this.q;
        if (tbImageView != null) {
            tbImageView.setVisibility(8);
        }
        if (getPendantView() != null) {
            getPendantView().setVisibility(8);
        }
    }

    public void setBawuLogoView(int i2) {
        if (i2 == 0) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setImageResource(i2);
        this.q.setVisibility(0);
    }

    public void setPendantView(int i2) {
        if (getPendantView() != null) {
            if (i2 == 0) {
                getPendantView().setVisibility(8);
                return;
            }
            getPendantView().setVisibility(0);
            getPendantView().setImageResource(i2);
        }
    }

    public BazhuHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BazhuHeadView(Context context) {
        super(context);
    }
}
