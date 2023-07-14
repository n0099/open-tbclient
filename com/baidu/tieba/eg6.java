package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaStageViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eg6 extends yh7<hba, FrsPageAlaStageViewHolder> implements sp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public pg6 m;

    @Override // com.baidu.tieba.sp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: G */
    public FrsPageAlaStageViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.c;
            if (tbPageContext == null) {
                return null;
            }
            pg6 pg6Var = new pg6(tbPageContext);
            this.m = pg6Var;
            pg6Var.a(this.l);
            return new FrsPageAlaStageViewHolder(this.m);
        }
        return (FrsPageAlaStageViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.l = str;
        }
    }

    public View H(int i, View view2, ViewGroup viewGroup, hba hbaVar, FrsPageAlaStageViewHolder frsPageAlaStageViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hbaVar, frsPageAlaStageViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) hbaVar, (hba) frsPageAlaStageViewHolder);
            if (hbaVar != null) {
                int i2 = 0;
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    i2 = frsViewData.getTopThreadSize();
                }
                pg6 pg6Var = frsPageAlaStageViewHolder.a;
                pg6Var.x = (i + 1) - i2;
                pg6Var.a(this.l);
                frsPageAlaStageViewHolder.a.i(hbaVar);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        H(i, view2, viewGroup, (hba) obj, (FrsPageAlaStageViewHolder) viewHolder);
        return view2;
    }
}
