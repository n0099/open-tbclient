package com.baidu.tbadk.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.ad;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class f extends BdAsyncTask<Void, Void, PluginNetConfigInfos> {
    private ad AR;
    final /* synthetic */ d ahn;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.c aho;

    public f(d dVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar) {
        this.ahn = dVar;
        this.aho = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public PluginNetConfigInfos doInBackground(Void... voidArr) {
        String str;
        SystemClock.sleep(1500L);
        if (this.aho == null) {
            return null;
        }
        String str2 = "";
        if (this.aho.ir() != null && this.aho.ir().size() > 0) {
            StringBuilder sb = new StringBuilder(50);
            int size = this.aho.ir().size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                BasicNameValuePair basicNameValuePair = this.aho.ir().get(i);
                if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                    sb.append(basicNameValuePair.getName());
                    sb.append(":");
                    sb.append(basicNameValuePair.getValue());
                }
            }
            str2 = sb.toString();
        }
        str = d.ahk;
        this.AR = new ad(str);
        this.AR.o("plugin_upload_config", str2);
        return PluginNetConfigInfos.parse(this.AR.ov());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(PluginNetConfigInfos pluginNetConfigInfos) {
        com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar;
        this.ahn.ahm = false;
        boolean z = pluginNetConfigInfos != null;
        aVar = this.ahn.ahl;
        aVar.a(z, pluginNetConfigInfos);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ahn.ahm = false;
        this.AR.dL();
        this.AR = null;
    }
}
