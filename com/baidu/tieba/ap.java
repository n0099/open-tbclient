package com.baidu.tieba;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tieba.bp;
import com.baidu.tieba.zo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ap implements zo.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BDHttpDns.e a;
    public final BDHttpDns b;
    public final bp c;

    public ap(Context context, BDHttpDns.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
        BDHttpDns service = BDHttpDns.getService(context);
        this.b = service;
        this.c = service.getDnsCache();
    }

    @Override // com.baidu.tieba.zo.a
    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), arrayList, arrayList2, Long.valueOf(j), str}) == null) {
            if (i != -1) {
                if (i != 0) {
                    dp.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i));
                    return;
                }
                Object[] objArr = new Object[4];
                objArr[0] = str;
                String str3 = null;
                if (arrayList != null) {
                    str2 = arrayList.toString();
                } else {
                    str2 = null;
                }
                objArr[1] = str2;
                if (arrayList2 != null) {
                    str3 = arrayList2.toString();
                }
                objArr[2] = str3;
                objArr[3] = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS.toString();
                dp.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                bp.a aVar = new bp.a();
                aVar.i(60L);
                aVar.h(System.currentTimeMillis() / 1000);
                aVar.f(arrayList);
                aVar.g(arrayList2);
                this.c.e(str, aVar);
                BDHttpDns.e eVar = this.a;
                if (eVar != null) {
                    eVar.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2));
                    return;
                }
                return;
            }
            dp.a("Async resolve failed, host(%s), dns resolve failed", str);
            BDHttpDns.e eVar2 = this.a;
            if (eVar2 != null) {
                eVar2.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2));
            }
        }
    }
}
