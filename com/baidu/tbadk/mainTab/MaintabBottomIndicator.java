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
    private int aGK;
    private HashMap<String, e.a> aGR;
    private int aGW;
    private int aHa;
    private View aHb;
    private View aHc;
    private ImageView aHd;
    private int aHe;
    private int aHf;
    private int aHg;
    private int aHh;
    private AnimationDrawable aHi;
    private TextView abE;
    private ImageView abO;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGK = 0;
        this.aGR = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGK = 0;
        this.aGR = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGK = 0;
        this.aGR = new HashMap<>();
        init();
    }

    private void init() {
        this.aHb = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHb.setLayoutParams(layoutParams);
        this.aHc = this.aHb.findViewById(d.g.container_common_item);
        this.abO = (ImageView) this.aHb.findViewById(d.g.view_bottom_icon);
        this.abE = (TextView) this.aHb.findViewById(d.g.view_bottom_text);
        this.aHd = (ImageView) this.aHb.findViewById(d.g.view_write_icon);
        addView(this.aHb);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGR.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aGR.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abO != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abO.getMeasuredWidth();
                    if (value.aHk) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGK == 1) {
                        measuredHeight = this.aHb.getTop() + this.abO.getTop();
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
        this.aGK = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGR.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gz(String str) {
        return this.aGR.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abE.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHf = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHe = i;
    }

    public void setShowIconType(int i) {
        this.aHa = i;
    }

    public void M(int i, int i2) {
        this.aHc.setVisibility(8);
        this.aHd.setVisibility(0);
        aj.c(this.aHd, i);
        aj.j(this.aHd, i2);
        this.aHg = i;
        this.aHh = i2;
    }

    public void setAnimationResId(int i) {
        this.aGW = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dE(int i) {
        super.dE(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGR.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dE(i);
                }
            }
        }
        if (this.aHa == c.aGX) {
            aj.c(this.aHd, this.aHg);
            aj.j(this.aHd, this.aHh);
            return;
        }
        if (this.aHe != 0) {
            aj.i(this.abE, this.aHe);
        } else {
            aj.i(this.abE, d.C0080d.cp_cont_f);
        }
        if (this.aHf != 0) {
            aj.c(this.abO, this.aHf);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bK(boolean z) {
        super.bK(z);
        if (this.aGW != 0) {
            if (z) {
                aj.c(this.abO, this.aGW);
                this.aHi = (AnimationDrawable) this.abO.getDrawable();
                if (this.aHi != null) {
                    this.aHi.start();
                    return;
                }
                return;
            }
            if (this.aHi != null) {
                this.aHi.stop();
            }
            if (this.aHf != 0) {
                aj.c(this.abO, this.aHf);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abE;
    }
}
