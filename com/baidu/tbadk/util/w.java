package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class w {
    private static w fkB = null;
    private String fkA;
    private Runnable fkC = new Runnable() { // from class: com.baidu.tbadk.util.w.1
        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(w.this.mFrom));
            hashMap.put("field_id", w.this.mFieldId);
            if (w.this.mFrom == 2) {
                hashMap.put("fid", w.this.fkA);
            }
            hashMap.put("animated", false);
            hashMap.put("transparent", true);
            hashMap.put("swipeback", false);
            if (PluginPackageManager.pT().cC("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(w.this.fkC, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                com.baidu.tbadk.core.sharedPref.b.blO().putLong("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    };
    private String mFieldId;
    private int mFrom;

    private w() {
    }

    public static synchronized w bzv() {
        w wVar;
        synchronized (w.class) {
            if (fkB == null) {
                fkB = new w();
            }
            wVar = fkB;
        }
        return wVar;
    }

    private boolean a(int i, NewGodData newGodData) {
        if (i != 5) {
            return (((((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_new_god_dialog_showed_time", 0L)) + IMConnection.RETRY_DELAY_TIMES) > Config.THREAD_IMAGE_SAVE_MAX_TIME ? 1 : (((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_new_god_dialog_showed_time", 0L)) + IMConnection.RETRY_DELAY_TIMES) == Config.THREAD_IMAGE_SAVE_MAX_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
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
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fkC, z ? IMConnection.RETRY_DELAY_TIMES : 0L);
        }
    }

    public void removeCallbacks() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fkC);
    }

    public void setFid(String str) {
        this.fkA = str;
    }
}
