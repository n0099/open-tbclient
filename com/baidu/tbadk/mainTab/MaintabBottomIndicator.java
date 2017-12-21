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
    private int aHB;
    private HashMap<String, e.a> aHI;
    private int aHN;
    private int aHR;
    private View aHS;
    private View aHT;
    private ImageView aHU;
    private int aHV;
    private int aHW;
    private int aHX;
    private int aHY;
    private AnimationDrawable aHZ;
    private TextView abW;
    private ImageView acg;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aHB = 0;
        this.aHI = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHB = 0;
        this.aHI = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHB = 0;
        this.aHI = new HashMap<>();
        init();
    }

    private void init() {
        this.aHS = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHS.setLayoutParams(layoutParams);
        this.aHT = this.aHS.findViewById(d.g.container_common_item);
        this.acg = (ImageView) this.aHS.findViewById(d.g.view_bottom_icon);
        this.abW = (TextView) this.aHS.findViewById(d.g.view_bottom_text);
        this.aHU = (ImageView) this.aHS.findViewById(d.g.view_write_icon);
        addView(this.aHS);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aHI.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aHI.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.acg != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.acg.getMeasuredWidth();
                    if (value.aIb) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aHB == 1) {
                        measuredHeight = this.aHS.getTop() + this.acg.getTop();
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
        this.aHB = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aHI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gC(String str) {
        return this.aHI.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abW.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHW = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHV = i;
    }

    public void setShowIconType(int i) {
        this.aHR = i;
    }

    public void L(int i, int i2) {
        this.aHT.setVisibility(8);
        this.aHU.setVisibility(0);
        aj.c(this.aHU, i);
        aj.j(this.aHU, i2);
        this.aHX = i;
        this.aHY = i2;
    }

    public void setAnimationResId(int i) {
        this.aHN = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        super.dE(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aHI.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dE(i);
                }
            }
        }
        if (this.aHR == c.aHO) {
            aj.c(this.aHU, this.aHX);
            aj.j(this.aHU, this.aHY);
            return;
        }
        if (this.aHV != 0) {
            aj.i(this.abW, this.aHV);
        } else {
            aj.i(this.abW, d.C0095d.cp_cont_f);
        }
        if (this.aHW != 0) {
            aj.c(this.acg, this.aHW);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bL(boolean z) {
        super.bL(z);
        if (this.aHN != 0) {
            if (z) {
                aj.c(this.acg, this.aHN);
                this.aHZ = (AnimationDrawable) this.acg.getDrawable();
                if (this.aHZ != null) {
                    this.aHZ.start();
                    return;
                }
                return;
            }
            if (this.aHZ != null) {
                this.aHZ.stop();
            }
            if (this.aHW != 0) {
                aj.c(this.acg, this.aHW);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abW;
    }
}
