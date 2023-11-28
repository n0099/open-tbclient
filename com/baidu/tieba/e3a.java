package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.os;
import com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e3a extends BaseOriginalThreadView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public et k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3a(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.z2a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.a();
            if (this.k == null) {
                et etVar = new et(this.a.getPageActivity());
                this.k = etVar;
                etVar.q(Boolean.TRUE);
                this.k.setFrom("pb");
                this.k.D(0);
                this.k.I(this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
                this.k.J(false);
                this.k.H(true);
            }
            l().addView(this.k.g());
            l().addView(i(true));
            return l();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.z2a
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.b(tbPageContext, i);
            if (this.e != i) {
                this.e = i;
                et etVar = this.k;
                if (etVar != null) {
                    etVar.onChangeSkinType(tbPageContext, i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.z2a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            super.c(originalThreadInfo);
            et etVar = this.k;
            if (etVar != null) {
                etVar.onBindDataToView(f());
            }
        }
    }

    @Override // com.baidu.tieba.z2a
    public void d(os.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            et etVar = this.k;
            if (etVar != null) {
                etVar.E(aVar);
            }
            m();
        }
    }

    @Override // com.baidu.tieba.z2a
    public void e(im6 im6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, im6Var) == null) {
            super.e(im6Var);
            et etVar = this.k;
            if (etVar != null) {
                etVar.n(this.b);
            }
        }
    }
}
