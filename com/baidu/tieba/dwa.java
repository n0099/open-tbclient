package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
/* loaded from: classes5.dex */
public class dwa implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public String b;
    public String c;

    public dwa(String str, String str2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
        this.c = str2;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && (bitmap = this.a) != null && !bitmap.isRecycled()) {
            FileUtils.saveBitmap2JPG(this.b, uva.a(this.c), this.a, 100);
        }
    }
}
