package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class XiaoyingUtil {
    public static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    private static int showTime;

    public static boolean isXiaoyingForbidden() {
        return PluginPackageManager.js().bg(PKG_NAME_VIDEO);
    }

    public static int getShowTime() {
        return showTime;
    }

    public static void setShowTime(int i) {
        showTime = i;
    }

    public static boolean isXiaoyingInstalled() {
        return PluginPackageManager.js().ba(PKG_NAME_VIDEO) && TbadkCoreApplication.getInst().appResponseToIntentClass(MotuVideoConfig.class);
    }

    public static void startXiaoying(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MotuVideoConfig(context)));
        }
    }

    public static void startXiaoying(Context context, boolean z, String str, String str2, String str3) {
        boolean z2 = false;
        if (context != null) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, z);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MotuVideoConfig(context, (z || com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("localvideo_open", false)) ? true : true, str, str2, str3)));
        }
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2) {
        startPlayXiaoyingVideo(context, str, i, i2, str2, true);
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2, boolean z) {
        if (context != null && !StringUtils.isNull(str)) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
                BdToast.b(context, context.getString(R.string.plugin_xiaoying_install_fail)).aEL();
            } else if (z && !j.isNetWorkAvailable()) {
                BdToast.b(context, context.getString(R.string.neterror)).aEL();
            } else if (z) {
                if (j.isWifiNet()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
                    return;
                }
                showStartPlayVideoDialog(context, str, i, i2, str2);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
            }
        }
    }

    private static void showStartPlayVideoDialog(final Context context, final String str, final int i, final int i2, final String str2) {
        e<?> ab = i.ab(context);
        if (ab != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.sS(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tbadk.plugins.XiaoyingUtil.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.XiaoyingUtil.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(ab).aEG();
        }
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        return (!TbadkCoreApplication.getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (pluginConfig = PluginPackageManager.js().getPluginConfig(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1 || c.jV().findPluginSetting(PKG_NAME_VIDEO) == null) ? false : true;
    }

    public static void showGoPluginDetailDialog(final TbPageContext<?> tbPageContext, String str, String str2) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.sS(str);
            aVar.a(str2, new a.b() { // from class: com.baidu.tbadk.plugins.XiaoyingUtil.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(pageActivity, XiaoyingUtil.PKG_NAME_VIDEO)));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.XiaoyingUtil.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(tbPageContext).aEG();
        }
    }
}
