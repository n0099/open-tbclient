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
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.az4;
import com.baidu.tieba.tf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public jz5 c;
    public BdUniqueId d;
    public LinearLayout e;
    public LinearLayout f;
    public View g;
    public BdTypeListView h;
    public bz4 i;
    public NavigationBar j;
    public LinearLayout k;
    public ka5 l;
    public PbListView m;
    public la5 n;
    public final List<kn> o;
    public yy5 p;
    public zy5 q;
    public b r;

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
        public tf.c i;
        public final /* synthetic */ gz5 j;

        /* loaded from: classes4.dex */
        public class a implements tf.c {
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

            @Override // com.baidu.tieba.tf.c
            public void a(int i, String str, Address address) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                    if (address != null) {
                        double latitude = address.getLatitude();
                        double longitude = address.getLongitude();
                        if (latitude != 0.0d && longitude != 0.0d) {
                            cz5 cz5Var = new cz5();
                            cz5Var.a = this.a.h;
                            cz5Var.b = String.valueOf(latitude);
                            cz5Var.c = String.valueOf(longitude);
                            cz5Var.d = true;
                            this.a.j.c.b(cz5Var);
                            this.a.d.setText(this.a.h);
                        }
                    } else if (!StringUtils.isNull(str)) {
                        this.a.j.a.showToast(str);
                    }
                }
            }
        }

        public b(gz5 gz5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz5Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = gz5Var;
            this.g = false;
            this.i = new a(this);
            this.b = view2;
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09141f);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091443);
            this.d = textView;
            textView.setVisibility(8);
            this.d.setOnClickListener(this);
            f();
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.b.setVisibility(i);
            }
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f = list;
                if (!ListUtils.isEmpty(list) && !this.g) {
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
                        GreyUtil.grey(this.a);
                        this.a.setWidth(-2);
                        this.a.setHeight(-2);
                        this.a.setAnimationStyle(16973826);
                        this.a.setBackgroundDrawable(this.j.a.getResources().getDrawable(R.drawable.popup_window_transparent));
                        this.a.setOutsideTouchable(true);
                        this.a.setFocusable(true);
                        this.a.setTouchable(true);
                    }
                }
            }
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!UtilHelper.isSystemLocationProviderEnabled(this.j.a.getPageActivity())) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
            }
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

        public final void h() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a != null) {
                int[] iArr = new int[2];
                this.d.getLocationOnScreen(iArr);
                int height = ((View) this.d.getParent()).getHeight() - this.d.getHeight();
                if (iArr[1] - this.a.getHeight() <= 50) {
                    ch.d(this.a, this.j.a.getPageActivity());
                    return;
                }
                ch.m(this.a, this.j.e, 0, (iArr[0] - (this.d.getWidth() / 2)) - this.j.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.d.getHeight() + height);
                PopupWindow popupWindow = this.a;
                if (popupWindow != null) {
                    popupWindow.update();
                }
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.c != null) {
                this.c.setText(this.j.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f126e, StringHelper.numberUniformFormatExtra(i)));
                this.b.setVisibility(0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
                if (view2 == this.d) {
                    h();
                } else if ((view2 instanceof TextView) && view2.getTag() != null && (view2.getTag() instanceof String) && !StringUtils.isNull((String) view2.getTag())) {
                    PopupWindow popupWindow = this.a;
                    if (popupWindow != null) {
                        ch.d(popupWindow, this.j.a.getPageActivity());
                    }
                    if (this.j.c != null) {
                        String str = (String) view2.getTag();
                        this.h = str;
                        if (str.contains("距离")) {
                            if (d()) {
                                tf.n().k(false, this.i);
                                return;
                            } else {
                                this.j.a.showToast(R.string.obfuscated_res_0x7f0f126b);
                                return;
                            }
                        }
                        cz5 cz5Var = new cz5();
                        cz5Var.a = this.h;
                        cz5Var.d = false;
                        this.j.c.b(cz5Var);
                        this.d.setText(this.h);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz5 a;

        public a(gz5 gz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.getPageActivity().finish();
            }
        }
    }

    public gz5(TbPageContext tbPageContext) {
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
        this.e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0670, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0112, (ViewGroup) null);
        this.f = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0913d5);
        View findViewById = this.e.findViewById(R.id.obfuscated_res_0x7f092060);
        this.g = findViewById;
        b bVar = new b(this, findViewById);
        this.r = bVar;
        bVar.g(8);
        this.h = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f0913bc);
        bz4 bz4Var = new bz4(this.a);
        this.i = bz4Var;
        bz4Var.b0(this.d);
        this.h.setPullRefresh(this.i);
        PbListView pbListView = new PbListView(this.a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        yy5 yy5Var = new yy5(this.a);
        this.p = yy5Var;
        yy5Var.v(2);
        zy5 zy5Var = new zy5(this.a);
        this.q = zy5Var;
        zy5Var.v(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.h.a(this.o);
    }

    public void l(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (bVar = this.r) != null) {
            bVar.i(i);
        }
    }

    public void m(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && !ListUtils.isEmpty(list)) {
            this.r.c(list);
        }
    }

    public void n(jz5 jz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jz5Var) == null) {
            this.c = jz5Var;
            yy5 yy5Var = this.p;
            if (yy5Var != null) {
                yy5Var.w(jz5Var);
            }
            zy5 zy5Var = this.q;
            if (zy5Var != null) {
                zy5Var.w(this.c);
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f.setVisibility(i);
        }
    }

    public void p(List<xn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && list != null && !ListUtils.isEmpty(list) && (bdTypeListView = this.h) != null) {
            bdTypeListView.setData(list);
        }
    }

    public void q(az4.g gVar) {
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

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.z();
        }
    }

    public BdTypeListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void g() {
        ka5 ka5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ka5Var = this.l) != null) {
            ka5Var.dettachView(this.e);
            this.l = null;
        }
    }

    public void h() {
        la5 la5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (la5Var = this.n) != null) {
            la5Var.dettachView(this.e);
            this.n = null;
        }
    }

    public void i() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pbListView = this.m) != null && pbListView.c().getParent() != null) {
            this.h.removeFooterView(this.m.c());
        }
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
            ka5 ka5Var = this.l;
            if (ka5Var != null) {
                ka5Var.onChangeSkinType();
            }
            NavigationBar navigationBar = this.j;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.e(i);
            }
            la5 la5Var = this.n;
            if (la5Var != null) {
                la5Var.onChangeSkinType();
            }
            SkinManager.setBackgroundResource(this.e, R.color.CAM_X0201);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ka5 ka5Var = this.l;
            if (ka5Var != null) {
                if (ka5Var.j() != null) {
                    this.l.dettachView(this.e);
                }
                this.l.n();
                this.l = null;
            }
            bz4 bz4Var = this.i;
            if (bz4Var != null) {
                bz4Var.f(null);
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
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (tbPageContext = this.a) != null && this.e != null) {
            if (this.l == null) {
                this.l = new ka5(tbPageContext.getPageActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
            }
            ka5 ka5Var = this.l;
            if (ka5Var != null) {
                ka5Var.attachView(this.e, true);
            }
        }
    }

    public void v() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (pbListView = this.m) != null) {
            if (pbListView.c().getParent() == null) {
                this.h.setNextPage(this.m);
            }
            this.m.F(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a7d));
            this.m.g();
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, str, onClickListener, z) == null) {
            if (this.n == null) {
                this.n = new la5(this.a.getPageActivity(), onClickListener);
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
}
