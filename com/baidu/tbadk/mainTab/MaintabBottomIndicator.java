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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private int bVY;
    private int cwA;
    private int cwa;
    private HashMap<String, TbFragmentTabIndicator.a> cwl;
    private int cwt;
    private View cwu;
    private View cwv;
    private TBLottieAnimationView cww;
    private OvalActionButton cwx;
    private TBLottieAnimationView cwy;
    private int cwz;
    private int kF;
    private e kJ;
    private int mSkinType;
    private TextView mTextView;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.cwa = 0;
        this.mSkinType = 3;
        this.cwl = new HashMap<>();
        this.kJ = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwa = 0;
        this.mSkinType = 3;
        this.cwl = new HashMap<>();
        this.kJ = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cwa = 0;
        this.mSkinType = 3;
        this.cwl = new HashMap<>();
        this.kJ = null;
        init();
    }

    private void init() {
        this.cwu = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.cwu.setLayoutParams(layoutParams);
        this.cwv = this.cwu.findViewById(R.id.container_common_item);
        this.cww = (TBLottieAnimationView) this.cwu.findViewById(R.id.view_bottom_icon);
        this.cww.setSpeed(1.2f);
        this.cww.axm();
        this.mTextView = (TextView) this.cwu.findViewById(R.id.view_bottom_text);
        this.cwx = (OvalActionButton) this.cwu.findViewById(R.id.view_write_icon);
        this.cwy = (TBLottieAnimationView) this.cwu.findViewById(R.id.animation_view);
        this.cwy.setFirstLoadInternal(true);
        addView(this.cwu);
        this.cwz = l.g(getContext(), R.dimen.tbds18);
        this.cwA = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cwl.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cwl.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.cww != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.cwH) {
                        left = this.mTextView.getRight() - this.cwz;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.cwa == 1) {
                        measuredHeight = this.cww.getTop();
                        measuredHeight2 = this.cwA;
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
        this.cwa = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.cwl.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.cwl.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a qz(String str) {
        return this.cwl.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bVY = i;
    }

    public void setShowIconType(int i) {
        this.cwt = i;
    }

    public void setWriteIconView() {
        this.cwv.setVisibility(8);
        this.cwx.setVisibility(0);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.cwy;
    }

    public void apg() {
        if (this.cwy != null && this.cwy.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.cwy.startAnimation(scaleAnimation);
            this.cwy.setVisibility(4);
            this.cww.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_lottie_show_count", 4);
        }
    }

    private void asO() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.agM().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_lottie_show_count", 0);
        }
    }

    private void asP() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asQ() {
        int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.cwy.setFrame(this.cwy.getFrame());
        if (i >= 3) {
            apg();
        }
    }

    public void onDestory() {
        if (this.cwy != null) {
            this.cwy.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.cwy != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ap.isEmpty(string) || !z) {
                asO();
                if (az.h(com.baidu.tbadk.core.sharedPref.b.agM().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.agM().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_lottie_show_count", 0) < 3) {
                    this.cwy.bo();
                    this.cwy.setAnimationUrl(string);
                    asP();
                    TiebaStatic.log(new am("c13248").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.cwy.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.cww.setVisibility(8);
                            MaintabBottomIndicator.this.cwy.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.asQ();
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
        this.kF = i;
        al.a(this.cww, this.kF);
    }

    public void asR() {
        al.a(this.cww, (int) R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.cww.y(false);
        bo();
    }

    public void asS() {
        al.a(this.cww, (int) R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.cww.y(true);
        bo();
    }

    public void asT() {
        al.a(this.cww, (int) R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.cww.y(false);
        bo();
    }

    public void bo() {
        if (this.cww != null) {
            this.cww.bo();
        }
    }

    public boolean isAnimating() {
        return this.cww.isAnimating();
    }

    public void fq(boolean z) {
        setAnimationResId(this.kF);
        this.cww.y(false);
        setText(R.string.home_recommend);
        if (z) {
            this.cww.bo();
            return;
        }
        this.cww.cancelAnimation();
        this.cww.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        iW(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void iW(int i) {
        super.iW(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cwl.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.iW(i);
                }
            }
        }
        if (this.cwx != null) {
            this.cwx.onChangeSkinType(i);
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bVY != 0) {
                al.j(this.mTextView, this.bVY);
            } else {
                al.j(this.mTextView, R.color.cp_cont_f);
            }
            if (this.kF != 0) {
                try {
                    al.a(this.cww, this.kF);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void fp(boolean z) {
        super.fp(z);
        if (this.kF != 0) {
            if (z) {
                this.cww.bo();
                return;
            }
            this.cww.cancelAnimation();
            this.cww.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.cww.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
