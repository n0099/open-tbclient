package com.baidu.tbadk.youngster.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private final SharedPreferences fMQ = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    private String fyg;
    private String mUid;

    public b(String str, String str2) {
        this.mUid = str;
        this.fyg = str2;
    }

    public long bGI() {
        if (ec(this.mUid, this.fyg)) {
            return this.fMQ.getLong(this.mUid + '_' + this.fyg + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int bGJ() {
        if (ec(this.mUid, this.fyg)) {
            return this.fMQ.getInt(this.mUid + '_' + this.fyg + "_youngster_tip_times", 0);
        }
        return 0;
    }

    public void eh(long j) {
        if (ec(this.mUid, this.fyg)) {
            String str = this.mUid + '_' + this.fyg + "_youngster_tip_times";
            String str2 = this.mUid + '_' + this.fyg + "_youngster_tip_time";
            int i = this.fMQ.getInt(str, 0);
            SharedPreferences.Editor edit = this.fMQ.edit();
            if (i + 1 <= 10) {
                i++;
            }
            edit.putInt(str, i);
            edit.putLong(str2, j);
            edit.apply();
        }
    }

    private boolean ec(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
