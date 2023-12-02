package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gt extends vs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fw4 h;
    public mm6<fw4> i;
    public CustomFitFrameCard j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        u(UtilHelper.getDimenPixelSize(R.dimen.tbds17));
    }

    public final boolean y(fw4 fw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fw4Var)) == null) {
            if (fw4Var != null && fw4Var.getThreadData() != null && fw4Var.getThreadData().getTaskInfoData() != null && fw4Var.getThreadData().getTaskInfoData().f() != null && fw4Var.getThreadData().getTaskInfoData().j() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: z */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fw4Var) == null) {
            this.h = fw4Var;
            if (y(fw4Var)) {
                CustomFitFrameCard customFitFrameCard = this.j;
                if (customFitFrameCard != null) {
                    customFitFrameCard.setData(fw4Var);
                }
                CustomFitFrameCard customFitFrameCard2 = this.j;
                if (customFitFrameCard2 != null) {
                    customFitFrameCard2.setVisibility(0);
                    return;
                }
                return;
            }
            CustomFitFrameCard customFitFrameCard3 = this.j;
            if (customFitFrameCard3 != null) {
                customFitFrameCard3.setVisibility(8);
            }
        }
    }

    public static final void x(gt this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            mm6<fw4> mm6Var = this$0.i;
            if (mm6Var != null) {
                mm6Var.a(view2, this$0.h);
            }
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        CustomFitFrameCard customFitFrameCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && (customFitFrameCard = this.j) != null) {
            customFitFrameCard.f();
        }
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context mContext = this.b;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            CustomFitFrameCard customFitFrameCard = new CustomFitFrameCard(mContext, null, 2, null);
            this.j = customFitFrameCard;
            Intrinsics.checkNotNull(customFitFrameCard);
            customFitFrameCard.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ns
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        gt.x(gt.this, view2);
                    }
                }
            });
            CustomFitFrameCard customFitFrameCard2 = this.j;
            Intrinsics.checkNotNull(customFitFrameCard2);
            return customFitFrameCard2;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os
    public void n(mm6<fw4> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mm6Var) == null) {
            this.i = mm6Var;
        }
    }
}
