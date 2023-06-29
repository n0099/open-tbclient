package com.baidu.tbadk.widget.tiejia;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.h26;
import com.baidu.tieba.i26;
import com.baidu.tieba.jw6;
import com.baidu.tieba.mh5;
import com.baidu.tieba.os9;
import com.baidu.tieba.ra7;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    @NonNull
    public final TiePlusStat.Locate b;
    @NonNull
    public final List<WeakReference<g>> c;
    @NonNull
    public final TiePlusHelper d;
    public PermissionJudgePolicy e;
    public ra7 f;
    public CustomMessageListener g;
    public CustomMessageListener h;

    /* loaded from: classes4.dex */
    public interface g {
        void call();
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusEventController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TiePlusEventController tiePlusEventController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, Integer.valueOf(i)};
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
            this.a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof i26)) {
                return;
            }
            i26 i26Var = (i26) customResponsedMessage.getData();
            this.a.q(i26Var);
            this.a.m(i26Var);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusEventController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TiePlusEventController tiePlusEventController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, Integer.valueOf(i)};
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
            this.a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((g) weakReference.get()).call();
                } else {
                    it.remove();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements h26.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i26 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TiePlusEventController c;

        public c(TiePlusEventController tiePlusEventController, i26 i26Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, i26Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiePlusEventController;
            this.a = i26Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.h26.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.c.b, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ i26 b;
        public final /* synthetic */ TiePlusEventController c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, i26 i26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, i26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiePlusEventController;
            this.a = tiebaPlusInfo;
            this.b = i26Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                UtilHelper.showToast(this.c.a, (int) R.string.tip_order_fail);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || j != vg.g(this.a.item_id, 0L)) {
                return;
            }
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
            builder.is_appoint = 1;
            this.b.r(builder.build(true));
            UtilHelper.showToast(this.c.a, (int) R.string.tip_order_successs);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ i26 b;
        public final /* synthetic */ TiePlusEventController c;

        public e(TiePlusEventController tiePlusEventController, DownloadData downloadData, i26 i26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, downloadData, i26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiePlusEventController;
            this.a = downloadData;
            this.b = i26Var;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.f.h(this.a)) {
                String str2 = "";
                if (this.b.k() == null) {
                    str = "";
                } else {
                    if (this.b.k().isTiebaPlusAdThread) {
                        str2 = this.b.k().tiebaPlusOrderId;
                    }
                    String str3 = str2;
                    str2 = this.b.k().getTid();
                    str = str3;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_DXX_GUIDE_START_DOWNLOAD).addParam("tid", str2).addParam("order_id", str).addParam(TiePlusStat.RichTextType.STAT_KEY, 1).addParam("packageName", this.b.n().app_package));
                jw6 jw6Var = new jw6();
                ItemData itemData = new ItemData();
                itemData.buttonLink = this.b.n().download_url;
                itemData.buttonName = ItemCardHelper.b;
                itemData.mTitle = this.b.n().title;
                itemData.pkgName = this.b.n().app_package;
                itemData.mIconUrl = this.b.n().app_icon;
                itemData.mIconSize = 1.0d;
                itemData.buttonLinkType = 1;
                itemData.forumName = this.b.n().forum_name;
                ApkDetail.Builder builder = new ApkDetail.Builder();
                builder.authority_url = this.b.n().app_power;
                builder.developer = this.b.n().app_company;
                builder.privacy_url = this.b.n().app_privacy;
                builder.version = this.b.n().app_version;
                builder.version_code = 1;
                builder.pkg_source = 2;
                itemData.itemId = vg.g(this.b.n().app_id, 0L);
                itemData.apkDetail = builder.build(true);
                jw6Var.a = itemData;
                jw6Var.b = 1;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, jw6Var));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-332864744, "Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-332864744, "Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController$f;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            a = iArr;
            try {
                iArr[TiePlusStat.Locate.PB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TiePlusStat.Locate.HOME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TiePlusStat.Locate.FRS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TiePlusEventController(@NonNull Context context, @NonNull TiePlusStat.Locate locate) {
        this(context, locate, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (TiePlusStat.Locate) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TiePlusEventController(@NonNull Context context, @NonNull TiePlusStat.Locate locate, @Nullable BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locate, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.g = new a(this, 2001454);
        this.h = new b(this, 2001455);
        this.a = context;
        this.b = locate;
        this.d = new TiePlusHelper(context);
        if (bdUniqueId != null) {
            this.g.setTag(bdUniqueId);
            this.g.setSelfListener(true);
            this.h.setTag(bdUniqueId);
            this.h.setSelfListener(true);
        }
    }

    public static void onEvent(@NonNull i26 i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, i26Var) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, i26Var));
        }
    }

    public static void r(@Nullable List<i26> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, list) == null) && list != null) {
            for (i26 i26Var : list) {
                i26Var.q(TiePlusStat.StatType.EXPOSE);
                onEvent(i26Var);
            }
        }
    }

    public void j(@Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            this.c.add(new WeakReference<>(gVar));
        }
    }

    public final void l(i26 i26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i26Var) == null) && i26Var != null && i26Var.n() != null) {
            if (os9.i(i26Var.n().app_package)) {
                UtilHelper.startAppByPkgName(i26Var.n().app_package);
                return;
            }
            DownloadData downloadData = new DownloadData(i26Var.n().app_package + ".v" + i26Var.n().app_version);
            downloadData.setUrl(i26Var.n().download_url);
            downloadData.setName(i26Var.n().title);
            downloadData.setSource(2);
            downloadData.setType(12);
            if (this.f == null) {
                this.f = new ra7();
            }
            int e2 = this.f.e(downloadData);
            if (e2 != 1 && e2 != 5) {
                if (this.e == null) {
                    this.e = new PermissionJudgePolicy();
                }
                this.e.setOnPermissionsGrantedListener(new e(this, downloadData, i26Var));
                if (this.a instanceof Activity) {
                    this.e.clearRequestPermissionList();
                    this.e.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    this.e.startRequestPermission((Activity) this.a);
                    return;
                }
                return;
            }
            this.f.f(downloadData);
        }
    }

    public void m(@NonNull i26 i26Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i26Var) == null) && i26Var.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.b;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                p();
            }
            TiePlusStat.LandingType g2 = i26Var.g();
            TiebaPlusInfo n = i26Var.n();
            String str = "";
            int i2 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.d.o(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.d.V(n, i26Var.h(), i26Var.m());
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.d.o(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                if (TbadkCoreApplication.getInst().isMainTabActivity() && i26Var.k().isRealVideoThread() && !ListUtils.isEmpty(i26Var.k().getRichAbstractList())) {
                    for (PbContent pbContent : i26Var.k().getRichAbstractList()) {
                        if (pbContent != null) {
                            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
                            if (pbContent.type.intValue() == 35 && tiebaPlusInfo != null) {
                                l(i26Var);
                                return;
                            }
                        }
                    }
                }
                TiePlusHelper tiePlusHelper = this.d;
                tiePlusHelper.F(n.app_id);
                tiePlusHelper.K(n.download_url);
                tiePlusHelper.O(n.app_package);
                tiePlusHelper.P(n.app_power);
                tiePlusHelper.Q(n.app_privacy);
                if (i26Var.k() != null && i26Var.k().isTiebaPlusAdThread) {
                    str = i26Var.k().tiebaPlusOrderId;
                }
                String str2 = str;
                h26 h26Var = new h26(this.a, this.d, true);
                this.d.J(h26Var);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.d.N(itemData);
                this.d.j(new mh5(TiePlusStat.StatType.DOWNLOAD_FINISHED, i26Var.h(), i26Var.m(), str2, n.app_package));
                h26Var.f(n.app_company);
                h26Var.g(n.app_icon);
                h26Var.h(n.title);
                h26Var.i(n.app_version);
                h26Var.j(new c(this, i26Var, str2));
                h26Var.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.b, i26Var.l(), i26Var.h(), i26Var.m(), i26Var.f(), i26Var.e(), str2);
            } else if (g2 == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    if (StringUtils.isNull(n.forum_name)) {
                        return;
                    }
                    int i3 = f.a[this.b.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4 && i3 != 5) {
                                    i = -1;
                                    i2 = -1;
                                } else {
                                    i = 3;
                                    i2 = 3;
                                }
                            } else {
                                i2 = 10;
                                i = 13;
                            }
                        } else {
                            i = 1;
                        }
                    } else {
                        i = 9;
                        i2 = 9;
                    }
                    ItemClickJumpUtil.itemClickJump(n.forum_name, n.item_id, i2, Integer.valueOf(i));
                    return;
                }
                this.d.E(vg.g(n.item_id, 0L), n.title, new d(this, n, i26Var));
            } else if (g2 == TiePlusStat.LandingType.MESSAGE) {
                PluginUser pluginUser = n.plugin_user;
                if (pluginUser != null) {
                    Context context = this.a;
                    if (context instanceof Activity) {
                        TiePlusHelper.z((Activity) context, pluginUser);
                    }
                }
            } else if (g2 == TiePlusStat.LandingType.WECHAT_OFFICIAL) {
                if (n.jump_setting.intValue() == 1) {
                    this.d.W(n, i26Var.h(), i26Var.m());
                } else {
                    this.d.V(n, i26Var.h(), i26Var.m());
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            this.d.Y();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
            this.d.B();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    public void q(@NonNull i26 i26Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i26Var) == null) {
            ThreadData k = i26Var.k();
            String str3 = "";
            if (!k.isTiebaPlusAdThread) {
                str = "";
                str2 = str;
            } else {
                str3 = k.tiebaPlusOrderId;
                str2 = k.tiebaPlusToken;
                str = k.tiebaPlusExtraParam;
            }
            TiePlusStat.b(i26Var.o(), i26Var.j(), this.b, i26Var.l(), i26Var.h(), i26Var.n().target_type.intValue(), i26Var.g(), i26Var.m(), i26Var.f(), i26Var.e(), str3, i26Var.d());
            int o = i26Var.o();
            TiePlusStat.StatType j = i26Var.j();
            TiePlusStat.Locate locate = this.b;
            TiePlusStat.c(o, j, locate, str3, str2, str, i26Var.i(locate));
        }
    }
}
