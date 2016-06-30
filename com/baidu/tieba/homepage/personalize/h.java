package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.util.s<DataRes> {
    final /* synthetic */ a cqR;
    private final /* synthetic */ com.baidu.adp.lib.cache.o cqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, com.baidu.adp.lib.cache.o oVar) {
        this.cqR = aVar;
        this.cqS = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ahc */
    public DataRes doInBackground() {
        byte[] bArr = (byte[]) this.cqS.get("0");
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
