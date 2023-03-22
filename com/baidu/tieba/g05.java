package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.k05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g05 implements j05 {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public k05 b;
    public View c;
    public EMTextView d;
    public View e;
    public ImageView f;
    public Drawable g;
    public String h;
    public int i;
    public int j;
    public int k;
    public k05.e l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g05 a;

        public a(g05 g05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l != null) {
                    this.a.l.onClick();
                }
                if (this.a.b != null && this.a.b.d() != null) {
                    this.a.b.d().M0(this.a.b, this.a.a, this.a.d);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740125, "Lcom/baidu/tieba/g05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740125, "Lcom/baidu/tieba/g05;");
                return;
            }
        }
        q = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        r = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    @Override // com.baidu.tieba.j05
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.d, this.j);
            SkinManager.setViewTextColorSelector(this.d, this.i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            MaskView.d(this.d, this.n);
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setImageDrawable(this.g);
            }
        }
    }

    public g05(int i, String str, k05 k05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, k05Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.a = i;
        this.h = str;
        this.b = k05Var;
        j();
        i();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g05(k05 k05Var) {
        this(null, k05Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k05Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (k05) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public g05(String str, k05 k05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, k05Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a(this);
        this.h = str;
        this.b = k05Var;
        this.a = hashCode();
        j();
        i();
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public void l(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.g = drawable;
        }
    }

    public void m(k05.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.l = eVar;
            i();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.h = str;
            this.d.setText(str);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
            SkinManager.setBackgroundResource(this.d, i);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
            SkinManager.setViewTextColor(this.d, i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
            MaskView.d(this.d, z);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j05
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void i() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (eMTextView = this.d) != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n15.d(this.d).B(R.string.F_X02);
        }
    }

    public final void h() {
        k05 k05Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (k05Var = this.b) != null && k05Var.getContext() != null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.popup_dialog_view_horizal_item, this.b.f(), false);
            this.c = inflate;
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (this.o) {
                i = r;
            } else {
                i = q;
            }
            layoutParams.width = i;
            Object tag = this.d.getTag();
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.item_view);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            this.d.setTag(tag);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0908c1);
            this.e = findViewById;
            findViewById.setVisibility(8);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.item_image);
            this.f = imageView;
            imageView.setImageDrawable(this.g);
            a();
            this.c.setOnClickListener(this.p);
        }
    }

    public final void j() {
        k05 k05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (k05Var = this.b) != null && k05Var.getContext() != null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.popup_dialog_view_item, this.b.f(), false);
            this.c = inflate;
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0908c1);
            this.e = findViewById;
            if (this.m) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            a();
        }
    }
}
