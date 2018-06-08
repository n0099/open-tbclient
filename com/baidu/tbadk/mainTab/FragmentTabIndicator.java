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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private int aQC;
    public int aQD;
    private int aQE;
    private int aQF;
    private boolean aQG;
    private int aQH;
    private String aQI;
    private BdUniqueId aQJ;
    private TextView aQK;
    private int aQL;
    private int aQM;
    private HashMap<String, TbFragmentTabIndicator.a> aQN;
    private String iconUrl;
    private int kc;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aQC = 0;
        this.kc = 0;
        this.aQG = true;
        this.aQN = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.na()) {
                    FragmentTabIndicator.this.Je();
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
        this.aQC = 0;
        this.kc = 0;
        this.aQG = true;
        this.aQN = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.na()) {
                    FragmentTabIndicator.this.Je();
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
        this.aQL = getResources().getDimensionPixelSize(d.e.ds2);
        this.aQM = getResources().getDimensionPixelSize(d.e.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(d.g.view_bottom_icon);
        this.aQK = (TextView) inflate.findViewById(d.g.view_bottom_text);
        this.aQK.setDuplicateParentStateEnabled(true);
        Je();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.aQK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aQK.getLayoutParams();
            layoutParams.topMargin = i;
            this.aQK.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aQN.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.aQN.entrySet().iterator();
        while (it.hasNext() && this.aQK.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.aQK.getPaint().measureText(this.aQK.getText().toString());
            if (value.aRg) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.zd;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.zd) - (measureText / 2);
            }
            if (this.aQC == 1) {
                i5 = measuredWidth - this.aQM;
                measuredHeight = this.aQL;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.aQL = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aQC = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.aQN.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hk(String str) {
        return this.aQN.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.aQK.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.aQK.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.aQK.setText(str);
        this.aQK.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.aQK.getText().toString();
        if (z) {
            charSequence = getContext().getString(d.k.talk_checked_tip) + charSequence;
        }
        this.aQK.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.aQK.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aQH = i;
        Je();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.aQE = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.aQF = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.aQK.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.aQK.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.aQK.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aQD = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.kc = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.aRf = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dC(int i) {
        al.c(this.aQK, this.aQD, 1);
        if (this.aQK != null) {
            this.aQK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.c((Resources) null, this.aQE), al.c((Resources) null, this.aQF), (Drawable) null);
        }
        Jd();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.aQN.entrySet()) {
            entry.getValue().dC(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bN(boolean z) {
        super.bN(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void Jc() {
        if (this.kc > 0 && this.aQG) {
            try {
                this.aQG = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.kc);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.aQG = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.aQG = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.aQK.getLayoutParams();
        layoutParams.width = -2;
        this.aQK.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.aQK;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.aQK.setVisibility(8);
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
        Jd();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.aQK.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.aQK.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        Jd();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.aRf) {
            this.aQK.getPaint().setFakeBoldText(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void au(String str, String str2) {
        this.iconUrl = str;
        this.aQI = str2;
        Jd();
    }

    private void Jd() {
        if (this.aQE <= 0 && this.aQF <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.aQI)) {
                com.baidu.adp.lib.f.c.ig().a(this.aQI, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.ig().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                Je();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Je() {
        if (this.aQH > 0) {
            al.c(this.mIconView, this.aQH);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.aQJ != null) {
            return this.aQJ;
        }
        e<?> ad = i.ad(getContext());
        if (ad != null) {
            this.aQJ = ad.getUniqueId();
        }
        return this.aQJ;
    }
}
