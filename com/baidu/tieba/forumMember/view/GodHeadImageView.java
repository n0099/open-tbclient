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
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a fti;
    private ImageView ftj;
    private int ftk;
    private int ftl;
    private int ftm;
    private int ftn;
    private int ftp;
    private int mRadius;
    private static final int aeQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fto = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.ftk = 0;
        this.ftl = this.ftk;
        this.ftm = 1;
        this.ftn = this.ftm;
        this.ftp = aeQ;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftk = 0;
        this.ftl = this.ftk;
        this.ftm = 1;
        this.ftn = this.ftm;
        this.ftp = aeQ;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftk = 0;
        this.ftl = this.ftk;
        this.ftm = 1;
        this.ftn = this.ftm;
        this.ftp = aeQ;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.ftp = obtainStyledAttributes.getDimensionPixelSize(0, aeQ);
            this.ftn = obtainStyledAttributes.getInteger(3, this.ftm);
            this.ftl = obtainStyledAttributes.getInteger(2, this.ftk);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.fti = new a(getContext());
        this.ftj = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fti.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fti, layoutParams);
        addView(this.ftj, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ftl = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ftn = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.fti.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.ftl) {
            case 0:
                this.fti.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.fti.setPadding(fto, fto, 0, 0);
                break;
        }
        switch (this.ftn) {
            case 1:
                this.fti.setIsRound(true);
                if (this.ftl == 0) {
                    am.setImageResource(this.ftj, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.ftj, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.fti.setIsRound(false);
                this.fti.setRadius(this.mRadius);
                am.setImageResource(this.ftj, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.fti.setIsRound(true);
                am.setImageResource(this.ftj, R.drawable.browser_null_drawable);
                return;
            default:
                this.fti.setIsRound(false);
                this.fti.setRadius(this.mRadius);
                am.setImageResource(this.ftj, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ftp != i) {
            this.ftp = i;
            this.fti.invalidate();
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
            if (GodHeadImageView.this.ftl == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ftp, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ftp, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
