package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.nu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fx8 extends nu4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ImageView b;
    public TextView c;
    public ViewGroup d;
    public TbCheckBox e;
    public TextView f;
    public Button g;
    public Button h;
    public ImageView i;
    public String j;
    public String k;
    public String l;
    public nu4.e m;
    public String n;
    public nu4.e o;
    public String p;
    public CompoundButton.OnCheckedChangeListener q;
    public boolean r;
    public TbCheckBox.b s;
    public final yg<on> t;

    /* loaded from: classes4.dex */
    public class a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public a(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) || this.a.q == null) {
                return;
            }
            this.a.q.onCheckedChanged(null, z);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx8 a;

        public b(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((b) onVar, str, i);
                if (onVar == null || !onVar.w()) {
                    this.a.b.setImageResource(R.drawable.obfuscated_res_0x7f080596);
                    return;
                }
                this.a.b.setBackgroundResource(0);
                this.a.b.setImageDrawable(null);
                onVar.h(this.a.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public c(fx8 fx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx8(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = false;
        this.s = new a(this);
        this.t = new b(this);
        c();
        setContentViewSize(1);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d0240, (ViewGroup) null);
            this.a = viewGroup;
            this.b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b2);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091515);
            Button button = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091672);
            this.h = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091a38);
            this.g = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090656);
            this.i = imageView;
            imageView.setOnClickListener(this);
            this.d = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f090613);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090615);
            TbCheckBox tbCheckBox = (TbCheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f090611);
            this.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f08072a, R.drawable.obfuscated_res_0x7f08072b);
            this.e.setStatedChangedListener(this.s);
            this.e.setTagData(new c(this));
            this.d.setClickable(true);
            this.d.setOnClickListener(this);
            setContentView(this.a);
        }
    }

    @Override // com.baidu.tieba.nu4
    public nu4 create(r9<?> r9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r9Var)) == null) {
            if (this.r) {
                return this;
            }
            this.r = true;
            super.create(r9Var);
            if (!dj.isEmpty(this.k)) {
                this.c.setText(this.k);
            }
            if (!dj.isEmpty(this.p)) {
                this.f.setText(this.p);
            } else {
                this.d.setVisibility(4);
            }
            if (!dj.isEmpty(this.n)) {
                this.h.setText(this.n);
            }
            if (!dj.isEmpty(this.l)) {
                this.g.setText(this.l);
            }
            if (!TextUtils.isEmpty(this.j)) {
                zg.h().m(this.j, 10, this.t, r9Var.getUniqueId());
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f080596);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (nu4) invokeL.objValue;
    }

    public fx8 d(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, onCheckedChangeListener)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.p = activity.getResources().getString(i);
                this.q = onCheckedChangeListener;
            }
            return this;
        }
        return (fx8) invokeIL.objValue;
    }

    public fx8 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (fx8) invokeL.objValue;
    }

    public fx8 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (fx8) invokeL.objValue;
    }

    public fx8 g(@StringRes int i, nu4.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.n = activity.getResources().getString(i);
                this.o = eVar;
            }
            return this;
        }
        return (fx8) invokeIL.objValue;
    }

    public fx8 h(int i, nu4.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.l = activity.getResources().getString(i);
                this.m = eVar;
            }
            return this;
        }
        return (fx8) invokeIL.objValue;
    }

    public fx8 i(String str, nu4.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.l = str;
            this.m = eVar;
            return this;
        }
        return (fx8) invokeLL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091a38) {
            nu4.e eVar = this.m;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f091672) {
            nu4.e eVar2 = this.o;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f090656) {
            dismiss();
        } else if (id == R.id.obfuscated_res_0x7f090613) {
            TbCheckBox tbCheckBox = this.e;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    @Override // com.baidu.tieba.nu4
    public /* bridge */ /* synthetic */ nu4 setMessage(String str) {
        f(str);
        return this;
    }

    @Override // com.baidu.tieba.nu4
    public /* bridge */ /* synthetic */ nu4 setNegativeButton(@StringRes int i, nu4.e eVar) {
        g(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.nu4
    public /* bridge */ /* synthetic */ nu4 setPositiveButton(int i, nu4.e eVar) {
        h(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.nu4
    public nu4 setNegativeButton(String str, nu4.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.n = str;
            this.o = eVar;
            return this;
        }
        return (nu4) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.nu4
    public /* bridge */ /* synthetic */ nu4 setPositiveButton(String str, nu4.e eVar) {
        i(str, eVar);
        return this;
    }
}
