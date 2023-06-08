package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.fa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ia8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oa8<T> a;
    public fa8 b;
    public ga8 c;
    public T d;
    public b e;

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void onCancel();
    }

    /* loaded from: classes6.dex */
    public class a implements ga8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ia8 b;

        public a(ia8 ia8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia8Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.ga8
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                vi.z(this.a, this.b.a.j());
                if (this.b.a != null) {
                    this.b.a.h();
                }
                this.b.b.dismiss();
                if (this.b.e != null) {
                    this.b.e.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.ga8
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.b.b != null) {
                vi.z(this.a, this.b.a.j());
                if (this.b.a != null) {
                    this.b.a.h();
                }
                this.b.b.dismiss();
                if (this.b.e != null) {
                    this.b.e.a();
                }
            }
        }
    }

    public ia8(Context context, oa8<T> oa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oa8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e(context);
        f(context, oa8Var);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = new a(this, context);
        }
    }

    public /* synthetic */ void h(Context context) {
        if (g(context, this.b.getWindow().getDecorView().findViewById(16908290))) {
            vi.z(context, this.a.j());
            return;
        }
        oa8<T> oa8Var = this.a;
        if (oa8Var != null) {
            oa8Var.h();
        }
        this.b.dismiss();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b != null && d()) {
            this.b.show();
        }
    }

    public final void f(final Context context, oa8<T> oa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, oa8Var) == null) {
            this.a = oa8Var;
            oa8Var.n(this.c);
            fa8 fa8Var = new fa8(context, R.style.obfuscated_res_0x7f10010c);
            this.b = fa8Var;
            fa8Var.setContentView(this.a.j());
            this.b.a(new fa8.a() { // from class: com.baidu.tieba.ea8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.fa8.a
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ia8.this.h(context);
                    }
                }
            });
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = vi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100419);
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
    }

    public final boolean g(Context context, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] >= context.getResources().getDisplayMetrics().heightPixels / 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void j(T t, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, t, metaData) == null) {
            this.d = t;
            this.a.o(t, metaData);
        }
    }
}
