package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.p46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p46 a;
    public t06 b;
    public TbPageContext c;

    /* loaded from: classes5.dex */
    public class a implements p46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public a(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // com.baidu.tieba.p46.i
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

    public d16(TbPageContext tbPageContext, t06 t06Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, t06Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t06Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p46 p46Var = this.a;
            if (p46Var != null) {
                p46Var.w();
                this.a.x();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        t06 t06Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (t06Var = this.b) != null && t06Var.b() != null && this.c != null) {
            o46 o46Var = new o46(this.b.b().f(), this.b.b().e(), this.b.b().d());
            o46Var.i(this.b.b().b(), this.b.b().c());
            o46Var.h(this.b.b().a());
            o46Var.j(this.b.b().j());
            UserData i2 = this.b.b().i();
            TbPageContext tbPageContext = this.c;
            this.a = new p46(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), o46Var, i2);
            g35 g35Var = new g35();
            g35Var.j(this.b.b().h());
            this.a.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.a.G(g35Var);
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
