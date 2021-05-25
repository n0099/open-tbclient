package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Drawable f14568e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f14569f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f14570g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f14571h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14572i;
    public TbImageView j;
    public ViewEventCenter k;
    public BdUniqueId l;
    public int m;
    public boolean n;
    public boolean o;
    public d.a.n0.j0.d.b p;
    public c q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EnterForumAdView.c(EnterForumAdView.this.l, EnterForumAdView.this.getContext());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                EnterForumAdView.this.f14572i = false;
                EnterForumAdView.this.invalidate();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.f14572i = false;
        this.n = false;
        this.o = false;
        d(context);
    }

    public static final void c(BdUniqueId bdUniqueId, Context context) {
        StatisticItem l;
        d.a.n0.j0.d.b x = EnterForumDelegateStatic.f14404c.x();
        if (x != null) {
            String str = EnterForumDelegateStatic.f14404c.x().f55832a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (context != null) {
                d.a.m0.l.a.l(context, str);
            }
            if (bdUniqueId == null || (l = d.a.n0.d3.a.l(true, "a025", "common_click", 3, 1, true, String.valueOf(x.f55833b), String.valueOf(x.f55833b), 5)) == null) {
                return;
            }
            d.a.n0.d3.c.g().c(bdUniqueId, l);
        }
    }

    public final void d(Context context) {
        setClipChildren(true);
        this.f14571h = new ColorDrawable(1241513984);
        this.f14568e = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.f14569f = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.f14570g = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f14572i) {
            this.f14571h.draw(canvas);
        }
        this.f14568e.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        c cVar;
        if (keyEvent.getKeyCode() == 4 && (cVar = this.q) != null) {
            cVar.onBackPressed();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean e() {
        return this.n;
    }

    public boolean f() {
        return this.o;
    }

    public final void g() {
        StatisticItem l;
        if (this.j == null) {
            TbImageView tbImageView = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.j = tbImageView;
            tbImageView.setPlaceHolder(3);
            this.j.setEvent(new b());
        }
        d.a.n0.j0.d.b x = EnterForumDelegateStatic.f14404c.x();
        if (x != null && x.a()) {
            this.f14572i = true;
            this.j.V(x.f55834c, 38, false);
            invalidate();
            if (this.k != null) {
                d.a.n0.j0.d.c cVar = new d.a.n0.j0.d.c();
                cVar.f55835a = true;
                cVar.f55836b = false;
                cVar.f55837c = getBottom();
                cVar.f55838d = this.m;
                d.a.m0.g0.c.b bVar = new d.a.m0.g0.c.b(16, null, null, null);
                bVar.h(cVar);
                this.k.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.p != x && (l = d.a.n0.d3.a.l(false, "a025", "common_exp", 0, 1, true, String.valueOf(x.f55833b), String.valueOf(x.f55833b), 5)) != null) {
                d.a.n0.d3.c g2 = d.a.n0.d3.c.g();
                BdUniqueId bdUniqueId = this.l;
                g2.d(bdUniqueId, d.a.n0.d3.a.a("" + x.f55833b), l);
                d.a.n0.d3.c.g().h(this.l, false);
            }
        } else {
            if (this.k != null) {
                d.a.n0.j0.d.c cVar2 = new d.a.n0.j0.d.c();
                cVar2.f55835a = false;
                cVar2.f55836b = false;
                cVar2.f55837c = getBottom();
                cVar2.f55838d = this.m;
                d.a.m0.g0.c.b bVar2 = new d.a.m0.g0.c.b(16, null, null, null);
                bVar2.h(cVar2);
                this.k.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.p = x;
    }

    public View getAdImageView() {
        return this.j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = -i3;
        this.f14568e.setBounds(0, i6, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260) + i6);
        if (!z || EnterForumDelegateStatic.f14404c.x() == null || this.k == null) {
            return;
        }
        d.a.n0.j0.d.c cVar = new d.a.n0.j0.d.c();
        cVar.f55835a = true;
        cVar.f55836b = false;
        cVar.f55837c = i5;
        cVar.f55838d = this.m;
        d.a.m0.g0.c.b bVar = new d.a.m0.g0.c.b(16, null, null, null);
        bVar.h(cVar);
        this.k.dispatchMvcEvent(bVar);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f14571h.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.f14568e.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.f14569f.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.f14570g.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAdData() {
        g();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.j.setLayoutParams(layoutParams2);
    }

    public void setAdViewHeight(int i2) {
        this.m = i2;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.k = viewEventCenter;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setOnBackPressedListener(c cVar) {
        this.q = cVar;
    }

    public void setRecentlyIsExtend(boolean z) {
        this.n = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.l = bdUniqueId;
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14572i = false;
        this.n = false;
        this.o = false;
        d(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14572i = false;
        this.n = false;
        this.o = false;
        d(context);
    }
}
