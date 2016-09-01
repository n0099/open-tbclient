package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ DataRes.Builder cFg;
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar, DataRes.Builder builder) {
        this.this$0 = bVar;
        this.cFg = builder;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        try {
            com.baidu.tbadk.core.b.a.sT().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", this.cFg.build(true).toByteArray());
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
