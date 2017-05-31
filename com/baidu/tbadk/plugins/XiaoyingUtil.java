package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class XiaoyingUtil {
    public static final String PKG_NAME_VIDEO = "cn.jingling.motu.photowonder.plugin.mv";
    private static int showTime;

    public static boolean isXiaoyingForbidden() {
        return PluginPackageManager.jx().be(PKG_NAME_VIDEO);
    }

    public static int getShowTime() {
        return showTime;
    }

    public static void setShowTime(int i) {
        showTime = i;
    }

    public static boolean isXiaoyingInstalled() {
        return PluginPackageManager.jx().aY(PKG_NAME_VIDEO) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MotuVideoConfig.class);
    }

    public static void startXiaoying(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MotuVideoConfig(context)));
        }
    }

    public static void startXiaoying(Context context, boolean z, String str, String str2) {
        boolean z2 = false;
        if (context != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, z);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MotuVideoConfig(context, (z || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("localvideo_open", false)) ? true : true, str, str2)));
        }
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2) {
        startPlayXiaoyingVideo(context, str, i, i2, str2, true);
    }

    public static void startPlayXiaoyingVideo(Context context, String str, int i, int i2, String str2, boolean z) {
        if (context != null && !StringUtils.isNull(str)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
                BdToast.a(context, context.getString(w.l.plugin_xiaoying_install_fail)).tk();
            } else if (z && !com.baidu.adp.lib.util.i.hk()) {
                BdToast.a(context, context.getString(w.l.neterror)).tk();
            } else if (z) {
                if (com.baidu.adp.lib.util.i.hl()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
                    return;
                }
                showStartPlayVideoDialog(context, str, i, i2, str2);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str, i, i2, str2)));
            }
        }
    }

    private static void showStartPlayVideoDialog(Context context, String str, int i, int i2, String str2) {
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
            aVar.cB(TbadkCoreApplication.m9getInst().getString(w.l.play_video_mobile_tip));
            aVar.a(w.l.confirm, new h(context, str, i, i2, str2));
            aVar.b(w.l.cancel, new i());
            aVar.b(Z).tc();
        }
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        return (!TbadkCoreApplication.m9getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (pluginConfig = PluginPackageManager.jx().getPluginConfig(PKG_NAME_VIDEO)) == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1 || com.baidu.adp.plugin.packageManager.pluginSettings.c.ka().findPluginSetting(PKG_NAME_VIDEO) == null) ? false : true;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cB(str);
            aVar.a(str2, new j(pageActivity, tbPageContext));
            aVar.b(w.l.cancel, new k());
            aVar.b(tbPageContext).tc();
        }
    }
}
