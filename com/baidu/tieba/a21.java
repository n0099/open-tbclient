package com.baidu.tieba;

import android.content.Context;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public interface a21 {
    public static final ServiceReference a = new ServiceReference("nad.core", DI.TOAST_NAME);
    public static final a21 b = new a();

    void a(Context context, int i);

    void b(Context context, int i, int i2);

    void showToast(Context context, String str);

    /* loaded from: classes3.dex */
    public final class a implements a21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.a21
        public void a(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, context, i) == null) {
                Toast.makeText(context, i, 0).show();
            }
        }

        @Override // com.baidu.tieba.a21
        public void showToast(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
                Toast.makeText(context, str, 0).show();
            }
        }

        @Override // com.baidu.tieba.a21
        public void b(Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, i2) == null) {
                Toast.makeText(context, i, i2).show();
            }
        }
    }
}
