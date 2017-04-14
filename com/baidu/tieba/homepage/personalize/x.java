package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ DataRes.Builder cxI;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(n nVar, DataRes.Builder builder) {
        this.this$0 = nVar;
        this.cxI = builder;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        try {
            com.baidu.tbadk.core.c.a.tM().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", this.cxI.build(true).toByteArray());
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
