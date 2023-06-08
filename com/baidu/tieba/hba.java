package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes6.dex */
public class hba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public NavigationBar b;
    public RelativeLayout c;
    public SimpleDraweeView d;
    public ImageView e;
    public RelativeLayout f;
    public ImageView g;
    public ImageView h;
    public PermissionJudgePolicy i;
    public View j;
    public ImageView k;
    public PopupWindow l;
    public boolean m;
    public Handler n;
    public int o;
    public TbPageContext p;
    public int q;
    public String r;
    public UserData s;
    public boolean t;
    public Runnable u;
    public Runnable v;

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hba a;

        /* loaded from: classes6.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TiebaStatic.log(new StatisticItem("c12706"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.a.a.a)));
                }
            }
        }

        public c(hba hbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(this.a.a instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) this.a.a;
            if (this.a.i == null) {
                this.a.i = new PermissionJudgePolicy();
            }
            this.a.i.clearRequestPermissionList();
            this.a.i.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            this.a.i.setOnPermissionsGrantedListener(new a(this));
            this.a.i.startRequestPermission(activity);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hba a;

        public a(hba hbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 22));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "1"));
                }
                this.a.x(6, false);
                if (this.a.q > 0 && this.a.s != null && !StringUtils.isNull(this.a.s.getUserId())) {
                    n95 m = n95.m();
                    m.z("key_record_bubble_info_id_" + this.a.s.getUserId(), this.a.q);
                }
                PersonRedTipManager.getInstance().updateRedTipState(6, false, true);
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.a.p;
                urlManager.dealOneLink(tbPageContext, new String[]{TbConfig.URL_THEME_CENTER + SkinManager.getCurrentSkinTypeString()}, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hba a;

        public b(hba hbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o == 1) {
                    TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 23));
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                }
                this.a.x(5, false);
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
                this.a.x(5, false);
                PersonRedTipManager.getInstance().updateRedTipState(5, false, true);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view2.getContext())));
                    return;
                }
                BdToast.b(this.a.a, this.a.a.getResources().getString(R.string.plugin_video_installing)).o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hba a;

        public d(hba hbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hbaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (imageView = this.a.g) == null) {
                return;
            }
            yg.k(this.a.l, imageView);
            n95.m().w("show_person_tab_feedback_tips", true);
            this.a.m = true;
            this.a.n.postDelayed(this.a.v, 3000L);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hba a;

        public e(hba hbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hbaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
        }
    }

    public hba(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
        this.n = new Handler();
        this.t = false;
        this.u = new d(this);
        this.v = new e(this);
        this.p = tbPageContext;
        this.o = i;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.q = i;
        }
    }

    public void t(float f) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048582, this, f) == null) && (navigationBar = this.b) != null && navigationBar.getBarBgView() != null) {
            this.b.getBarBgView().setAlpha(f);
        }
    }

    public void v(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, userData) == null) {
            this.s = userData;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.r = str;
            z();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            if (this.o == 1) {
                View view2 = this.j;
                if (view2 != null && view2.getParent() == null) {
                    this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, (View.OnClickListener) null);
                }
                RelativeLayout relativeLayout = this.c;
                if (relativeLayout != null && relativeLayout.getParent() == null) {
                    this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c, (View.OnClickListener) null);
                }
                RelativeLayout relativeLayout2 = this.f;
                if (relativeLayout2 != null && relativeLayout2.getParent() == null) {
                    this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f, (View.OnClickListener) null);
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            yg.c(this.l);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            z();
            ImageView imageView = this.e;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_news_head_new);
            }
            if (this.g != null) {
                if (2 == i) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (this.b.getBarBgView().getAlpha() == 0.0f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0205, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView2 = this.h;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.drawable.icon_news_down_bar_one);
                }
            }
            if (this.k != null && 2 != i) {
                if (this.b.getBarBgView().getAlpha() == 0.0f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0205, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            this.t = true;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (!this.t && this.b.getBarBgView() != null && this.b.getBarBgView().getAlpha() != 0.0f) {
                return;
            }
            NavigationBar navigationBar = this.b;
            if (navigationBar != null && navigationBar.getBarBgView() != null && this.b.getBarBgView().getAlpha() != 0.0f) {
                this.t = false;
            }
            float alpha = this.b.getBarBgView().getAlpha();
            if (this.d == null) {
                return;
            }
            if (TextUtils.isEmpty(this.r)) {
                if (2 == TbadkCoreApplication.getInst().getSkinType()) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (alpha == 0.0f) {
                    WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0205, null);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                this.d.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(this.r)).setAutoPlayAnimations(true).build());
                this.d.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_news_head_new);
            }
            if (this.g != null) {
                if (2 == i) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else if (alpha == 0.0f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0205, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                ImageView imageView2 = this.h;
                if (imageView2 != null) {
                    SkinManager.setImageResource(imageView2, R.drawable.icon_news_down_bar_one);
                }
            }
            if (this.k != null && 2 != i) {
                if (alpha == 0.0f) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0205, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (alpha == 0.0f) {
                this.t = true;
            }
        }
    }

    public void r(Context context, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, navigationBar) == null) {
            this.a = context;
            this.b = navigationBar;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0460, (ViewGroup) null);
            this.j = inflate;
            this.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091b90);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d045f, (ViewGroup) null);
            this.c = relativeLayout;
            this.d = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b8e);
            this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091b8f);
            RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0461, (ViewGroup) null);
            this.f = relativeLayout2;
            this.g = (ImageView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091b91);
            this.h = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091b92);
        }
    }

    public void u(iba ibaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ibaVar) == null) {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new a(this));
            }
            RelativeLayout relativeLayout2 = this.f;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new b(this));
            }
            View view2 = this.j;
            if (view2 != null) {
                view2.setOnClickListener(new c(this));
            }
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            or6 or6Var = new or6(this.p, this.d);
            or6Var.L(R.drawable.bg_tip_blue_up_right);
            or6Var.l(4);
            or6Var.o(48);
            or6Var.N(true);
            or6Var.B(5);
            or6Var.Q(-UtilHelper.getDimenPixelSize(R.dimen.tbds6));
            or6Var.R(-UtilHelper.getDimenPixelSize(R.dimen.tbds3));
            or6Var.C(R.color.CAM_X0101);
            or6Var.J(R.dimen.T_X08);
            or6Var.p(R.dimen.T_X08);
            or6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            or6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
            or6Var.S(str);
        }
    }

    public void x(int i, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int i2 = 0;
            if (i == 5 && (imageView2 = this.h) != null) {
                if (!z) {
                    i2 = 8;
                }
                imageView2.setVisibility(i2);
            } else if (i == 6 && (imageView = this.e) != null) {
                if (!z) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.d == null) {
            return;
        }
        if (TextUtils.isEmpty(this.r)) {
            if (2 == TbadkCoreApplication.getInst().getSkinType()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            } else if (this.b.getBarBgView().getAlpha() == 0.0f) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0205, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return;
            }
        }
        this.d.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(this.r)).setAutoPlayAnimations(true).build());
        this.d.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    }
}
