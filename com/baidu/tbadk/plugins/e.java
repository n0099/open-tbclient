package com.baidu.tbadk.plugins;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aAl;
    private final /* synthetic */ String aAm;
    private final /* synthetic */ String aAn;
    private final /* synthetic */ String aAo;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, String str3, String str4, String str5) {
        this.aAl = str;
        this.aAm = str2;
        this.aAn = str3;
        this.val$url = str4;
        this.aAo = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String buildEventJSON;
        v vVar = new v(XiaoyingUtil.URL_EVENT_REPORT);
        vVar.o("from", "BaiduTieba");
        vVar.o("eventid", "XYTiebaShare");
        buildEventJSON = XiaoyingUtil.buildEventJSON(this.aAl, this.aAm, this.aAn, this.val$url, this.aAo);
        vVar.o("userjson", buildEventJSON);
        vVar.tI();
        return null;
    }
}
