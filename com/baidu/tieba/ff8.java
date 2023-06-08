package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class ff8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(final String filePath, final int i, final int i2, final cf8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{filePath, Integer.valueOf(i), Integer.valueOf(i2), callback}) == null) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ah.d(new Runnable() { // from class: com.baidu.tieba.bf8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ff8.b(filePath, i, i2, callback);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00b8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00ba */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[Catch: all -> 0x0126, Exception -> 0x012a, TryCatch #12 {Exception -> 0x012a, all -> 0x0126, blocks: (B:7:0x0039, B:9:0x004f, B:20:0x0073, B:21:0x0079, B:24:0x0089, B:47:0x00d6, B:51:0x00e7, B:53:0x00ee, B:54:0x00f7, B:15:0x0059), top: B:89:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v12, types: [int] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(final String filePath, int i, int i2, final cf8 callback) {
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r7;
        Object obj;
        Bitmap bitmap;
        BitmapFactory.Options options;
        int i3;
        int i4;
        Bitmap.CompressFormat compressFormat;
        int ceil;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{filePath, Integer.valueOf(i), Integer.valueOf(i2), callback}) == null) {
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            final String str = filePath + "_backup";
            Bitmap bitmap2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeFile(filePath, options);
                    try {
                        i3 = options.outWidth;
                        i4 = options.outHeight;
                        compressFormat = Bitmap.CompressFormat.JPEG;
                        String str2 = options.outMimeType;
                        Intrinsics.checkNotNullExpressionValue(str2, "options.outMimeType");
                        if (StringsKt__StringsJVMKt.endsWith$default(str2, "png", false, 2, null)) {
                            compressFormat = Bitmap.CompressFormat.PNG;
                        }
                    } catch (Exception e) {
                        e = e;
                        obj = null;
                        bitmap2 = bitmap;
                        bitmap = obj;
                        r7 = obj;
                        try {
                            e.printStackTrace();
                            g(bitmap2, r7, byteArrayOutputStream, bitmap);
                            ah.e(new Runnable() { // from class: com.baidu.tieba.ye8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        ff8.f(cf8.this, filePath);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            th = th;
                            g(bitmap2, r7, byteArrayOutputStream, bitmap);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r7 = 0;
                        bitmap2 = bitmap;
                        bitmap = r7;
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    obj = null;
                } catch (Throwable th3) {
                    th = th3;
                    r7 = 0;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                r7 = 0;
            }
            try {
                try {
                    try {
                        if (i4 <= i && i4 <= i2) {
                            ceil = 1;
                            if (ceil > 1) {
                                options.inSampleSize = ceil;
                                bitmap = BitmapFactory.decodeFile(filePath, options);
                            }
                            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                            r7 = byteArrayOutputStream.toByteArray().length;
                            if (r7 > 5242880) {
                                if (ceil > 1) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                    Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                                    if (decodeStream.compress(compressFormat, 100, fileOutputStream)) {
                                        fileOutputStream.flush();
                                    }
                                    ah.e(new Runnable() { // from class: com.baidu.tieba.we8
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                ff8.c(cf8.this, str);
                                            }
                                        }
                                    });
                                    g(decodeStream, byteArrayInputStream, byteArrayOutputStream, fileOutputStream);
                                    g(decodeStream, byteArrayInputStream, byteArrayOutputStream, fileOutputStream);
                                    return;
                                }
                                ah.e(new Runnable() { // from class: com.baidu.tieba.ve8
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            ff8.d(cf8.this, filePath);
                                        }
                                    }
                                });
                                g(bitmap, null, byteArrayOutputStream, null);
                                g(bitmap, null, byteArrayOutputStream, null);
                                return;
                            }
                            int i5 = 90;
                            while (byteArrayOutputStream.toByteArray().length > 5242880) {
                                byteArrayOutputStream.reset();
                                bitmap.compress(compressFormat, i5, byteArrayOutputStream);
                                i5 -= 10;
                            }
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            Bitmap decodeStream2 = BitmapFactory.decodeStream(byteArrayInputStream2);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                            if (decodeStream2.compress(compressFormat, 100, fileOutputStream2)) {
                                fileOutputStream2.flush();
                            }
                            ah.e(new Runnable() { // from class: com.baidu.tieba.ze8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        ff8.e(cf8.this, str);
                                    }
                                }
                            });
                            g(decodeStream2, byteArrayInputStream2, byteArrayOutputStream, fileOutputStream2);
                            g(decodeStream2, byteArrayInputStream2, byteArrayOutputStream, fileOutputStream2);
                            return;
                        }
                        if (r7 > 5242880) {
                        }
                    } catch (Exception e4) {
                        e = e4;
                        Bitmap bitmap3 = bitmap;
                        bitmap = 0;
                        bitmap2 = bitmap3;
                        r7 = r7;
                        e.printStackTrace();
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        ah.e(new Runnable() { // from class: com.baidu.tieba.ye8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    ff8.f(cf8.this, filePath);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        Bitmap bitmap4 = bitmap;
                        bitmap = 0;
                        bitmap2 = bitmap4;
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bitmap2 = 1;
                    r7 = r7;
                    bitmap = bitmap;
                    e.printStackTrace();
                    g(bitmap2, r7, byteArrayOutputStream, bitmap);
                    ah.e(new Runnable() { // from class: com.baidu.tieba.ye8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ff8.f(cf8.this, filePath);
                            }
                        }
                    });
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    bitmap2 = 1;
                    g(bitmap2, r7, byteArrayOutputStream, bitmap);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                bitmap = 0;
                bitmap2 = 1;
                r7 = r7;
                bitmap = bitmap;
                e.printStackTrace();
                g(bitmap2, r7, byteArrayOutputStream, bitmap);
                ah.e(new Runnable() { // from class: com.baidu.tieba.ye8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ff8.f(cf8.this, filePath);
                        }
                    }
                });
                return;
            } catch (Throwable th7) {
                th = th7;
                bitmap = 0;
                bitmap2 = 1;
                g(bitmap2, r7, byteArrayOutputStream, bitmap);
                throw th;
            }
            ceil = (int) Math.ceil(i3 / i);
            int ceil2 = (int) Math.ceil(i4 / i2);
            if (ceil <= ceil2) {
                ceil = ceil2;
            }
            if (ceil > 1) {
            }
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            r7 = byteArrayOutputStream.toByteArray().length;
        }
    }

    public static final void c(cf8 callback, String toFilePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, callback, toFilePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(toFilePath, "$toFilePath");
            callback.onFinish(toFilePath);
        }
    }

    public static final void d(cf8 callback, String filePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, callback, filePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            callback.onFinish(filePath);
        }
    }

    public static final void e(cf8 callback, String toFilePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callback, toFilePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(toFilePath, "$toFilePath");
            callback.onFinish(toFilePath);
        }
    }

    public static final void f(cf8 callback, String filePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, callback, filePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            callback.onFinish(filePath);
        }
    }

    public static final void g(Bitmap bitmap, ByteArrayInputStream byteArrayInputStream, ByteArrayOutputStream byteArrayOutputStream, FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, bitmap, byteArrayInputStream, byteArrayOutputStream, fileOutputStream) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
