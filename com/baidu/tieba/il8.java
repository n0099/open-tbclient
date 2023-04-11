package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResult;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class il8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MemberPayResult.e> a;
    public final LayoutInflater b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public LinearLayout b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public RoundRelativeLayout h;
        public ImageView i;
        public LinearLayout j;

        public a(il8 il8Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il8Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e1d);
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090772);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925dd);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925df);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925dc);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925de);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925b4);
            this.h = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c03);
            this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e72);
            this.h.setRoundLayoutRadius(new float[]{il8Var.g, il8Var.g, il8Var.g, il8Var.g, il8Var.g, il8Var.g, 0.0f, il8Var.g});
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c02);
        }
    }

    public il8(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        this.c = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds294);
        this.d = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds416);
        this.e = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.M_H_X007);
        this.f = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.g = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds42);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public MemberPayResult.e getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (MemberPayResult.e) ListUtils.getItem(this.a, i);
        }
        return (MemberPayResult.e) invokeI.objValue;
    }

    public void f(List<MemberPayResult.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.a = list;
        }
    }

    public MemberPayResult.e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.a)) {
                return null;
            }
            for (MemberPayResult.e eVar : this.a) {
                if (eVar != null && eVar.i) {
                    return eVar;
                }
            }
            return null;
        }
        return (MemberPayResult.e) invokeV.objValue;
    }

    public final void d(int i, MemberPayResult.e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, eVar, aVar) == null) && eVar != null && eVar.f >= 0) {
            aVar.g.setText(h(eVar.b, 7));
            if (TextUtils.isEmpty(eVar.c)) {
                aVar.f.setVisibility(4);
            } else {
                aVar.f.setVisibility(0);
                aVar.f.setText(h(eVar.c, 10));
            }
            TextView textView = aVar.e;
            textView.setText("" + (eVar.f / 100));
            if (TextUtils.isEmpty(eVar.d)) {
                aVar.j.setVisibility(4);
                aVar.h.setVisibility(4);
                aVar.d.setVisibility(4);
            } else {
                aVar.h.setVisibility(0);
                aVar.d.setVisibility(0);
                aVar.j.setVisibility(0);
                aVar.d.setText(eVar.d);
            }
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
                layoutParams.width = this.c;
                layoutParams.height = this.d;
                layoutParams.leftMargin = this.e;
                layoutParams.rightMargin = this.f;
                aVar.a.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
                layoutParams2.width = this.c;
                layoutParams2.height = this.d;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = this.f;
                aVar.a.setLayoutParams(layoutParams2);
            }
            SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(aVar.d, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(aVar.d, R.drawable.member_price_tag_bg_shape);
            q25.d(aVar.d).C(R.string.F_X02);
            SkinManager.setViewTextColor(aVar.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(aVar.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(aVar.g, (int) R.color.CAM_X0105);
            q25.d(aVar.g).C(R.string.F_X01);
            e(aVar);
            g(eVar, aVar);
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds42)).setShadowColor(R.color.CAM_X0301).setShadowAlpha(200).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds16)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds45)).into(aVar.j);
        }
    }

    public final void g(MemberPayResult.e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, eVar, aVar) == null) && eVar != null && aVar != null) {
            SkinManager.setViewTextColor(aVar.e, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0301);
            aVar.i.setVisibility(8);
            if (eVar.i) {
                SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_s);
                q25 d = q25.d(aVar.b);
                d.e(R.string.A_X09);
                d.o(R.string.J_X07);
                d.l(R.color.CAM_X0335);
                d.k(R.string.A_X05);
                d.m(R.dimen.L_X04);
                d.f(R.color.CAM_X0335);
                q25 d2 = q25.d(aVar.g);
                d2.C(R.string.F_X02);
                d2.w(R.color.CAM_X0311);
                q25 d3 = q25.d(aVar.f);
                d3.w(R.color.CAM_X0311);
                d3.B(R.dimen.T_X09);
                d3.C(R.string.F_X02);
                if (aVar.f.getVisibility() == 0) {
                    aVar.i.setVisibility(0);
                    return;
                } else {
                    aVar.i.setVisibility(8);
                    return;
                }
            }
            SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_n);
            q25 d4 = q25.d(aVar.b);
            d4.n(0);
            d4.o(R.string.J_X07);
            d4.l(R.color.CAM_X0335);
            d4.m(R.dimen.L_X04);
            d4.k(R.string.A_X09);
            d4.f(R.color.CAM_X0201);
            q25 d5 = q25.d(aVar.f);
            d5.w(R.color.CAM_X0109);
            d5.B(R.dimen.T_X09);
            d5.C(R.string.F_X01);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d05c0, (ViewGroup) null);
                view2.setTag(new a(this, view2));
            }
            d(i, getItem(i), (a) view2.getTag());
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final String h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void i(MemberPayResult.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) && eVar != null && !ListUtils.isEmpty(this.a)) {
            for (MemberPayResult.e eVar2 : this.a) {
                if (eVar2 != null) {
                    eVar2.i = eVar2.a.equals(eVar.a);
                }
            }
            notifyDataSetChanged();
        }
    }
}
