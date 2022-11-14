package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d18 extends f08<yx7, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d18(z48 z48Var, BdUniqueId bdUniqueId) {
        super(z48Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z48Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((z48) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public PbNoDataItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbNoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06f3, viewGroup, false), this.mContext);
        }
        return (PbNoDataItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.f08, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v(i, view2, viewGroup, (yx7) obj, (PbNoDataItemViewHolder) viewHolder);
        return view2;
    }

    public View v(int i, View view2, ViewGroup viewGroup, yx7 yx7Var, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yx7Var, pbNoDataItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, yx7Var, pbNoDataItemViewHolder);
            this.d = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setText(yx7Var.X0);
            int i2 = yx7Var.W0;
            if (i2 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, i2);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.a, (int) R.color.CAM_X0109);
            if (yx7Var.Y0 != 0 && view2.getLayoutParams() != null) {
                view2.getLayoutParams().height = yx7Var.Y0;
            }
            if (yx7Var.Z0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.b.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, yx7Var.Z0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (yx7Var.a1 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.a.getLayoutParams();
                int i3 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, yx7Var.a1);
            }
            pbNoDataItemViewHolder.b.setVisibility(yx7Var.b1);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
