package com.baidu.tbadk.mainTab;

import android.content.Context;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private int animationResId;
    public int dayTextColorResId;
    private int drawableRightResId;
    private int drawableTopResId;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eJP;
    private boolean frX;
    private int frY;
    private String frZ;
    private BdUniqueId fsa;
    private TextView fsb;
    private String iconUrl;
    private ImageView mIconView;
    private boolean mIsSupportNight;
    private int mTipPosType;
    private int mTipRightMargin;
    private int mTipTopMargin;
    private HashMap<String, TbFragmentTabIndicator.a> mTips;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.mTipPosType = 0;
        this.animationResId = 0;
        this.frX = true;
        this.mIsSupportNight = true;
        this.mTips = new HashMap<>();
        this.eJP = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.isValidNow()) {
                    FragmentTabIndicator.this.bAA();
                    return;
                }
                FragmentTabIndicator.this.mIconView.setBackgroundResource(0);
                FragmentTabIndicator.this.mIconView.setImageDrawable(null);
                aVar.drawImageTo(FragmentTabIndicator.this.mIconView);
            }
        };
        init();
    }

    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.animationResId = 0;
        this.frX = true;
        this.mIsSupportNight = true;
        this.mTips = new HashMap<>();
        this.eJP = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.isValidNow()) {
                    FragmentTabIndicator.this.bAA();
                    return;
                }
                FragmentTabIndicator.this.mIconView.setBackgroundResource(0);
                FragmentTabIndicator.this.mIconView.setImageDrawable(null);
                aVar.drawImageTo(FragmentTabIndicator.this.mIconView);
            }
        };
        init();
    }

    private void init() {
        this.mTipTopMargin = getResources().getDimensionPixelSize(R.dimen.ds2);
        this.mTipRightMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
        this.fsb = (TextView) inflate.findViewById(R.id.view_bottom_text);
        this.fsb.setDuplicateParentStateEnabled(true);
        bAA();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.fsb.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fsb.getLayoutParams();
            layoutParams.topMargin = i;
            this.fsb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i) {
        super.setContentDefaultTextColor(i);
        this.fsb.setTextColor(i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.mTips.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.mTips.entrySet().iterator();
        while (it.hasNext() && this.fsb.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.fsb.getPaint().measureText(this.fsb.getText().toString());
            if (value.isRight) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.offsetX;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.offsetX) - (measureText / 2);
            }
            if (this.mTipPosType == 1) {
                i5 = measuredWidth - this.mTipRightMargin;
                measuredHeight = this.mTipTopMargin;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.mTipTopMargin = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.mTipPosType = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.mTips.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a DD(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.fsb.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.fsb.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.fsb.setText(str);
        this.fsb.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.fsb.getText().toString();
        if (z) {
            charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
        }
        this.fsb.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.fsb.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.frY = i;
        bAA();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.drawableTopResId = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.drawableRightResId = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.fsb.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.fsb.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.fsb.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.dayTextColorResId = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.animationResId = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.mIsContentSelectBold = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i) {
        if (this.mIsSupportNight) {
            ap.setViewTextColor(this.fsb, this.dayTextColorResId, 1);
        } else {
            ap.setViewTextColor(this.fsb, this.dayTextColorResId, 1, 0);
        }
        if (this.fsb != null) {
            this.fsb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getSkinDrawable(null, this.drawableTopResId), ap.getSkinDrawable(null, this.drawableRightResId), (Drawable) null);
        }
        bAz();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.mTips.entrySet()) {
            entry.getValue().onChangeSkin(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bAy() {
        if (this.animationResId > 0 && this.frX) {
            try {
                this.frX = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.animationResId);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.f.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.f.d
                    public void onSafeAnimationEnd(Animation animation) {
                        FragmentTabIndicator.this.frX = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.frX = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.fsb.getLayoutParams();
        layoutParams.width = -2;
        this.fsb.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            ap.setViewTextColor(this.fsb, this.dayTextColorResId, 1, 0);
        }
        this.mIsSupportNight = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.fsb;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.fsb.setVisibility(8);
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
        bAz();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.fsb.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.fsb.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        bAz();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.mIsContentSelectBold) {
            this.fsb.getPaint().setFakeBoldText(z);
        }
        if (z) {
            if (this.fss != 0.0f) {
                this.fsb.setTextSize(0, this.fss);
            }
            if (this.mThemeColorInfo != null && this.mThemeColorInfo.day != null && this.mThemeColorInfo.night != null && this.mThemeColorInfo.dark != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    this.fsb.setTextColor(com.baidu.tieba.tbadkCore.c.sa(this.mThemeColorInfo.dark.font_color));
                    return;
                } else if (skinType == 1) {
                    this.fsb.setTextColor(com.baidu.tieba.tbadkCore.c.sa(this.mThemeColorInfo.night.font_color));
                    return;
                } else {
                    this.fsb.setTextColor(com.baidu.tieba.tbadkCore.c.sa(this.mThemeColorInfo.day.font_color));
                    return;
                }
            } else if (this.fsu != 0) {
                ap.setViewTextColor(this.fsb, this.fsu);
                return;
            } else {
                return;
            }
        }
        if (this.fst != 0.0f) {
            this.fsb.setTextSize(0, this.fst);
        }
        if (this.fsv != 0) {
            ap.setViewTextColor(this.fsb, this.fsv);
        }
    }

    private void bAz() {
        if (this.drawableTopResId <= 0 && this.drawableRightResId <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.frZ)) {
                com.baidu.adp.lib.e.c.mS().a(this.frZ, 10, this.eJP, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.e.c.mS().a(this.iconUrl, 10, this.eJP, getBdUniqueId());
            } else {
                bAA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAA() {
        if (this.frY > 0) {
            ap.setImageResource(this.mIconView, this.frY);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.fsa != null) {
            return this.fsa;
        }
        e<?> I = i.I(getContext());
        if (I != null) {
            this.fsa = I.getUniqueId();
        }
        return this.fsa;
    }
}
