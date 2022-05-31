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
import com.repackage.af5;
import com.repackage.fz4;
import com.repackage.jg;
import com.repackage.ze5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    @NonNull
    public final TiePlusStat.Locate b;
    @NonNull
    public final List<WeakReference<f>> c;
    @NonNull
    public final TiePlusHelper d;
    public CustomMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof af5)) {
                af5 af5Var = (af5) customResponsedMessage.getData();
                this.a.o(af5Var);
                this.a.m(af5Var);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Iterator it = this.a.c.iterator();
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

    /* loaded from: classes3.dex */
    public class c implements ze5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af5 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TiePlusEventController c;

        public c(TiePlusEventController tiePlusEventController, af5 af5Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, af5Var, str};
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
            this.a = af5Var;
            this.b = str;
        }

        @Override // com.repackage.ze5.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.c.b, this.a.l(), this.a.h(), this.a.m(), this.a.f(), this.a.e(), this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ af5 b;
        public final /* synthetic */ TiePlusEventController c;

        public d(TiePlusEventController tiePlusEventController, TiebaPlusInfo tiebaPlusInfo, af5 af5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusEventController, tiebaPlusInfo, af5Var};
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
            this.b = af5Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UtilHelper.showToast(this.c.a, (int) R.string.obfuscated_res_0x7f0f1419);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && j == jg.g(this.a.item_id, 0L)) {
                TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder(this.a);
                builder.is_appoint = 1;
                this.b.r(builder.build(true));
                UtilHelper.showToast(this.c.a, (int) R.string.obfuscated_res_0x7f0f141a);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public static void onEvent(@NonNull af5 af5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, af5Var) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, af5Var));
        }
    }

    public static void p(@Nullable List<af5> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, list) == null) || list == null) {
            return;
        }
        for (af5 af5Var : list) {
            af5Var.q(TiePlusStat.StatType.EXPOSE);
            onEvent(af5Var);
        }
    }

    public void l(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.c.add(new WeakReference<>(fVar));
        }
    }

    public void m(@NonNull af5 af5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af5Var) == null) && af5Var.j() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.b;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                n();
            }
            TiePlusStat.LandingType g = af5Var.g();
            TiebaPlusInfo n = af5Var.n();
            String str = "";
            int i2 = 1;
            if (g == TiePlusStat.LandingType.H5) {
                this.d.l(n.jump_url, 1, "", n.h5_jump_type.intValue());
            } else if (g == TiePlusStat.LandingType.WECHAT) {
                this.d.U(n, af5Var.h(), af5Var.m());
            } else if (g == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.d.l(n.h5_jump_number, n.jump_type.intValue(), n.h5_jump_param, 0);
            } else if (g == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                TiePlusHelper tiePlusHelper = this.d;
                tiePlusHelper.F(n.app_id);
                tiePlusHelper.K(n.download_url);
                tiePlusHelper.N(n.app_package);
                tiePlusHelper.O(n.app_power);
                tiePlusHelper.P(n.app_privacy);
                if (af5Var.k() != null && af5Var.k().isTiebaPlusAdThread) {
                    str = af5Var.k().tiebaPlusOrderId;
                }
                String str2 = str;
                ze5 ze5Var = new ze5(this.a, this.d, true);
                this.d.J(ze5Var);
                ItemData itemData = new ItemData();
                itemData.parseProto(n);
                this.d.M(itemData);
                this.d.g(new fz4(TiePlusStat.StatType.DOWNLOAD_FINISHED, af5Var.h(), af5Var.m(), str2, n.app_package));
                ze5Var.f(n.app_company);
                ze5Var.g(n.app_icon);
                ze5Var.h(n.title);
                ze5Var.i(n.app_version);
                ze5Var.j(new c(this, af5Var, str2));
                ze5Var.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.b, af5Var.l(), af5Var.h(), af5Var.m(), af5Var.f(), af5Var.e(), str2);
            } else if (g == TiePlusStat.LandingType.APPOINT) {
                if (n.is_appoint.intValue() == 1) {
                    if (StringUtils.isNull(n.forum_name)) {
                        return;
                    }
                    int i3 = e.a[this.b.ordinal()];
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
                this.d.E(jg.g(n.item_id, 0L), n.title, new d(this, n, af5Var));
            } else if (g == TiePlusStat.LandingType.MESSAGE) {
                PluginUser pluginUser = n.plugin_user;
                if (pluginUser != null) {
                    Context context = this.a;
                    if (context instanceof Activity) {
                        TiePlusHelper.v((Activity) context, pluginUser);
                    }
                }
            } else if (g == TiePlusStat.LandingType.WECHAT_OFFICIAL) {
                if (n.jump_setting.intValue() == 1) {
                    this.d.V(n, af5Var.h(), af5Var.m());
                } else {
                    this.d.U(n, af5Var.h(), af5Var.m());
                }
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    public void o(@NonNull af5 af5Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, af5Var) == null) {
            ThreadData k = af5Var.k();
            String str3 = "";
            if (k.isTiebaPlusAdThread) {
                str3 = k.tiebaPlusOrderId;
                str2 = k.tiebaPlusToken;
                str = k.tiebaPlusExtraParam;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(af5Var.o(), af5Var.j(), this.b, af5Var.l(), af5Var.h(), af5Var.n().target_type.intValue(), af5Var.g(), af5Var.m(), af5Var.f(), af5Var.e(), str3, af5Var.d());
            int o = af5Var.o();
            TiePlusStat.StatType j = af5Var.j();
            TiePlusStat.Locate locate = this.b;
            TiePlusStat.c(o, j, locate, str3, str2, str, af5Var.i(locate));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
            this.d.X();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.e);
            MessageManager.getInstance().registerListener(this.f);
            this.d.B();
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
        this.e = new a(this, 2001454);
        this.f = new b(this, 2001455);
        this.a = context;
        this.b = locate;
        this.d = new TiePlusHelper(context);
        if (bdUniqueId != null) {
            this.e.setTag(bdUniqueId);
            this.e.setSelfListener(true);
            this.f.setTag(bdUniqueId);
            this.f.setSelfListener(true);
        }
    }
}
