package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public int A;
    public int k;
    public View l;
    public View m;
    public TBLottieAnimationView n;
    public TextView o;
    public TBLottieAnimationView p;
    public TbImageView q;
    public View r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public HashMap<String, TbFragmentTabIndicator.a> x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MaintabBottomIndicator.this.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MaintabBottomIndicator.this.n.setVisibility(8);
            MaintabBottomIndicator.this.p.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13949a;

        public b(String str) {
            this.f13949a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                MaintabBottomIndicator.this.q.setVisibility(0);
                if (!k.isEmpty(this.f13949a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.f13949a));
                }
                MaintabBottomIndicator.this.q.setEvent(null);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    public MaintabBottomIndicator(Context context) {
        super(context);
        this.k = 0;
        this.t = 3;
        this.x = new HashMap<>();
        this.y = false;
        this.z = true;
        this.A = 1;
        o();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        if (aVar == null || (view = aVar.f13955a) == null) {
            return;
        }
        addView(view);
        this.x.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        if (aVar == null || (view = aVar.f13955a) == null) {
            return;
        }
        addView(view, -2, -2);
        this.x.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        return this.x.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i) {
        super.e(i);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.x.entrySet();
        if (entrySet != null && (r0 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.b(i);
                }
            }
        }
        if (this.t != i) {
            this.t = i;
            int i2 = this.s;
            if (i2 != 0) {
                SkinManager.setViewTextColor(this.o, i2);
            } else {
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            }
            int i3 = this.u;
            if (i3 != 0) {
                try {
                    SkinManager.setLottieAnimation(this.n, i3);
                    if (this.t == 1) {
                        this.n.setAlpha(0.66f);
                    } else if (this.t == 4) {
                        this.n.setAlpha(0.83f);
                    } else {
                        this.n.setAlpha(1.0f);
                    }
                    m();
                } catch (Exception unused) {
                }
            }
        }
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0203, i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        View view;
        super.f(z);
        if (this.u == 0) {
            return;
        }
        if (z) {
            c.a(this.o).s(R.string.F_X02);
            this.q.setVisibility(8);
            this.n.playAnimation();
            HashMap<String, TbFragmentTabIndicator.a> hashMap = this.x;
            if (hashMap != null) {
                for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                    if (aVar != null && (view = aVar.f13955a) != null && view.isClickable()) {
                        aVar.f13955a.performClick();
                    }
                }
                return;
            }
            return;
        }
        this.n.cancelAnimation();
        this.n.setFrame(0);
        c.a(this.o).s(R.string.F_X01);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.p;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.o;
    }

    public final void k() {
        int j = d.b.h0.r.d0.b.i().j(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
        d.b.h0.r.d0.b.i().v("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        TBLottieAnimationView tBLottieAnimationView = this.p;
        tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
        if (j >= 3) {
            n();
        }
    }

    public final void l() {
        d.b.h0.r.d0.b.i().u(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, d.b.h0.r.d0.b.i().j(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) + 1);
    }

    public final void m() {
        boolean z;
        if (this.y && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && (z = this.z)) {
            int i = this.A;
            if (i == 1) {
                v(z);
            } else if (i == 2) {
                w();
            }
        }
    }

    public void n() {
        TBLottieAnimationView tBLottieAnimationView = this.p;
        if (tBLottieAnimationView == null || tBLottieAnimationView.getVisibility() != 0) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        this.p.startAnimation(scaleAnimation);
        this.p.setVisibility(4);
        this.n.setVisibility(0);
        d.b.h0.r.d0.b.i().u(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 4);
    }

    public final void o() {
        this.l = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.l.setLayoutParams(layoutParams);
        this.m = this.l.findViewById(R.id.container_common_item);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.l.findViewById(R.id.view_bottom_icon);
        this.n = tBLottieAnimationView;
        tBLottieAnimationView.setSpeed(1.1f);
        this.n.n();
        TbImageView tbImageView = (TbImageView) this.l.findViewById(R.id.image_icon);
        this.q = tbImageView;
        tbImageView.setRadius(50);
        this.q.setDefaultBgResource(R.color.transparent);
        this.q.setConrers(15);
        TextView textView = (TextView) this.l.findViewById(R.id.view_bottom_text);
        this.o = textView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = -l.g(getContext(), R.dimen.M_H_X001);
        this.o.setLayoutParams(marginLayoutParams);
        TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.l.findViewById(R.id.animation_view);
        this.p = tBLottieAnimationView2;
        tBLottieAnimationView2.setFirstLoadInternal(true);
        this.r = this.l.findViewById(R.id.bar_cross_line);
        addView(this.l);
        this.v = l.g(getContext(), R.dimen.tbds18);
        this.w = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int i5;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i, i2, i3, i4);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.x.entrySet();
        if (entrySet == null || (it = entrySet.iterator()) == null) {
            return;
        }
        while (it.hasNext() && this.o != null && this.n != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            if (value != null) {
                int measuredWidth = value.f13955a.getMeasuredWidth();
                int measuredHeight3 = value.f13955a.getMeasuredHeight();
                if (value.f13956b) {
                    i5 = this.o.getRight() - this.v;
                } else {
                    int left = this.o.getLeft();
                    double measuredWidth2 = this.o.getMeasuredWidth();
                    Double.isNaN(measuredWidth2);
                    i5 = (left + ((int) (measuredWidth2 * 0.14d))) - measuredWidth;
                }
                if (this.k == 1) {
                    measuredHeight = this.n.getTop();
                    measuredHeight2 = this.w;
                } else {
                    measuredHeight = getMeasuredHeight() / 2;
                    measuredHeight2 = value.f13955a.getMeasuredHeight() / 2;
                }
                int i6 = measuredHeight - measuredHeight2;
                value.f13955a.layout(i5, i6, measuredWidth + i5, measuredHeight3 + i6);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.x.entrySet();
        if (entrySet == null || (r0 = entrySet.iterator()) == null) {
            return;
        }
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
            TbFragmentTabIndicator.a value = entry.getValue();
            if (value != null) {
                ViewGroup.LayoutParams layoutParams = value.f13955a.getLayoutParams();
                int i3 = layoutParams.width;
                if (i3 == -2) {
                    value.f13955a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i3 > size) {
                        i3 = size;
                    }
                    int i4 = layoutParams.height;
                    if (i4 > size2) {
                        i4 = size2;
                    }
                    value.f13955a.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    public boolean p() {
        return this.n.isAnimating();
    }

    public final void q() {
        if (System.currentTimeMillis() > d.b.h0.r.d0.b.i().k("key_lottie_show_expired_time", 0L)) {
            d.b.h0.r.d0.b.i().u(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
        }
    }

    public void r() {
        TBLottieAnimationView tBLottieAnimationView = this.p;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void s() {
        TBLottieAnimationView tBLottieAnimationView = this.n;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        this.u = i;
        SkinManager.setLottieAnimation(this.n, i);
    }

    public void setImageIconUrl(String str, String str2) {
        if (k.isEmpty(str)) {
            return;
        }
        this.q.setVisibility(8);
        this.q.setEvent(new b(str2));
        this.q.W(str, 10, false);
    }

    public void setLottieView(boolean z) {
        if (this.p == null) {
            return;
        }
        String o = d.b.h0.r.d0.b.i().o("sync_send_maintab_my_tab_lottie_url", "");
        if (k.isEmpty(o) && z) {
            return;
        }
        q();
        if (TimeHelper.isInTimeBlock(d.b.h0.r.d0.b.i().k("sync_send_maintab_my_tab_lottie_start_time", 0L), d.b.h0.r.d0.b.i().k("sync_send_maintab_my_tab_lottie_end_time", 0L)) && d.b.h0.r.d0.b.i().j(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) < 3) {
            this.p.playAnimation();
            this.p.setAnimationUrl(o);
            l();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.p.addAnimatorListener(new a());
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.n.setProgress(1.0f);
        }
    }

    public void setShowIconType(int i) {
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        this.o.setText(i);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        this.s = i;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        this.k = i;
    }

    public void setWriteIconView() {
        this.m.setVisibility(8);
    }

    public void t() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.n.loop(true);
        s();
    }

    public void u() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.n.loop(false);
        s();
    }

    public void v(boolean z) {
        setAnimationResId(this.u);
        this.n.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.n.playAnimation();
            return;
        }
        this.n.cancelAnimation();
        this.n.setFrame(0);
    }

    public void w() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.n.loop(false);
        s();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.t = 3;
        this.x = new HashMap<>();
        this.y = false;
        this.z = true;
        this.A = 1;
        o();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        this.t = 3;
        this.x = new HashMap<>();
        this.y = false;
        this.z = true;
        this.A = 1;
        o();
    }
}
