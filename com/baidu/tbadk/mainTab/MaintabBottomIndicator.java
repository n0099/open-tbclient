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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
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
    private int dYn;
    private View epQ;
    private View epR;
    private TBLottieAnimationView epS;
    private TBLottieAnimationView epT;
    private int epU;
    private int epV;
    public boolean epW;
    public boolean epX;
    public int epY;
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
        this.epW = false;
        this.epX = true;
        this.epY = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.epW = false;
        this.epX = true;
        this.epY = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.epW = false;
        this.epX = true;
        this.epY = 1;
        init();
    }

    private void init() {
        this.epQ = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.epQ.setLayoutParams(layoutParams);
        this.epR = this.epQ.findViewById(R.id.container_common_item);
        this.epS = (TBLottieAnimationView) this.epQ.findViewById(R.id.view_bottom_icon);
        this.epS.setSpeed(1.1f);
        this.epS.bii();
        this.mTextView = (TextView) this.epQ.findViewById(R.id.view_bottom_text);
        this.epT = (TBLottieAnimationView) this.epQ.findViewById(R.id.animation_view);
        this.epT.setFirstLoadInternal(true);
        addView(this.epQ);
        this.epU = l.getDimens(getContext(), R.dimen.tbds18);
        this.epV = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.epS != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.epU;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.epS.getTop();
                        measuredHeight2 = this.epV;
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
    public TbFragmentTabIndicator.a yy(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.dYn = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.epR.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.epT;
    }

    public void beC() {
        if (this.epT != null && this.epT.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.epT.startAnimation(scaleAnimation);
            this.epT.setVisibility(4);
            this.epS.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_lottie_show_count", 4);
        }
    }

    private void beD() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_lottie_show_count", 0);
        }
    }

    private void beE() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beF() {
        int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.epT.setFrame(this.epT.getFrame());
        if (i >= 3) {
            beC();
        }
    }

    public void onDestory() {
        if (this.epT != null) {
            this.epT.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.epT != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!aq.isEmpty(string) || !z) {
                beD();
                if (az.u(com.baidu.tbadk.core.sharedPref.b.aTX().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.aTX().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_lottie_show_count", 0) < 3) {
                    this.epT.playAnimation();
                    this.epT.setAnimationUrl(string);
                    beE();
                    TiebaStatic.log(new an("c13248").dh("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.epT.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.epS.setVisibility(8);
                            MaintabBottomIndicator.this.epT.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.beF();
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
        am.a(this.epS, this.animationResId);
    }

    public void beG() {
        am.a(this.epS, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.epS.loop(false);
        playAnimation();
    }

    public void beH() {
        am.a(this.epS, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.epS.loop(true);
        playAnimation();
    }

    public void beI() {
        am.a(this.epS, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.epS.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.epS != null) {
            this.epS.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.epS.isAnimating();
    }

    public void ig(boolean z) {
        setAnimationResId(this.animationResId);
        this.epS.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.epS.playAnimation();
            return;
        }
        this.epS.cancelAnimation();
        this.epS.setFrame(0);
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
            if (this.dYn != 0) {
                am.setViewTextColor(this.mTextView, this.dYn);
            } else {
                am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            }
            if (this.animationResId != 0) {
                try {
                    am.a(this.epS, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.epS.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.epS.setAlpha(0.83f);
                    } else {
                        this.epS.setAlpha(1.0f);
                    }
                    beJ();
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
                this.epS.playAnimation();
                return;
            }
            this.epS.cancelAnimation();
            this.epS.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.epS.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void beJ() {
        if (this.epW && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.epX) {
            if (this.epY == 1) {
                ig(this.epX);
            } else if (this.epY == 2) {
                beG();
            }
        }
    }
}
