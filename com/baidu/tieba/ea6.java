package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ea6 implements da6, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public TbPageContext b;
    public LinearLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public RelativeLayout l;
    public RelativeLayout m;
    public ca6 n;
    public float o;
    public float p;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ea6 a;

        public a(ea6 ea6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ea6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p = 0.0f;
                ea6 ea6Var = this.a;
                ea6Var.i(ea6Var.a);
            }
        }
    }

    public ea6(TbPageContext tbPageContext, int i, int i2, ca6 ca6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), ca6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.n = ca6Var;
        if (i2 > 0) {
            this.a = (i * 1.0f) / i2;
        } else {
            this.a = 1.7777778f;
        }
        this.o = this.a;
        this.p = 0.0f;
        h();
    }

    @Override // com.baidu.tieba.da6
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            i(this.a);
            if (i > 0) {
                this.a = (i2 * 1.0f) / i;
            }
            jg.a().post(new a(this));
        }
    }

    @Override // com.baidu.tieba.da6
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.da6
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.i.setVisibility(i);
            if (i == 8) {
                this.p = 1.7777778f;
                i(1.7777778f);
            }
        }
    }

    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.o = f;
            ca6 ca6Var = this.n;
            if (ca6Var != null) {
                ca6Var.a(f);
            }
            j();
        }
    }

    @Override // com.baidu.tieba.da6
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getVisibility();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.da6
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.da6
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.da6
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p = 0.0f;
            i(this.a);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090528);
            this.c = linearLayout;
            n15 d = n15.d(linearLayout);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0214);
            this.d = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d01);
            this.i = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d02);
            this.g = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cff);
            this.l = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d00);
            this.f = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cfd);
            this.k = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cfe);
            this.e = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cf9);
            this.j = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cfa);
            this.h = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cfb);
            this.m = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091cfc);
            j();
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.m.setOnClickListener(this);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a48));
            this.g.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a47));
            this.f.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a46));
            this.e.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a44));
            this.h.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a45));
            float f = this.p;
            if (f == 0.0f) {
                this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a48, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.7777778f) {
                this.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a47, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.3333334f) {
                this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a46, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 0.5625f) {
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.0f) {
                this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a45, this.b.getResources().getColor(R.color.CAM_X0302), null));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091d02) {
                this.p = 0.0f;
                i(this.a);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d00) {
                this.p = 1.7777778f;
                i(1.7777778f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfe) {
                this.p = 1.3333334f;
                i(1.3333334f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfa) {
                this.p = 0.5625f;
                i(0.5625f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091cfc) {
                this.p = 1.0f;
                i(1.0f);
            }
        }
    }
}
