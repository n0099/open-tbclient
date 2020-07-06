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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
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
    private int ego;
    private View eyI;
    private View eyJ;
    private TBLottieAnimationView eyK;
    private TBLottieAnimationView eyL;
    private int eyM;
    private int eyN;
    public boolean eyO;
    public boolean eyP;
    public int eyQ;
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
        this.eyO = false;
        this.eyP = true;
        this.eyQ = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.eyO = false;
        this.eyP = true;
        this.eyQ = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.eyO = false;
        this.eyP = true;
        this.eyQ = 1;
        init();
    }

    private void init() {
        this.eyI = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.eyI.setLayoutParams(layoutParams);
        this.eyJ = this.eyI.findViewById(R.id.container_common_item);
        this.eyK = (TBLottieAnimationView) this.eyI.findViewById(R.id.view_bottom_icon);
        this.eyK.setSpeed(1.1f);
        this.eyK.bkF();
        this.mTextView = (TextView) this.eyI.findViewById(R.id.view_bottom_text);
        this.eyL = (TBLottieAnimationView) this.eyI.findViewById(R.id.animation_view);
        this.eyL.setFirstLoadInternal(true);
        addView(this.eyI);
        this.eyM = l.getDimens(getContext(), R.dimen.tbds18);
        this.eyN = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.eyK != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.eyM;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.eyK.getTop();
                        measuredHeight2 = this.eyN;
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
    public TbFragmentTabIndicator.a yR(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.ego = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.eyJ.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.eyL;
    }

    public void bgH() {
        if (this.eyL != null && this.eyL.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.eyL.startAnimation(scaleAnimation);
            this.eyL.setVisibility(4);
            this.eyK.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_lottie_show_count", 4);
        }
    }

    private void bgI() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_lottie_show_count", 0);
        }
    }

    private void bgJ() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgK() {
        int i = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.aVP().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.eyL.setFrame(this.eyL.getFrame());
        if (i >= 3) {
            bgH();
        }
    }

    public void onDestory() {
        if (this.eyL != null) {
            this.eyL.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.eyL != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ar.isEmpty(string) || !z) {
                bgI();
                if (bb.u(com.baidu.tbadk.core.sharedPref.b.aVP().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.aVP().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_lottie_show_count", 0) < 3) {
                    this.eyL.playAnimation();
                    this.eyL.setAnimationUrl(string);
                    bgJ();
                    TiebaStatic.log(new ao("c13248").dk("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.eyL.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.eyK.setVisibility(8);
                            MaintabBottomIndicator.this.eyL.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bgK();
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
        an.a(this.eyK, this.animationResId);
    }

    public void bgL() {
        an.a(this.eyK, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.eyK.loop(false);
        playAnimation();
    }

    public void bgM() {
        an.a(this.eyK, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.eyK.loop(true);
        playAnimation();
    }

    public void bgN() {
        an.a(this.eyK, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.eyK.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.eyK != null) {
            this.eyK.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.eyK.isAnimating();
    }

    public void ip(boolean z) {
        setAnimationResId(this.animationResId);
        this.eyK.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.eyK.playAnimation();
            return;
        }
        this.eyK.cancelAnimation();
        this.eyK.setFrame(0);
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
            if (this.ego != 0) {
                an.setViewTextColor(this.mTextView, this.ego);
            } else {
                an.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            }
            if (this.animationResId != 0) {
                try {
                    an.a(this.eyK, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.eyK.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.eyK.setAlpha(0.83f);
                    } else {
                        this.eyK.setAlpha(1.0f);
                    }
                    bgO();
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
        if (this.animationResId != 0) {
            if (z) {
                this.eyK.playAnimation();
                return;
            }
            this.eyK.cancelAnimation();
            this.eyK.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.eyK.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bgO() {
        if (this.eyO && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.eyP) {
            if (this.eyQ == 1) {
                ip(this.eyP);
            } else if (this.eyQ == 2) {
                bgL();
            }
        }
    }
}
