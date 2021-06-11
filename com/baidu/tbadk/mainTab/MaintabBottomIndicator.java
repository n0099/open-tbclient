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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.e0.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public boolean A;
    public int B;
    public d.a.m0.e0.e.a C;
    public boolean D;
    public int k;
    public View l;
    public View m;
    public TBLottieAnimationView n;
    public TextView o;
    public TBLottieAnimationView p;
    public TbImageView q;
    public TbImageView r;
    public View s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public HashMap<String, TbFragmentTabIndicator.a> y;
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
        public final /* synthetic */ String f12925a;

        public b(String str) {
            this.f12925a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (MaintabBottomIndicator.this.C == null || !c.d().b()) {
                    MaintabBottomIndicator.this.q.setVisibility(0);
                }
                if (!k.isEmpty(this.f12925a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.f12925a));
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
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        if (aVar == null || (view = aVar.f12932a) == null) {
            return;
        }
        addView(view);
        this.y.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        if (aVar == null || (view = aVar.f12932a) == null) {
            return;
        }
        addView(view, -2, -2);
        this.y.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        return this.y.get(str);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i2) {
        super.e(i2);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
        if (entrySet != null && (r0 = entrySet.iterator()) != null) {
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    value.b(i2);
                }
            }
        }
        if (this.u != i2) {
            this.u = i2;
            int i3 = this.t;
            if (i3 != 0) {
                SkinManager.setViewTextColor(this.o, i3);
            } else {
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            }
            int i4 = this.v;
            if (i4 != 0) {
                try {
                    SkinManager.setLottieAnimation(this.n, i4);
                    if (this.u == 1) {
                        this.n.setAlpha(0.66f);
                    } else if (this.u == 4) {
                        this.n.setAlpha(0.83f);
                    } else {
                        this.n.setAlpha(1.0f);
                    }
                    m();
                } catch (Exception unused) {
                }
            }
        }
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0203, i2);
        z();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        View view;
        super.f(z);
        this.D = z;
        z();
        if (this.v == 0) {
            return;
        }
        if (z) {
            d.a.m0.r.u.c.d(this.o).x(R.string.F_X02);
            this.q.setVisibility(8);
            this.n.playAnimation();
            HashMap<String, TbFragmentTabIndicator.a> hashMap = this.y;
            if (hashMap != null) {
                for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                    if (aVar != null && (view = aVar.f12932a) != null && view.isClickable()) {
                        aVar.f12932a.performClick();
                    }
                }
                return;
            }
            return;
        }
        this.n.cancelAnimation();
        this.n.setFrame(0);
        d.a.m0.r.u.c.d(this.o).x(R.string.F_X01);
    }

    public TBLottieAnimationView getAnimationView() {
        return this.p;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        return this.o;
    }

    public final void k() {
        int k = d.a.m0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
        d.a.m0.r.d0.b.j().w("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
        TBLottieAnimationView tBLottieAnimationView = this.p;
        tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
        if (k >= 3) {
            n();
        }
    }

    public final void l() {
        d.a.m0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, d.a.m0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) + 1);
    }

    public final void m() {
        boolean z;
        if (this.z && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && (z = this.A)) {
            int i2 = this.B;
            if (i2 == 1) {
                x(z);
            } else if (i2 == 2) {
                y();
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
        d.a.m0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 4);
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
        this.n.l();
        TbImageView tbImageView = (TbImageView) this.l.findViewById(R.id.image_icon);
        this.q = tbImageView;
        tbImageView.setRadius(50);
        this.q.setDefaultBgResource(R.color.transparent);
        this.q.setConrers(15);
        this.r = (TbImageView) this.l.findViewById(R.id.dynamic_image_icon);
        TextView textView = (TextView) this.l.findViewById(R.id.view_bottom_text);
        this.o = textView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = -l.g(getContext(), R.dimen.M_H_X001);
        this.o.setLayoutParams(marginLayoutParams);
        TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.l.findViewById(R.id.animation_view);
        this.p = tBLottieAnimationView2;
        tBLottieAnimationView2.setFirstLoadInternal(true);
        this.s = this.l.findViewById(R.id.bar_cross_line);
        addView(this.l);
        this.w = l.g(getContext(), R.dimen.tbds18);
        this.x = l.g(getContext(), R.dimen.tbds10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        super.onLayout(z, i2, i3, i4, i5);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
        if (entrySet == null || (it = entrySet.iterator()) == null) {
            return;
        }
        while (it.hasNext() && this.o != null && this.n != null) {
            TbFragmentTabIndicator.a value = it.next().getValue();
            if (value != null) {
                int measuredWidth = value.f12932a.getMeasuredWidth();
                int measuredHeight3 = value.f12932a.getMeasuredHeight();
                if (value.f12933b) {
                    left = this.o.getRight() - this.w;
                } else {
                    left = (this.o.getLeft() + ((int) (this.o.getMeasuredWidth() * 0.14d))) - measuredWidth;
                }
                if (this.k == 1) {
                    measuredHeight = this.n.getTop();
                    measuredHeight2 = this.x;
                } else {
                    measuredHeight = getMeasuredHeight() / 2;
                    measuredHeight2 = value.f12932a.getMeasuredHeight() / 2;
                }
                int i6 = measuredHeight - measuredHeight2;
                value.f12932a.layout(left, i6, measuredWidth + left, measuredHeight3 + i6);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
        if (entrySet == null || (r0 = entrySet.iterator()) == null) {
            return;
        }
        for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
            TbFragmentTabIndicator.a value = entry.getValue();
            if (value != null) {
                ViewGroup.LayoutParams layoutParams = value.f12932a.getLayoutParams();
                int i4 = layoutParams.width;
                if (i4 == -2) {
                    value.f12932a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i4 > size) {
                        i4 = size;
                    }
                    int i5 = layoutParams.height;
                    if (i5 > size2) {
                        i5 = size2;
                    }
                    value.f12932a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                }
            }
        }
    }

    public boolean p() {
        return this.n.isAnimating();
    }

    public final void q() {
        if (System.currentTimeMillis() > d.a.m0.r.d0.b.j().l("key_lottie_show_expired_time", 0L)) {
            d.a.m0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
        }
    }

    public void r(boolean z) {
        if (z) {
            s(4);
        } else {
            s(this.u);
        }
    }

    public void s(int i2) {
        int i3 = this.t;
        if (i3 != 0) {
            SkinManager.setViewTextColor(this.o, i3, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1, i2);
        }
        int i4 = this.v;
        if (i4 != 0) {
            try {
                if (i2 == 1) {
                    SkinManager.setNightLottieAnimation(this.n, i4);
                    this.n.setAlpha(0.66f);
                } else if (i2 == 4) {
                    SkinManager.setDarkLottieAnimation(this.n, i4);
                    this.n.setAlpha(0.83f);
                } else {
                    SkinManager.setLottieAnimation(this.n, i4);
                    this.n.setAlpha(1.0f);
                }
                m();
            } catch (Exception unused) {
            }
        }
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0203, i2);
        z();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        this.v = i2;
        SkinManager.setLottieAnimation(this.n, i2);
    }

    public void setDynamicIconData(d.a.m0.e0.e.a aVar) {
        this.C = aVar;
        z();
    }

    public void setImageIconUrl(String str, String str2) {
        if (k.isEmpty(str)) {
            return;
        }
        this.q.setVisibility(8);
        this.q.setEvent(new b(str2));
        this.q.U(str, 10, false);
    }

    public void setLottieView(boolean z) {
        if (this.p == null) {
            return;
        }
        String p = d.a.m0.r.d0.b.j().p("sync_send_maintab_my_tab_lottie_url", "");
        if (k.isEmpty(p) && z) {
            return;
        }
        q();
        if (TimeHelper.isInTimeBlock(d.a.m0.r.d0.b.j().l("sync_send_maintab_my_tab_lottie_start_time", 0L), d.a.m0.r.d0.b.j().l("sync_send_maintab_my_tab_lottie_end_time", 0L)) && d.a.m0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) < 3) {
            this.p.playAnimation();
            this.p.setAnimationUrl(p);
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

    public void setShowIconType(int i2) {
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        this.o.setText(i2);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        this.t = i2;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        this.k = i2;
    }

    public void setWriteIconView() {
        this.m.setVisibility(8);
    }

    public void t() {
        TBLottieAnimationView tBLottieAnimationView = this.p;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void u() {
        TBLottieAnimationView tBLottieAnimationView = this.n;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public void v() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh2);
        setText(R.string.refresh);
        this.n.loop(true);
        u();
    }

    public void w() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh3);
        setText(R.string.home_recommend);
        this.n.loop(false);
        u();
    }

    public void x(boolean z) {
        setAnimationResId(this.v);
        this.n.loop(false);
        setText(R.string.home_recommend);
        if (z) {
            this.n.playAnimation();
            return;
        }
        this.n.cancelAnimation();
        this.n.setFrame(0);
    }

    public void y() {
        SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh1);
        setText(R.string.refresh);
        this.n.loop(false);
        u();
    }

    public final void z() {
        if (this.C == null || !c.d().b()) {
            return;
        }
        this.n.setVisibility(8);
        this.p.setVisibility(4);
        this.q.setVisibility(8);
        this.r.setVisibility(0);
        if (this.D) {
            this.r.U(this.C.l(), this.C.j(), false);
        } else {
            this.r.U(this.C.k(), this.C.j(), false);
        }
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
    }

    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
    }
}
