package com.baidu.tbadk.youngster.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private String fKR;
    private final SharedPreferences fZw = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    private String mUid;

    public b(String str, String str2) {
        this.mUid = str;
        this.fKR = str2;
    }

    public long bIJ() {
        if (eh(this.mUid, this.fKR)) {
            return this.fZw.getLong(this.mUid + '_' + this.fKR + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int bIK() {
        if (eh(this.mUid, this.fKR)) {
            return this.fZw.getInt(this.mUid + '_' + this.fKR + "_youngster_tip_times", 0);
        }
        return 0;
    }

    public void eK(long j) {
        if (eh(this.mUid, this.fKR)) {
            String str = this.mUid + '_' + this.fKR + "_youngster_tip_times";
            String str2 = this.mUid + '_' + this.fKR + "_youngster_tip_time";
            int i = this.fZw.getInt(str, 0);
            SharedPreferences.Editor edit = this.fZw.edit();
            if (i + 1 <= 10) {
                i++;
            }
            edit.putInt(str, i);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    private boolean eh(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
