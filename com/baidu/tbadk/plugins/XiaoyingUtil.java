package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.XiaoyingPlayerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XiaoyingUtil {
    public static final String EXTRA_PORTAIT = "extra_portait";
    public static final String EXTRA_SHOW_TIME = "extra_show_time";
    public static final String EXTRA_UID = "extra_uid";
    public static final String EXTRA_USER_NAME = "extra_user_name";
    public static final String PKG_NAME_XIAOYING = "com.quvideo.xiaoying";
    private static final long START_INTERVAL_TIME = 3000;
    public static final String URL_EVENT_REPORT = "http://reportevent.xiaoying.co/event";
    private static long lastStartTime;
    private static String lastUid;
    private static String shareUid;
    private static int showTime;

    public static boolean isXiaoyingForbidden() {
        return PluginPackageManager.lR().bs(PKG_NAME_XIAOYING);
    }

    public static int getShowTime() {
        return showTime;
    }

    public static void setShowTime(int i) {
        showTime = i;
    }

    public static boolean isXiaoyingInstalled() {
        return PluginPackageManager.lR().bm(PKG_NAME_XIAOYING) && TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_START_XIAOYING);
    }

    public static void startXiaoying(Context context) {
        if (context != null) {
            if (!i.iM()) {
                BdToast.b(context, context.getString(i.h.neterror)).sW();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (lastStartTime <= 0 || elapsedRealtime - lastStartTime >= START_INTERVAL_TIME) {
                lastStartTime = elapsedRealtime;
                if (TextUtils.equals(lastUid, TbadkCoreApplication.getCurrentAccount()) && !StringUtils.isNull(shareUid)) {
                    startXiaoyingInternal(context, shareUid);
                } else {
                    new a(context).execute(new String[0]);
                }
            }
        }
    }

    public static void startPlayXiaoyingVideo(Context context, String str) {
        if (context != null && !StringUtils.isNull(str)) {
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(XiaoyingPlayerConfig.class)) {
                BdToast.b(context, context.getString(i.h.plugin_xiaoying_install_fail)).sW();
            } else if (!com.baidu.adp.lib.util.i.iM()) {
                BdToast.b(context, context.getString(i.h.neterror)).sW();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new XiaoyingPlayerConfig(context, str)));
            }
        }
    }

    public static boolean showXiaoyingTool() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginSetting findPluginSetting;
        if (!TbadkCoreApplication.m411getInst().isXiaoyingAvaliable() || Build.VERSION.SDK_INT < 14 || (pluginConfig = PluginPackageManager.lR().getPluginConfig(PKG_NAME_XIAOYING)) == null || TextUtils.isEmpty(pluginConfig.display_name) || pluginConfig.forbidden == 1 || (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting(PKG_NAME_XIAOYING)) == null) {
            return false;
        }
        return pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cu(str);
            aVar.a(str2, new c(pageActivity, tbPageContext));
            aVar.b(i.h.cancel, new d());
            aVar.b(tbPageContext).sO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startXiaoyingInternal(Context context, String str) {
        if (context != null && !StringUtils.isNull(str)) {
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            IntentConfig intentConfig = new IntentConfig(context);
            intentConfig.getIntent().putExtra(EXTRA_UID, str);
            intentConfig.getIntent().putExtra(EXTRA_PORTAIT, String.valueOf(TbConfig.getPhotoSmallAddress()) + TbadkCoreApplication.getCurrentPortrait());
            intentConfig.getIntent().putExtra(EXTRA_USER_NAME, currentAccountName);
            intentConfig.getIntent().putExtra(EXTRA_SHOW_TIME, getShowTime());
            intentConfig.setRequestCode(13010);
            intentConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_START_XIAOYING, intentConfig), (Class) null);
        }
    }

    public static void reportEvent(String str, String str2, String str3, String str4, String str5) {
        new e(str, str2, str3, str4, str5).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String buildEventJSON(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TID", str);
            jSONObject.put("UID", shareUid);
            jSONObject.put("PID", str2);
            jSONObject.put("FID", str3);
            jSONObject.put("H5", str4);
            jSONObject.put("BarName", str5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Void, String> {
        private Context context;

        public a(Context context) {
            this.context = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.equals(XiaoyingUtil.lastUid, currentAccount) && !StringUtils.isNull(XiaoyingUtil.shareUid)) {
                return XiaoyingUtil.shareUid;
            }
            w wVar = new w(TbConfig.GET_AUTHORIZE_ID);
            wVar.o("uid", currentAccount);
            wVar.o("_client_version", TbConfig.getVersion());
            wVar.o("method", "uidEncode");
            String tD = wVar.tD();
            if (!wVar.uh() || StringUtils.isNull(tD)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(tD);
                if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 0) {
                    String optString = jSONObject.optString("uid");
                    if (!StringUtils.isNull(optString)) {
                        XiaoyingUtil.lastUid = currentAccount;
                        XiaoyingUtil.shareUid = optString;
                    }
                    return optString;
                }
                return null;
            } catch (JSONException e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (this.context != null && !StringUtils.isNull(str)) {
                XiaoyingUtil.startXiaoyingInternal(this.context, str);
            }
        }
    }
}
