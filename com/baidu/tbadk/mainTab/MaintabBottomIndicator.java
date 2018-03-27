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
    private int bxH;
    private HashMap<String, e.a> bxO;
    private int bxT;
    private int bxX;
    private View bxY;
    private View bxZ;
    private ImageView bya;
    private int byb;
    private int byc;
    private int byd;
    private int bye;
    private AnimationDrawable byf;
    private ImageView mIconView;
    private TextView ry;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.bxH = 0;
        this.bxO = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxH = 0;
        this.bxO = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxH = 0;
        this.bxO = new HashMap<>();
        init();
    }

    private void init() {
        this.bxY = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bxY.setLayoutParams(layoutParams);
        this.bxZ = this.bxY.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.bxY.findViewById(d.g.view_bottom_icon);
        this.ry = (TextView) this.bxY.findViewById(d.g.view_bottom_text);
        this.bya = (ImageView) this.bxY.findViewById(d.g.view_write_icon);
        addView(this.bxY);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.bxO.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.bxO.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.mIconView.getMeasuredWidth();
                    if (value.byh) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.bxH == 1) {
                        measuredHeight = this.bxY.getTop() + this.mIconView.getTop();
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
        this.bxH = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bxO.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void b(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bxO.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gX(String str) {
        return this.bxO.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.ry.setText(i);
    }

    public void setIconResourceId(int i) {
        this.byc = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.byb = i;
    }

    public void setShowIconType(int i) {
        this.bxX = i;
    }

    public void aK(int i, int i2) {
        this.bxZ.setVisibility(8);
        this.bya.setVisibility(0);
        aj.c(this.bya, i);
        aj.s(this.bya, i2);
        this.byd = i;
        this.bye = i2;
    }

    public void setAnimationResId(int i) {
        this.bxT = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gB(int i) {
        super.gB(i);
        Set<Map.Entry<String, e.a>> entrySet = this.bxO.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.gB(i);
                }
            }
        }
        if (this.bxX == c.bxU) {
            aj.c(this.bya, this.byd);
            aj.s(this.bya, this.bye);
            return;
        }
        if (this.byb != 0) {
            aj.r(this.ry, this.byb);
        } else {
            aj.r(this.ry, d.C0141d.cp_cont_f);
        }
        if (this.byc != 0) {
            aj.c(this.mIconView, this.byc);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void cr(boolean z) {
        super.cr(z);
        if (this.bxT != 0) {
            if (z) {
                aj.c(this.mIconView, this.bxT);
                this.byf = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.byf != null) {
                    this.byf.start();
                    return;
                }
                return;
            }
            if (this.byf != null) {
                this.byf.stop();
            }
            if (this.byc != 0) {
                aj.c(this.mIconView, this.byc);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.ry;
    }
}
