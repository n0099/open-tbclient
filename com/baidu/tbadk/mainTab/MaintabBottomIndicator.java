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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bc;
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
    private View eEY;
    private View eEZ;
    private TBLottieAnimationView eFa;
    private TBLottieAnimationView eFb;
    private int eFc;
    private int eFd;
    public boolean eFe;
    public boolean eFf;
    public int eFg;
    private int emy;
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
        this.eFe = false;
        this.eFf = true;
        this.eFg = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.eFe = false;
        this.eFf = true;
        this.eFg = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.eFe = false;
        this.eFf = true;
        this.eFg = 1;
        init();
    }

    private void init() {
        this.eEY = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.eEY.setLayoutParams(layoutParams);
        this.eEZ = this.eEY.findViewById(R.id.container_common_item);
        this.eFa = (TBLottieAnimationView) this.eEY.findViewById(R.id.view_bottom_icon);
        this.eFa.setSpeed(1.1f);
        this.eFa.boz();
        this.mTextView = (TextView) this.eEY.findViewById(R.id.view_bottom_text);
        this.eFb = (TBLottieAnimationView) this.eEY.findViewById(R.id.animation_view);
        this.eFb.setFirstLoadInternal(true);
        addView(this.eEY);
        this.eFc = l.getDimens(getContext(), R.dimen.tbds18);
        this.eFd = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.eFa != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.eFc;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.eFa.getTop();
                        measuredHeight2 = this.eFd;
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
    public TbFragmentTabIndicator.a zY(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.emy = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.eEZ.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.eFb;
    }

    public void bks() {
        if (this.eFb != null && this.eFb.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.eFb.startAnimation(scaleAnimation);
            this.eFb.setVisibility(4);
            this.eFa.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_lottie_show_count", 4);
        }
    }

    private void bkt() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_lottie_show_count", 0);
        }
    }

    private void bku() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkv() {
        int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.aZP().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.eFb.setFrame(this.eFb.getFrame());
        if (i >= 3) {
            bks();
        }
    }

    public void onDestory() {
        if (this.eFb != null) {
            this.eFb.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.eFb != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!as.isEmpty(string) || !z) {
                bkt();
                if (bc.v(com.baidu.tbadk.core.sharedPref.b.aZP().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.aZP().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_lottie_show_count", 0) < 3) {
                    this.eFb.playAnimation();
                    this.eFb.setAnimationUrl(string);
                    bku();
                    TiebaStatic.log(new ap("c13248").dn("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.eFb.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.eFa.setVisibility(8);
                            MaintabBottomIndicator.this.eFb.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bkv();
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
        ao.a(this.eFa, this.animationResId);
    }

    public void bkw() {
        ao.a(this.eFa, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.eFa.loop(false);
        playAnimation();
    }

    public void bkx() {
        ao.a(this.eFa, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.eFa.loop(true);
        playAnimation();
    }

    public void bky() {
        ao.a(this.eFa, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.eFa.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.eFa != null) {
            this.eFa.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.eFa.isAnimating();
    }

    public void iU(boolean z) {
        setAnimationResId(this.animationResId);
        this.eFa.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.eFa.playAnimation();
            return;
        }
        this.eFa.cancelAnimation();
        this.eFa.setFrame(0);
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
            if (this.emy != 0) {
                ao.setViewTextColor(this.mTextView, this.emy);
            } else {
                ao.setViewTextColor(this.mTextView, R.color.cp_cont_f);
            }
            if (this.animationResId != 0) {
                try {
                    ao.a(this.eFa, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.eFa.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.eFa.setAlpha(0.83f);
                    } else {
                        this.eFa.setAlpha(1.0f);
                    }
                    bkz();
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
                this.eFa.playAnimation();
                return;
            }
            this.eFa.cancelAnimation();
            this.eFa.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.eFa.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bkz() {
        if (this.eFe && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.eFf) {
            if (this.eFg == 1) {
                iU(this.eFf);
            } else if (this.eFg == 2) {
                bkw();
            }
        }
    }
}
