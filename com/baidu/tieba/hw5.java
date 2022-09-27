package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class hw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public kw5 c;
    public BdUniqueId d;
    public LinearLayout e;
    public LinearLayout f;
    public View g;
    public BdTypeListView h;
    public zx4 i;
    public NavigationBar j;
    public LinearLayout k;
    public f95 l;
    public PbListView m;
    public g95 n;
    public final List<qn> o;
    public zv5 p;
    public aw5 q;
    public b r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw5 a;

        public a(hw5 hw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PopupWindow a;
        public View b;
        public TextView c;
        public TextView d;
        public LinearLayout e;
        public List<String> f;
        public boolean g;
        public String h;
        public zf.c i;
        public final /* synthetic */ hw5 j;

        /* loaded from: classes4.dex */
        public class a implements zf.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.zf.c
            public void a(int i, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude == 0.0d || longitude == 0.0d) {
                            return;
                        }
                        dw5 dw5Var = new dw5();
                        dw5Var.a = this.a.h;
                        dw5Var.b = String.valueOf(latitude);
                        dw5Var.c = String.valueOf(longitude);
                        dw5Var.d = true;
                        this.a.j.c.b(dw5Var);
                        this.a.d.setText(this.a.h);
                    } else if (StringUtils.isNull(str)) {
                    } else {
                        this.a.j.a.showToast(str);
                    }
                }
            }
        }

        public b(hw5 hw5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw5Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hw5Var;
            this.g = false;
            this.i = new a(this);
            this.b = view2;
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138b);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0913af);
            this.d = textView;
            textView.setVisibility(8);
            this.d.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f = list;
                if (ListUtils.isEmpty(list) || this.g) {
                    return;
                }
                this.g = true;
                String str = this.f.get(0);
                if (!StringUtils.isNull(str)) {
                    this.d.setText(str);
                    this.d.setVisibility(0);
                }
                this.e = new LinearLayout(this.j.a.getPageActivity());
                this.e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                SkinManager.setBackgroundResource(this.e, R.drawable.bg_ala_sub_list_sort_panel);
                this.e.setClipChildren(true);
                this.e.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.j.a.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07025d), this.j.a.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070306));
                for (int i = 0; i < this.f.size(); i++) {
                    this.e.addView(e(this.f.get(i)), layoutParams);
                    if (i != this.f.size() - 1) {
                        View view2 = new View(this.j.a.getPageActivity());
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, this.j.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198)));
                        SkinManager.setBackgroundResource(view2, R.color.CAM_X0204);
                        this.e.addView(view2);
                    }
                }
                if (this.a == null) {
                    PopupWindow popupWindow = new PopupWindow(this.j.a.getPageActivity());
                    this.a = popupWindow;
                    popupWindow.setContentView(this.e);
                    this.a.setWidth(-2);
                    this.a.setHeight(-2);
                    this.a.setAnimationStyle(16973826);
                    this.a.setBackgroundDrawable(this.j.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080fc1));
                    this.a.setOutsideTouchable(true);
                    this.a.setFocusable(true);
                    this.a.setTouchable(true);
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.isSystemLocationProviderEnabled(this.j.a.getPageActivity()) : invokeV.booleanValue;
        }

        public final TextView e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                TextView textView = new TextView(this.j.a.getPageActivity());
                textView.setTextSize(0, this.j.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9));
                textView.setText(str);
                textView.setTag(str);
                textView.setGravity(17);
                SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                textView.setOnClickListener(this);
                return textView;
            }
            return (TextView) invokeL.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.b.setVisibility(i);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a == null) {
                return;
            }
            int[] iArr = new int[2];
            this.d.getLocationOnScreen(iArr);
            int height = ((View) this.d.getParent()).getHeight() - this.d.getHeight();
            if (iArr[1] - this.a.getHeight() <= 50) {
                ih.d(this.a, this.j.a.getPageActivity());
                return;
            }
            ih.m(this.a, this.j.e, 0, (iArr[0] - (this.d.getWidth() / 2)) - this.j.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.d.getHeight() + height);
            PopupWindow popupWindow = this.a;
            if (popupWindow != null) {
                popupWindow.update();
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.c == null) {
                return;
            }
            this.c.setText(this.j.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11fc, StringHelper.numberUniformFormatExtra(i)));
            this.b.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
                if (view2 == this.d) {
                    h();
                } else if (!(view2 instanceof TextView) || view2.getTag() == null || !(view2.getTag() instanceof String) || StringUtils.isNull((String) view2.getTag())) {
                } else {
                    PopupWindow popupWindow = this.a;
                    if (popupWindow != null) {
                        ih.d(popupWindow, this.j.a.getPageActivity());
                    }
                    if (this.j.c != null) {
                        String str = (String) view2.getTag();
                        this.h = str;
                        if (str.contains("距离")) {
                            if (!d()) {
                                this.j.a.showToast(R.string.obfuscated_res_0x7f0f11f9);
                                return;
                            } else {
                                zf.n().k(false, this.i);
                                return;
                            }
                        }
                        dw5 dw5Var = new dw5();
                        dw5Var.a = this.h;
                        dw5Var.d = false;
                        this.j.c.b(dw5Var);
                        this.d.setText(this.h);
                    }
                }
            }
        }
    }

    public hw5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.d = BdUniqueId.gen();
        this.o = new ArrayList();
        this.a = tbPageContext;
        this.e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d064a, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0110, (ViewGroup) null);
        this.f = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091341);
        View findViewById = this.e.findViewById(R.id.obfuscated_res_0x7f091f99);
        this.g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.h = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f09132a);
        zx4 zx4Var = new zx4(this.a);
        this.i = zx4Var;
        zx4Var.b0(this.d);
        this.h.setPullRefresh(this.i);
        PbListView pbListView = new PbListView(this.a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        zv5 zv5Var = new zv5(this.a);
        this.p = zv5Var;
        zv5Var.v(2);
        aw5 aw5Var = new aw5(this.a);
        this.q = aw5Var;
        aw5Var.v(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.h.a(this.o);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.z();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void g() {
        f95 f95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (f95Var = this.l) == null) {
            return;
        }
        f95Var.dettachView(this.e);
        this.l = null;
    }

    public void h() {
        g95 g95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (g95Var = this.n) == null) {
            return;
        }
        g95Var.dettachView(this.e);
        this.n = null;
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.m) == null || pbListView.b().getParent() == null) {
            return;
        }
        this.h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            if (this.b != i) {
                this.b = i;
            }
            b bVar = this.r;
            if (bVar != null) {
                bVar.f();
            }
            f95 f95Var = this.l;
            if (f95Var != null) {
                f95Var.onChangeSkinType();
            }
            NavigationBar navigationBar = this.j;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.d(i);
            }
            g95 g95Var = this.n;
            if (g95Var != null) {
                g95Var.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f95 f95Var = this.l;
            if (f95Var != null) {
                if (f95Var.j() != null) {
                    this.l.dettachView(this.e);
                }
                this.l.n();
                this.l = null;
            }
            zx4 zx4Var = this.i;
            if (zx4Var != null) {
                zx4Var.f(null);
                this.i.g(null);
                this.i.m(null);
                this.i.Z();
                this.i = null;
            }
            BdTypeListView bdTypeListView = this.h;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.h.setOnScrollListener(null);
                this.h.setRecyclerListener(null);
                this.h = null;
            }
        }
    }

    public void l(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (bVar = this.r) == null) {
            return;
        }
        bVar.i(i);
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.r.c(list);
    }

    public void n(kw5 kw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kw5Var) == null) {
            this.c = kw5Var;
            zv5 zv5Var = this.p;
            if (zv5Var != null) {
                zv5Var.w(kw5Var);
            }
            aw5 aw5Var = this.q;
            if (aw5Var != null) {
                aw5Var.w(this.c);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f.setVisibility(i);
        }
    }

    public void p(List<Cdo> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(yx4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.i.f(gVar);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) {
            this.h.setOnSrollToBottomListener(pVar);
        }
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), list, str, str2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                this.j = navigationBar;
                navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
                if (!StringUtils.isNull(str2)) {
                    this.j.setCenterTextTitle(str2);
                } else if (!StringUtils.isNull(str)) {
                    this.j.setCenterTextTitle(str);
                }
                this.e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
            }
            if (!ListUtils.isEmpty(list)) {
                this.r.c(list);
            }
            this.p.x(z3);
            this.q.x(z3);
        }
    }

    public void t() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbPageContext = this.a) == null || this.e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new f95(tbPageContext.getPageActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
        }
        f95 f95Var = this.l;
        if (f95Var != null) {
            f95Var.attachView(this.e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new g95(this.a.getPageActivity(), onClickListener);
            }
            this.n.k(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070260));
            this.n.m(str);
            this.n.attachView(this.e, false);
            if (z) {
                this.n.p();
            } else {
                this.n.e();
            }
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.m) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.h.setNextPage(this.m);
        }
        this.m.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a2c));
        this.m.f();
    }
}
