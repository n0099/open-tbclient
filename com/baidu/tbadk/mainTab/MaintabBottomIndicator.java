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
    private e composition;
    private View ePE;
    private View ePF;
    private TBLottieAnimationView ePG;
    private TBLottieAnimationView ePH;
    private TbImageView ePI;
    private int ePJ;
    private int ePK;
    public boolean ePL;
    public boolean ePM;
    public int ePN;
    private int ewF;
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
        this.ePL = false;
        this.ePM = true;
        this.ePN = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.ePL = false;
        this.ePM = true;
        this.ePN = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.ePL = false;
        this.ePM = true;
        this.ePN = 1;
        init();
    }

    private void init() {
        this.ePE = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.ePE.setLayoutParams(layoutParams);
        this.ePF = this.ePE.findViewById(R.id.container_common_item);
        this.ePG = (TBLottieAnimationView) this.ePE.findViewById(R.id.view_bottom_icon);
        this.ePG.setSpeed(1.1f);
        this.ePG.bxn();
        this.ePI = (TbImageView) this.ePE.findViewById(R.id.image_icon);
        this.ePI.setRadius(50);
        this.ePI.setConrers(15);
        this.mTextView = (TextView) this.ePE.findViewById(R.id.view_bottom_text);
        this.ePH = (TBLottieAnimationView) this.ePE.findViewById(R.id.animation_view);
        this.ePH.setFirstLoadInternal(true);
        addView(this.ePE);
        this.ePJ = l.getDimens(getContext(), R.dimen.tbds18);
        this.ePK = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.ePG != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.ePJ;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.ePG.getTop();
                        measuredHeight2 = this.ePK;
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
    public TbFragmentTabIndicator.a Cp(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.ewF = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.ePF.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.ePH;
    }

    public void btf() {
        if (this.ePH != null && this.ePH.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.ePH.startAnimation(scaleAnimation);
            this.ePH.setVisibility(4);
            this.ePG.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_lottie_show_count", 4);
        }
    }

    private void btg() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_lottie_show_count", 0);
        }
    }

    private void bth() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.bik().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.ePH.setFrame(this.ePH.getFrame());
        if (i >= 3) {
            btf();
        }
    }

    public void onDestory() {
        if (this.ePH != null) {
            this.ePH.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.ePH != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!at.isEmpty(string) || !z) {
                btg();
                if (bd.v(com.baidu.tbadk.core.sharedPref.b.bik().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.bik().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_lottie_show_count", 0) < 3) {
                    this.ePH.playAnimation();
                    this.ePH.setAnimationUrl(string);
                    bth();
                    TiebaStatic.log(new aq("c13248").dD("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.ePH.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.ePG.setVisibility(8);
                            MaintabBottomIndicator.this.ePH.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bti();
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
        ap.a(this.ePG, this.animationResId);
    }

    public void setImageIconUrl(String str, final String str2) {
        if (!at.isEmpty(str)) {
            this.ePI.setVisibility(8);
            this.ePI.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str3, boolean z) {
                    if (z) {
                        MaintabBottomIndicator.this.ePI.setVisibility(0);
                        if (!at.isEmpty(str2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, str2));
                        }
                        MaintabBottomIndicator.this.ePI.setEvent(null);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
            this.ePI.startLoad(str, 10, false);
        }
    }

    public void btj() {
        ap.a(this.ePG, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.ePG.loop(false);
        playAnimation();
    }

    public void btk() {
        ap.a(this.ePG, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.ePG.loop(true);
        playAnimation();
    }

    public void btl() {
        ap.a(this.ePG, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.ePG.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.ePG != null) {
            this.ePG.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.ePG.isAnimating();
    }

    public void ju(boolean z) {
        setAnimationResId(this.animationResId);
        this.ePG.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.ePG.playAnimation();
            return;
        }
        this.ePG.cancelAnimation();
        this.ePG.setFrame(0);
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
            if (this.ewF != 0) {
                ap.setViewTextColor(this.mTextView, this.ewF);
            } else {
                ap.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            }
            if (this.animationResId != 0) {
                try {
                    ap.a(this.ePG, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.ePG.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.ePG.setAlpha(0.83f);
                    } else {
                        this.ePG.setAlpha(1.0f);
                    }
                    btm();
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
                this.ePI.setVisibility(8);
                this.ePG.playAnimation();
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
            this.ePG.cancelAnimation();
            this.ePG.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.ePG.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void btm() {
        if (this.ePL && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.ePM) {
            if (this.ePN == 1) {
                ju(this.ePM);
            } else if (this.ePN == 2) {
                btj();
            }
        }
    }
}
