package com.baidu.tieba;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h56 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<f56> a;
    public TbPageContext<?> b;
    public int c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f56 a;
        public final /* synthetic */ h56 b;

        public a(h56 h56Var, f56 f56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h56Var, f56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h56Var;
            this.a = f56Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                String h = this.a.h();
                if (!StringUtils.isNull(h)) {
                    ClipboardManager clipboardManager = (ClipboardManager) this.b.b.getPageActivity().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    clipboardManager.setText(h);
                    if (clipboardManager.getText() != null) {
                        xi.O(this.b.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0460);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f56 a;
        public final /* synthetic */ h56 b;

        public b(h56 h56Var, f56 f56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h56Var, f56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h56Var;
            this.a = f56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.b.b, new String[]{this.a.c()});
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public TextView i;
        public TextView j;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public h56(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public f56 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<f56> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0 && i >= 0 && i < getCount()) {
                return this.a.get(i);
            }
            return null;
        }
        return (f56) invokeI.objValue;
    }

    public void h(ArrayList<f56> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public final SpannableString b(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, Integer.valueOf(i2)})) == null) {
            String string = this.b.getString(i);
            String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            String str = string + "    [icon]" + formatOverBaiwanNum;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i2);
            int g = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701e8);
            moneyIcon.setBounds(0, 0, g, g);
            fk5 fk5Var = new fk5(moneyIcon);
            fk5Var.b(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230));
            fk5Var.c(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230));
            UtilHelper.setSpan(spannableString, str, "[icon]", fk5Var);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString c(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), foregroundColorSpan, foregroundColorSpan2})) == null) {
            String string = this.b.getString(i);
            String long2String = StringHelper.long2String(j, "yyyy-MM-dd HH:mm");
            String str = string + "    " + long2String;
            SpannableString spannableString = new SpannableString(str);
            UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final SpannableString d(int i, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, foregroundColorSpan, foregroundColorSpan2})) == null) {
            String str2 = this.b.getString(i) + "    " + str;
            SpannableString spannableString = new SpannableString(str2);
            UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public final void e(c cVar, f56 f56Var) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, cVar, f56Var) == null) && cVar != null && f56Var != null) {
            cVar.g.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0d4c) + "    ");
            cVar.a.setText(f56Var.h());
            cVar.a.setOnLongClickListener(new a(this, f56Var));
            if (f56Var.k() == 1) {
                cVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f0808c8), 24, false);
                SkinManager.setViewTextColor(cVar.b, R.color.CAM_X0305, 1);
            } else {
                cVar.b.K(String.valueOf((int) R.drawable.obfuscated_res_0x7f0808c7), 24, false);
                SkinManager.setViewTextColor(cVar.b, R.color.CAM_X0109, 1);
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
            new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
            int i4 = this.c;
            if (i4 == 1) {
                SpannableString d = d(R.string.obfuscated_res_0x7f0f035f, f56Var.l(), foregroundColorSpan, foregroundColorSpan2);
                spannableString3 = b(R.string.obfuscated_res_0x7f0f044e, f56Var.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, f56Var.e());
                spannableString = c(R.string.obfuscated_res_0x7f0f0361, f56Var.d(), foregroundColorSpan, foregroundColorSpan2);
                spannableString4 = d;
                spannableString2 = null;
            } else if (i4 == 2) {
                SpannableString d2 = d(R.string.obfuscated_res_0x7f0f07dc, f56Var.l(), foregroundColorSpan, foregroundColorSpan2);
                if (CurrencySwitchUtil.isYyIsConvert(f56Var.e())) {
                    i = R.string.obfuscated_res_0x7f0f07dd;
                } else {
                    i = R.string.obfuscated_res_0x7f0f07da;
                }
                spannableString3 = b(i, f56Var.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, f56Var.e());
                spannableString = c(R.string.obfuscated_res_0x7f0f0361, f56Var.d(), foregroundColorSpan, foregroundColorSpan2);
                String str = "" + f56Var.j();
                String str2 = this.b.getString(R.string.obfuscated_res_0x7f0f0282) + "    " + str;
                SpannableString spannableString5 = new SpannableString(str2);
                UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
                UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
                spannableString2 = spannableString5;
                spannableString4 = d2;
            } else if (i4 == 3) {
                String string = this.b.getString(R.string.obfuscated_res_0x7f0f0fd9);
                if (CurrencySwitchUtil.isYyIsConvert(f56Var.e())) {
                    l = String.format(this.b.getString(R.string.obfuscated_res_0x7f0f1661), g(Double.valueOf(f56Var.i())));
                } else {
                    l = f56Var.l();
                }
                String str3 = string + "    " + l;
                spannableString4 = new SpannableString(str3);
                UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
                UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
                String str4 = ("" + f56Var.g()) + this.b.getString(R.string.obfuscated_res_0x7f0f0fde);
                String str5 = this.b.getString(R.string.obfuscated_res_0x7f0f0fd8) + "    " + str4;
                SpannableString spannableString6 = new SpannableString(str5);
                UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
                UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
                UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
                spannableString3 = spannableString6;
                SpannableString c2 = c(R.string.obfuscated_res_0x7f0f0fdd, f56Var.f(), foregroundColorSpan, foregroundColorSpan2);
                String str6 = "" + f56Var.j();
                String str7 = this.b.getString(R.string.obfuscated_res_0x7f0f0fd7) + "    " + str6;
                spannableString2 = new SpannableString(str7);
                UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
                UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
                spannableString = c2;
            } else {
                spannableString = null;
                spannableString2 = null;
                spannableString3 = null;
                spannableString4 = null;
            }
            cVar.c.setText(spannableString4);
            cVar.d.setText(spannableString3);
            cVar.e.setText(spannableString);
            if (!StringUtils.isNull(f56Var.j()) && ((i3 = this.c) == 3 || i3 == 2)) {
                cVar.f.setVisibility(0);
                cVar.f.setText(spannableString2);
            } else {
                cVar.f.setVisibility(8);
            }
            if (!StringUtils.isNull(f56Var.b())) {
                cVar.i.setText(f56Var.b());
                if (!StringUtils.isNull(f56Var.a())) {
                    cVar.j.setText(f56Var.a());
                    i2 = 0;
                    cVar.j.setVisibility(0);
                } else {
                    i2 = 0;
                    cVar.j.setVisibility(8);
                }
                cVar.j.setOnClickListener(new b(this, f56Var));
                cVar.h.setVisibility(i2);
                return;
            }
            cVar.h.setVisibility(8);
        }
    }

    public final String g(Double d) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d)) == null) {
            if (d.doubleValue() == d.intValue()) {
                return d.intValue() + "";
            }
            return d + "";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<f56> arrayList = this.a;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            f56 item = getItem(i);
            if (view2 != null) {
                cVar = (c) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0795, viewGroup, false);
                cVar = new c();
                cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091783);
                cVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091787);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091789);
                cVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091786);
                cVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091784);
                cVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091780);
                cVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091788);
                cVar.h = view2.findViewById(R.id.obfuscated_res_0x7f091781);
                cVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090076);
                cVar.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090073);
                view2.setTag(cVar);
            }
            e(cVar, item);
            this.b.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
