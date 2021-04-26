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
    public a f15788e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15789f;

    /* renamed from: g  reason: collision with root package name */
    public int f15790g;

    /* renamed from: h  reason: collision with root package name */
    public int f15791h;

    /* renamed from: i  reason: collision with root package name */
    public int f15792i;
    public int j;
    public int k;
    public int l;

    /* loaded from: classes4.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i2, int i3) {
            if (GodHeadImageView.this.f15791h == 1) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                i2 = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.k, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.k, 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    public GodHeadImageView(Context context) {
        super(context);
        this.f15790g = 0;
        this.f15791h = 0;
        this.f15792i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(null);
    }

    public final void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GodHeadImageView);
            this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.GodHeadImageView_extra_padding, m);
            this.j = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_shape_type, this.f15792i);
            this.f15791h = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_show_type, this.f15790g);
            this.l = obtainStyledAttributes.getInteger(R$styleable.GodHeadImageView_extra_radius, o);
            obtainStyledAttributes.recycle();
        }
        this.f15788e = new a(getContext());
        this.f15789f = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f15788e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f15788e, layoutParams);
        addView(this.f15789f, new FrameLayout.LayoutParams(-1, -1));
        d();
    }

    public final void d() {
        int i2 = this.f15791h;
        if (i2 == 0) {
            this.f15788e.setPadding(0, 0, 0, 0);
        } else if (i2 == 1) {
            a aVar = this.f15788e;
            int i3 = n;
            aVar.setPadding(i3, i3, 0, 0);
        }
        int i4 = this.j;
        if (i4 == 1) {
            this.f15788e.setIsRound(true);
            if (this.f15791h == 0) {
                SkinManager.setImageResource(this.f15789f, R.drawable.pic_shen_avatar_big);
            } else {
                SkinManager.setImageResource(this.f15789f, R.drawable.pic_shen_avatar);
            }
        } else if (i4 == 2) {
            this.f15788e.setIsRound(false);
            this.f15788e.setRadius(this.l);
            SkinManager.setImageResource(this.f15789f, R.drawable.pic_frs_shen_avatar);
        } else if (i4 != 3) {
            this.f15788e.setIsRound(false);
            this.f15788e.setRadius(this.l);
            SkinManager.setImageResource(this.f15789f, R.drawable.pic_shen_avatar_square);
        } else {
            this.f15788e.setIsRound(true);
            SkinManager.setImageResource(this.f15789f, R.drawable.browser_null_drawable);
        }
    }

    public void e(String str, int i2, boolean z) {
        this.f15788e.V(str, i2, z);
    }

    public void setExtraPadding(int i2) {
        if (this.k != i2) {
            this.k = i2;
            this.f15788e.invalidate();
        }
    }

    public void setRadius(int i2) {
        this.l = i2;
        d();
    }

    public void setShapeType(int i2) {
        this.j = i2;
        d();
    }

    public void setShowType(int i2) {
        this.f15791h = i2;
        d();
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15790g = 0;
        this.f15791h = 0;
        this.f15792i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15790g = 0;
        this.f15791h = 0;
        this.f15792i = 1;
        this.j = 1;
        this.k = m;
        this.l = 7;
        c(attributeSet);
    }
}
