package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkSettings;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ahs = null;

    private a() {
    }

    public static synchronized a zq() {
        a aVar;
        synchronized (a.class) {
            if (ahs == null) {
                ahs = new a();
            }
            aVar = ahs;
        }
        return aVar;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                E(0L);
                aY(false);
                eC(null);
                setStartTime(0);
                dU(0);
            } else {
                E(jSONObject.optLong("ad_time"));
                aY(jSONObject.optInt("ad_enabled") == 1);
                eC(jSONObject.getString("ad_url"));
                setStartTime(jSONObject.getInt("start_time"));
                dU(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void zr() {
        String zv = zv();
        if (!TextUtils.isEmpty(zv)) {
            com.baidu.adp.lib.f.d.ee().a(zv, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public boolean zs() {
        if (!zw()) {
            return false;
        }
        long zt = zt() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (getStartTime() * 1000 > currentTimeMillis || currentTimeMillis > zt) {
            return false;
        }
        return true;
    }

    public int getStartTime() {
        return TbadkSettings.getInst().loadInt("ad_start_time", 0);
    }

    public int zt() {
        return TbadkSettings.getInst().loadInt("ad_end_time", 0);
    }

    public long zu() {
        return TbadkSettings.getInst().loadLong("ad_time", 0L);
    }

    public String zv() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    public boolean zw() {
        return TbadkSettings.getInst().loadBoolean("ad_enabled", false);
    }

    public void E(long j) {
        TbadkSettings.getInst().saveLong("ad_time", j);
    }

    public void eC(String str) {
        TbadkSettings.getInst().saveString("ad_url", str);
    }

    public void aY(boolean z) {
        TbadkSettings.getInst().saveBoolean("ad_enabled", z);
    }

    public void setStartTime(int i) {
        TbadkSettings.getInst().saveInt("ad_start_time", i);
    }

    public void dU(int i) {
        TbadkSettings.getInst().saveInt("ad_end_time", i);
    }
}
