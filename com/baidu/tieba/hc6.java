package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.alasquare.livetab.view.LiveTabAlaRecommendViewHolder;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hc6 extends in<ic6, LiveTabAlaRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public AlaRecommendLayout b;
    public int c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc6(TbPageContext tbPageContext, int i, String str) {
        super(tbPageContext.getPageActivity(), ic6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "0";
        this.a = tbPageContext;
        this.c = i;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: s */
    public LiveTabAlaRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaRecommendLayout alaRecommendLayout = new AlaRecommendLayout(this.a.getPageActivity());
            this.b = alaRecommendLayout;
            alaRecommendLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds34), UtilHelper.getDimenPixelSize(R.dimen.tbds21), UtilHelper.getDimenPixelSize(R.dimen.tbds34), this.b.getPaddingBottom());
            this.b.setFid(this.d);
            TiebaStatic.log(ho6.e("c13620", this.c, this.d));
            return new LiveTabAlaRecommendViewHolder(this.b);
        }
        return (LiveTabAlaRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ic6 ic6Var, LiveTabAlaRecommendViewHolder liveTabAlaRecommendViewHolder) {
        InterceptResult invokeCommon;
        AlaRecommendLayout alaRecommendLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ic6Var, liveTabAlaRecommendViewHolder})) == null) {
            if (liveTabAlaRecommendViewHolder != null && (alaRecommendLayout = liveTabAlaRecommendViewHolder.a) != null && ic6Var != null) {
                m75 d = m75.d(alaRecommendLayout.findViewById(R.id.ala_recommend_list_container));
                d.o(R.string.J_X06);
                d.f(R.color.CAM_X0201);
                io6 io6Var = ic6Var.a;
                if (io6Var != null && !ListUtils.isEmpty(io6Var.c())) {
                    liveTabAlaRecommendViewHolder.a.setData(ic6Var.a);
                    liveTabAlaRecommendViewHolder.a.d(TbadkCoreApplication.getInst().getSkinType());
                    liveTabAlaRecommendViewHolder.a.setVisibility(0);
                } else {
                    liveTabAlaRecommendViewHolder.a.setVisibility(8);
                }
                return liveTabAlaRecommendViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
