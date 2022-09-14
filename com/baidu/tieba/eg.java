package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes3.dex */
public class eg {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public hg a;
    public dg b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448303435, "Lcom/baidu/tieba/eg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448303435, "Lcom/baidu/tieba/eg;");
        }
    }

    public eg(hg hgVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hgVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 0L;
        this.a = hgVar;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                if (this.a == null || i <= 0) {
                    return;
                }
                this.a.b().a("Retry-Count", String.valueOf(i));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        dg dgVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dgVar = this.b) == null) {
            return;
        }
        dgVar.b();
    }

    public boolean c(String str, lg lgVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        gg ggVar;
        int i5;
        int i6;
        String str2;
        int i7;
        gg ggVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        gg ggVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, lgVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b = i3 <= 0 ? yb.d().b().b() : i3;
            int b2 = i4 <= 0 ? yb.d().c().b() : i4;
            dg dgVar = new dg(this.a);
            this.b = dgVar;
            dgVar.r(e);
            int i8 = 0;
            boolean z3 = false;
            for (int a = i <= 0 ? yb.d().a() : i; i8 < a; a = i6) {
                gg ggVar4 = new gg();
                this.a.c().c = -1;
                this.b.q(i8);
                int i9 = i8 + 1;
                try {
                    try {
                        ggVar4.e = i9;
                        try {
                            this.c = i8;
                            a(i8);
                            str2 = str4;
                            i7 = i9;
                            i5 = i8;
                            i6 = a;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i7 = i9;
                            ggVar2 = ggVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i7 = i9;
                            ggVar2 = ggVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i7 = i9;
                            ggVar2 = ggVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i7 = i9;
                            ggVar2 = ggVar4;
                            i5 = i8;
                            i6 = a;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i7 = i9;
                        ggVar2 = ggVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i7 = i9;
                        ggVar2 = ggVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i7 = i9;
                        ggVar2 = ggVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i7 = i9;
                        ggVar2 = ggVar4;
                        i5 = i8;
                        i6 = a;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i7 = i9;
                    ggVar2 = ggVar4;
                    i5 = i8;
                    i6 = a;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i7 = i9;
                    ggVar = ggVar4;
                    i5 = i8;
                    i6 = a;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i7 = i9;
                    ggVar = ggVar4;
                    i5 = i8;
                    i6 = a;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i7 = i9;
                    ggVar = ggVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i7 = i9;
                    ggVar = ggVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Throwable th) {
                    th = th;
                    ggVar = ggVar4;
                    i5 = i8;
                    i6 = a;
                }
                try {
                    z3 = this.b.d(str, lgVar, b, b2, z, ggVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (z3 || i5 != i6 - 1) {
                        ggVar3 = ggVar4;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        ggVar3 = ggVar4;
                        sb3.append(ggVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar3.h = sb3.toString();
                    }
                    this.a.e(ggVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    ggVar2 = ggVar4;
                    StringBuilder sb4 = new StringBuilder();
                    str3 = str2;
                    sb4.append(str3);
                    sb4.append(String.valueOf(this.a.c().b));
                    sb4.append("|retryCount:");
                    sb4.append(i5);
                    sb4.append("|");
                    sb4.append(e.getClass().getName());
                    sb4.append("|");
                    sb4.append(e.getMessage());
                    ggVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(ggVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar2.h = sb2.toString();
                    }
                    this.a.e(ggVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (IllegalStateException e16) {
                    e = e16;
                    ggVar2 = ggVar4;
                    str3 = str2;
                    ggVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(ggVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar2.h = sb2.toString();
                    }
                    this.a.e(ggVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (ConnectException e17) {
                    e = e17;
                    ggVar2 = ggVar4;
                    str3 = str2;
                    ggVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(ggVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar2.h = sb2.toString();
                    }
                    this.a.e(ggVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketException e18) {
                    e = e18;
                    ggVar2 = ggVar4;
                    str3 = str2;
                    ggVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(ggVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar2.h = sb2.toString();
                    }
                    this.a.e(ggVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    ggVar2 = ggVar4;
                    str3 = str2;
                    ggVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(ggVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar2.h = sb2.toString();
                    }
                    this.a.e(ggVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (UnknownHostException e20) {
                    e = e20;
                    ggVar = ggVar4;
                    ggVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(ggVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar.h = sb.toString();
                    }
                    this.a.e(ggVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (SSLException e21) {
                    e = e21;
                    ggVar = ggVar4;
                    if (this.a.b().e() && i5 < i6 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        ggVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(ggVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar.h = sb.toString();
                    }
                    this.a.e(ggVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (IOException e22) {
                    e = e22;
                    ggVar = ggVar4;
                    ggVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(ggVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        ggVar.h = sb.toString();
                    }
                    this.a.e(ggVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (Exception e23) {
                    e = e23;
                    ggVar = ggVar4;
                    try {
                        ggVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i5 == i6 - 1) {
                            sb = new StringBuilder();
                            sb.append(ggVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            ggVar.h = sb.toString();
                        }
                        this.a.e(ggVar);
                        str3 = str2;
                        str4 = str3;
                        i8 = i7;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i5 == i6 - 1) {
                            ggVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(ggVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ggVar = ggVar4;
                    if (!z3) {
                        ggVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(ggVar);
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0224, code lost:
        if (r0 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02e8, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0340, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0342, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0176, code lost:
        if (r0 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0178, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        og ogVar;
        gg ggVar;
        int i4;
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        dg dgVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? yb.d().b().b() : i2;
            int a = i <= 0 ? yb.d().a() : i;
            int b2 = i3 <= 0 ? yb.d().c().b() : i3;
            int i5 = ((cg) ServiceManager.getService(cg.a)).qaHttpsTest() ? 0 : ((bg) ServiceManager.getService(bg.a)).isSwitchOn() ? 2 : 0;
            long currentTimeMillis = System.currentTimeMillis();
            int i6 = 1;
            int i7 = 0;
            boolean z = true;
            while (!this.a.c().a && z && i7 < a + i5) {
                gg ggVar2 = new gg();
                this.a.e(ggVar2);
                og ogVar2 = new og();
                ogVar2.a = this.a.b().k(i7 < i5);
                ogVar2.d = i7 < i5;
                try {
                    this.c = i7;
                    ggVar2.e = i7 + 1;
                    ggVar2.v = i6;
                    a(i7);
                    dg dgVar6 = new dg(this.a);
                    this.b = dgVar6;
                    dgVar6.q(i7);
                    this.b.r(e);
                    i4 = i7;
                    try {
                        this.b.k(i7 < i5, i7 < i6, b, b2, ggVar2, ogVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                    } catch (IOException e4) {
                        e = e4;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                    } catch (Exception e5) {
                        e = e5;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                    } catch (Throwable th) {
                        th = th;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i4 = i7;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i4 = i7;
                } catch (IOException e8) {
                    e = e8;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i4 = i7;
                } catch (Exception e9) {
                    e = e9;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i4 = i7;
                } catch (Throwable th2) {
                    th = th2;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                }
                if (this.a.c().b != 200) {
                    ggVar = ggVar2;
                    try {
                        ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4;
                        z = l(this.a.c().b);
                        ogVar = ogVar2;
                        try {
                            try {
                                try {
                                    ogVar.b = this.a.c().b;
                                    ogVar.c = "faild";
                                    if (this.d <= 0 && (dgVar5 = this.b) != null) {
                                        this.d = dgVar5.i();
                                    }
                                    ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(ggVar);
                                    ogVar.a();
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (this.d <= 0 && (dgVar3 = this.b) != null) {
                                    this.d = dgVar3.i();
                                }
                                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(ggVar);
                                ogVar.a();
                                throw th;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            ogVar.b = -12;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ggVar);
                            ogVar.a();
                            z = true;
                            i7 = i4 + 1;
                            i6 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            ogVar.b = -13;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ggVar);
                            ogVar.a();
                            z = true;
                            i7 = i4 + 1;
                            i6 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            ggVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            ogVar.b = -19;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = dgVar.i();
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ggVar);
                            ogVar.a();
                            i7 = i4 + 1;
                            i6 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        ogVar = ogVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        ogVar = ogVar2;
                    } catch (IOException e16) {
                        e = e16;
                        ogVar = ogVar2;
                    } catch (Exception e17) {
                        e = e17;
                        ogVar = ogVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ogVar = ogVar2;
                        if (this.d <= 0) {
                            this.d = dgVar3.i();
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ggVar);
                        ogVar.a();
                        throw th;
                    }
                    i7 = i4 + 1;
                    i6 = 1;
                } else {
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    this.a.f(ggVar);
                    try {
                        ogVar.b = 0;
                        ogVar.c = "ok";
                        if (this.d <= 0) {
                            dgVar4 = this.b;
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ggVar);
                        ogVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        ogVar.b = -12;
                        ogVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            dgVar2 = this.b;
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ggVar);
                        ogVar.a();
                        z = true;
                        i7 = i4 + 1;
                        i6 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        ogVar.b = -13;
                        ogVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            dgVar2 = this.b;
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ggVar);
                        ogVar.a();
                        z = true;
                        i7 = i4 + 1;
                        i6 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        ggVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        ogVar.b = -19;
                        ogVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (dgVar = this.b) != null) {
                            this.d = dgVar.i();
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ggVar);
                        ogVar.a();
                        i7 = i4 + 1;
                        i6 = 1;
                    }
                }
                e = e10;
                ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                ogVar.b = -10;
                ogVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    dgVar4 = this.b;
                }
                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(ggVar);
                ogVar.a();
                return;
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            dg dgVar = this.b;
            if (dgVar == null) {
                return -1L;
            }
            return dgVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dg dgVar = this.b;
            if (dgVar == null) {
                return -1L;
            }
            return dgVar.h();
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = this.d;
            if (j > 0) {
                return j;
            }
            dg dgVar = this.b;
            if (dgVar == null) {
                return -1L;
            }
            return dgVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            dg dgVar = this.b;
            if (dgVar == null) {
                return -1L;
            }
            return dgVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            dg dgVar = this.b;
            if (dgVar == null) {
                return -1L;
            }
            return dgVar.j();
        }
        return invokeV.longValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            hg hgVar = this.a;
            if (hgVar == null) {
                return false;
            }
            return hgVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public void m(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            if (this.a.b().l()) {
                o(i, i2, i3);
            } else {
                n(i, i2, i3);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0240, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02a8, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02aa, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0327, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x038f, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0391, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        og ogVar;
        gg ggVar;
        int i5;
        int i6;
        int i7;
        int i8;
        dg dgVar;
        dg dgVar2;
        boolean z;
        dg dgVar3;
        dg dgVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? yb.d().b().b() : i2;
            int a = i <= 0 ? yb.d().a() : i;
            int b2 = i3 <= 0 ? yb.d().c().b() : i3;
            int i9 = ((cg) ServiceManager.getService(cg.a)).qaHttpsTest() ? 0 : ((bg) ServiceManager.getService(bg.a)).isSwitchOn() ? 2 : 0;
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            boolean z2 = true;
            int i11 = 0;
            while (!this.a.c().a && z2 && i11 < a + i9) {
                gg ggVar2 = new gg();
                og ogVar2 = new og();
                ogVar2.a = this.a.b().k(i11 < i9);
                ogVar2.d = i11 < i9;
                this.c = i11;
                int i12 = i11 + 1;
                ggVar2.e = i12;
                a(i11);
                try {
                    try {
                        try {
                            dg dgVar5 = new dg(this.a);
                            this.b = dgVar5;
                            dgVar5.q(i11);
                            this.b.r(e);
                            i4 = i12;
                            i7 = i11;
                            try {
                                this.b.p(i11 < i9, i11 < i10, b, b2, ggVar2, ogVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (Throwable th) {
                                th = th;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                            i7 = i11;
                        } catch (SocketException e6) {
                            e = e6;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = i12;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                        i7 = i11;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i7 = i11;
                    i8 = R.string.obfuscated_res_0x7f0f0c59;
                } catch (SocketException e9) {
                    e = e9;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i6 = R.string.obfuscated_res_0x7f0f0c59;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i5 = R.string.obfuscated_res_0x7f0f0c59;
                }
                if (this.a.c().b != 200) {
                    ggVar = ggVar2;
                    try {
                        ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7;
                        z2 = l(this.a.c().b);
                        this.a.e(ggVar);
                        ogVar = ogVar2;
                        try {
                            try {
                                ogVar.b = this.a.c().b;
                                ogVar.c = "faild";
                                if (this.d <= 0 && (dgVar4 = this.b) != null) {
                                    this.d = dgVar4.i();
                                }
                                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(ggVar);
                                ogVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i8 = R.string.obfuscated_res_0x7f0f0c59;
                                z = i7 >= i9;
                                this.a.c().c = -14;
                                jg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i8);
                                this.a.e(ggVar);
                                ogVar.b = -14;
                                ogVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    dgVar3 = this.b;
                                }
                                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(ggVar);
                                ogVar.a();
                                z2 = z;
                                i11 = i4;
                                i10 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    jg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    z = i7 >= i9;
                                    ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                                    BdLog.e(th.getMessage());
                                    this.a.e(ggVar);
                                    ogVar.b = -10;
                                    ogVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        dgVar3 = this.b;
                                    }
                                    ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(ggVar);
                                    ogVar.a();
                                    z2 = z;
                                    i11 = i4;
                                    i10 = 1;
                                } finally {
                                    if (this.d <= 0 && (dgVar2 = this.b) != null) {
                                        this.d = dgVar2.i();
                                    }
                                    ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(ggVar);
                                    ogVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i6 = R.string.obfuscated_res_0x7f0f0c59;
                            this.a.c().c = -12;
                            jg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i6);
                            BdLog.e(e.getMessage());
                            this.a.e(ggVar);
                            ogVar.b = -12;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                dgVar = this.b;
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ggVar);
                            ogVar.a();
                            z2 = true;
                            i11 = i4;
                            i10 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i5 = R.string.obfuscated_res_0x7f0f0c59;
                            this.a.c().c = -13;
                            jg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i5);
                            BdLog.e(e.getMessage());
                            this.a.e(ggVar);
                            ogVar.b = -13;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                dgVar = this.b;
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ggVar);
                            ogVar.a();
                            z2 = true;
                            i11 = i4;
                            i10 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ogVar = ogVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ogVar = ogVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ogVar = ogVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ogVar = ogVar2;
                    }
                    i11 = i4;
                    i10 = 1;
                } else {
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    try {
                        ogVar.b = 0;
                        ogVar.c = "ok";
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i8 = R.string.obfuscated_res_0x7f0f0c59;
                        if (i7 >= i9) {
                        }
                        this.a.c().c = -14;
                        jg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i8);
                        this.a.e(ggVar);
                        ogVar.b = -14;
                        ogVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ggVar);
                        ogVar.a();
                        z2 = z;
                        i11 = i4;
                        i10 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        jg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i7 >= i9) {
                        }
                        ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        BdLog.e(th.getMessage());
                        this.a.e(ggVar);
                        ogVar.b = -10;
                        ogVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ggVar);
                        ogVar.a();
                        z2 = z;
                        i11 = i4;
                        i10 = 1;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0240, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02a8, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02aa, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0327, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x038f, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0391, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        og ogVar;
        gg ggVar;
        int i5;
        int i6;
        int i7;
        int i8;
        dg dgVar;
        dg dgVar2;
        boolean z;
        dg dgVar3;
        dg dgVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? yb.d().b().b() : i2;
            int a = i <= 0 ? yb.d().a() : i;
            int b2 = i3 <= 0 ? yb.d().c().b() : i3;
            int i9 = ((cg) ServiceManager.getService(cg.a)).qaHttpsTest() ? 0 : ((bg) ServiceManager.getService(bg.a)).isSwitchOn() ? 2 : 0;
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            boolean z2 = true;
            int i11 = 0;
            while (!this.a.c().a && z2 && i11 < a + i9) {
                gg ggVar2 = new gg();
                og ogVar2 = new og();
                ogVar2.a = this.a.b().k(i11 < i9);
                ogVar2.d = i11 < i9;
                int i12 = i11 + 1;
                ggVar2.e = i12;
                this.c = i11;
                a(i11);
                try {
                    try {
                        try {
                            dg dgVar5 = new dg(this.a);
                            this.b = dgVar5;
                            dgVar5.q(i11);
                            this.b.r(e);
                            i4 = i12;
                            i7 = i11;
                            try {
                                this.b.o(i11 < i9, i11 < i10, b, b2, ggVar2, ogVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            } catch (Throwable th) {
                                th = th;
                                ogVar = ogVar2;
                                ggVar = ggVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                            i7 = i11;
                        } catch (SocketException e6) {
                            e = e6;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i4 = i12;
                            ogVar = ogVar2;
                            ggVar = ggVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = i12;
                        ogVar = ogVar2;
                        ggVar = ggVar2;
                        i7 = i11;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i7 = i11;
                    i8 = R.string.obfuscated_res_0x7f0f0c59;
                } catch (SocketException e9) {
                    e = e9;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i6 = R.string.obfuscated_res_0x7f0f0c59;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i4 = i12;
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    i5 = R.string.obfuscated_res_0x7f0f0c59;
                }
                if (this.a.c().b != 200) {
                    ggVar = ggVar2;
                    try {
                        ggVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7;
                        z2 = l(this.a.c().b);
                        this.a.e(ggVar);
                        ogVar = ogVar2;
                        try {
                            try {
                                ogVar.b = this.a.c().b;
                                ogVar.c = "faild";
                                if (this.d <= 0 && (dgVar4 = this.b) != null) {
                                    this.d = dgVar4.i();
                                }
                                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(ggVar);
                                ogVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i8 = R.string.obfuscated_res_0x7f0f0c59;
                                z = i7 >= i9;
                                this.a.c().c = -14;
                                jg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i8);
                                this.a.e(ggVar);
                                ogVar.b = -14;
                                ogVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    dgVar3 = this.b;
                                }
                                ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(ggVar);
                                ogVar.a();
                                z2 = z;
                                i11 = i4;
                                i10 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    jg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    z = i7 >= i9;
                                    ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                                    BdLog.e(th.getMessage());
                                    this.a.e(ggVar);
                                    ogVar.b = -10;
                                    ogVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        dgVar3 = this.b;
                                    }
                                    ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(ggVar);
                                    ogVar.a();
                                    z2 = z;
                                    i11 = i4;
                                    i10 = 1;
                                } finally {
                                    if (this.d <= 0 && (dgVar2 = this.b) != null) {
                                        this.d = dgVar2.i();
                                    }
                                    ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(ggVar);
                                    ogVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i6 = R.string.obfuscated_res_0x7f0f0c59;
                            this.a.c().c = -12;
                            jg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i6);
                            BdLog.e(e.getMessage());
                            this.a.e(ggVar);
                            ogVar.b = -12;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                dgVar = this.b;
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ggVar);
                            ogVar.a();
                            z2 = true;
                            i11 = i4;
                            i10 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i5 = R.string.obfuscated_res_0x7f0f0c59;
                            this.a.c().c = -13;
                            jg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i5);
                            BdLog.e(e.getMessage());
                            this.a.e(ggVar);
                            ogVar.b = -13;
                            ogVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                dgVar = this.b;
                            }
                            ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ggVar);
                            ogVar.a();
                            z2 = true;
                            i11 = i4;
                            i10 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ogVar = ogVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ogVar = ogVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ogVar = ogVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ogVar = ogVar2;
                    }
                    i11 = i4;
                    i10 = 1;
                } else {
                    ogVar = ogVar2;
                    ggVar = ggVar2;
                    try {
                        ogVar.b = 0;
                        ogVar.c = "ok";
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i8 = R.string.obfuscated_res_0x7f0f0c59;
                        if (i7 >= i9) {
                        }
                        this.a.c().c = -14;
                        jg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i8);
                        this.a.e(ggVar);
                        ogVar.b = -14;
                        ogVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ggVar);
                        ogVar.a();
                        z2 = z;
                        i11 = i4;
                        i10 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        jg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i7 >= i9) {
                        }
                        ggVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        BdLog.e(th.getMessage());
                        this.a.e(ggVar);
                        ogVar.b = -10;
                        ogVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        ggVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ggVar);
                        ogVar.a();
                        z2 = z;
                        i11 = i4;
                        i10 = 1;
                    }
                }
            }
        }
    }

    public void p() {
        hg hgVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (hgVar = this.a) == null) {
            return;
        }
        hgVar.c().a = true;
    }
}
