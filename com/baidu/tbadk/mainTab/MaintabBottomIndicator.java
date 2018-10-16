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
    private int aBf;
    private int aZF;
    private View aZG;
    private View aZH;
    private ImageView aZI;
    private TBLottieAnimationView aZJ;
    private int aZK;
    private int aZL;
    private int aZM;
    private AnimationDrawable aZN;
    private int aZm;
    private HashMap<String, TbFragmentTabIndicator.a> aZx;
    private ImageView mIconView;
    private TextView mTextView;
    private int nk;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.aZm = 0;
        this.aZx = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZm = 0;
        this.aZx = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZm = 0;
        this.aZx = new HashMap<>();
        init();
    }

    private void init() {
        this.aZG = LayoutInflater.from(getContext()).inflate(e.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.aZG.setLayoutParams(layoutParams);
        this.aZH = this.aZG.findViewById(e.g.container_common_item);
        this.mIconView = (ImageView) this.aZG.findViewById(e.g.view_bottom_icon);
        this.mTextView = (TextView) this.aZG.findViewById(e.g.view_bottom_text);
        this.aZI = (ImageView) this.aZG.findViewById(e.g.view_write_icon);
        this.aZJ = (TBLottieAnimationView) this.aZG.findViewById(e.g.animation_view);
        this.aZJ.setFirstLoadInternal(true);
        addView(this.aZG);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aZx.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aZx.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.aZQ) {
                        left = this.mTextView.getRight() - ((int) (this.mTextView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.aZm == 1) {
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
        this.aZm = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.aZx.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.aZx.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a hV(String str) {
        return this.aZx.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.aZK = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aBf = i;
    }

    public void setShowIconType(int i) {
        this.aZF = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.aZH.setVisibility(8);
        this.aZI.setVisibility(0);
        al.c(this.aZI, i);
        al.i(this.aZI, i2);
        this.aZL = i;
        this.aZM = i2;
    }

    public TBLottieAnimationView getAnimationView() {
        return this.aZJ;
    }

    public void MG() {
        if (this.aZJ != null && this.aZJ.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.aZJ.startAnimation(scaleAnimation);
            this.aZJ.setVisibility(4);
            this.mIconView.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void MH() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void MI() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.aZJ.setFrame(this.aZJ.getFrame());
        if (i >= 3) {
            MG();
        }
    }

    public void onDestory() {
        if (this.aZJ != null) {
            this.aZJ.cx();
        }
    }

    public void setLottieView(boolean z) {
        if (this.aZJ != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ao.isEmpty(string) || !z) {
                MH();
                if (ax.c(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.aZJ.cv();
                    this.aZJ.setAnimationUrl(string);
                    MI();
                    TiebaStatic.log(new am("c13248").ax("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.aZJ.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.mIconView.setVisibility(8);
                            MaintabBottomIndicator.this.aZJ.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.MJ();
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
        ea(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void ea(int i) {
        super.ea(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.aZx.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.ea(i);
                }
            }
        }
        if (this.aZF == c.aZB) {
            al.c(this.aZI, this.aZL);
            al.i(this.aZI, this.aZM);
            return;
        }
        if (this.aBf != 0) {
            al.h(this.mTextView, this.aBf);
        } else {
            al.h(this.mTextView, e.d.cp_cont_f);
        }
        if (this.aZK != 0) {
            al.c(this.mIconView, this.aZK);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void ck(boolean z) {
        super.ck(z);
        if (this.nk != 0) {
            if (z) {
                al.c(this.mIconView, this.nk);
                this.aZN = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.aZN != null) {
                    this.aZN.start();
                    return;
                }
                return;
            }
            if (this.aZN != null) {
                this.aZN.stop();
            }
            if (this.aZK != 0) {
                al.c(this.mIconView, this.aZK);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
