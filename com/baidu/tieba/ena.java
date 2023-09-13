package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.n55;
import com.baidu.tieba.p19;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ena extends n55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements p19.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n55.a a;
        public final /* synthetic */ ena b;

        public a(ena enaVar, n55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enaVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = enaVar;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.p19.e
        public void a() {
            n55.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.a) != null) {
                aVar.callback(false);
            }
        }

        @Override // com.baidu.tieba.p19.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!p19.n(this.b.c).k(this.b.c.z.intValue(), 2)) {
                    n55.a aVar = this.a;
                    if (aVar != null) {
                        aVar.callback(false);
                        return;
                    }
                    return;
                }
                n55.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.callback(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements p19.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ena a;

        public b(ena enaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enaVar;
        }

        @Override // com.baidu.tieba.p19.f
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.unMarkShowingDialogName("insertAd");
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ena a;

        public c(ena enaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!p19.n(this.a.c).H(this.a.c.z.intValue(), 2)) {
                    this.a.c();
                } else {
                    YunDialogManager.markShowingDialogName("insertAd");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ena(TbPageContext tbPageContext, kka kkaVar, MainTabActivity mainTabActivity, boolean z) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kkaVar, mainTabActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = z;
    }

    @Override // com.baidu.tieba.n55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p19.n(this.c).l();
        }
    }

    @Override // com.baidu.tieba.n55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p19.n(this.c).E(new b(this));
            SafeHandler.getInst().postDelayed(new c(this), 400L);
        }
    }

    @Override // com.baidu.tieba.n55
    public void d(n55.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog() && aVar != null) {
                aVar.callback(false);
            } else if (!p19.m && ((TbSingleton.getInstance().isCanShowHotSplash || p19.m || TbSingleton.getInstance().mIsSplashClick) && !this.d)) {
                if (aVar != null) {
                    aVar.callback(false);
                }
            } else {
                p19 n = p19.n(this.c);
                if (p19.m) {
                    str = "1";
                } else {
                    str = "2";
                }
                if (!n.B(str, this.c.z.intValue(), 2, this.c.I, new a(this, aVar), false) && aVar != null) {
                    aVar.callback(false);
                }
            }
        }
    }
}
