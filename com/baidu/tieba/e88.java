package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e88 extends ax<b15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaRecommendLayout f;
    public int g;

    @Override // com.baidu.tieba.ax
    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e88(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().b instanceof AlaRecommendLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().b.getParent() == null) {
            AlaRecommendLayout alaRecommendLayout = (AlaRecommendLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().b;
            this.f = alaRecommendLayout;
            b16.b(alaRecommendLayout, tbPageContext.getPageActivity());
            return;
        }
        this.f = new AlaRecommendLayout(tbPageContext.getPageActivity());
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.g != i) {
                this.f.d(i);
                q(this.f, 3);
            }
            this.g = i;
        }
    }

    public qp6 s(b15 b15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b15Var)) == null) {
            if (b15Var instanceof d78) {
                d78 d78Var = (d78) b15Var;
                return new qp6(d78Var.getType(), d78Var.c(), "recommend");
            } else if (b15Var instanceof y18) {
                y18 y18Var = (y18) b15Var;
                return new qp6(y18Var.getType(), y18Var.c(), ImageViewerConfig.FROM_CONCERN);
            } else {
                return new qp6();
            }
        }
        return (qp6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: t */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b15Var) == null) {
            qp6 s = s(b15Var);
            if (s != null && !ListUtils.isEmpty(s.c())) {
                this.f.setData(s);
                this.f.d(TbadkCoreApplication.getInst().getSkinType());
                this.f.setVisibility(0);
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
