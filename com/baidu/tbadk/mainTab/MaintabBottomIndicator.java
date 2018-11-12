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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int aBU;
    private int aZZ;
    private int baA;
    private AnimationDrawable baB;
    private HashMap<String, TbFragmentTabIndicator.a> bak;
    private int bat;
    private View bau;
    private View bav;
    private ImageView baw;
    private TBLottieAnimationView bax;
    private int bay;
    private int baz;
    private ImageView mIconView;
    private TextView mTextView;
    private int nk;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aZZ = 0;
        this.bak = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZZ = 0;
        this.bak = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZZ = 0;
        this.bak = new HashMap<>();
        init();
    }

    private void init() {
        this.bau = LayoutInflater.from(getContext()).inflate(e.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bau.setLayoutParams(layoutParams);
        this.bav = this.bau.findViewById(e.g.container_common_item);
        this.mIconView = (ImageView) this.bau.findViewById(e.g.view_bottom_icon);
        this.mTextView = (TextView) this.bau.findViewById(e.g.view_bottom_text);
        this.baw = (ImageView) this.bau.findViewById(e.g.view_write_icon);
        this.bax = (TBLottieAnimationView) this.bau.findViewById(e.g.animation_view);
        this.bax.setFirstLoadInternal(true);
        addView(this.bau);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bak.entrySet();
        if (entrySet != null && (r5 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.view.getLayoutParams();
                    if (layoutParams.width == -2) {
                        value.view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        value.view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width > size ? size : layoutParams.width, AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(layoutParams.height > size2 ? size2 : layoutParams.height, AiAppsFileUtils.GB));
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bak.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.baE) {
                        left = this.mTextView.getRight() - ((int) (this.mTextView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aZZ == 1) {
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
        this.aZZ = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bak.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bak.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hW(String str) {
        return this.bak.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.bay = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aBU = i;
    }

    public void setShowIconType(int i) {
        this.bat = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.bav.setVisibility(8);
        this.baw.setVisibility(0);
        al.c(this.baw, i);
        al.i(this.baw, i2);
        this.baz = i;
        this.baA = i2;
    }

    public TBLottieAnimationView getAnimationView() {
        return this.bax;
    }

    public void MP() {
        if (this.bax != null && this.bax.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.bax.startAnimation(scaleAnimation);
            this.bax.setVisibility(4);
            this.mIconView.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void MQ() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void MR() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.bax.setFrame(this.bax.getFrame());
        if (i >= 3) {
            MP();
        }
    }

    public void onDestory() {
        if (this.bax != null) {
            this.bax.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.bax != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ao.isEmpty(string) || !z) {
                MQ();
                if (ax.c(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.bax.cv();
                    this.bax.setAnimationUrl(string);
                    MR();
                    TiebaStatic.log(new am("c13248").ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.bax.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.mIconView.setVisibility(8);
                            MaintabBottomIndicator.this.bax.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.MS();
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
        this.nk = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eo(int i) {
        super.eo(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bak.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.eo(i);
                }
            }
        }
        if (this.bat == c.bao) {
            al.c(this.baw, this.baz);
            al.i(this.baw, this.baA);
            return;
        }
        if (this.aBU != 0) {
            al.h(this.mTextView, this.aBU);
        } else {
            al.h(this.mTextView, e.d.cp_cont_f);
        }
        if (this.bay != 0) {
            al.c(this.mIconView, this.bay);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cB(boolean z) {
        super.cB(z);
        if (this.nk != 0) {
            if (z) {
                al.c(this.mIconView, this.nk);
                this.baB = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.baB != null) {
                    this.baB.start();
                    return;
                }
                return;
            }
            if (this.baB != null) {
                this.baB.stop();
            }
            if (this.bay != 0) {
                al.c(this.mIconView, this.bay);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
