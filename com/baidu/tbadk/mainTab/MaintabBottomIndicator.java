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
    private HashMap<String, e.a> bvF;
    private int bvK;
    private int bvO;
    private View bvP;
    private View bvQ;
    private ImageView bvR;
    private int bvS;
    private int bvT;
    private int bvU;
    private int bvV;
    private AnimationDrawable bvW;
    private int bvy;
    private ImageView mIconView;
    private TextView rz;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.bvy = 0;
        this.bvF = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvy = 0;
        this.bvF = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvy = 0;
        this.bvF = new HashMap<>();
        init();
    }

    private void init() {
        this.bvP = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bvP.setLayoutParams(layoutParams);
        this.bvQ = this.bvP.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.bvP.findViewById(d.g.view_bottom_icon);
        this.rz = (TextView) this.bvP.findViewById(d.g.view_bottom_text);
        this.bvR = (ImageView) this.bvP.findViewById(d.g.view_write_icon);
        addView(this.bvP);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, e.a>> entrySet = this.bvF.entrySet();
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
        Set<Map.Entry<String, e.a>> entrySet = this.bvF.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                e.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth2 = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    int measuredWidth3 = this.mIconView.getMeasuredWidth();
                    if (value.bvY) {
                        measuredWidth = ((measuredWidth3 / 2) + (getMeasuredWidth() / 2)) - (measuredWidth2 / 2);
                    } else {
                        measuredWidth = ((getMeasuredWidth() / 2) - (measuredWidth3 / 2)) + (measuredWidth2 / 2);
                    }
                    if (this.bvy == 1) {
                        measuredHeight = this.bvP.getTop() + this.mIconView.getTop();
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
        this.bvy = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void a(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bvF.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void b(String str, e.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bvF.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public e.a gG(String str) {
        return this.bvF.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setText(int i) {
        this.rz.setText(i);
    }

    public void setIconResourceId(int i) {
        this.bvT = i;
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void setTextColorResId(int i) {
        this.bvS = i;
    }

    public void setShowIconType(int i) {
        this.bvO = i;
    }

    public void aK(int i, int i2) {
        this.bvQ.setVisibility(8);
        this.bvR.setVisibility(0);
        aj.c(this.bvR, i);
        aj.s(this.bvR, i2);
        this.bvU = i;
        this.bvV = i2;
    }

    public void setAnimationResId(int i) {
        this.bvK = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gz(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void gz(int i) {
        super.gz(i);
        Set<Map.Entry<String, e.a>> entrySet = this.bvF.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, e.a> entry : entrySet) {
                e.a value = entry.getValue();
                if (value != null) {
                    value.gz(i);
                }
            }
        }
        if (this.bvO == c.bvL) {
            aj.c(this.bvR, this.bvU);
            aj.s(this.bvR, this.bvV);
            return;
        }
        if (this.bvS != 0) {
            aj.r(this.rz, this.bvS);
        } else {
            aj.r(this.rz, d.C0107d.cp_cont_f);
        }
        if (this.bvT != 0) {
            aj.c(this.mIconView, this.bvT);
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public void cm(boolean z) {
        super.cm(z);
        if (this.bvK != 0) {
            if (z) {
                aj.c(this.mIconView, this.bvK);
                this.bvW = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.bvW != null) {
                    this.bvW.start();
                    return;
                }
                return;
            }
            if (this.bvW != null) {
                this.bvW.stop();
            }
            if (this.bvT != 0) {
                aj.c(this.mIconView, this.bvT);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.e
    public View getContentTv() {
        return this.rz;
    }
}
