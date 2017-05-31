package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.util.v<Object> {
    private final /* synthetic */ DataRes.Builder cBB;
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(o oVar, DataRes.Builder builder) {
        this.this$0 = oVar;
        this.cBB = builder;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        try {
            com.baidu.tbadk.core.c.a.sY().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", this.cBB.build(true).toByteArray());
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
