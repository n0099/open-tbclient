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
    private HashMap<String, e.a> aHB;
    private int aHG;
    private int aHK;
    private View aHL;
    private View aHM;
    private ImageView aHN;
    private int aHO;
    private int aHP;
    private int aHQ;
    private int aHR;
    private AnimationDrawable aHS;
    private int aHu;
    private TextView abZ;
    private ImageView acj;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHu = 0;
        this.aHB = new HashMap<>();
        init();
    }

    private void init() {
        this.aHL = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHL.setLayoutParams(layoutParams);
        this.aHM = this.aHL.findViewById(d.g.container_common_item);
        this.acj = (ImageView) this.aHL.findViewById(d.g.view_bottom_icon);
        this.abZ = (TextView) this.aHL.findViewById(d.g.view_bottom_text);
        this.aHN = (ImageView) this.aHL.findViewById(d.g.view_write_icon);
        addView(this.aHL);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aHB.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aHB.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.acj != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.acj.getMeasuredWidth();
                    if (value.aHU) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aHu == 1) {
                        measuredHeight = this.aHL.getTop() + this.acj.getTop();
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
        this.aHu = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aHB.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gD(String str) {
        return this.aHB.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abZ.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHP = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHO = i;
    }

    public void setShowIconType(int i) {
        this.aHK = i;
    }

    public void K(int i, int i2) {
        this.aHM.setVisibility(8);
        this.aHN.setVisibility(0);
        aj.c(this.aHN, i);
        aj.j(this.aHN, i2);
        this.aHQ = i;
        this.aHR = i2;
    }

    public void setAnimationResId(int i) {
        this.aHG = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        super.dE(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aHB.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dE(i);
                }
            }
        }
        if (this.aHK == c.aHH) {
            aj.c(this.aHN, this.aHQ);
            aj.j(this.aHN, this.aHR);
            return;
        }
        if (this.aHO != 0) {
            aj.i(this.abZ, this.aHO);
        } else {
            aj.i(this.abZ, d.C0082d.cp_cont_f);
        }
        if (this.aHP != 0) {
            aj.c(this.acj, this.aHP);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bK(boolean z) {
        super.bK(z);
        if (this.aHG != 0) {
            if (z) {
                aj.c(this.acj, this.aHG);
                this.aHS = (AnimationDrawable) this.acj.getDrawable();
                if (this.aHS != null) {
                    this.aHS.start();
                    return;
                }
                return;
            }
            if (this.aHS != null) {
                this.aHS.stop();
            }
            if (this.aHP != 0) {
                aj.c(this.acj, this.aHP);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abZ;
    }
}
