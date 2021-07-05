package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.r0.r.s.a;
/* loaded from: classes4.dex */
public class XiaoyingUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    public static int showTime;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f13148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f13149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f13150g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f13151h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f13152i;

        public a(Context context, String str, int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13148e = context;
            this.f13149f = str;
            this.f13150g = i2;
            this.f13151h = i3;
            this.f13152i = str2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(this.f13148e, this.f13149f, this.f13150g, this.f13151h, this.f13152i)));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f13153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f13154f;

        public c(Activity activity, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13153e = activity;
            this.f13154f = tbPageContext;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f13154f.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(this.f13153e, XiaoyingUtil.PKG_NAME_VIDEO)));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public XiaoyingUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? showTime : invokeV.intValue;
    }

    public static boolean isXiaoyingForbidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PluginPackageManager.O().b0(PKG_NAME_VIDEO) : invokeV.booleanValue;
    }

    public static boolean isXiaoyingInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? PluginPackageManager.O().d0(PKG_NAME_VIDEO) && TbadkCoreApplication.getInst().appResponseToIntentClass(MotuVideoConfig.class) : invokeV.booleanValue;
    }

    public static void setShowTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, null, i2) == null) {
            showTime = i2;
        }
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, tbPageContext, str, str2) == null) || tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(pageActivity);
        aVar.setMessage(str);
        aVar.setPositiveButton(str2, new c(pageActivity, tbPageContext));
        aVar.setNegativeButton(R.string.cancel, new d());
        aVar.create(tbPageContext).show();
    }

    public static void showStartPlayVideoDialog(Context context, String str, int i2, int i3, String str2) {
        f<?> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) || (a2 = j.a(context)) == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(a2.getPageActivity());
        aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
        aVar.setPositiveButton(R.string.confirm, new a(context, str, i2, i3, str2));
        aVar.setNegativeButton(R.string.cancel, new b());
        aVar.create(a2).show();
    }

    public static boolean showXiaoyingTool() {
        InterceptResult invokeV;
        PluginNetConfigInfos.PluginConfig R;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (!TbadkCoreApplication.getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (R = PluginPackageManager.O().R(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(R.display_name) || R.forbidden == 1 || d.a.c.h.j.g.d.k().h(PKG_NAME_VIDEO) == null) ? false : true : invokeV.booleanValue;
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            startPlayXiaoyingVideo(context, str, i2, i3, str2, true);
        }
    }

    public static void startXiaoying(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, context) == null) || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context)));
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i2, int i3, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z)}) == null) || context == null || StringUtils.isNull(str)) {
            return;
        }
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
            BdToast.c(context, context.getString(R.string.plugin_xiaoying_install_fail)).q();
        } else if (z && !d.a.c.e.p.j.z()) {
            BdToast.c(context, context.getString(R.string.neterror)).q();
        } else if (z) {
            if (d.a.c.e.p.j.H()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i2, i3, str2)));
            } else {
                showStartPlayVideoDialog(context, str, i2, i3, str2);
            }
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new XiaoyingPlayerConfig(context, str, i2, i3, str2)));
        }
    }

    public static void startXiaoying(Context context, boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3}) == null) || context == null) {
            return;
        }
        d.a.r0.r.d0.b.j().t(MotuVideoConfig.IS_SINGLE_GOD_USER, z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MotuVideoConfig(context, z || d.a.r0.r.d0.b.j().g("localvideo_open", false), str, str2, str3)));
    }
}
