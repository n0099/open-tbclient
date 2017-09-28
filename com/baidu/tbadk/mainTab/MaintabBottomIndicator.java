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
    private int aGD;
    private View aGE;
    private View aGF;
    private ImageView aGG;
    private int aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private AnimationDrawable aGL;
    private int aGn;
    private HashMap<String, e.a> aGu;
    private int aGz;
    private ImageView abB;
    private TextView abv;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGn = 0;
        this.aGu = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGn = 0;
        this.aGu = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGn = 0;
        this.aGu = new HashMap<>();
        init();
    }

    private void init() {
        this.aGE = LayoutInflater.from(getContext()).inflate(d.j.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aGE.setLayoutParams(layoutParams);
        this.aGF = this.aGE.findViewById(d.h.container_common_item);
        this.abB = (ImageView) this.aGE.findViewById(d.h.view_bottom_icon);
        this.abv = (TextView) this.aGE.findViewById(d.h.view_bottom_text);
        this.aGG = (ImageView) this.aGE.findViewById(d.h.view_write_icon);
        addView(this.aGE);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGu.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aGu.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abB != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abB.getMeasuredWidth();
                    if (value.aGN) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGn == 1) {
                        measuredHeight = this.aGE.getTop() + this.abB.getTop();
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
        this.aGn = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGu.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gt(String str) {
        return this.aGu.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abv.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aGI = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aGH = i;
    }

    public void setShowIconType(int i) {
        this.aGD = i;
    }

    public void M(int i, int i2) {
        this.aGF.setVisibility(8);
        this.aGG.setVisibility(0);
        aj.c(this.aGG, i);
        aj.j(this.aGG, i2);
        this.aGJ = i;
        this.aGK = i2;
    }

    public void setAnimationResId(int i) {
        this.aGz = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        super.dE(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGu.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dE(i);
                }
            }
        }
        if (this.aGD == c.aGA) {
            aj.c(this.aGG, this.aGJ);
            aj.j(this.aGG, this.aGK);
            return;
        }
        if (this.aGH != 0) {
            aj.i(this.abv, this.aGH);
        } else {
            aj.i(this.abv, d.e.cp_cont_f);
        }
        if (this.aGI != 0) {
            aj.c(this.abB, this.aGI);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bQ(boolean z) {
        super.bQ(z);
        if (this.aGz != 0) {
            if (z) {
                aj.c(this.abB, this.aGz);
                this.aGL = (AnimationDrawable) this.abB.getDrawable();
                if (this.aGL != null) {
                    this.aGL.start();
                    return;
                }
                return;
            }
            if (this.aGL != null) {
                this.aGL.stop();
            }
            if (this.aGI != 0) {
                aj.c(this.abB, this.aGI);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abv;
    }
}
