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
/* loaded from: classes4.dex */
public class fg {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public ig a;
    public eg b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448304396, "Lcom/baidu/tieba/fg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448304396, "Lcom/baidu/tieba/fg;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public fg(ig igVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {igVar};
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
        this.a = igVar;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                if (this.a != null && i > 0) {
                    this.a.b().a("Retry-Count", String.valueOf(i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        eg egVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (egVar = this.b) != null) {
            egVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            eg egVar = this.b;
            if (egVar == null) {
                return -1L;
            }
            return egVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            eg egVar = this.b;
            if (egVar == null) {
                return -1L;
            }
            return egVar.h();
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
            eg egVar = this.b;
            if (egVar == null) {
                return -1L;
            }
            return egVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            eg egVar = this.b;
            if (egVar == null) {
                return -1L;
            }
            return egVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            eg egVar = this.b;
            if (egVar == null) {
                return -1L;
            }
            return egVar.j();
        }
        return invokeV.longValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ig igVar = this.a;
            if (igVar == null) {
                return false;
            }
            return igVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        ig igVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (igVar = this.a) == null) {
            return;
        }
        igVar.c().a = true;
    }

    public boolean c(String str, mg mgVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        hg hgVar;
        int i8;
        int i9;
        String str2;
        int i10;
        hg hgVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        hg hgVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, mgVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            if (i3 <= 0) {
                i5 = zb.d().b().b();
            } else {
                i5 = i3;
            }
            if (i <= 0) {
                i6 = zb.d().a();
            } else {
                i6 = i;
            }
            if (i4 <= 0) {
                i7 = zb.d().c().b();
            } else {
                i7 = i4;
            }
            eg egVar = new eg(this.a);
            this.b = egVar;
            egVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                hg hgVar4 = new hg();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        hgVar4.e = i12;
                        try {
                            this.c = i11;
                            a(i11);
                            str2 = str4;
                            i10 = i12;
                            i8 = i11;
                            i9 = i6;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i10 = i12;
                            hgVar2 = hgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            hgVar2 = hgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            hgVar2 = hgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            hgVar2 = hgVar4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        hgVar2 = hgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        hgVar2 = hgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        hgVar2 = hgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        hgVar2 = hgVar4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    hgVar2 = hgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    hgVar = hgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    hgVar = hgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    hgVar = hgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    hgVar = hgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    hgVar = hgVar4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, mgVar, i5, i7, z, hgVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        hgVar3 = hgVar4;
                        sb3.append(hgVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar3.h = sb3.toString();
                    } else {
                        hgVar3 = hgVar4;
                    }
                    this.a.e(hgVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    hgVar2 = hgVar4;
                    StringBuilder sb4 = new StringBuilder();
                    str3 = str2;
                    sb4.append(str3);
                    sb4.append(String.valueOf(this.a.c().b));
                    sb4.append("|retryCount:");
                    sb4.append(i8);
                    sb4.append("|");
                    sb4.append(e.getClass().getName());
                    sb4.append("|");
                    sb4.append(e.getMessage());
                    hgVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(hgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar2.h = sb2.toString();
                    }
                    this.a.e(hgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    hgVar2 = hgVar4;
                    str3 = str2;
                    hgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(hgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar2.h = sb2.toString();
                    }
                    this.a.e(hgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    hgVar2 = hgVar4;
                    str3 = str2;
                    hgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(hgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar2.h = sb2.toString();
                    }
                    this.a.e(hgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    hgVar2 = hgVar4;
                    str3 = str2;
                    hgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(hgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar2.h = sb2.toString();
                    }
                    this.a.e(hgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    hgVar2 = hgVar4;
                    str3 = str2;
                    hgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(hgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar2.h = sb2.toString();
                    }
                    this.a.e(hgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    hgVar = hgVar4;
                    hgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(hgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar.h = sb.toString();
                    }
                    this.a.e(hgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    hgVar = hgVar4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        hgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(hgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar.h = sb.toString();
                    }
                    this.a.e(hgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    hgVar = hgVar4;
                    hgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(hgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        hgVar.h = sb.toString();
                    }
                    this.a.e(hgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    hgVar = hgVar4;
                    try {
                        hgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(hgVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            hgVar.h = sb.toString();
                        }
                        this.a.e(hgVar);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            hgVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(hgVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    hgVar = hgVar4;
                    if (!z3) {
                        hgVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(hgVar);
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
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        pg pgVar;
        hg hgVar;
        int i9;
        eg egVar;
        eg egVar2;
        eg egVar3;
        eg egVar4;
        boolean z3;
        boolean z4;
        eg egVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = zb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = zb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = zb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((cg) ServiceManager.getService(cg.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((dg) ServiceManager.getService(dg.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            int i11 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i11 < i5 + i8) {
                hg hgVar2 = new hg();
                this.a.e(hgVar2);
                pg pgVar2 = new pg();
                jg b = this.a.b();
                if (i11 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                pgVar2.a = b.k(z);
                if (i11 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pgVar2.d = z2;
                try {
                    this.c = i11;
                    hgVar2.e = i11 + 1;
                    hgVar2.v = i10;
                    a(i11);
                    eg egVar6 = new eg(this.a);
                    this.b = egVar6;
                    egVar6.q(i11);
                    this.b.r(e);
                    eg egVar7 = this.b;
                    if (i11 < i8) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (i11 < i10) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i9 = i11;
                    try {
                        egVar7.k(z3, z4, i4, i6, hgVar2, pgVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                    } catch (IOException e4) {
                        e = e4;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                    } catch (Exception e5) {
                        e = e5;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                    } catch (Throwable th) {
                        th = th;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i9 = i11;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i9 = i11;
                } catch (IOException e8) {
                    e = e8;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i9 = i11;
                } catch (Exception e9) {
                    e = e9;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i9 = i11;
                } catch (Throwable th2) {
                    th = th2;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                }
                if (this.a.c().b != 200) {
                    hgVar = hgVar2;
                    try {
                        hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9;
                        z5 = l(this.a.c().b);
                        pgVar = pgVar2;
                        try {
                            try {
                                try {
                                    pgVar.b = this.a.c().b;
                                    pgVar.c = "faild";
                                    if (this.d <= 0 && (egVar5 = this.b) != null) {
                                        this.d = egVar5.i();
                                    }
                                    hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(hgVar);
                                    pgVar.a();
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (this.d <= 0 && (egVar3 = this.b) != null) {
                                    this.d = egVar3.i();
                                }
                                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(hgVar);
                                pgVar.a();
                                throw th;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            pgVar.b = -12;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(hgVar);
                            pgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            pgVar.b = -13;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(hgVar);
                            pgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            hgVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            pgVar.b = -19;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = egVar.i();
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(hgVar);
                            pgVar.a();
                            i11 = i9 + 1;
                            i10 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        pgVar = pgVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        pgVar = pgVar2;
                    } catch (IOException e16) {
                        e = e16;
                        pgVar = pgVar2;
                    } catch (Exception e17) {
                        e = e17;
                        pgVar = pgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        pgVar = pgVar2;
                        if (this.d <= 0) {
                            this.d = egVar3.i();
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(hgVar);
                        pgVar.a();
                        throw th;
                    }
                    i11 = i9 + 1;
                    i10 = 1;
                } else {
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    this.a.f(hgVar);
                    try {
                        pgVar.b = 0;
                        pgVar.c = "ok";
                        if (this.d <= 0) {
                            egVar4 = this.b;
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(hgVar);
                        pgVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        pgVar.b = -12;
                        pgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            egVar2 = this.b;
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(hgVar);
                        pgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        pgVar.b = -13;
                        pgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            egVar2 = this.b;
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(hgVar);
                        pgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        hgVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        pgVar.b = -19;
                        pgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (egVar = this.b) != null) {
                            this.d = egVar.i();
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(hgVar);
                        pgVar.a();
                        i11 = i9 + 1;
                        i10 = 1;
                    }
                }
                e = e10;
                hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                pgVar.b = -10;
                pgVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    egVar4 = this.b;
                }
                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(hgVar);
                pgVar.a();
                return;
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
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        pg pgVar;
        hg hgVar;
        int i10;
        int i11;
        int i12;
        int i13;
        eg egVar;
        eg egVar2;
        boolean z3;
        eg egVar3;
        boolean z4;
        boolean z5;
        eg egVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = zb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = zb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = zb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((cg) ServiceManager.getService(cg.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((dg) ServiceManager.getService(dg.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                hg hgVar2 = new hg();
                pg pgVar2 = new pg();
                jg b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                pgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pgVar2.d = z2;
                this.c = i15;
                int i16 = i15 + 1;
                hgVar2.e = i16;
                a(i15);
                try {
                    try {
                        try {
                            eg egVar5 = new eg(this.a);
                            this.b = egVar5;
                            egVar5.q(i15);
                            this.b.r(e);
                            eg egVar6 = this.b;
                            if (i15 < i8) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i15 < i14) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i9 = i16;
                            i12 = i15;
                            try {
                                egVar6.p(z4, z5, i4, i6, hgVar2, pgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (Throwable th) {
                                th = th;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0c68;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0c68;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0c68;
                }
                if (this.a.c().b != 200) {
                    hgVar = hgVar2;
                    try {
                        hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(hgVar);
                        pgVar = pgVar2;
                        try {
                            try {
                                pgVar.b = this.a.c().b;
                                pgVar.c = "faild";
                                if (this.d <= 0 && (egVar4 = this.b) != null) {
                                    this.d = egVar4.i();
                                }
                                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(hgVar);
                                pgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0c68;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                kg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(hgVar);
                                pgVar.b = -14;
                                pgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    egVar3 = this.b;
                                }
                                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(hgVar);
                                pgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    kg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                                    BdLog.e(th.getMessage());
                                    this.a.e(hgVar);
                                    pgVar.b = -10;
                                    pgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        egVar3 = this.b;
                                    }
                                    hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(hgVar);
                                    pgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (egVar2 = this.b) != null) {
                                        this.d = egVar2.i();
                                    }
                                    hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(hgVar);
                                    pgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0c68;
                            this.a.c().c = -12;
                            kg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(hgVar);
                            pgVar.b = -12;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                egVar = this.b;
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(hgVar);
                            pgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0c68;
                            this.a.c().c = -13;
                            kg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(hgVar);
                            pgVar.b = -13;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                egVar = this.b;
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(hgVar);
                            pgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        pgVar = pgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        pgVar = pgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        pgVar = pgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        pgVar = pgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    try {
                        pgVar.b = 0;
                        pgVar.c = "ok";
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0c68;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        kg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(hgVar);
                        pgVar.b = -14;
                        pgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(hgVar);
                        pgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        kg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                        BdLog.e(th.getMessage());
                        this.a.e(hgVar);
                        pgVar.b = -10;
                        pgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(hgVar);
                        pgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
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
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        pg pgVar;
        hg hgVar;
        int i10;
        int i11;
        int i12;
        int i13;
        eg egVar;
        eg egVar2;
        boolean z3;
        eg egVar3;
        boolean z4;
        boolean z5;
        eg egVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = zb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = zb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = zb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((cg) ServiceManager.getService(cg.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((dg) ServiceManager.getService(dg.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                hg hgVar2 = new hg();
                pg pgVar2 = new pg();
                jg b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                pgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pgVar2.d = z2;
                int i16 = i15 + 1;
                hgVar2.e = i16;
                this.c = i15;
                a(i15);
                try {
                    try {
                        try {
                            eg egVar5 = new eg(this.a);
                            this.b = egVar5;
                            egVar5.q(i15);
                            this.b.r(e);
                            eg egVar6 = this.b;
                            if (i15 < i8) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i15 < i14) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i9 = i16;
                            i12 = i15;
                            try {
                                egVar6.o(z4, z5, i4, i6, hgVar2, pgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            } catch (Throwable th) {
                                th = th;
                                pgVar = pgVar2;
                                hgVar = hgVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            pgVar = pgVar2;
                            hgVar = hgVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        pgVar = pgVar2;
                        hgVar = hgVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0c68;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0c68;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0c68;
                }
                if (this.a.c().b != 200) {
                    hgVar = hgVar2;
                    try {
                        hgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(hgVar);
                        pgVar = pgVar2;
                        try {
                            try {
                                pgVar.b = this.a.c().b;
                                pgVar.c = "faild";
                                if (this.d <= 0 && (egVar4 = this.b) != null) {
                                    this.d = egVar4.i();
                                }
                                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(hgVar);
                                pgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0c68;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                kg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(hgVar);
                                pgVar.b = -14;
                                pgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    egVar3 = this.b;
                                }
                                hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(hgVar);
                                pgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    kg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                                    BdLog.e(th.getMessage());
                                    this.a.e(hgVar);
                                    pgVar.b = -10;
                                    pgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        egVar3 = this.b;
                                    }
                                    hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(hgVar);
                                    pgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (egVar2 = this.b) != null) {
                                        this.d = egVar2.i();
                                    }
                                    hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(hgVar);
                                    pgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0c68;
                            this.a.c().c = -12;
                            kg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(hgVar);
                            pgVar.b = -12;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                egVar = this.b;
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(hgVar);
                            pgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0c68;
                            this.a.c().c = -13;
                            kg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(hgVar);
                            pgVar.b = -13;
                            pgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                egVar = this.b;
                            }
                            hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(hgVar);
                            pgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        pgVar = pgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        pgVar = pgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        pgVar = pgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        pgVar = pgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    pgVar = pgVar2;
                    hgVar = hgVar2;
                    try {
                        pgVar.b = 0;
                        pgVar.c = "ok";
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0c68;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        kg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(hgVar);
                        pgVar.b = -14;
                        pgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(hgVar);
                        pgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        kg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        hgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                        BdLog.e(th.getMessage());
                        this.a.e(hgVar);
                        pgVar.b = -10;
                        pgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        hgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(hgVar);
                        pgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    }
                }
            }
        }
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
}
