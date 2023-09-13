package com.baidu.tieba;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hz9 extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a b;

    /* loaded from: classes6.dex */
    public interface a {
        void onChange(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz9(Context context, Handler handler) {
        super(handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final void a() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (context = this.a) == null) {
            return;
        }
        try {
            int i = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            if (this.b != null) {
                a aVar = this.b;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                aVar.onChange(z);
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.b = aVar;
            a();
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            a();
        }
    }
}
