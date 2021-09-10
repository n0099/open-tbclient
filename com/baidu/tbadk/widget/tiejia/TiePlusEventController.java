package com.baidu.tbadk.widget.tiejia;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import c.a.q0.d1.p0;
import c.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Context f48950e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TiePlusStat.Locate f48951f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<WeakReference<d>> f48952g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final p0 f48953h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f48954i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f48955j;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f48956a;

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
            this.f48956a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.f1.o.a)) {
                c.a.q0.f1.o.a aVar = (c.a.q0.f1.o.a) customResponsedMessage.getData();
                this.f48956a.g(aVar);
                this.f48956a.e(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f48957a;

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
            this.f48957a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Iterator it = this.f48957a.f48952g.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() != null) {
                    ((d) weakReference.get()).call();
                } else {
                    it.remove();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TiePlusDownloadDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.f1.o.a f48958a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48959b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f48960c;

        public c(TiePlusEventController tiePlusEventController, c.a.q0.f1.o.a aVar, String str) {
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
            this.f48960c = tiePlusEventController;
            this.f48958a = aVar;
            this.f48959b = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f48960c.f48951f, this.f48958a.j(), TiePlusStat.RichTextType.LINK, this.f48958a.k(), this.f48958a.e(), this.f48958a.d(), this.f48959b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
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
        this.f48952g = new ArrayList();
        this.f48954i = new a(this, 2001454);
        this.f48955j = new b(this, 2001455);
        this.f48950e = context;
        this.f48951f = locate;
        this.f48953h = new p0(context);
    }

    public static void onEvent(@NonNull c.a.q0.f1.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, aVar));
        }
    }

    public static void tryExposeTiePlusLinkEvent(@Nullable List<c.a.q0.f1.o.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list) == null) || list == null) {
            return;
        }
        for (c.a.q0.f1.o.a aVar : list) {
            aVar.n(TiePlusStat.StatType.EXPOSE);
            onEvent(aVar);
        }
    }

    public void addEventAckedCallbackWeaked(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f48952g.add(new WeakReference<>(dVar));
        }
    }

    public final void e(@NonNull c.a.q0.f1.o.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar.h() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f48951f;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                f();
            }
            TiePlusStat.LandingType f2 = aVar.f();
            TiebaPlusInfo l = aVar.l();
            if (f2 == TiePlusStat.LandingType.H5) {
                this.f48953h.f(l.jump_url, l.h5_jump_type.intValue() != 2);
            } else if (f2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                p0 p0Var = this.f48953h;
                p0Var.o(l.app_id);
                p0Var.q(l.download_url);
                p0Var.r(l.app_package);
                p0Var.s(l.app_power);
                p0Var.t(l.app_privacy);
                String str = (aVar.i() == null || !aVar.i().Q2) ? "" : aVar.i().R2;
                TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(this.f48950e, this.f48953h, true);
                this.f48953h.p(tiePlusDownloadDialog);
                tiePlusDownloadDialog.setAppCompany(l.app_company).setAppIcon(l.app_icon).setAppTitle(l.title).setAppVersion(l.app_version).setDownloadClickCallback(new c(this, aVar, str));
                tiePlusDownloadDialog.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f48951f, aVar.j(), TiePlusStat.RichTextType.LINK, aVar.k(), aVar.e(), aVar.d(), str);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    public final void g(@NonNull c.a.q0.f1.o.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            d2 i2 = aVar.i();
            String str3 = "";
            if (i2.Q2) {
                str3 = i2.R2;
                str2 = i2.S2;
                str = i2.T2;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(aVar.m(), aVar.h(), this.f48951f, aVar.j(), TiePlusStat.RichTextType.LINK, aVar.l().target_type.intValue(), aVar.f(), aVar.k(), aVar.e(), aVar.d(), str3, null);
            int m = aVar.m();
            TiePlusStat.StatType h2 = aVar.h();
            TiePlusStat.Locate locate = this.f48951f;
            TiePlusStat.c(m, h2, locate, str3, str2, str, aVar.g(locate));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f48954i);
            MessageManager.getInstance().unRegisterListener(this.f48955j);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f48954i);
            MessageManager.getInstance().registerListener(this.f48955j);
        }
    }
}
