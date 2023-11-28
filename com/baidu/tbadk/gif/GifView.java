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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.d7;
import com.baidu.tieba.e7;
import com.baidu.tieba.pt5;
import com.baidu.tieba.vu4;
import com.baidu.tieba.w25;
import com.baidu.tieba.yf;
import com.baidu.tieba.z4;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class GifView extends TbClipImageView implements Runnable, View.OnClickListener, yf {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap L;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public zh5 B;
    public int C;
    public Handler D;
    public boolean E;
    public GifInfo F;
    public int G;
    public boolean H;
    public BdUniqueId I;
    public BdResourceCallback<BdImage> J;
    public TbRichTextView.x K;
    public int a;
    public e7 b;
    public Bitmap c;
    public int d;
    public c e;
    public boolean f;
    public boolean g;
    public boolean h;
    public BitmapDrawable i;
    public boolean j;
    public boolean k;
    public float l;
    public float m;
    public boolean n;
    public Drawable o;
    public int p;
    public final Rect q;
    public final Rect r;
    public boolean s;
    public vu4 t;
    public View.OnClickListener u;
    public boolean v;
    public boolean w;
    public boolean x;
    public BdImage y;
    public String z;

    /* loaded from: classes5.dex */
    public interface c {
        void onStop();
    }

    /* loaded from: classes5.dex */
    public class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;

        public a(GifView gifView) {
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

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((a) bdImage, str, i);
                this.a.stopLoading();
                this.a.setGif(bdImage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<GifView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GifView gifView) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView};
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
            this.a = new WeakReference<>(gifView);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                GifView gifView = this.a.get();
                if (gifView == null) {
                    return;
                }
                gifView.e();
            }
        }
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
        this.a = R.drawable.pic_expression_upload_selector;
        this.f = false;
        this.g = true;
        this.h = true;
        this.q = new Rect();
        this.r = new Rect();
        this.s = true;
        this.v = false;
        this.w = false;
        this.x = false;
        this.C = R.drawable.image_group_load_f;
        this.D = new b(this);
        this.G = 20;
        this.H = true;
        this.J = new a(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.i = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.i.getIntrinsicHeight());
        this.m = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap f = f(this);
            L = f;
            this.r.set(0, 0, f.getWidth(), L.getHeight());
        }
        this.A = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.K;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i == 4 || i == 8) {
                stopLoad();
            }
            if (this.f) {
                return;
            }
            if (i != 4 && i != 8) {
                if (i == 0) {
                    j();
                    return;
                }
                return;
            }
            r();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.s = z;
        }
    }

    public void setBgImage(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bdImage) == null) {
            this.y = bdImage;
        }
    }

    public void setDefaultNoImageDay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, xVar) == null) {
            this.K = xVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.C = i;
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, str) != null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        BdImage a2 = d7.a.b().a(GetFileData, 0, GetFileData.length);
        this.w = true;
        setGif(a2);
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.v = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            if (z) {
                startLoading();
            } else {
                stopLoading();
            }
        }
    }

    public void setLoadCallback(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, zh5Var) == null) {
            this.B = zh5Var;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.u = onClickListener;
        }
    }

    public void setOnInterceptClickListener(vu4 vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, vu4Var) == null) {
            super.setOnClickListener(this);
            this.t = vu4Var;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public void setShowError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.h = z;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.g = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            super.setSupportNoImage(z);
            this.H = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.G = i;
        }
    }

    public static Bitmap f(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gifView)) == null) {
            Bitmap bitmap = L;
            if (bitmap != null && !bitmap.isRecycled()) {
                return L;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                L = bitmapDrawable.getBitmap();
            }
            return L;
        }
        return (Bitmap) invokeL.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.z = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.o;
            if (drawable != null && drawable.isStateful()) {
                this.o.setState(getDrawableState());
                invalidate();
            }
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.j && ((gifInfo = this.F) == null || !gifInfo.mLoadFailed)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public BdImage getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.y;
        }
        return (BdImage) invokeV.objValue;
    }

    public e7 getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e7 e7Var = this.b;
            if (e7Var == null) {
                i();
                return null;
            }
            return e7Var;
        }
        return (e7) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.F;
        }
        return (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdImage bdImage = this.y;
            if (bdImage == null) {
                return 0;
            }
            return bdImage.getHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BdImage bdImage = this.y;
            if (bdImage == null) {
                return 0;
            }
            return bdImage.getWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return w25.b(this.A);
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.y = null;
            e7 e7Var = this.b;
            if (e7Var != null) {
                e7Var.close();
            }
            if (this.F != null) {
                this.F = null;
            }
            if (this.c != null) {
                this.c = null;
            }
        }
    }

    public final void i() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (cVar = this.e) != null && !this.x) {
            cVar.onStop();
            this.x = true;
        }
    }

    public void k() {
        e7 e7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            stopLoad();
            reset();
            if (this.w && (e7Var = this.b) != null && e7Var != null) {
                e7Var.close();
                this.b = null;
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a = R.drawable.pic_expression_upload_selector;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x = false;
            e7 gif = getGif();
            if (gif == null) {
                return;
            }
            this.D.removeMessages(1);
            this.D.sendEmptyMessageDelayed(1, gif.b(this.d));
        }
    }

    public final void nextLoadingFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.h) {
                SkinManager.setImageResource(this, this.C);
            }
            zh5 zh5Var = this.B;
            if (zh5Var != null) {
                zh5Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
            this.D.removeMessages(1);
            stopLoad();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStartTemporaryDetach();
            this.D.removeMessages(1);
            stopLoad();
        }
    }

    public void r() {
        e7 gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || (gif = getGif()) == null) {
            return;
        }
        this.D.removeMessages(1);
        gif.c(0);
        gif.a(this.c, null);
        invalidate();
        i();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.tieba.yf
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            GifInfo gifInfo = this.F;
            if (gifInfo != null) {
                p(gifInfo);
            }
            if (!TextUtils.isEmpty(this.z)) {
                q(this.z, this.G);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.reset();
            this.b = null;
            this.c = null;
            this.D.removeCallbacksAndMessages(null);
            this.j = false;
            this.d = 0;
            GifInfo gifInfo = this.F;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            float f = this.l;
            float f2 = this.m;
            float f3 = f + f2;
            this.l = f3;
            if (f3 > 360.0f - f2) {
                this.l = 0.0f;
            }
            invalidate();
            nextLoadingFrame();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLoading() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && !this.k) {
            this.k = true;
            nextLoadingFrame();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.k = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public final void e() {
        e7 gif;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (gif = getGif()) == null) {
            return;
        }
        int i = this.d + 1;
        this.d = i;
        boolean z2 = false;
        if (i >= gif.getFrameCount()) {
            if (this.E) {
                if (!this.v) {
                    setVisibility(4);
                }
                this.E = false;
                z = true;
            } else {
                z = false;
            }
            if (this.v) {
                this.d = gif.getFrameCount() - 1;
            } else {
                this.d = 0;
            }
            z2 = z;
        }
        gif.c(this.d);
        gif.a(this.c, null);
        invalidate();
        this.D.removeMessages(1);
        if (!z2) {
            this.D.sendEmptyMessageDelayed(1, gif.b(this.d));
        } else {
            i();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.x = false;
            e7 gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.d != 0) {
                this.d = 0;
            }
            gif.c(0);
            this.D.removeMessages(1);
            this.D.sendEmptyMessageDelayed(1, gif.b(this.d));
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            stopLoading();
            this.j = false;
            this.n = false;
            if (this.F != null) {
                BdResourceLoader.getInstance().cancelLoad(this.F.mSharpText, this.G, this.J);
            }
            if (!TextUtils.isEmpty(this.z)) {
                BdResourceLoader.getInstance().cancelLoad(this.z, this.G, this.J);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            vu4 vu4Var = this.t;
            if (vu4Var != null && vu4Var.a(view2)) {
                return;
            }
            if (this.F != null) {
                boolean c2 = pt5.c();
                GifInfo gifInfo = this.F;
                if (c2) {
                    str = gifInfo.mDynamicUrl;
                } else {
                    str = gifInfo.mStaticUrl;
                }
                BdResourceLoader bdResourceLoader = BdResourceLoader.getInstance();
                GifInfo gifInfo2 = this.F;
                String str2 = gifInfo2.mSharpText;
                BdImage bdImage = (BdImage) bdResourceLoader.loadResourceFromMemery(str2, this.G, gifInfo2.mGid, str2, Boolean.valueOf(c2), str);
                if (bdImage != null) {
                    this.F.mLoadFailed = false;
                    setGif(bdImage);
                } else {
                    startLoading();
                    BdResourceLoader bdResourceLoader2 = BdResourceLoader.getInstance();
                    GifInfo gifInfo3 = this.F;
                    String str3 = gifInfo3.mSharpText;
                    bdResourceLoader2.loadResource(str3, this.G, this.J, 0, 0, this.I, gifInfo3.mGid, str3, Boolean.valueOf(c2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.z)) {
                BdImage bdImage2 = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.z, this.G, new Object[0]);
                if (bdImage2 != null) {
                    this.j = false;
                    setGif(bdImage2);
                } else {
                    startLoading();
                    BdResourceLoader.getInstance().loadResource(this.z, this.G, this.J, this.I);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.u;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, canvas) == null) {
            try {
                if ((!this.k && !this.j && !this.n) || g()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.b != null && !this.k && !this.j && !this.n) {
                    this.b.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                i();
            }
            if (this.f && this.g) {
                canvas.save();
                this.i.draw(canvas);
                canvas.restore();
            }
            if (this.k && f(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.l, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(f(this), this.r, this.q, (Paint) null);
                canvas.restore();
            } else if (this.n) {
                canvas.save();
                this.o.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void p(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, gifInfo) == null) {
            this.G = 20;
            if (gifInfo == null) {
                this.F = null;
                o();
                return;
            }
            zh5 zh5Var = this.B;
            if (zh5Var != null) {
                zh5Var.a();
            }
            boolean c2 = pt5.c();
            z4 c3 = a5.c(getContext());
            if (c3 != null) {
                bdUniqueId = c3.getUniqueId();
                z = c3.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.F;
            if (gifInfo2 != null && (str2 = gifInfo.mDynamicUrl) != null && StringHelper.equals(str2, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.F.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.F.mStaticUrl) && this.I == bdUniqueId) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                stopLoad();
            }
            this.F = gifInfo;
            this.I = bdUniqueId;
            this.z = null;
            reset();
            GifInfo gifInfo3 = this.F;
            if (c2) {
                str = gifInfo3.mDynamicUrl;
            } else {
                str = gifInfo3.mStaticUrl;
            }
            BdResourceLoader bdResourceLoader = BdResourceLoader.getInstance();
            GifInfo gifInfo4 = this.F;
            String str3 = gifInfo4.mSharpText;
            BdImage bdImage = (BdImage) bdResourceLoader.loadResourceFromMemery(str3, this.G, gifInfo4.mGid, str3, Boolean.valueOf(c2), str);
            if (bdImage != null) {
                stopLoading();
                setGif(bdImage);
            } else if (this.F.mLoadFailed) {
                setGif(null);
                o();
            } else if (!BdResourceLoader.getInstance().isNeedLoad(this.G) && this.H) {
                setHasNoImage(true, this.a);
            } else if (z) {
            } else {
                startLoading();
                BdResourceLoader bdResourceLoader2 = BdResourceLoader.getInstance();
                GifInfo gifInfo5 = this.F;
                String str4 = gifInfo5.mSharpText;
                bdResourceLoader2.loadResource(str4, this.G, this.J, 0, 0, this.I, gifInfo5.mGid, str4, Boolean.valueOf(c2), str);
            }
        }
    }

    public void setGif(BdImage bdImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bdImage) == null) {
            setBackgroundDrawable(null);
            this.y = bdImage;
            this.j = false;
            this.k = false;
            this.n = false;
            GifInfo gifInfo = this.F;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (bdImage == null) {
                this.j = true;
                this.f = false;
                GifInfo gifInfo2 = this.F;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                o();
                e7 e7Var = this.b;
                if (e7Var != null) {
                    e7Var.close();
                    return;
                }
                return;
            }
            zh5 zh5Var = this.B;
            if (zh5Var != null) {
                zh5Var.onLoadSuccess();
            }
            if (bdImage.getGif() == null) {
                if (!bdImage.isEmotionGif()) {
                    this.f = true;
                    bdImage.drawImageTo(this);
                    this.k = false;
                }
                e7 e7Var2 = this.b;
                if (e7Var2 != null) {
                    e7Var2.close();
                }
            } else if (this.b != null && bdImage.getGif().equals(this.b)) {
                if (this.d >= bdImage.getGif().getFrameCount()) {
                    this.d = 0;
                }
                bdImage.getGif().c(this.d);
                bdImage.getGif().a(this.c, null);
                setImageBitmap(this.c);
                if (this.s) {
                    n();
                }
            } else {
                this.f = false;
                try {
                    if (this.c == null || (this.c.getWidth() != bdImage.getGif().getWidth() && this.c.getHeight() != bdImage.getGif().getHeight())) {
                        this.c = Bitmap.createBitmap(bdImage.getGif().getWidth(), bdImage.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.b = bdImage.getGif();
                    bdImage.getGif().c(0);
                    bdImage.getGif().a(this.c, null);
                    setImageBitmap(this.c);
                    if (this.s) {
                        j();
                    }
                } catch (Throwable unused) {
                    i();
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i == i3 && i2 == i4) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (f(this) != null) {
                int width = L.getWidth();
                int height = L.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.q.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.o;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.o.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.o.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            }
        }
    }

    public void q(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, str, i) == null) {
            this.G = i;
            this.F = null;
            if (TextUtils.isEmpty(str)) {
                this.z = null;
                o();
                return;
            }
            zh5 zh5Var = this.B;
            if (zh5Var != null) {
                zh5Var.a();
            }
            z4 c2 = a5.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (str.equals(this.z) && i == this.G && bdUniqueId == this.I) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                stopLoad();
                if (!TextUtils.isEmpty(this.z)) {
                    setImageDrawable(null);
                    setBgImage(null);
                }
            }
            this.I = bdUniqueId;
            reset();
            this.z = str;
            this.F = null;
            BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(str, i, new Object[0]);
            if (bdImage != null) {
                stopLoading();
                setGif(bdImage);
            } else if (!BdResourceLoader.getInstance().isNeedLoad(this.G) && this.H) {
                setHasNoImage(true, this.a);
            } else if (z) {
            } else {
                BdResourceLoader.getInstance().loadResource(this.z, i, this.J, this.I);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [com.baidu.tieba.d7] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i) {
        Interceptable interceptable;
        int i2;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048616, this, i) != null) {
                return;
            }
        }
        ?? openRawResource = getContext().getResources().openRawResource(i);
        byte[] bArr = null;
        try {
            try {
                try {
                    i2 = openRawResource.available();
                } catch (IOException e) {
                    openRawResource = e.getMessage();
                    BdLog.e((String) openRawResource);
                }
                try {
                    bArr = new byte[i2];
                    openRawResource.read(bArr);
                    openRawResource.close();
                    interceptable = i2;
                } catch (IOException e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr != null) {
                    }
                    return;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr != null) {
                    }
                }
            } catch (IOException e4) {
                e = e4;
                i2 = 0;
            } catch (OutOfMemoryError e5) {
                e = e5;
                i2 = 0;
            }
            if (bArr != null && bArr.length >= interceptable) {
                BdImage a2 = d7.a.b().a(bArr, 0, interceptable);
                this.w = true;
                setGif(a2);
            }
        } catch (Throwable th) {
            try {
                openRawResource.close();
            } catch (IOException e6) {
                BdLog.e(e6.getMessage());
            }
            throw th;
        }
    }

    public void setHasNoImage(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.n = z;
            if (z) {
                this.k = false;
                this.j = false;
                if (this.o == null || this.p != i) {
                    this.p = i;
                    Drawable drawable = SkinManager.getDrawable(i);
                    this.o = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.o.getIntrinsicHeight();
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
                    this.o.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.o = null;
            }
            invalidate();
        }
    }
}
