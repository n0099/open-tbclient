package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
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
    private int bvB;
    private int bvF;
    private View bvG;
    private View bvH;
    private ImageView bvI;
    private int bvJ;
    private int bvK;
    private int bvL;
    private int bvM;
    private AnimationDrawable bvN;
    private int bvp;
    private HashMap<String, e.a> bvw;
    private ImageView mIconView;
    private TextView rz;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.bvp = 0;
        this.bvw = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvp = 0;
        this.bvw = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvp = 0;
        this.bvw = new HashMap<>();
        init();
    }

    private void init() {
        this.bvG = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bvG.setLayoutParams(layoutParams);
        this.bvH = this.bvG.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.bvG.findViewById(d.g.view_bottom_icon);
        this.rz = (TextView) this.bvG.findViewById(d.g.view_bottom_text);
        this.bvI = (ImageView) this.bvG.findViewById(d.g.view_write_icon);
        addView(this.bvG);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.bvw.entrySet();
        if (entrySet != null && (r5 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
                    if (layoutParams.width == -2) {
                        value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
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
        Set<Map.Entry<String, e.a>> entrySet = this.bvw.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.mIconView.getMeasuredWidth();
                    if (value.bvP) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.bvp == 1) {
                        measuredHeight = this.bvG.getTop() + this.mIconView.getTop();
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
        this.bvp = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bvw.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void b(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bvw.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gF(String str) {
        return this.bvw.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.rz.setText(i);
    }

    public void setIconResourceId(int i) {
        this.bvK = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bvJ = i;
    }

    public void setShowIconType(int i) {
        this.bvF = i;
    }

    public void aK(int i, int i2) {
        this.bvH.setVisibility(8);
        this.bvI.setVisibility(0);
        aj.c(this.bvI, i);
        aj.s(this.bvI, i2);
        this.bvL = i;
        this.bvM = i2;
    }

    public void setAnimationResId(int i) {
        this.bvB = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gC(int i) {
        super.gC(i);
        Set<Map.Entry<String, e.a>> entrySet = this.bvw.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.gC(i);
                }
            }
        }
        if (this.bvF == c.bvC) {
            aj.c(this.bvI, this.bvL);
            aj.s(this.bvI, this.bvM);
            return;
        }
        if (this.bvJ != 0) {
            aj.r(this.rz, this.bvJ);
        } else {
            aj.r(this.rz, d.C0108d.cp_cont_f);
        }
        if (this.bvK != 0) {
            aj.c(this.mIconView, this.bvK);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void co(boolean z) {
        super.co(z);
        if (this.bvB != 0) {
            if (z) {
                aj.c(this.mIconView, this.bvB);
                this.bvN = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.bvN != null) {
                    this.bvN.start();
                    return;
                }
                return;
            }
            if (this.bvN != null) {
                this.bvN.stop();
            }
            if (this.bvK != 0) {
                aj.c(this.mIconView, this.bvK);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.rz;
    }
}
