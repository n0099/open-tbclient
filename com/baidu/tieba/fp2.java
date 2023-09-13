package com.baidu.tieba;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fp2 extends cp2<hp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hp2.f h;

    /* loaded from: classes5.dex */
    public class a implements hp2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fp2 a;

        public a(fp2 fp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fp2Var;
        }

        @Override // com.baidu.tieba.hp2.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.hp2.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "committext", str);
            }
        }

        @Override // com.baidu.tieba.hp2.f
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onCustomKeyboardHide", null);
            }
        }

        @Override // com.baidu.tieba.hp2.f
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp2(@NonNull hp2 hp2Var) {
        super(hp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ep2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        hp2Var.C0(aVar);
        this.a.a(new mp2());
        this.a.a(new ip2());
        this.a.a(new lp2());
        this.a.a(new kp2());
        this.a.a(new jp2());
    }
}
