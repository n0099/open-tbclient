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
import com.baidu.tieba.ch5;
import com.baidu.tieba.fa7;
import com.baidu.tieba.fm9;
import com.baidu.tieba.tg;
import com.baidu.tieba.v16;
import com.baidu.tieba.w16;
import com.baidu.tieba.xv6;
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
    public fa7 f;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof w16)) {
                return;
            }
            w16 w16Var = (w16) customResponsedMessage.getData();
            this.a.q(w16Var);
            this.a.m(w16Var);
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
    public class c implements v16.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w16 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TiePlusEventController c;

        public c(TiePlusEventController tiePlusEventController, w16 w16Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, w16Var, str};
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
            this.a = w16Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.v16.c
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
        public final /* synthetic */ w16 b;
        public final /* synthetic */ TiePlusEventController c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, w16 w16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, w16Var};
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
            this.b = w16Var;
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
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || j != tg.g(this.a.item_id, 0L)) {
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
        public final /* synthetic */ w16 b;
        public final /* synthetic */ TiePlusEventController c;

        public e(TiePlusEventController tiePlusEventController, DownloadData downloadData, w16 w16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, downloadData, w16Var};
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
            this.b = w16Var;
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
                xv6 xv6Var = new xv6();
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
                itemData.itemId = tg.g(this.b.n().app_id, 0L);
                itemData.apkDetail = builder.build(true);
                xv6Var.a = itemData;
                xv6Var.b = 1;
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, xv6Var));
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

    public static void onEvent(@NonNull w16 w16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, w16Var) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, w16Var));
        }
    }

    public static void r(@Nullable List<w16> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, list) == null) && list != null) {
            for (w16 w16Var : list) {
                w16Var.q(TiePlusStat.StatType.EXPOSE);
                onEvent(w16Var);
            }
        }
    }

    public void j(@Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            this.c.add(new WeakReference<>(gVar));
        }
    }

    public final void l(w16 w16Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w16Var) == null) && w16Var != null && w16Var.n() != null) {
            if (fm9.i(w16Var.n().app_package)) {
                UtilHelper.startAppByPkgName(w16Var.n().app_package);
                return;
            }
            DownloadData downloadData = new DownloadData(w16Var.n().app_package + ".v" + w16Var.n().app_version);
            downloadData.setUrl(w16Var.n().download_url);
            downloadData.setName(w16Var.n().title);
            downloadData.setSource(2);
            downloadData.setType(12);
            if (this.f == null) {
                this.f = new fa7();
            }
            int e2 = this.f.e(downloadData);
            if (e2 != 1 && e2 != 5) {
                if (this.e == null) {
                    this.e = new PermissionJudgePolicy();
                }
                this.e.setOnPermissionsGrantedListener(new e(this, downloadData, w16Var));
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

    public void m(@NonNull w16 w16Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w16Var) == null) && w16Var.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.b;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                p();
            }
            TiePlusStat.LandingType g2 = w16Var.g();
            TiebaPlusInfo n = w16Var.n();
            String str = "";
            int i2 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.d.o(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.d.V(n, w16Var.h(), w16Var.m());
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.d.o(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                if (TbadkCoreApplication.getInst().isMainTabActivity() && w16Var.k().isRealVideoThread() && !ListUtils.isEmpty(w16Var.k().getRichAbstractList())) {
                    for (PbContent pbContent : w16Var.k().getRichAbstractList()) {
                        if (pbContent != null) {
                            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
                            if (pbContent.type.intValue() == 35 && tiebaPlusInfo != null) {
                                l(w16Var);
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
                if (w16Var.k() != null && w16Var.k().isTiebaPlusAdThread) {
                    str = w16Var.k().tiebaPlusOrderId;
                }
                String str2 = str;
                v16 v16Var = new v16(this.a, this.d, true);
                this.d.J(v16Var);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.d.N(itemData);
                this.d.j(new ch5(TiePlusStat.StatType.DOWNLOAD_FINISHED, w16Var.h(), w16Var.m(), str2, n.app_package));
                v16Var.f(n.app_company);
                v16Var.g(n.app_icon);
                v16Var.h(n.title);
                v16Var.i(n.app_version);
                v16Var.j(new c(this, w16Var, str2));
                v16Var.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.b, w16Var.l(), w16Var.h(), w16Var.m(), w16Var.f(), w16Var.e(), str2);
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
                this.d.E(tg.g(n.item_id, 0L), n.title, new d(this, n, w16Var));
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
                    this.d.W(n, w16Var.h(), w16Var.m());
                } else {
                    this.d.V(n, w16Var.h(), w16Var.m());
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

    public void q(@NonNull w16 w16Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, w16Var) == null) {
            ThreadData k = w16Var.k();
            String str3 = "";
            if (!k.isTiebaPlusAdThread) {
                str = "";
                str2 = str;
            } else {
                str3 = k.tiebaPlusOrderId;
                str2 = k.tiebaPlusToken;
                str = k.tiebaPlusExtraParam;
            }
            TiePlusStat.b(w16Var.o(), w16Var.j(), this.b, w16Var.l(), w16Var.h(), w16Var.n().target_type.intValue(), w16Var.g(), w16Var.m(), w16Var.f(), w16Var.e(), str3, w16Var.d());
            int o = w16Var.o();
            TiePlusStat.StatType j = w16Var.j();
            TiePlusStat.Locate locate = this.b;
            TiePlusStat.c(o, j, locate, str3, str2, str, w16Var.i(locate));
        }
    }
}
