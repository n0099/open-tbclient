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
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.d.a;
import c.a.d.h.a.h;
import c.a.o0.c1.t;
import c.a.o0.m.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
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
/* loaded from: classes5.dex */
public class GifView extends TbImageView implements Runnable, View.OnClickListener, h {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap e1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public boolean B0;
    public BitmapDrawable C0;
    public boolean D0;
    public boolean E0;
    public float F0;
    public float G0;
    public boolean H0;
    public Drawable I0;
    public int J0;
    public final Rect K0;
    public final Rect L0;
    public boolean M0;
    public d N0;
    public View.OnClickListener O0;
    public boolean P0;
    public boolean Q0;
    public boolean R0;
    public c.a.d.o.d.a S0;
    public String T0;
    public int U0;
    public int V0;
    public Handler W0;
    public boolean X0;
    public GifInfo Y0;
    public int Z0;
    public boolean a1;
    public BdUniqueId b1;
    public c.a.d.f.l.c<c.a.d.o.d.a> c1;
    public TbRichTextView.w d1;
    public int v0;
    public c.a.d.d.b w0;
    public Bitmap x0;
    public int y0;
    public c z0;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GifView gifView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.a.d.d.b gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.y0++;
                boolean z2 = false;
                if (this.a.y0 >= gif.getFrameCount()) {
                    if (this.a.X0) {
                        if (!this.a.P0) {
                            this.a.setVisibility(4);
                        }
                        this.a.X0 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.P0) {
                        this.a.y0 = gif.getFrameCount() - 1;
                    } else {
                        this.a.y0 = 0;
                    }
                    z2 = z;
                }
                gif.c(this.a.y0);
                gif.a(this.a.x0, null);
                this.a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.a.y0));
                } else {
                    this.a.Z();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;

        public b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifView;
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((b) aVar, str, i);
                this.a.N();
                this.a.setGif(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public static Bitmap W(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gifView)) == null) {
            Bitmap bitmap = e1;
            if (bitmap != null && !bitmap.isRecycled()) {
                return e1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                e1 = bitmapDrawable.getBitmap();
            }
            return e1;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.F();
            this.w0 = null;
            this.x0 = null;
            this.W0.removeCallbacksAndMessages(null);
            this.D0 = false;
            this.y0 = 0;
            GifInfo gifInfo = this.Y0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.E0) {
            return;
        }
        this.E0 = true;
        A();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            N();
            this.D0 = false;
            this.H0 = false;
            if (this.Y0 != null) {
                c.a.d.f.l.d.h().d(this.Y0.mSharpText, this.Z0, this.c1);
            }
            if (TextUtils.isEmpty(this.T0)) {
                return;
            }
            c.a.d.f.l.d.h().d(this.T0, this.Z0, this.c1);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.E0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public final boolean X() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D0 || ((gifInfo = this.Y0) != null && gifInfo.mLoadFailed) : invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.S0 = null;
            c.a.d.d.b bVar = this.w0;
            if (bVar != null) {
                bVar.close();
            }
            if (this.Y0 != null) {
                this.Y0 = null;
            }
            if (this.x0 != null) {
                this.x0 = null;
            }
        }
    }

    public final void Z() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.z0) == null || this.R0) {
            return;
        }
        cVar.onStop();
        this.R0 = true;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.R0 = false;
            c.a.d.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.y0 != 0) {
                this.y0 = 0;
            }
            gif.c(0);
            this.W0.removeMessages(1);
            this.W0.sendEmptyMessageDelayed(1, gif.b(this.y0));
        }
    }

    public void b0() {
        c.a.d.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            M();
            F();
            if (!this.Q0 || (bVar = this.w0) == null || bVar == null) {
                return;
            }
            bVar.close();
            this.w0 = null;
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.v0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.R0 = false;
            c.a.d.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            this.W0.removeMessages(1);
            this.W0.sendEmptyMessageDelayed(1, gif.b(this.y0));
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            TbRichTextView.w wVar = this.d1;
            if (wVar != null) {
                wVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.I0;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.I0.setState(getDrawableState());
            invalidate();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setImageResource(this, this.V0);
        }
    }

    public void f0(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gifInfo) == null) {
            this.Z0 = 20;
            if (gifInfo == null) {
                this.Y0 = null;
                e0();
                return;
            }
            boolean f2 = t.f();
            i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.Y0;
            if (!(gifInfo2 != null && (str = gifInfo.mDynamicUrl) != null && StringHelper.equals(str, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.Y0.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.Y0.mStaticUrl) && this.b1 == bdUniqueId)) {
                M();
            }
            this.Y0 = gifInfo;
            this.b1 = bdUniqueId;
            this.T0 = null;
            F();
            GifInfo gifInfo3 = this.Y0;
            String str2 = f2 ? gifInfo3.mDynamicUrl : gifInfo3.mStaticUrl;
            c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
            GifInfo gifInfo4 = this.Y0;
            String str3 = gifInfo4.mSharpText;
            c.a.d.o.d.a aVar = (c.a.d.o.d.a) h2.n(str3, this.Z0, gifInfo4.mGid, str3, Boolean.valueOf(f2), str2);
            if (aVar != null) {
                N();
                setGif(aVar);
            } else if (this.Y0.mLoadFailed) {
                setGif(null);
                e0();
            } else if (!c.a.d.f.l.d.h().j(this.Z0) && this.a1) {
                setHasNoImage(true, this.v0);
            } else if (z) {
            } else {
                L();
                c.a.d.f.l.d h3 = c.a.d.f.l.d.h();
                GifInfo gifInfo5 = this.Y0;
                String str4 = gifInfo5.mSharpText;
                h3.k(str4, this.Z0, this.c1, 0, 0, this.b1, gifInfo5.mGid, str4, Boolean.valueOf(f2), str2);
            }
        }
    }

    public void g0(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) {
            this.Z0 = i;
            this.Y0 = null;
            if (TextUtils.isEmpty(str)) {
                this.T0 = null;
                e0();
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
            if (!(str.equals(this.T0) && i == this.Z0 && bdUniqueId == this.b1)) {
                M();
            }
            this.b1 = bdUniqueId;
            F();
            this.T0 = str;
            this.Y0 = null;
            c.a.d.o.d.a aVar = (c.a.d.o.d.a) c.a.d.f.l.d.h().n(str, i, new Object[0]);
            if (aVar != null) {
                N();
                setGif(aVar);
            } else if (!c.a.d.f.l.d.h().j(this.Z0) && this.a1) {
                setHasNoImage(true, this.v0);
            } else if (z) {
            } else {
                c.a.d.f.l.d.h().m(this.T0, i, this.c1, this.b1);
            }
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.M0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.d.o.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.S0 : (c.a.d.o.d.a) invokeV.objValue;
    }

    public c.a.d.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.d.d.b bVar = this.w0;
            if (bVar == null) {
                Z();
                return null;
            }
            return bVar;
        }
        return (c.a.d.d.b) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.Y0 : (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            c.a.d.o.d.a aVar = this.S0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.d.o.d.a aVar = this.S0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? c.a.o0.r.v.d.a.b(this.U0) : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.T0 : (String) invokeV.objValue;
    }

    public void h0() {
        c.a.d.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (gif = getGif()) == null) {
            return;
        }
        this.W0.removeMessages(1);
        gif.c(0);
        gif.a(this.x0, null);
        invalidate();
        Z();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            d dVar = this.N0;
            if (dVar == null || !dVar.a(view)) {
                if (this.Y0 != null) {
                    boolean f2 = t.f();
                    GifInfo gifInfo = this.Y0;
                    String str = f2 ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                    c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                    GifInfo gifInfo2 = this.Y0;
                    String str2 = gifInfo2.mSharpText;
                    c.a.d.o.d.a aVar = (c.a.d.o.d.a) h2.n(str2, this.Z0, gifInfo2.mGid, str2, Boolean.valueOf(f2), str);
                    if (aVar != null) {
                        this.Y0.mLoadFailed = false;
                        setGif(aVar);
                    } else {
                        L();
                        c.a.d.f.l.d h3 = c.a.d.f.l.d.h();
                        GifInfo gifInfo3 = this.Y0;
                        String str3 = gifInfo3.mSharpText;
                        h3.k(str3, this.Z0, this.c1, 0, 0, this.b1, gifInfo3.mGid, str3, Boolean.valueOf(f2), str);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(this.T0)) {
                    c.a.d.o.d.a aVar2 = (c.a.d.o.d.a) c.a.d.f.l.d.h().n(this.T0, this.Z0, new Object[0]);
                    if (aVar2 != null) {
                        this.D0 = false;
                        setGif(aVar2);
                    } else {
                        L();
                        c.a.d.f.l.d.h().m(this.T0, this.Z0, this.c1, this.b1);
                        return;
                    }
                }
                View.OnClickListener onClickListener = this.O0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            this.W0.removeMessages(1);
            M();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            try {
                if ((!this.E0 && !this.D0 && !this.H0) || X()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.w0 != null && !this.E0 && !this.D0 && !this.H0) {
                    this.w0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                Z();
            }
            if (this.A0 && this.B0) {
                canvas.save();
                this.C0.draw(canvas);
                canvas.restore();
            }
            if (this.E0 && W(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.F0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(W(this), this.L0, this.K0, (Paint) null);
                canvas.restore();
            } else if (this.H0) {
                canvas.save();
                this.I0.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i == i3 && i2 == i4) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (W(this) != null) {
                int width = e1.getWidth();
                int height = e1.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.K0.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.I0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.I0.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.I0.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStartTemporaryDetach();
            this.W0.removeMessages(1);
            M();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i == 4 || i == 8) {
                M();
            }
            if (this.A0) {
                return;
            }
            if (i == 4 || i == 8) {
                h0();
            } else if (i == 0) {
                a0();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.W0.removeMessages(1);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, c.a.d.h.a.h
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.Y0;
            if (gifInfo != null) {
                f0(gifInfo);
            }
            if (TextUtils.isEmpty(this.T0)) {
                return;
            }
            g0(this.T0, this.Z0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f2 = this.F0;
            float f3 = this.G0;
            float f4 = f2 + f3;
            this.F0 = f4;
            if (f4 > 360.0f - f3) {
                this.F0 = 0.0f;
            }
            invalidate();
            A();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.M0 = z;
        }
    }

    public void setBgImage(c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.S0 = aVar;
        }
    }

    public void setDefaultNoImageDay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.v0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, wVar) == null) {
            this.d1 = wVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.V0 = i;
        }
    }

    public void setGif(c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, aVar) == null) {
            setBackgroundDrawable(null);
            this.S0 = aVar;
            this.D0 = false;
            this.E0 = false;
            this.H0 = false;
            GifInfo gifInfo = this.Y0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (aVar == null) {
                this.D0 = true;
                this.A0 = false;
                GifInfo gifInfo2 = this.Y0;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                e0();
                c.a.d.d.b bVar = this.w0;
                if (bVar != null) {
                    bVar.close();
                }
            } else if (aVar.l() == null) {
                if (!aVar.s()) {
                    this.A0 = true;
                    aVar.h(this);
                    this.E0 = false;
                }
                c.a.d.d.b bVar2 = this.w0;
                if (bVar2 != null) {
                    bVar2.close();
                }
            } else if (this.w0 != null && aVar.l().equals(this.w0)) {
                if (this.y0 >= aVar.l().getFrameCount()) {
                    this.y0 = 0;
                }
                aVar.l().c(this.y0);
                aVar.l().a(this.x0, null);
                setImageBitmap(this.x0);
                if (this.M0) {
                    d0();
                }
            } else {
                this.A0 = false;
                try {
                    if (this.x0 == null || (this.x0.getWidth() != aVar.l().getWidth() && this.x0.getHeight() != aVar.l().getHeight())) {
                        this.x0 = Bitmap.createBitmap(aVar.l().getWidth(), aVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.w0 = aVar.l();
                    aVar.l().c(0);
                    aVar.l().a(this.x0, null);
                    setImageBitmap(this.x0);
                    if (this.M0) {
                        a0();
                    }
                } catch (Throwable unused) {
                    Z();
                }
            }
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, str) == null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        c.a.d.o.d.a a2 = a.C0090a.b().a(GetFileData, 0, GetFileData.length);
        this.Q0 = true;
        setGif(a2);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [c.a.d.d.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i) {
        Interceptable interceptable;
        int i2;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048617, this, i) != null) {
                return;
            }
        }
        ?? openRawResource = getContext().getResources().openRawResource(i);
        byte[] bArr = null;
        try {
            try {
                try {
                    i2 = openRawResource.available();
                } catch (IOException e2) {
                    openRawResource = e2.getMessage();
                    BdLog.e((String) openRawResource);
                }
                try {
                    bArr = new byte[i2];
                    openRawResource.read(bArr);
                    openRawResource.close();
                    interceptable = i2;
                } catch (IOException e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr == null) {
                        return;
                    }
                    return;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr == null) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                i2 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                i2 = 0;
            }
            if (bArr == null || bArr.length < interceptable) {
                return;
            }
            c.a.d.o.d.a a2 = a.C0090a.b().a(bArr, 0, interceptable);
            this.Q0 = true;
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

    public void setHasNoImage(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.H0 = z;
            if (z) {
                this.E0 = false;
                this.D0 = false;
                if (this.I0 == null || this.J0 != i) {
                    this.J0 = i;
                    Drawable drawable = SkinManager.getDrawable(i);
                    this.I0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.I0.getIntrinsicHeight();
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
                    this.I0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.I0 = null;
            }
            invalidate();
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.P0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            if (z) {
                L();
            } else {
                N();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.O0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, dVar) == null) {
            super.setOnClickListener(this);
            this.N0 = dVar;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, cVar) == null) {
            this.z0 = cVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.B0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            super.setSupportNoImage(z);
            this.a1 = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.Z0 = i;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v0 = R.drawable.pic_expression_upload_selector;
        this.A0 = false;
        this.B0 = true;
        this.K0 = new Rect();
        this.L0 = new Rect();
        this.M0 = true;
        this.P0 = false;
        this.Q0 = false;
        this.R0 = false;
        this.V0 = R.drawable.obfuscated_res_0x7f080b6c;
        this.W0 = new a(this, Looper.getMainLooper());
        this.Z0 = 20;
        this.a1 = true;
        this.c1 = new b(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.C0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.C0.getIntrinsicHeight());
        this.G0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap W = W(this);
            e1 = W;
            this.L0.set(0, 0, W.getWidth(), e1.getHeight());
        }
        this.U0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }
}
