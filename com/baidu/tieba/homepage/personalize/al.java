package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.util.w<Object> {
    private final /* synthetic */ DataRes.Builder cJy;
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(x xVar, DataRes.Builder builder) {
        this.this$0 = xVar;
        this.cJy = builder;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        e eVar;
        DataRes.Builder builder = new DataRes.Builder(this.cJy.build(true));
        eVar = this.this$0.cIT;
        eVar.be(builder.thread_list);
        try {
            com.baidu.tbadk.core.c.a.sW().L("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).k("0", builder.build(true).toByteArray());
            return null;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
