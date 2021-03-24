package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class GodHeadImageView extends FrameLayout {
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    public static final int n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    public static int o = 7;

    /* renamed from: e  reason: collision with root package name */
    public a f15954e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15955f;

    /* renamed from: g  reason: collision with root package name */
    public int f15956g;

    /* renamed from: h  reason: collision with root package name */
    public int f15957h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes4.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.f15957h == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.k, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.k, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    public GodHeadImageView(Context context) {
        super(context);
        this.f15956g = 0;
        this.f15957h = 0;
        this.i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(null);
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GodHeadImageView);
            this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GodHeadImageView_extra_padding, m);
            this.j = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_shape_type, this.i);
            this.f15957h = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_show_type, this.f15956g);
            this.l = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_extra_radius, o);
            obtainStyledAttributes.recycle();
        }
        this.f15954e = new a(getContext());
        this.f15955f = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f15954e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f15954e, layoutParams);
        addView(this.f15955f, new FrameLayout.LayoutParams(-1, -1));
        d();
    }

    public final void d() {
        int i = this.f15957h;
        if (i == 0) {
            this.f15954e.setPadding(0, 0, 0, 0);
        } else if (i == 1) {
            a aVar = this.f15954e;
            int i2 = n;
            aVar.setPadding(i2, i2, 0, 0);
        }
        int i3 = this.j;
        if (i3 == 1) {
            this.f15954e.setIsRound(true);
            if (this.f15957h == 0) {
                SkinManager.setImageResource(this.f15955f, R.drawable.pic_shen_avatar_big);
            } else {
                SkinManager.setImageResource(this.f15955f, R.drawable.pic_shen_avatar);
            }
        } else if (i3 == 2) {
            this.f15954e.setIsRound(false);
            this.f15954e.setRadius(this.l);
            SkinManager.setImageResource(this.f15955f, R.drawable.pic_frs_shen_avatar);
        } else if (i3 != 3) {
            this.f15954e.setIsRound(false);
            this.f15954e.setRadius(this.l);
            SkinManager.setImageResource(this.f15955f, R.drawable.pic_shen_avatar_square);
        } else {
            this.f15954e.setIsRound(true);
            SkinManager.setImageResource(this.f15955f, R.drawable.browser_null_drawable);
        }
    }

    public void e(String str, int i, boolean z) {
        this.f15954e.W(str, i, z);
    }

    public void setExtraPadding(int i) {
        if (this.k != i) {
            this.k = i;
            this.f15954e.invalidate();
        }
    }

    public void setRadius(int i) {
        this.l = i;
        d();
    }

    public void setShapeType(int i) {
        this.j = i;
        d();
    }

    public void setShowType(int i) {
        this.f15957h = i;
        d();
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15956g = 0;
        this.f15957h = 0;
        this.i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15956g = 0;
        this.f15957h = 0;
        this.i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }
}
