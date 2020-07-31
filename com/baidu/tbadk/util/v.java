package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v {
    private static v eKP = null;
    private String eKO;
    private Runnable eKQ = new Runnable() { // from class: com.baidu.tbadk.util.v.1
        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(v.this.mFrom));
            hashMap.put("field_id", v.this.mFieldId);
            if (v.this.mFrom == 2) {
                hashMap.put("fid", v.this.eKO);
            }
            hashMap.put("animated", false);
            hashMap.put("transparent", true);
            hashMap.put("swipeback", false);
            if (PluginPackageManager.op().cu("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(v.this.eKQ, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    };
    private String mFieldId;
    private int mFrom;

    private v() {
    }

    public static synchronized v bmO() {
        v vVar;
        synchronized (v.class) {
            if (eKP == null) {
                eKP = new v();
            }
            vVar = eKP;
        }
        return vVar;
    }

    private boolean a(int i, NewGodData newGodData) {
        if (i != 5) {
            return (((((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_new_god_dialog_showed_time", 0L)) + 3000) > Config.THREAD_IMAGE_SAVE_MAX_TIME ? 1 : (((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_new_god_dialog_showed_time", 0L)) + 3000) == Config.THREAD_IMAGE_SAVE_MAX_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return true;
    }

    public void b(int i, NewGodData newGodData) {
        a(i, newGodData, true);
    }

    public void a(int i, NewGodData newGodData, boolean z) {
        if (a(i, newGodData)) {
            removeCallbacks();
            this.mFrom = i;
            this.mFieldId = newGodData.getFieldId();
            com.baidu.adp.lib.f.e.lt().postDelayed(this.eKQ, z ? 3000L : 0L);
        }
    }

    public void removeCallbacks() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eKQ);
    }

    public void setFid(String str) {
        this.eKO = str;
    }
}
