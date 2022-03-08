package com.baidu.tbadk.widget.tiejia;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.q0.r.r.e2;
import c.a.q0.t.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
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
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Context f40201e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TiePlusStat.Locate f40202f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<WeakReference<f>> f40203g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TiePlusHelper f40204h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f40205i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f40206j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusEventController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TiePlusEventController tiePlusEventController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.e1.p.b)) {
                c.a.q0.e1.p.b bVar = (c.a.q0.e1.p.b) customResponsedMessage.getData();
                this.a.statRichTextEvent(bVar);
                this.a.processClick(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusEventController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TiePlusEventController tiePlusEventController, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Iterator it = this.a.f40203g.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((f) weakReference.get()).call();
                } else {
                    it.remove();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.e1.p.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f40208c;

        public c(TiePlusEventController tiePlusEventController, c.a.q0.e1.p.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40208c = tiePlusEventController;
            this.a = bVar;
            this.f40207b = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f40208c.f40202f, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.f40207b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.e1.p.b f40209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f40210c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, c.a.q0.e1.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40210c = tiePlusEventController;
            this.a = tiebaPlusInfo;
            this.f40209b = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UtilHelper.showToast(this.f40210c.f40201e, (int) R.string.tip_order_fail);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                this.f40209b.r(builder.build(true));
                UtilHelper.showToast(this.f40210c.f40201e, (int) R.string.tip_order_successs);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-332864775, "Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-332864775, "Lcom/baidu/tbadk/widget/tiejia/TiePlusEventController$e;");
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

    /* loaded from: classes5.dex */
    public interface f {
        void call();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (TiePlusStat.Locate) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void onEvent(@NonNull c.a.q0.e1.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, bVar));
        }
    }

    public static void tryExposeTiePlusLinkEvent(@Nullable List<c.a.q0.e1.p.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, list) == null) || list == null) {
            return;
        }
        for (c.a.q0.e1.p.b bVar : list) {
            bVar.q(TiePlusStat.StatType.EXPOSE);
            onEvent(bVar);
        }
    }

    public void addEventAckedCallbackWeaked(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f40203g.add(new WeakReference<>(fVar));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f40205i);
            MessageManager.getInstance().unRegisterListener(this.f40206j);
            this.f40204h.W();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.f40205i);
            MessageManager.getInstance().registerListener(this.f40206j);
            this.f40204h.A();
        }
    }

    public void processClick(@NonNull c.a.q0.e1.p.b bVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) && bVar.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f40202f;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                d();
            }
            TiePlusStat.LandingType g2 = bVar.g();
            TiebaPlusInfo n = bVar.n();
            String str = "";
            int i3 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.f40204h.l(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.f40204h.T(n, bVar.h(), bVar.m());
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.f40204h.l(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                TiePlusHelper tiePlusHelper = this.f40204h;
                tiePlusHelper.E(n.app_id);
                tiePlusHelper.J(n.download_url);
                tiePlusHelper.M(n.app_package);
                tiePlusHelper.N(n.app_power);
                tiePlusHelper.O(n.app_privacy);
                if (bVar.k() != null && bVar.k().U2) {
                    str = bVar.k().V2;
                }
                String str2 = str;
                TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(this.f40201e, this.f40204h, true);
                this.f40204h.I(tiePlusDownloadDialog);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.f40204h.L(itemData);
                this.f40204h.g(new o(TiePlusStat.StatType.DOWNLOAD_FINISHED, bVar.h(), bVar.m(), str2, n.app_package));
                tiePlusDownloadDialog.setAppCompany(n.app_company).setAppIcon(n.app_icon).setAppTitle(n.title).setAppVersion(n.app_version).setDownloadClickCallback(new c(this, bVar, str2));
                tiePlusDownloadDialog.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f40202f, bVar.l(), bVar.h(), bVar.m(), bVar.f(), bVar.e(), str2);
            } else if (g2 == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    if (StringUtils.isNull(n.forum_name)) {
                        return;
                    }
                    int i4 = e.a[this.f40202f.ordinal()];
                    if (i4 == 1) {
                        i2 = 9;
                        i3 = 9;
                    } else if (i4 == 2) {
                        i2 = 1;
                    } else if (i4 == 3) {
                        i3 = 10;
                        i2 = 13;
                    } else if (i4 == 4 || i4 == 5) {
                        i2 = 3;
                        i3 = 3;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    ItemClickJumpUtil.itemClickJump(n.forum_name, n.item_id, i3, Integer.valueOf(i2));
                    return;
                }
                this.f40204h.D(c.a.d.f.m.b.g(n.item_id, 0L), n.title, new d(this, n, bVar));
            } else if (g2 == TiePlusStat.LandingType.MESSAGE) {
                PluginUser pluginUser = n.plugin_user;
                if (pluginUser != null) {
                    Context context = this.f40201e;
                    if (context instanceof Activity) {
                        TiePlusHelper.u((Activity) context, pluginUser);
                    }
                }
            } else if (g2 == TiePlusStat.LandingType.WECHAT_OFFICIAL) {
                if (n.jump_setting.intValue() == 1) {
                    this.f40204h.U(n, bVar.h(), bVar.m());
                } else {
                    this.f40204h.T(n, bVar.h(), bVar.m());
                }
            }
        }
    }

    public void statRichTextEvent(@NonNull c.a.q0.e1.p.b bVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            e2 k = bVar.k();
            String str3 = "";
            if (k.U2) {
                str3 = k.V2;
                str2 = k.W2;
                str = k.X2;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(bVar.o(), bVar.j(), this.f40202f, bVar.l(), bVar.h(), bVar.n().target_type.intValue(), bVar.g(), bVar.m(), bVar.f(), bVar.e(), str3, bVar.d());
            int o = bVar.o();
            TiePlusStat.StatType j2 = bVar.j();
            TiePlusStat.Locate locate = this.f40202f;
            TiePlusStat.c(o, j2, locate, str3, str2, str, bVar.i(locate));
        }
    }

    public TiePlusEventController(@NonNull Context context, @NonNull TiePlusStat.Locate locate, @Nullable BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locate, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40203g = new ArrayList();
        this.f40205i = new a(this, 2001454);
        this.f40206j = new b(this, 2001455);
        this.f40201e = context;
        this.f40202f = locate;
        this.f40204h = new TiePlusHelper(context);
        if (bdUniqueId != null) {
            this.f40205i.setTag(bdUniqueId);
            this.f40205i.setSelfListener(true);
            this.f40206j.setTag(bdUniqueId);
            this.f40206j.setSelfListener(true);
        }
    }
}
