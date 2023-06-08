package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ga9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public TextView E;
    public float F;
    public int G;
    public m39 H;
    public og<gn> I;
    public Runnable J;
    public View.OnClickListener K;
    public final NavigationBar a;
    public boolean b;
    public final int c;
    public final int d;
    public TextView e;
    public View f;
    public ImageView g;
    public final View h;
    public final ImageView i;
    public final LinearLayout j;
    public LinearLayout k;
    public BarImageView l;
    public EMTextView m;
    public ImageView n;
    public String o;
    public AlertDialog p;
    public d79 q;
    public float r;
    public PbFragment s;
    public Runnable t;
    public ImageView u;
    public boolean v;
    public PopupWindow w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;

        public a(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s.U5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;

        public c(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!yg.a(this.a.p, this.a.s.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends og<gn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;

        public d(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        public void onLoaded(gn gnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, gnVar, str, i) == null) {
                if (gnVar != null && gnVar.j() != null) {
                    this.a.a.setBackground(gnVar.j());
                    return;
                }
                SkinManager.setBackgroundColor(this.a.a.getBarBgView(), R.color.CAM_X0208);
                this.a.a.setBackground(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;

        public e(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga9 a;

        public f(ga9 ga9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    public ga9(PbFragment pbFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds200);
        this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.p = null;
        this.q = null;
        this.r = 0.33f;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = true;
        this.I = new d(this);
        this.J = new e(this);
        this.K = new f(this);
        this.s = pbFragment;
        this.x = vi.g(pbFragment.getContext(), R.dimen.tbds39);
        this.y = vi.g(pbFragment.getContext(), R.dimen.tbds54);
        this.z = vi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f07041a);
        this.A = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        int l = vi.l(TbadkCoreApplication.getInst());
        int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070354) + ((int) (l * 0.07d));
        this.B = g2;
        if (g2 - g > 0) {
            this.B = g2 - g;
        }
        this.C = (l - (this.B * 2)) - vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.h = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.i2);
        this.e = this.a.setCenterTextTitle("");
        this.i = (ImageView) this.a.getCenterImgBox();
        this.j = (LinearLayout) this.a.getCenterImgBoxLayout();
        int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.j.setPadding(g3, 0, g3, 0);
        SkinManager.setNavbarIconSrc(this.i, R.drawable.obfuscated_res_0x7f080a8c, R.drawable.obfuscated_res_0x7f080a8c);
        this.i.setVisibility(8);
        this.e.setOnClickListener(pbFragment.i2);
        this.i.setOnClickListener(pbFragment.i2);
        this.u = (ImageView) this.h.findViewById(R.id.widget_navi_back_button);
        if (this.k == null) {
            l();
        }
        m();
    }

    public void B(boolean z) {
        View view2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (view2 = this.f) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.v = z;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            t(z);
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.b = z;
            if (this.f == null && this.g == null) {
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.s.i2);
                this.f = addCustomView;
                this.g = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.y + this.x, this.z);
                layoutParams.rightMargin = this.A;
                int i = 0;
                this.f.setPadding(0, 0, this.x, 0);
                this.f.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                View view2 = this.f;
                if (!TbadkCoreApplication.isLogin()) {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.s.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.l;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL_PRESS));
            TextView textView = this.E;
            if (textView != null) {
                o75 d2 = o75.d(textView);
                d2.w(R.color.CAM_X0105);
                d2.B(R.dimen.T_X05);
            }
            s();
            E();
            G();
        }
    }

    public void C() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (view2 = this.f) != null) {
            view2.setVisibility(8);
        }
    }

    public final void E() {
        d79 d79Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (d79Var = this.q) == null) {
            return;
        }
        d79Var.Q();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            yg.c(this.w);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.t == null) {
                this.t = new c(this);
            }
            wg.a().postDelayed(this.t, 100L);
        }
    }

    public d79 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.q;
        }
        return (d79) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.J != null) {
                wg.a().removeCallbacks(this.J);
            }
            e();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AlertDialog alertDialog = this.p;
            if (alertDialog != null && alertDialog.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d79 d79Var = this.q;
            if (d79Var != null) {
                d79Var.P();
            }
            this.p = null;
            this.q = null;
            wg.a().removeCallbacks(this.t);
        }
    }

    public void D(m39 m39Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{m39Var, str, str2, str3, Boolean.valueOf(z)}) == null) && this.s != null && this.k != null) {
            this.H = m39Var;
            if (StringUtils.isNull(str)) {
                this.l.setVisibility(8);
                this.m.setText(R.string.obfuscated_res_0x7f0f0f8d);
                this.o = null;
            } else {
                this.l.setVisibility(0);
                this.o = str;
                if (this.C < 0) {
                    this.C = vi.w(this.m.getPaint(), str);
                }
                ThreadCardUtils.cutAndSetTextByMaxLine(this.m, str, R.string.obfuscated_res_0x7f0f0766, R.dimen.tbds0, 1, this.C, false);
                n05.c().h(str);
                this.l.N(str3, 10, false);
            }
            s();
        }
    }

    public final void F(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048581, this, absListView, i, i2, i3) != null) || !o()) {
            return;
        }
        View childAt = absListView.getChildAt(0);
        int firstVisiblePosition = (-childAt.getTop()) + (absListView.getFirstVisiblePosition() * childAt.getHeight());
        if (Math.abs(firstVisiblePosition - this.G) > this.d) {
            int i4 = this.c;
            if (firstVisiblePosition < i4) {
                this.F = (firstVisiblePosition * 1.0f) / i4;
            } else {
                this.F = 1.0f;
            }
        }
        this.G = firstVisiblePosition;
        if (this.a.getBarBgView().getAlpha() != this.F) {
            this.a.getBarBgView().setAlpha(this.F);
        }
    }

    public final void G() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (navigationBar = this.a) != null && navigationBar.getBarBgView() != null) {
            if (o()) {
                l45 taskInfoData = this.H.N().getTaskInfoData();
                this.a.getBarBgView().setBackgroundColor(ow9.f(taskInfoData.i()));
                pg.h().m(taskInfoData.o(), 10, this.I, this.s.getPageContext().getUniqueId());
                return;
            }
            SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            this.a.setBackground(null);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.E == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.E = textView;
            textView.setSingleLine();
            this.E.setEllipsize(TextUtils.TruncateAt.END);
            this.E.setIncludeFontPadding(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X001);
            layoutParams.setMargins(g, 0, g, 0);
            this.E.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.E, (View.OnClickListener) null);
            o75 d2 = o75.d(this.E);
            d2.w(R.color.CAM_X0105);
            d2.B(R.dimen.T_X05);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if ((this.v && !TbadkCoreApplication.isLogin()) || n95.m().i("show_share", false)) {
                return;
            }
            View inflate = LayoutInflater.from(this.s.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924a0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = vi.g(this.s.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
            } else {
                layoutParams.rightMargin = vi.g(this.s.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.K);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
            this.w = popupWindow;
            GreyUtil.grey(popupWindow);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.E != null && this.a != null) {
            int l = vi.l(TbadkCoreApplication.getInst());
            ViewGroup viewGroup = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            ViewGroup viewGroup2 = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                l -= viewGroup.getMeasuredWidth();
            }
            if (viewGroup2 != null && viewGroup2.getVisibility() == 0) {
                l -= viewGroup2.getMeasuredWidth();
            }
            this.E.setWidth(l);
        }
    }

    public void h() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (pbFragment = this.s) != null && pbFragment.Q() != null && this.D) {
            this.D = false;
            StatisticItem statisticItem = new StatisticItem("c13400");
            statisticItem.param("tid", this.s.Q().R1());
            statisticItem.param("fid", this.s.Q().getForumId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            m39 m39Var = this.H;
            if (m39Var == null || m39Var.N() == null || this.H.N().getTaskInfoData() == null) {
                return false;
            }
            l45 taskInfoData = this.H.N().getTaskInfoData();
            if (TextUtils.isEmpty(taskInfoData.i()) || TextUtils.isEmpty(taskInfoData.o())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.k == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.o)) {
            if (UbsABTestHelper.isPbEnterForum()) {
                o75 d2 = o75.d(this.k);
                d2.o(R.string.J_X07);
                d2.h(ow9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
                return;
            }
            o75 d3 = o75.d(this.k);
            d3.o(R.string.J_X07);
            d3.f(R.color.CAM_X0209);
            return;
        }
        this.k.setBackgroundResource(0);
    }

    public void g() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (alertDialog = this.p) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!yg.a(alertDialog, this.s.getPageContext().getPageActivity()))));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d06b5, (View.OnClickListener) null);
            this.k = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a6e);
            this.l = barImageView;
            barImageView.setShowOval(true);
            this.l.setShowOuterBorder(false);
            this.l.setShowInnerBorder(true);
            this.l.setStrokeWith(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.l.setStrokeColorResId(R.color.CAM_X0401);
            this.n = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f091abd);
            this.m = (EMTextView) this.k.findViewById(R.id.obfuscated_res_0x7f091a6f);
            this.k.setOnClickListener(this.s.i2);
            if (this.k.getLayoutParams() != null && (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.B > 0 && this.C > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
                int i = this.B;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
                this.k.setLayoutParams(marginLayoutParams);
            }
            if (this.k.getVisibility() == 8) {
                this.k.setVisibility(0);
            }
            if (this.k.getAlpha() != 1.0f) {
                this.k.setAlpha(1.0f);
            }
            if (UbsABTestHelper.isPbEnterForum()) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
        }
    }

    public void q(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048596, this, absListView, i, i2, i3) == null) {
            F(absListView, i, i2, i3);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (!this.b && z && !"".equals(this.e.getText().toString())) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    public void x(e79 e79Var) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, e79Var) != null) || this.s.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.s;
        this.q = new d79(pbFragment, pbFragment.i2);
        AlertDialog create = new AlertDialog.Builder(this.s.getContext(), R.style.obfuscated_res_0x7f10010c).create();
        this.p = create;
        GreyUtil.grey(create);
        boolean z17 = true;
        this.p.setCanceledOnTouchOutside(true);
        this.p.setOnDismissListener(new b(this));
        yg.i(this.p, this.s.getFragmentActivity());
        Window window = this.p.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = vi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f100419);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.q.M());
        window.setDimAmount(this.r);
        d79 d79Var = this.q;
        boolean z18 = false;
        if (e79Var == null) {
            z = false;
        } else {
            z = e79Var.a;
        }
        d79Var.d0(z);
        d79 d79Var2 = this.q;
        if (e79Var == null) {
            z2 = false;
        } else {
            z2 = e79Var.n;
        }
        d79Var2.R(z2);
        d79 d79Var3 = this.q;
        if (e79Var == null) {
            z3 = false;
        } else {
            z3 = e79Var.e;
        }
        d79Var3.T(z3);
        d79 d79Var4 = this.q;
        if (e79Var == null) {
            z4 = false;
        } else {
            z4 = e79Var.i;
        }
        d79Var4.Y(z4);
        d79 d79Var5 = this.q;
        if (e79Var == null) {
            z5 = false;
        } else {
            z5 = e79Var.f;
        }
        d79Var5.U(z5);
        d79 d79Var6 = this.q;
        if (e79Var != null) {
            z17 = e79Var.c;
        }
        d79Var6.f0(z17);
        d79 d79Var7 = this.q;
        if (e79Var == null) {
            z6 = false;
        } else {
            z6 = e79Var.k;
        }
        d79Var7.c0(z6);
        d79 d79Var8 = this.q;
        if (e79Var == null) {
            z7 = false;
        } else {
            z7 = e79Var.l;
        }
        if (e79Var != null) {
            z8 = e79Var.t;
        } else {
            z8 = false;
        }
        d79Var8.V(z7, z8);
        if (e79Var == null) {
            this.q.a0(false, false);
            this.q.Z(false, false);
        } else {
            this.q.a0(e79Var.g, e79Var.s);
            this.q.Z(e79Var.h, e79Var.r);
        }
        if (e79Var == null) {
            z9 = false;
        } else {
            z9 = e79Var.q;
        }
        if (e79Var == null) {
            z10 = false;
        } else {
            z10 = e79Var.o;
        }
        if (e79Var == null) {
            z11 = false;
        } else {
            z11 = e79Var.d;
        }
        if (e79Var == null) {
            z12 = false;
        } else {
            z12 = e79Var.b;
        }
        if (e79Var == null) {
            z13 = false;
        } else {
            z13 = e79Var.p;
        }
        if (e79Var == null) {
            z14 = false;
        } else {
            z14 = e79Var.j;
        }
        if (e79Var == null) {
            z15 = false;
        } else {
            z15 = e79Var.m;
        }
        this.q.W(z11, z10);
        this.q.e0(z12, z9);
        this.q.b0(z14, z13);
        this.q.i0(z15);
        if (e79Var != null) {
            d79 d79Var9 = this.q;
            boolean z19 = e79Var.u;
            d79Var9.A = z19;
            if (z19) {
                d79Var9.z().setText(R.string.report_text);
                this.q.U(false);
            }
        }
        d79 d79Var10 = this.q;
        if (e79Var == null) {
            z16 = false;
        } else {
            z16 = e79Var.v;
        }
        d79Var10.S(z16);
        if (!TbSingleton.getInstance().mCanCallFans && this.s.Q() != null && this.s.Q().y1() != null && this.s.Q().y1().P() != null && this.s.Q().y1().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.q.x().setText(R.string.have_called_fans_short);
        }
        E();
        d79 d79Var11 = this.q;
        if (e79Var != null) {
            z18 = e79Var.w;
        }
        d79Var11.j0(z18);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.e.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                t(true);
                n05.c().h(str);
                return;
            }
            t(false);
        }
    }

    public void z(boolean z, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048605, this, z, spannableStringBuilder) == null) {
            d();
            this.E.setText(spannableStringBuilder);
            if (z) {
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(8);
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(0);
                return;
            }
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(0);
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(8);
        }
    }
}
