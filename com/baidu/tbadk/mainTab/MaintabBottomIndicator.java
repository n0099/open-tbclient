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
import com.baidu.tbadk.core.util.ba;
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
    private int bXb;
    private HashMap<String, TbFragmentTabIndicator.a> cxB;
    private int cxJ;
    private View cxK;
    private View cxL;
    private TBLottieAnimationView cxM;
    private OvalActionButton cxN;
    private TBLottieAnimationView cxO;
    private int cxP;
    private int cxQ;
    private int cxq;
    private int kE;
    private e kI;
    private int mSkinType;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.cxq = 0;
        this.mSkinType = 3;
        this.cxB = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxq = 0;
        this.mSkinType = 3;
        this.cxB = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxq = 0;
        this.mSkinType = 3;
        this.cxB = new HashMap<>();
        this.kI = null;
        init();
    }

    private void init() {
        this.cxK = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.cxK.setLayoutParams(layoutParams);
        this.cxL = this.cxK.findViewById(R.id.container_common_item);
        this.cxM = (TBLottieAnimationView) this.cxK.findViewById(R.id.view_bottom_icon);
        this.cxM.setSpeed(1.2f);
        this.cxM.ayy();
        this.mTextView = (TextView) this.cxK.findViewById(R.id.view_bottom_text);
        this.cxN = (OvalActionButton) this.cxK.findViewById(R.id.view_write_icon);
        this.cxO = (TBLottieAnimationView) this.cxK.findViewById(R.id.animation_view);
        this.cxO.setFirstLoadInternal(true);
        addView(this.cxK);
        this.cxP = l.g(getContext(), R.dimen.tbds18);
        this.cxQ = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxB.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxB.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.cxM != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.cxX) {
                        left = this.mTextView.getRight() - this.cxP;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.cxq == 1) {
                        measuredHeight = this.cxM.getTop();
                        measuredHeight2 = this.cxQ;
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
        this.cxq = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.cxB.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.cxB.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a qP(String str) {
        return this.cxB.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bXb = i;
    }

    public void setShowIconType(int i) {
        this.cxJ = i;
    }

    public void setWriteIconView() {
        this.cxL.setVisibility(8);
        this.cxN.setVisibility(0);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.cxO;
    }

    public void aqm() {
        if (this.cxO != null && this.cxO.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.cxO.startAnimation(scaleAnimation);
            this.cxO.setVisibility(4);
            this.cxM.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_lottie_show_count", 4);
        }
    }

    private void atW() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahO().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_lottie_show_count", 0);
        }
    }

    private void atX() {
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atY() {
        int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.cxO.setFrame(this.cxO.getFrame());
        if (i >= 3) {
            aqm();
        }
    }

    public void onDestory() {
        if (this.cxO != null) {
            this.cxO.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.cxO != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!aq.isEmpty(string) || !z) {
                atW();
                if (ba.h(com.baidu.tbadk.core.sharedPref.b.ahO().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.ahO().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_lottie_show_count", 0) < 3) {
                    this.cxO.br();
                    this.cxO.setAnimationUrl(string);
                    atX();
                    TiebaStatic.log(new an("c13248").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.cxO.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.cxM.setVisibility(8);
                            MaintabBottomIndicator.this.cxO.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.atY();
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
        am.a(this.cxM, this.kE);
    }

    public void atZ() {
        am.a(this.cxM, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.cxM.y(false);
        br();
    }

    public void aua() {
        am.a(this.cxM, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.cxM.y(true);
        br();
    }

    public void aub() {
        am.a(this.cxM, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.cxM.y(false);
        br();
    }

    public void br() {
        if (this.cxM != null) {
            this.cxM.br();
        }
    }

    public boolean isAnimating() {
        return this.cxM.isAnimating();
    }

    public void fu(boolean z) {
        setAnimationResId(this.kE);
        this.cxM.y(false);
        setText(R.string.home_recommend);
        if (z) {
            this.cxM.br();
            return;
        }
        this.cxM.cancelAnimation();
        this.cxM.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        jc(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void jc(int i) {
        super.jc(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxB.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.jc(i);
                }
            }
        }
        if (this.cxN != null) {
            this.cxN.onChangeSkinType(i);
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bXb != 0) {
                am.j(this.mTextView, this.bXb);
            } else {
                am.j(this.mTextView, R.color.cp_cont_f);
            }
            if (this.kE != 0) {
                try {
                    am.a(this.cxM, this.kE);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void ft(boolean z) {
        super.ft(z);
        if (this.kE != 0) {
            if (z) {
                this.cxM.br();
                return;
            }
            this.cxM.cancelAnimation();
            this.cxM.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.cxM.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
