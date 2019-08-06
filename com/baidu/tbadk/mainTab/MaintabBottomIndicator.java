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
    private int bXh;
    private HashMap<String, TbFragmentTabIndicator.a> cxI;
    private int cxQ;
    private View cxR;
    private View cxS;
    private TBLottieAnimationView cxT;
    private OvalActionButton cxU;
    private TBLottieAnimationView cxV;
    private int cxW;
    private int cxX;
    private int cxx;
    private int kE;
    private e kI;
    private int mSkinType;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.cxx = 0;
        this.mSkinType = 3;
        this.cxI = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxx = 0;
        this.mSkinType = 3;
        this.cxI = new HashMap<>();
        this.kI = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cxx = 0;
        this.mSkinType = 3;
        this.cxI = new HashMap<>();
        this.kI = null;
        init();
    }

    private void init() {
        this.cxR = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.cxR.setLayoutParams(layoutParams);
        this.cxS = this.cxR.findViewById(R.id.container_common_item);
        this.cxT = (TBLottieAnimationView) this.cxR.findViewById(R.id.view_bottom_icon);
        this.cxT.setSpeed(1.2f);
        this.cxT.ayA();
        this.mTextView = (TextView) this.cxR.findViewById(R.id.view_bottom_text);
        this.cxU = (OvalActionButton) this.cxR.findViewById(R.id.view_write_icon);
        this.cxV = (TBLottieAnimationView) this.cxR.findViewById(R.id.animation_view);
        this.cxV.setFirstLoadInternal(true);
        addView(this.cxR);
        this.cxW = l.g(getContext(), R.dimen.tbds18);
        this.cxX = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxI.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxI.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.cxT != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.cye) {
                        left = this.mTextView.getRight() - this.cxW;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.cxx == 1) {
                        measuredHeight = this.cxT.getTop();
                        measuredHeight2 = this.cxX;
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
        this.cxx = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.cxI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.cxI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a qP(String str) {
        return this.cxI.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bXh = i;
    }

    public void setShowIconType(int i) {
        this.cxQ = i;
    }

    public void setWriteIconView() {
        this.cxS.setVisibility(8);
        this.cxU.setVisibility(0);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.cxV;
    }

    public void aqo() {
        if (this.cxV != null && this.cxV.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.cxV.startAnimation(scaleAnimation);
            this.cxV.setVisibility(4);
            this.cxT.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_lottie_show_count", 4);
        }
    }

    private void atY() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_lottie_show_count", 0);
        }
    }

    private void atZ() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aua() {
        int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.cxV.setFrame(this.cxV.getFrame());
        if (i >= 3) {
            aqo();
        }
    }

    public void onDestory() {
        if (this.cxV != null) {
            this.cxV.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.cxV != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!aq.isEmpty(string) || !z) {
                atY();
                if (ba.h(com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_lottie_show_count", 0) < 3) {
                    this.cxV.br();
                    this.cxV.setAnimationUrl(string);
                    atZ();
                    TiebaStatic.log(new an("c13248").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.cxV.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.cxT.setVisibility(8);
                            MaintabBottomIndicator.this.cxV.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.aua();
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
        am.a(this.cxT, this.kE);
    }

    public void aub() {
        am.a(this.cxT, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.cxT.y(false);
        br();
    }

    public void auc() {
        am.a(this.cxT, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.cxT.y(true);
        br();
    }

    public void aud() {
        am.a(this.cxT, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.cxT.y(false);
        br();
    }

    public void br() {
        if (this.cxT != null) {
            this.cxT.br();
        }
    }

    public boolean isAnimating() {
        return this.cxT.isAnimating();
    }

    public void fu(boolean z) {
        setAnimationResId(this.kE);
        this.cxT.y(false);
        setText(R.string.home_recommend);
        if (z) {
            this.cxT.br();
            return;
        }
        this.cxT.cancelAnimation();
        this.cxT.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        jd(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void jd(int i) {
        super.jd(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cxI.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.jd(i);
                }
            }
        }
        if (this.cxU != null) {
            this.cxU.onChangeSkinType(i);
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bXh != 0) {
                am.j(this.mTextView, this.bXh);
            } else {
                am.j(this.mTextView, R.color.cp_cont_f);
            }
            if (this.kE != 0) {
                try {
                    am.a(this.cxT, this.kE);
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
                this.cxT.br();
                return;
            }
            this.cxT.cancelAnimation();
            this.cxT.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.cxT.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
