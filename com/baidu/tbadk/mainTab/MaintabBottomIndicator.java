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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int aIA;
    private int aIB;
    private AnimationDrawable aIC;
    private int aIe;
    private HashMap<String, TbFragmentTabIndicator.a> aIl;
    private int aIq;
    private int aIu;
    private View aIv;
    private View aIw;
    private ImageView aIx;
    private int aIy;
    private int aIz;
    private ImageView mIconView;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aIe = 0;
        this.aIl = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIe = 0;
        this.aIl = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIe = 0;
        this.aIl = new HashMap<>();
        init();
    }

    private void init() {
        this.aIv = LayoutInflater.from(getContext()).inflate(d.i.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aIv.setLayoutParams(layoutParams);
        this.aIw = this.aIv.findViewById(d.g.container_common_item);
        this.mIconView = (ImageView) this.aIv.findViewById(d.g.view_bottom_icon);
        this.mTextView = (TextView) this.aIv.findViewById(d.g.view_bottom_text);
        this.aIx = (ImageView) this.aIv.findViewById(d.g.view_write_icon);
        addView(this.aIv);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aIl.entrySet();
        if (entrySet != null && (r5 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.f7view.getLayoutParams();
                    if (layoutParams.width == -2) {
                        value.f7view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        value.f7view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aIl.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.f7view.getMeasuredWidth();
                    int measuredHeight3 = value.f7view.getMeasuredHeight();
                    if (value.aIE) {
                        left = this.mIconView.getRight() - ((int) (this.mIconView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mIconView.getLeft() + ((int) (this.mIconView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aIe == 1) {
                        measuredHeight = this.mIconView.getTop();
                        measuredHeight2 = measuredHeight3 / 4;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.f7view.getMeasuredHeight() / 2;
                    }
                    int i5 = measuredHeight - measuredHeight2;
                    value.f7view.layout(left, i5, measuredWidth + left, measuredHeight3 + i5);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aIe = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.f7view != null) {
            addView(aVar.f7view);
            this.aIl.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.f7view != null) {
            addView(aVar.f7view, -2, -2);
            this.aIl.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a gM(String str) {
        return this.aIl.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    public void setIconResourceId(int i) {
        this.aIz = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aIy = i;
    }

    public void setShowIconType(int i) {
        this.aIu = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.aIw.setVisibility(8);
        this.aIx.setVisibility(0);
        ak.c(this.aIx, i);
        ak.i(this.aIx, i2);
        this.aIA = i;
        this.aIB = i2;
    }

    public void setAnimationResId(int i) {
        this.aIq = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dA(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dA(int i) {
        super.dA(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aIl.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.dA(i);
                }
            }
        }
        if (this.aIu == c.aIr) {
            ak.c(this.aIx, this.aIA);
            ak.i(this.aIx, this.aIB);
            return;
        }
        if (this.aIy != 0) {
            ak.h(this.mTextView, this.aIy);
        } else {
            ak.h(this.mTextView, d.C0126d.cp_cont_f);
        }
        if (this.aIz != 0) {
            ak.c(this.mIconView, this.aIz);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bJ(boolean z) {
        super.bJ(z);
        if (this.aIq != 0) {
            if (z) {
                ak.c(this.mIconView, this.aIq);
                this.aIC = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.aIC != null) {
                    this.aIC.start();
                    return;
                }
                return;
            }
            if (this.aIC != null) {
                this.aIC.stop();
            }
            if (this.aIz != 0) {
                ak.c(this.mIconView, this.aIz);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
