package com.baidu.tbadk.pluginArch;

import android.os.SystemClock;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class PluginNetConfigLoader {
    private static final String ADDRESS = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS;
    private CallBack mCallBack;
    private ConfigInfos mConfigInfos;
    private boolean mLoading;

    /* loaded from: classes.dex */
    public interface CallBack {
        void onResult(ConfigInfos configInfos);
    }

    public ConfigInfos getConfigInfos() {
        return this.mConfigInfos;
    }

    public void setConfigInfos(ConfigInfos configInfos) {
        this.mConfigInfos = configInfos;
    }

    public ConfigInfos loadConfigInfos(CallBack callBack) {
        this.mCallBack = callBack;
        if (!this.mLoading) {
            this.mLoading = true;
            new LoaderWorker(this, null).execute(new Void[0]);
        }
        return this.mConfigInfos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LoaderWorker extends BdAsyncTask<Void, Void, ConfigInfos> {
        private ac mNetWork;

        private LoaderWorker() {
        }

        /* synthetic */ LoaderWorker(PluginNetConfigLoader pluginNetConfigLoader, LoaderWorker loaderWorker) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ConfigInfos doInBackground(Void... voidArr) {
            SystemClock.sleep(1500L);
            this.mNetWork = new ac(PluginNetConfigLoader.ADDRESS);
            return ConfigInfos.parse(this.mNetWork.lA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(ConfigInfos configInfos) {
            PluginNetConfigLoader.this.mLoading = false;
            PluginNetConfigLoader.this.mConfigInfos = configInfos;
            PluginNetConfigLoader.this.mCallBack.onResult(configInfos);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            PluginNetConfigLoader.this.mLoading = false;
            this.mNetWork.dM();
            this.mNetWork = null;
        }
    }
}
