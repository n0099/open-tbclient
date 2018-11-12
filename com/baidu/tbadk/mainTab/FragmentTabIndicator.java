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
    private int aZZ;
    public int baa;
    private int bab;
    private int bac;
    private boolean bad;
    private int bae;
    private String baf;
    private BdUniqueId bag;
    private TextView bah;
    private int bai;
    private int baj;
    private HashMap<String, TbFragmentTabIndicator.a> bak;
    private String iconUrl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;
    private int nk;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.aZZ = 0;
        this.nk = 0;
        this.bad = true;
        this.PT = true;
        this.bak = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.or()) {
                    FragmentTabIndicator.this.MO();
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
        this.aZZ = 0;
        this.nk = 0;
        this.bad = true;
        this.PT = true;
        this.bak = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.or()) {
                    FragmentTabIndicator.this.MO();
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
        this.bai = getResources().getDimensionPixelSize(e.C0200e.ds2);
        this.baj = getResources().getDimensionPixelSize(e.C0200e.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(e.g.view_bottom_icon);
        this.bah = (TextView) inflate.findViewById(e.g.view_bottom_text);
        this.bah.setDuplicateParentStateEnabled(true);
        MO();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.bah.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bah.getLayoutParams();
            layoutParams.topMargin = i;
            this.bah.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bak.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.bak.entrySet().iterator();
        while (it.hasNext() && this.bah.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.bah.getPaint().measureText(this.bah.getText().toString());
            if (value.baE) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.Cd;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.Cd) - (measureText / 2);
            }
            if (this.aZZ == 1) {
                i5 = measuredWidth - this.baj;
                measuredHeight = this.bai;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bai = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.aZZ = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bak.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hW(String str) {
        return this.bak.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.bah.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.bah.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.bah.setText(str);
        this.bah.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.bah.getText().toString();
        if (z) {
            charSequence = getContext().getString(e.j.talk_checked_tip) + charSequence;
        }
        this.bah.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.bah.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.bae = i;
        MO();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.bab = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.bac = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.bah.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.bah.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.bah.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.baa = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.nk = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.baD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eo(int i) {
        if (this.PT) {
            al.c(this.bah, this.baa, 1);
        } else {
            al.b(this.bah, this.baa, 1, 0);
        }
        if (this.bah != null) {
            this.bah.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.c((Resources) null, this.bab), al.c((Resources) null, this.bac), (Drawable) null);
        }
        MN();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bak.entrySet()) {
            entry.getValue().eo(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cB(boolean z) {
        super.cB(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void MM() {
        if (this.nk > 0 && this.bad) {
            try {
                this.bad = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.nk);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.bad = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.bad = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.bah.getLayoutParams();
        layoutParams.width = -2;
        this.bah.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            al.b(this.bah, this.baa, 1, 0);
        }
        this.PT = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.bah;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.bah.setVisibility(8);
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
        MN();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.bah.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.bah.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        MN();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.baD) {
            this.bah.getPaint().setFakeBoldText(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void aI(String str, String str2) {
        this.iconUrl = str;
        this.baf = str2;
        MN();
    }

    private void MN() {
        if (this.bab <= 0 && this.bac <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.baf)) {
                com.baidu.adp.lib.f.c.jA().a(this.baf, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.jA().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                MO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MO() {
        if (this.bae > 0) {
            al.c(this.mIconView, this.bae);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.bag != null) {
            return this.bag;
        }
        com.baidu.adp.base.e<?> aK = i.aK(getContext());
        if (aK != null) {
            this.bag = aK.getUniqueId();
        }
        return this.bag;
    }
}
