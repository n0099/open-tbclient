package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bz extends ey {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().n instanceof MultiLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().n.getParent() == null) {
            this.h = (MultiLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().n;
        } else {
            this.h = new MultiLinkCardView(context);
        }
        z(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    public final boolean A(t15 t15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t15Var)) == null) {
            if (t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().isVideoThreadType() && t15Var.getThreadData().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean B(t15 t15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t15Var)) == null) {
            if (t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().getPollData() != null && t15Var.getThreadData().getPollData().getOptions() != null && t15Var.getThreadData().getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: C */
    public void b(t15 t15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t15Var) == null) {
            if (!B(t15Var) && !A(t15Var) && t15Var != null && t15Var.getThreadData() != null && ((!ListUtils.isEmpty(t15Var.getThreadData().getLinkDataList()) || ListUtils.getCount(t15Var.getThreadData().getGoodsDataList()) > 1) && ((!ListUtils.isEmpty(t15Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(t15Var.getThreadData().getLinkDataList()) > 1) && ListUtils.getCount(t15Var.getThreadData().getLinkDataList()) + ListUtils.getCount(t15Var.getThreadData().getGoodsDataList()) > 1))) {
                this.h.a(t15Var.getThreadData().getLinkDataList(), t15Var.getThreadData().getGoodsDataList());
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.xx
    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }
}
