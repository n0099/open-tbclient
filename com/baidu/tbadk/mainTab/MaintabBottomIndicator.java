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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private HashMap<String, TbFragmentTabIndicator.a> aRJ;
    private int aRS;
    private View aRT;
    private View aRU;
    private ImageView aRV;
    private int aRW;
    private int aRX;
    private int aRY;
    private int aRZ;
    private int aRy;
    private AnimationDrawable aSa;
    private int kc;
    private ImageView mIconView;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aRy = 0;
        this.aRJ = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRy = 0;
        this.aRJ = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRy = 0;
        this.aRJ = new HashMap<>();
        init();
    }

    private void init() {
        this.aRT = LayoutInflater.from(getContext()).inflate(d.i.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aRT.setLayoutParams(layoutParams);
        this.aRU = this.aRT.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.aRT.findViewById(d.g.view_bottom_icon);
        this.mTextView = (TextView) this.aRT.findViewById(d.g.view_bottom_text);
        this.aRV = (ImageView) this.aRT.findViewById(d.g.view_write_icon);
        addView(this.aRT);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRJ.entrySet();
        if (entrySet != null && (r5 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i, i2, i3, i4);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRJ.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.aSc) {
                        left = this.mIconView.getRight() - ((int) (this.mIconView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mIconView.getLeft() + ((int) (this.mIconView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aRy == 1) {
                        measuredHeight = this.mIconView.getTop();
                        measuredHeight2 = measuredHeight3 / 4;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.view.getMeasuredHeight() / 2;
                    }
                    int i5 = measuredHeight - measuredHeight2;
                    value.view.layout(left, i5, measuredWidth + left, measuredHeight3 + i5);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aRy = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aRJ.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.aRJ.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a ho(String str) {
        return this.aRJ.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aRX = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aRW = i;
    }

    public void setShowIconType(int i) {
        this.aRS = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.aRU.setVisibility(8);
        this.aRV.setVisibility(0);
        am.c(this.aRV, i);
        am.i(this.aRV, i2);
        this.aRY = i;
        this.aRZ = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.kc = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dD(int i) {
        super.dD(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRJ.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.dD(i);
                }
            }
        }
        if (this.aRS == c.aRP) {
            am.c(this.aRV, this.aRY);
            am.i(this.aRV, this.aRZ);
            return;
        }
        if (this.aRW != 0) {
            am.h(this.mTextView, this.aRW);
        } else {
            am.h(this.mTextView, d.C0142d.cp_cont_f);
        }
        if (this.aRX != 0) {
            am.c(this.mIconView, this.aRX);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bQ(boolean z) {
        super.bQ(z);
        if (this.kc != 0) {
            if (z) {
                am.c(this.mIconView, this.kc);
                this.aSa = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.aSa != null) {
                    this.aSa.start();
                    return;
                }
                return;
            }
            if (this.aSa != null) {
                this.aSa.stop();
            }
            if (this.aRX != 0) {
                am.c(this.mIconView, this.aRX);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
