package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.a.k0.d3.j;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsAdCommentScrollView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f15304e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15305f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f15306g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f15307h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f15308i;
    public ValueAnimator j;
    public List<j> k;
    public int l;
    public Runnable m;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsAdCommentScrollView.this.l();
            FrsAdCommentScrollView.this.f15308i.postDelayed(this, 5000L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f15310e;

        public b(float f2) {
            this.f15310e = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FrsAdCommentScrollView.this.f15306g.setY(-floatValue);
            FrsAdCommentScrollView.this.f15307h.setY(this.f15310e - floatValue);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FrsAdCommentScrollView.i(FrsAdCommentScrollView.this);
            if (FrsAdCommentScrollView.this.l == FrsAdCommentScrollView.this.k.size()) {
                FrsAdCommentScrollView.this.l = 0;
            }
            FrameLayout frameLayout = FrsAdCommentScrollView.this.f15306g;
            FrsAdCommentScrollView frsAdCommentScrollView = FrsAdCommentScrollView.this;
            frsAdCommentScrollView.f15306g = frsAdCommentScrollView.f15307h;
            FrsAdCommentScrollView.this.f15307h = frameLayout;
            FrsAdCommentScrollView.this.f15307h.setY(FrsAdCommentScrollView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds99));
            FrsAdCommentScrollView.this.r();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public FrsAdCommentScrollView(Context context) {
        super(context);
        this.f15308i = new Handler();
        this.l = 0;
        this.m = new a();
        n();
    }

    public static /* synthetic */ int i(FrsAdCommentScrollView frsAdCommentScrollView) {
        int i2 = frsAdCommentScrollView.l;
        frsAdCommentScrollView.l = i2 + 1;
        return i2;
    }

    public final void l() {
        float y = this.f15307h.getY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.f15306g.getMeasuredHeight());
        this.j = ofFloat;
        ofFloat.addUpdateListener(new b(y));
        this.j.addListener(new c());
        this.j.start();
    }

    public void m(List<j> list) {
        if (ListUtils.getCount(list) <= 1) {
            this.f15308i.removeCallbacks(this.m);
            setVisibility(8);
            return;
        }
        this.k.clear();
        this.k.addAll(list);
        setVisibility(0);
        this.l = 0;
        r();
        q();
    }

    public final void n() {
        this.k = new LinkedList();
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_ad_comment_scroll_view, this);
        this.f15304e = (TextView) findViewById(R.id.cur_display_view);
        this.f15305f = (TextView) findViewById(R.id.next_display_view);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.cur_display_layout);
        this.f15306g = frameLayout;
        frameLayout.setTag(this.f15304e);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.next_display_layout);
        this.f15307h = frameLayout2;
        frameLayout2.setTag(this.f15305f);
    }

    public void o() {
        this.f15308i.removeCallbacks(this.m);
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void p(boolean z) {
        if (z) {
            q();
        }
    }

    public final void q() {
        this.f15308i.removeCallbacks(this.m);
        if (ListUtils.getCount(this.k) >= 2) {
            this.f15308i.postDelayed(this.m, 5000L);
        }
    }

    public final void r() {
        j jVar;
        j jVar2 = (j) ListUtils.getItem(this.k, this.l);
        if (this.l + 1 >= this.k.size()) {
            jVar = (j) ListUtils.getItem(this.k, 0);
        } else {
            jVar = (j) ListUtils.getItem(this.k, this.l + 1);
        }
        if ((this.f15306g.getTag() instanceof TextView) && jVar2 != null) {
            String a2 = jVar2.a();
            if (jVar2.b()) {
                a2 = getContext().getString(R.string.frs_top_ad_lz_reply, a2);
            }
            ((TextView) this.f15306g.getTag()).setText(a2);
        }
        if (!(this.f15307h.getTag() instanceof TextView) || jVar == null) {
            return;
        }
        String a3 = jVar.a();
        if (jVar.b()) {
            a3 = getContext().getString(R.string.frs_top_ad_lz_reply, a3);
        }
        ((TextView) this.f15307h.getTag()).setText(a3);
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15308i = new Handler();
        this.l = 0;
        this.m = new a();
        n();
    }

    public FrsAdCommentScrollView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15308i = new Handler();
        this.l = 0;
        this.m = new a();
        n();
    }
}
