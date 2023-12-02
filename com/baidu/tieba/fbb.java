package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.headcard.RecommendCollectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fbb extends os<qbb> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendCollectLayout f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fbb(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f = new RecommendCollectLayout(tbPageContext);
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os
    public void o(BdUniqueId bdUniqueId) {
        RecommendCollectLayout recommendCollectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) && (recommendCollectLayout = this.f) != null) {
            recommendCollectLayout.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: r */
    public void onBindDataToView(qbb qbbVar) {
        RecommendCollectLayout recommendCollectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, qbbVar) == null) && (recommendCollectLayout = this.f) != null) {
            recommendCollectLayout.setData(qbbVar);
            this.f.setSourceForPb(this.g);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        RecommendCollectLayout recommendCollectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && (recommendCollectLayout = this.f) != null) {
            recommendCollectLayout.onChangeSkinType(tbPageContext, i);
        }
    }
}
