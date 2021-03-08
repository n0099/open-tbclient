package com.baidu.tbadk.youngster.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private String fOD;
    private final SharedPreferences gdp = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    private String mUid;

    public b(String str, String str2) {
        this.mUid = str;
        this.fOD = str2;
    }

    public long bJg() {
        if (ee(this.mUid, this.fOD)) {
            return this.gdp.getLong(this.mUid + '_' + this.fOD + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int bJh() {
        if (ee(this.mUid, this.fOD)) {
            return this.gdp.getInt(this.mUid + '_' + this.fOD + "_youngster_tip_times", 0);
        }
        return 0;
    }

    public void eQ(long j) {
        if (ee(this.mUid, this.fOD)) {
            String str = this.mUid + '_' + this.fOD + "_youngster_tip_times";
            String str2 = this.mUid + '_' + this.fOD + "_youngster_tip_time";
            int i = this.gdp.getInt(str, 0);
            SharedPreferences.Editor edit = this.gdp.edit();
            if (i + 1 <= 10) {
                i++;
            }
            edit.putInt(str, i);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    private boolean ee(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
