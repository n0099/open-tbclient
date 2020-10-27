package com.baidu.tbadk.o;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ADDRESS = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a frm;
    private boolean frn;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null, null);
                return;
            }
            return;
        }
        this.frm = aVar;
        if (!this.frn) {
            this.frn = true;
            new b(cVar, z).execute(new Void[0]);
        }
        try {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            File filesDir = inst.getFilesDir();
            if (filesDir == null) {
                filesDir = new File("/data/data/" + inst.getPackageName() + "/files/");
                try {
                    if (!filesDir.exists()) {
                        f.forceMkdir(filesDir);
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
        private aa bVi;
        private com.baidu.adp.plugin.packageManager.pluginServerConfig.c frp;
        private boolean frq;

        public b(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, boolean z) {
            this.frq = false;
            this.frp = cVar;
            this.frq = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            PluginSettings qs;
            boolean z2;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            if (this.frp == null) {
                publishProgress(null);
                return null;
            }
            if (this.frp.qo() == null || this.frp.qo().size() <= 0) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder(50);
                int size = this.frp.qo().size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    BasicNameValuePair basicNameValuePair = this.frp.qo().get(i);
                    if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                        sb.append(basicNameValuePair.getName());
                        sb.append(":");
                        sb.append(basicNameValuePair.getValue());
                    }
                }
                str = sb.toString();
            }
            BdCacheService bA = BdCacheService.bA("baidu_plugin.db");
            l<String> a2 = bA.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
            String str3 = a2.get("time");
            if (!this.frq && str3 != null) {
                long j = com.baidu.adp.lib.f.b.toLong(str3, -1L);
                if (j != -1 && System.currentTimeMillis() - j < 86400000) {
                    z = false;
                    String str4 = null;
                    qs = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().qs();
                    if (qs != null) {
                        str4 = qs.getContainerVersion();
                    }
                    String str5 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
                    if (!z) {
                        String b = b(a2, str);
                        pluginNetConfigInfos = PluginNetConfigInfos.parse(b);
                        z2 = z;
                        str2 = b;
                    } else {
                        String a3 = a(a2, str5);
                        PluginNetConfigInfos parse = PluginNetConfigInfos.parse(a3);
                        if (parse == null) {
                            str2 = b(a2, str);
                            pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                            z2 = true;
                        } else {
                            z2 = z;
                            str2 = a3;
                            pluginNetConfigInfos = parse;
                        }
                    }
                    publishProgress(pluginNetConfigInfos);
                    if (z2) {
                        bA.a(a2);
                        l<String> a4 = bA.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                        a4.set("time", String.valueOf(System.currentTimeMillis()), 172800000L);
                        a4.set(str5, str2, 172800000L);
                    }
                    return null;
                }
            }
            z = true;
            String str42 = null;
            qs = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().qs();
            if (qs != null) {
            }
            String str52 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str42 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
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
            boolean checkNewUser = TbadkCoreApplication.getInst().checkNewUser();
            if (TbadkCoreApplication.getInst().checkInterrupt() && checkNewUser) {
                return null;
            }
            this.bVi = new aa(d.ADDRESS);
            this.bVi.addPostData("plugin_upload_config", str);
            return this.bVi.postNetData();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            d.this.frn = false;
            boolean z = pluginNetConfigInfosArr[0] != null;
            String str = null;
            if (this.bVi != null && !this.bVi.isNetSuccess()) {
                str = this.bVi.boo();
                if (this.bVi.getServerErrorCode() != 0) {
                    str = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bVi.getErrorString();
                }
            }
            d.this.frm.a(z, this.frp, pluginNetConfigInfosArr[0], str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.this.frn = false;
            this.bVi.cancelNetConnect();
            this.bVi = null;
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
                Util.cleanDirectory(this.mFile);
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r1) {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
