package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.i;
import b.a.e.a.j;
import b.a.e.d.a;
import b.a.e.e.p.l;
import b.a.e.f.a.h;
import b.a.q0.d1.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes8.dex */
public class GifView extends TbImageView implements Runnable, View.OnClickListener, h {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap loadingBm;
    public transient /* synthetic */ FieldHolder $fh;
    public GifInfo A0;
    public int B0;
    public boolean C0;
    public BdUniqueId D0;
    public b.a.e.e.l.c<b.a.e.l.d.a> E0;
    public TbRichTextView.x F0;
    public int P;
    public b.a.e.d.b Q;
    public Bitmap R;
    public int S;
    public d T;
    public boolean U;
    public boolean V;
    public BitmapDrawable W;
    public boolean a0;
    public boolean b0;
    public float c0;
    public float i0;
    public boolean j0;
    public Drawable k0;
    public int l0;
    public final Rect m0;
    public final Rect n0;
    public boolean o0;
    public b.a.q0.n.d p0;
    public View.OnClickListener q0;
    public boolean r0;
    public boolean s0;
    public boolean t0;
    public b.a.e.l.d.a u0;
    public String v0;
    public int w0;
    public int x0;
    public Handler y0;
    public boolean z0;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f45941a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GifView gifView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45941a = gifView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b.a.e.d.b gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.f45941a.getGif()) != null && message.what == 1) {
                this.f45941a.S++;
                boolean z2 = false;
                if (this.f45941a.S >= gif.getFrameCount()) {
                    if (this.f45941a.z0) {
                        if (!this.f45941a.r0) {
                            this.f45941a.setVisibility(4);
                        }
                        this.f45941a.z0 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.f45941a.r0) {
                        this.f45941a.S = gif.getFrameCount() - 1;
                    } else {
                        this.f45941a.S = 0;
                    }
                    z2 = z;
                }
                gif.c(this.f45941a.S);
                gif.a(this.f45941a.R, null);
                this.f45941a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.f45941a.S));
                } else {
                    this.f45941a.A();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GifView.loadingBm = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f45942a;

        public c(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45942a = gifView;
        }

        @Override // b.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                this.f45942a.stopLoading();
                this.f45942a.setGif(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onStop();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Bitmap getLoadingBitmap(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gifView)) == null) {
            Bitmap bitmap = loadingBm;
            if (bitmap != null && !bitmap.isRecycled()) {
                return loadingBm;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                loadingBm = bitmapDrawable.getBitmap();
            }
            return loadingBm;
        }
        return (Bitmap) invokeL.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public static void releaseBitmap() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || loadingBm == null) {
            return;
        }
        if (l.C()) {
            loadingBm = null;
        } else {
            new Handler(Looper.getMainLooper()).post(new b());
        }
    }

    public final void A() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.T) == null || this.t0) {
            return;
        }
        dVar.onStop();
        this.t0 = true;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setImageResource(this, this.x0);
        }
    }

    public void addCallback(b.a.e.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.F0;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.k0;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.k0.setState(getDrawableState());
            invalidate();
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public b.a.e.l.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u0 : (b.a.e.l.d.a) invokeV.objValue;
    }

    public b.a.e.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.a.e.d.b bVar = this.Q;
            if (bVar == null) {
                A();
                return null;
            }
            return bVar;
        }
        return (b.a.e.d.b) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.A0 : (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a.e.l.d.a aVar = this.u0;
            if (aVar == null) {
                return 0;
            }
            return aVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b.a.e.l.d.a aVar = this.u0;
            if (aVar == null) {
                return 0;
            }
            return aVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? b.a.q0.s.u.d.a.b(this.w0) : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v0 : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            b.a.q0.n.d dVar = this.p0;
            if (dVar == null || !dVar.onClickEvent(view)) {
                if (this.A0 != null) {
                    boolean f2 = r.f();
                    GifInfo gifInfo = this.A0;
                    String str = f2 ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                    b.a.e.e.l.d h2 = b.a.e.e.l.d.h();
                    GifInfo gifInfo2 = this.A0;
                    String str2 = gifInfo2.mSharpText;
                    b.a.e.l.d.a aVar = (b.a.e.l.d.a) h2.n(str2, this.B0, gifInfo2.mGid, str2, Boolean.valueOf(f2), str);
                    if (aVar != null) {
                        this.A0.mLoadFailed = false;
                        setGif(aVar);
                    } else {
                        startLoading();
                        b.a.e.e.l.d h3 = b.a.e.e.l.d.h();
                        GifInfo gifInfo3 = this.A0;
                        String str3 = gifInfo3.mSharpText;
                        h3.k(str3, this.B0, this.E0, 0, 0, this.D0, gifInfo3.mGid, str3, Boolean.valueOf(f2), str);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(this.v0)) {
                    b.a.e.l.d.a aVar2 = (b.a.e.l.d.a) b.a.e.e.l.d.h().n(this.v0, this.B0, new Object[0]);
                    if (aVar2 != null) {
                        this.a0 = false;
                        setGif(aVar2);
                    } else {
                        startLoading();
                        b.a.e.e.l.d.h().m(this.v0, this.B0, this.E0, this.D0);
                        return;
                    }
                }
                View.OnClickListener onClickListener = this.q0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.u0 = null;
            b.a.e.d.b bVar = this.Q;
            if (bVar != null) {
                bVar.close();
            }
            if (this.A0 != null) {
                this.A0 = null;
            }
            if (this.R != null) {
                this.R = null;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            this.y0.removeMessages(1);
            stopLoad();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) {
            try {
                if ((!this.b0 && !this.a0 && !this.j0) || z()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.Q != null && !this.b0 && !this.a0 && !this.j0) {
                    this.Q.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                A();
            }
            if (this.U && this.V) {
                canvas.save();
                this.W.draw(canvas);
                canvas.restore();
            }
            if (this.b0 && getLoadingBitmap(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.c0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(getLoadingBitmap(this), this.n0, this.m0, (Paint) null);
                canvas.restore();
            } else if (this.j0) {
                canvas.save();
                this.k0.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048593, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 == i4 && i3 == i5) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i3 - (getPaddingBottom() + paddingTop);
            int i6 = i2 - (paddingRight + paddingLeft);
            if (getLoadingBitmap(this) != null) {
                int width = loadingBm.getWidth();
                int height = loadingBm.getHeight();
                int i7 = ((i6 - width) / 2) + paddingLeft;
                int i8 = ((paddingBottom - height) / 2) + paddingTop;
                this.m0.set(i7, i8, width + i7, height + i8);
            }
            Drawable drawable = this.k0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.k0.getIntrinsicHeight();
                if (intrinsicWidth > i6) {
                    intrinsicWidth = i6;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i9 = ((i6 - intrinsicWidth) / 2) + paddingLeft;
                int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.k0.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStartTemporaryDetach();
            this.y0.removeMessages(1);
            stopLoad();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 4 || i2 == 8) {
                stopLoad();
            }
            if (this.U) {
                return;
            }
            if (i2 == 4 || i2 == 8) {
                stop();
            } else if (i2 == 0) {
                play();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.y0.removeMessages(1);
        }
    }

    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.t0 = false;
            b.a.e.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.S != 0) {
                this.S = 0;
            }
            gif.c(0);
            this.y0.removeMessages(1);
            this.y0.sendEmptyMessageDelayed(1, gif.b(this.S));
        }
    }

    public void playOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.z0 = true;
            play();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, b.a.e.f.a.h
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            GifInfo gifInfo = this.A0;
            if (gifInfo != null) {
                startLoad(gifInfo);
            }
            if (TextUtils.isEmpty(this.v0)) {
                return;
            }
            startLoad(this.v0, this.B0);
        }
    }

    public void release() {
        b.a.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            stopLoad();
            reset();
            if (!this.s0 || (bVar = this.Q) == null || bVar == null) {
                return;
            }
            bVar.close();
            this.Q = null;
        }
    }

    public void removeCallback(b.a.e.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.reset();
            this.Q = null;
            this.R = null;
            this.y0.removeCallbacksAndMessages(null);
            this.a0 = false;
            this.S = 0;
            GifInfo gifInfo = this.A0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    public void resetDefaultNoImageDay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.P = R.drawable.pic_expression_upload_selector;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.t0 = false;
            b.a.e.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            this.y0.removeMessages(1);
            this.y0.sendEmptyMessageDelayed(1, gif.b(this.S));
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            float f2 = this.c0;
            float f3 = this.i0;
            float f4 = f2 + f3;
            this.c0 = f4;
            if (f4 > 360.0f - f3) {
                this.c0 = 0.0f;
            }
            invalidate();
            m();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.o0 = z;
        }
    }

    public void setBgImage(b.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            this.u0 = aVar;
        }
    }

    public void setDefaultNoImageDay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.P = i2;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, xVar) == null) {
            this.F0 = xVar;
        }
    }

    public void setErrorResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.x0 = i2;
        }
    }

    public void setGif(b.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            setBackgroundDrawable(null);
            this.u0 = aVar;
            this.a0 = false;
            this.b0 = false;
            this.j0 = false;
            GifInfo gifInfo = this.A0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (aVar == null) {
                this.a0 = true;
                this.U = false;
                GifInfo gifInfo2 = this.A0;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                B();
                b.a.e.d.b bVar = this.Q;
                if (bVar != null) {
                    bVar.close();
                }
            } else if (aVar.l() == null) {
                if (!aVar.s()) {
                    this.U = true;
                    aVar.h(this);
                    this.b0 = false;
                }
                b.a.e.d.b bVar2 = this.Q;
                if (bVar2 != null) {
                    bVar2.close();
                }
            } else if (this.Q != null && aVar.l().equals(this.Q)) {
                if (this.S >= aVar.l().getFrameCount()) {
                    this.S = 0;
                }
                aVar.l().c(this.S);
                aVar.l().a(this.R, null);
                setImageBitmap(this.R);
                if (this.o0) {
                    resume();
                }
            } else {
                this.U = false;
                try {
                    if (this.R == null || (this.R.getWidth() != aVar.l().getWidth() && this.R.getHeight() != aVar.l().getHeight())) {
                        this.R = Bitmap.createBitmap(aVar.l().getWidth(), aVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.Q = aVar.l();
                    aVar.l().c(0);
                    aVar.l().a(this.R, null);
                    setImageBitmap(this.R);
                    if (this.o0) {
                        play();
                    }
                } catch (Throwable unused) {
                    A();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x002a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0012 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [b.a.e.d.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i2) {
        Interceptable interceptable;
        int i3;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048612, this, i2) != null) {
                return;
            }
        }
        ?? openRawResource = getContext().getResources().openRawResource(i2);
        byte[] bArr = null;
        try {
            try {
                try {
                    i3 = openRawResource.available();
                } catch (IOException e2) {
                    openRawResource = e2.getMessage();
                    BdLog.e((String) openRawResource);
                }
                try {
                    bArr = new byte[i3];
                    openRawResource.read(bArr);
                    openRawResource.close();
                    interceptable = i3;
                } catch (IOException e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i3;
                    if (bArr == null) {
                        return;
                    }
                    return;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i3;
                    if (bArr == null) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                i3 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                i3 = 0;
            }
            if (bArr == null || bArr.length < interceptable) {
                return;
            }
            b.a.e.l.d.a a2 = a.C0025a.b().a(bArr, 0, interceptable);
            this.s0 = true;
            setGif(a2);
        } catch (Throwable th) {
            try {
                openRawResource.close();
            } catch (IOException e7) {
                BdLog.e(e7.getMessage());
            }
            throw th;
        }
    }

    public void setHasNoImage(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.j0 = z;
            if (z) {
                this.b0 = false;
                this.a0 = false;
                if (this.k0 == null || this.l0 != i2) {
                    this.l0 = i2;
                    Drawable drawable = SkinManager.getDrawable(i2);
                    this.k0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.k0.getIntrinsicHeight();
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
                    this.k0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.k0 = null;
            }
            invalidate();
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.r0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (z) {
                startLoading();
            } else {
                stopLoading();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.q0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(b.a.q0.n.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            super.setOnClickListener(this);
            this.p0 = dVar;
        }
    }

    public void setPlayCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) {
            this.T = dVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.V = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            super.setSupportNoImage(z);
            this.C0 = z;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.B0 = i2;
        }
    }

    public void startLoad(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, gifInfo) == null) {
            this.B0 = 20;
            if (gifInfo == null) {
                this.A0 = null;
                B();
                return;
            }
            boolean f2 = r.f();
            i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.A0;
            if (!(gifInfo2 != null && (str = gifInfo.mDynamicUrl) != null && StringHelper.equals(str, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.A0.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.A0.mStaticUrl) && this.D0 == bdUniqueId)) {
                stopLoad();
            }
            this.A0 = gifInfo;
            this.D0 = bdUniqueId;
            this.v0 = null;
            reset();
            GifInfo gifInfo3 = this.A0;
            String str2 = f2 ? gifInfo3.mDynamicUrl : gifInfo3.mStaticUrl;
            b.a.e.e.l.d h2 = b.a.e.e.l.d.h();
            GifInfo gifInfo4 = this.A0;
            String str3 = gifInfo4.mSharpText;
            b.a.e.l.d.a aVar = (b.a.e.l.d.a) h2.n(str3, this.B0, gifInfo4.mGid, str3, Boolean.valueOf(f2), str2);
            if (aVar != null) {
                stopLoading();
                setGif(aVar);
            } else if (this.A0.mLoadFailed) {
                setGif(null);
                B();
            } else if (!b.a.e.e.l.d.h().j(this.B0) && this.C0) {
                setHasNoImage(true, this.P);
            } else if (z) {
            } else {
                startLoading();
                b.a.e.e.l.d h3 = b.a.e.e.l.d.h();
                GifInfo gifInfo5 = this.A0;
                String str4 = gifInfo5.mSharpText;
                h3.k(str4, this.B0, this.E0, 0, 0, this.D0, gifInfo5.mGid, str4, Boolean.valueOf(f2), str2);
            }
        }
    }

    public void startLoadGifOrBitmapByByte(byte[] bArr, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048624, this, bArr, bitmap, z) == null) || bArr == null || bArr.length <= 0 || bitmap == null) {
            return;
        }
        if (!b.a.e.e.l.d.h().j(this.B0) && this.C0) {
            setHasNoImage(true, this.P);
        } else if (!z) {
            if (bitmap != null) {
                setImageBitmap(bitmap);
            }
        } else {
            NSGif f2 = NSGif.f(bArr, 0, bArr.length);
            if (f2 == null) {
                return;
            }
            this.Q = f2;
            f2.c(0);
            Bitmap bitmap2 = this.R;
            if (bitmap2 == null || (bitmap2.getWidth() != this.Q.getWidth() && this.R.getHeight() != this.Q.getHeight())) {
                this.R = Bitmap.createBitmap(this.Q.getWidth(), this.Q.getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.Q.a(this.R, null);
            setImageBitmap(this.R);
            play();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || this.b0) {
            return;
        }
        this.b0 = true;
        m();
    }

    public void stop() {
        b.a.e.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (gif = getGif()) == null) {
            return;
        }
        this.y0.removeMessages(1);
        gif.c(0);
        gif.a(this.R, null);
        invalidate();
        A();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            stopLoading();
            this.a0 = false;
            this.j0 = false;
            if (this.A0 != null) {
                b.a.e.e.l.d.h().d(this.A0.mSharpText, this.B0, this.E0);
            }
            if (TextUtils.isEmpty(this.v0)) {
                return;
            }
            b.a.e.e.l.d.h().d(this.v0, this.B0, this.E0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.b0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.a0 || ((gifInfo = this.A0) != null && gifInfo.mLoadFailed) : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.P = R.drawable.pic_expression_upload_selector;
        this.U = false;
        this.V = true;
        this.m0 = new Rect();
        this.n0 = new Rect();
        this.o0 = true;
        this.r0 = false;
        this.s0 = false;
        this.t0 = false;
        this.x0 = R.drawable.image_group_load_f;
        this.y0 = new a(this, Looper.getMainLooper());
        this.B0 = 20;
        this.C0 = true;
        this.E0 = new c(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.W = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.W.getIntrinsicHeight());
        this.i0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap loadingBitmap = getLoadingBitmap(this);
            loadingBm = loadingBitmap;
            this.n0.set(0, 0, loadingBitmap.getWidth(), loadingBm.getHeight());
        }
        this.w0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    public void startLoad(String str, int i2) {
        BdUniqueId bdUniqueId;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, str, i2) == null) {
            this.B0 = i2;
            this.A0 = null;
            if (TextUtils.isEmpty(str)) {
                this.v0 = null;
                B();
                return;
            }
            i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (!(str.equals(this.v0) && i2 == this.B0 && bdUniqueId == this.D0)) {
                stopLoad();
            }
            this.D0 = bdUniqueId;
            reset();
            this.v0 = str;
            this.A0 = null;
            b.a.e.l.d.a aVar = (b.a.e.l.d.a) b.a.e.e.l.d.h().n(str, i2, new Object[0]);
            if (aVar != null) {
                stopLoading();
                setGif(aVar);
            } else if (!b.a.e.e.l.d.h().j(this.B0) && this.C0) {
                setHasNoImage(true, this.P);
            } else if (z) {
            } else {
                b.a.e.e.l.d.h().m(this.v0, i2, this.E0, this.D0);
            }
        }
    }
}
