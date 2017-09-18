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
    private int aGM;
    private HashMap<String, e.a> aGT;
    private int aGY;
    private int aHc;
    private View aHd;
    private View aHe;
    private ImageView aHf;
    private int aHg;
    private int aHh;
    private int aHi;
    private int aHj;
    private AnimationDrawable aHk;
    private ImageView abA;
    private TextView abu;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGM = 0;
        this.aGT = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGM = 0;
        this.aGT = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGM = 0;
        this.aGT = new HashMap<>();
        init();
    }

    private void init() {
        this.aHd = LayoutInflater.from(getContext()).inflate(d.j.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHd.setLayoutParams(layoutParams);
        this.aHe = this.aHd.findViewById(d.h.container_common_item);
        this.abA = (ImageView) this.aHd.findViewById(d.h.view_bottom_icon);
        this.abu = (TextView) this.aHd.findViewById(d.h.view_bottom_text);
        this.aHf = (ImageView) this.aHd.findViewById(d.h.view_write_icon);
        addView(this.aHd);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGT.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aGT.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abA != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abA.getMeasuredWidth();
                    if (value.aHm) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGM == 1) {
                        measuredHeight = this.aHd.getTop() + this.abA.getTop();
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
        this.aGM = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGT.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gw(String str) {
        return this.aGT.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abu.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHh = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHg = i;
    }

    public void setShowIconType(int i) {
        this.aHc = i;
    }

    public void L(int i, int i2) {
        this.aHe.setVisibility(8);
        this.aHf.setVisibility(0);
        aj.c(this.aHf, i);
        aj.j(this.aHf, i2);
        this.aHi = i;
        this.aHj = i2;
    }

    public void setAnimationResId(int i) {
        this.aGY = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void du(int i) {
        super.du(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGT.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.du(i);
                }
            }
        }
        if (this.aHc == c.aGZ) {
            aj.c(this.aHf, this.aHi);
            aj.j(this.aHf, this.aHj);
            return;
        }
        if (this.aHg != 0) {
            aj.i(this.abu, this.aHg);
        } else {
            aj.i(this.abu, d.e.cp_cont_f);
        }
        if (this.aHh != 0) {
            aj.c(this.abA, this.aHh);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bR(boolean z) {
        super.bR(z);
        if (this.aGY != 0) {
            if (z) {
                aj.c(this.abA, this.aGY);
                this.aHk = (AnimationDrawable) this.abA.getDrawable();
                this.aHk.start();
                return;
            }
            if (this.aHk != null) {
                this.aHk.stop();
            }
            if (this.aHh != 0) {
                aj.c(this.abA, this.aHh);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abu;
    }
}
