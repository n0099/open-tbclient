package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.c0.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes12.dex */
public class CameraView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NATIVE_AUTH_FAIL = 11;
    public static final int NATIVE_AUTH_INIT_SUCCESS = 0;
    public static final int NATIVE_INIT_FAIL = 12;
    public static final int NATIVE_SOLOAD_FAIL = 10;
    public static final int ORIENTATION_HORIZONTAL = 90;
    public static final int ORIENTATION_INVERT = 270;
    public static final int ORIENTATION_PORTRAIT = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f42216e;

    /* renamed from: f  reason: collision with root package name */
    public d f42217f;

    /* renamed from: g  reason: collision with root package name */
    public View f42218g;

    /* renamed from: h  reason: collision with root package name */
    public MaskView f42219h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f42220i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42221j;
    public LinearLayout k;

    /* loaded from: classes12.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File a;

        /* renamed from: b  reason: collision with root package name */
        public c f42222b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CameraView f42223c;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f42224e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f42225f;

            public a(b bVar, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f42225f = bVar;
                this.f42224e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int orientation = ImageUtil.getOrientation(this.f42224e);
                    b bVar = this.f42225f;
                    this.f42225f.f42222b.a(bVar.f42223c.b(bVar.a, this.f42224e, orientation));
                }
            }
        }

        public b(CameraView cameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42223c = cameraView;
        }

        @Override // c.a.t0.c0.c.d.b
        public void a(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
                c.a.t0.c0.c.c.c(new a(this, bArr));
            }
        }

        public /* synthetic */ b(CameraView cameraView, a aVar) {
            this(cameraView);
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42216e = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
    }

    public final Bitmap b(File file, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(1048576, this, file, bArr, i2)) != null) {
            return (Bitmap) invokeLLI.objValue;
        }
        try {
            Rect f2 = this.f42217f.f();
            if (this.f42219h.getWidth() != 0 && this.f42219h.getHeight() != 0 && f2.width() != 0 && f2.height() != 0) {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
                int width = i2 % 180 == 0 ? newInstance.getWidth() : newInstance.getHeight();
                int height = i2 % 180 == 0 ? newInstance.getHeight() : newInstance.getWidth();
                Rect frameRect = this.f42219h.getFrameRect();
                int width2 = (frameRect.left * width) / this.f42219h.getWidth();
                int height2 = (frameRect.top * height) / this.f42219h.getHeight();
                int width3 = (frameRect.right * width) / this.f42219h.getWidth();
                int height3 = (frameRect.bottom * height) / this.f42219h.getHeight();
                if (f2.top < 0) {
                    int height4 = (f2.height() * getWidth()) / f2.width();
                    int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / f2.width();
                    int height6 = (((((height4 - frameRect.height()) / 2) * getWidth()) / f2.width()) * height) / f2.height();
                    height3 = (height5 * height) / f2.height();
                    height2 = height6;
                } else if (f2.left < 0) {
                    int width4 = (f2.width() * getHeight()) / f2.height();
                    int width5 = (((width4 - this.f42219h.getFrameRect().width()) / 2) * getHeight()) / f2.height();
                    int width6 = (((width4 + this.f42219h.getFrameRect().width()) / 2) * getHeight()) / f2.height();
                    width2 = (width5 * width) / f2.width();
                    width3 = (width6 * width) / f2.width();
                }
                Rect rect = new Rect();
                rect.left = width2;
                rect.top = height2;
                rect.right = width3;
                rect.bottom = height3;
                if (i2 % 180 == 90) {
                    int width7 = newInstance.getWidth() / 2;
                    int height7 = newInstance.getHeight() / 2;
                    int height8 = rect.height();
                    int width8 = rect.width();
                    rect.left = width7 - (height8 / 2);
                    rect.top = height7 - (width8 / 2);
                    rect.right = width7 + (height8 / 2);
                    rect.bottom = height7 + (width8 / 2);
                    rect.sort();
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.outWidth = width;
                options.outHeight = height;
                int min = Math.min(Math.min(newInstance.getWidth(), newInstance.getHeight()), 640);
                options.inSampleSize = ImageUtil.calculateInSampleSize(options, min, min);
                options.inScaled = true;
                options.inDensity = Math.max(options.outWidth, options.outHeight);
                options.inTargetDensity = min;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
                if (i2 != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(i2);
                    Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
                    if (decodeRegion != createBitmap) {
                        decodeRegion.recycle();
                    }
                    decodeRegion = createBitmap;
                }
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    decodeRegion.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return decodeRegion;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            switch (i2) {
                case 0:
                    return "";
                case 1:
                case 8:
                case 9:
                default:
                    return "请将身份证置于取景框内";
                case 2:
                    return "身份证模糊，请重新尝试";
                case 3:
                    return "身份证反光，请重新尝试";
                case 4:
                    return "请将身份证前后反转再进行识别";
                case 5:
                    return "请拿稳镜头和身份证";
                case 6:
                    return "请将镜头靠近身份证";
                case 7:
                    return "请将身份证完整置于取景框内";
                case 10:
                    return "本地SO库加载失败";
                case 11:
                    return "本地质量控制授权失败";
                case 12:
                    return "本地模型加载失败";
            }
        }
        return (String) invokeI.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.c0.c.b bVar = new c.a.t0.c0.c.b(getContext());
            this.f42217f = bVar;
            View a2 = bVar.a();
            this.f42218g = a2;
            addView(a2);
            MaskView maskView = new MaskView(getContext());
            this.f42219h = maskView;
            addView(maskView);
            ImageView imageView = new ImageView(getContext());
            this.f42220i = imageView;
            addView(imageView);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.k = linearLayout;
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.a.t0.c0.e.b.a(25));
            layoutParams.gravity = 17;
            TextView textView = new TextView(getContext());
            this.f42221j = textView;
            textView.setBackgroundResource(R.drawable.bd_ocr_round_corner);
            this.f42221j.setAlpha(0.5f);
            this.f42221j.setPadding(c.a.t0.c0.e.b.a(10), 0, c.a.t0.c0.e.b.a(10), 0);
            this.k.addView(this.f42221j, layoutParams);
            this.f42221j.setGravity(17);
            this.f42221j.setTextColor(-1);
            this.f42221j.setTextSize(2, 14.0f);
            this.f42221j.setText(c(-1));
            addView(this.k, layoutParams);
        }
    }

    public d getCameraControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42217f : (d) invokeV.objValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i5 - i3;
            this.f42218g.layout(i2, 0, i4, i6);
            this.f42219h.layout(i2, 0, i4, i6);
            int a2 = c.a.t0.c0.e.b.a(250);
            int a3 = c.a.t0.c0.e.b.a(25);
            int width = (getWidth() - a2) / 2;
            int a4 = this.f42219h.getFrameRect().bottom + c.a.t0.c0.e.b.a(16);
            int i7 = a2 + width;
            int i8 = a3 + a4;
            this.k.layout(width, a4, i7, i8);
            this.f42220i.layout(width, a4, i7, i8);
        }
    }

    public void setAutoPictureCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
        }
    }

    public void setInitNativeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }

    public void setMaskType(int i2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, context) == null) {
            this.f42219h.setMaskType(i2);
            boolean z = false;
            this.f42219h.setVisibility(0);
            this.f42220i.setVisibility(0);
            int i3 = R.drawable.bd_ocr_hint_align_id_card;
            if (i2 == 1) {
                i3 = R.drawable.bd_ocr_round_corner;
            } else if (i2 != 2) {
                this.f42219h.setVisibility(4);
                this.f42220i.setVisibility(4);
                z = true;
            } else {
                i3 = R.drawable.bd_ocr_round_corner;
            }
            if (z) {
                this.f42220i.setImageResource(i3);
                this.k.setVisibility(4);
            }
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f42217f.c(i2);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f42217f.start();
            setKeepScreenOn(true);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f42217f.stop();
            setKeepScreenOn(false);
        }
    }

    public void takePicture(File file, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, file, cVar) == null) {
            this.f42216e.a = file;
            this.f42216e.f42222b = cVar;
            this.f42217f.b(this.f42216e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42216e = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.f42216e = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
    }
}
