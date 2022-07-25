package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an;
import com.repackage.bu6;
import com.repackage.pi;
/* loaded from: classes3.dex */
public class ConcernTipAdapter extends an<bu6, ConcernTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int i;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;
        public int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernTipViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = 3;
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090685);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090684);
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.c == i) {
                return;
            }
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0205);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernTipAdapter(Context context) {
        super(context, bu6.f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        i = pi.f(context, R.dimen.tbds102);
        j = pi.f(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: Z */
    public ConcernTipViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = View.inflate(viewGroup.getContext(), R.layout.obfuscated_res_0x7f0d01ef, null);
            SkinManager.setBackgroundColor(inflate, R.color.CAM_X0205);
            ConcernTipViewHolder concernTipViewHolder = new ConcernTipViewHolder(inflate);
            ViewGroup.LayoutParams t = t(viewGroup);
            t.width = -1;
            t.height = -2;
            inflate.setLayoutParams(t);
            return concernTipViewHolder;
        }
        return (ConcernTipViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public View S(int i2, View view2, ViewGroup viewGroup, bu6 bu6Var, ConcernTipViewHolder concernTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, bu6Var, concernTipViewHolder})) == null) {
            concernTipViewHolder.a.setText(bu6Var.b);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.a.getLayoutParams();
            if (bu6Var.c) {
                layoutParams.height = j;
                concernTipViewHolder.b.setVisibility(0);
            } else if (bu6Var.d) {
                layoutParams.height = i;
            }
            concernTipViewHolder.a.setLayoutParams(layoutParams);
            concernTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
            return concernTipViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
