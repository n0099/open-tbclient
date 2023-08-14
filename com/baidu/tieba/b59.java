package com.baidu.tieba;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.d59;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b59 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b0 = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String c0 = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public TextView C;
    public TextView D;
    public ImageView E;
    public TextView F;
    public TextView G;
    public ImageView H;
    public ImageView I;
    public LinearLayout J;
    public LinearLayout K;
    public String L;
    public String M;
    public String N;
    public int O;
    public long P;
    public String Q;
    public String R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public Boolean f1090T;
    public int U;
    public String V;
    public String W;
    public String X;
    public int Y;
    public AdapterView.d Z;
    public TbPageContext a;
    public View.OnClickListener a0;
    public View b;
    public RelativeLayout c;
    public HListView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public GridView h;
    public LinearLayout i;
    public TextView j;
    public NoNetworkView k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public c59 o;
    public d59 p;
    public MemberPayResult q;
    public MemberPayResult.i r;
    public MemberPayResult.c s;
    public MemberPayResult.d t;
    public MemberPayResult.a u;
    public MemberPayResult.b v;
    public LinearLayout w;
    public RelativeLayout x;
    public View y;
    public LinearLayout z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947596099, "Lcom/baidu/tieba/b59;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947596099, "Lcom/baidu/tieba/b59;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements d59.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b59 a;

        public a(b59 b59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b59Var;
        }

        @Override // com.baidu.tieba.d59.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                e59.d(this.a.U, this.a.V, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b59 a;

        public b(b59 b59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b59Var;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view2, int i, long j) {
            MemberPayResult.e item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.o.getItem(i)) == null) {
                return;
            }
            item.i = true;
            this.a.o.i(item);
            this.a.D(item.j);
            this.a.G(item.f);
            e59.c(this.a.U, this.a.V, item.a);
            this.a.z(item);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b59 a;

        public c(b59 b59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i2 = 0;
                if (view2 == this.a.j) {
                    this.a.q();
                    if (this.a.O == 1) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    if (this.a.o != null) {
                        MemberPayResult.e c = this.a.o.c();
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
                            e59.b(this.a.U, this.a.V, c.f / 100);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i).param("obj_locate", i2));
                } else if (view2 == this.a.m) {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{b59.c0});
                } else if (view2 == this.a.f) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, true);
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{b59.b0}, false, bundle);
                } else if (view2 == this.a.B && this.a.q != null && this.a.q.d != null && !TextUtils.isEmpty(this.a.q.d.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{this.a.q.d.c});
                }
            }
        }
    }

    public b59(TbPageContext tbPageContext, View view2, int i, String str, String str2, boolean z, int i2, int i3, String str3, String str4) {
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
        this.O = 2;
        this.f1090T = Boolean.FALSE;
        this.Y = 0;
        this.Z = new b(this);
        this.a0 = new c(this);
        this.b = view2;
        this.a = tbPageContext;
        this.O = i;
        this.f1090T = Boolean.valueOf(z);
        this.Q = str;
        this.R = str2;
        this.S = i2;
        this.U = i3;
        this.V = str3;
        this.W = str4;
        t();
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void x(MemberPayResult memberPayResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, memberPayResult) == null) {
            if (memberPayResult == null) {
                this.c.setVisibility(8);
                return;
            }
            this.q = memberPayResult;
            s();
            w();
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        MemberPayResult.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MemberPayResult memberPayResult = this.q;
            if (memberPayResult != null && (gVar = memberPayResult.d) != null && !ListUtils.isEmpty(gVar.d)) {
                this.x.setVisibility(0);
                return true;
            }
            this.x.setVisibility(8);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.f1090T.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.Q, this.R);
            String str = this.N + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c64, new Object[]{String.valueOf(j3)});
            payConfig.setAutoPay(i);
            payConfig.fromScene = this.U;
            if (this.S == 23) {
                payConfig.paymentPosKey = "37";
            }
            lr5.c().a(payConfig, this.a.getPageActivity());
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !r()) {
            return;
        }
        String str = this.q.d.a;
        if (!TextUtils.isEmpty(str)) {
            this.C.setText(str);
        } else {
            this.C.setText(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15f7));
        }
        String str2 = this.q.d.b;
        if (!TextUtils.isEmpty(str2)) {
            this.D.setText(str2);
        } else {
            this.D.setText(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c5a));
        }
        C();
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !r()) {
            return;
        }
        List<MemberPayResult.g.a> list = this.q.d.d;
        MemberPayResult.g.a aVar = list.get(0);
        if (aVar != null && !TextUtils.isEmpty(aVar.a)) {
            y(aVar.a, aVar.b, this.F);
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(8);
        }
        if (ListUtils.getCount(list) >= 2) {
            MemberPayResult.g.a aVar2 = list.get(1);
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.a)) {
                y(aVar2.a, aVar2.b, this.G);
                this.K.setVisibility(0);
            } else {
                this.K.setVisibility(8);
            }
        }
        if (this.J.getVisibility() == 8 && this.K.getVisibility() == 8) {
            this.x.setVisibility(8);
        }
    }

    public final void E() {
        MemberPayResult.d dVar;
        List<MemberPayResult.e> list;
        MemberPayResult.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (2 != this.O ? (dVar = this.t) == null || (list = dVar.a) == null : (aVar = this.u) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (MemberPayResult.e eVar : list) {
                if (eVar.i) {
                    D(eVar.j);
                    G(eVar.f);
                    this.X = eVar.a;
                }
            }
            if (this.o == null) {
                c59 c59Var = new c59(this.a);
                this.o = c59Var;
                c59Var.f(list);
                this.d.setAdapter((ListAdapter) this.o);
            }
            this.o.f(list);
            this.o.notifyDataSetChanged();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.O;
            if (2 == i) {
                if (this.P == 2) {
                    this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f04db, new Object[]{this.L});
                } else {
                    this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0602, new Object[]{this.L});
                }
                this.N = this.L;
            } else if (1 == i) {
                long j = this.P;
                if (j == 1) {
                    this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f04db, new Object[]{this.M});
                } else if (j == 0) {
                    this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0602, new Object[]{this.M});
                }
                this.N = this.M;
            } else {
                this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0602, new Object[]{this.M});
                this.N = this.M;
            }
        }
    }

    public final void q() {
        c59 c59Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (c59Var = this.o) == null) {
            return;
        }
        MemberPayResult.e c2 = c59Var.c();
        if (c2 == null) {
            BdUtilHelper.showToast(this.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f15ff);
        } else if (c2.j == 1 && BdBaseApplication.getInst().isDebugMode() && mr5.a) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{"tieba.baidu.com/mo/q/tbeanrights?from=autopay"}, true);
        } else if (c2.j == 1 && c2.k) {
            BdUtilHelper.showToast(this.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1691);
        } else {
            A(c2.e, c2.f / 100, c2.h, c2.j);
            if (this.S == 26) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
            }
        }
    }

    public final void w() {
        MemberPayResult.i iVar;
        MemberPayResult.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.q == null) {
                this.c.setVisibility(8);
            } else if (this.s != null && (iVar = this.r) != null) {
                if (iVar.a == null) {
                    this.c.setVisibility(8);
                } else if (this.u == null && this.t == null) {
                    this.c.setVisibility(8);
                } else if (this.O == 2 && ((aVar = this.u) == null || ListUtils.isEmpty(aVar.a))) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    E();
                    F();
                    H();
                    B();
                }
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.p == null) {
            ArrayList<MemberPayResult.VipPayPrivilegeData> arrayList = this.v.a;
            d59 d59Var = new d59(this.a.getPageActivity());
            this.p = d59Var;
            d59Var.i(new a(this));
            this.p.h(arrayList);
            this.h.setAdapter((ListAdapter) this.p);
        }
    }

    public final void s() {
        MemberPayResult memberPayResult;
        MemberPayResult.f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (memberPayResult = this.q) == null) {
            return;
        }
        MemberPayResult.c cVar = memberPayResult.b;
        this.s = cVar;
        MemberPayResult.i iVar = memberPayResult.a;
        this.r = iVar;
        this.v = memberPayResult.c;
        if (cVar == null || iVar == null || (fVar = iVar.a) == null) {
            return;
        }
        this.P = fVar.a;
        MemberPayResult.a aVar = cVar.b;
        this.u = aVar;
        if (aVar != null) {
            this.L = aVar.c;
        }
        MemberPayResult.d dVar = this.s.a;
        this.t = dVar;
        if (dVar != null) {
            this.M = dVar.c;
        }
    }

    public final void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.j.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f15fd, "" + (j / 100)));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091f71);
            this.d = (HListView) this.b.findViewById(R.id.obfuscated_res_0x7f091d2e);
            this.i = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091ea6);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d5d);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091d55);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f9b);
            this.h = (GridView) this.b.findViewById(R.id.obfuscated_res_0x7f091d4b);
            this.k = (NoNetworkView) this.b.findViewById(R.id.view_no_network);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09171e);
            this.n = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09171f);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09272c);
            this.m = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09272d);
            this.w = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090b18);
            this.y = this.b.findViewById(R.id.obfuscated_res_0x7f090033);
            this.x = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090034);
            this.z = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092127);
            this.A = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0924c5);
            this.B = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090039);
            this.C = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09003e);
            this.D = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09003d);
            this.E = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090035);
            this.F = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090036);
            this.G = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09003a);
            this.H = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090038);
            this.I = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09003c);
            this.J = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090037);
            this.K = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09003b);
            this.d.setBackgroundResource(R.drawable.transparent_bg);
            this.d.setOnItemClickListener(this.Z);
            this.d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
            this.h.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.j.setOnClickListener(this.a0);
            this.m.setOnClickListener(this.a0);
            this.f.setOnClickListener(this.a0);
            this.B.setOnClickListener(this.a0);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k.onChangeSkinType(this.a, i);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0320);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_tbvip_arrow_right, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.E, R.drawable.icon_tbvip_arrow_right, R.color.CAM_X0109, null);
            WebPManager.setPureDrawable(this.H, R.drawable.obfuscated_res_0x7f080cc0, R.color.CAM_X0311, null);
            WebPManager.setPureDrawable(this.I, R.drawable.obfuscated_res_0x7f080cc0, R.color.CAM_X0311, null);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0311);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.dimen.tbds31).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.obfuscated_res_0x7f0607ea, R.color.CAM_X0335).into(this.n);
            EMManager.from(this.w).setCorner(R.string.J_X06).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0203).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.x).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.y).setAlpha(R.string.A_X10).setCorner(R.string.J_X06).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0203).setGradientColor(new int[]{R.color.CAM_X0335, R.color.CAM_X0205}, Direction.TOP);
            EMManager.from(this.z).setCorner(R.string.J_X06).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0203).setBackGroundColor(R.color.CAM_X0205);
            if (StringHelper.equals(this.W, "1")) {
                this.z.setVisibility(8);
            }
            EMManager.from(this.A).setBackGroundColor(R.color.CAM_X0201);
            if (this.q != null) {
                C();
            }
        }
    }

    public void v(boolean z) {
        MemberPayResult.d dVar;
        List<MemberPayResult.e> list;
        MemberPayResult.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || this.q == null) {
            return;
        }
        List<MemberPayResult.e> list2 = null;
        if (2 != this.O ? !((dVar = this.t) == null || (list = dVar.a) == null) : !((aVar = this.u) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            MemberPayResult.e eVar = list2.get(i);
            if (eVar != null && eVar.f >= 0 && eVar.j == 1) {
                eVar.k = z;
                return;
            }
        }
    }

    public final void z(MemberPayResult.e eVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) && (i = this.U) >= 100200 && i <= 100299 && this.Y < 1 && StringUtils.isNotNull(this.X) && !this.X.equals(eVar.a)) {
            BdToast.makeText(this.a.getPageActivity(), this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f1600)).setIcon(BdToast.ToastIcon.FAILURE).show();
            this.Y++;
        }
    }

    public final void y(@NonNull String str, List<Integer> list, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, list, textView) == null) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0311);
            SpannableString spannableString = new SpannableString(str);
            if (ListUtils.getCount(list) == 2) {
                int intValue = list.get(0).intValue();
                int intValue2 = list.get(1).intValue() + 1;
                if (intValue >= 0 && str.length() >= intValue2 && intValue2 >= intValue) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), intValue, intValue2, 33);
                }
            }
            textView.setText(spannableString);
        }
    }
}
