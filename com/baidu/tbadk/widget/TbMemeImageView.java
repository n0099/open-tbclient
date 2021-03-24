package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.gif.NSGif;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
/* loaded from: classes3.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.d.b f14106e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f14107f;

    /* renamed from: g  reason: collision with root package name */
    public int f14108g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.j.d.a f14109h;
    public boolean i;
    public Drawable j;
    public Drawable k;
    public String l;
    public View.OnClickListener m;
    public TbRichTextView.u n;
    public final Handler o;
    public c<d.b.b.j.d.a> p;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.b.b.d.b gif = TbMemeImageView.this.getGif();
            if (gif != null && message.what == 1) {
                TbMemeImageView.this.f14108g++;
                if (TbMemeImageView.this.f14108g >= gif.getFrameCount()) {
                    TbMemeImageView.this.f14108g = 0;
                }
                gif.b(TbMemeImageView.this.f14108g);
                gif.c(TbMemeImageView.this.f14107f, null);
                TbMemeImageView.this.invalidate();
                TbMemeImageView.this.o.removeMessages(1);
                TbMemeImageView.this.o.sendEmptyMessageDelayed(1, gif.a(TbMemeImageView.this.f14108g));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c<d.b.b.j.d.a> {
        public b() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            d.h().c(str, 33);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                TbMemeImageView.this.g(aVar);
            }
        }
    }

    public TbMemeImageView(Context context) {
        super(context);
        this.i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a();
        this.p = new b();
        e();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TbRichTextView.u uVar = this.n;
        if (uVar != null) {
            uVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        setBackgroundDrawable(this.j);
        setOnClickListener(null);
    }

    public void f() {
        d.b.b.d.b gif = getGif();
        if (gif == null) {
            return;
        }
        if (this.f14108g != 0) {
            this.f14108g = 0;
        }
        gif.b(0);
        this.o.removeMessages(1);
        this.o.sendEmptyMessageDelayed(1, gif.a(this.f14108g));
    }

    public void g(d.b.b.j.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f14109h = aVar;
        if (aVar.t() && aVar.k() != null && aVar.k().length > 0) {
            NSGif f2 = NSGif.f(aVar.k(), 0, aVar.k().length);
            if (f2 == null) {
                return;
            }
            this.f14106e = f2;
            f2.b(0);
            Bitmap bitmap = this.f14107f;
            if (bitmap == null || (bitmap.getWidth() != this.f14106e.getWidth() && this.f14107f.getHeight() != this.f14106e.getHeight())) {
                this.f14107f = Bitmap.createBitmap(this.f14106e.getWidth(), this.f14106e.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.f14106e.c(this.f14107f, null);
            setImageBitmap(this.f14107f);
            f();
        } else if (aVar.p() != null) {
            setImageBitmap(aVar.p());
        }
    }

    public d.b.b.j.d.a getBdImage() {
        return this.f14109h;
    }

    public d.b.b.d.b getGif() {
        d.b.b.d.b bVar = this.f14106e;
        if (bVar == null) {
            return null;
        }
        return bVar;
    }

    public void h() {
        if (getGif() == null) {
            return;
        }
        this.o.removeMessages(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f14109h == null && this.i) {
            d.h().l(this.l, 33, this.p, 0, 0, false, null, new Object[0]);
            return;
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o.removeMessages(1);
        d.b.b.d.b bVar = this.f14106e;
        if (bVar != null) {
            bVar.close();
            this.f14106e = null;
        }
        if (this.f14109h != null) {
            this.f14109h = null;
        }
        Bitmap bitmap = this.f14107f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f14107f = null;
        }
        this.f14108g = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.o.removeMessages(1);
        d.b.b.d.b bVar = this.f14106e;
        if (bVar != null) {
            bVar.close();
            this.f14106e = null;
        }
        if (this.f14109h != null) {
            this.f14109h = null;
        }
        Bitmap bitmap = this.f14107f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f14107f = null;
        }
        this.f14108g = 0;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f14106e == null) {
            return;
        }
        if (i == 4 || i == 8) {
            h();
        } else if (i == 0) {
            f();
        }
    }

    public void setDispatchTouchListener(TbRichTextView.u uVar) {
        this.n = uVar;
    }

    public void setHasNoImage(boolean z) {
        if (z && (this.j != null || this.k != null)) {
            int intrinsicWidth = this.j.getIntrinsicWidth();
            int intrinsicHeight = this.j.getIntrinsicHeight();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (intrinsicWidth > measuredWidth) {
                intrinsicWidth = measuredWidth;
            }
            if (intrinsicHeight > measuredHeight) {
                intrinsicHeight = measuredHeight;
            }
            int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
            int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
            this.j.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!isClickable()) {
            setClickable(true);
        }
        super.setOnClickListener(this);
        this.m = onClickListener;
    }

    public void setSupportNoImage(boolean z) {
        this.i = z;
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a();
        this.p = new b();
        e();
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a();
        this.p = new b();
        e();
    }
}
