package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class XiaoyingUtil {
    private static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    private static int showTime;

    public static boolean isXiaoyingForbidden() {
        return PluginPackageManager.lU().bu(PKG_NAME_VIDEO);
    }

    public static int getShowTime() {
        return showTime;
    }

    public static void setShowTime(int i) {
        showTime = i;
    }

    public static boolean isXiaoyingInstalled() {
        return PluginPackageManager.lU().bo(PKG_NAME_VIDEO) && TbadkCoreApplication.m411getInst().appResponseToIntentClass(MotuVideoConfig.class);
    }

    public static void startXiaoying(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MotuVideoConfig(context)));
        }
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2) {
        if (context != null && !StringUtils.isNull(str)) {
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
                BdToast.b(context, context.getString(n.i.plugin_xiaoying_install_fail)).tE();
            } else if (!i.iP()) {
                BdToast.b(context, context.getString(n.i.neterror)).tE();
            } else if (i.iQ()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
            } else {
                showStartPlayVideoDialog(context, str, i, i2, str2);
            }
        }
    }

    private static void showStartPlayVideoDialog(Context context, String str, int i, int i2, String str2) {
        h<?> C = l.C(context);
        if (C != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
            aVar.cC(TbadkCoreApplication.m411getInst().getString(n.i.play_video_mobile_tip));
            aVar.a(n.i.confirm, new c(context, str, i, i2, str2));
            aVar.b(n.i.cancel, new d());
            aVar.b(C).tv();
        }
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginSetting findPluginSetting;
        if (!TbadkCoreApplication.m411getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (pluginConfig = PluginPackageManager.lU().getPluginConfig(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1 || (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(PKG_NAME_VIDEO)) == null) {
            return false;
        }
        return pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cC(str);
            aVar.a(str2, new e(pageActivity, tbPageContext));
            aVar.b(n.i.cancel, new f());
            aVar.b(tbPageContext).tv();
        }
    }
}
