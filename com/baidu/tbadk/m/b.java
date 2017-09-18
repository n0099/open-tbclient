package com.baidu.tbadk.m;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.c;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ADDRESS = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a aLg;
    private boolean aLh;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(boolean z, c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null);
                return;
            }
            return;
        }
        this.aLg = aVar;
        if (!this.aLh) {
            this.aLh = true;
            new C0064b(cVar, z).execute(new Void[0]);
        }
        try {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            File filesDir = inst.getFilesDir();
            if (filesDir == null) {
                filesDir = new File("/data/data/" + inst.getPackageName() + "/files/");
                try {
                    if (!filesDir.exists()) {
                        e.m(filesDir);
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

    /* renamed from: com.baidu.tbadk.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0064b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {
        private c aLj;
        private boolean aLk;
        private x mNetWork;

        public C0064b(c cVar, boolean z) {
            this.aLk = false;
            this.aLj = cVar;
            this.aLk = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0146  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            PluginSettings jV;
            boolean z2;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            SystemClock.sleep(1500L);
            if (this.aLj == null) {
                publishProgress(null);
                return null;
            }
            if (this.aLj.jR() == null || this.aLj.jR().size() <= 0) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder(50);
                int size = this.aLj.jR().size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    BasicNameValuePair basicNameValuePair = this.aLj.jR().get(i);
                    if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                        sb.append(basicNameValuePair.getName());
                        sb.append(":");
                        sb.append(basicNameValuePair.getValue());
                    }
                }
                str = sb.toString();
            }
            BdCacheService eF = BdCacheService.eF();
            l<String> a = eF.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
            String str3 = a.get(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            if (!this.aLk && str3 != null) {
                long c = com.baidu.adp.lib.g.b.c(str3, -1L);
                if (c != -1 && System.currentTimeMillis() - c < 86400000) {
                    z = false;
                    String str4 = null;
                    jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
                    if (jV != null) {
                        str4 = jV.getContainerVersion();
                    }
                    String str5 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + str4 + "_" + str;
                    if (!z) {
                        String b = b(a, str);
                        pluginNetConfigInfos = PluginNetConfigInfos.parse(b);
                        z2 = z;
                        str2 = b;
                    } else {
                        String a2 = a(a, str5);
                        PluginNetConfigInfos parse = PluginNetConfigInfos.parse(a2);
                        if (parse == null) {
                            str2 = b(a, str);
                            pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                            z2 = true;
                        } else {
                            z2 = z;
                            str2 = a2;
                            pluginNetConfigInfos = parse;
                        }
                    }
                    publishProgress(pluginNetConfigInfos);
                    if (z2) {
                        eF.a(a);
                        l<String> a3 = eF.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                        a3.a(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(System.currentTimeMillis()), 172800000L);
                        a3.a(str5, str2, 172800000L);
                    }
                    return null;
                }
            }
            z = true;
            String str42 = null;
            jV = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV();
            if (jV != null) {
            }
            String str52 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + str42 + "_" + str;
            if (!z) {
            }
            publishProgress(pluginNetConfigInfos);
            if (z2) {
            }
            return null;
        }

        private String a(l<String> lVar, String str) {
            return lVar.get(str);
        }

        private String b(l<String> lVar, String str) {
            this.mNetWork = new x(b.ADDRESS);
            this.mNetWork.n("plugin_upload_config", str);
            return this.mNetWork.uM();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            b.this.aLh = false;
            b.this.aLg.a(pluginNetConfigInfosArr[0] != null, this.aLj, pluginNetConfigInfosArr[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            b.this.aLh = false;
            this.mNetWork.fp();
            this.mNetWork = null;
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
                Util.i(this.mFile);
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r1) {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
