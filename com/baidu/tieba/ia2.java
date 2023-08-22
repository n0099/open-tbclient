package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.ha3;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ia2 extends ja2 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean K0;
    public static String L0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter G0;
    public final List<dg3> H0;
    public FrameLayout I0;
    public boolean J0;

    @Override // com.baidu.tieba.ja2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia2 a;

        public a(ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia2Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia2 a;

        public b(ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.J0 = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg3 a;
        public final /* synthetic */ ia2 b;

        public c(ia2 ia2Var, dg3 dg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var, dg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia2Var;
            this.a = dg3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.f3().e0().z(ia2.L0, true);
                this.b.j3(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements wp3<Map<String, dg3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia2 a;

        public d(ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(Map<String, dg3> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) && (activity = this.a.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                la3.b(this.a.I0);
                if (map == null) {
                    return;
                }
                for (Map.Entry<String, dg3> entry : map.entrySet()) {
                    dg3 value = entry.getValue();
                    if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.d && value.b() && "2".equals(value.e) && !"snsapi_base".equals(value.b)) {
                        this.a.H0.add(value);
                    }
                }
                this.a.l3();
                this.a.G0.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia2 a;

        public e(ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public dg3 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (dg3) this.a.H0.get(i);
            }
            return (dg3) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return getItem(i).hashCode();
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.H0.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null || !(view2.getTag() instanceof g)) {
                    view2 = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d00d7, null);
                    g gVar = new g(this.a);
                    gVar.b = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f0906ee);
                    gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258f);
                    view2.setTag(gVar);
                }
                g gVar2 = (g) view2.getTag();
                dg3 item = getItem(i);
                if (TextUtils.isEmpty(item.g)) {
                    str = item.f;
                } else {
                    str = item.g;
                }
                TextView textView = gVar2.a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.b.setChecked(item.a());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg3 a;
        public final /* synthetic */ ia2 b;

        public f(ia2 ia2Var, dg3 dg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var, dg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia2Var;
            this.a = dg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) != null) || (activity = this.b.getActivity()) == null) {
                return;
            }
            la3.b(this.b.I0);
            if (gg3Var == null || !gg3Var.c()) {
                va3.f(activity, R.string.obfuscated_res_0x7f0f01f0).G();
            } else {
                this.b.k3(this.a, gg3Var.a.b);
            }
            this.b.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public CheckBox b;
        public final /* synthetic */ ia2 c;

        public g(ia2 ia2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ia2Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947846703, "Lcom/baidu/tieba/ia2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947846703, "Lcom/baidu/tieba/ia2;");
                return;
            }
        }
        K0 = nr1.a;
        L0 = "pref_close_scope_alert_showed";
    }

    public ia2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = new ArrayList();
        this.J0 = false;
    }

    public static ia2 h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new ia2();
        }
        return (ia2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c0 = null;
            super.C0();
        }
    }

    public final BaseAdapter e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new e(this);
        }
        return (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public db3 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return qw2.T().D();
        }
        return (db3) invokeV.objValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            la3.g(getActivity(), this.I0);
            this.H0.clear();
            this.G0.notifyDataSetChanged();
            b33.h(new d(this));
        }
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onPause()");
            }
        }
    }

    @Override // com.baidu.tieba.ja2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            J2(1);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onResume()");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            g3();
        }
    }

    public final void k3(dg3 dg3Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, dg3Var, z) == null) {
            if (z) {
                i = 1;
            } else {
                i = -1;
            }
            dg3Var.j = i;
            this.G0.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ja2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            X1(view2);
            v2(-1);
            E2(-16777216);
            x2(K(R.string.obfuscated_res_0x7f0f049f));
            z2(true);
            L2(false);
        }
    }

    public final void j3(dg3 dg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dg3Var) == null) {
            d3(dg3Var, !dg3Var.a());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            super.s0(activity);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.v0(bundle);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
            }
        }
    }

    public final void d3(dg3 dg3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, dg3Var, z) == null) {
            db3 f3 = f3();
            if (f3 == null) {
                this.J0 = false;
                return;
            }
            la3.g(getActivity(), this.I0);
            f3.e0().d(getActivity(), dg3Var.b, false, z, true, new f(this, dg3Var));
        }
    }

    public final void i3(dg3 dg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dg3Var) == null) {
            ha3.a aVar = new ha3.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f01f3);
            aVar.v(R.string.obfuscated_res_0x7f0f01f2);
            aVar.n(new lq3());
            aVar.O(R.string.obfuscated_res_0x7f0f01f1, new c(this, dg3Var));
            aVar.B(R.string.obfuscated_res_0x7f0f013f, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void l3() {
        View b0;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (b0 = b0()) == null) {
            return;
        }
        boolean isEmpty = this.H0.isEmpty();
        TextView textView = (TextView) b0.findViewById(R.id.obfuscated_res_0x7f09258c);
        int i2 = 8;
        if (isEmpty) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        if (!isEmpty) {
            textView.setText(M(R.string.obfuscated_res_0x7f0f01f4, f3().Z()));
        }
        View findViewById = b0.findViewById(R.id.obfuscated_res_0x7f09101e);
        if (findViewById != null) {
            if (isEmpty) {
                i2 = 0;
            }
            findViewById.setVisibility(i2);
        }
        TextView textView2 = (TextView) b0.findViewById(R.id.obfuscated_res_0x7f0909ff);
        if (isEmpty) {
            textView2.setText(M(R.string.obfuscated_res_0x7f0f01ef, f3().Z()));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.J0) {
            return;
        }
        dg3 dg3Var = this.H0.get(i);
        this.J0 = true;
        if (dg3Var.a() && !f3().e0().m(L0, false)) {
            i3(dg3Var);
            return;
        }
        bg3.k("onItemClick : " + dg3Var, Boolean.FALSE);
        j3(dg3Var);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00d6, viewGroup, false);
            W1(inflate);
            this.I0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0907b5);
            this.G0 = e3();
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090191);
            listView.setAdapter((ListAdapter) this.G0);
            listView.setOnItemClickListener(this);
            if (V1()) {
                inflate = Y1(inflate);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.z0();
            db3 f3 = f3();
            if (f3 != null) {
                f3.e0().v();
            }
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
            }
        }
    }
}
