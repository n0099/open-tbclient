package com.baidu.tbadk.pluginArch;

import android.content.SharedPreferences;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginLogger {
    public static final String DEBUGKEY = "pluginarch";
    public static final String KEY_COUNT = "_count";
    public static final String KEY_FAILURE = "_failure";
    public static final String KEY_PLUGINNAME = "pname";
    public static final String KEY_REASON = "reason";
    public static final String KEY_SUCCESS = "_success";
    public static final String KEY_WROKFLOW = "workflow";
    public static final String WORKFLOW_NODE_DEXLOADER = "plugin_dexloader";
    public static final String WORKFLOW_NODE_DOWNLOAD = "plugin_download";
    public static final String WORKFLOW_NODE_GETINSTANCE = "plugin_getinst";
    public static final String WORKFLOW_NODE_INSTALL = "plugin_install";
    public static final String WORKFLOW_NODE_LOAD = "plugin_load";
    public static final String WORKFLOW_NODE_USE = "plugin_use";
    private static HashMap<String, Integer> sWorkflowSuccessCount = new HashMap<>();

    public static void logSuccess(String str) {
        if (str != null) {
            Integer num = sWorkflowSuccessCount.get(str);
            if (num == null) {
                num = 0;
            }
            sWorkflowSuccessCount.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static void logSuccess(String str, String str2) {
        logSuccess(str);
        if (str != null && str2 != null && getStatus(str, str2)) {
            q logItem = getLogItem();
            logItem.n(KEY_WROKFLOW, String.valueOf(str) + KEY_SUCCESS);
            logItem.n(KEY_PLUGINNAME, str2);
            appendOtherInfo(logItem);
            f.er().a(DEBUGKEY, logItem);
            removeStatus(str, str2);
        }
    }

    public static void logFailure(String str, String str2, String str3) {
        q logItem = getLogItem();
        if (str != null) {
            logItem.n(KEY_WROKFLOW, String.valueOf(str) + KEY_FAILURE);
        }
        if (str2 != null) {
            logItem.n(KEY_REASON, str2);
        }
        if (str3 != null) {
            logItem.n(KEY_PLUGINNAME, str3);
        }
        setStatus(str, str3, true);
        appendCountLog(logItem);
        appendOtherInfo(logItem);
        f.er().a(DEBUGKEY, logItem);
    }

    public static void updateToServer() {
        q logItem = getLogItem();
        appendCountLog(logItem);
        appendOtherInfo(logItem);
        f.er().a(DEBUGKEY, logItem);
    }

    private static void appendOtherInfo(q qVar) {
        if (qVar != null && PluginFileHelper.OS_ARCH != null) {
            qVar.n("arch", PluginFileHelper.OS_ARCH);
        }
    }

    private static void appendCountLog(q qVar) {
        if (qVar != null) {
            for (Map.Entry<String, Integer> entry : sWorkflowSuccessCount.entrySet()) {
                qVar.n(String.valueOf(entry.getKey()) + KEY_COUNT, String.valueOf(entry.getValue()));
            }
            sWorkflowSuccessCount.clear();
        }
    }

    public static q getLogItem() {
        return f.er().ag("dbg");
    }

    private static void setStatus(String str, String str2, boolean z) {
        SharedPreferences.Editor edit = TbadkApplication.m251getInst().getApp().getSharedPreferences(DEBUGKEY, 0).edit();
        edit.putBoolean(String.valueOf(str) + str2, z);
        edit.commit();
    }

    private static boolean getStatus(String str, String str2) {
        return TbadkApplication.m251getInst().getApp().getSharedPreferences(DEBUGKEY, 0).getBoolean(String.valueOf(str) + str2, false);
    }

    private static void removeStatus(String str, String str2) {
        SharedPreferences.Editor edit = TbadkApplication.m251getInst().getApp().getSharedPreferences(DEBUGKEY, 0).edit();
        edit.remove(String.valueOf(str) + str2);
        edit.commit();
    }
}
