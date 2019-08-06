package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a fsi;
    private ImageView fsj;
    private int fsk;
    private int fsl;
    private int fsm;
    private int fsn;
    private int fsp;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fso = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.fsk = 0;
        this.fsl = this.fsk;
        this.fsm = 1;
        this.fsn = this.fsm;
        this.fsp = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsk = 0;
        this.fsl = this.fsk;
        this.fsm = 1;
        this.fsn = this.fsm;
        this.fsp = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fsk = 0;
        this.fsl = this.fsk;
        this.fsm = 1;
        this.fsn = this.fsm;
        this.fsp = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.GodHeadImageView);
            this.fsp = obtainStyledAttributes.getDimensionPixelSize(0, DS6);
            this.fsn = obtainStyledAttributes.getInteger(3, this.fsm);
            this.fsl = obtainStyledAttributes.getInteger(2, this.fsk);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.fsi = new a(getContext());
        this.fsj = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fsi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fsi, layoutParams);
        addView(this.fsj, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.fsl = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.fsn = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.fsi.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.fsl) {
            case 0:
                this.fsi.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.fsi.setPadding(fso, fso, 0, 0);
                break;
        }
        switch (this.fsn) {
            case 1:
                this.fsi.setIsRound(true);
                if (this.fsl == 0) {
                    am.c(this.fsj, (int) R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.fsj, (int) R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.fsi.setIsRound(false);
                this.fsi.setRadius(this.mRadius);
                am.c(this.fsj, (int) R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.fsi.setIsRound(true);
                am.c(this.fsj, (int) R.drawable.browser_null_drawable);
                return;
            default:
                this.fsi.setIsRound(false);
                this.fsi.setRadius(this.mRadius);
                am.c(this.fsj, (int) R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.fsp != i) {
            this.fsp = i;
            this.fsi.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.fsl == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.fsp, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.fsp, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
