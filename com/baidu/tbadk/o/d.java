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
import com.baidu.tbadk.core.util.z;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ADDRESS = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a fNO;
    private boolean fNP;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(boolean z, com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, cVar, null, null);
                return;
            }
            return;
        }
        this.fNO = aVar;
        if (!this.fNP) {
            this.fNP = true;
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
        private z cmJ;
        private com.baidu.adp.plugin.packageManager.pluginServerConfig.c fNR;
        private boolean fNS;

        public b(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, boolean z) {
            this.fNS = false;
            this.fNR = cVar;
            this.fNS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            String str;
            boolean z;
            PluginSettings pW;
            PluginNetConfigInfos parse;
            String str2;
            boolean z2;
            if (this.fNR == null) {
                publishProgress(null);
            } else {
                if (this.fNR.pS() == null || this.fNR.pS().size() <= 0) {
                    str = "";
                } else {
                    StringBuilder sb = new StringBuilder(50);
                    int size = this.fNR.pS().size();
                    for (int i = 0; i < size; i++) {
                        if (i != 0) {
                            sb.append(",");
                        }
                        BasicNameValuePair basicNameValuePair = this.fNR.pS().get(i);
                        if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                            sb.append(basicNameValuePair.getName());
                            sb.append(":");
                            sb.append(basicNameValuePair.getValue());
                        }
                    }
                    str = sb.toString();
                }
                BdCacheService bx = BdCacheService.bx("baidu_plugin.db");
                l<String> a2 = bx.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                String str3 = a2.get("time");
                if (!this.fNS && str3 != null) {
                    long j = com.baidu.adp.lib.f.b.toLong(str3, -1L);
                    if (j != -1 && System.currentTimeMillis() - j < 86400000) {
                        z = false;
                        String str4 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (com.baidu.adp.plugin.packageManager.pluginSettings.c.pZ().pW() == null ? pW.getContainerVersion() : null) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
                        if (!z) {
                            str2 = b(a2, str);
                            z2 = z;
                            parse = PluginNetConfigInfos.parse(str2);
                        } else {
                            String a3 = a(a2, str4);
                            parse = PluginNetConfigInfos.parse(a3);
                            if (parse == null) {
                                String b2 = b(a2, str);
                                str2 = b2;
                                z2 = true;
                                parse = PluginNetConfigInfos.parse(b2);
                            } else {
                                str2 = a3;
                                z2 = z;
                            }
                        }
                        publishProgress(parse);
                        if (z2) {
                            bx.a(a2);
                            l<String> a4 = bx.a("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                            a4.set("time", String.valueOf(System.currentTimeMillis()), 172800000L);
                            a4.set(str4, str2, 172800000L);
                        }
                    }
                }
                z = true;
                String str42 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (com.baidu.adp.plugin.packageManager.pluginSettings.c.pZ().pW() == null ? pW.getContainerVersion() : null) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
                if (!z) {
                }
                publishProgress(parse);
                if (z2) {
                }
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
            this.cmJ = new z(d.ADDRESS);
            this.cmJ.addPostData("plugin_upload_config", str);
            return this.cmJ.postNetData();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            super.onProgressUpdate(pluginNetConfigInfosArr);
            d.this.fNP = false;
            boolean z = pluginNetConfigInfosArr[0] != null;
            String str = null;
            if (this.cmJ != null && !this.cmJ.isNetSuccess()) {
                str = this.cmJ.bvS();
                if (this.cmJ.getServerErrorCode() != 0) {
                    str = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.cmJ.getErrorString();
                }
            }
            d.this.fNO.a(z, this.fNR, pluginNetConfigInfosArr[0], str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_NETCONFIG_GET));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            d.this.fNP = false;
            this.cmJ.cancelNetConnect();
            this.cmJ = null;
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
