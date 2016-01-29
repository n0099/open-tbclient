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
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aa;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ADDRESS = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a aBY;
    private boolean aBZ;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null);
                return;
            }
            return;
        }
        this.aBY = aVar;
        if (!this.aBZ) {
            this.aBZ = true;
            new b(cVar, z).execute(new Void[0]);
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
        private aa Ty;
        private com.baidu.adp.plugin.packageManager.pluginServerConfig.c aCb;
        private boolean aCc;

        public b(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, boolean z) {
            this.aCc = false;
            this.aCb = cVar;
            this.aCc = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            PluginSettings lZ;
            boolean z2;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            SystemClock.sleep(1500L);
            if (this.aCb == null) {
                publishProgress(new PluginNetConfigInfos[1]);
                return null;
            }
            if (this.aCb.lV() == null || this.aCb.lV().size() <= 0) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder(50);
                int size = this.aCb.lV().size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    BasicNameValuePair basicNameValuePair = this.aCb.lV().get(i);
                    if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                        sb.append(basicNameValuePair.getName());
                        sb.append(":");
                        sb.append(basicNameValuePair.getValue());
                    }
                }
                str = sb.toString();
            }
            BdCacheService gs = BdCacheService.gs();
            o<String> a = gs.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
            String str3 = a.get(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            if (!this.aCc && str3 != null) {
                long c = com.baidu.adp.lib.h.b.c(str3, -1L);
                if (c != -1 && System.currentTimeMillis() - c < 86400000) {
                    z = false;
                    String str4 = null;
                    lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
                    if (lZ != null) {
                        str4 = lZ.getContainerVersion();
                    }
                    String str5 = String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER + "_" + str4 + "_" + str;
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
                        gs.a(a);
                        o<String> a3 = gs.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                        a3.a(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(System.currentTimeMillis()), 172800000L);
                        a3.a(str5, str2, 172800000L);
                    }
                    return null;
                }
            }
            z = true;
            String str42 = null;
            lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
            if (lZ != null) {
            }
            String str52 = String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER + "_" + str42 + "_" + str;
            if (!z) {
            }
            publishProgress(pluginNetConfigInfos);
            if (z2) {
            }
            return null;
        }

        private String a(o<String> oVar, String str) {
            return oVar.get(str);
        }

        private String b(o<String> oVar, String str) {
            this.Ty = new aa(c.ADDRESS);
            this.Ty.p("plugin_upload_config", str);
            return this.Ty.uZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            c.this.aBZ = false;
            c.this.aBY.a(pluginNetConfigInfosArr[0] != null, this.aCb, pluginNetConfigInfosArr[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            c.this.aBZ = false;
            this.Ty.gT();
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
