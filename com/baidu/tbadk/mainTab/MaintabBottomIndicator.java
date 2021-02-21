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
    private com.airbnb.lottie.d BJ;
    private int animationResId;
    private View fHe;
    private View fHf;
    private TBLottieAnimationView fHg;
    private TBLottieAnimationView fHh;
    private TbImageView fHi;
    private View fHj;
    private int fHk;
    private int fHl;
    public boolean fHm;
    public boolean fHn;
    public int fHo;
    private int fnb;
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
        this.BJ = null;
        this.fHm = false;
        this.fHn = true;
        this.fHo = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.BJ = null;
        this.fHm = false;
        this.fHn = true;
        this.fHo = 1;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTipPosType = 0;
        this.mSkinType = 3;
        this.mTips = new HashMap<>();
        this.BJ = null;
        this.fHm = false;
        this.fHn = true;
        this.fHo = 1;
        init();
    }

    private void init() {
        this.fHe = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fHe.setLayoutParams(layoutParams);
        this.fHf = this.fHe.findViewById(R.id.container_common_item);
        this.fHg = (TBLottieAnimationView) this.fHe.findViewById(R.id.view_bottom_icon);
        this.fHg.setSpeed(1.1f);
        this.fHg.bHp();
        this.fHi = (TbImageView) this.fHe.findViewById(R.id.image_icon);
        this.fHi.setRadius(50);
        this.fHi.setDefaultBgResource(R.color.transparent);
        this.fHi.setConrers(15);
        this.mTextView = (TextView) this.fHe.findViewById(R.id.view_bottom_text);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams();
        marginLayoutParams.topMargin = -l.getDimens(getContext(), R.dimen.M_H_X001);
        this.mTextView.setLayoutParams(marginLayoutParams);
        this.fHh = (TBLottieAnimationView) this.fHe.findViewById(R.id.animation_view);
        this.fHh.setFirstLoadInternal(true);
        this.fHj = this.fHe.findViewById(R.id.bar_cross_line);
        addView(this.fHe);
        this.fHk = l.getDimens(getContext(), R.dimen.tbds18);
        this.fHl = l.getDimens(getContext(), R.dimen.tbds10);
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
            while (it.hasNext() && this.mTextView != null && this.fHg != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.isRight) {
                        left = this.mTextView.getRight() - this.fHk;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.mTipPosType == 1) {
                        measuredHeight = this.fHg.getTop();
                        measuredHeight2 = this.fHl;
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
    public TbFragmentTabIndicator.a Dl(String str) {
        return this.mTips.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.fnb = i;
    }

    public void setShowIconType(int i) {
        this.showIconType = i;
    }

    public void setWriteIconView() {
        this.fHf.setVisibility(8);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.fHh;
    }

    public void bCX() {
        if (this.fHh != null && this.fHh.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.fHh.startAnimation(scaleAnimation);
            this.fHh.setVisibility(4);
            this.fHg.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_lottie_show_count", 4);
        }
    }

    private void bCY() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_lottie_show_count", 0);
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.fHh.setFrame(this.fHh.getFrame());
        if (i >= 3) {
            bCX();
        }
    }

    public void onDestory() {
        if (this.fHh != null) {
            this.fHh.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.fHh != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!au.isEmpty(string) || !z) {
                bCY();
                if (be.z(com.baidu.tbadk.core.sharedPref.b.brQ().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.brQ().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_lottie_show_count", 0) < 3) {
                    this.fHh.playAnimation();
                    this.fHh.setAnimationUrl(string);
                    bCZ();
                    TiebaStatic.log(new ar("c13248").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.fHh.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.fHg.setVisibility(8);
                            MaintabBottomIndicator.this.fHh.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.bDa();
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
        ap.a(this.fHg, this.animationResId);
    }

    public void setImageIconUrl(String str, final String str2) {
        if (!au.isEmpty(str)) {
            this.fHi.setVisibility(8);
            this.fHi.setEvent(new TbImageView.b() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str3, boolean z) {
                    if (z) {
                        MaintabBottomIndicator.this.fHi.setVisibility(0);
                        if (!au.isEmpty(str2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, str2));
                        }
                        MaintabBottomIndicator.this.fHi.setEvent(null);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
            this.fHi.startLoad(str, 10, false);
        }
    }

    public void bDb() {
        ap.a(this.fHg, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.fHg.loop(false);
        playAnimation();
    }

    public void bDc() {
        ap.a(this.fHg, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.fHg.loop(true);
        playAnimation();
    }

    public void bDd() {
        ap.a(this.fHg, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.fHg.loop(false);
        playAnimation();
    }

    public void playAnimation() {
        if (this.fHg != null) {
            this.fHg.playAnimation();
        }
    }

    public boolean isAnimating() {
        return this.fHg.isAnimating();
    }

    public void le(boolean z) {
        setAnimationResId(this.animationResId);
        this.fHg.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.fHg.playAnimation();
            return;
        }
        this.fHg.cancelAnimation();
        this.fHg.setFrame(0);
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
            if (this.fnb != 0) {
                ap.setViewTextColor(this.mTextView, this.fnb);
            } else {
                ap.setViewTextColor(this.mTextView, R.color.CAM_X0107);
            }
            if (this.animationResId != 0) {
                try {
                    ap.a(this.fHg, this.animationResId);
                    if (this.mSkinType == 1) {
                        this.fHg.setAlpha(0.66f);
                    } else if (this.mSkinType == 4) {
                        this.fHg.setAlpha(0.83f);
                    } else {
                        this.fHg.setAlpha(1.0f);
                    }
                    bDe();
                } catch (Exception e) {
                }
            }
        }
        ap.setBackgroundColor(this.fHj, R.color.CAM_X0203, i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        super.onTabSelected(z);
        if (this.animationResId != 0) {
            if (z) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.mTextView).oa(R.string.F_X02);
                this.fHi.setVisibility(8);
                this.fHg.playAnimation();
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
            this.fHg.cancelAnimation();
            this.fHg.setFrame(0);
            com.baidu.tbadk.core.elementsMaven.c.br(this.mTextView).oa(R.string.F_X01);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.fHg.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }

    private void bDe() {
        if (this.fHm && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && this.fHn) {
            if (this.fHo == 1) {
                le(this.fHn);
            } else if (this.fHo == 2) {
                bDb();
            }
        }
    }
}
