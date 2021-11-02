package com.baidu.tbadk.widget.tiejia;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import b.a.q0.d1.p0;
import b.a.q0.s.q.d2;
import b.a.q0.u.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.ItemData;
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
/* loaded from: classes8.dex */
public class TiePlusEventController implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Context f46471e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TiePlusStat.Locate f46472f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final List<WeakReference<d>> f46473g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final p0 f46474h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f46475i;
    public CustomMessageListener j;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f46476a;

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
            this.f46476a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.q0.f1.p.a)) {
                b.a.q0.f1.p.a aVar = (b.a.q0.f1.p.a) customResponsedMessage.getData();
                this.f46476a.g(aVar);
                this.f46476a.e(aVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f46477a;

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
            this.f46477a = tiePlusEventController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Iterator it = this.f46477a.f46473g.iterator();
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

    /* loaded from: classes8.dex */
    public class c implements TiePlusDownloadDialog.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.f1.p.a f46478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TiePlusEventController f46480c;

        public c(TiePlusEventController tiePlusEventController, b.a.q0.f1.p.a aVar, String str) {
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
            this.f46480c = tiePlusEventController;
            this.f46478a = aVar;
            this.f46479b = str;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_CLICK, this.f46480c.f46472f, this.f46478a.j(), TiePlusStat.RichTextType.LINK, this.f46478a.k(), this.f46478a.e(), this.f46478a.d(), this.f46479b);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f46473g = new ArrayList();
        this.f46475i = new a(this, 2001454);
        this.j = new b(this, 2001455);
        this.f46471e = context;
        this.f46472f = locate;
        this.f46474h = new p0(context);
    }

    public static void onEvent(@NonNull b.a.q0.f1.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001454, aVar));
        }
    }

    public static void tryExposeTiePlusLinkEvent(@Nullable List<b.a.q0.f1.p.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list) == null) || list == null) {
            return;
        }
        for (b.a.q0.f1.p.a aVar : list) {
            aVar.n(TiePlusStat.StatType.EXPOSE);
            onEvent(aVar);
        }
    }

    public void addEventAckedCallbackWeaked(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f46473g.add(new WeakReference<>(dVar));
        }
    }

    public final void e(@NonNull b.a.q0.f1.p.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar.h() == TiePlusStat.StatType.CLICK) {
            TiePlusStat.Locate locate = this.f46472f;
            if (locate == TiePlusStat.Locate.PB || locate == TiePlusStat.Locate.PB_COMMENT) {
                f();
            }
            TiePlusStat.LandingType f2 = aVar.f();
            TiebaPlusInfo l = aVar.l();
            if (f2 == TiePlusStat.LandingType.H5) {
                this.f46474h.h(l.jump_url, l.h5_jump_type.intValue());
            } else if (f2 == TiePlusStat.LandingType.WECHAT) {
                this.f46474h.h(l.h5_jump_number, l.jump_type.intValue());
            } else if (f2 == TiePlusStat.LandingType.WECHAT_MINIAPP) {
                this.f46474h.i(l.h5_jump_number, l.jump_type.intValue(), l.h5_jump_param);
            } else if (f2 == TiePlusStat.LandingType.DIALOG_DOWNLOAD) {
                p0 p0Var = this.f46474h;
                p0Var.t(l.app_id);
                p0Var.w(l.download_url);
                p0Var.z(l.app_package);
                p0Var.A(l.app_power);
                p0Var.B(l.app_privacy);
                String str = (aVar.i() == null || !aVar.i().R2) ? "" : aVar.i().S2;
                TiePlusDownloadDialog tiePlusDownloadDialog = new TiePlusDownloadDialog(this.f46471e, this.f46474h, true);
                this.f46474h.v(tiePlusDownloadDialog);
                ItemData itemData = new ItemData();
                itemData.parseProto(l);
                this.f46474h.y(itemData);
                this.f46474h.f(new m(TiePlusStat.StatType.DOWNLOAD_FINISHED, TiePlusStat.RichTextType.LINK, aVar.k(), str, l.app_package));
                tiePlusDownloadDialog.setAppCompany(l.app_company).setAppIcon(l.app_icon).setAppTitle(l.title).setAppVersion(l.app_version).setDownloadClickCallback(new c(this, aVar, str));
                tiePlusDownloadDialog.show();
                TiePlusStat.d(TiePlusStat.StatType.DIALOG_EXPOSE, this.f46472f, aVar.j(), TiePlusStat.RichTextType.LINK, aVar.k(), aVar.e(), aVar.d(), str);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001455));
        }
    }

    public final void g(@NonNull b.a.q0.f1.p.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            d2 i2 = aVar.i();
            String str3 = "";
            if (i2.R2) {
                str3 = i2.S2;
                str2 = i2.T2;
                str = i2.U2;
            } else {
                str = "";
                str2 = str;
            }
            TiePlusStat.b(aVar.m(), aVar.h(), this.f46472f, aVar.j(), TiePlusStat.RichTextType.LINK, aVar.l().target_type.intValue(), aVar.f(), aVar.k(), aVar.e(), aVar.d(), str3, null);
            int m = aVar.m();
            TiePlusStat.StatType h2 = aVar.h();
            TiePlusStat.Locate locate = this.f46472f;
            TiePlusStat.c(m, h2, locate, str3, str2, str, aVar.g(locate));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f46475i);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f46475i);
            MessageManager.getInstance().registerListener(this.j);
        }
    }
}
