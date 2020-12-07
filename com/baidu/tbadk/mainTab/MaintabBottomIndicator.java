package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int animationResId;
    private e composition;
    private int fAa;
    public boolean fAb;
    public boolean fAc;
    public int fAd;
    private int ffJ;
    private View fzT;
    private View fzU;
    private TBLottieAnimationView fzV;
    private TBLottieAnimationView fzW;
    private TbImageView fzX;
    private View fzY;
    private int fzZ;
    private int mSkinType;
    private TextView mTextView;
    private int mTipPosType;
    private HashMap<String, TbFragmentTabIndicator.a> mTips;
    private int showIconType;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fAb = false;
        this.fAc = true;
        this.fAd = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fAb = false;
        this.fAc = true;
        this.fAd = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fAb = false;
        this.fAc = true;
        this.fAd = 1;
        init();
    }

    private void init() {
        this.fzT = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fzT.setLayoutParams(layoutParams);
        this.fzU = this.fzT.findViewById(R.id.container_common_item);
        this.fzV = (TBLottieAnimationView) this.fzT.findViewById(R.id.view_bottom_icon);
        this.fzV.setSpeed(1.1f);
        this.fzV.bIs();
        this.fzX = (TbImageView) this.fzT.findViewById(R.id.image_icon);
        this.fzX.setRadius(50);
        this.fzX.setConrers(15);
        this.mTextView = (TextView) this.fzT.findViewById(R.id.view_bottom_text);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams();
        marginLayoutParams.topMargin = -l.getDimens(getContext(), R.dimen.M_H_X001);
        this.mTextView.setLayoutParams(marginLayoutParams);
        this.fzW = (TBLottieAnimationView) this.fzT.findViewById(R.id.animation_view);
        this.fzW.setFirstLoadInternal(true);
        this.fzY = this.fzT.findViewById(R.id.bar_cross_line);
        addView(this.fzT);
        this.fzZ = l.getDimens(getContext(), R.dimen.tbds18);
        this.fAa = l.getDimens(getContext(), R.dimen.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.mTips.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.mTips.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.fzV != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.fzZ;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.fzV.getTop();
                        measuredHeight2 = this.fAa;
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
        this.mTipPosType = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.mTips.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.mTips.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a El(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.ffJ = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.fzU.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.fzW;
    }

    public void bEd() {
        if (this.fzW != null && this.fzW.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.fzW.startAnimation(scaleAnimation);
            this.fzW.setVisibility(4);
            this.fzV.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_lottie_show_count", 4);
        }
    }

    private void bEe() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_lottie_show_count", 0);
        }
    }

    private void bEf() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.bsO().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.fzW.setFrame(this.fzW.getFrame());
        if (i >= 3) {
            bEd();
        }
    }

    public void onDestory() {
        if (this.fzW != null) {
            this.fzW.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.fzW != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!au.isEmpty(string) || !z) {
                bEe();
                if (be.s(com.baidu.tbadk.core.sharedPref.b.bsO().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.bsO().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_lottie_show_count", 0) < 3) {
                    this.fzW.playAnimation();
                    this.fzW.setAnimationUrl(string);
                    bEf();
                    TiebaStatic.log(new ar("c13248").dY("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.fzW.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.fzV.setVisibility(8);
                            MaintabBottomIndicator.this.fzW.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bEg();
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.animationResId = i;
        ap.a(this.fzV, this.animationResId);
    }

    public void setImageIconUrl(String str, final String str2) {
        if (!au.isEmpty(str)) {
            this.fzX.setVisibility(8);
            this.fzX.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str3, boolean z) {
                    if (z) {
                        MaintabBottomIndicator.this.fzX.setVisibility(0);
                        if (!au.isEmpty(str2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, str2));
                        }
                        MaintabBottomIndicator.this.fzX.setEvent(null);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
            this.fzX.startLoad(str, 10, false);
        }
    }

    public void bEh() {
        ap.a(this.fzV, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.fzV.loop(false);
        playAnimation();
    }

    public void bEi() {
        ap.a(this.fzV, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.fzV.loop(true);
        playAnimation();
    }

    public void bEj() {
        ap.a(this.fzV, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.fzV.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.fzV != null) {
            this.fzV.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.fzV.isAnimating();
    }

    public void kJ(boolean z) {
        setAnimationResId(this.animationResId);
        this.fzV.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.fzV.playAnimation();
            return;
        }
        this.fzV.cancelAnimation();
        this.fzV.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i) {
        super.onChangeSkin(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.mTips.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.onChangeSkin(i);
                }
            }
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ffJ != 0) {
                ap.setViewTextColor(this.mTextView, this.ffJ);
            } else {
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0107);
            }
            if (this.animationResId != 0) {
                try {
                    ap.a(this.fzV, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.fzV.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.fzV.setAlpha(0.83f);
                    } else {
                        this.fzV.setAlpha(1.0f);
                    }
                    bEk();
                } catch (Exception e) {
                }
            }
        }
        ap.setBackgroundColor(this.fzY, R.color.CAM_X0203, i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
        if (this.animationResId != 0) {
            if (z) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.mTextView).pu(R.string.F_X02);
                this.fzX.setVisibility(8);
                this.fzV.playAnimation();
                if (this.mTips != null) {
                    for (TbFragmentTabIndicator.a aVar : this.mTips.values()) {
                        if (aVar != null && aVar.view != null && aVar.view.isClickable()) {
                            aVar.view.performClick();
                        }
                    }
                    return;
                }
                return;
            }
            this.fzV.cancelAnimation();
            this.fzV.setFrame(0);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.mTextView).pu(R.string.F_X01);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.fzV.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bEk() {
        if (this.fAb && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.fAc) {
            if (this.fAd == 1) {
                kJ(this.fAc);
            } else if (this.fAd == 2) {
                bEh();
            }
        }
    }
}
