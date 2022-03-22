package com.baidu.tbadk.widget.tiejia;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.o0.e1.p.b;
import c.a.o0.t.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.util.TiePlusHelper;
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
    public final Context a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TiePlusStat.Locate f31002b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final List<WeakReference<f>> f31003c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TiePlusHelper f31004d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f31005e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f31006f;

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.o0.e1.p.c)) {
                c.a.o0.e1.p.c cVar = (c.a.o0.e1.p.c) customResponsedMessage.getData();
                this.a.g(cVar);
                this.a.e(cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Iterator it = this.a.f31003c.iterator();
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
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.e1.p.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f31007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f31008c;

        public c(TiePlusEventController tiePlusEventController, c.a.o0.e1.p.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31008c = tiePlusEventController;
            this.a = cVar;
            this.f31007b = str;
        }

        @Override // c.a.o0.e1.p.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f31008c.f31002b, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.f31007b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.e1.p.c f31009b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f31010c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, c.a.o0.e1.p.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31010c = tiePlusEventController;
            this.a = tiebaPlusInfo;
            this.f31009b = cVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UtilHelper.showToast(this.f31010c.a, (int) R.string.obfuscated_res_0x7f0f13db);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j == c.a.d.f.m.b.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                this.f31009b.r(builder.build(true));
                UtilHelper.showToast(this.f31010c.a, (int) R.string.obfuscated_res_0x7f0f13dc);
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

    public static void h(@Nullable List<c.a.o0.e1.p.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null) {
            return;
        }
        for (c.a.o0.e1.p.c cVar : list) {
            cVar.q(TiePlusStat.StatType.EXPOSE);
            onEvent(cVar);
        }
    }

    public static void onEvent(@NonNull c.a.o0.e1.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, cVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, cVar));
        }
    }

    public void d(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.f31003c.add(new WeakReference<>(fVar));
        }
    }

    public void e(@NonNull c.a.o0.e1.p.c cVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && cVar.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f31002b;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                f();
            }
            TiePlusStat.LandingType g2 = cVar.g();
            TiebaPlusInfo n = cVar.n();
            String str = "";
            int i2 = 1;
            if (g2 == TiePlusStat.LandingType.H5) {
                this.f31004d.l(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g2 == TiePlusStat.LandingType.WECHAT) {
                this.f31004d.T(n, cVar.h(), cVar.m());
            } else if (g2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.f31004d.l(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                TiePlusHelper tiePlusHelper = this.f31004d;
                tiePlusHelper.E(n.app_id);
                tiePlusHelper.J(n.download_url);
                tiePlusHelper.M(n.app_package);
                tiePlusHelper.N(n.app_power);
                tiePlusHelper.O(n.app_privacy);
                if (cVar.k() != null && cVar.k().isTiebaPlusAdThread) {
                    str = cVar.k().tiebaPlusOrderId;
                }
                String str2 = str;
                c.a.o0.e1.p.b bVar = new c.a.o0.e1.p.b(this.a, this.f31004d, true);
                this.f31004d.I(bVar);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.f31004d.L(itemData);
                this.f31004d.g(new o(TiePlusStat.StatType.DOWNLOAD_FINISHED, cVar.h(), cVar.m(), str2, n.app_package));
                bVar.f(n.app_company);
                bVar.g(n.app_icon);
                bVar.h(n.title);
                bVar.i(n.app_version);
                bVar.j(new c(this, cVar, str2));
                bVar.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f31002b, cVar.l(), cVar.h(), cVar.m(), cVar.f(), cVar.e(), str2);
            } else if (g2 == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    if (StringUtils.isNull(n.forum_name)) {
                        return;
                    }
                    int i3 = e.a[this.f31002b.ordinal()];
                    if (i3 == 1) {
                        i = 9;
                        i2 = 9;
                    } else if (i3 == 2) {
                        i = 1;
                    } else if (i3 == 3) {
                        i2 = 10;
                        i = 13;
                    } else if (i3 == 4 || i3 == 5) {
                        i = 3;
                        i2 = 3;
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    ItemClickJumpUtil.itemClickJump(n.forum_name, n.item_id, i2, Integer.valueOf(i));
                    return;
                }
                this.f31004d.D(c.a.d.f.m.b.g(n.item_id, 0L), n.title, new d(this, n, cVar));
            } else if (g2 == TiePlusStat.LandingType.MESSAGE) {
                PluginUser pluginUser = n.plugin_user;
                if (pluginUser != null) {
                    Context context = this.a;
                    if (context instanceof Activity) {
                        TiePlusHelper.u((Activity) context, pluginUser);
                    }
                }
            } else if (g2 == TiePlusStat.LandingType.WECHAT_OFFICIAL) {
                if (n.jump_setting.intValue() == 1) {
                    this.f31004d.U(n, cVar.h(), cVar.m());
                } else {
                    this.f31004d.T(n, cVar.h(), cVar.m());
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    public void g(@NonNull c.a.o0.e1.p.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            ThreadData k = cVar.k();
            String str3 = "";
            if (k.isTiebaPlusAdThread) {
                str3 = k.tiebaPlusOrderId;
                str2 = k.tiebaPlusToken;
                str = k.tiebaPlusExtraParam;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(cVar.o(), cVar.j(), this.f31002b, cVar.l(), cVar.h(), cVar.n().target_type.intValue(), cVar.g(), cVar.m(), cVar.f(), cVar.e(), str3, cVar.d());
            int o = cVar.o();
            TiePlusStat.StatType j = cVar.j();
            TiePlusStat.Locate locate = this.f31002b;
            TiePlusStat.c(o, j, locate, str3, str2, str, cVar.i(locate));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f31005e);
            MessageManager.getInstance().unRegisterListener(this.f31006f);
            this.f31004d.W();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f31005e);
            MessageManager.getInstance().registerListener(this.f31006f);
            this.f31004d.A();
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
        this.f31003c = new ArrayList();
        this.f31005e = new a(this, 2001454);
        this.f31006f = new b(this, 2001455);
        this.a = context;
        this.f31002b = locate;
        this.f31004d = new TiePlusHelper(context);
        if (bdUniqueId != null) {
            this.f31005e.setTag(bdUniqueId);
            this.f31005e.setSelfListener(true);
            this.f31006f.setTag(bdUniqueId);
            this.f31006f.setSelfListener(true);
        }
    }
}
