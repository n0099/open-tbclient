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
    public FrameLayout A0;
    public long B0;
    public boolean C0;
    public boolean D0;
    public float E0;
    public float K0;
    public float L0;
    public float M0;
    public View.OnClickListener N0;
    public float O0;
    public int P0;
    public c Q0;
    public EmotionImageData w0;
    public EmotionPreview x0;
    public int y0;
    public int z0;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
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
                EmotionView.this.C0 = true;
                EmotionView.this.E0 = motionEvent.getRawX();
                EmotionView.this.K0 = motionEvent.getRawY();
                EmotionView emotionView = EmotionView.this;
                emotionView.L0 = emotionView.E0;
                EmotionView emotionView2 = EmotionView.this;
                emotionView2.M0 = emotionView2.K0;
                EmotionView.this.B0 = System.currentTimeMillis();
                if (EmotionView.this.z0()) {
                    EmotionView emotionView3 = EmotionView.this;
                    emotionView3.postDelayed(new d(emotionView3.B0), 500L);
                }
            } else if (action == 1) {
                EmotionView.this.C0 = false;
                if (EmotionView.this.D0) {
                    EmotionView.this.F0();
                } else if (EmotionView.this.N0 != null && EmotionView.this.y0()) {
                    EmotionView.this.N0.onClick(EmotionView.this);
                }
            } else if (action == 3) {
                EmotionView.this.C0 = false;
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
        public long f14688e;

        public d(long j) {
            this.f14688e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EmotionView.this.C0 && this.f14688e == EmotionView.this.B0 && EmotionView.this.B0()) {
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
        float abs = Math.abs(this.L0 - this.E0);
        float abs2 = Math.abs(this.M0 - this.K0);
        float f2 = this.O0;
        return abs < f2 && abs2 < f2;
    }

    public void C0(EmotionImageData emotionImageData) {
        if (emotionImageData == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        this.w0 = emotionImageData;
        setTag(emotionImageData.getThumbUrl());
        if (this.P0 == 20) {
            D0(this.w0);
        } else {
            V(this.w0.getThumbUrl(), this.P0, false);
        }
    }

    public final void D0(EmotionImageData emotionImageData) {
        Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        d.a.c.j.d.a aVar = (k == null || !(k instanceof d.a.c.j.d.a)) ? null : (d.a.c.j.d.a) k;
        if (aVar != null) {
            aVar.h(this);
            setTag(null);
        }
    }

    public final void E0() {
        EmotionImageData emotionImageData;
        if (this.D0 || !z0() || (emotionImageData = this.w0) == null || TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            return;
        }
        c cVar = this.Q0;
        if (cVar != null) {
            cVar.d();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (this.x0 == null) {
            this.x0 = new EmotionPreview(getContext());
        }
        this.x0.e(this.w0.getPicUrl(), this.w0.getThumbUrl(), this.L, this.P0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.y0, this.z0);
        int i2 = iArr[0] - 60;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = iArr[1] - this.z0;
        if (i2 < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.y0 > l.k(getContext())) {
            layoutParams.leftMargin = l.k(getContext()) - this.y0;
        }
        if (this.A0 == null) {
            this.A0 = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        }
        if (this.x0.getParent() != null) {
            ViewParent parent = this.x0.getParent();
            FrameLayout frameLayout = this.A0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.x0);
            }
        }
        this.A0.addView(this.x0, layoutParams);
        this.D0 = true;
    }

    public final void F0() {
        if (this.x0 == null || !this.D0) {
            return;
        }
        c cVar = this.Q0;
        if (cVar != null) {
            cVar.b();
        }
        if (this.x0.getParent() != null) {
            ViewParent parent = this.x0.getParent();
            FrameLayout frameLayout = this.A0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.x0);
            }
        }
        this.D0 = false;
    }

    public final void G() {
        this.y0 = l.g(getContext(), R.dimen.ds240);
        this.z0 = l.g(getContext(), R.dimen.ds260);
        this.O0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        this.w0 = null;
        setImageResource(0);
        super.Q();
    }

    public EmotionImageData getData() {
        return this.w0;
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
