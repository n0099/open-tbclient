package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public int c;
    public BroadcastReceiver d;
    public dj0 e;

    /* loaded from: classes6.dex */
    public class a implements kj0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gj0 a;

        /* renamed from: com.baidu.tieba.gj0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0298a extends BroadcastReceiver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a this$1;

            public C0298a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = aVar;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction()) && NetUtil.a(hf0.b())) {
                    fj0.c().b();
                    try {
                        hf0.b().unregisterReceiver(this);
                    } catch (Exception unused) {
                    }
                    this.this$1.a.d = null;
                }
            }
        }

        public a(gj0 gj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gj0Var;
        }

        @Override // com.baidu.tieba.kj0
        public void a(ADConfigError aDConfigError) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aDConfigError) == null) && this.a.e != null && !this.a.e.j() && aDConfigError != null && !TextUtils.isEmpty(aDConfigError.reason)) {
                if (NetUtil.a(hf0.b())) {
                    fj0.c().b();
                } else if (this.a.d == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                    this.a.d = new C0298a(this);
                    hf0.b().registerReceiver(this.a.d, intentFilter);
                }
            }
        }
    }

    public gj0(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.c = i2;
        this.b = z;
    }

    public void d() {
        dj0 dj0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dj0Var = this.e) != null) {
            dj0Var.m(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dj0 dj0Var = new dj0(this.a, this.b, this.c);
            this.e = dj0Var;
            dj0Var.m(new a(this));
            e01.c(this.e, "adc_async_request", 0);
        }
    }
}
