package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.oi7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class dk7 implements oi7.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ek7 f;
    public oi7 g;
    public View h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk7 a;

        public a(dk7 dk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.j.getId()) {
                this.a.a.getPageActivity().finish();
            }
        }
    }

    public dk7(TbPageContext tbPageContext, View view2) {
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
        this.n = new a(this);
        this.a = tbPageContext;
        this.b = view2;
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09259f);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907b2);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09214e);
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f0921b0);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d41);
        ImageView imageView = (ImageView) view2.findViewById(R.id.close_button);
        this.j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910f5);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int l = yi.l(tbPageContext.getPageActivity()) - (yi.g(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.width = l;
        layoutParams.height = (int) (((l * 364) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091dc8);
        View findViewById = view2.findViewById(R.id.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.h.setBackground(f());
        ek7 ek7Var = new ek7(tbPageContext);
        this.f = ek7Var;
        ek7Var.k();
        i();
        oi7 oi7Var = new oi7(tbPageContext);
        this.g = oi7Var;
        oi7Var.o(view2, this.h, this);
        oi7 oi7Var2 = this.g;
        ek7 ek7Var2 = this.f;
        oi7Var2.q(ek7Var2.b, ek7Var2.f);
        this.g.r(5);
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setImageResource(this.j, R.drawable.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            View view2 = this.b;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.oi7.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.setBackground(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0201)));
            this.k.setImageResource(R.drawable.obfuscated_res_0x7f081230);
        }
    }

    @Override // com.baidu.tieba.oi7.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.setBackground(f());
            this.k.setImageResource(R.drawable.obfuscated_res_0x7f08122f);
        }
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.i.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    public final GradientDrawable f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(R.color.CAM_X0201), SkinManager.getColor(R.color.CAM_X0201)});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(yi.g(this.a.getPageActivity(), R.dimen.tbds31));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setText("你好，朋友！");
            this.d.setText(this.f.h());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView = this.e;
            textView.setText(this.f.d + "\n" + simpleDateFormat.format(date));
            e(this.f.c);
        }
    }
}
