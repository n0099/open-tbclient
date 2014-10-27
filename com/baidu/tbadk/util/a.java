package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkSettings;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a ZE = null;

    private a() {
    }

    public static synchronized a uR() {
        a aVar;
        synchronized (a.class) {
            if (ZE == null) {
                ZE = new a();
            }
            aVar = ZE;
        }
        return aVar;
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                u(0L);
                aJ(false);
                dN(null);
                setStartTime(0);
                dq(0);
            } else {
                u(jSONObject.optLong("ad_time"));
                aJ(jSONObject.optInt("ad_enabled") == 1);
                dN(jSONObject.getString("ad_url"));
                setStartTime(jSONObject.getInt("start_time"));
                dq(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void uS() {
        String uW = uW();
        if (!TextUtils.isEmpty(uW)) {
            com.baidu.adp.lib.f.d.ef().a(uW, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public boolean uT() {
        if (!uX()) {
            return false;
        }
        long uU = uU() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (getStartTime() * 1000 > currentTimeMillis || currentTimeMillis > uU) {
            return false;
        }
        return true;
    }

    public int getStartTime() {
        return TbadkSettings.getInst().loadInt("ad_start_time", 0);
    }

    public int uU() {
        return TbadkSettings.getInst().loadInt("ad_end_time", 0);
    }

    public long uV() {
        return TbadkSettings.getInst().loadLong("ad_time", 0L);
    }

    public String uW() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }

    public boolean uX() {
        return TbadkSettings.getInst().loadBoolean("ad_enabled", false);
    }

    public void u(long j) {
        TbadkSettings.getInst().saveLong("ad_time", j);
    }

    public void dN(String str) {
        TbadkSettings.getInst().saveString("ad_url", str);
    }

    public void aJ(boolean z) {
        TbadkSettings.getInst().saveBoolean("ad_enabled", z);
    }

    public void setStartTime(int i) {
        TbadkSettings.getInst().saveInt("ad_start_time", i);
    }

    public void dq(int i) {
        TbadkSettings.getInst().saveInt("ad_end_time", i);
    }
}
