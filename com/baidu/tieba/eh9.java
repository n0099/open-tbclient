package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eh9 extends qg9<fh9, PbImageAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId g;
    public td9 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh9(vl9 vl9Var, BdUniqueId bdUniqueId) {
        super(vl9Var, fh9.q);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vl9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: u */
    public PbImageAlaRecommendVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbImageAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0796, viewGroup, false), this.a.getPageContext(), this.g);
        }
        return (PbImageAlaRecommendVH) invokeL.objValue;
    }

    public void y(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, td9Var) == null) {
            this.h = td9Var;
        }
    }

    @Override // com.baidu.tieba.qg9, com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, (fh9) obj, (PbImageAlaRecommendVH) viewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, fh9 fh9Var, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fh9Var, pbImageAlaRecommendVH})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) fh9Var, (fh9) pbImageAlaRecommendVH);
            if (pbImageAlaRecommendVH != null) {
                pbImageAlaRecommendVH.d(fh9Var);
                pbImageAlaRecommendVH.i(this.h);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
