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
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class boa extends p55 implements View.OnClickListener {
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
    public p55.e m;
    public String n;
    public p55.e o;
    public String p;
    public CompoundButton.OnCheckedChangeListener q;
    public boolean r;
    public TbCheckBox.b s;
    public final rg<jn> t;

    /* loaded from: classes5.dex */
    public class a implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boa a;

        public a(boa boaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {boaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = boaVar;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && this.a.q != null) {
                this.a.q.onCheckedChanged(null, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boa a;

        public b(boa boaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {boaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = boaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                super.onLoaded((b) jnVar, str, i);
                if (jnVar != null && jnVar.w()) {
                    this.a.b.setBackgroundResource(0);
                    this.a.b.setImageDrawable(null);
                    jnVar.h(this.a.b);
                    return;
                }
                this.a.b.setImageResource(R.drawable.obfuscated_res_0x7f0806ce);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public c(boa boaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {boaVar};
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
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public boa(Activity activity) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091cd1) {
            p55.e eVar = this.m;
            if (eVar != null) {
                eVar.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f0918da) {
            p55.e eVar2 = this.o;
            if (eVar2 != null) {
                eVar2.onClick(this);
            }
        } else if (id == R.id.obfuscated_res_0x7f090720) {
            dismiss();
        } else if (id == R.id.obfuscated_res_0x7f0906dd) {
            TbCheckBox tbCheckBox = this.e;
            tbCheckBox.setChecked(!tbCheckBox.d());
        }
    }

    public boa e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (boa) invokeL.objValue;
    }

    public boa f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (boa) invokeL.objValue;
    }

    @Override // com.baidu.tieba.p55
    public /* bridge */ /* synthetic */ p55 setMessage(String str) {
        f(str);
        return this;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d027d, (ViewGroup) null);
            this.a = viewGroup;
            this.b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09088f);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09172c);
            Button button = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0918da);
            this.h = button;
            button.setOnClickListener(this);
            Button button2 = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f091cd1);
            this.g = button2;
            button2.setOnClickListener(this);
            ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090720);
            this.i = imageView;
            imageView.setOnClickListener(this);
            this.d = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0906dd);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906df);
            TbCheckBox tbCheckBox = (TbCheckBox) this.a.findViewById(R.id.obfuscated_res_0x7f0906db);
            this.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f0808e5, R.drawable.obfuscated_res_0x7f0808e6);
            this.e.setStatedChangedListener(this.s);
            this.e.setTagData(new c(this));
            this.d.setClickable(true);
            this.d.setOnClickListener(this);
            setContentView(this.a);
        }
    }

    @Override // com.baidu.tieba.p55
    public p55 create(l9<?> l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l9Var)) == null) {
            if (this.r) {
                return this;
            }
            this.r = true;
            super.create(l9Var);
            if (!xi.isEmpty(this.k)) {
                this.c.setText(this.k);
            }
            if (!xi.isEmpty(this.p)) {
                this.f.setText(this.p);
            } else {
                this.d.setVisibility(4);
            }
            if (!xi.isEmpty(this.n)) {
                this.h.setText(this.n);
            }
            if (!xi.isEmpty(this.l)) {
                this.g.setText(this.l);
            }
            if (!TextUtils.isEmpty(this.j)) {
                sg.h().m(this.j, 10, this.t, l9Var.getUniqueId());
            } else {
                this.b.setImageResource(R.drawable.obfuscated_res_0x7f0806ce);
            }
            getRealView().setBackgroundDrawable(null);
            return this;
        }
        return (p55) invokeL.objValue;
    }

    public boa d(@StringRes int i, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
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
        return (boa) invokeIL.objValue;
    }

    public boa g(@StringRes int i, p55.e eVar) {
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
        return (boa) invokeIL.objValue;
    }

    public boa h(int i, p55.e eVar) {
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
        return (boa) invokeIL.objValue;
    }

    public boa i(String str, p55.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, eVar)) == null) {
            this.l = str;
            this.m = eVar;
            return this;
        }
        return (boa) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.p55
    public /* bridge */ /* synthetic */ p55 setNegativeButton(@StringRes int i, p55.e eVar) {
        g(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.p55
    public /* bridge */ /* synthetic */ p55 setPositiveButton(int i, p55.e eVar) {
        h(i, eVar);
        return this;
    }

    @Override // com.baidu.tieba.p55
    public p55 setNegativeButton(String str, p55.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, eVar)) == null) {
            this.n = str;
            this.o = eVar;
            return this;
        }
        return (p55) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.p55
    public /* bridge */ /* synthetic */ p55 setPositiveButton(String str, p55.e eVar) {
        i(str, eVar);
        return this;
    }
}
