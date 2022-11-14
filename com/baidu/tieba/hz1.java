package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.upload.UploadConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hz1 extends cz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public float r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz1(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = "png";
        this.r = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.k = wh3.g((float) jSONObject.optDouble("x"));
            this.l = wh3.g((float) jSONObject.optDouble("y"));
            this.m = wh3.g((float) jSONObject.optDouble("width"));
            this.n = wh3.g((float) jSONObject.optDouble("height"));
            this.o = wh3.g((float) jSONObject.optDouble("destWidth"));
            this.p = wh3.g((float) jSONObject.optDouble("destHeight"));
            this.q = jSONObject.optString(UploadConstant.KEY_FILE_TYPE);
            this.r = (float) jSONObject.optDouble("quality");
        } catch (Exception e) {
            if (pk1.a) {
                e.printStackTrace();
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TextUtils.equals(this.q, "jpg");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cz1, com.baidu.tieba.vz1, com.baidu.tieba.eu2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m > 0 && this.n > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bc A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(View view2, String str) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bitmap.CompressFormat compressFormat;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str)) == null) {
            if (view2 != null && !TextUtils.isEmpty(str)) {
                try {
                    Bitmap x = wh3.x(view2, view2.getWidth(), view2.getHeight());
                    int width = x.getWidth();
                    int height = x.getHeight();
                    if (this.k >= 0 && this.k < width) {
                        i = this.k;
                        this.k = i;
                        if (this.l >= 0 && this.l < height) {
                            i2 = this.l;
                            this.l = i2;
                            if (this.m > 0 && this.k + this.m <= width) {
                                i3 = this.m;
                                this.m = i3;
                                if (this.n > 0 && this.l + this.n <= height) {
                                    i4 = this.n;
                                    this.n = i4;
                                    if (this.o > 0) {
                                        i5 = this.m;
                                    } else {
                                        i5 = this.o;
                                    }
                                    this.o = i5;
                                    if (this.p > 0) {
                                        i6 = this.n;
                                    } else {
                                        i6 = this.p;
                                    }
                                    this.p = i6;
                                    Bitmap createBitmap = Bitmap.createBitmap(this.o, i6, x.getConfig());
                                    new Canvas(createBitmap).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                                    if (!h()) {
                                        compressFormat = Bitmap.CompressFormat.JPEG;
                                    } else {
                                        compressFormat = Bitmap.CompressFormat.PNG;
                                    }
                                    file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (file.getParentFile() != null) {
                                        file.getParentFile().mkdirs();
                                    }
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    createBitmap.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream);
                                    fileOutputStream.flush();
                                    jk4.d(fileOutputStream);
                                    return true;
                                }
                                i4 = height - this.l;
                                this.n = i4;
                                if (this.o > 0) {
                                }
                                this.o = i5;
                                if (this.p > 0) {
                                }
                                this.p = i6;
                                Bitmap createBitmap2 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                                new Canvas(createBitmap2).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                                if (!h()) {
                                }
                                file = new File(str);
                                if (file.exists()) {
                                }
                                if (file.getParentFile() != null) {
                                }
                                file.createNewFile();
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                createBitmap2.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream2);
                                fileOutputStream2.flush();
                                jk4.d(fileOutputStream2);
                                return true;
                            }
                            i3 = width - this.k;
                            this.m = i3;
                            if (this.n > 0) {
                                i4 = this.n;
                                this.n = i4;
                                if (this.o > 0) {
                                }
                                this.o = i5;
                                if (this.p > 0) {
                                }
                                this.p = i6;
                                Bitmap createBitmap22 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                                new Canvas(createBitmap22).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                                if (!h()) {
                                }
                                file = new File(str);
                                if (file.exists()) {
                                }
                                if (file.getParentFile() != null) {
                                }
                                file.createNewFile();
                                FileOutputStream fileOutputStream22 = new FileOutputStream(file);
                                createBitmap22.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream22);
                                fileOutputStream22.flush();
                                jk4.d(fileOutputStream22);
                                return true;
                            }
                            i4 = height - this.l;
                            this.n = i4;
                            if (this.o > 0) {
                            }
                            this.o = i5;
                            if (this.p > 0) {
                            }
                            this.p = i6;
                            Bitmap createBitmap222 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                            new Canvas(createBitmap222).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                            if (!h()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream222 = new FileOutputStream(file);
                            createBitmap222.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream222);
                            fileOutputStream222.flush();
                            jk4.d(fileOutputStream222);
                            return true;
                        }
                        i2 = 0;
                        this.l = i2;
                        if (this.m > 0) {
                            i3 = this.m;
                            this.m = i3;
                            if (this.n > 0) {
                            }
                            i4 = height - this.l;
                            this.n = i4;
                            if (this.o > 0) {
                            }
                            this.o = i5;
                            if (this.p > 0) {
                            }
                            this.p = i6;
                            Bitmap createBitmap2222 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                            new Canvas(createBitmap2222).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                            if (!h()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream2222 = new FileOutputStream(file);
                            createBitmap2222.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream2222);
                            fileOutputStream2222.flush();
                            jk4.d(fileOutputStream2222);
                            return true;
                        }
                        i3 = width - this.k;
                        this.m = i3;
                        if (this.n > 0) {
                        }
                        i4 = height - this.l;
                        this.n = i4;
                        if (this.o > 0) {
                        }
                        this.o = i5;
                        if (this.p > 0) {
                        }
                        this.p = i6;
                        Bitmap createBitmap22222 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                        new Canvas(createBitmap22222).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                        if (!h()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream22222 = new FileOutputStream(file);
                        createBitmap22222.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream22222);
                        fileOutputStream22222.flush();
                        jk4.d(fileOutputStream22222);
                        return true;
                    }
                    i = 0;
                    this.k = i;
                    if (this.l >= 0) {
                        i2 = this.l;
                        this.l = i2;
                        if (this.m > 0) {
                        }
                        i3 = width - this.k;
                        this.m = i3;
                        if (this.n > 0) {
                        }
                        i4 = height - this.l;
                        this.n = i4;
                        if (this.o > 0) {
                        }
                        this.o = i5;
                        if (this.p > 0) {
                        }
                        this.p = i6;
                        Bitmap createBitmap222222 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                        new Canvas(createBitmap222222).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                        if (!h()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream222222 = new FileOutputStream(file);
                        createBitmap222222.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream222222);
                        fileOutputStream222222.flush();
                        jk4.d(fileOutputStream222222);
                        return true;
                    }
                    i2 = 0;
                    this.l = i2;
                    if (this.m > 0) {
                    }
                    i3 = width - this.k;
                    this.m = i3;
                    if (this.n > 0) {
                    }
                    i4 = height - this.l;
                    this.n = i4;
                    if (this.o > 0) {
                    }
                    this.o = i5;
                    if (this.p > 0) {
                    }
                    this.p = i6;
                    Bitmap createBitmap2222222 = Bitmap.createBitmap(this.o, i6, x.getConfig());
                    new Canvas(createBitmap2222222).drawBitmap(x, new Rect(this.k, this.l, this.k + this.m, this.l + this.n), new Rect(0, 0, this.o, this.p), new Paint());
                    if (!h()) {
                    }
                    file = new File(str);
                    if (file.exists()) {
                    }
                    if (file.getParentFile() != null) {
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2222222 = new FileOutputStream(file);
                    createBitmap2222222.compress(compressFormat, (int) (this.r * 100.0f), fileOutputStream2222222);
                    fileOutputStream2222222.flush();
                    jk4.d(fileOutputStream2222222);
                    return true;
                } catch (Exception e) {
                    if (pk1.a) {
                        e.printStackTrace();
                    }
                } catch (OutOfMemoryError e2) {
                    if (pk1.a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
