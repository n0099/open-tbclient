package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int coa = 0;
    public static int cob = 1;
    public static int coc = 2;
    private j cod;
    private boolean coe;
    private int mState;

    public TabItemView(Context context, j jVar, int i, boolean z) {
        super(context);
        this.mState = coa;
        this.cod = jVar;
        this.coe = z;
        n(context, i);
    }

    private void n(Context context, int i) {
        if (this.coe) {
            setPadding(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16), 0, 0);
            setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cod != null) {
            setText(this.cod.name);
        }
        wK();
    }

    public void setState(int i) {
        if (this.cod != null && this.cod.cnZ != null && this.cod.cnZ.ceU != null && this.cod.cnZ.ceU.size() > 0) {
            int i2 = -com.baidu.adp.lib.util.k.g(getContext(), w.f.ds10);
            if (!this.coe) {
                i2 = 0;
            }
            if (i == coc) {
                Drawable drawable = as.getDrawable(w.g.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = as.getDrawable(w.g.icon_public_down_arrow_gray_n);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(w.f.ds8));
        }
        if (this.coe) {
            as.c(this, w.e.cp_cont_b, 1);
        } else {
            if (i == cob || i == coc) {
                as.c(this, w.e.cp_link_tip_a, 1);
            } else {
                as.c(this, w.e.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cod == null) {
            return -1;
        }
        return this.cod.cnY;
    }

    public int getState() {
        return this.mState;
    }

    public void wK() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.coe) {
                setPadding(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16), spaceWidth, 0);
            } else {
                setPadding(0, 0, spaceWidth, 0);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            canvas.translate(spaceWidth / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    private int getSpaceWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || (drawable = compoundDrawables[2]) == null) {
            return -1;
        }
        float measureText = getPaint().measureText(getText().toString());
        return getWidth() - ((drawable.getIntrinsicWidth() + ((int) measureText)) + getCompoundDrawablePadding());
    }

    public String getUrl() {
        if (this.cod == null) {
            return null;
        }
        return this.cod.url;
    }

    public int getDrawableWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || compoundDrawables.length < 3 || (drawable = compoundDrawables[2]) == null) {
            return 0;
        }
        return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
    }

    public void setForNewFrame(boolean z) {
        this.coe = z;
    }
}
