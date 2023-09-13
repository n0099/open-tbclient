package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e48 extends pm<ln, NoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e48(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), ln.c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.a = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public NoDataItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new NoDataItemViewHolder(inflate);
        }
        return (NoDataItemViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ln lnVar, NoDataItemViewHolder noDataItemViewHolder) {
        t(i, view2, viewGroup, lnVar, noDataItemViewHolder);
        return view2;
    }

    public View t(int i, View view2, ViewGroup viewGroup, ln lnVar, NoDataItemViewHolder noDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lnVar, noDataItemViewHolder})) == null) {
            noDataItemViewHolder.a.setText(lnVar.a);
            if (this.a != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setImageResource(noDataItemViewHolder.b, lnVar.b);
                SkinManager.setViewTextColor(noDataItemViewHolder.a, (int) R.color.CAM_X0109);
                this.a = TbadkCoreApplication.getInst().getSkinType();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
