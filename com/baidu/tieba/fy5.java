package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.o16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class fy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o16 a;
    public vx5 b;
    public TbPageContext c;

    /* loaded from: classes6.dex */
    public class a implements o16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy5 a;

        public a(fy5 fy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fy5Var;
        }

        @Override // com.baidu.tieba.o16.i
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

    public fy5(TbPageContext tbPageContext, vx5 vx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vx5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = vx5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o16 o16Var = this.a;
            if (o16Var != null) {
                o16Var.x();
                this.a.y();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        vx5 vx5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (vx5Var = this.b) != null && vx5Var.b() != null && this.c != null) {
            n16 n16Var = new n16(this.b.b().f(), this.b.b().e(), this.b.b().d());
            n16Var.i(this.b.b().b(), this.b.b().c());
            n16Var.h(this.b.b().a());
            n16Var.j(this.b.b().j());
            UserData i2 = this.b.b().i();
            TbPageContext tbPageContext = this.c;
            this.a = new o16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), n16Var, i2);
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(this.b.b().h());
            this.a.I(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.a.H(negativeFeedBackData);
            this.a.J(new a(this));
            if (i != 2 && i != 1) {
                if (i == 3) {
                    str = "6";
                } else {
                    str = "0";
                }
            } else {
                str = "5";
            }
            this.a.K(str);
        }
    }
}
