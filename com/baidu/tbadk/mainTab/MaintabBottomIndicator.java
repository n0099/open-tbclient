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
    private int aFu;
    private HashMap<String, TbFragmentTabIndicator.a> bdI;
    private int bdQ;
    private View bdR;
    private View bdS;
    private ImageView bdT;
    private TBLottieAnimationView bdU;
    private int bdV;
    private int bdW;
    private int bdX;
    private AnimationDrawable bdY;
    private int bdx;
    private ImageView mIconView;
    private TextView mTextView;
    private int nk;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.bdx = 0;
        this.bdI = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdx = 0;
        this.bdI = new HashMap<>();
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdx = 0;
        this.bdI = new HashMap<>();
        init();
    }

    private void init() {
        this.bdR = LayoutInflater.from(getContext()).inflate(e.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.bdR.setLayoutParams(layoutParams);
        this.bdS = this.bdR.findViewById(e.g.container_common_item);
        this.mIconView = (ImageView) this.bdR.findViewById(e.g.view_bottom_icon);
        this.mTextView = (TextView) this.bdR.findViewById(e.g.view_bottom_text);
        this.bdT = (ImageView) this.bdR.findViewById(e.g.view_write_icon);
        this.bdU = (TBLottieAnimationView) this.bdR.findViewById(e.g.animation_view);
        this.bdU.setFirstLoadInternal(true);
        addView(this.bdR);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdI.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdI.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.mIconView != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.beb) {
                        left = this.mTextView.getRight() - ((int) (this.mTextView.getMeasuredWidth() * 0.14d));
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.bdx == 1) {
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
        this.bdx = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.bdI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.bdI.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a io(String str) {
        return this.bdI.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        this.bdV = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.aFu = i;
    }

    public void setShowIconType(int i) {
        this.bdQ = i;
    }

    public void setWriteIconView(int i, int i2) {
        this.bdS.setVisibility(8);
        this.bdT.setVisibility(0);
        al.c(this.bdT, i);
        al.i(this.bdT, i2);
        this.bdW = i;
        this.bdX = i2;
    }

    public TBLottieAnimationView getAnimationView() {
        return this.bdU;
    }

    public void NT() {
        if (this.bdU != null && this.bdU.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.bdU.startAnimation(scaleAnimation);
            this.bdU.setVisibility(4);
            this.mIconView.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void NU() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void NV() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.bdU.setFrame(this.bdU.getFrame());
        if (i >= 3) {
            NT();
        }
    }

    public void onDestory() {
        if (this.bdU != null) {
            this.bdU.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.bdU != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ao.isEmpty(string) || !z) {
                NU();
                if (ax.c(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.bdU.cv();
                    this.bdU.setAnimationUrl(string);
                    NV();
                    TiebaStatic.log(new am("c13248").aA("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.bdU.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.mIconView.setVisibility(8);
                            MaintabBottomIndicator.this.bdU.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.NW();
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
        eC(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eC(int i) {
        super.eC(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.bdI.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.eC(i);
                }
            }
        }
        if (this.bdQ == c.bdM) {
            al.c(this.bdT, this.bdW);
            al.i(this.bdT, this.bdX);
            return;
        }
        if (this.aFu != 0) {
            al.h(this.mTextView, this.aFu);
        } else {
            al.h(this.mTextView, e.d.cp_cont_f);
        }
        if (this.bdV != 0) {
            al.c(this.mIconView, this.bdV);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void cC(boolean z) {
        super.cC(z);
        if (this.nk != 0) {
            if (z) {
                al.c(this.mIconView, this.nk);
                this.bdY = (AnimationDrawable) this.mIconView.getDrawable();
                if (this.bdY != null) {
                    this.bdY.start();
                    return;
                }
                return;
            }
            if (this.bdY != null) {
                this.bdY.stop();
            }
            if (this.bdV != 0) {
                al.c(this.mIconView, this.bdV);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
