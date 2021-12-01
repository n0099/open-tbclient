package com.baidu.tbadk.widget.tiejia;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.q0.s.q.d2;
import c.a.q0.u.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
/* loaded from: classes9.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Context f42395e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TiePlusStat.Locate f42396f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<WeakReference<f>> f42397g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TiePlusHelper f42398h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f42399i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f42400j;

    /* loaded from: classes9.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.f1.p.a)) {
                c.a.q0.f1.p.a aVar = (c.a.q0.f1.p.a) customResponsedMessage.getData();
                this.a.statRichTextEvent(aVar);
                this.a.processClick(aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
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
            Iterator it = this.a.f42397g.iterator();
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

    /* loaded from: classes9.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.f1.p.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42401b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f42402c;

        public c(TiePlusEventController tiePlusEventController, c.a.q0.f1.p.a aVar, String str) {
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
            this.f42402c = tiePlusEventController;
            this.a = aVar;
            this.f42401b = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f42402c.f42396f, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.f42401b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.f1.p.a f42403b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f42404c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, c.a.q0.f1.p.a aVar) {
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
            this.f42404c = tiePlusEventController;
            this.a = tiebaPlusInfo;
            this.f42403b = aVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && j2 == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                this.f42403b.r(builder.build(true));
                UtilHelper.showToast(this.f42404c.f42395e, R.string.tip_order_successs);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UtilHelper.showToast(this.f42404c.f42395e, R.string.tip_order_fail);
            }
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
        this.f42397g = new ArrayList();
        this.f42399i = new a(this, 2001454);
        this.f42400j = new b(this, 2001455);
        this.f42395e = context;
        this.f42396f = locate;
        this.f42398h = new TiePlusHelper(context);
    }

    public static void onEvent(@NonNull c.a.q0.f1.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, aVar));
        }
    }

    public static void tryExposeTiePlusLinkEvent(@Nullable List<c.a.q0.f1.p.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null) {
            return;
        }
        for (c.a.q0.f1.p.a aVar : list) {
            aVar.q(TiePlusStat.StatType.EXPOSE);
            onEvent(aVar);
        }
    }

    public void addEventAckedCallbackWeaked(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f42397g.add(new WeakReference<>(fVar));
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
            MessageManager.getInstance().unRegisterListener(this.f42399i);
            MessageManager.getInstance().unRegisterListener(this.f42400j);
            this.f42398h.Y();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.f42399i);
            MessageManager.getInstance().registerListener(this.f42400j);
            this.f42398h.y();
        }
    }

    public void processClick(@NonNull c.a.q0.f1.p.a aVar) {
        PluginUser pluginUser;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && aVar.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f42396f;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                d();
            }
            TiePlusStat.LandingType g2 = aVar.g();
            TiebaPlusInfo n = aVar.n();
            String str = "";
            int i3 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.f42398h.l(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.f42398h.l(n.h5_jump_number, n.jump_type.intValue(), "", 0);
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.f42398h.l(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                TiePlusHelper tiePlusHelper = this.f42398h;
                tiePlusHelper.C(n.app_id);
                tiePlusHelper.G(n.download_url);
                tiePlusHelper.M(n.app_package);
                tiePlusHelper.O(n.app_power);
                tiePlusHelper.Q(n.app_privacy);
                if (aVar.k() != null && aVar.k().U2) {
                    str = aVar.k().V2;
                }
                String str2 = str;
                TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(this.f42395e, this.f42398h, true);
                this.f42398h.F(tiePlusDownloadDialog);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.f42398h.L(itemData);
                this.f42398h.g(new l(TiePlusStat.StatType.DOWNLOAD_FINISHED, aVar.h(), aVar.m(), str2, n.app_package));
                tiePlusDownloadDialog.setAppCompany(n.app_company).setAppIcon(n.app_icon).setAppTitle(n.title).setAppVersion(n.app_version).setDownloadClickCallback(new c(this, aVar, str2));
                tiePlusDownloadDialog.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f42396f, aVar.l(), aVar.h(), aVar.m(), aVar.f(), aVar.e(), str2);
            } else if (g2 == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    int i4 = e.a[this.f42396f.ordinal()];
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
                    ItemClickJumpUtil.itemClickJump(n.title, n.item_id, i3, Integer.valueOf(i2));
                    return;
                }
                this.f42398h.B(c.a.d.f.m.b.g(n.item_id, 0L), n.title, new d(this, n, aVar));
            } else if (g2 != TiePlusStat.LandingType.MESSAGE || (pluginUser = n.plugin_user) == null) {
            } else {
                TiePlusHelper.u(this.f42395e, pluginUser);
            }
        }
    }

    public void statRichTextEvent(@NonNull c.a.q0.f1.p.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            d2 k2 = aVar.k();
            String str3 = "";
            if (k2.U2) {
                str3 = k2.V2;
                str2 = k2.W2;
                str = k2.X2;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(aVar.o(), aVar.j(), this.f42396f, aVar.l(), aVar.h(), aVar.n().target_type.intValue(), aVar.g(), aVar.m(), aVar.f(), aVar.e(), str3, aVar.d());
            int o = aVar.o();
            TiePlusStat.StatType j2 = aVar.j();
            TiePlusStat.Locate locate = this.f42396f;
            TiePlusStat.c(o, j2, locate, str3, str2, str, aVar.i(locate));
        }
    }
}
