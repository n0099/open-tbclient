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
    private int aGP;
    private HashMap<String, e.a> aGW;
    private int aHb;
    private int aHf;
    private View aHg;
    private View aHh;
    private ImageView aHi;
    private int aHj;
    private int aHk;
    private int aHl;
    private int aHm;
    private AnimationDrawable aHn;
    private ImageView abA;
    private TextView abu;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGP = 0;
        this.aGW = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGP = 0;
        this.aGW = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGP = 0;
        this.aGW = new HashMap<>();
        init();
    }

    private void init() {
        this.aHg = LayoutInflater.from(getContext()).inflate(d.j.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHg.setLayoutParams(layoutParams);
        this.aHh = this.aHg.findViewById(d.h.container_common_item);
        this.abA = (ImageView) this.aHg.findViewById(d.h.view_bottom_icon);
        this.abu = (TextView) this.aHg.findViewById(d.h.view_bottom_text);
        this.aHi = (ImageView) this.aHg.findViewById(d.h.view_write_icon);
        addView(this.aHg);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGW.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aGW.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abA != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abA.getMeasuredWidth();
                    if (value.aHp) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGP == 1) {
                        measuredHeight = this.aHg.getTop() + this.abA.getTop();
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
        this.aGP = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGW.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gw(String str) {
        return this.aGW.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abu.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHk = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHj = i;
    }

    public void setShowIconType(int i) {
        this.aHf = i;
    }

    public void L(int i, int i2) {
        this.aHh.setVisibility(8);
        this.aHi.setVisibility(0);
        aj.c(this.aHi, i);
        aj.j(this.aHi, i2);
        this.aHl = i;
        this.aHm = i2;
    }

    public void setAnimationResId(int i) {
        this.aHb = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void du(int i) {
        super.du(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGW.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.du(i);
                }
            }
        }
        if (this.aHf == c.aHc) {
            aj.c(this.aHi, this.aHl);
            aj.j(this.aHi, this.aHm);
            return;
        }
        if (this.aHj != 0) {
            aj.i(this.abu, this.aHj);
        } else {
            aj.i(this.abu, d.e.cp_cont_f);
        }
        if (this.aHk != 0) {
            aj.c(this.abA, this.aHk);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bR(boolean z) {
        super.bR(z);
        if (this.aHb != 0) {
            if (z) {
                aj.c(this.abA, this.aHb);
                this.aHn = (AnimationDrawable) this.abA.getDrawable();
                this.aHn.start();
                return;
            }
            if (this.aHn != null) {
                this.aHn.stop();
            }
            if (this.aHk != 0) {
                aj.c(this.abA, this.aHk);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abu;
    }
}
