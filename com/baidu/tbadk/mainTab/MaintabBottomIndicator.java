package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends e {
    private int aGa;
    private HashMap<String, e.a> aGh;
    private int aGm;
    private int aGq;
    private View aGr;
    private View aGs;
    private ImageView aGt;
    private int aGu;
    private int aGv;
    private int aGw;
    private int aGx;
    private AnimationDrawable aGy;
    private TextView abi;
    private ImageView abo;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGa = 0;
        this.aGh = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGa = 0;
        this.aGh = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGa = 0;
        this.aGh = new HashMap<>();
        init();
    }

    private void init() {
        this.aGr = LayoutInflater.from(getContext()).inflate(d.j.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGr.setLayoutParams(layoutParams);
        this.aGs = this.aGr.findViewById(d.h.container_common_item);
        this.abo = (ImageView) this.aGr.findViewById(d.h.view_bottom_icon);
        this.abi = (TextView) this.aGr.findViewById(d.h.view_bottom_text);
        this.aGt = (ImageView) this.aGr.findViewById(d.h.view_write_icon);
        addView(this.aGr);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGh.entrySet();
        if (entrySet != null && (r5 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
                    if (layoutParams.width == -2) {
                        value.view.measure(View.MeasureSpec.makeMeasureSpec(size, ExploreByTouchHelper.INVALID_ID), View.MeasureSpec.makeMeasureSpec(size2, ExploreByTouchHelper.INVALID_ID));
                    } else {
                        value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
                    }
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, e.a>> it;
        int measuredWidth;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i, i2, i3, i4);
        Set<Map.Entry<String, e.a>> entrySet = this.aGh.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abo != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abo.getMeasuredWidth();
                    if (value.aGA) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGa == 1) {
                        measuredHeight = this.aGr.getTop() + this.abo.getTop();
                        measuredHeight2 = measuredHeight3 / 2;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.view.getMeasuredHeight() / 2;
                    }
                    int i5 = measuredHeight - measuredHeight2;
                    value.view.layout(measuredWidth, i5, measuredWidth2 + measuredWidth, measuredHeight3 + i5);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTipPosType(int i) {
        this.aGa = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGh.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gr(String str) {
        return this.aGh.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abi.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aGv = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGu = i;
    }

    public void setShowIconType(int i) {
        this.aGq = i;
    }

    public void M(int i, int i2) {
        this.aGs.setVisibility(8);
        this.aGt.setVisibility(0);
        aj.c(this.aGt, i);
        aj.j(this.aGt, i2);
        this.aGw = i;
        this.aGx = i2;
    }

    public void setAnimationResId(int i) {
        this.aGm = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dD(int i) {
        super.dD(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGh.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dD(i);
                }
            }
        }
        if (this.aGq == c.aGn) {
            aj.c(this.aGt, this.aGw);
            aj.j(this.aGt, this.aGx);
            return;
        }
        if (this.aGu != 0) {
            aj.i(this.abi, this.aGu);
        } else {
            aj.i(this.abi, d.e.cp_cont_f);
        }
        if (this.aGv != 0) {
            aj.c(this.abo, this.aGv);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bP(boolean z) {
        super.bP(z);
        if (this.aGm != 0) {
            if (z) {
                aj.c(this.abo, this.aGm);
                this.aGy = (AnimationDrawable) this.abo.getDrawable();
                if (this.aGy != null) {
                    this.aGy.start();
                    return;
                }
                return;
            }
            if (this.aGy != null) {
                this.aGy.stop();
            }
            if (this.aGv != 0) {
                aj.c(this.abo, this.aGv);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abi;
    }
}
