package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbLoadMoreItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bw8 extends pv8<ft8, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId g;
    public View.OnClickListener h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw8(yz8 yz8Var, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(yz8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yz8Var, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yz8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdUniqueId2;
        this.i = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: u */
    public PbLoadMoreItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbLoadMoreItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.new_pb_list_more, viewGroup, false), this.g);
        }
        return (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    @Override // com.baidu.tieba.pv8, com.baidu.tieba.um
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, (ft8) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, ft8 ft8Var, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ft8Var, pbLoadMoreItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) ft8Var, (ft8) pbLoadMoreItemViewHolder);
            if (ft8Var.b) {
                pbLoadMoreItemViewHolder.e(ft8Var.a);
            } else {
                pbLoadMoreItemViewHolder.d(ft8Var.a, this.i);
            }
            pbLoadMoreItemViewHolder.c(this.h);
            pbLoadMoreItemViewHolder.b();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
