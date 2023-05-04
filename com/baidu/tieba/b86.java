package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsGameLiveDoubleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b86 extends vm<u86, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public s46 b;
    public String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b86(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: s */
    public AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaGameFrsGameLiveDoubleView alaGameFrsGameLiveDoubleView = new AlaGameFrsGameLiveDoubleView(this.a);
            alaGameFrsGameLiveDoubleView.t(this.c);
            return new AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder(alaGameFrsGameLiveDoubleView);
        }
        return (AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder) invokeL.objValue;
    }

    public void u(s46 s46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s46Var) == null) {
            this.b = s46Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u86 u86Var, AlaGameFrsGameLiveDoubleView.AlaGameFrsGameLiveDoubleViewHolder alaGameFrsGameLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u86Var, alaGameFrsGameLiveDoubleViewHolder})) == null) {
            alaGameFrsGameLiveDoubleViewHolder.a.i(u86Var);
            alaGameFrsGameLiveDoubleViewHolder.a.u(this.b);
            String str2 = "";
            if (StringUtils.isNull(u86Var.a.getThreadAlaInfo().appId)) {
                str = "";
            } else {
                str = u86Var.a.getThreadAlaInfo().appId;
            }
            r46.b().a(new StatisticItem("c12115").param("obj_id", u86Var.a.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, str));
            ThreadData threadData = u86Var.b;
            if (threadData != null) {
                if (!StringUtils.isNull(threadData.getThreadAlaInfo().appId)) {
                    str2 = u86Var.b.getThreadAlaInfo().appId;
                }
                r46.b().a(new StatisticItem("c12115").param("obj_id", u86Var.b.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, str2));
            }
            return alaGameFrsGameLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
