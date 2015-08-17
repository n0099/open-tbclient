package com.baidu.tbadk.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ayq = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a ayr;
    private boolean ays;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, null);
                return;
            }
            return;
        }
        this.ayr = aVar;
        if (!this.ays) {
            this.ays = true;
            new b(cVar).execute(new Void[0]);
        }
        try {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            File filesDir = m411getInst.getFilesDir();
            if (filesDir == null) {
                filesDir = new File("/data/data/" + m411getInst.getPackageName() + "/files/");
                try {
                    if (!filesDir.exists()) {
                        e.k(filesDir);
                    }
                } catch (IOException e) {
                }
            }
            File file = new File(filesDir, "pluginsEX");
            if (file != null && file.exists()) {
                new a(file).execute(new Void[0]);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<Void, Void, PluginNetConfigInfos> {
        private v Tu;
        private com.baidu.adp.plugin.packageManager.pluginServerConfig.c ayu;

        public b(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar) {
            this.ayu = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public PluginNetConfigInfos doInBackground(Void... voidArr) {
            SystemClock.sleep(1500L);
            if (this.ayu == null) {
                return null;
            }
            String str = "";
            if (this.ayu.mi() != null && this.ayu.mi().size() > 0) {
                StringBuilder sb = new StringBuilder(50);
                int size = this.ayu.mi().size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    BasicNameValuePair basicNameValuePair = this.ayu.mi().get(i);
                    if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                        sb.append(basicNameValuePair.getName());
                        sb.append(":");
                        sb.append(basicNameValuePair.getValue());
                    }
                }
                str = sb.toString();
            }
            this.Tu = new v(c.ayq);
            this.Tu.o("plugin_upload_config", str);
            return PluginNetConfigInfos.parse(this.Tu.tD());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(PluginNetConfigInfos pluginNetConfigInfos) {
            c.this.ays = false;
            c.this.ayr.a(pluginNetConfigInfos != null, pluginNetConfigInfos);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            c.this.ays = false;
            this.Tu.gM();
            this.Tu = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, Void, Void> {
        private File mFile;

        public a(File file) {
            this.mFile = null;
            this.mFile = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.mFile != null && this.mFile.exists()) {
                Util.g(this.mFile);
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
