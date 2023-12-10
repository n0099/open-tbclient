package com.baidu.tieba;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes6.dex */
public class g6b {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947747286, "Lcom/baidu/tieba/g6b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947747286, "Lcom/baidu/tieba/g6b;");
                return;
            }
        }
        a = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY);
        sb.append("/videoCover.jpg");
        b = sb.toString();
        c = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        d = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        e = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/tbNewVideo/temp/";
        f = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/tbVideo/temp/";
        g = FileHelper.EXTERNAL_STORAGE_DCIM_DIRECTORY + "/tieba/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY);
        sb2.append("/");
        sb2.append(".pendant/");
        h = sb2.toString();
        i = FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/takepic/";
    }
}
