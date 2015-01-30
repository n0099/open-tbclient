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
    final /* synthetic */ d ahL;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.c ahM;

    public f(d dVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar) {
        this.ahL = dVar;
        this.ahM = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public PluginNetConfigInfos doInBackground(Void... voidArr) {
        String str;
        SystemClock.sleep(1500L);
        if (this.ahM == null) {
            return null;
        }
        String str2 = "";
        if (this.ahM.ir() != null && this.ahM.ir().size() > 0) {
            StringBuilder sb = new StringBuilder(50);
            int size = this.ahM.ir().size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                BasicNameValuePair basicNameValuePair = this.ahM.ir().get(i);
                if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                    sb.append(basicNameValuePair.getName());
                    sb.append(":");
                    sb.append(basicNameValuePair.getValue());
                }
            }
            str2 = sb.toString();
        }
        str = d.ahI;
        this.AR = new ad(str);
        this.AR.o("plugin_upload_config", str2);
        return PluginNetConfigInfos.parse(this.AR.oy());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(PluginNetConfigInfos pluginNetConfigInfos) {
        com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar;
        this.ahL.ahK = false;
        boolean z = pluginNetConfigInfos != null;
        aVar = this.ahL.ahJ;
        aVar.a(z, pluginNetConfigInfos);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ahL.ahK = false;
        this.AR.dJ();
        this.AR = null;
    }
}
