package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.ko5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class bl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ko5 a;
    public rk5 b;
    public TbPageContext c;

    /* loaded from: classes3.dex */
    public class a implements ko5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl5 a;

        public a(bl5 bl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bl5Var;
        }

        @Override // com.baidu.tieba.ko5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.a.b != null) {
                    this.a.b.g(JsonArrayToString);
                    this.a.b.e();
                }
            }
        }
    }

    public bl5(TbPageContext tbPageContext, rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rk5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = rk5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ko5 ko5Var = this.a;
            if (ko5Var != null) {
                ko5Var.w();
                this.a.x();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        rk5 rk5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (rk5Var = this.b) != null && rk5Var.b() != null && this.c != null) {
            jo5 jo5Var = new jo5(this.b.b().f(), this.b.b().e(), this.b.b().d());
            jo5Var.i(this.b.b().b(), this.b.b().c());
            jo5Var.h(this.b.b().a());
            jo5Var.j(this.b.b().j());
            UserData i2 = this.b.b().i();
            TbPageContext tbPageContext = this.c;
            this.a = new ko5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), jo5Var, i2);
            xs4 xs4Var = new xs4();
            xs4Var.j(this.b.b().h());
            this.a.H(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cc), this.c.getString(R.string.obfuscated_res_0x7f0f04cd), this.c.getString(R.string.obfuscated_res_0x7f0f04ce), this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0)});
            this.a.G(xs4Var);
            this.a.I(new a(this));
            if (i != 2 && i != 1) {
                if (i == 3) {
                    str = "6";
                } else {
                    str = "0";
                }
            } else {
                str = "5";
            }
            this.a.J(str);
        }
    }
}
