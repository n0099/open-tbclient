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
    private int aGS;
    private HashMap<String, e.a> aGZ;
    private int aHe;
    private int aHi;
    private View aHj;
    private View aHk;
    private ImageView aHl;
    private int aHm;
    private int aHn;
    private int aHo;
    private int aHp;
    private AnimationDrawable aHq;
    private TextView abE;
    private ImageView abO;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aGS = 0;
        this.aGZ = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGS = 0;
        this.aGZ = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGS = 0;
        this.aGZ = new HashMap<>();
        init();
    }

    private void init() {
        this.aHj = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aHj.setLayoutParams(layoutParams);
        this.aHk = this.aHj.findViewById(d.g.container_common_item);
        this.abO = (ImageView) this.aHj.findViewById(d.g.view_bottom_icon);
        this.abE = (TextView) this.aHj.findViewById(d.g.view_bottom_text);
        this.aHl = (ImageView) this.aHj.findViewById(d.g.view_write_icon);
        addView(this.aHj);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.aGZ.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.aGZ.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.abO != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.abO.getMeasuredWidth();
                    if (value.aHs) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.aGS == 1) {
                        measuredHeight = this.aHj.getTop() + this.abO.getTop();
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
        this.aGS = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aGZ.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gA(String str) {
        return this.aGZ.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.abE.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aHn = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.aHm = i;
    }

    public void setShowIconType(int i) {
        this.aHi = i;
    }

    public void M(int i, int i2) {
        this.aHk.setVisibility(8);
        this.aHl.setVisibility(0);
        aj.c(this.aHl, i);
        aj.j(this.aHl, i2);
        this.aHo = i;
        this.aHp = i2;
    }

    public void setAnimationResId(int i) {
        this.aHe = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void dD(int i) {
        super.dD(i);
        Set<Map.Entry<String, e.a>> entrySet = this.aGZ.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.dD(i);
                }
            }
        }
        if (this.aHi == c.aHf) {
            aj.c(this.aHl, this.aHo);
            aj.j(this.aHl, this.aHp);
            return;
        }
        if (this.aHm != 0) {
            aj.i(this.abE, this.aHm);
        } else {
            aj.i(this.abE, d.C0080d.cp_cont_f);
        }
        if (this.aHn != 0) {
            aj.c(this.abO, this.aHn);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void bL(boolean z) {
        super.bL(z);
        if (this.aHe != 0) {
            if (z) {
                aj.c(this.abO, this.aHe);
                this.aHq = (AnimationDrawable) this.abO.getDrawable();
                if (this.aHq != null) {
                    this.aHq.start();
                    return;
                }
                return;
            }
            if (this.aHq != null) {
                this.aHq.stop();
            }
            if (this.aHn != 0) {
                aj.c(this.abO, this.aHn);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.abE;
    }
}
