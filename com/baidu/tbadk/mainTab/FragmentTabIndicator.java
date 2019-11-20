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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    private int animationResId;
    private boolean cJl;
    private int cJm;
    private String cJn;
    private BdUniqueId cJo;
    private TextView cJp;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> chB;
    public int dayTextColorResId;
    private int drawableRightResId;
    private int drawableTopResId;
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
        this.cJl = true;
        this.mIsSupportNight = true;
        this.mTips = new HashMap<>();
        this.chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.isValidNow()) {
                    FragmentTabIndicator.this.avA();
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
        this.cJl = true;
        this.mIsSupportNight = true;
        this.mTips = new HashMap<>();
        this.chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.isValidNow()) {
                    FragmentTabIndicator.this.avA();
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
        this.cJp = (TextView) inflate.findViewById(R.id.view_bottom_text);
        this.cJp.setDuplicateParentStateEnabled(true);
        avA();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.cJp.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cJp.getLayoutParams();
            layoutParams.topMargin = i;
            this.cJp.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i) {
        super.setContentDefaultTextColor(i);
        this.cJp.setTextColor(i);
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
        while (it.hasNext() && this.cJp.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.cJp.getPaint().measureText(this.cJp.getText().toString());
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
    public TbFragmentTabIndicator.a qa(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.cJp.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.cJp.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.cJp.setText(str);
        this.cJp.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.cJp.getText().toString();
        if (z) {
            charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
        }
        this.cJp.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.cJp.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.cJm = i;
        avA();
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
        this.cJp.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.cJp.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.cJp.setTextSize(i, f);
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
            am.setViewTextColor(this.cJp, this.dayTextColorResId, 1);
        } else {
            am.setViewTextColor(this.cJp, this.dayTextColorResId, 1, 0);
        }
        if (this.cJp != null) {
            this.cJp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getSkinDrawable(null, this.drawableTopResId), am.getSkinDrawable(null, this.drawableRightResId), (Drawable) null);
        }
        avz();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.mTips.entrySet()) {
            entry.getValue().onChangeSkin(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void avy() {
        if (this.animationResId > 0 && this.cJl) {
            try {
                this.cJl = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.animationResId);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void onSafeAnimationEnd(Animation animation) {
                        FragmentTabIndicator.this.cJl = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.cJl = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.cJp.getLayoutParams();
        layoutParams.width = -2;
        this.cJp.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            am.setViewTextColor(this.cJp, this.dayTextColorResId, 1, 0);
        }
        this.mIsSupportNight = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.cJp;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.cJp.setVisibility(8);
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
        avz();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.cJp.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.cJp.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        avz();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.mIsContentSelectBold) {
            this.cJp.getPaint().setFakeBoldText(z);
        }
        if (z && this.cJA != 0.0f) {
            this.cJp.setTextSize(0, this.cJA);
        } else if (!z && this.cJB != 0.0f) {
            this.cJp.setTextSize(0, this.cJB);
        }
        if (z && this.cJC != 0) {
            am.setViewTextColor(this.cJp, this.cJC);
        } else if (!z && this.cJD != 0) {
            am.setViewTextColor(this.cJp, this.cJD);
        }
    }

    private void avz() {
        if (this.drawableTopResId <= 0 && this.drawableRightResId <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.cJn)) {
                com.baidu.adp.lib.f.c.fT().a(this.cJn, 10, this.chB, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.fT().a(this.iconUrl, 10, this.chB, getBdUniqueId());
            } else {
                avA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avA() {
        if (this.cJm > 0) {
            am.setImageResource(this.mIconView, this.cJm);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.cJo != null) {
            return this.cJo;
        }
        e<?> ab = i.ab(getContext());
        if (ab != null) {
            this.cJo = ab.getUniqueId();
        }
        return this.cJo;
    }
}
