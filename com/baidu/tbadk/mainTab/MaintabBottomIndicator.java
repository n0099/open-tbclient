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
    private int eYm;
    private View fsf;
    private View fsg;
    private TBLottieAnimationView fsh;
    private TBLottieAnimationView fsi;
    private TbImageView fsj;
    private View fsk;
    private int fsl;
    private int fsm;
    public boolean fsn;
    public boolean fso;
    public int fsp;
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
        this.fsn = false;
        this.fso = true;
        this.fsp = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fsn = false;
        this.fso = true;
        this.fsp = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.composition = null;
        this.fsn = false;
        this.fso = true;
        this.fsp = 1;
        init();
    }

    private void init() {
        this.fsf = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fsf.setLayoutParams(layoutParams);
        this.fsg = this.fsf.findViewById(R.id.container_common_item);
        this.fsh = (TBLottieAnimationView) this.fsf.findViewById(R.id.view_bottom_icon);
        this.fsh.setSpeed(1.1f);
        this.fsh.bER();
        this.fsj = (TbImageView) this.fsf.findViewById(R.id.image_icon);
        this.fsj.setRadius(50);
        this.fsj.setConrers(15);
        this.mTextView = (TextView) this.fsf.findViewById(R.id.view_bottom_text);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams();
        marginLayoutParams.topMargin = -l.getDimens(getContext(), R.dimen.M_H_X001);
        this.mTextView.setLayoutParams(marginLayoutParams);
        this.fsi = (TBLottieAnimationView) this.fsf.findViewById(R.id.animation_view);
        this.fsi.setFirstLoadInternal(true);
        this.fsk = this.fsf.findViewById(R.id.bar_cross_line);
        addView(this.fsf);
        this.fsl = l.getDimens(getContext(), R.dimen.tbds18);
        this.fsm = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.fsh != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.fsl;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.fsh.getTop();
                        measuredHeight2 = this.fsm;
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
    public TbFragmentTabIndicator.a DD(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.eYm = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.fsg.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.fsi;
    }

    public void bAB() {
        if (this.fsi != null && this.fsi.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.fsi.startAnimation(scaleAnimation);
            this.fsi.setVisibility(4);
            this.fsh.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_lottie_show_count", 4);
        }
    }

    private void bAC() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_lottie_show_count", 0);
        }
    }

    private void bAD() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAE() {
        int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.bpu().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.fsi.setFrame(this.fsi.getFrame());
        if (i >= 3) {
            bAB();
        }
    }

    public void onDestory() {
        if (this.fsi != null) {
            this.fsi.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.fsi != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!au.isEmpty(string) || !z) {
                bAC();
                if (be.s(com.baidu.tbadk.core.sharedPref.b.bpu().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.bpu().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_lottie_show_count", 0) < 3) {
                    this.fsi.playAnimation();
                    this.fsi.setAnimationUrl(string);
                    bAD();
                    TiebaStatic.log(new ar("c13248").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.fsi.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.fsh.setVisibility(8);
                            MaintabBottomIndicator.this.fsi.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bAE();
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
        ap.a(this.fsh, this.animationResId);
    }

    public void setImageIconUrl(String str, final String str2) {
        if (!au.isEmpty(str)) {
            this.fsj.setVisibility(8);
            this.fsj.setEvent(new TbImageView.a() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str3, boolean z) {
                    if (z) {
                        MaintabBottomIndicator.this.fsj.setVisibility(0);
                        if (!au.isEmpty(str2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, str2));
                        }
                        MaintabBottomIndicator.this.fsj.setEvent(null);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
            this.fsj.startLoad(str, 10, false);
        }
    }

    public void bAF() {
        ap.a(this.fsh, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.fsh.loop(false);
        playAnimation();
    }

    public void bAG() {
        ap.a(this.fsh, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.fsh.loop(true);
        playAnimation();
    }

    public void bAH() {
        ap.a(this.fsh, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.fsh.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.fsh != null) {
            this.fsh.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.fsh.isAnimating();
    }

    public void kq(boolean z) {
        setAnimationResId(this.animationResId);
        this.fsh.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.fsh.playAnimation();
            return;
        }
        this.fsh.cancelAnimation();
        this.fsh.setFrame(0);
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
            if (this.eYm != 0) {
                ap.setViewTextColor(this.mTextView, this.eYm);
            } else {
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0107);
            }
            if (this.animationResId != 0) {
                try {
                    ap.a(this.fsh, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.fsh.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.fsh.setAlpha(0.83f);
                    } else {
                        this.fsh.setAlpha(1.0f);
                    }
                    bAI();
                } catch (Exception e) {
                }
            }
        }
        ap.setBackgroundColor(this.fsk, R.color.CAM_X0203, i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
        if (this.animationResId != 0) {
            if (z) {
                com.baidu.tbadk.core.elementsMaven.c.bj(this.mTextView).oV(R.string.F_X02);
                this.fsj.setVisibility(8);
                this.fsh.playAnimation();
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
            this.fsh.cancelAnimation();
            this.fsh.setFrame(0);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.mTextView).oV(R.string.F_X01);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.fsh.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bAI() {
        if (this.fsn && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.fso) {
            if (this.fsp == 1) {
                kq(this.fso);
            } else if (this.fsp == 2) {
                bAF();
            }
        }
    }
}
