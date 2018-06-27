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
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private boolean Na;
    private int aRA;
    private int aRB;
    private boolean aRC;
    private int aRD;
    private String aRE;
    private BdUniqueId aRF;
    private TextView aRG;
    private int aRH;
    private int aRI;
    private HashMap<String, TbFragmentTabIndicator.a> aRJ;
    private int aRy;
    public int aRz;
    private String iconUrl;
    private int kc;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aRy = 0;
        this.kc = 0;
        this.aRC = true;
        this.Na = true;
        this.aRJ = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.na()) {
                    FragmentTabIndicator.this.Jw();
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
        this.aRy = 0;
        this.kc = 0;
        this.aRC = true;
        this.Na = true;
        this.aRJ = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.na()) {
                    FragmentTabIndicator.this.Jw();
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
        this.aRH = getResources().getDimensionPixelSize(d.e.ds2);
        this.aRI = getResources().getDimensionPixelSize(d.e.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(d.g.view_bottom_icon);
        this.aRG = (TextView) inflate.findViewById(d.g.view_bottom_text);
        this.aRG.setDuplicateParentStateEnabled(true);
        Jw();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.aRG.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRG.getLayoutParams();
            layoutParams.topMargin = i;
            this.aRG.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aRJ.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.aRJ.entrySet().iterator();
        while (it.hasNext() && this.aRG.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aRG.getPaint().measureText(this.aRG.getText().toString());
            if (value.aSc) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.zb;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.zb) - (measureText / 2);
            }
            if (this.aRy == 1) {
                i5 = measuredWidth - this.aRI;
                measuredHeight = this.aRH;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aRH = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aRy = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aRJ.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a ho(String str) {
        return this.aRJ.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.aRG.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.aRG.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.aRG.setText(str);
        this.aRG.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aRG.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.k.talk_checked_tip) + charSequence;
        }
        this.aRG.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aRG.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aRD = i;
        Jw();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.aRA = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aRB = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.aRG.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.aRG.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.aRG.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aRz = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.kc = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.aSb = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dD(int i) {
        if (this.Na) {
            am.c(this.aRG, this.aRz, 1);
        } else {
            am.b(this.aRG, this.aRz, 1, 0);
        }
        if (this.aRG != null) {
            this.aRG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.c((Resources) null, this.aRA), am.c((Resources) null, this.aRB), (Drawable) null);
        }
        Jv();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aRJ.entrySet()) {
            entry.getValue().dD(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bQ(boolean z) {
        super.bQ(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void Ju() {
        if (this.kc > 0 && this.aRC) {
            try {
                this.aRC = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.kc);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.aRC = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.aRC = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.aRG.getLayoutParams();
        layoutParams.width = -2;
        this.aRG.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            am.b(this.aRG, this.aRz, 1, 0);
        }
        this.Na = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.aRG;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.aRG.setVisibility(8);
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
        Jv();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.aRG.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.aRG.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        Jv();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aSb) {
            this.aRG.getPaint().setFakeBoldText(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void au(String str, String str2) {
        this.iconUrl = str;
        this.aRE = str2;
        Jv();
    }

    private void Jv() {
        if (this.aRA <= 0 && this.aRB <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.aRE)) {
                com.baidu.adp.lib.f.c.ig().a(this.aRE, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.ig().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                Jw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jw() {
        if (this.aRD > 0) {
            am.c(this.mIconView, this.aRD);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.aRF != null) {
            return this.aRF;
        }
        e<?> ad = i.ad(getContext());
        if (ad != null) {
            this.aRF = ad.getUniqueId();
        }
        return this.aRF;
    }
}
