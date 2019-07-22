package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private boolean Pg;
    private int cxA;
    private HashMap<String, TbFragmentTabIndicator.a> cxB;
    private int cxq;
    public int cxr;
    private int cxs;
    private int cxt;
    private boolean cxu;
    private int cxv;
    private String cxw;
    private BdUniqueId cxx;
    private TextView cxy;
    private int cxz;
    private String iconUrl;
    private int kE;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.cxq = 0;
        this.kE = 0;
        this.cxu = true;
        this.Pg = true;
        this.cxB = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.nL()) {
                    FragmentTabIndicator.this.atV();
                    return;
                }
                FragmentTabIndicator.this.mIconView.setBackgroundResource(0);
                FragmentTabIndicator.this.mIconView.setImageDrawable(null);
                aVar.a(FragmentTabIndicator.this.mIconView);
            }
        };
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxq = 0;
        this.kE = 0;
        this.cxu = true;
        this.Pg = true;
        this.cxB = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.nL()) {
                    FragmentTabIndicator.this.atV();
                    return;
                }
                FragmentTabIndicator.this.mIconView.setBackgroundResource(0);
                FragmentTabIndicator.this.mIconView.setImageDrawable(null);
                aVar.a(FragmentTabIndicator.this.mIconView);
            }
        };
        init();
    }

    private void init() {
        this.cxz = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.cxA = getResources().getDimensionPixelSize(R.dimen.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
        this.cxy = (TextView) inflate.findViewById(R.id.view_bottom_text);
        this.cxy.setDuplicateParentStateEnabled(true);
        atV();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.cxy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cxy.getLayoutParams();
            layoutParams.topMargin = i;
            this.cxy.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i) {
        super.setContentDefaultTextColor(i);
        this.cxy.setTextColor(i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.cxB.entrySet()) {
            TbFragmentTabIndicator.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            } else {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, 1073741824));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.cxB.entrySet().iterator();
        while (it.hasNext() && this.cxy.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.cxy.getPaint().measureText(this.cxy.getText().toString());
            if (value.cxX) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.zQ;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.zQ) - (measureText / 2);
            }
            if (this.cxq == 1) {
                i5 = measuredWidth - this.cxA;
                measuredHeight = this.cxz;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.cxz = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.cxq = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.cxB.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a qP(String str) {
        return this.cxB.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.cxy.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.cxy.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.cxy.setText(str);
        this.cxy.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.cxy.getText().toString();
        if (z) {
            charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
        }
        this.cxy.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.cxy.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.cxv = i;
        atV();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.cxs = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.cxt = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.cxy.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.cxy.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.cxy.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.cxr = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.kE = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.cxS = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        jc(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void jc(int i) {
        if (this.Pg) {
            am.f(this.cxy, this.cxr, 1);
        } else {
            am.d(this.cxy, this.cxr, 1, 0);
        }
        if (this.cxy != null) {
            this.cxy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.d((Resources) null, this.cxs), am.d((Resources) null, this.cxt), (Drawable) null);
        }
        atU();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.cxB.entrySet()) {
            entry.getValue().jc(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void ft(boolean z) {
        super.ft(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void atT() {
        if (this.kE > 0 && this.cxu) {
            try {
                this.cxu = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.kE);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.cxu = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.cxu = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.cxy.getLayoutParams();
        layoutParams.width = -2;
        this.cxy.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            am.d(this.cxy, this.cxr, 1, 0);
        }
        this.Pg = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.cxy;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.cxy.setVisibility(8);
        this.mIconView.setVisibility(0);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = i;
            layoutParams.height = i;
            layoutParams.bottomMargin = i2;
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams);
        }
        atU();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.cxy.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.cxy.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        atU();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.cxS) {
            this.cxy.getPaint().setFakeBoldText(z);
        }
        if (z && this.cxT != 0.0f) {
            this.cxy.setTextSize(0, this.cxT);
        } else if (!z && this.cxU != 0.0f) {
            this.cxy.setTextSize(0, this.cxU);
        }
        if (z && this.cxV != 0) {
            am.j(this.cxy, this.cxV);
        } else if (!z && this.cxW != 0) {
            am.j(this.cxy, this.cxW);
        }
    }

    private void atU() {
        if (this.cxs <= 0 && this.cxt <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.cxw)) {
                com.baidu.adp.lib.f.c.iE().a(this.cxw, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.iE().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                atV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atV() {
        if (this.cxv > 0) {
            am.c(this.mIconView, this.cxv);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.cxx != null) {
            return this.cxx;
        }
        e<?> ab = i.ab(getContext());
        if (ab != null) {
            this.cxx = ab.getUniqueId();
        }
        return this.cxx;
    }
}
