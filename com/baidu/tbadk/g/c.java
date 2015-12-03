package com.baidu.tbadk.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ab;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ADDRESS = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a azD;
    private boolean azE;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null);
                return;
            }
            return;
        }
        this.azD = aVar;
        if (!this.azE) {
            this.azE = true;
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
    private class b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {
        private ab Ty;
        private com.baidu.adp.plugin.packageManager.pluginServerConfig.c azG;

        public b(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar) {
            this.azG = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            String a;
            PluginNetConfigInfos parse;
            SystemClock.sleep(1500L);
            if (this.azG == null) {
                publishProgress(new PluginNetConfigInfos[1]);
            } else {
                if (this.azG.mk() == null || this.azG.mk().size() <= 0) {
                    str = "";
                } else {
                    StringBuilder sb = new StringBuilder(50);
                    int size = this.azG.mk().size();
                    for (int i = 0; i < size; i++) {
                        if (i != 0) {
                            sb.append(",");
                        }
                        BasicNameValuePair basicNameValuePair = this.azG.mk().get(i);
                        if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                            sb.append(basicNameValuePair.getName());
                            sb.append(":");
                            sb.append(basicNameValuePair.getValue());
                        }
                    }
                    str = sb.toString();
                }
                BdCacheService gk = BdCacheService.gk();
                o<String> a2 = gk.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                String str2 = a2.get(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                if (str2 != null) {
                    long c = com.baidu.adp.lib.h.b.c(str2, -1L);
                    if (c != -1 && System.currentTimeMillis() - c < 86400000) {
                        z = false;
                        if (!z) {
                            a = b(a2, str);
                            parse = PluginNetConfigInfos.parse(a);
                        } else {
                            a = a(a2, str);
                            parse = PluginNetConfigInfos.parse(a);
                            if (parse == null) {
                                a = b(a2, str);
                                parse = PluginNetConfigInfos.parse(a);
                                z = true;
                            }
                        }
                        publishProgress(parse);
                        if (z) {
                            gk.a(a2);
                            o<String> a3 = gk.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                            a3.a(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(System.currentTimeMillis()), 172800000L);
                            a3.a(str, a, 172800000L);
                        }
                    }
                }
                z = true;
                if (!z) {
                }
                publishProgress(parse);
                if (z) {
                }
            }
            return null;
        }

        private String a(o<String> oVar, String str) {
            return oVar.get(str);
        }

        private String b(o<String> oVar, String str) {
            this.Ty = new ab(c.ADDRESS);
            this.Ty.o("plugin_upload_config", str);
            return this.Ty.ul();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            c.this.azE = false;
            c.this.azD.a(pluginNetConfigInfosArr[0] != null, this.azG, pluginNetConfigInfosArr[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            c.this.azE = false;
            this.Ty.gL();
            this.Ty = null;
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
