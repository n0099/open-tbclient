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
import com.baidu.adp.base.i;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private boolean PT;
    private int bdA;
    private boolean bdB;
    private int bdC;
    private String bdD;
    private BdUniqueId bdE;
    private TextView bdF;
    private int bdG;
    private int bdH;
    private HashMap<String, TbFragmentTabIndicator.a> bdI;
    private int bdx;
    public int bdy;
    private int bdz;
    private String iconUrl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;
    private int nk;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bdx = 0;
        this.nk = 0;
        this.bdB = true;
        this.PT = true;
        this.bdI = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.oq()) {
                    FragmentTabIndicator.this.NS();
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
        this.bdx = 0;
        this.nk = 0;
        this.bdB = true;
        this.PT = true;
        this.bdI = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.oq()) {
                    FragmentTabIndicator.this.NS();
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
        this.bdG = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.bdH = getResources().getDimensionPixelSize(e.C0210e.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(e.g.view_bottom_icon);
        this.bdF = (TextView) inflate.findViewById(e.g.view_bottom_text);
        this.bdF.setDuplicateParentStateEnabled(true);
        NS();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.bdF.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bdF.getLayoutParams();
            layoutParams.topMargin = i;
            this.bdF.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bdI.entrySet()) {
            TbFragmentTabIndicator.a value = entry.getValue();
            ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
            if (layoutParams.width == -2) {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            } else {
                value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, AiAppsFileUtils.GB));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int i5;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.bdI.entrySet().iterator();
        while (it.hasNext() && this.bdF.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bdF.getPaint().measureText(this.bdF.getText().toString());
            if (value.beb) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.Cd;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.Cd) - (measureText / 2);
            }
            if (this.bdx == 1) {
                i5 = measuredWidth - this.bdH;
                measuredHeight = this.bdG;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bdG = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.bdx = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bdI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a io(String str) {
        return this.bdI.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.bdF.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.bdF.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.bdF.setText(str);
        this.bdF.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bdF.getText().toString();
        if (z) {
            charSequence = getContext().getString(e.j.talk_checked_tip) + charSequence;
        }
        this.bdF.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bdF.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.bdC = i;
        NS();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.bdz = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bdA = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.bdF.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.bdF.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.bdF.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bdy = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.nk = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.bea = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eC(int i) {
        if (this.PT) {
            al.c(this.bdF, this.bdy, 1);
        } else {
            al.b(this.bdF, this.bdy, 1, 0);
        }
        if (this.bdF != null) {
            this.bdF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.c((Resources) null, this.bdz), al.c((Resources) null, this.bdA), (Drawable) null);
        }
        NR();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bdI.entrySet()) {
            entry.getValue().eC(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cC(boolean z) {
        super.cC(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void NQ() {
        if (this.nk > 0 && this.bdB) {
            try {
                this.bdB = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.nk);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.bdB = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.bdB = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.bdF.getLayoutParams();
        layoutParams.width = -2;
        this.bdF.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            al.b(this.bdF, this.bdy, 1, 0);
        }
        this.PT = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.bdF;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.bdF.setVisibility(8);
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
        NR();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.bdF.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.bdF.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        NR();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.bea) {
            this.bdF.getPaint().setFakeBoldText(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void aL(String str, String str2) {
        this.iconUrl = str;
        this.bdD = str2;
        NR();
    }

    private void NR() {
        if (this.bdz <= 0 && this.bdA <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.bdD)) {
                com.baidu.adp.lib.f.c.jA().a(this.bdD, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.jA().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                NS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NS() {
        if (this.bdC > 0) {
            al.c(this.mIconView, this.bdC);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.bdE != null) {
            return this.bdE;
        }
        com.baidu.adp.base.e<?> aK = i.aK(getContext());
        if (aK != null) {
            this.bdE = aK.getUniqueId();
        }
        return this.bdE;
    }
}
