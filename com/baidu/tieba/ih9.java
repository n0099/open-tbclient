package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.p05;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.z18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ih9 extends p05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity c;
    public boolean d;

    /* loaded from: classes4.dex */
    public class a implements z18.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p05.a a;
        public final /* synthetic */ ih9 b;

        public a(ih9 ih9Var, p05.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ih9Var;
            this.a = aVar;
        }

        @Override // com.baidu.tieba.z18.e
        public void a() {
            p05.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.a) != null) {
                aVar.a(false);
            }
        }

        @Override // com.baidu.tieba.z18.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!z18.n(this.b.c).k(this.b.c.B.intValue(), 2)) {
                    p05.a aVar = this.a;
                    if (aVar != null) {
                        aVar.a(false);
                        return;
                    }
                    return;
                }
                p05.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements z18.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih9 a;

        public b(ih9 ih9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ih9Var;
        }

        @Override // com.baidu.tieba.z18.f
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w05.r("insertAd");
                this.a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih9 a;

        public c(ih9 ih9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ih9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!z18.n(this.a.c).H(this.a.c.B.intValue(), 2)) {
                    this.a.c();
                } else {
                    w05.l("insertAd");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih9(TbPageContext tbPageContext, se9 se9Var, MainTabActivity mainTabActivity, boolean z) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, se9Var, mainTabActivity, Boolean.valueOf(z)};
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

    @Override // com.baidu.tieba.p05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z18.n(this.c).l();
        }
    }

    @Override // com.baidu.tieba.p05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z18.n(this.c).E(new b(this));
            jg.a().postDelayed(new c(this), 400L);
        }
    }

    @Override // com.baidu.tieba.p05
    public void d(p05.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (w05.i() && aVar != null) {
                aVar.a(false);
            } else if (!z18.m && ((TbSingleton.getInstance().isCanShowHotSplash || z18.m || TbSingleton.getInstance().mIsSplashClick) && !this.d)) {
                if (aVar != null) {
                    aVar.a(false);
                }
            } else {
                z18 n = z18.n(this.c);
                if (z18.m) {
                    str = "1";
                } else {
                    str = "2";
                }
                if (!n.B(str, this.c.B.intValue(), 2, this.c.K, new a(this, aVar), false) && aVar != null) {
                    aVar.a(false);
                }
            }
        }
    }
}
