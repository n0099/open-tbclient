package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.InvateAnswerSettingActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.p05;
import com.baidu.tieba.t9b;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class es4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n05 A;
    public boolean B;
    public View C;
    public boolean D;
    public int E;
    public zr4 F;
    public BaseWebViewActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public TextView d;
    public ImageView e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public LinearLayout l;
    public TextView m;
    public LinearLayout n;
    public ContinuousAnimationView o;
    public ProgressBar p;
    public NoDataView q;
    public View.OnClickListener r;
    public View s;
    public FrameLayout t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public h7a z;

    /* loaded from: classes5.dex */
    public class a implements t9b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public a(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.t9b.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.z == null) {
                return;
            }
            this.a.z.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public b(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_HELP).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                BrowserHelper.startWebActivity((Context) this.a.a, "", BdUtilHelper.urlAddParam(TbConfig.QUESTION_THREAD_RULE, "refer=1"), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public c(es4 es4Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                new BdTopToast(currentActivity).setIcon(this.a).setContent(this.b).show((ViewGroup) currentActivity.findViewById(16908290));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public d(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                if (((this.a.a instanceof BaseWebViewActivity) && this.a.a.isDisableGoBack && this.a.a.needDealClickGoBack()) || this.a.a.webViewGoBack()) {
                    return;
                }
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public e(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public f(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.y) {
                    new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_MORE).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InvateAnswerSettingActivityConfig(this.a.a)));
                } else if (this.a.j()) {
                    this.a.N();
                } else if (this.a.k.getVisibility() != 0) {
                    this.a.Q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements p05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public g(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.p05.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.A == null) {
                return;
            }
            this.a.A.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public h(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.A != null && this.a.a != null) {
                this.a.A.dismiss();
                this.a.a.shareFriend();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public i(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.A != null && this.a.a != null) {
                this.a.A.dismiss();
                this.a.a.copyLink();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements p05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public j(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.p05.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.A != null && this.a.a != null) {
                this.a.A.dismiss();
                this.a.a.openInBrowser();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements t9b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;

        public k(es4 es4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es4Var;
        }

        @Override // com.baidu.tieba.t9b.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z != null && this.a.a != null) {
                this.a.z.dismiss();
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.a).createNormalCfg(this.a.a.getResources().getString(R.string.user_feedback), null);
                createNormalCfg.setCallFrom(12);
                this.a.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public es4(BaseWebViewActivity baseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.u = true;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = false;
        this.B = false;
        this.D = true;
        this.E = 0;
        this.a = baseWebViewActivity;
        p();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.x = z;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.E = i2;
        }
    }

    public void C(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (view2 = this.s) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.l.getLayoutParams().height = -1;
                this.c.setVisibility(0);
                return;
            }
            this.l.getLayoutParams().height = -1;
            this.c.setVisibility(8);
        }
    }

    public void E(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.c != null && (imageView = this.j) != null) {
            imageView.setVisibility(i2);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.D = z;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.u != z) {
            this.u = z;
            this.A = null;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
        }
    }

    public void o(String str) {
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, str) == null) && (zr4Var = this.F) != null) {
            zr4Var.e(str);
        }
    }

    public void w(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (view2 = this.h) != null) {
            if (z) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.y = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.w = z;
        }
    }

    public void F() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.c != null && (imageView = this.j) != null && this.k != null) {
            imageView.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setOnClickListener(this.a);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.B = true;
            L();
        }
    }

    public void O() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (navigationBar = this.c) != null && navigationBar.getVisibility() == 0 && (imageView = this.i) != null) {
            imageView.setVisibility(8);
        }
    }

    public void h() {
        n05 n05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (n05Var = this.A) != null) {
            n05Var.cancel();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.m.setVisibility(8);
        }
    }

    public void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (noDataView = this.q) != null) {
            noDataView.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null && navigationBar.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            h();
            zr4 zr4Var = this.F;
            if (zr4Var != null) {
                zr4Var.j();
            }
        }
    }

    public void G(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                this.d = navigationBar.setCenterTextTitle(str);
                ImageView imageView2 = this.g;
                if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.i) != null && imageView.getVisibility() == 0) {
                    this.d.setMaxWidth(BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070377) * 2);
                }
                if (!this.B) {
                    SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
                } else {
                    this.d.setTextColor(-1);
                }
                if (this.x) {
                    ImageView imageView3 = (ImageView) this.c.getCenterImgBox();
                    this.e = imageView3;
                    imageView3.setOnClickListener(new b(this));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                    layoutParams.rightMargin = BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.M_W_X002);
                    this.d.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                    layoutParams2.height = BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds42);
                    layoutParams2.width = BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds42);
                    this.e.setLayoutParams(layoutParams2);
                    this.e.setVisibility(0);
                }
            }
            zr4 zr4Var = this.F;
            if (zr4Var != null) {
                zr4Var.g();
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            ContinuousAnimationView continuousAnimationView = this.o;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            }
            FrameLayout frameLayout = this.t;
            if (frameLayout != null) {
                if (this.E == 1) {
                    SkinManager.setBackgroundColor(frameLayout, R.color.black_alpha4);
                } else {
                    SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0202);
                }
                this.t.setVisibility(8);
            }
            NoDataView noDataView = this.q;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            if (!this.B) {
                NavigationBar navigationBar = this.c;
                if (navigationBar != null) {
                    navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            zr4 zr4Var = this.F;
            if (zr4Var != null) {
                zr4Var.f(i2);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.title_help_icon, R.color.CAM_X0105, null);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null && this.j != null && this.k != null) {
                navigationBar.setBackgroundDrawable(null);
                this.c.setBackgroundColor(R.color.transparent);
                this.c.setBackgroundResource(R.drawable.transparent_bg);
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setOnClickListener(this.a);
                this.d.setTextColor(-1);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                layoutParams.width = BdUtilHelper.getDimens(this.a, R.dimen.tbds100);
                layoutParams.height = BdUtilHelper.getDimens(this.a, R.dimen.tbds100);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.z == null) {
                t9b t9bVar = new t9b(this.a);
                ArrayList arrayList = new ArrayList();
                t9b.b bVar = new t9b.b(this.a.getString(R.string.report_text), t9bVar);
                bVar.h(new k(this));
                arrayList.add(bVar);
                t9bVar.h(new a(this));
                t9bVar.g(arrayList);
                h7a h7aVar = new h7a(this.a, t9bVar.b());
                this.z = h7aVar;
                h7aVar.a(0.7f);
            }
            this.z.show();
        }
    }

    public final ProgressBar i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.p == null) {
                ProgressBar progressBar = new ProgressBar(this.a.getActivity(), null, 16842871);
                this.p = progressBar;
                progressBar.setIndeterminateDrawable(ResourcesCompat.getDrawable(this.a.getActivity().getResources(), R.drawable.obfuscated_res_0x7f0812ca, null));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.p.setLayoutParams(layoutParams);
                this.t.addView(this.p);
            }
            return this.p;
        }
        return (ProgressBar) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.l.setLayoutParams(layoutParams);
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.i;
            if (imageView2 != null) {
                imageView2.setBackgroundDrawable(null);
            }
            ImageView imageView3 = this.j;
            if (imageView3 != null) {
                imageView3.setBackgroundDrawable(null);
            }
            ImageView imageView4 = this.k;
            if (imageView4 != null) {
                imageView4.setBackgroundDrawable(null);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.showBottomLine(true);
            }
            BaseWebViewActivity baseWebViewActivity = this.a;
            if (baseWebViewActivity != null) {
                baseWebViewActivity.getWindow().clearFlags(1024);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.l.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.i, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.j, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.k, R.drawable.frs_star_navigation_bg);
            G("");
            this.a.getWindow().setFlags(1024, 1024);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.q == null) {
                this.q = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.a.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1256), this.r)));
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.q.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.a.getPageContext());
            } else {
                this.q.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.a.getPageContext());
            }
            this.l.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.A == null) {
                p05 p05Var = new p05(this.a);
                p05Var.p(new g(this));
                ArrayList arrayList = new ArrayList();
                if (this.u) {
                    l05 l05Var = new l05(p05Var);
                    l05Var.p(this.a.getString(R.string.share_to_friebds));
                    l05Var.n(new h(this));
                    arrayList.add(l05Var);
                }
                l05 l05Var2 = new l05(p05Var);
                l05Var2.p(this.a.getString(R.string.copy_link));
                l05Var2.n(new i(this));
                arrayList.add(l05Var2);
                l05 l05Var3 = new l05(p05Var);
                l05Var3.p(this.a.getString(R.string.open_with_browser));
                l05Var3.n(new j(this));
                arrayList.add(l05Var3);
                p05Var.m(arrayList);
                this.A = new n05(this.a.getPageContext(), p05Var);
            }
            this.A.show();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress() && this.D) {
            this.t.setVisibility(0);
            if (this.E == 1) {
                this.p = i();
                this.n.setVisibility(8);
                this.p.setVisibility(0);
            } else {
                ProgressBar progressBar = this.p;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.n.setVisibility(0);
                this.o.playAnimation();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                SkinManager.setBackgroundResource(navigationBar.getBarBgView(), R.color.CAM_X0201);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void S(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, shareItem) != null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.linkUrl);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.isShowMoreForumIcon()) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.a, shareItem, true, k())));
    }

    public void T(boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) {
            SafeHandler.getInst().postDelayed(new c(this, z, str), i2);
        }
    }

    public final SparseArray<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.D) {
            this.n.setVisibility(8);
            this.o.cancelAnimation();
            ProgressBar progressBar = this.p;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.t.setVisibility(8);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                SkinManager.setBackgroundResource(navigationBar.getBarBgView(), R.color.common_color_10022);
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            try {
                this.l.addView(this.a.createWebView());
                this.m.setVisibility(8);
                if (!this.v) {
                    this.c.setStatusBarVisibility(8);
                    return true;
                }
                return true;
            } catch (Exception e2) {
                this.m.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.a.setContentView(R.layout.base_webview_activity_new);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f092083);
            this.c = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.C = this.a.findViewById(R.id.night_mode_overlay);
            this.t = (FrameLayout) this.b.findViewById(R.id.webview_progress_container);
            this.c.showBottomLine();
            G("");
            if (this.a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.b, this.a.getResources().getColor(R.color.black_alpha0));
                this.b.setOnClickListener(this.a);
                this.c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.webview_container);
            this.l = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.l.setLayoutParams(layoutParams);
            this.m = (TextView) this.a.findViewById(R.id.webview_crash_tip);
            this.o = (ContinuousAnimationView) this.a.findViewById(R.id.webview_progress);
            this.n = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092b0a);
            this.p = (ProgressBar) this.a.findViewById(R.id.webview_progress_bar);
            SkinManager.setLottieAnimation(this.o, R.raw.lottie_full_screen_refresh);
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new d(this));
            this.f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.g = imageView;
            imageView.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0314));
            View addCustomView2 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new e(this));
            this.h = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.widget_navi_back_button);
            this.i = imageView2;
            imageView2.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0480));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.leftMargin = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
            this.i.setLayoutParams(layoutParams2);
            View addCustomView3 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new f(this));
            this.s = addCustomView3;
            this.j = (ImageView) addCustomView3.findViewById(R.id.widget_navi_more_button);
            this.k = (ImageView) this.s.findViewById(R.id.widget_navi_share_button);
            zr4 zr4Var = new zr4(this.c, this.l);
            this.F = zr4Var;
            zr4Var.a(new yr4(this.g, R.drawable.ic_icon_pure_topbar_return40_svg), new yr4(this.i, R.drawable.icon_pure_topbar_close44_svg), new yr4(this.j, R.drawable.icon_pure_topbar_more44_svg), new yr4(this.k, R.drawable.icon_pure_topbar_share44_svg), new yr4(this.c.getCenterText(), 0));
        }
    }

    public void t(int i2, int i3, int i4, int i5) {
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048608, this, i2, i3, i4, i5) == null) && (zr4Var = this.F) != null) {
            zr4Var.h(i2, i3, i4, i5);
        }
    }
}
