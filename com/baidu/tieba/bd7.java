package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.forumMember.member.ComplaintBarlordViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bd7 extends lm<cd7, ComplaintBarlordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View.OnClickListener b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd7 a;

        public a(bd7 bd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bd7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof String)) {
                String str = (String) view2.getTag();
                if (this.a.a == 4) {
                    str = str + "?isNightModel=1";
                }
                BrowserHelper.startWebActivity(this.a.mContext, this.a.mContext.getString(R.string.obfuscated_res_0x7f0f04b2), str, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd7(BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), cd7.c, bdPageContext.getUniqueId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: z */
    public ComplaintBarlordViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new ComplaintBarlordViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d045d, viewGroup, false));
        }
        return (ComplaintBarlordViewHolder) invokeL.objValue;
    }

    public View A(int i, View view2, ViewGroup viewGroup, cd7 cd7Var, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cd7Var, complaintBarlordViewHolder})) == null) {
            if (cd7Var != null && complaintBarlordViewHolder != null) {
                y(complaintBarlordViewHolder);
                x(complaintBarlordViewHolder, cd7Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cd7 cd7Var, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        A(i, view2, viewGroup, cd7Var, complaintBarlordViewHolder);
        return view2;
    }

    public final void x(ComplaintBarlordViewHolder complaintBarlordViewHolder, cd7 cd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, complaintBarlordViewHolder, cd7Var) == null) {
            complaintBarlordViewHolder.d.setText(cd7Var.a);
            complaintBarlordViewHolder.b.setTag(cd7Var.b);
            complaintBarlordViewHolder.b.setOnClickListener(this.b);
        }
    }

    public final void y(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, complaintBarlordViewHolder) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a = skinType;
            if (complaintBarlordViewHolder.a == skinType) {
                return;
            }
            complaintBarlordViewHolder.a = skinType;
            SkinManager.setBackgroundResource(complaintBarlordViewHolder.b, R.drawable.frs_member_manito_bg);
            SkinManager.setBackgroundColor(complaintBarlordViewHolder.c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(complaintBarlordViewHolder.d, R.color.CAM_X0105, 1);
            SkinManager.setImageResource(complaintBarlordViewHolder.e, R.drawable.icon_arrow12_gray66_right);
        }
    }
}
