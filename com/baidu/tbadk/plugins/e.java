package com.baidu.tbadk.plugins;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String ayW;
    private final /* synthetic */ String ayX;
    private final /* synthetic */ String ayY;
    private final /* synthetic */ String ayZ;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, String str3, String str4, String str5) {
        this.ayW = str;
        this.ayX = str2;
        this.ayY = str3;
        this.val$url = str4;
        this.ayZ = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String buildEventJSON;
        w wVar = new w(XiaoyingUtil.URL_EVENT_REPORT);
        wVar.o("from", "BaiduTieba");
        wVar.o("eventid", "XYTiebaShare");
        buildEventJSON = XiaoyingUtil.buildEventJSON(this.ayW, this.ayX, this.ayY, this.val$url, this.ayZ);
        wVar.o("userjson", buildEventJSON);
        wVar.tG();
        return null;
    }
}
