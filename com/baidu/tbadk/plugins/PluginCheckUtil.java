package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.install.c;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PluginCheckUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Status {
        UnInstalled,
        Downloading,
        Installing,
        Installed,
        Disabled
    }

    public static boolean vM(String str) {
        if (k.isEmpty(str)) {
            return false;
        }
        Status status = Status.UnInstalled;
        if (PluginPackageManager.js().bj(str)) {
            status = Status.Downloading;
        } else if (c.iK().aT(str)) {
            status = Status.Installing;
        } else if (PluginPackageManager.js().bg(str)) {
            status = Status.Disabled;
        } else if (PluginPackageManager.js().ba(str)) {
            status = Status.Installed;
        } else if (PluginPackageManager.js().bb(str) == null) {
            status = Status.UnInstalled;
        }
        if (status == Status.UnInstalled) {
            Y(str, TbadkCoreApplication.getInst().getResources().getString(R.string.current_plugin_not_install), TbadkCoreApplication.getInst().getResources().getString(R.string.plugin_go_install));
        } else if (status == Status.Disabled) {
            Y(str, TbadkCoreApplication.getInst().getResources().getString(R.string.current_plugin_not_active), TbadkCoreApplication.getInst().getResources().getString(R.string.setup));
        } else if (status == Status.Downloading) {
            l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.plugin_downloading));
        } else if (status == Status.Installing) {
            l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.plugin_installing));
        } else {
            return true;
        }
        return false;
    }

    private static void Y(final String str, String str2, String str3) {
        final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.sS(str2);
            if (TextUtils.isEmpty(str3)) {
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.plugins.PluginCheckUtil.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            } else {
                aVar.a(str3, new a.b() { // from class: com.baidu.tbadk.plugins.PluginCheckUtil.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (PluginPackageManager.js().getPluginConfig(str) != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(currentActivity, str)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(currentActivity)));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.PluginCheckUtil.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            if (currentActivity instanceof TbPageContextSupport) {
                aVar.b(((TbPageContextSupport) currentActivity).getPageContext()).aEC();
            }
        }
    }
}
