package com.baidu.tbadk.youngster.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private String fkA;
    private final SharedPreferences fzc = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    private String mUid;

    public b(String str, String str2) {
        this.mUid = str;
        this.fkA = str2;
    }

    public long bCX() {
        if (dV(this.mUid, this.fkA)) {
            return this.fzc.getLong(this.mUid + '_' + this.fkA + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int bCY() {
        if (dV(this.mUid, this.fkA)) {
            return this.fzc.getInt(this.mUid + '_' + this.fkA + "_youngster_tip_times", 0);
        }
        return 0;
    }

    public void dJ(long j) {
        if (dV(this.mUid, this.fkA)) {
            String str = this.mUid + '_' + this.fkA + "_youngster_tip_times";
            String str2 = this.mUid + '_' + this.fkA + "_youngster_tip_time";
            int i = this.fzc.getInt(str, 0);
            SharedPreferences.Editor edit = this.fzc.edit();
            if (i + 1 <= 10) {
                i++;
            }
            edit.putInt(str, i);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    private boolean dV(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
