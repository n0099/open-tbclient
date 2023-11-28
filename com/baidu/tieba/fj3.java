package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes5.dex */
public final class fj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements cl3<OutputStream, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ Bitmap.CompressFormat b;
        public final /* synthetic */ int c;

        public a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap, compressFormat, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bitmap;
            this.b = compressFormat;
            this.c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cl3
        /* renamed from: b */
        public Boolean a(OutputStream outputStream) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream)) == null) {
                Bitmap bitmap = this.a;
                if (bitmap != null) {
                    Bitmap.CompressFormat compressFormat = this.b;
                    if (compressFormat == null) {
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    }
                    if (bitmap.compress(compressFormat, this.c, outputStream)) {
                        z = true;
                        return Boolean.valueOf(z);
                    }
                }
                z = false;
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947766010, "Lcom/baidu/tieba/fj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947766010, "Lcom/baidu/tieba/fj3;");
                return;
            }
        }
        a = sm1.a;
    }

    public static Bitmap a(Bitmap bitmap, long j, boolean z) {
        InterceptResult invokeCommon;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (bitmap != null && j > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() <= j) {
                    byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
                    if (byteArrayOutputStream.size() >= j) {
                        byteArray = byteArrayOutputStream.toByteArray();
                    } else {
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < i) {
                            i3 = (i2 + i) / 2;
                            byteArrayOutputStream.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                            int i4 = (byteArrayOutputStream.size() > j ? 1 : (byteArrayOutputStream.size() == j ? 0 : -1));
                            if (i4 == 0) {
                                break;
                            } else if (i4 > 0) {
                                i = i3 - 1;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (i == i3 - 1) {
                            byteArrayOutputStream.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                        }
                        byteArray = byteArrayOutputStream.toByteArray();
                    }
                }
                if (z && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static boolean b(File file, File file2, int i) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, file, file2, i)) == null) {
            if (a) {
                Log.d("ImageUtils", "压缩图片");
            }
            if (file2 == null) {
                if (a) {
                    Log.e("ImageUtils", "dest file is null");
                }
                return false;
            } else if (i >= 0 && i <= 100) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile == null) {
                    if (a) {
                        Log.e("ImageUtils", "compress image，but decode bitmap is null");
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (FileNotFoundException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    km4.d(fileOutputStream);
                    return true;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    if (a) {
                        Log.e("ImageUtils", "压缩图片失败", e);
                    }
                    km4.d(fileOutputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    km4.d(fileOutputStream2);
                    throw th;
                }
            } else {
                if (a) {
                    Log.e("ImageUtils", "quality must be 0..100");
                }
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean c(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i)) == null) {
            try {
                if (a) {
                    Log.d("ImageUtils", "copyJpegExif oldFilePath:" + str + "，newFilePath：" + str2 + ",quality:" + i);
                }
                ExifInterface i2 = i(str);
                ExifInterface i3 = i(str2);
                if (i2 != null && i3 != null) {
                    Field[] fields = ExifInterface.class.getFields();
                    for (int i4 = 0; i4 < fields.length; i4++) {
                        String name = fields[i4].getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith("TAG")) {
                            String obj = fields[i4].get(ExifInterface.class).toString();
                            String attribute = i2.getAttribute(obj);
                            if (a) {
                                Log.d("ImageUtils", "fields name:" + obj + "，value：" + attribute);
                            }
                            if (!TextUtils.isEmpty(obj) && !TextUtils.equals(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, obj)) {
                                if (i < 100) {
                                    char c = 65535;
                                    switch (obj.hashCode()) {
                                        case -2093253645:
                                            if (obj.equals(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_Y_DIMENSION)) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        case -1896740140:
                                            if (obj.equals(androidx.exifinterface.media.ExifInterface.TAG_PIXEL_X_DIMENSION)) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case -666122239:
                                            if (obj.equals(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH)) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case 542970187:
                                            if (obj.equals(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH)) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c != 0) {
                                        if (c != 1) {
                                            if (c != 2) {
                                                if (c == 3) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (attribute != null) {
                                    i3.setAttribute(obj, attribute);
                                }
                            }
                        }
                    }
                    i3.saveAttributes();
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public static boolean n(File file, File file2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, file, file2, i)) == null) {
            if (a) {
                Log.d("ImageUtils", "rotateAndCompressImage");
            }
            if (file2 != null && file != null && file.exists() && file2.exists()) {
                if (i >= 0 && i <= 100) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                            if (decodeFile != null && decodeFile.getWidth() != 0 && decodeFile.getHeight() != 0) {
                                int f = f(file.getAbsolutePath());
                                if (f != 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postRotate(f);
                                    decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                try {
                                    decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream2);
                                    km4.d(fileOutputStream2);
                                    c(file.getAbsolutePath(), file2.getAbsolutePath(), i);
                                    return true;
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream = fileOutputStream2;
                                    if (a) {
                                        Log.e("ImageUtils", "rotateAndCompressImage fail:", e);
                                    }
                                    km4.d(fileOutputStream);
                                    return false;
                                } catch (OutOfMemoryError e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    if (a) {
                                        Log.e("ImageUtils", "rotateAndCompressImage fail:", e);
                                    }
                                    km4.d(fileOutputStream);
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    km4.d(fileOutputStream);
                                    throw th;
                                }
                            }
                            if (a) {
                                Log.e("ImageUtils", "compress image，but decode bitmap is null");
                            }
                            km4.d(null);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                    }
                } else {
                    if (a) {
                        Log.e("ImageUtils", "quality must be 0..100");
                    }
                    return false;
                }
            } else {
                if (a) {
                    Log.e("ImageUtils", "dest file or sourceFile is null");
                }
                return false;
            }
        } else {
            return invokeLLI.booleanValue;
        }
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (!file.getParentFile().exists()) {
                return file.getParentFile().mkdirs();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Bitmap e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            try {
                return MediaStore.Images.Media.getBitmap(g63.K().getContentResolver(), uri);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap g(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return h(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static ExifInterface i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public static File k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return l(ur2.V().I().k(), str);
        }
        return (File) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        ExifInterface i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (i = i(str)) == null) {
                return 0;
            }
            int attributeInt = i.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        }
        return invokeL.intValue;
    }

    public static Bitmap h(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, drawable, i, i2)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i > 0 && i2 > 0) {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                try {
                    bitmap = Bitmap.createBitmap(i, i2, config);
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, i, i2);
                        drawable.draw(canvas);
                    }
                } catch (Exception | OutOfMemoryError e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static int[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            if (iArr[0] != 0) {
                return iArr;
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, new int[1]);
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
            EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
            egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
            GLES10.glGetIntegerv(3379, iArr, 0);
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
            egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
            egl10.eglTerminate(eglGetDisplay);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static File l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (a) {
                Log.d("ImageUtils", "获取temp路径");
            }
            String str3 = "swan_tmp_" + System.currentTimeMillis() + "_" + str2;
            File file = null;
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(str);
                if (file2.exists()) {
                    file = new File(file2, str3);
                } else if (file2.mkdirs()) {
                    file = new File(file2, str3);
                }
                if (file != null && !file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (a && file != null) {
                Log.e("ImageUtils", "temp路径:" + file.getAbsolutePath());
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static Uri m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith(DownloadConstants.LOCAL_DATA_URI_PREFIX)) {
                if (!str.startsWith("/")) {
                    return null;
                }
                return Uri.fromFile(new File(str));
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean o(Bitmap bitmap, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65551, null, bitmap, str, i)) == null) {
            return p(bitmap, str, i, Bitmap.CompressFormat.JPEG);
        }
        return invokeLLI.booleanValue;
    }

    public static boolean p(Bitmap bitmap, String str, int i, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65552, null, bitmap, str, i, compressFormat)) == null) {
            return q(str, new a(bitmap, compressFormat, i));
        }
        return invokeLLIL.booleanValue;
    }

    public static boolean q(String str, cl3<OutputStream, Boolean> cl3Var) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, cl3Var)) == null) {
            boolean z = false;
            if (!km4.w()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    File file = new File(str);
                    if (cl3Var != null && d(file)) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            if (cl3Var.a(fileOutputStream).booleanValue()) {
                                z = true;
                                km4.d(fileOutputStream);
                                return z;
                            }
                            fileOutputStream2 = fileOutputStream;
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            if (a) {
                                Log.e("ImageUtils", "保存图片失败", e);
                            }
                            km4.d(fileOutputStream2);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            km4.d(fileOutputStream2);
                            throw th;
                        }
                    }
                    fileOutputStream = fileOutputStream2;
                    km4.d(fileOutputStream);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static void r(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) && str != null && context != null) {
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        }
    }
}
