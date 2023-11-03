package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.j05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f05 implements i05 {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final int t;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public j05 b;
    public View c;
    public EMTextView d;
    public View e;
    public ImageView f;
    public Drawable g;
    public String h;
    public int i;
    public int j;
    public int k;
    public j05.e l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Object p;
    public boolean q;
    public final View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;

        public a(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l != null) {
                    this.a.l.onClick();
                }
                if (this.a.b != null && this.a.b.e() != null) {
                    j05.f e = this.a.b.e();
                    f05 f05Var = this.a;
                    f05Var.d.setTag(R.id.item_data, f05Var.p);
                    e.F0(this.a.b, this.a.a, this.a.d);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947710334, "Lcom/baidu/tieba/f05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947710334, "Lcom/baidu/tieba/f05;");
                return;
            }
        }
        s = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds251);
        t = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds231);
    }

    @Override // com.baidu.tieba.i05
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SkinManager.setBackgroundResource(this.d, this.j);
            SkinManager.setViewTextColorSelector(this.d, this.i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            MaskView.c(this.d, this.n);
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setImageDrawable(this.g);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f05(int i, String str, j05 j05Var) {
        this(i, str, null, j05Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, j05Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], objArr2[2], (j05) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public f05(int i, String str, @Nullable Object obj, j05 j05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, obj, j05Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = false;
        this.r = new a(this);
        this.a = i;
        this.h = str;
        this.b = j05Var;
        this.p = obj;
        j();
        i();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f05(j05 j05Var) {
        this(null, j05Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j05Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (j05) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public f05(String str, j05 j05Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, j05Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = false;
        this.r = new a(this);
        this.h = str;
        this.b = j05Var;
        this.a = hashCode();
        j();
        i();
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void m(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.g = drawable;
        }
    }

    public void n(j05.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.l = eVar;
            i();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.h = str;
            this.d.setText(str);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.j = i;
            SkinManager.setBackgroundResource(this.d, i);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.i = i;
            SkinManager.setViewTextColor(this.d, i);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
            MaskView.c(this.d, z);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i05
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void i() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (eMTextView = this.d) != null) {
            eMTextView.setOnClickListener(this.r);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            EMManager.from(this.d).setTextStyle(R.string.F_X02);
        }
    }

    public final void h() {
        j05 j05Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j05Var = this.b) != null && j05Var.d() != null) {
            View inflate = LayoutInflater.from(this.b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.b.g(), false);
            this.c = inflate;
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (this.q) {
                i = t;
            } else {
                i = s;
            }
            layoutParams.width = i;
            Object tag = this.d.getTag();
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.item_view);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            this.d.setTag(tag);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f090939);
            this.e = findViewById;
            findViewById.setVisibility(8);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.item_image);
            this.f = imageView;
            imageView.setImageDrawable(this.g);
            onChangeSkinType();
            this.c.setOnClickListener(this.r);
        }
    }

    public final void j() {
        j05 j05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (j05Var = this.b) != null && j05Var.d() != null) {
            View inflate = LayoutInflater.from(this.b.d()).inflate(R.layout.popup_dialog_view_item, this.b.g(), false);
            this.c = inflate;
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
            this.d = eMTextView;
            eMTextView.setText(this.h);
            this.d.setGravity(this.k);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f090939);
            this.e = findViewById;
            if (this.m) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            onChangeSkinType();
        }
    }
}
