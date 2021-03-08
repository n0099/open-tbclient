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
public class x {
    private static x fOE = null;
    private String fOD;
    private Runnable fOF = new Runnable() { // from class: com.baidu.tbadk.util.x.1
        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("from", String.valueOf(x.this.mFrom));
            hashMap.put("field_id", x.this.mFieldId);
            hashMap.put("type", Integer.valueOf(x.this.mType));
            hashMap.put("type_name", x.this.mTypeName);
            if (x.this.mFrom == 2) {
                hashMap.put("fid", x.this.fOD);
            }
            hashMap.put("animated", false);
            hashMap.put("transparent", true);
            hashMap.put("swipeback", false);
            if (PluginPackageManager.pv().cE("com.baidu.tieba.pluginFlutter")) {
                if (MessageManager.getInstance().findTask(2002015) == null) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(x.this.fOF, 0L);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GodDialog", hashMap)));
                com.baidu.tbadk.core.sharedPref.b.brR().putLong("key_new_god_dialog_showed_time", System.currentTimeMillis());
            }
        }
    };
    private String mFieldId;
    private int mFrom;
    private int mType;
    private String mTypeName;

    private x() {
    }

    public static synchronized x bFG() {
        x xVar;
        synchronized (x.class) {
            if (fOE == null) {
                fOE = new x();
            }
            xVar = fOE;
        }
        return xVar;
    }

    private boolean a(int i, NewGodData newGodData) {
        if (i != 5) {
            return (((((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_new_god_dialog_showed_time", 0L)) + IMConnection.RETRY_DELAY_TIMES) > Config.THREAD_IMAGE_SAVE_MAX_TIME ? 1 : (((System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_new_god_dialog_showed_time", 0L)) + IMConnection.RETRY_DELAY_TIMES) == Config.THREAD_IMAGE_SAVE_MAX_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
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
            this.mType = newGodData.getType();
            this.mTypeName = newGodData.getTypeName();
            com.baidu.adp.lib.f.e.mA().postDelayed(this.fOF, z ? IMConnection.RETRY_DELAY_TIMES : 0L);
        }
    }

    public void removeCallbacks() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fOF);
    }

    public void setFid(String str) {
        this.fOD = str;
    }
}
