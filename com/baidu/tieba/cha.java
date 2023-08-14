package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tieba.b55;
import com.baidu.tieba.kw8;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cha extends b55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements kw8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b55.a a;
        public final /* synthetic */ cha b;

        public a(cha chaVar, b55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chaVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = chaVar;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.kw8.e
        public void a() {
            b55.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.a) != null) {
                aVar.callback(false);
            }
        }

        @Override // com.baidu.tieba.kw8.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!kw8.n(this.b.c).k(this.b.c.z.intValue(), 2)) {
                    b55.a aVar = this.a;
                    if (aVar != null) {
                        aVar.callback(false);
                        return;
                    }
                    return;
                }
                b55.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.callback(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kw8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cha a;

        public b(cha chaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chaVar;
        }

        @Override // com.baidu.tieba.kw8.f
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
        public final /* synthetic */ cha a;

        public c(cha chaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!kw8.n(this.a.c).H(this.a.c.z.intValue(), 2)) {
                    this.a.c();
                } else {
                    YunDialogManager.markShowingDialogName("insertAd");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cha(TbPageContext tbPageContext, iea ieaVar, MainTabActivity mainTabActivity, boolean z) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ieaVar, mainTabActivity, Boolean.valueOf(z)};
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

    @Override // com.baidu.tieba.b55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kw8.n(this.c).l();
        }
    }

    @Override // com.baidu.tieba.b55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            kw8.n(this.c).E(new b(this));
            SafeHandler.getInst().postDelayed(new c(this), 400L);
        }
    }

    @Override // com.baidu.tieba.b55
    public void d(b55.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog() && aVar != null) {
                aVar.callback(false);
            } else if (!kw8.m && ((TbSingleton.getInstance().isCanShowHotSplash || kw8.m || TbSingleton.getInstance().mIsSplashClick) && !this.d)) {
                if (aVar != null) {
                    aVar.callback(false);
                }
            } else {
                kw8 n = kw8.n(this.c);
                if (kw8.m) {
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
