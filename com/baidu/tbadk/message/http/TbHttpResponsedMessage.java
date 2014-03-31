package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.core.log.a;
import com.baidu.tbadk.core.log.j;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    private static /* synthetic */ int[] a;

    private static /* synthetic */ int[] i() {
        int[] iArr = a;
        if (iArr == null) {
            iArr = new int[BdNetUtil.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[BdNetUtil.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[BdNetUtil.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            a = iArr;
        }
        return iArr;
    }

    public TbHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.c
    public void a(int i, byte[] bArr) {
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x009a: IGET  (r5v4 long A[REMOVE]) = (r4v3 com.baidu.tbadk.core.util.au) com.baidu.tbadk.core.util.au.b long)] */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage
    public void a(int i, e eVar) {
        int i2;
        if (eVar.c().size() > 0) {
            d dVar = eVar.c().get(eVar.c().size() - 1);
            at.a.addAndGet(eVar.c().size() - 1);
            au auVar = new au();
            switch (i()[BdNetUtil.a().ordinal()]) {
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                    i2 = 3;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            auVar.e = i2;
            auVar.c = dVar.b;
            auVar.b = dVar.f;
            auVar.d = dVar.e;
            auVar.a = eVar.a().a() != HttpMessageTask.HTTP_METHOD.POST ? 2 : 1;
            at.a(auVar);
            if (eVar.a().a() == HttpMessageTask.HTTP_METHOD.GET && auVar.b > 5000) {
                a.a(j.a(eVar.a().b().toString(), new StringBuilder().append(auVar.b).toString(), String.valueOf(auVar.c) + " |DNS Time" + dVar.g + "|ConnectTime" + dVar.c + "|current ip" + UtilHelper.b(UtilHelper.a(eVar.a().b())), "old network download OK, retryCount:" + auVar.d, ""));
            }
        }
    }
}
