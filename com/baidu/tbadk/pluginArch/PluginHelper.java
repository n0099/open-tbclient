package com.baidu.tbadk.pluginArch;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.util.a;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class PluginHelper {
    public static final String OS_ARCH_ARM = "arm";
    public static final String OS_TYPE_X86 = "x86";
    public static String currentUserId;

    public static String getCurrentUserId() {
        return TbadkApplication.m251getInst().isMainProcess(false) ? TbadkApplication.getCurrentAccount() : currentUserId;
    }

    public static boolean isOsArchARM() {
        return !TextUtils.isEmpty(PluginFileHelper.OS_ARCH) && PluginFileHelper.OS_ARCH.equals(OS_ARCH_ARM);
    }

    public static String getArch() {
        String substring = System.getProperty("os.arch", OS_ARCH_ARM).substring(0, 3);
        if (substring.equals("i68")) {
            return OS_TYPE_X86;
        }
        return substring;
    }

    public static String getPluginPackage(String str) {
        File apkDir;
        PackageInfo packageArchiveInfo;
        if (!TextUtils.isEmpty(str) && PluginCenter.getInstance().checkPluginInstalled(str) && (apkDir = PluginFileHelper.apkDir(str)) != null && apkDir.isFile() && apkDir.exists() && (packageArchiveInfo = TbadkApplication.m251getInst().getPackageManager().getPackageArchiveInfo(apkDir.getAbsolutePath(), 1)) != null) {
            return packageArchiveInfo.packageName;
        }
        return null;
    }

    public static boolean isFileExist(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean isBaoBaoCanUse(final Context context) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
        if (pluginByName == null) {
            ConfigInfos.PluginConfig netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_BAOBAO);
            if (netConfigInfo == null) {
                UtilHelper.showToast(context, y.plugin_config_not_found);
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(context, netConfigInfo)));
            return false;
        } else if (!pluginByName.checkEnable()) {
            a.a((Activity) context, y.plugin_baobao_not_install, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.1
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginNameList.NAME_BAOBAO)));
                    aVar.dismiss();
                }
            }, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.2
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public static boolean isHao123CanUse(final Context context) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
        if (pluginByName == null) {
            ConfigInfos.PluginConfig netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_HAO123);
            if (netConfigInfo == null) {
                UtilHelper.showToast(context, y.plugin_config_not_found);
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(context, netConfigInfo)));
            return false;
        } else if (!pluginByName.checkEnable()) {
            a.a((Activity) context, y.plugin_hao123_not_install, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.3
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginNameList.NAME_HAO123)));
                    aVar.dismiss();
                }
            }, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.4
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            return false;
        } else {
            return true;
        }
    }

    public static boolean isXiubaCanuse(final Context context) {
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_XIUBA);
        if (pluginByName == null) {
            ConfigInfos.PluginConfig netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_XIUBA);
            if (netConfigInfo == null) {
                UtilHelper.showToast(context, y.plugin_config_not_found);
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(context, netConfigInfo, 23006)));
            return false;
        } else if (!pluginByName.checkEnable()) {
            a.a((Activity) context, y.plugin_xiuba_not_canuse, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.5
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(context, PluginNameList.NAME_XIUBA, 23005)));
                    aVar.dismiss();
                }
            }, new d() { // from class: com.baidu.tbadk.pluginArch.PluginHelper.6
                @Override // com.baidu.tbadk.core.dialog.d
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            return false;
        } else {
            return true;
        }
    }
}
