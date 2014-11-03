package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.PluginDownloader;
import com.baidu.tbadk.pluginArch.PluginNetConfigLoader;
import com.baidu.tbadk.pluginArch.PluginXMLReader;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class PluginCenter {
    private static long MIN_LOAD_INTERVAL = 300000;
    private static long mLastLoadTime = -1;
    private static PluginCenter sPluginCenter;
    public Context mContext;
    private final PluginDexLoader mDexLoader;
    private final PluginDownloader mDownloader;
    private boolean mTipUpdateRead;
    private final PluginUpdater mUpdater;
    final TreeMap<String, Plugin> mPluginMap = new TreeMap<>();
    private e mOnlineListener = new e(1001) { // from class: com.baidu.tbadk.pluginArch.PluginCenter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0) {
                    PluginCenter.this.checkVersion(responseOnlineMessage.getConfigVersion().f224plugin);
                }
            }
        }
    };
    private final PluginNetConfigLoader mNetConfigLoader = new PluginNetConfigLoader();

    public static void createPluginCenter(Context context) {
        if (sPluginCenter == null) {
            sPluginCenter = new PluginCenter(context);
            sPluginCenter.load();
            if (TbadkApplication.m251getInst().isMainProcess(false)) {
                sPluginCenter.loadNetConfigInfos();
            }
        }
    }

    public static PluginCenter getInstance() {
        if (sPluginCenter == null) {
            synchronized (PluginCenter.class) {
                if (sPluginCenter == null) {
                    createPluginCenter(TbadkApplication.m251getInst());
                }
            }
            if (BdLog.isDebugMode()) {
                BdLog.detailException("PluginCenter.getInstance() invoked before inited from on app Create.", new Exception());
            }
        }
        return sPluginCenter;
    }

    private PluginCenter(Context context) {
        this.mContext = context;
        this.mDexLoader = new PluginDexLoader(context);
        this.mDownloader = new PluginDownloader(context);
        this.mUpdater = new PluginUpdater(context);
        MessageManager.getInstance().registerListener(this.mOnlineListener);
    }

    public void checkVersion(String str) {
        ConfigInfos configInfos;
        String config_version;
        if (str != null && this.mNetConfigLoader != null && (configInfos = this.mNetConfigLoader.getConfigInfos()) != null && (config_version = configInfos.getConfig_version()) != null && !config_version.equalsIgnoreCase(str) && checkAutoLoadInterval()) {
            mLastLoadTime = System.currentTimeMillis();
            loadNetConfigInfos();
        }
    }

    private boolean checkAutoLoadInterval() {
        if (-1 == mLastLoadTime) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - mLastLoadTime;
        return currentTimeMillis <= 0 || currentTimeMillis >= MIN_LOAD_INTERVAL;
    }

    private void load() {
        HashMap<String, PluginInstalledConfigItem> installedConfig = PluginInstalledConfigManager.getInstance().getInstalledConfig();
        if (TbadkApplication.m251getInst().isMainProcess(false)) {
            this.mUpdater.updatePackage();
        }
        loadFromConfig(this.mUpdater.filterUpdating(installedConfig));
    }

    public void resetLoad() {
        loadFromConfig(PluginInstalledConfigManager.getInstance().resetInstalledConfig());
    }

    private void loadFromConfig(HashMap<String, PluginInstalledConfigItem> hashMap) {
        File pluginXML;
        PluginXMLInfo xMLInfoFromFile;
        Plugin createPlugin;
        if (hashMap != null) {
            LinkedList<File> linkedList = new LinkedList<>();
            LinkedList<File> linkedList2 = new LinkedList<>();
            for (PluginInstalledConfigItem pluginInstalledConfigItem : hashMap.values()) {
                if (pluginInstalledConfigItem.mPluginName != null && PluginLoadFilter.getInstance().canLoadPlugin(pluginInstalledConfigItem) && (pluginXML = PluginFileHelper.pluginXML(pluginInstalledConfigItem.mPluginName)) != null && (xMLInfoFromFile = getXMLInfoFromFile(pluginXML)) != null && (xMLInfoFromFile.mPluginName == null || this.mPluginMap.get(xMLInfoFromFile.mPluginName) == null)) {
                    if (xMLInfoFromFile.mImplClassName != null && (createPlugin = createPlugin(xMLInfoFromFile)) != null) {
                        linkedList.add(PluginFileHelper.libraryDir(createPlugin.getName()));
                        linkedList2.add(PluginFileHelper.nativeDir(createPlugin.getName()));
                    }
                }
            }
            getInstance().getClassLoader().add(linkedList, linkedList2);
            for (Plugin plugin2 : this.mPluginMap.values()) {
                plugin2.loadPlugin(false);
            }
        }
    }

    public List<Plugin> getInstalledPluginList() {
        LinkedList linkedList = new LinkedList();
        for (Plugin plugin2 : this.mPluginMap.values()) {
            linkedList.add(plugin2);
        }
        return linkedList;
    }

    public Plugin getPluginByName(String str) {
        if (str == null) {
            return null;
        }
        return this.mPluginMap.get(str);
    }

    public ConfigInfos loadNetConfigInfos() {
        return this.mNetConfigLoader.loadConfigInfos(new PluginNetConfigLoader.CallBack() { // from class: com.baidu.tbadk.pluginArch.PluginCenter.2
            @Override // com.baidu.tbadk.pluginArch.PluginNetConfigLoader.CallBack
            public void onResult(ConfigInfos configInfos) {
                if (configInfos != null && TbadkApplication.m251getInst().isMainProcess(false)) {
                    RemoteSynchronousDataHelper.getInstance().startNetConfigMsg(configInfos);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230));
                    PluginCenter.this.mUpdater.downloadUpdatePackage();
                    PluginCenter.this.startDownloadBackground();
                }
            }
        });
    }

    public ConfigInfos getNetConfigInfos() {
        return this.mNetConfigLoader.getConfigInfos();
    }

    public void setNetConfigInfos(ConfigInfos configInfos) {
        this.mNetConfigLoader.setConfigInfos(configInfos);
    }

    public ConfigInfos.PluginConfig getNetConfigInfo(String str) {
        ConfigInfos netConfigInfos;
        if (!TextUtils.isEmpty(str) && (netConfigInfos = getNetConfigInfos()) != null) {
            for (ConfigInfos.PluginConfig pluginConfig : netConfigInfos.getConfigs()) {
                if (str.equals(pluginConfig.name)) {
                    return pluginConfig;
                }
            }
            return null;
        }
        return null;
    }

    public void startDownloadBackground() {
        if (j.fi()) {
            ArrayList arrayList = new ArrayList();
            if (!getInstance().checkPluginInstalled(PluginNameList.NAME_MOTUSDK)) {
                arrayList.add(PluginNameList.NAME_MOTUSDK);
            }
            if (!getInstance().checkPluginInstalled(PluginNameList.NAME_BROWSER)) {
                arrayList.add(PluginNameList.NAME_BROWSER);
            }
            if (!PluginHelper.isOsArchARM() && !getInstance().checkPluginInstalled(PluginNameList.NAME_LIVE)) {
                arrayList.add(PluginNameList.NAME_LIVE);
            }
            if (!getInstance().checkPluginInstalled(PluginNameList.NAME_LIGHT_APP)) {
                arrayList.add(PluginNameList.NAME_LIGHT_APP);
            }
            if (!getInstance().checkPluginInstalled(PluginNameList.NAME_BAOBAO)) {
                arrayList.add(PluginNameList.NAME_BAOBAO);
            }
            if (!getInstance().checkPluginInstalled(PluginNameList.NAME_XIUBA)) {
                arrayList.add(PluginNameList.NAME_XIUBA);
            }
            this.mDownloader.startDownload((String[]) arrayList.toArray(new String[arrayList.size()]), new PluginDownloader.Callback() { // from class: com.baidu.tbadk.pluginArch.PluginCenter.3
                @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
                public void processUpdate(DownloadData downloadData) {
                }

                @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
                public void installFinish(DownloadData downloadData, int i, String str) {
                    if ("lightapp.tbplugin".equals(downloadData.getName())) {
                        TbadkApplication.m251getInst().getSharedPreferences("zeus", 2).edit().putString("T5SoPath", String.valueOf(PluginFileHelper.nativeDir(PluginNameList.NAME_LIGHT_APP).getAbsolutePath()) + File.separator).commit();
                    }
                }

                @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
                public void downloadSuccess(DownloadData downloadData) {
                }

                @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
                public void downloadFail(DownloadData downloadData) {
                }
            });
        }
    }

    public void startDownloadForeground(ConfigInfos.PluginConfig pluginConfig, PluginDownloader.Callback callback) {
        this.mDownloader.startForeground(pluginConfig, callback);
    }

    public void cancelDownloadForeground() {
        this.mDownloader.cancelForeground();
    }

    public void installPluginFromAsset(String str, InstallCallback installCallback) {
        PluginInstalledConfigItem installedConfigByName;
        if (str != null) {
            if (!checkPluginInstalled(str) || (installedConfigByName = PluginInstalledConfigManager.getInstance().getInstalledConfigByName(str)) == null || installedConfigByName.mInstalledMainVersion == null || !installedConfigByName.mInstalledMainVersion.equals(TbConfig.getVersion())) {
                new PluginInstaller(this.mContext, str, new InstallCallbackImpl(str, installCallback)).install();
            }
        }
    }

    public void installPluginFromFile(String str, String str2, InstallCallback installCallback) {
        PluginInstalledConfigItem installedConfigByName;
        if (!checkPluginInstalled(str2) || (installedConfigByName = PluginInstalledConfigManager.getInstance().getInstalledConfigByName(str2)) == null || installedConfigByName.mInstalledMainVersion == null || !installedConfigByName.mInstalledMainVersion.equals(TbConfig.getVersion())) {
            new PluginInstaller(str, str2, new InstallCallbackImpl(str2, installCallback)).install();
        }
    }

    public void unInstallPlugin(String str) {
    }

    public void unLoadPlugin(String str) {
        this.mPluginMap.remove(str);
    }

    public PluginDexLoader getClassLoader() {
        return this.mDexLoader;
    }

    public boolean checkPluginInstalled(String str) {
        return str != null && PluginInstalledConfigManager.getInstance().getInstalledConfig().containsKey(str);
    }

    public boolean isEnabled(String str) {
        return PluginForbiddenManager.getInstance().isEnabled(str);
    }

    public void setEnabled(String str, boolean z) {
        PluginForbiddenManager.getInstance().setEnabled(str, z);
    }

    public boolean hasUpdate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return PluginVersionCheck.checkPluginUpdate(str);
    }

    public boolean isTipUpdate() {
        return hasUpdate() && !this.mTipUpdateRead;
    }

    public void setTipUpdateRead() {
        this.mTipUpdateRead = true;
    }

    public boolean hasUpdate() {
        for (String str : this.mPluginMap.keySet()) {
            if (hasUpdate(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Plugin createPlugin(PluginXMLInfo pluginXMLInfo) {
        if (pluginXMLInfo == null) {
            return null;
        }
        Plugin plugin2 = new Plugin(pluginXMLInfo);
        if (plugin2.getName() != null) {
            this.mPluginMap.put(plugin2.getName(), plugin2);
            return plugin2;
        }
        return null;
    }

    private PluginXMLInfo getXMLInfoFromFile(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        PluginXMLReader pluginXMLReader = new PluginXMLReader(file);
        pluginXMLReader.parse();
        return pluginXMLReader.mXmlInfo;
    }

    public void loadNativeLibrary(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(PluginFileHelper.nativeDir(str), System.mapLibraryName(str2));
            if (file != null && file.isFile()) {
                try {
                    System.load(file.getAbsolutePath());
                    PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_USE, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                    PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_USE, th.getMessage(), str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InstallCallbackImpl implements InstallCallback, PluginXMLReader.PluginXMLAsyncCallback {
        private InstallCallback callback;
        private String pluginName;
        private String mMsg = null;
        private int mErr = -1;

        public InstallCallbackImpl(String str, InstallCallback installCallback) {
            this.pluginName = null;
            this.callback = null;
            this.pluginName = str;
            this.callback = installCallback;
        }

        @Override // com.baidu.tbadk.pluginArch.InstallCallback
        public void onFinish(int i, String str) {
            this.mErr = i;
            this.mMsg = str;
            onInstallFinished(i, str, this.pluginName);
        }

        private void onInstallFinished(int i, String str, String str2) {
            File pluginXML;
            if (i == 0 && (pluginXML = PluginFileHelper.pluginXML(str2)) != null && pluginXML.exists()) {
                PluginXMLReader pluginXMLReader = new PluginXMLReader(pluginXML);
                pluginXMLReader.mCallback = this;
                pluginXMLReader.asyncParse();
            }
        }

        @Override // com.baidu.tbadk.pluginArch.PluginXMLReader.PluginXMLAsyncCallback
        public void onFinish(PluginXMLReader pluginXMLReader) {
            PluginXMLInfo pluginXMLInfo = pluginXMLReader.mXmlInfo;
            if (pluginXMLInfo != null) {
                PluginInstalledConfigItem pluginInstalledConfigItem = new PluginInstalledConfigItem();
                pluginInstalledConfigItem.mPluginName = this.pluginName;
                pluginInstalledConfigItem.mPluginVersion = pluginXMLInfo.mVersion;
                pluginInstalledConfigItem.mInstalledMainVersion = TbConfig.getVersion();
                if (PluginLoadFilter.getInstance().canLoadPlugin(pluginInstalledConfigItem)) {
                    Plugin createPlugin = PluginCenter.this.createPlugin(pluginXMLInfo);
                    if (createPlugin == null) {
                        if (this.callback != null) {
                            this.callback.onFinish(this.mErr, this.mMsg);
                            return;
                        }
                        return;
                    }
                    createPlugin.loadPlugin(true);
                }
                RemoteSynchronousDataHelper.getInstance().startInstallPluginMsg();
                PluginInstalledConfigManager.getInstance().addInstalledConfig(pluginInstalledConfigItem);
                if (TbadkApplication.m251getInst().isMainProcess(false)) {
                    Intent intent = new Intent(PluginCenter.this.mContext, PluginFileService.class);
                    intent.putExtra(PluginFileService.KEY_PLUGIN_NAME, this.pluginName);
                    PluginCenter.this.mContext.startService(intent);
                }
                if (this.callback != null) {
                    this.callback.onFinish(this.mErr, this.mMsg);
                }
            }
        }
    }
}
