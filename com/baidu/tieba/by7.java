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
public class by7 extends mx7<bv7, PbLoadMoreItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId g;
    public View.OnClickListener h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by7(f28 f28Var, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(f28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f28Var, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f28) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdUniqueId2;
        this.i = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    }

    @Override // com.baidu.tieba.mx7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v(i, view2, viewGroup, (bv7) obj, (PbLoadMoreItemViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public PbLoadMoreItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbLoadMoreItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0646, viewGroup, false), this.g) : (PbLoadMoreItemViewHolder) invokeL.objValue;
    }

    public View v(int i, View view2, ViewGroup viewGroup, bv7 bv7Var, PbLoadMoreItemViewHolder pbLoadMoreItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bv7Var, pbLoadMoreItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, bv7Var, pbLoadMoreItemViewHolder);
            if (bv7Var.b) {
                pbLoadMoreItemViewHolder.e(bv7Var.a);
            } else {
                pbLoadMoreItemViewHolder.d(bv7Var.a, this.i);
            }
            pbLoadMoreItemViewHolder.c(this.h);
            pbLoadMoreItemViewHolder.b();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void w(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }
}
