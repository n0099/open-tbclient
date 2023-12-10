package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.jr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public jr4 b;
    public b c;
    public MarkData d;
    public final jr4.a e;

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements jr4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g06 a;

        public a(g06 g06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g06Var;
        }

        @Override // com.baidu.tieba.jr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                if (z) {
                    if (z2) {
                        if (str2 == null) {
                            str2 = this.a.a.getString(R.string.add_mark);
                        }
                        BdUtilHelper.showToast(str2, 2000, true);
                    } else {
                        BdUtilHelper.showToast(this.a.a, this.a.a.getString(R.string.remove_mark));
                    }
                    if (this.a.c != null) {
                        this.a.c.a(z2);
                    }
                    if (this.a.d != null) {
                        jwa jwaVar = new jwa();
                        jwaVar.a = this.a.d.getThreadId();
                        jwaVar.b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, jwaVar));
                        return;
                    }
                    return;
                }
                BdUtilHelper.showToast(this.a.a, this.a.a.getString(R.string.update_mark_failed));
            }
        }
    }

    public g06(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.e = new a(this);
        this.a = context;
        if (context instanceof BaseActivity) {
            this.b = jr4.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.b = jr4.c((BaseFragmentActivity) context);
        }
        jr4 jr4Var = this.b;
        if (jr4Var != null) {
            jr4Var.j(this.e);
        }
    }

    public void g(boolean z) {
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (jr4Var = this.b) != null) {
            jr4Var.h(z);
        }
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.d = markData;
            jr4 jr4Var = this.b;
            if (jr4Var != null) {
                jr4Var.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void d() {
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (jr4Var = this.b) != null) {
            jr4Var.a();
            this.b.h(true);
        }
    }

    public void e() {
        jr4 jr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jr4Var = this.b) != null && jr4Var.e()) {
            this.b.d();
            this.b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jr4 jr4Var = this.b;
            if (jr4Var != null) {
                return jr4Var.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
