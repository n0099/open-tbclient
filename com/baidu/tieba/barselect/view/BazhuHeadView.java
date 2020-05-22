package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class BazhuHeadView extends HeadPendantView {
    private TbImageView gAI;

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
        int dimens = l.getDimens(getContext(), R.dimen.tbds92);
        int dimens2 = l.getDimens(getContext(), R.dimen.tbds82);
        if (getPendantView() != null) {
            getPendantView().setLayoutParams(new RelativeLayout.LayoutParams(dimens, dimens2));
        }
        this.gAI = new TbImageView(getContext());
        this.gAI.setDefaultBgResource(0);
        this.gAI.setDefaultResource(0);
        this.gAI.setDefaultErrorResource(0);
        this.gAI.setImageDrawable(null);
        int dimens3 = l.getDimens(getContext(), R.dimen.tbds115);
        int dimens4 = l.getDimens(getContext(), R.dimen.tbds34);
        int dimens5 = l.getDimens(getContext(), R.dimen.tbds154);
        int dimens6 = l.getDimens(getContext(), R.dimen.tbds32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens3, dimens4);
        layoutParams.topMargin = dimens5;
        layoutParams.leftMargin = dimens6;
        this.gAI.setLayoutParams(layoutParams);
        this.gAI.setVisibility(8);
        addView(this.gAI);
    }

    public void setBawuLogoView(int i) {
        if (i == 0) {
            this.gAI.setVisibility(8);
            return;
        }
        this.gAI.setImageResource(i);
        this.gAI.setVisibility(0);
    }

    public void lK(boolean z) {
        if (z) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds5);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds130);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds26);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds44);
            getHeadView().setBorderWidth(dimens);
            getHeadView().setBorderColor(com.baidu.tieba.lego.card.d.a.dT("#FCD442"));
            getHeadView().setDrawBorder(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens2, dimens2);
            layoutParams.leftMargin = dimens3;
            layoutParams.topMargin = dimens4;
            getHeadView().setLayoutParams(layoutParams);
            return;
        }
        int dimens5 = l.getDimens(getContext(), R.dimen.tbds90);
        getHeadView().setBorderWidth(0);
        getHeadView().setDrawBorder(false);
        getHeadView().setLayoutParams(new RelativeLayout.LayoutParams(dimens5, dimens5));
        if (this.gAI != null) {
            this.gAI.setVisibility(8);
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
        return this.gAI;
    }
}
