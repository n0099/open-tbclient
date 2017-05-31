package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.v<DataRes> {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(o oVar) {
        this.this$0 = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: aja */
    public DataRes doInBackground() {
        com.baidu.adp.lib.cache.o<byte[]> L = com.baidu.tbadk.core.c.a.sY().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
        if (L == null) {
            return null;
        }
        byte[] bArr = L.get("0");
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
        } catch (IOException e) {
            BdLog.e(e);
            return null;
        }
    }
}
