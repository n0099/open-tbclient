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
    private int dJT;
    private View ebA;
    private TBLottieAnimationView ebB;
    private TBLottieAnimationView ebC;
    private int ebD;
    private int ebE;
    public boolean ebF;
    public boolean ebG;
    public int ebH;
    private View ebz;
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
        this.ebF = false;
        this.ebG = true;
        this.ebH = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.ebF = false;
        this.ebG = true;
        this.ebH = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.ebF = false;
        this.ebG = true;
        this.ebH = 1;
        init();
    }

    private void init() {
        this.ebz = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.ebz.setLayoutParams(layoutParams);
        this.ebA = this.ebz.findViewById(R.id.container_common_item);
        this.ebB = (TBLottieAnimationView) this.ebz.findViewById(R.id.view_bottom_icon);
        this.ebB.setSpeed(1.1f);
        this.ebB.bbX();
        this.mTextView = (TextView) this.ebz.findViewById(R.id.view_bottom_text);
        this.ebC = (TBLottieAnimationView) this.ebz.findViewById(R.id.animation_view);
        this.ebC.setFirstLoadInternal(true);
        addView(this.ebz);
        this.ebD = l.getDimens(getContext(), R.dimen.tbds18);
        this.ebE = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.ebB != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.ebD;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.ebB.getTop();
                        measuredHeight2 = this.ebE;
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
    public TbFragmentTabIndicator.a wP(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.dJT = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.ebA.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.ebC;
    }

    public void aVk() {
        if (this.ebC != null && this.ebC.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.ebC.startAnimation(scaleAnimation);
            this.ebC.setVisibility(4);
            this.ebB.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_lottie_show_count", 4);
        }
    }

    private void aYu() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aNV().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_lottie_show_count", 0);
        }
    }

    private void aYv() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYw() {
        int i = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.aNV().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.ebC.setFrame(this.ebC.getFrame());
        if (i >= 3) {
            aVk();
        }
    }

    public void onDestory() {
        if (this.ebC != null) {
            this.ebC.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.ebC != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!aq.isEmpty(string) || !z) {
                aYu();
                if (az.t(com.baidu.tbadk.core.sharedPref.b.aNV().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.aNV().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_lottie_show_count", 0) < 3) {
                    this.ebC.playAnimation();
                    this.ebC.setAnimationUrl(string);
                    aYv();
                    TiebaStatic.log(new an("c13248").cI("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.ebC.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.ebB.setVisibility(8);
                            MaintabBottomIndicator.this.ebC.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.aYw();
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
        am.a(this.ebB, this.animationResId);
    }

    public void aYx() {
        am.a(this.ebB, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.ebB.loop(false);
        playAnimation();
    }

    public void aYy() {
        am.a(this.ebB, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.ebB.loop(true);
        playAnimation();
    }

    public void aYz() {
        am.a(this.ebB, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.ebB.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.ebB != null) {
            this.ebB.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.ebB.isAnimating();
    }

    public void hK(boolean z) {
        setAnimationResId(this.animationResId);
        this.ebB.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.ebB.playAnimation();
            return;
        }
        this.ebB.cancelAnimation();
        this.ebB.setFrame(0);
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
            if (this.dJT != 0) {
                am.setViewTextColor(this.mTextView, this.dJT);
            } else {
                am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_f);
            }
            if (this.animationResId != 0) {
                try {
                    am.a(this.ebB, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.ebB.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.ebB.setAlpha(0.83f);
                    } else {
                        this.ebB.setAlpha(1.0f);
                    }
                    aYA();
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
                this.ebB.playAnimation();
                return;
            }
            this.ebB.cancelAnimation();
            this.ebB.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.ebB.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void aYA() {
        if (this.ebF && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.ebG) {
            if (this.ebH == 1) {
                hK(this.ebG);
            } else if (this.ebH == 2) {
                aYx();
            }
        }
    }
}
