package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class en7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final String b;
    public final String c;
    public LikeModel d;
    public hn7 e;

    /* loaded from: classes5.dex */
    public class a extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ en7 a;

        public a(en7 en7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = en7Var;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof LikeReturnData) && this.a.d.getErrorCode() == 0) {
                    if (this.a.e != null) {
                        this.a.e.a();
                    }
                } else if (AntiHelper.m(this.a.d.getErrorCode(), this.a.d.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.d.getErrorString());
                } else {
                    this.a.a.showToast(this.a.d.getErrorString());
                }
            }
        }
    }

    public en7(TbPageContext<?> tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = str;
        this.c = str2;
    }

    public final void e(eda edaVar, int i, hn7 hn7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, edaVar, i, hn7Var) == null) && this.a != null && edaVar != null) {
            this.e = hn7Var;
            if (this.d == null) {
                f();
            }
            if (this.d.d0()) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f003a));
                return;
            }
            this.d.f0(edaVar.c, edaVar.a);
            k(edaVar.a, edaVar.c);
        }
    }

    public void d() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (likeModel = this.d) != null) {
            likeModel.b0();
        }
    }

    public final void f() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (tbPageContext = this.a) == null) {
            return;
        }
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.d = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            fn7.c("c15527", this.b, this.c);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            fn7.c("c15526", this.b, this.c);
        }
    }

    public void g(eda edaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, edaVar) == null) && this.a != null && edaVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(edaVar.c, null)));
            j(edaVar.a, edaVar.c);
        }
    }

    public void h(eda edaVar, int i, hn7 hn7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, edaVar, i, hn7Var) == null) && edaVar != null && !edaVar.f) {
            e(edaVar, i, hn7Var);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            fn7.b("c15529", this.b, this.c, str, str2);
        }
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            fn7.b("c15530", this.b, this.c, str, str2);
        }
    }
}
