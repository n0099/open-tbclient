package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkSettings;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ahN = null;

    private a() {
    }

    public static synchronized a zB() {
        a aVar;
        synchronized (a.class) {
            if (ahN == null) {
                ahN = new a();
            }
            aVar = ahN;
        }
        return aVar;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                E(0L);
                ba(false);
                ez(null);
                setStartTime(0);
                ea(0);
            } else {
                E(jSONObject.optLong("ad_time"));
                ba(jSONObject.optInt("ad_enabled") == 1);
                ez(jSONObject.getString("ad_url"));
                setStartTime(jSONObject.getInt("start_time"));
                ea(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void zC() {
        String zG = zG();
        if (!TextUtils.isEmpty(zG)) {
            com.baidu.adp.lib.f.d.ec().a(zG, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public boolean zD() {
        if (!zH()) {
            return false;
        }
        long zE = zE() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (getStartTime() * 1000 > currentTimeMillis || currentTimeMillis > zE) {
            return false;
        }
        return true;
    }

    public int getStartTime() {
        return TbadkSettings.getInst().loadInt("ad_start_time", 0);
    }

    public int zE() {
        return TbadkSettings.getInst().loadInt("ad_end_time", 0);
    }

    public long zF() {
        return TbadkSettings.getInst().loadLong("ad_time", 0L);
    }

    public String zG() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    public boolean zH() {
        return TbadkSettings.getInst().loadBoolean("ad_enabled", false);
    }

    public void E(long j) {
        TbadkSettings.getInst().saveLong("ad_time", j);
    }

    public void ez(String str) {
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
