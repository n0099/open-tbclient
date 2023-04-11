package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class f77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TBSpecificationBtn f;
    public TBSpecificationBtn g;
    public View h;
    public e77 i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f77 a;

        public a(f77 f77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.f.getId()) {
                    if (this.a.b.getPageActivity() != null) {
                        this.a.b.getPageActivity().finish();
                    }
                    this.a.f(2);
                } else if (view2.getId() == this.a.g.getId()) {
                    if (this.a.j != null) {
                        this.a.j.onClick(view2);
                    }
                    this.a.f(1);
                }
            }
        }
    }

    public f77(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.b = tbPageContext;
        this.a = view2;
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09244e);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090782);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092011);
        this.f = (TBSpecificationBtn) view2.findViewById(R.id.btn_known);
        o55 o55Var = new o55();
        o55Var.q(R.color.CAM_X0618);
        this.f.setConfig(o55Var);
        this.f.setTextSize(R.dimen.tbds42);
        this.f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f.setOnClickListener(this.k);
        this.g = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0904c6);
        n55 n55Var = new n55();
        n55Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
        this.g.setConfig(n55Var);
        this.g.setTextSize(R.dimen.tbds42);
        this.g.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f083a));
        this.g.setOnClickListener(this.k);
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f090449);
        int i3 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.h.setBackground(gradientDrawable);
        e77 e77Var = new e77(tbPageContext);
        this.i = e77Var;
        e77Var.k();
        i();
        String str = this.i.m;
        if (str != null && str.equals("bazhu")) {
            i3 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i3).param("fid", this.i.e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            View view2 = this.a;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public final void f(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            String str = this.i.m;
            if (str != null && str.equals("bazhu")) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i).param("obj_source", i2).param("fid", this.i.e).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView textView = this.c;
            textView.setText(this.i.d + ":");
            this.d.setText(this.i.j());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView2 = this.e;
            textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
        }
    }
}
