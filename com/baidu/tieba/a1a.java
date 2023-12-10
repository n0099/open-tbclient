package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a1a extends a0a<mw9, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1a(i6a i6aVar, BdUniqueId bdUniqueId) {
        super(i6aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i6aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i6a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public PbNoDataItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbNoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07e0, viewGroup, false), this.mContext);
        }
        return (PbNoDataItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a0a, com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y(i, view2, viewGroup, (mw9) obj, (PbNoDataItemViewHolder) viewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, mw9 mw9Var, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mw9Var, pbNoDataItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mw9Var, (mw9) pbNoDataItemViewHolder);
            this.d = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setTextOption(NoDataViewFactory.e.c(mw9Var.j1));
            if (mw9Var.i1 != 0) {
                int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds156);
                int i2 = mw9Var.k1;
                if (i2 != 0) {
                    dimens = i2;
                }
                int dimens2 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds312);
                int dimens3 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds312);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.LOCAL);
                aVar.h(mw9Var.i1);
                aVar.j(dimens);
                aVar.k(dimens2);
                aVar.g(dimens3);
                pbNoDataItemViewHolder.a.setImgOption(aVar.f());
            } else {
                pbNoDataItemViewHolder.a.setImgOption(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds156)));
            }
            pbNoDataItemViewHolder.a.f(a5.a(view2.getContext()), this.d);
            pbNoDataItemViewHolder.a.setVisibility(mw9Var.l1);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
