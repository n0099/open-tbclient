package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.payment.PaymentConfirmActivity;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class cz7 extends p9<PaymentConfirmActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PaymentConfirmActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public ViewGroup d;
    public ViewGroup e;
    public TbImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public ViewGroup n;
    public TbImageView o;
    public TextView p;
    public TextView q;
    public ViewGroup r;
    public EditText s;
    public ViewGroup t;
    public TextView u;
    public TextView v;
    public boolean w;
    public int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz7(PaymentConfirmActivity paymentConfirmActivity, boolean z, int i) {
        super(paymentConfirmActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {paymentConfirmActivity, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = false;
        this.a = paymentConfirmActivity;
        this.w = z;
        this.x = i;
        paymentConfirmActivity.setContentView(R.layout.obfuscated_res_0x7f0d06e0);
        y(paymentConfirmActivity);
        x(paymentConfirmActivity);
    }

    public final SpannableString A(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (indexOf = str.indexOf(str2)) >= 0) {
                return g(str, indexOf, str2.length() + indexOf, i);
            }
            return new SpannableString(str);
        }
        return (SpannableString) invokeLLI.objValue;
    }

    public void B(int i) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (viewGroup = this.t) != null) {
            if (i == 5) {
                viewGroup.setVisibility(0);
                this.u.setText("");
                this.v.setText(R.string.obfuscated_res_0x7f0f0e20);
            } else if (i > 0) {
                viewGroup.setVisibility(0);
                this.u.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e22, Integer.valueOf(i)));
                this.v.setText(R.string.obfuscated_res_0x7f0f0e20);
            } else {
                viewGroup.setVisibility(0);
                this.u.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e21));
                this.v.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public final void y(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, paymentConfirmActivity) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09186e);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f09186b);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
                if (this.w) {
                    this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e25));
                } else {
                    this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e27));
                }
            } else if (this.w) {
                this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0d));
            } else {
                this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e18));
            }
        }
    }

    public final SpannableString g(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, str, i, i2, i3)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
            return spannableString;
        }
        return (SpannableString) invokeLIII.objValue;
    }

    public void k() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (editText = this.s) != null) {
            editText.setText("");
        }
    }

    public ViewGroup p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            EditText editText = this.s;
            if (editText != null) {
                return editText.getText().toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public CheckBox r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return (CheckBox) invokeV.objValue;
    }

    public EditText s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.s;
        }
        return (EditText) invokeV.objValue;
    }

    public TextView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.v;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return (TextView) invokeV.objValue;
    }

    public void z() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (viewGroup = this.r) != null && viewGroup.getParent() != null) {
            ((ViewGroup) this.r.getParent()).removeAllViews();
        }
    }

    public void l(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, paymentConfirmInfoData, z) != null) || paymentConfirmInfoData == null) {
            return;
        }
        this.e.setVisibility(0);
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (goods_info != null) {
            this.f.K(goods_info.getGoods_pic(), 10, false);
            this.g.setText(goods_info.getGoods_name());
            String numFormatOver10000 = StringHelper.numFormatOver10000(goods_info.getGoods_num());
            this.h.setText(A(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e0f, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, SkinManager.getColor(R.color.CAM_X0305)));
            int goods_duration = goods_info.getGoods_duration();
            if (goods_duration > 0) {
                String numFormatOver100002 = StringHelper.numFormatOver10000(goods_duration);
                this.i.setText(A(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e14, numFormatOver100002), numFormatOver100002, SkinManager.getColor(R.color.CAM_X0305)));
            } else {
                this.i.setText(g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e15), 3, 5, SkinManager.getColor(R.color.CAM_X0305)));
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(CurrencySwitchUtil.getMoneyIcon(goods_info.getCurrency()), (Drawable) null, (Drawable) null, (Drawable) null);
            if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                this.j.setText(CurrencyHelper.getFormatOverBaiwanNum(goods_info.getCurrency(), goods_info.getTdou_num()));
            } else {
                this.j.setText(StringHelper.numFormatOver10000wan(goods_info.getTdou_num()));
            }
            this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e0e, goods_info.getGoods_name()));
            if (z) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.l.setText(o(goods_info.getTdou_num(), goods_info.getCurrency()));
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0301, 1);
                if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0e26);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0e13);
                }
            }
        }
        PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
        if (order_info != null && (cpath = order_info.getCpath()) != null) {
            PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
            if (member != null) {
                String icon = member.getIcon();
                String desc = member.getDesc();
                if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                    this.n.setVisibility(0);
                    this.o.K(icon, 10, false);
                    this.p.setText(desc);
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (cpath.getTip_exist() == 1) {
                this.m.setButtonDrawable(SkinManager.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                this.m.setVisibility(0);
                this.m.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e16, Integer.valueOf(cpath.getTip_days())));
            } else {
                this.m.setVisibility(8);
            }
        }
        if (z) {
            if (this.w) {
                this.q.setText(R.string.buy_now);
            } else {
                this.q.setText(R.string.goto_exchange);
            }
        } else if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
            this.q.setText(R.string.get_ybean);
        } else {
            this.q.setText(R.string.get_tdou);
        }
    }

    public void m(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (editText = this.s) != null) {
            editText.setEnabled(z);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.q.setEnabled(z);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            ig5.a(this.a.getPageContext(), this.b);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
        }
    }

    public final SpannableStringBuilder o(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            String str = "" + j;
            if (CurrencySwitchUtil.isYyIsConvert(i)) {
                str = "" + CurrencyHelper.getFormatOverBaiwanNum(i, j);
            }
            String w = w(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(w);
            int indexOf = w.indexOf(str);
            if (indexOf >= 0) {
                spannableStringBuilder.insert(indexOf, (CharSequence) " ");
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
                en enVar = new en(getPageContext().getPageActivity(), CurrencySwitchUtil.getMoneyIconBitmap(i), 1);
                int i2 = indexOf + 1;
                spannableStringBuilder.setSpan(enVar, indexOf, i2, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, i2, str.length() + i2, 33);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public ViewGroup u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.r == null) {
                this.r = (ViewGroup) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03f9, (ViewGroup) null, false);
                ig5.a(this.a.getPageContext(), this.r);
                this.s = (EditText) this.r.findViewById(R.id.obfuscated_res_0x7f0907f8);
                this.t = (ViewGroup) this.r.findViewById(R.id.obfuscated_res_0x7f091856);
                this.u = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f091855);
                this.v = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f091858);
            }
            return this.r;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (this.w) {
                return this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e11, str);
            }
            return this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e12, str);
        }
        return (String) invokeL.objValue;
    }

    public final void x(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, paymentConfirmActivity) == null) {
            this.d = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f09186f);
            this.e = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091870);
            this.f = (TbImageView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091863);
            this.g = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091860);
            this.h = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091862);
            this.i = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091867);
            this.j = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091864);
            this.k = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091861);
            this.l = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091866);
            this.m = (CheckBox) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f09186c);
            this.n = (ViewGroup) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f09186a);
            this.o = (TbImageView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091869);
            this.p = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f091868);
            this.q = (TextView) paymentConfirmActivity.findViewById(R.id.obfuscated_res_0x7f09186d);
        }
    }
}
