package com.baidu.tieba;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gw9 extends AsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera a;
    public byte[] b;
    public a c;
    public int d;

    /* loaded from: classes6.dex */
    public interface a {
        String a(byte[] bArr, int i, int i2, boolean z);
    }

    public gw9(Camera camera, byte[] bArr, a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {camera, bArr, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = camera;
        this.b = bArr;
        this.c = aVar;
        this.d = i;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    public gw9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                execute(new Void[0]);
            }
            return this;
        }
        return (gw9) invokeV.objValue;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCancelled();
            this.c = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            Camera camera = this.a;
            if (camera == null) {
                return null;
            }
            try {
                parameters = camera.getParameters();
            } catch (RuntimeException e) {
                BdLog.e(e);
                parameters = null;
            }
            if (parameters == null) {
                return null;
            }
            Camera.Size previewSize = parameters.getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            byte[] bArr = this.b;
            if (this.d == 0) {
                bArr = new byte[bArr.length];
                for (int i3 = 0; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < i; i4++) {
                        bArr[(((i4 * i2) + i2) - i3) - 1] = this.b[(i3 * i) + i4];
                    }
                }
                i = i2;
                i2 = i;
            }
            try {
                try {
                    if (this.c == null) {
                        return null;
                    }
                    return this.c.a(bArr, i, i2, false);
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return this.c.a(bArr, i, i2, true);
            }
        }
        return (String) invokeL.objValue;
    }
}
