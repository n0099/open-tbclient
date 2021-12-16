package com.baidu.tbadk.widget.tiejia;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.r0.s.r.d2;
import c.a.r0.u.l;
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
/* loaded from: classes11.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Context f42886e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TiePlusStat.Locate f42887f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<WeakReference<f>> f42888g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TiePlusHelper f42889h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f42890i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f42891j;

    /* loaded from: classes11.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.f1.p.a)) {
                c.a.r0.f1.p.a aVar = (c.a.r0.f1.p.a) customResponsedMessage.getData();
                this.a.statRichTextEvent(aVar);
                this.a.processClick(aVar);
            }
        }
    }

    /* loaded from: classes11.dex */
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
            Iterator it = this.a.f42888g.iterator();
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

    /* loaded from: classes11.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.f1.p.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42892b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f42893c;

        public c(TiePlusEventController tiePlusEventController, c.a.r0.f1.p.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42893c = tiePlusEventController;
            this.a = aVar;
            this.f42892b = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f42893c.f42887f, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.f42892b);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.f1.p.a f42894b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f42895c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, c.a.r0.f1.p.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42895c = tiePlusEventController;
            this.a = tiebaPlusInfo;
            this.f42894b = aVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                this.f42894b.r(builder.build(true));
                UtilHelper.showToast(this.f42895c.f42886e, R.string.tip_order_successs);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.f42895c.f42886e, R.string.tip_order_fail);
            }
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public interface f {
        void call();
    }

    public TiePlusEventController(@NonNull Context context, @NonNull TiePlusStat.Locate locate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, locate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42888g = new ArrayList();
        this.f42890i = new a(this, 2001454);
        this.f42891j = new b(this, 2001455);
        this.f42886e = context;
        this.f42887f = locate;
        this.f42889h = new TiePlusHelper(context);
    }

    public static void onEvent(@NonNull c.a.r0.f1.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, aVar));
        }
    }

    public static void tryExposeTiePlusLinkEvent(@Nullable List<c.a.r0.f1.p.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null) {
            return;
        }
        for (c.a.r0.f1.p.a aVar : list) {
            aVar.q(TiePlusStat.StatType.EXPOSE);
            onEvent(aVar);
        }
    }

    public void addEventAckedCallbackWeaked(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f42888g.add(new WeakReference<>(fVar));
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
            MessageManager.getInstance().unRegisterListener(this.f42890i);
            MessageManager.getInstance().unRegisterListener(this.f42891j);
            this.f42889h.c0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.f42890i);
            MessageManager.getInstance().registerListener(this.f42891j);
            this.f42889h.A();
        }
    }

    public void processClick(@NonNull c.a.r0.f1.p.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && aVar.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f42887f;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                d();
            }
            TiePlusStat.LandingType g2 = aVar.g();
            TiebaPlusInfo n = aVar.n();
            String str = "";
            int i3 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.f42889h.l(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.f42889h.Z(n, aVar.h(), aVar.m());
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.f42889h.l(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                TiePlusHelper tiePlusHelper = this.f42889h;
                tiePlusHelper.E(n.app_id);
                tiePlusHelper.L(n.download_url);
                tiePlusHelper.Q(n.app_package);
                tiePlusHelper.S(n.app_power);
                tiePlusHelper.T(n.app_privacy);
                if (aVar.k() != null && aVar.k().V2) {
                    str = aVar.k().W2;
                }
                String str2 = str;
                TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(this.f42886e, this.f42889h, true);
                this.f42889h.K(tiePlusDownloadDialog);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.f42889h.O(itemData);
                this.f42889h.g(new l(TiePlusStat.StatType.DOWNLOAD_FINISHED, aVar.h(), aVar.m(), str2, n.app_package));
                tiePlusDownloadDialog.setAppCompany(n.app_company).setAppIcon(n.app_icon).setAppTitle(n.title).setAppVersion(n.app_version).setDownloadClickCallback(new c(this, aVar, str2));
                tiePlusDownloadDialog.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f42887f, aVar.l(), aVar.h(), aVar.m(), aVar.f(), aVar.e(), str2);
            } else if (g2 == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    if (StringUtils.isNull(n.forum_name)) {
                        return;
                    }
                    int i4 = e.a[this.f42887f.ordinal()];
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
                this.f42889h.D(c.a.d.f.m.b.g(n.item_id, 0L), n.title, new d(this, n, aVar));
            } else if (g2 == TiePlusStat.LandingType.MESSAGE) {
                PluginUser pluginUser = n.plugin_user;
                if (pluginUser != null) {
                    TiePlusHelper.u(this.f42886e, pluginUser);
                }
            } else if (g2 == TiePlusStat.LandingType.WECHAT_OFFICIAL) {
                if (n.jump_setting.intValue() == 1) {
                    this.f42889h.a0(n, aVar.h(), aVar.m());
                } else {
                    this.f42889h.Z(n, aVar.h(), aVar.m());
                }
            }
        }
    }

    public void statRichTextEvent(@NonNull c.a.r0.f1.p.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            d2 k2 = aVar.k();
            String str3 = "";
            if (k2.V2) {
                str3 = k2.W2;
                str2 = k2.X2;
                str = k2.Y2;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(aVar.o(), aVar.j(), this.f42887f, aVar.l(), aVar.h(), aVar.n().target_type.intValue(), aVar.g(), aVar.m(), aVar.f(), aVar.e(), str3, aVar.d());
            int o = aVar.o();
            TiePlusStat.StatType j2 = aVar.j();
            TiePlusStat.Locate locate = this.f42887f;
            TiePlusStat.c(o, j2, locate, str3, str2, str, aVar.i(locate));
        }
    }
}
