package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.iv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class gj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iv4 a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public boolean f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj6 a;

        public a(gj6 gj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gj6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gj6 gj6Var = this.a;
                gj6Var.f = !gj6Var.f;
                this.a.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gj6 c;

        public b(gj6 gj6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gj6Var;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                ky4.k().u("key_frs_recommend_tip", !this.c.f);
                mi6.c().d(this.a, this.b);
                this.c.a.dismiss();
                this.c.a = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj6 a;

        public c(gj6 gj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gj6Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, iv4Var) != null) {
                return;
            }
            this.a.f = false;
            this.a.a.dismiss();
            this.a.a = null;
        }
    }

    public gj6() {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.c;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            h();
            TextView textView3 = this.e;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public final void h() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (imageView = this.d) == null) {
            return;
        }
        if (this.f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805fe, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805fd, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, str2) == null) {
            iv4 iv4Var = this.a;
            if (iv4Var != null && iv4Var.isShowing()) {
                return;
            }
            iv4 iv4Var2 = new iv4(tbPageContext.getPageActivity());
            this.a = iv4Var2;
            iv4Var2.setContentViewSize(1);
            this.a.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0170, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092256);
            this.b = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f076a);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0904a5);
            BawuThrones b2 = mi6.c().b();
            if (b2 != null) {
                TextView textView2 = this.c;
                String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0769);
                Integer num = b2.total_recommend_num;
                textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
            } else {
                this.c.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0769), "D", 2, 2));
            }
            this.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090627);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091718);
            inflate.findViewById(R.id.obfuscated_res_0x7f091717).setOnClickListener(new a(this));
            f();
            this.a.setContentView(inflate);
            this.a.setPositiveButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0768), new b(this, str, str2));
            this.a.setNegativeButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c8d), new c(this));
            this.a.create(tbPageContext).show();
        }
    }
}
