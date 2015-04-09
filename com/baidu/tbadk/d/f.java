package com.baidu.tbadk.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.util.aa;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
class f extends BdAsyncTask<Void, Void, PluginNetConfigInfos> {
    private aa Ok;
    final /* synthetic */ d aqv;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.c aqw;

    public f(d dVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar) {
        this.aqv = dVar;
        this.aqw = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public PluginNetConfigInfos doInBackground(Void... voidArr) {
        String str;
        SystemClock.sleep(1500L);
        if (this.aqw == null) {
            return null;
        }
        String str2 = "";
        if (this.aqw.lI() != null && this.aqw.lI().size() > 0) {
            StringBuilder sb = new StringBuilder(50);
            int size = this.aqw.lI().size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                BasicNameValuePair basicNameValuePair = this.aqw.lI().get(i);
                if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                    sb.append(basicNameValuePair.getName());
                    sb.append(":");
                    sb.append(basicNameValuePair.getValue());
                }
            }
            str2 = sb.toString();
        }
        str = d.aqs;
        this.Ok = new aa(str);
        this.Ok.o("plugin_upload_config", str2);
        return PluginNetConfigInfos.parse(this.Ok.rO());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(PluginNetConfigInfos pluginNetConfigInfos) {
        com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar;
        this.aqv.aqu = false;
        boolean z = pluginNetConfigInfos != null;
        aVar = this.aqv.aqt;
        aVar.a(z, pluginNetConfigInfos);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.aqv.aqu = false;
        this.Ok.hh();
        this.Ok = null;
    }
}
