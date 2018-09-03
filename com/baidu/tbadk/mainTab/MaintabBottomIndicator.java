package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private HashMap<String, TbFragmentTabIndicator.a> aRG;
    private int aRQ;
    private View aRR;
    private View aRS;
    private ImageView aRT;
    private TBLottieAnimationView aRU;
    private int aRV;
    private int aRW;
    private int aRX;
    private int aRY;
    private AnimationDrawable aRZ;
    private int aRv;
    private int jU;
    private ImageView mIconView;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aRv = 0;
        this.aRG = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aRv = 0;
        this.aRG = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aRv = 0;
        this.aRG = new HashMap<>();
        init();
    }

    private void init() {
        this.aRR = LayoutInflater.from(getContext()).inflate(f.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aRR.setLayoutParams(layoutParams);
        this.aRS = this.aRR.findViewById(f.g.container_common_item);
        this.mIconView = (ImageView) this.aRR.findViewById(f.g.view_bottom_icon);
        this.mTextView = (TextView) this.aRR.findViewById(f.g.view_bottom_text);
        this.aRT = (ImageView) this.aRR.findViewById(f.g.view_write_icon);
        this.aRU = (TBLottieAnimationView) this.aRR.findViewById(f.g.animation_view);
        this.aRU.setFirstLoadInternal(true);
        addView(this.aRR);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRG.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRG.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.aSc) {
                        left = this.mTextView.getRight() - ((int) (this.mTextView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aRv == 1) {
                        measuredHeight = this.mIconView.getTop();
                        measuredHeight2 = measuredHeight3 / 4;
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
        this.aRv = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aRG.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.aRG.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hl(String str) {
        return this.aRG.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aRW = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aRV = i;
    }

    public void setShowIconType(int i) {
        this.aRQ = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.aRS.setVisibility(8);
        this.aRT.setVisibility(0);
        am.c(this.aRT, i);
        am.i(this.aRT, i2);
        this.aRX = i;
        this.aRY = i2;
    }

    public TBLottieAnimationView getAnimationView() {
        return this.aRU;
    }

    public void Js() {
        if (this.aRU != null && this.aRU.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.aRU.startAnimation(scaleAnimation);
            this.aRU.setVisibility(4);
            this.mIconView.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void Jt() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void Ju() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.aRU.setFrame(this.aRU.getFrame());
        if (i >= 3) {
            Js();
        }
    }

    public void onDestory() {
        if (this.aRU != null) {
            this.aRU.aY();
        }
    }

    public void setLottieView(boolean z) {
        if (this.aRU != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ap.isEmpty(string) || !z) {
                Jt();
                if (ay.c(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.aRU.aX();
                    this.aRU.setAnimationUrl(string);
                    Ju();
                    TiebaStatic.log(new an("c13248").ae("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.aRU.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.mIconView.setVisibility(8);
                            MaintabBottomIndicator.this.aRU.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.Jv();
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
        this.jU = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dF(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void dF(int i) {
        super.dF(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aRG.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.dF(i);
                }
            }
        }
        if (this.aRQ == c.aRM) {
            am.c(this.aRT, this.aRX);
            am.i(this.aRT, this.aRY);
            return;
        }
        if (this.aRV != 0) {
            am.h(this.mTextView, this.aRV);
        } else {
            am.h(this.mTextView, f.d.cp_cont_f);
        }
        if (this.aRW != 0) {
            am.c(this.mIconView, this.aRW);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void bP(boolean z) {
        super.bP(z);
        if (this.jU != 0) {
            if (z) {
                am.c(this.mIconView, this.jU);
                this.aRZ = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.aRZ != null) {
                    this.aRZ.start();
                    return;
                }
                return;
            }
            if (this.aRZ != null) {
                this.aRZ.stop();
            }
            if (this.aRW != 0) {
                am.c(this.mIconView, this.aRW);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
