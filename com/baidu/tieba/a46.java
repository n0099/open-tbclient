package com.baidu.tieba;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes4.dex */
public class a46 extends BdAsyncTask<Void, Void, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565254, "Lcom/baidu/tieba/a46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565254, "Lcom/baidu/tieba/a46;");
                return;
            }
        }
        b = Environment.getExternalStorageDirectory() + "/tieba/.advideo";
        c = File.separator;
    }

    public a46() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(boolean z, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, file) == null) {
            if (z && file != null) {
                File file2 = new File(b + c + (yi.c(this.a.adVideoUrl) + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION));
                if (file2.exists()) {
                    file2.delete();
                }
                if (file.renameTo(file2)) {
                    this.a.videoLocalPath = file2.getAbsolutePath();
                } else {
                    this.a.videoLocalPath = "";
                }
            } else {
                this.a.videoLocalPath = "";
            }
            e46.i(this.a);
        }
    }

    public void c(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            this.a = adInfo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        if (r12.equalsIgnoreCase(r11.a.videoMd5) == false) goto L26;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        File file;
        boolean z;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
            String str = b + c + "advideo.temp";
            file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            z = false;
            try {
                new File(b).mkdirs();
                if (!file.createNewFile()) {
                    b(false, null);
                    return Boolean.FALSE;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            tf tfVar = new tf();
            tfVar.b().s(this.a.adVideoUrl);
            c2 = new qf(tfVar).c(str, null, 3, 3000, -1, -1, true, true);
            try {
                if (TextUtils.isEmpty(this.a.videoMd5)) {
                    b(c2, file);
                    return Boolean.valueOf(c2);
                }
                String b2 = yi.b(new FileInputStream(str));
                if (TextUtils.isEmpty(b2)) {
                    c2 = false;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        } else {
            return (Boolean) invokeL.objValue;
        }
        z = c2;
        b(z, file);
        return Boolean.valueOf(z);
    }
}
