package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.t<DataRes> {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.this$0 = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: amz */
    public DataRes doInBackground() {
        com.baidu.adp.lib.cache.o<byte[]> M = com.baidu.tbadk.core.b.a.sT().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
        if (M == null) {
            return null;
        }
        byte[] bArr = M.get("0");
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
