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
    private boolean Qd;
    private int bel;
    public int bem;
    private int ben;
    private int beo;
    private boolean bep;
    private int beq;
    private String ber;
    private BdUniqueId bes;
    private TextView beu;
    private int bev;
    private int bew;
    private HashMap<String, TbFragmentTabIndicator.a> bex;
    private String iconUrl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback;
    private ImageView mIconView;
    private int nk;

    public FragmentTabIndicator(Context context) {
        super(context);
        this.bel = 0;
        this.nk = 0;
        this.bep = true;
        this.Qd = true;
        this.bex = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.ou()) {
                    FragmentTabIndicator.this.Ok();
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
        this.bel = 0;
        this.nk = 0;
        this.bep = true;
        this.Qd = true;
        this.bex = new HashMap<>();
        this.mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass2) aVar, str, i);
                if (FragmentTabIndicator.this.mIconView == null || aVar == null || !aVar.ou()) {
                    FragmentTabIndicator.this.Ok();
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
        this.bev = getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.bew = getResources().getDimensionPixelSize(e.C0210e.ds12);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.fragment_bottom_indicator_item, this);
        this.mIconView = (ImageView) inflate.findViewById(e.g.view_bottom_icon);
        this.beu = (TextView) inflate.findViewById(e.g.view_bottom_text);
        this.beu.setDuplicateParentStateEnabled(true);
        Ok();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        if (this.beu.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.beu.getLayoutParams();
            layoutParams.topMargin = i;
            this.beu.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bex.entrySet()) {
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
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.bex.entrySet().iterator();
        while (it.hasNext() && this.beu.getText() != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            int measuredWidth2 = value.view.getMeasuredWidth();
            int measuredHeight2 = value.view.getMeasuredHeight();
            int measureText = (int) this.beu.getPaint().measureText(this.beu.getText().toString());
            if (value.beQ) {
                measuredWidth = (measureText / 2) + (getMeasuredWidth() / 2) + value.Cd;
            } else {
                measuredWidth = ((getMeasuredWidth() / 2) - value.Cd) - (measureText / 2);
            }
            if (this.bel == 1) {
                i5 = measuredWidth - this.bew;
                measuredHeight = this.bev;
            } else {
                i5 = measuredWidth;
                measuredHeight = (getMeasuredHeight() / 2) - (value.view.getMeasuredHeight() / 2);
            }
            value.view.layout(i5, measuredHeight, measuredWidth2 + i5, measuredHeight2 + measuredHeight);
        }
    }

    public void setTipTopMargin(int i) {
        this.bev = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.bel = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar.view != null) {
            addView(aVar.view);
            this.bex.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a iD(String str) {
        return this.bex.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.beu.setText(i);
    }

    public void setWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        layoutParams.addRule(13, -1);
        this.beu.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        this.beu.setText(str);
        this.beu.setContentDescription(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        String charSequence = this.beu.getText().toString();
        if (z) {
            charSequence = getContext().getString(e.j.talk_checked_tip) + charSequence;
        }
        this.beu.setContentDescription(charSequence);
    }

    public void setTextSpan(SpannableString spannableString) {
        this.beu.setText(spannableString);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.beq = i;
        Ok();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        this.ben = i;
    }

    public void setCompoundDrawablesRightResId(int i) {
        this.beo = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        this.beu.setCompoundDrawablePadding(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        this.beu.setTextSize(f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        this.beu.setTextSize(i, f);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bem = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.nk = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        this.beP = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eD(int i) {
        if (this.Qd) {
            al.c(this.beu, this.bem, 1);
        } else {
            al.b(this.beu, this.bem, 1, 0);
        }
        if (this.beu != null) {
            this.beu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.c((Resources) null, this.ben), al.c((Resources) null, this.beo), (Drawable) null);
        }
        Oj();
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.bex.entrySet()) {
            entry.getValue().eD(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cF(boolean z) {
        super.cF(z);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void Oi() {
        if (this.nk > 0 && this.bep) {
            try {
                this.bep = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mIconView.getContext(), this.nk);
                loadAnimation.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tbadk.mainTab.FragmentTabIndicator.1
                    @Override // com.baidu.adp.lib.g.d
                    public void b(Animation animation) {
                        FragmentTabIndicator.this.bep = true;
                    }
                });
                this.mIconView.startAnimation(loadAnimation);
            } catch (Exception e) {
                this.bep = true;
            }
        }
    }

    public void setContentWidthWrapContent() {
        ViewGroup.LayoutParams layoutParams = this.beu.getLayoutParams();
        layoutParams.width = -2;
        this.beu.setLayoutParams(layoutParams);
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            al.b(this.beu, this.bem, 1, 0);
        }
        this.Qd = z;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.beu;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        setClipToPadding(false);
        setClipChildren(false);
        this.beu.setVisibility(8);
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
        Oj();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        this.beu.setVisibility(0);
        this.mIconView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        this.beu.setLayoutParams(layoutParams);
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = i2;
            layoutParams2.addRule(2, this.mIconView.getId());
            layoutParams2.addRule(14, -1);
            this.mIconView.setLayoutParams(layoutParams2);
        }
        Oj();
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.beP) {
            this.beu.getPaint().setFakeBoldText(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void aM(String str, String str2) {
        this.iconUrl = str;
        this.ber = str2;
        Oj();
    }

    private void Oj() {
        if (this.ben <= 0 && this.beo <= 0) {
            if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.ber)) {
                com.baidu.adp.lib.f.c.jA().a(this.ber, 10, this.mCallback, getBdUniqueId());
            } else if (!TextUtils.isEmpty(this.iconUrl)) {
                com.baidu.adp.lib.f.c.jA().a(this.iconUrl, 10, this.mCallback, getBdUniqueId());
            } else {
                Ok();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ok() {
        if (this.beq > 0) {
            al.c(this.mIconView, this.beq);
        }
    }

    private BdUniqueId getBdUniqueId() {
        if (this.bes != null) {
            return this.bes;
        }
        com.baidu.adp.base.e<?> aK = i.aK(getContext());
        if (aK != null) {
            this.bes = aK.getUniqueId();
        }
        return this.bes;
    }
}
