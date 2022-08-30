package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.dv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class dv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hv5 A;
    public tu5 B;
    public lm6 C;
    public NavigationBar D;
    public TbPageContext a;
    public int b;
    public ev5 c;
    public boolean d;
    public BdUniqueId e;
    public View f;
    public View g;
    public TextView h;
    public TextView i;
    public BdTypeMultiColumnListView j;
    public PopupWindow k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public String p;
    public boolean q;
    public ev4 r;
    public PbListView s;
    public NoNetworkView t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public a(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.a.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public b(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public c(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.C.b(view2, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public d(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public e(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s(2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public f(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;

        public g(dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12573").param("fid", this.a.p));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(this.a.a.getPageActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdMultiColumnListView.OnScrollToBottomListener a;

        public h(dv5 dv5Var, BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv5Var, onScrollToBottomListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onScrollToBottomListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onScrollToBottomListener = this.a) == null) {
                return;
            }
            onScrollToBottomListener.onScrollToBottom();
        }
    }

    public dv5(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), bdUniqueId, str, Boolean.valueOf(z2)};
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
        this.q = false;
        this.a = tbPageContext;
        this.d = z;
        this.e = bdUniqueId;
        this.p = str;
        this.q = z2;
    }

    public void A() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.j.setNextPage(this.s);
        }
        this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a3d));
        this.s.f();
    }

    public void B() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.j.setNextPage(this.s);
        }
        this.s.O();
        this.s.Q();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.A == null) {
                hv5 hv5Var = new hv5(this.a.getPageActivity());
                this.A = hv5Var;
                hv5Var.a();
                this.A.e(new g(this));
            }
            if (this.A.b().getParent() == null) {
                this.j.setNextPage(this.A);
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            SkinManager.setBackgroundResource(this.l, R.drawable.bg_ala_frs_game_live_sort_panel);
            SkinManager.setBackgroundResource(this.m, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0106);
            int[] iArr = new int[2];
            this.i.getLocationOnScreen(iArr);
            int height = ((View) this.i.getParent()).getHeight() - this.i.getHeight();
            if (iArr[1] - this.k.getHeight() <= 50) {
                ug.d(this.k, this.a.getPageActivity());
                return;
            }
            ug.m(this.k, this.f, 0, (iArr[0] - (this.i.getWidth() / 2)) - this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.i.getHeight() + height);
            this.k.update();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.completePullRefresh();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.j != null && pi.z()) {
            this.j.startPullRefresh();
        }
    }

    public BdTypeMultiColumnListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (BdTypeMultiColumnListView) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (NavigationBar) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.u == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f0, (ViewGroup) null);
                this.u = inflate;
                this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b0e);
                this.w = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090b0f);
                this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090b10);
                this.y = this.u.findViewById(R.id.obfuscated_res_0x7f090b11);
                this.z = this.u.findViewById(R.id.obfuscated_res_0x7f090b12);
            }
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.l == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f2, (ViewGroup) null);
                this.l = inflate;
                this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b0b);
                this.n = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f090b0c);
                this.o = this.l.findViewById(R.id.obfuscated_res_0x7f090b14);
                this.m.setOnClickListener(new d(this));
                this.n.setOnClickListener(new e(this));
            }
            if (this.k == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.k = popupWindow;
                popupWindow.setContentView(this.l);
                this.k.setWidth(-2);
                this.k.setHeight(-2);
                this.k.setAnimationStyle(16973826);
                this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f98));
                this.k.setOutsideTouchable(true);
                this.k.setFocusable(true);
                this.k.setTouchable(true);
                this.k.setOnDismissListener(new f(this));
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f7, (ViewGroup) null);
            this.f = inflate;
            if (this.q) {
                NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f092566);
                this.D = navigationBar;
                navigationBar.setVisibility(0);
                this.D.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
                this.D.showBottomLine(true);
                this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            this.g = this.f.findViewById(R.id.obfuscated_res_0x7f090b15);
            this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090b0d);
            this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090b13);
            BdTypeMultiColumnListView bdTypeMultiColumnListView = (BdTypeMultiColumnListView) this.f.findViewById(R.id.obfuscated_res_0x7f09130c);
            this.j = bdTypeMultiColumnListView;
            bdTypeMultiColumnListView.setColumnDiv((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be));
            this.t = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f092485);
            ev4 ev4Var = new ev4(this.a);
            this.r = ev4Var;
            ev4Var.b0(this.e);
            this.j.setPullRefresh(this.r);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.s = pbListView;
            pbListView.a();
            this.B = new tu5(this.a, this.j);
            this.i.setOnClickListener(new b(this));
            if (this.d) {
                this.C = new lm6(this.a.getPageActivity(), this.e, this.d);
                this.j.setOnTouchListener(new c(this));
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (this.b != i) {
                this.b = i;
            }
            NavigationBar navigationBar = this.D;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            NavigationBar navigationBar2 = this.D;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.a, i);
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            this.j.setContentBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            D();
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            u(i);
            ug.d(this.k, this.a.getPageActivity());
            ev5 ev5Var = this.c;
            if (ev5Var != null) {
                ev5Var.a(i);
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || this.h == null) {
            return;
        }
        this.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06f1, StringHelper.numberUniformFormatExtra(i)));
        if (i <= 1) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
    }

    public void u(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 1) {
                TextView textView2 = this.i;
                if (textView2 != null) {
                    textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f06f5));
                }
            } else if (i != 2 || (textView = this.i) == null) {
            } else {
                textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f06f6));
            }
        }
    }

    public void v(mq5 mq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mq5Var) == null) {
            this.B.b(mq5Var);
        }
    }

    public void w(List<pn> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            if (z2) {
                m();
                this.g.setVisibility(8);
                View view2 = this.u;
                if (view2 != null) {
                    this.j.removeHeaderView(view2);
                    this.j.addHeaderView(this.u);
                }
                this.B.c(list);
                this.j.setNextPage(null);
                return;
            }
            View view3 = this.u;
            if (view3 != null) {
                this.j.removeHeaderView(view3);
            }
            if (list.size() == 0) {
                this.g.setVisibility(8);
                this.B.c(list);
                this.j.setNextPage(null);
                return;
            }
            this.g.setVisibility(0);
            this.B.c(list);
            if (z) {
                A();
            } else {
                C();
            }
        }
    }

    public void x(ev5 ev5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, ev5Var) == null) {
            this.c = ev5Var;
        }
    }

    public void y(dv4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.r.f(gVar);
        }
    }

    public void z(BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onScrollToBottomListener) == null) {
            this.j.setOnSrollToBottomListener(onScrollToBottomListener);
            this.s.B(new h(this, onScrollToBottomListener));
        }
    }
}
