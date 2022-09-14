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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TBSpecificationBtn B;
    public boolean C;
    public vu7 D;
    public String E;
    public TextView F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public Runnable I;
    public View.OnClickListener J;
    public final NavigationBar a;
    public boolean b;
    public TextView c;
    public View d;
    public ImageView e;
    public final View f;
    public final ImageView g;
    public final LinearLayout h;
    public LinearLayout i;
    public BarImageView j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public gy7 n;
    public float o;
    public PbFragment p;
    public Runnable q;
    public ImageView r;
    public boolean s;
    public PopupWindow t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        public a(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p.b6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a18 a18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof to8) && ((to8) customResponsedMessage.getData()).b) {
                this.a.C = true;
                a18 a18Var = this.a;
                a18Var.L(a18Var.C);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a18 a18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.A != null) {
                    if (!booleanValue || this.a.C) {
                        this.a.A.setVisibility(4);
                    } else {
                        this.a.A.setVisibility(0);
                        TbPageTag l = gc5.l(this.a.p.getContext());
                        if (this.a.D != null && l != null) {
                            v08.a("c14277", this.a.E, this.a.D.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    a18 a18Var = this.a;
                    a18Var.L(a18Var.C);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
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

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        public e(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ih.a(this.a.m, this.a.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        public f(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a18 a;

        public g(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
            }
        }
    }

    public a18(PbFragment pbFragment, View view2) {
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
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.C = false;
        this.G = new b(this, 2001437);
        this.H = new c(this, 2921599);
        this.I = new f(this);
        this.J = new g(this);
        this.p = pbFragment;
        this.u = ej.f(pbFragment.getContext(), R.dimen.tbds39);
        this.v = ej.f(pbFragment.getContext(), R.dimen.tbds54);
        this.w = ej.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f070306);
        this.x = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int k = ej.k(TbadkCoreApplication.getInst());
        int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070231) + ((int) (k * 0.07d));
        this.y = f3;
        if (f3 - f2 > 0) {
            this.y = f3 - f2;
        }
        this.z = (k - (this.y * 2)) - ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0925c2);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.f = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.h2);
        this.c = this.a.setCenterTextTitle("");
        this.g = (ImageView) this.a.getCenterImgBox();
        this.h = (LinearLayout) this.a.getCenterImgBoxLayout();
        int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.h.setPadding(f4, 0, f4, 0);
        SkinManager.setNavbarIconSrc(this.g, R.drawable.obfuscated_res_0x7f0808c7, R.drawable.obfuscated_res_0x7f0808c7);
        this.g.setVisibility(8);
        this.c.setOnClickListener(pbFragment.h2);
        this.g.setOnClickListener(pbFragment.h2);
        this.r = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09267d);
        if (this.i == null) {
            s();
        }
        t();
        pbFragment.registerListener(this.G);
        pbFragment.registerListener(this.H);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!this.b && z && !"".equals(this.c.getText().toString())) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            A(z);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !bx4.k().h("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0891, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0902c2);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092213);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = ej.f(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
                } else {
                    layoutParams.rightMargin = ej.f(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
                }
                textView.setText(R.string.obfuscated_res_0x7f0f117e);
                textView.setOnClickListener(this.J);
                this.t = new PopupWindow(inflate, -2, -2);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.r.setVisibility(0);
            A(z);
            if (TbadkCoreApplication.isLogin()) {
                View view2 = this.d;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.d;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public void F(hy7 hy7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, hy7Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new gy7(pbFragment, pbFragment.h2);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        ih.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = ej.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f7);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.y());
        window.setDimAmount(this.o);
        this.n.Q(hy7Var == null ? false : hy7Var.a);
        this.n.D(hy7Var == null ? false : hy7Var.n);
        this.n.F(hy7Var == null ? false : hy7Var.e);
        this.n.L(hy7Var == null ? false : hy7Var.i);
        this.n.G(hy7Var == null ? false : hy7Var.f);
        this.n.S(hy7Var != null ? hy7Var.c : true);
        this.n.P(hy7Var == null ? false : hy7Var.k);
        this.n.H(hy7Var == null ? false : hy7Var.l, hy7Var.t);
        if (hy7Var == null) {
            this.n.N(false, false);
            this.n.M(false, false);
        } else {
            this.n.N(hy7Var.g, hy7Var.s);
            this.n.M(hy7Var.h, hy7Var.r);
        }
        boolean z = hy7Var == null ? false : hy7Var.q;
        boolean z2 = hy7Var == null ? false : hy7Var.o;
        boolean z3 = hy7Var == null ? false : hy7Var.d;
        boolean z4 = hy7Var == null ? false : hy7Var.b;
        boolean z5 = hy7Var == null ? false : hy7Var.p;
        boolean z6 = hy7Var == null ? false : hy7Var.j;
        boolean z7 = hy7Var == null ? false : hy7Var.m;
        this.n.I(z3, z2);
        this.n.R(z4, z);
        this.n.O(z6, z5);
        this.n.U(z7);
        if (hy7Var != null) {
            gy7 gy7Var = this.n;
            boolean z8 = hy7Var.u;
            gy7Var.w = z8;
            if (z8) {
                gy7Var.m().setText(R.string.obfuscated_res_0x7f0f1016);
                this.n.G(false);
            }
        }
        this.n.E(hy7Var == null ? false : hy7Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.K() != null && this.p.K().S1() != null && this.p.K().S1().Q() != null && this.p.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.k().setText(R.string.obfuscated_res_0x7f0f084b);
        }
        N();
        this.n.V(hy7Var != null ? hy7Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03d7, UtilHelper.getFixedBarText(str, 7, false)));
                A(true);
                up4.c().h(str);
                return;
            }
            A(false);
        }
    }

    public void H(boolean z, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, spannableStringBuilder) == null) {
            this.F.setText(spannableStringBuilder);
            if (z) {
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(8);
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(0);
                return;
            }
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(0);
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(8);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.b = z;
            if (this.d == null && this.e == null) {
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.obfuscated_res_0x7f0d062e, this.p.h2);
                this.d = addCustomView;
                this.e = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09164d);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.v + this.u, this.w);
                layoutParams.rightMargin = this.x;
                this.d.setPadding(0, 0, this.u, 0);
                this.d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void J(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (view2 = this.d) == null) {
            return;
        }
        view2.setVisibility(z ? 0 : 8);
    }

    public void K() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (view2 = this.d) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void L(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (tBSpecificationBtn = this.B) == null) {
            return;
        }
        if (z) {
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0659));
            ((ay4) this.B.getStyleConfig()).t(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02b0));
    }

    public void M(vu7 vu7Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{vu7Var, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.i == null) {
            return;
        }
        this.D = vu7Var;
        this.E = str2;
        if (StringUtils.isNull(str)) {
            this.j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.obfuscated_res_0x7f0f066e, R.dimen.tbds0, 1, this.z, false);
            up4.c().h(str);
            this.j.K(str3, 10, false);
        }
        View view2 = this.A;
        if (view2 != null && this.D != null) {
            view2.setTag(R.id.obfuscated_res_0x7f090a8e, str);
            this.A.setTag(R.id.obfuscated_res_0x7f090a79, str2);
            this.A.setTag(R.id.obfuscated_res_0x7f09218e, this.D.Q());
            this.C = z;
        }
        z();
    }

    public final void N() {
        gy7 gy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gy7Var = this.n) == null) {
            return;
        }
        gy7Var.C();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ih.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            gh.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ih.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.A : (View) invokeV.objValue;
    }

    public gy7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.n : (gy7) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.I != null) {
                gh.a().removeCallbacks(this.I);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.r.setVisibility(0);
            A(false);
            View view2 = this.d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d0629, (View.OnClickListener) null);
            this.i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091859);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.h2);
            TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09185a);
            this.k = textView;
            textView.setOnClickListener(this.p.h2);
            if (this.i.getLayoutParams() != null && (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.y > 0 && this.z > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                int i = this.y;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
                this.i.setLayoutParams(marginLayoutParams);
            }
            if (this.i.getVisibility() == 8) {
                this.i.setVisibility(0);
            }
            if (this.i.getAlpha() != 1.0f) {
                this.i.setAlpha(1.0f);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.F == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.F = textView;
            textView.setSingleLine();
            this.F.setEllipsize(TextUtils.TruncateAt.END);
            this.F.setIncludeFontPadding(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708f2), -2);
            layoutParams.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X001), 0, 0, 0);
            this.F.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.F, (View.OnClickListener) null);
            uu4 d2 = uu4.d(this.F);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AlertDialog alertDialog = this.m;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a1e, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a1a, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            TextView textView = this.F;
            if (textView != null) {
                uu4 d2 = uu4.d(textView);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X05);
            }
            z();
            N();
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.a.onChangeSkinType(this.p.getPageContext(), i);
            this.a.getBackground().mutate().setAlpha(0);
            this.a.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802ca);
            this.a.getTopCoverBgView().setVisibility(0);
            this.a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a1a, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a1e, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view2) == null) {
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            gy7 gy7Var = this.n;
            if (gy7Var != null) {
                gy7Var.B();
            }
            this.m = null;
            this.n = null;
            gh.a().removeCallbacks(this.q);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            uu4 d2 = uu4.d(this.i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.i.setBackgroundResource(0);
    }
}
