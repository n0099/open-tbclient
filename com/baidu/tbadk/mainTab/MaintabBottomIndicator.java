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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int aQC;
    private HashMap<String, TbFragmentTabIndicator.a> aQN;
    private int aQW;
    private View aQX;
    private View aQY;
    private ImageView aQZ;
    private int aRa;
    private int aRb;
    private int aRc;
    private int aRd;
    private AnimationDrawable aRe;
    private int kc;
    private ImageView mIconView;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aQC = 0;
        this.aQN = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQC = 0;
        this.aQN = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQC = 0;
        this.aQN = new HashMap<>();
        init();
    }

    private void init() {
        this.aQX = LayoutInflater.from(getContext()).inflate(d.i.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aQX.setLayoutParams(layoutParams);
        this.aQY = this.aQX.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.aQX.findViewById(d.g.view_bottom_icon);
        this.mTextView = (TextView) this.aQX.findViewById(d.g.view_bottom_text);
        this.aQZ = (ImageView) this.aQX.findViewById(d.g.view_write_icon);
        addView(this.aQX);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aQN.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aQN.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.aRg) {
                        left = this.mIconView.getRight() - ((int) (this.mIconView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mIconView.getLeft() + ((int) (this.mIconView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aQC == 1) {
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
        this.aQC = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aQN.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.aQN.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hk(String str) {
        return this.aQN.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aRb = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aRa = i;
    }

    public void setShowIconType(int i) {
        this.aQW = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.aQY.setVisibility(8);
        this.aQZ.setVisibility(0);
        al.c(this.aQZ, i);
        al.i(this.aQZ, i2);
        this.aRc = i;
        this.aRd = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.kc = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dC(int i) {
        super.dC(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aQN.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.dC(i);
                }
            }
        }
        if (this.aQW == c.aQT) {
            al.c(this.aQZ, this.aRc);
            al.i(this.aQZ, this.aRd);
            return;
        }
        if (this.aRa != 0) {
            al.h(this.mTextView, this.aRa);
        } else {
            al.h(this.mTextView, d.C0141d.cp_cont_f);
        }
        if (this.aRb != 0) {
            al.c(this.mIconView, this.aRb);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bN(boolean z) {
        super.bN(z);
        if (this.kc != 0) {
            if (z) {
                al.c(this.mIconView, this.kc);
                this.aRe = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.aRe != null) {
                    this.aRe.start();
                    return;
                }
                return;
            }
            if (this.aRe != null) {
                this.aRe.stop();
            }
            if (this.aRb != 0) {
                al.c(this.mIconView, this.aRb);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
