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
public class e69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public c05 b;
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
        public final /* synthetic */ e69 a;

        public a(e69 e69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dismiss();
            }
        }
    }

    public e69(TbPageContext tbPageContext) {
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
        this.c = p45.m().i("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int l = ii.l(this.a.getPageActivity()) - (ii.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225) * 2);
        layoutParams.width = l;
        layoutParams.height = (l * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d074b, (ViewGroup) null);
            this.d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090f99);
            this.e = tbImageView;
            e(tbImageView);
            this.e.setAutoChangeStyle(true);
            this.e.setRadius(ii.g(this.a.getPageActivity(), R.dimen.tbds24));
            this.e.setConrers(3);
            this.e.setIsBitmapPic(true);
            this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f9a);
            this.g = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f9b);
            TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f98);
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
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f081006);
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
        p45.m().w("key_person_dynamic_tab_guide_has_shown", true);
        b();
        c05 c05Var = new c05(this.a.getPageActivity());
        this.b = c05Var;
        c05Var.setContentViewSize(1);
        this.b.setCancelable(true);
        this.b.setCanceledOnTouchOutside(false);
        this.b.setContentView(this.d);
        this.b.create(this.a).show();
    }
}
