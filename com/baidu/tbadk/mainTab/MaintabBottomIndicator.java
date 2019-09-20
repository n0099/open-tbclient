package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int bYa;
    private HashMap<String, TbFragmentTabIndicator.a> cyE;
    private int cyM;
    private View cyN;
    private View cyO;
    private TBLottieAnimationView cyP;
    private OvalActionButton cyQ;
    private TBLottieAnimationView cyR;
    private int cyS;
    private int cyT;
    private int cyt;
    private int kE;
    private e kI;
    private int mSkinType;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.cyt = 0;
        this.mSkinType = 3;
        this.cyE = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyt = 0;
        this.mSkinType = 3;
        this.cyE = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyt = 0;
        this.mSkinType = 3;
        this.cyE = new HashMap<>();
        this.kI = null;
        init();
    }

    private void init() {
        this.cyN = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.cyN.setLayoutParams(layoutParams);
        this.cyO = this.cyN.findViewById(R.id.container_common_item);
        this.cyP = (TBLottieAnimationView) this.cyN.findViewById(R.id.view_bottom_icon);
        this.cyP.setSpeed(1.2f);
        this.cyP.ayM();
        this.mTextView = (TextView) this.cyN.findViewById(R.id.view_bottom_text);
        this.cyQ = (OvalActionButton) this.cyN.findViewById(R.id.view_write_icon);
        this.cyR = (TBLottieAnimationView) this.cyN.findViewById(R.id.animation_view);
        this.cyR.setFirstLoadInternal(true);
        addView(this.cyN);
        this.cyS = l.g(getContext(), R.dimen.tbds18);
        this.cyT = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cyE.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cyE.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.cyP != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.cza) {
                        left = this.mTextView.getRight() - this.cyS;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.cyt == 1) {
                        measuredHeight = this.cyP.getTop();
                        measuredHeight2 = this.cyT;
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
        this.cyt = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.cyE.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.cyE.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a ra(String str) {
        return this.cyE.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bYa = i;
    }

    public void setShowIconType(int i) {
        this.cyM = i;
    }

    public void setWriteIconView() {
        this.cyO.setVisibility(8);
        this.cyQ.setVisibility(0);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.cyR;
    }

    public void aqA() {
        if (this.cyR != null && this.cyR.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.cyR.startAnimation(scaleAnimation);
            this.cyR.setVisibility(4);
            this.cyP.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_lottie_show_count", 4);
        }
    }

    private void auk() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_lottie_show_count", 0);
        }
    }

    private void aul() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aum() {
        int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.cyR.setFrame(this.cyR.getFrame());
        if (i >= 3) {
            aqA();
        }
    }

    public void onDestory() {
        if (this.cyR != null) {
            this.cyR.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.cyR != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!aq.isEmpty(string) || !z) {
                auk();
                if (az.h(com.baidu.tbadk.core.sharedPref.b.ahU().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.ahU().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_lottie_show_count", 0) < 3) {
                    this.cyR.br();
                    this.cyR.setAnimationUrl(string);
                    aul();
                    TiebaStatic.log(new an("c13248").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.cyR.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.cyP.setVisibility(8);
                            MaintabBottomIndicator.this.cyR.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.aum();
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
        this.kE = i;
        am.a(this.cyP, this.kE);
    }

    public void aun() {
        am.a(this.cyP, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.cyP.y(false);
        br();
    }

    public void auo() {
        am.a(this.cyP, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.cyP.y(true);
        br();
    }

    public void aup() {
        am.a(this.cyP, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.cyP.y(false);
        br();
    }

    public void br() {
        if (this.cyP != null) {
            this.cyP.br();
        }
    }

    public boolean isAnimating() {
        return this.cyP.isAnimating();
    }

    public void fx(boolean z) {
        setAnimationResId(this.kE);
        this.cyP.y(false);
        setText(R.string.home_recommend);
        if (z) {
            this.cyP.br();
            return;
        }
        this.cyP.cancelAnimation();
        this.cyP.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void jg(int i) {
        super.jg(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cyE.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.jg(i);
                }
            }
        }
        if (this.cyQ != null) {
            this.cyQ.onChangeSkinType(i);
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bYa != 0) {
                am.j(this.mTextView, this.bYa);
            } else {
                am.j(this.mTextView, R.color.cp_cont_f);
            }
            if (this.kE != 0) {
                try {
                    am.a(this.cyP, this.kE);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void fw(boolean z) {
        super.fw(z);
        if (this.kE != 0) {
            if (z) {
                this.cyP.br();
                return;
            }
            this.cyP.cancelAnimation();
            this.cyP.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.cyP.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
