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
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    private int bOj;
    private int cnS;
    private HashMap<String, TbFragmentTabIndicator.a> cod;
    private int col;

    /* renamed from: com  reason: collision with root package name */
    private View f4com;
    private View con;
    private TBLottieAnimationView coo;
    private OvalActionButton cop;
    private TBLottieAnimationView coq;
    private int cor;
    private int cos;
    private int mSkinType;
    private TextView mTextView;
    private int nf;
    private e nj;

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.cnS = 0;
        this.mSkinType = 3;
        this.cod = new HashMap<>();
        this.nj = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnS = 0;
        this.mSkinType = 3;
        this.cod = new HashMap<>();
        this.nj = null;
        init();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnS = 0;
        this.mSkinType = 3;
        this.cod = new HashMap<>();
        this.nj = null;
        init();
    }

    private void init() {
        this.f4com = LayoutInflater.from(getContext()).inflate(d.h.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.f4com.setLayoutParams(layoutParams);
        this.con = this.f4com.findViewById(d.g.container_common_item);
        this.coo = (TBLottieAnimationView) this.f4com.findViewById(d.g.view_bottom_icon);
        this.coo.setSpeed(1.2f);
        this.coo.asg();
        this.mTextView = (TextView) this.f4com.findViewById(d.g.view_bottom_text);
        this.cop = (OvalActionButton) this.f4com.findViewById(d.g.view_write_icon);
        this.coq = (TBLottieAnimationView) this.f4com.findViewById(d.g.animation_view);
        this.coq.setFirstLoadInternal(true);
        addView(this.f4com);
        this.cor = l.h(getContext(), d.e.tbds18);
        this.cos = l.h(getContext(), d.e.tbds10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cod.entrySet();
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
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cod.entrySet();
        if (entrySet != null && (it = entrySet.iterator()) != null) {
            while (it.hasNext() && this.mTextView != null && this.coo != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.view.getMeasuredWidth();
                    int measuredHeight3 = value.view.getMeasuredHeight();
                    if (value.coz) {
                        left = this.mTextView.getRight() - this.cor;
                    } else {
                        left = (this.mTextView.getLeft() + ((int) (this.mTextView.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.cnS == 1) {
                        measuredHeight = this.coo.getTop();
                        measuredHeight2 = this.cos;
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
        this.cnS = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view);
            this.cod.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        if (aVar != null && aVar.view != null) {
            addView(aVar.view, -2, -2);
            this.cod.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a pr(String str) {
        return this.cod.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.mTextView.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.bOj = i;
    }

    public void setShowIconType(int i) {
        this.col = i;
    }

    public void setWriteIconView() {
        this.con.setVisibility(8);
        this.cop.setVisibility(0);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.coq;
    }

    public void ake() {
        if (this.coq != null && this.coq.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.coq.startAnimation(scaleAnimation);
            this.coq.setVisibility(4);
            this.coo.setVisibility(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    private void anL() {
        if (System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", 0);
        }
    }

    private void anM() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_lottie_show_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anN() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        this.coq.setFrame(this.coq.getFrame());
        if (i >= 3) {
            ake();
        }
    }

    public void onDestory() {
        if (this.coq != null) {
            this.coq.cancelAnimation();
        }
    }

    public void setLottieView(boolean z) {
        if (this.coq != null) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
            if (!ap.isEmpty(string) || !z) {
                anL();
                if (az.h(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_lottie_show_count", 0) < 3) {
                    this.coq.cu();
                    this.coq.setAnimationUrl(string);
                    anM();
                    TiebaStatic.log(new am("c13248").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    this.coq.a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.mainTab.MaintabBottomIndicator.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            MaintabBottomIndicator.this.coo.setVisibility(8);
                            MaintabBottomIndicator.this.coq.setVisibility(0);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaintabBottomIndicator.this.anN();
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
        this.nf = i;
        al.a(this.coo, this.nf);
    }

    public void anO() {
        al.a(this.coo, d.i.icon_refresh1);
        setText(d.j.refresh);
        this.coo.G(false);
        cu();
    }

    public void anP() {
        al.a(this.coo, d.i.icon_refresh2);
        setText(d.j.refresh);
        this.coo.G(true);
        cu();
    }

    public void anQ() {
        al.a(this.coo, d.i.icon_refresh3);
        setText(d.j.home_recommend);
        this.coo.G(false);
        cu();
    }

    public void cu() {
        if (this.coo != null) {
            this.coo.cu();
        }
    }

    public boolean isAnimating() {
        return this.coo.isAnimating();
    }

    public void eU(boolean z) {
        setAnimationResId(this.nf);
        this.coo.G(false);
        setText(d.j.home_recommend);
        if (z) {
            this.coo.cu();
            return;
        }
        this.coo.cancelAnimation();
        this.coo.setFrame(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ii(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void ii(int i) {
        super.ii(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.cod.entrySet();
        if (entrySet != null && (r1 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.ii(i);
                }
            }
        }
        if (this.cop != null) {
            this.cop.onChangeSkinType(i);
        }
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bOj != 0) {
                al.j(this.mTextView, this.bOj);
            } else {
                al.j(this.mTextView, d.C0277d.cp_cont_f);
            }
            if (this.nf != 0) {
                try {
                    al.a(this.coo, this.nf);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void eT(boolean z) {
        super.eT(z);
        if (this.nf != 0) {
            if (z) {
                this.coo.cu();
                return;
            }
            this.coo.cancelAnimation();
            this.coo.setFrame(0);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.coo.setProgress(1.0f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.mTextView;
    }
}
