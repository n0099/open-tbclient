package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public iv4 b;
    public boolean c;
    public View d;
    public TbImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public final View.OnClickListener i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb8 a;

        public a(eb8 eb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eb8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dismiss();
            }
        }
    }

    public eb8(TbPageContext tbPageContext) {
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
        this.i = new a(this);
        this.a = tbPageContext;
        this.c = ky4.k().h("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int l = xi.l(this.a.getPageActivity()) - (xi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225) * 2);
        layoutParams.width = l;
        layoutParams.height = (l * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d070d, (ViewGroup) null);
            this.d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e6e);
            this.e = tbImageView;
            e(tbImageView);
            this.e.setAutoChangeStyle(true);
            this.e.setRadius(xi.g(this.a.getPageActivity(), R.dimen.tbds24));
            this.e.setConrers(3);
            this.e.setIsBitmapPic(true);
            this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e6f);
            this.g = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e70);
            TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e6d);
            this.h = textView;
            textView.setOnClickListener(this.i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080faa);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.c) {
            return;
        }
        this.c = true;
        ky4.k().u("key_person_dynamic_tab_guide_has_shown", true);
        b();
        iv4 iv4Var = new iv4(this.a.getPageActivity());
        this.b = iv4Var;
        iv4Var.setContentViewSize(1);
        this.b.setCancelable(true);
        this.b.setCanceledOnTouchOutside(false);
        this.b.setContentView(this.d);
        this.b.create(this.a).show();
    }
}
