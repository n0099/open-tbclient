package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.jx7;
import com.baidu.tieba.kx7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class hx7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String Q = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String R = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public int D;
    public long E;
    public String F;
    public String G;
    public int H;
    public Boolean I;
    public int J;
    public String K;
    public String L;
    public String M;
    public int N;
    public AdapterView.d O;
    public View.OnClickListener P;
    public TbPageContext a;
    public View b;
    public RelativeLayout c;
    public HListView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public GridView i;
    public LinearLayout j;
    public TextView k;
    public NoNetworkView l;
    public TextView m;
    public LinearLayout n;
    public ix7 o;
    public jx7 p;
    public kx7 q;
    public kx7.h r;
    public kx7.c s;
    public kx7.d t;
    public kx7.a u;
    public kx7.b v;
    public LinearLayout w;
    public LinearLayout x;
    public LinearLayout y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947839170, "Lcom/baidu/tieba/hx7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947839170, "Lcom/baidu/tieba/hx7;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements jx7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public a(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // com.baidu.tieba.jx7.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                lx7.d(this.a.J, this.a.K, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public b(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            kx7.e item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.o.getItem(i)) == null) {
                return;
            }
            item.i = true;
            this.a.o.i(item);
            this.a.x(item.j);
            this.a.A(item.f);
            lx7.c(this.a.J, this.a.K, item.a);
            this.a.v(item);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public c(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i2 = 0;
                if (view2 == this.a.k) {
                    this.a.o();
                    if (this.a.D == 1) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    if (this.a.o != null) {
                        kx7.e c = this.a.o.c();
                        if (c != null && c.j != 1) {
                            long j = c.h;
                            if (j == 1) {
                                i2 = 1;
                            } else if (j == 3) {
                                i2 = 3;
                            } else if (j == 6) {
                                i2 = 6;
                            } else if (j == 12) {
                                i2 = 12;
                            }
                        }
                        if (c != null) {
                            lx7.b(this.a.J, this.a.K, c.f / 100);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i).param("obj_locate", i2));
                } else if (view2 == this.a.e) {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{hx7.R});
                } else if (view2 == this.a.g) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, true);
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{hx7.Q}, false, bundle);
                }
            }
        }
    }

    public hx7(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2, int i3, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i), str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = 2;
        this.I = Boolean.FALSE;
        this.N = 0;
        this.O = new b(this);
        this.P = new c(this);
        this.b = view2;
        this.a = tbPageContext;
        this.D = i;
        this.I = Boolean.valueOf(z);
        this.F = str;
        this.G = str2;
        this.H = i2;
        this.J = i3;
        this.K = str3;
        this.L = str4;
        q();
    }

    public void u(kx7 kx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kx7Var) == null) {
            if (kx7Var == null) {
                this.c.setVisibility(8);
                return;
            }
            this.q = kx7Var;
            p();
            t();
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 1) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public final void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.k.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f143e, "" + (j / 100)));
        }
    }

    public final void B() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.D;
            if (2 == i) {
                if (this.E == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0463, new Object[]{this.z});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0543, new Object[]{this.z});
                }
                this.C = this.z;
            } else if (1 == i) {
                long j = this.E;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0463, new Object[]{this.A});
                } else if (j == 0) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0543, new Object[]{this.A});
                } else {
                    string = null;
                }
                this.C = this.A;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0543, new Object[]{this.A});
                this.C = this.A;
            }
            this.B = string;
        }
    }

    public final void o() {
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (ix7Var = this.o) == null) {
            return;
        }
        kx7.e c2 = ix7Var.c();
        if (c2 == null) {
            zi.P(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1440);
        } else if (c2.j == 1 && BdBaseApplication.getInst().isDebugMode() && wf5.a) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{"tieba.baidu.com/mo/q/tbeanrights?from=autopay"}, true);
        } else if (c2.j == 1 && c2.k) {
            zi.P(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f14c6);
        } else {
            w(c2.e, c2.f / 100, c2.h, c2.j);
            if (this.H == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
            }
        }
    }

    public final void t() {
        kx7.h hVar;
        kx7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.q == null) {
                this.c.setVisibility(8);
            } else if (this.s != null && (hVar = this.r) != null) {
                if (hVar.a == null) {
                    this.c.setVisibility(8);
                } else if (this.u == null && this.t == null) {
                    this.c.setVisibility(8);
                } else if (this.D == 2 && ((aVar = this.u) == null || ListUtils.isEmpty(aVar.a))) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    y();
                    z();
                    B();
                }
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public final void y() {
        kx7.d dVar;
        List<kx7.e> list;
        kx7.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (2 != this.D ? (dVar = this.t) == null || (list = dVar.a) == null : (aVar = this.u) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (kx7.e eVar : list) {
                if (eVar.i) {
                    x(eVar.j);
                    A(eVar.f);
                    this.M = eVar.a;
                }
            }
            if (this.o == null) {
                ix7 ix7Var = new ix7(this.a);
                this.o = ix7Var;
                ix7Var.f(list);
                this.d.setAdapter((ListAdapter) this.o);
            }
            this.o.f(list);
            this.o.notifyDataSetChanged();
        }
    }

    public final void p() {
        kx7 kx7Var;
        kx7.f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (kx7Var = this.q) == null) {
            return;
        }
        kx7.c cVar = kx7Var.b;
        this.s = cVar;
        kx7.h hVar = kx7Var.a;
        this.r = hVar;
        this.v = kx7Var.c;
        if (cVar == null || hVar == null || (fVar = hVar.a) == null) {
            return;
        }
        this.E = fVar.a;
        kx7.a aVar = cVar.b;
        this.u = aVar;
        if (aVar != null) {
            this.z = aVar.c;
        }
        kx7.d dVar = this.s.a;
        this.t = dVar;
        if (dVar != null) {
            this.A = dVar.c;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.p == null) {
            ArrayList<kx7.i> arrayList = this.v.a;
            jx7 jx7Var = new jx7(this.a.getPageActivity());
            this.p = jx7Var;
            jx7Var.g(new a(this));
            this.p.f(arrayList);
            this.i.setAdapter((ListAdapter) this.p);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d49);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f091b3a);
            this.j = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c9c);
            this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c9d);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b69);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b61);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091d73);
            this.i = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f091b57);
            this.l = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09159e);
            this.n = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09159f);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0924b3);
            this.w = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0909fb);
            this.x = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091efb);
            this.y = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092267);
            this.d.setBackgroundResource(R.drawable.transparent_bg);
            this.d.setOnItemClickListener(this.O);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
            this.i.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.i.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds80));
            this.k.setOnClickListener(this.P);
            this.e.setOnClickListener(this.P);
            this.g.setOnClickListener(this.P);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.l.d(this.a, i);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_tbvip_arrow_right, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.e, R.drawable.obfuscated_res_0x7f080b18);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0311);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.dimen.tbds31).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.obfuscated_res_0x7f0607d6, R.color.CAM_X0335).into(this.n);
            cx4 d = cx4.d(this.w);
            d.n(R.string.J_X06);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0203);
            d.f(R.color.CAM_X0205);
            cx4 d2 = cx4.d(this.x);
            d2.n(R.string.J_X06);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0203);
            d2.f(R.color.CAM_X0205);
            if (StringHelper.equals(this.L, "1")) {
                this.x.setVisibility(8);
            }
            cx4.d(this.y).f(R.color.CAM_X0201);
        }
    }

    public void s(boolean z) {
        kx7.d dVar;
        List<kx7.e> list;
        kx7.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.q == null) {
            return;
        }
        List<kx7.e> list2 = null;
        if (2 != this.D ? !((dVar = this.t) == null || (list = dVar.a) == null) : !((aVar = this.u) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            kx7.e eVar = list2.get(i);
            if (eVar != null && eVar.f >= 0 && eVar.j == 1) {
                eVar.k = z;
                return;
            }
        }
    }

    public final void v(kx7.e eVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) && (i = this.J) >= 100200 && i <= 100299 && this.N < 1 && StringUtils.isNotNull(this.M) && !this.M.equals(eVar.a)) {
            BdToast b2 = BdToast.b(this.a.getPageActivity(), this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f1441));
            b2.g(BdToast.ToastIcon.FAILURE);
            b2.k();
            this.N++;
        }
    }

    public final void w(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.I.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.F, this.G);
            payConfig.setTitle(this.B);
            payConfig.setOrderName(this.C + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0b3d, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.H == 23) {
                payConfig.paymentPosKey = "37";
            }
            uf5.c().a(payConfig, this.a.getPageActivity());
        }
    }
}
