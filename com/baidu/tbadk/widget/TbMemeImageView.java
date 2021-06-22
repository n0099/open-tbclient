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
import d.a.c.e.l.c;
import d.a.c.e.l.d;
/* loaded from: classes3.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.d.b f13196e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f13197f;

    /* renamed from: g  reason: collision with root package name */
    public int f13198g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.d.a f13199h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13200i;
    public Drawable j;
    public Drawable k;
    public String l;
    public View.OnClickListener m;
    public TbRichTextView.v n;
    public final Handler o;
    public c<d.a.c.k.d.a> p;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.a.c.d.b gif = TbMemeImageView.this.getGif();
            if (gif != null && message.what == 1) {
                TbMemeImageView.this.f13198g++;
                if (TbMemeImageView.this.f13198g >= gif.getFrameCount()) {
                    TbMemeImageView.this.f13198g = 0;
                }
                gif.c(TbMemeImageView.this.f13198g);
                gif.a(TbMemeImageView.this.f13197f, null);
                TbMemeImageView.this.invalidate();
                TbMemeImageView.this.o.removeMessages(1);
                TbMemeImageView.this.o.sendEmptyMessageDelayed(1, gif.b(TbMemeImageView.this.f13198g));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c<d.a.c.k.d.a> {
        public b() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            d.h().c(str, 33);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                TbMemeImageView.this.g(aVar);
            }
        }
    }

    public TbMemeImageView(Context context) {
        super(context);
        this.f13200i = true;
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
        TbRichTextView.v vVar = this.n;
        if (vVar != null) {
            vVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        setBackgroundDrawable(this.j);
        setOnClickListener(null);
    }

    public void f() {
        d.a.c.d.b gif = getGif();
        if (gif == null) {
            return;
        }
        if (this.f13198g != 0) {
            this.f13198g = 0;
        }
        gif.c(0);
        this.o.removeMessages(1);
        this.o.sendEmptyMessageDelayed(1, gif.b(this.f13198g));
    }

    public void g(d.a.c.k.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f13199h = aVar;
        if (aVar.t() && aVar.k() != null && aVar.k().length > 0) {
            NSGif f2 = NSGif.f(aVar.k(), 0, aVar.k().length);
            if (f2 == null) {
                return;
            }
            this.f13196e = f2;
            f2.c(0);
            Bitmap bitmap = this.f13197f;
            if (bitmap == null || (bitmap.getWidth() != this.f13196e.getWidth() && this.f13197f.getHeight() != this.f13196e.getHeight())) {
                this.f13197f = Bitmap.createBitmap(this.f13196e.getWidth(), this.f13196e.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.f13196e.a(this.f13197f, null);
            setImageBitmap(this.f13197f);
            f();
        } else if (aVar.p() != null) {
            setImageBitmap(aVar.p());
        }
    }

    public d.a.c.k.d.a getBdImage() {
        return this.f13199h;
    }

    public d.a.c.d.b getGif() {
        d.a.c.d.b bVar = this.f13196e;
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
        if (this.f13199h == null && this.f13200i) {
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
        d.a.c.d.b bVar = this.f13196e;
        if (bVar != null) {
            bVar.close();
            this.f13196e = null;
        }
        if (this.f13199h != null) {
            this.f13199h = null;
        }
        Bitmap bitmap = this.f13197f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f13197f = null;
        }
        this.f13198g = 0;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.o.removeMessages(1);
        d.a.c.d.b bVar = this.f13196e;
        if (bVar != null) {
            bVar.close();
            this.f13196e = null;
        }
        if (this.f13199h != null) {
            this.f13199h = null;
        }
        Bitmap bitmap = this.f13197f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f13197f = null;
        }
        this.f13198g = 0;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f13196e == null) {
            return;
        }
        if (i2 == 4 || i2 == 8) {
            h();
        } else if (i2 == 0) {
            f();
        }
    }

    public void setDispatchTouchListener(TbRichTextView.v vVar) {
        this.n = vVar;
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
        this.f13200i = z;
    }

    public TbMemeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13200i = true;
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
        this.f13200i = true;
        this.j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a();
        this.p = new b();
        e();
    }
}
