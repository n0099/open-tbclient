package com.baidu.tbadk.message.http;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class TbHttpResponsedMessage extends HttpResponsedMessage {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$adp$lib$util$BdNetUtil$NetworkStateInfo;

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$adp$lib$util$BdNetUtil$NetworkStateInfo() {
        int[] iArr = $SWITCH_TABLE$com$baidu$adp$lib$util$BdNetUtil$NetworkStateInfo;
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
            $SWITCH_TABLE$com$baidu$adp$lib$util$BdNetUtil$NetworkStateInfo = iArr;
        }
        return iArr;
    }

    public TbHttpResponsedMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
    }

    private int getMode(BdNetUtil.NetworkStateInfo networkStateInfo) {
        switch ($SWITCH_TABLE$com$baidu$adp$lib$util$BdNetUtil$NetworkStateInfo()[networkStateInfo.ordinal()]) {
            case 2:
            default:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
        }
    }

    @Override // com.baidu.adp.framework.message.HttpResponsedMessage
    public void logStatInBackground(int i, e eVar) {
        if (eVar.c().size() > 0) {
            d dVar = eVar.c().get(eVar.c().size() - 1);
            an.a.addAndGet(eVar.c().size() - 1);
            ao aoVar = new ao();
            aoVar.e = getMode(BdNetUtil.getStatusInfo());
            aoVar.c = dVar.b;
            aoVar.b = dVar.f;
            aoVar.d = dVar.e;
            aoVar.a = eVar.a().a() == HttpMessageTask.HTTP_METHOD.POST ? 1 : 2;
            an.a(aoVar);
        }
    }
}
