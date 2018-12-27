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
    private int aFv;
    private int bdA;
    private HashMap<String, TbFragmentTabIndicator.a> bdL;
    private int bdT;
    private View bdU;
    private View bdV;
    private ImageView bdW;
    private TBLottieAnimationView bdX;
    private int bdY;
    private int bdZ;
    private int bea;
    private AnimationDrawable beb;
    private ImageView mIconView;
    private TextView mTextView;
    private int nk;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.bdA = 0;
        this.bdL = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdA = 0;
        this.bdL = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdA = 0;
        this.bdL = new HashMap<>();
        init();
    }

    private void init() {
        this.bdU = LayoutInflater.from(getContext()).inflate(e.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bdU.setLayoutParams(layoutParams);
        this.bdV = this.bdU.findViewById(e.g.container_common_item);
        this.mIconView = (ImageView) this.bdU.findViewById(e.g.view_bottom_icon);
        this.mTextView = (TextView) this.bdU.findViewById(e.g.view_bottom_text);
        this.bdW = (ImageView) this.bdU.findViewById(e.g.view_write_icon);
        this.bdX = (TBLottieAnimationView) this.bdU.findViewById(e.g.animation_view);
        this.bdX.setFirstLoadInternal(true);
        addView(this.bdU);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdL.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdL.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.bee) {
                        left = this.mTextView.getRight() - ((int) (this.mTextView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.bdA == 1) {
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
        this.bdA = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bdL.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bdL.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a ip(String str) {
        return this.bdL.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.bdY = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aFv = i;
    }

    public void setShowIconType(int i) {
        this.bdT = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.bdV.setVisibility(8);
        this.bdW.setVisibility(0);
        al.c(this.bdW, i);
        al.i(this.bdW, i2);
        this.bdZ = i;
        this.bea = i2;
    }

    public TBLottieAnimationView getAnimationView() {
        return this.bdX;
    }

    public void NU() {
        if (this.bdX != null && this.bdX.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.bdX.startAnimation(scaleAnimation);
            this.bdX.setVisibility(4);
            this.mIconView.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void NV() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void NW() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NX() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.bdX.setFrame(this.bdX.getFrame());
        if (i >= 3) {
            NU();
        }
    }

    public void onDestory() {
        if (this.bdX != null) {
            this.bdX.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.bdX != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ao.isEmpty(string) || !z) {
                NV();
                if (ax.c(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.bdX.cv();
                    this.bdX.setAnimationUrl(string);
                    NW();
                    TiebaStatic.log(new am("c13248").aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.bdX.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.mIconView.setVisibility(8);
                            MaintabBottomIndicator.this.bdX.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.NX();
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
        eD(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eD(int i) {
        super.eD(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdL.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.eD(i);
                }
            }
        }
        if (this.bdT == c.bdP) {
            al.c(this.bdW, this.bdZ);
            al.i(this.bdW, this.bea);
            return;
        }
        if (this.aFv != 0) {
            al.h(this.mTextView, this.aFv);
        } else {
            al.h(this.mTextView, e.d.cp_cont_f);
        }
        if (this.bdY != 0) {
            al.c(this.mIconView, this.bdY);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cC(boolean z) {
        super.cC(z);
        if (this.nk != 0) {
            if (z) {
                al.c(this.mIconView, this.nk);
                this.beb = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.beb != null) {
                    this.beb.start();
                    return;
                }
                return;
            }
            if (this.beb != null) {
                this.beb.stop();
            }
            if (this.bdY != 0) {
                al.c(this.mIconView, this.bdY);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
