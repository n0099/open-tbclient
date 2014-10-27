package com.baidu.tbadk.pluginArch;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.PluginDownloader;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PluginUpdater implements PluginDownloader.Callback {
    private static final String PLUGIN_FILE_SUFFIX = ".tbplugin";
    String[] mAssetSubfileArray = null;
    private Context mContext;
    private final PluginDownloader mDownloader;

    public PluginUpdater(Context context) {
        this.mContext = context;
        this.mDownloader = new PluginDownloader(context);
        this.mDownloader.setInstallAfterDownload(false);
    }

    public HashMap<String, PluginInstalledConfigItem> filterUpdating(HashMap<String, PluginInstalledConfigItem> hashMap) {
        HashMap<String, PluginInstalledConfigItem> hashMap2 = new HashMap<>();
        for (String str : hashMap.keySet()) {
            PluginInstalledConfigItem pluginInstalledConfigItem = hashMap.get(str);
            if (pluginInstalledConfigItem.mInstalledMainVersion.equals(TbConfig.getVersion()) || !isPluginPackageExistInAssets(pluginInstalledConfigItem.mPluginName)) {
                if (!PluginVersionCheck.checkHasPluginUpdatePackageXML(pluginInstalledConfigItem)) {
                    hashMap2.put(str, pluginInstalledConfigItem);
                }
            }
        }
        return hashMap2;
    }

    public void downloadUpdatePackage() {
        ConfigInfos netConfigInfos;
        if (UtilHelper.getNetStatusInfo(this.mContext) == UtilHelper.NetworkStateInfo.WIFI && (netConfigInfos = PluginCenter.getInstance().getNetConfigInfos()) != null) {
            for (ConfigInfos.PluginConfig pluginConfig : netConfigInfos.getConfigs()) {
                if (pluginConfig.name != null && pluginConfig.newest != null && PluginVersionCheck.checkPluginUpdate(pluginConfig.name) && pluginConfig.newest.silent_upgrade == 1 && !PluginVersionCheck.checkHasPluginUpdatePackage(pluginConfig.name)) {
                    this.mDownloader.startForeground(pluginConfig, this);
                }
            }
        }
    }

    public void updatePackage() {
        HashMap<String, PluginInstalledConfigItem> installedConfig = PluginInstalledConfigManager.getInstance().getInstalledConfig();
        if (installedConfig != null) {
            for (PluginInstalledConfigItem pluginInstalledConfigItem : installedConfig.values()) {
                if (PluginVersionCheck.checkHasPluginUpdatePackageXML(pluginInstalledConfigItem) && pluginInstalledConfigItem.mPluginName != null) {
                    final File updateDir = PluginFileHelper.updateDir(pluginInstalledConfigItem.mPluginName, pluginInstalledConfigItem.mPluginUpdateVersion);
                    if (updateDir.exists()) {
                        PluginCenter.getInstance().installPluginFromFile(updateDir.getAbsolutePath(), pluginInstalledConfigItem.mPluginName, new InstallCallback() { // from class: com.baidu.tbadk.pluginArch.PluginUpdater.1
                            @Override // com.baidu.tbadk.pluginArch.InstallCallback
                            public void onFinish(int i, String str) {
                                if (i == 0) {
                                    RemoteSynchronousDataHelper.getInstance().startInstallPluginMsg();
                                    s.m(updateDir);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void processUpdate(DownloadData downloadData) {
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadSuccess(DownloadData downloadData) {
        ConfigInfos netConfigInfos;
        if (downloadData != null && downloadData.getPath() != null && downloadData.getId() != null && (netConfigInfos = PluginCenter.getInstance().getNetConfigInfos()) != null) {
            for (ConfigInfos.PluginConfig pluginConfig : netConfigInfos.getConfigs()) {
                if (pluginConfig.name != null && pluginConfig.newest != null && pluginConfig.name.equalsIgnoreCase(downloadData.getId())) {
                    File file = new File(downloadData.getPath());
                    copyFile(downloadData.getPath(), PluginFileHelper.updateDir(downloadData.getId(), pluginConfig.newest.version).getAbsolutePath());
                    s.m(file);
                    PluginInstalledConfigItem installedConfigByName = PluginInstalledConfigManager.getInstance().getInstalledConfigByName(downloadData.getId());
                    if (installedConfigByName != null) {
                        installedConfigByName.mPluginUpdateVersion = pluginConfig.newest.version;
                        PluginInstalledConfigManager.getInstance().addInstalledConfig(installedConfigByName);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void downloadFail(DownloadData downloadData) {
    }

    @Override // com.baidu.tbadk.pluginArch.PluginDownloader.Callback
    public void installFinish(DownloadData downloadData, int i, String str) {
    }

    public boolean copyFile(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPluginPackageExistInAssets(String str) {
        if (str != null) {
            if (this.mAssetSubfileArray == null) {
                try {
                    this.mAssetSubfileArray = this.mContext.getAssets().list("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.mAssetSubfileArray != null) {
                String str2 = String.valueOf(str) + PLUGIN_FILE_SUFFIX;
                for (String str3 : this.mAssetSubfileArray) {
                    if (str3.equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
