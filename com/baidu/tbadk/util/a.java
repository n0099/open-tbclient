package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkSettings;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a aqA = null;

    private a() {
    }

    public static synchronized a Db() {
        a aVar;
        synchronized (a.class) {
            if (aqA == null) {
                aqA = new a();
            }
            aVar = aqA;
        }
        return aVar;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                E(0L);
                bf(false);
                eH(null);
                setStartTime(0);
                ee(0);
            } else {
                E(jSONObject.optLong("ad_time"));
                bf(jSONObject.optInt("ad_enabled") == 1);
                eH(jSONObject.getString("ad_url"));
                setStartTime(jSONObject.getInt("start_time"));
                ee(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void Dc() {
        String Dg = Dg();
        if (!TextUtils.isEmpty(Dg)) {
            com.baidu.adp.lib.f.d.hB().a(Dg, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public boolean Dd() {
        if (!Dh()) {
            return false;
        }
        long De = De() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (getStartTime() * 1000 > currentTimeMillis || currentTimeMillis > De) {
            return false;
        }
        return true;
    }

    public int getStartTime() {
        return TbadkSettings.getInst().loadInt("ad_start_time", 0);
    }

    public int De() {
        return TbadkSettings.getInst().loadInt("ad_end_time", 0);
    }

    public long Df() {
        return TbadkSettings.getInst().loadLong("ad_time", 0L);
    }

    public String Dg() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    public boolean Dh() {
        return TbadkSettings.getInst().loadBoolean("ad_enabled", false);
    }

    public void E(long j) {
        TbadkSettings.getInst().saveLong("ad_time", j);
    }

    public void eH(String str) {
        TbadkSettings.getInst().saveString("ad_url", str);
    }

    public void bf(boolean z) {
        TbadkSettings.getInst().saveBoolean("ad_enabled", z);
    }

    public void setStartTime(int i) {
        TbadkSettings.getInst().saveInt("ad_start_time", i);
    }

    public void ee(int i) {
        TbadkSettings.getInst().saveInt("ad_end_time", i);
    }
}
