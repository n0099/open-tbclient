package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ DataRes.Builder cGf;
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(m mVar, DataRes.Builder builder) {
        this.this$0 = mVar;
        this.cGf = builder;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        try {
            com.baidu.tbadk.core.b.a.ti().M("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", this.cGf.build(true).toByteArray());
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
