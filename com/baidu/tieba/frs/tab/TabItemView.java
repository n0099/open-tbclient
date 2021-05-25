package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.e1;
import d.a.n0.r0.f1;
import d.a.n0.r0.k2.d;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class TabItemView extends TextView {

    /* renamed from: i  reason: collision with root package name */
    public static int f15716i = 0;
    public static int j = 1;
    public static int k = 2;

    /* renamed from: e  reason: collision with root package name */
    public d f15717e;

    /* renamed from: f  reason: collision with root package name */
    public int f15718f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15719g;

    /* renamed from: h  reason: collision with root package name */
    public int f15720h;

    public TabItemView(Context context, d dVar, int i2, boolean z) {
        super(context);
        this.f15718f = f15716i;
        this.f15720h = 0;
        this.f15717e = dVar;
        this.f15719g = z;
        b(context, i2);
    }

    private int getSpaceWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || (drawable = compoundDrawables[2]) == null) {
            return -1;
        }
        float measureText = getPaint().measureText(getText().toString());
        return getWidth() - ((((int) measureText) + drawable.getIntrinsicWidth()) + getCompoundDrawablePadding());
    }

    public void a() {
        setState(this.f15718f);
    }

    public final void b(Context context, int i2) {
        if (this.f15719g) {
            setPadding(0, l.g(getContext(), R.dimen.tbds20), 0, 0);
            setTextSize(0, l.g(context, R.dimen.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        d dVar = this.f15717e;
        if (dVar != null) {
            setText(dVar.f58809a);
        }
        a();
    }

    public int getDrawableWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || compoundDrawables.length < 3 || (drawable = compoundDrawables[2]) == null) {
            return 0;
        }
        return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
    }

    public int getState() {
        return this.f15718f;
    }

    public int getTabId() {
        d dVar = this.f15717e;
        if (dVar == null) {
            return -1;
        }
        return dVar.f58810b;
    }

    public String getUrl() {
        d dVar = this.f15717e;
        if (dVar == null) {
            return null;
        }
        return dVar.f58812d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            canvas.translate(spaceWidth / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.f15719g) {
                setPadding(0, l.g(getContext(), R.dimen.ds16), spaceWidth, 0);
            } else {
                setPadding(0, 0, spaceWidth, 0);
            }
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void setForNewFrame(boolean z) {
        this.f15719g = z;
    }

    public void setSelectItemColorResId(int i2) {
        this.f15720h = i2;
    }

    public void setState(int i2) {
        f1 f1Var;
        List<e1> list;
        d dVar = this.f15717e;
        if (dVar != null && (f1Var = dVar.f58811c) != null && (list = f1Var.f58556b) != null && list.size() > 0) {
            int i3 = -l.g(getContext(), R.dimen.tbds20);
            if (!this.f15719g) {
                i3 = 0;
            }
            if (i2 == k) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_toolbar_arrow_up);
                drawable.setBounds(0, i3, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i3);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_arrow_gray_down);
                drawable2.setBounds(0, i3, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i3);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        if (this.f15719g) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
        } else {
            if (i2 != j && i2 != k) {
                SkinManager.setViewTextColor(this, R.color.CAM_X0106, 1);
            } else {
                int i4 = this.f15720h;
                if (i4 == 0) {
                    SkinManager.setViewTextColor(this, R.color.CAM_X0302, 1);
                } else {
                    SkinManager.setViewTextColor(this, i4, 1);
                }
            }
            setGravity(17);
        }
        this.f15718f = i2;
        invalidate();
    }
}
