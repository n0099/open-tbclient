package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkSettings;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ahQ = null;

    private a() {
    }

    public static synchronized a zH() {
        a aVar;
        synchronized (a.class) {
            if (ahQ == null) {
                ahQ = new a();
            }
            aVar = ahQ;
        }
        return aVar;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                E(0L);
                ba(false);
                eC(null);
                setStartTime(0);
                ea(0);
            } else {
                E(jSONObject.optLong("ad_time"));
                ba(jSONObject.optInt("ad_enabled") == 1);
                eC(jSONObject.getString("ad_url"));
                setStartTime(jSONObject.getInt("start_time"));
                ea(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void zI() {
        String zM = zM();
        if (!TextUtils.isEmpty(zM)) {
            com.baidu.adp.lib.f.d.ec().a(zM, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public boolean zJ() {
        if (!zN()) {
            return false;
        }
        long zK = zK() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (getStartTime() * 1000 > currentTimeMillis || currentTimeMillis > zK) {
            return false;
        }
        return true;
    }

    public int getStartTime() {
        return TbadkSettings.getInst().loadInt("ad_start_time", 0);
    }

    public int zK() {
        return TbadkSettings.getInst().loadInt("ad_end_time", 0);
    }

    public long zL() {
        return TbadkSettings.getInst().loadLong("ad_time", 0L);
    }

    public String zM() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    public boolean zN() {
        return TbadkSettings.getInst().loadBoolean("ad_enabled", false);
    }

    public void E(long j) {
        TbadkSettings.getInst().saveLong("ad_time", j);
    }

    public void eC(String str) {
        TbadkSettings.getInst().saveString("ad_url", str);
    }

    public void ba(boolean z) {
        TbadkSettings.getInst().saveBoolean("ad_enabled", z);
    }

    public void setStartTime(int i) {
        TbadkSettings.getInst().saveInt("ad_start_time", i);
    }

    public void ea(int i) {
        TbadkSettings.getInst().saveInt("ad_end_time", i);
    }
}
