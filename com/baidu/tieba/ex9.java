package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ex9 extends uv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex9(h1a h1aVar, BdUniqueId bdUniqueId) {
        super(h1aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h1aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h1a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            I0(pbCommenFloorItemViewHolder.F0);
        }
    }

    public final void E0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder) == null) {
            I0(pbCommenFloorItemViewHolder.C0);
        }
    }

    public final void F0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) == null) {
            I0(pbCommenFloorItemViewHolder.s);
        }
    }

    public final void G0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) && (view2 = pbCommenFloorItemViewHolder.J) != null) {
            view2.setVisibility(4);
        }
    }

    public final void H0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pbCommenFloorItemViewHolder) == null) {
            TextView textView = pbCommenFloorItemViewHolder.D;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = pbCommenFloorItemViewHolder.m;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    public final void J0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) == null) {
            I0(pbCommenFloorItemViewHolder.w);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uv9, com.baidu.tieba.bi
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            PbCommenFloorItemViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            K0(onCreateViewHolder);
            return onCreateViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void I0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            marginLayoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            marginLayoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            view2.setLayoutParams(marginLayoutParams);
        }
    }

    public final void L0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder) == null) {
            View findViewById = pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f0927d1);
            if (findViewById != null) {
                SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            }
            View findViewById2 = pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f0927d0);
            if (findViewById2 != null) {
                SkinManager.setViewTextColor(findViewById2, R.color.CAM_X0105, 1);
            }
        }
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pbCommenFloorItemViewHolder) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f091bb8);
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07cf, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            if (relativeLayout != null) {
                relativeLayout.addView(inflate, 0, layoutParams2);
            }
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f091206);
            if (linearLayout != null) {
                if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                }
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091fd7);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tieba.uv9, com.baidu.tieba.wv9, com.baidu.tieba.bi
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i, view2, viewGroup, (vra) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.uv9
    public View q0(int i, View view2, ViewGroup viewGroup, vra vraVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vraVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, vraVar, pbCommenFloorItemViewHolder);
            F0(pbCommenFloorItemViewHolder);
            H0(pbCommenFloorItemViewHolder);
            D0(pbCommenFloorItemViewHolder);
            E0(pbCommenFloorItemViewHolder);
            J0(pbCommenFloorItemViewHolder);
            G0(pbCommenFloorItemViewHolder);
            L0(pbCommenFloorItemViewHolder);
            d1a.w("c14887");
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
