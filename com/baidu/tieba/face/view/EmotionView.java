package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class EmotionView extends TbImageView {
    public EmotionImageData B0;
    public EmotionPreview C0;
    public int D0;
    public int E0;
    public FrameLayout F0;
    public long G0;
    public boolean H0;
    public boolean I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public View.OnClickListener N0;
    public float O0;
    public int P0;
    public c Q0;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                EmotionView.this.L = aVar.t();
                View findViewWithTag = EmotionView.this.findViewWithTag(str);
                if (findViewWithTag == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.h(tbImageView);
                tbImageView.setTag(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                EmotionView.this.H0 = true;
                EmotionView.this.J0 = motionEvent.getRawX();
                EmotionView.this.K0 = motionEvent.getRawY();
                EmotionView emotionView = EmotionView.this;
                emotionView.L0 = emotionView.J0;
                EmotionView emotionView2 = EmotionView.this;
                emotionView2.M0 = emotionView2.K0;
                EmotionView.this.G0 = System.currentTimeMillis();
                if (EmotionView.this.z0()) {
                    EmotionView emotionView3 = EmotionView.this;
                    emotionView3.postDelayed(new d(emotionView3.G0), 500L);
                }
            } else if (action == 1) {
                EmotionView.this.H0 = false;
                if (EmotionView.this.I0) {
                    EmotionView.this.F0();
                } else if (EmotionView.this.N0 != null && EmotionView.this.y0()) {
                    EmotionView.this.N0.onClick(EmotionView.this);
                }
            } else if (action == 3) {
                EmotionView.this.H0 = false;
                EmotionView.this.F0();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f14730e;

        public d(long j) {
            this.f14730e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.H0 && this.f14730e == EmotionView.this.G0 && EmotionView.this.B0()) {
                EmotionView.this.E0();
            }
        }
    }

    public EmotionView(Context context) {
        super(context);
        this.P0 = 10;
        G();
    }

    public void A0() {
        setOnTouchListener(new b());
    }

    public final boolean B0() {
        float abs = Math.abs(this.L0 - this.J0);
        float abs2 = Math.abs(this.M0 - this.K0);
        float f2 = this.O0;
        return abs < f2 && abs2 < f2;
    }

    public void C0(EmotionImageData emotionImageData) {
        if (emotionImageData == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        this.B0 = emotionImageData;
        setTag(emotionImageData.getThumbUrl());
        if (this.P0 == 20) {
            D0(this.B0);
        } else {
            U(this.B0.getThumbUrl(), this.P0, false);
        }
    }

    public final void D0(EmotionImageData emotionImageData) {
        Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        d.a.c.k.d.a aVar = (k == null || !(k instanceof d.a.c.k.d.a)) ? null : (d.a.c.k.d.a) k;
        if (aVar != null) {
            aVar.h(this);
            setTag(null);
        }
    }

    public final void E0() {
        EmotionImageData emotionImageData;
        if (this.I0 || !z0() || (emotionImageData = this.B0) == null || TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            return;
        }
        c cVar = this.Q0;
        if (cVar != null) {
            cVar.d();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (this.C0 == null) {
            this.C0 = new EmotionPreview(getContext());
        }
        this.C0.e(this.B0.getPicUrl(), this.B0.getThumbUrl(), this.L, this.P0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.D0, this.E0);
        int i2 = iArr[0] - 60;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = iArr[1] - this.E0;
        if (i2 < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.D0 > l.k(getContext())) {
            layoutParams.leftMargin = l.k(getContext()) - this.D0;
        }
        if (this.F0 == null) {
            this.F0 = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        }
        if (this.C0.getParent() != null) {
            ViewParent parent = this.C0.getParent();
            FrameLayout frameLayout = this.F0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.C0);
            }
        }
        this.F0.addView(this.C0, layoutParams);
        this.I0 = true;
    }

    public final void F0() {
        if (this.C0 == null || !this.I0) {
            return;
        }
        c cVar = this.Q0;
        if (cVar != null) {
            cVar.b();
        }
        if (this.C0.getParent() != null) {
            ViewParent parent = this.C0.getParent();
            FrameLayout frameLayout = this.F0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.C0);
            }
        }
        this.I0 = false;
    }

    public final void G() {
        this.D0 = l.g(getContext(), R.dimen.ds240);
        this.E0 = l.g(getContext(), R.dimen.ds260);
        this.O0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        this.B0 = null;
        setImageResource(0);
        super.Q();
    }

    public EmotionImageData getData() {
        return this.B0;
    }

    public boolean getIsGif() {
        return this.L;
    }

    public int getLoadProcType() {
        return this.P0;
    }

    public void setController(c cVar) {
        this.Q0 = cVar;
    }

    public void setLoadProcType(int i2) {
        this.P0 = i2;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.N0 = onClickListener;
    }

    public final boolean y0() {
        c cVar = this.Q0;
        return cVar == null || cVar.c();
    }

    public final boolean z0() {
        c cVar = this.Q0;
        return cVar == null || cVar.e();
    }

    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P0 = 10;
        G();
    }

    public EmotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.P0 = 10;
        G();
    }
}
