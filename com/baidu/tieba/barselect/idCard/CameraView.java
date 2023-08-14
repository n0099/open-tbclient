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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ImageUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.lg6;
import com.baidu.tieba.mg6;
import com.baidu.tieba.ng6;
import com.baidu.tieba.rg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class CameraView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public ng6 b;
    public View c;
    public MaskView d;
    public ImageView e;
    public TextView f;
    public LinearLayout g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    public final String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            switch (i) {
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

    public void setAutoPictureCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
        }
    }

    public void setInitNativeStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ng6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File a;
        public c b;
        public final /* synthetic */ CameraView c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ byte[] a;
            public final /* synthetic */ b b;

            public a(b bVar, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int orientation = ImageUtil.getOrientation(this.a);
                    b bVar = this.b;
                    this.b.b.a(bVar.c.b(bVar.a, this.a, orientation));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cameraView;
        }

        @Override // com.baidu.tieba.ng6.b
        public void a(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
                mg6.c(new a(this, bArr));
            }
        }

        public /* synthetic */ b(CameraView cameraView, a aVar) {
            this(cameraView);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.a = new b(this, null);
        new Handler(Looper.getMainLooper());
        d();
    }

    public final Bitmap b(File file, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        int height;
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, file, bArr, i)) == null) {
            try {
                Rect f = this.b.f();
                if (this.d.getWidth() != 0 && this.d.getHeight() != 0 && f.width() != 0 && f.height() != 0) {
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
                    if (i % 180 == 0) {
                        height = newInstance.getWidth();
                    } else {
                        height = newInstance.getHeight();
                    }
                    if (i % 180 == 0) {
                        width = newInstance.getHeight();
                    } else {
                        width = newInstance.getWidth();
                    }
                    Rect frameRect = this.d.getFrameRect();
                    int width2 = (frameRect.left * height) / this.d.getWidth();
                    int height2 = (frameRect.top * width) / this.d.getHeight();
                    int width3 = (frameRect.right * height) / this.d.getWidth();
                    int height3 = (frameRect.bottom * width) / this.d.getHeight();
                    if (f.top < 0) {
                        int height4 = (f.height() * getWidth()) / f.width();
                        int height5 = (((height4 + frameRect.height()) / 2) * getWidth()) / f.width();
                        int height6 = (((((height4 - frameRect.height()) / 2) * getWidth()) / f.width()) * width) / f.height();
                        height3 = (height5 * width) / f.height();
                        height2 = height6;
                    } else if (f.left < 0) {
                        int width4 = (f.width() * getHeight()) / f.height();
                        int width5 = (((width4 - this.d.getFrameRect().width()) / 2) * getHeight()) / f.height();
                        int width6 = (((width4 + this.d.getFrameRect().width()) / 2) * getHeight()) / f.height();
                        width2 = (width5 * height) / f.width();
                        width3 = (width6 * height) / f.width();
                    }
                    Rect rect = new Rect();
                    rect.left = width2;
                    rect.top = height2;
                    rect.right = width3;
                    rect.bottom = height3;
                    if (i % 180 == 90) {
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
                    options.outWidth = height;
                    options.outHeight = width;
                    int min = Math.min(Math.min(newInstance.getWidth(), newInstance.getHeight()), 640);
                    options.inSampleSize = ImageUtil.calculateInSampleSize(options, min, min);
                    options.inScaled = true;
                    options.inDensity = Math.max(options.outWidth, options.outHeight);
                    options.inTargetDensity = min;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
                    if (i != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(i);
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
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            return (Bitmap) invokeLLI.objValue;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lg6 lg6Var = new lg6(getContext());
            this.b = lg6Var;
            View a2 = lg6Var.a();
            this.c = a2;
            addView(a2);
            MaskView maskView = new MaskView(getContext());
            this.d = maskView;
            addView(maskView);
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            addView(imageView);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.g = linearLayout;
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, rg6.a(25));
            layoutParams.gravity = 17;
            TextView textView = new TextView(getContext());
            this.f = textView;
            textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08024b);
            this.f.setAlpha(0.5f);
            this.f.setPadding(rg6.a(10), 0, rg6.a(10), 0);
            this.g.addView(this.f, layoutParams);
            this.f.setGravity(17);
            this.f.setTextColor(-1);
            this.f.setTextSize(2, 14.0f);
            this.f.setText(c(-1));
            addView(this.g, layoutParams);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.start();
            setKeepScreenOn(true);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.stop();
            setKeepScreenOn(false);
        }
    }

    public ng6 getCameraControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (ng6) invokeV.objValue;
    }

    public void g(File file, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, file, cVar) == null) {
            this.a.a = file;
            this.a.b = cVar;
            this.b.b(this.a);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = i4 - i2;
            this.c.layout(i, 0, i3, i5);
            this.d.layout(i, 0, i3, i5);
            int a2 = rg6.a(250);
            int a3 = rg6.a(25);
            int width = (getWidth() - a2) / 2;
            int a4 = this.d.getFrameRect().bottom + rg6.a(16);
            int i6 = a2 + width;
            int i7 = a3 + a4;
            this.g.layout(width, a4, i6, i7);
            this.e.layout(width, a4, i6, i7);
        }
    }

    public void setMaskType(int i, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, context) == null) {
            this.d.setMaskType(i);
            boolean z = false;
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            int i2 = R.drawable.obfuscated_res_0x7f08024b;
            if (i != 1 && i != 2) {
                this.d.setVisibility(4);
                this.e.setVisibility(4);
                i2 = R.drawable.obfuscated_res_0x7f080245;
                z = true;
            }
            if (z) {
                this.e.setImageResource(i2);
                this.g.setVisibility(4);
            }
        }
    }

    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.b.c(i);
        }
    }
}
