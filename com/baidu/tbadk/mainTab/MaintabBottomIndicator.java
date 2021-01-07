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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bd;
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
    private com.airbnb.lottie.d composition;
    private View fJA;
    private TBLottieAnimationView fJB;
    private TBLottieAnimationView fJC;
    private TbImageView fJD;
    private View fJE;
    private int fJF;
    private int fJG;
    public boolean fJH;
    public boolean fJI;
    public int fJJ;
    private View fJz;
    private int fpt;
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
        this.fJH = false;
        this.fJI = true;
        this.fJJ = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fJH = false;
        this.fJI = true;
        this.fJJ = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fJH = false;
        this.fJI = true;
        this.fJJ = 1;
        init();
    }

    private void init() {
        this.fJz = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fJz.setLayoutParams(layoutParams);
        this.fJA = this.fJz.findViewById(R.id.container_common_item);
        this.fJB = (TBLottieAnimationView) this.fJz.findViewById(R.id.view_bottom_icon);
        this.fJB.setSpeed(1.1f);
        this.fJB.bKN();
        this.fJD = (TbImageView) this.fJz.findViewById(R.id.image_icon);
        this.fJD.setRadius(50);
        this.fJD.setDefaultBgResource(R.color.transparent);
        this.fJD.setConrers(15);
        this.mTextView = (TextView) this.fJz.findViewById(R.id.view_bottom_text);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams();
        marginLayoutParams.topMargin = -l.getDimens(getContext(), R.dimen.M_H_X001);
        this.mTextView.setLayoutParams(marginLayoutParams);
        this.fJC = (TBLottieAnimationView) this.fJz.findViewById(R.id.animation_view);
        this.fJC.setFirstLoadInternal(true);
        this.fJE = this.fJz.findViewById(R.id.bar_cross_line);
        addView(this.fJz);
        this.fJF = l.getDimens(getContext(), R.dimen.tbds18);
        this.fJG = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.fJB != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.fJF;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.fJB.getTop();
                        measuredHeight2 = this.fJG;
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
    public TbFragmentTabIndicator.a Eh(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.fpt = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.fJA.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.fJC;
    }

    public void bGy() {
        if (this.fJC != null && this.fJC.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.fJC.startAnimation(scaleAnimation);
            this.fJC.setVisibility(4);
            this.fJB.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_lottie_show_count", 4);
        }
    }

    private void bGz() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvr().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_lottie_show_count", 0);
        }
    }

    private void bGA() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGB() {
        int i = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.bvr().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.fJC.setFrame(this.fJC.getFrame());
        if (i >= 3) {
            bGy();
        }
    }

    public void onDestory() {
        if (this.fJC != null) {
            this.fJC.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.fJC != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!at.isEmpty(string) || !z) {
                bGz();
                if (bd.v(com.baidu.tbadk.core.sharedPref.b.bvr().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.bvr().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_lottie_show_count", 0) < 3) {
                    this.fJC.playAnimation();
                    this.fJC.setAnimationUrl(string);
                    bGA();
                    TiebaStatic.log(new aq("c13248").dX("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.fJC.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.fJB.setVisibility(8);
                            MaintabBottomIndicator.this.fJC.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bGB();
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
        ao.a(this.fJB, this.animationResId);
    }

    public void setImageIconUrl(String str, final String str2) {
        if (!at.isEmpty(str)) {
            this.fJD.setVisibility(8);
            this.fJD.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str3, boolean z) {
                    if (z) {
                        MaintabBottomIndicator.this.fJD.setVisibility(0);
                        if (!at.isEmpty(str2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, str2));
                        }
                        MaintabBottomIndicator.this.fJD.setEvent(null);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
            this.fJD.startLoad(str, 10, false);
        }
    }

    public void bGC() {
        ao.a(this.fJB, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.fJB.loop(false);
        playAnimation();
    }

    public void bGD() {
        ao.a(this.fJB, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.fJB.loop(true);
        playAnimation();
    }

    public void bGE() {
        ao.a(this.fJB, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.fJB.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.fJB != null) {
            this.fJB.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.fJB.isAnimating();
    }

    public void lf(boolean z) {
        setAnimationResId(this.animationResId);
        this.fJB.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.fJB.playAnimation();
            return;
        }
        this.fJB.cancelAnimation();
        this.fJB.setFrame(0);
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
            if (this.fpt != 0) {
                ao.setViewTextColor(this.mTextView, this.fpt);
            } else {
                ao.setViewTextColor(this.mTextView, R.color.CAM_X0107);
            }
            if (this.animationResId != 0) {
                try {
                    ao.a(this.fJB, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.fJB.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.fJB.setAlpha(0.83f);
                    } else {
                        this.fJB.setAlpha(1.0f);
                    }
                    bGF();
                } catch (Exception e) {
                }
            }
        }
        ao.setBackgroundColor(this.fJE, R.color.CAM_X0203, i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
        if (this.animationResId != 0) {
            if (z) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.mTextView).pE(R.string.F_X02);
                this.fJD.setVisibility(8);
                this.fJB.playAnimation();
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
            this.fJB.cancelAnimation();
            this.fJB.setFrame(0);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mTextView).pE(R.string.F_X01);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.fJB.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bGF() {
        if (this.fJH && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.fJI) {
            if (this.fJJ == 1) {
                lf(this.fJI);
            } else if (this.fJJ == 2) {
                bGC();
            }
        }
    }
}
