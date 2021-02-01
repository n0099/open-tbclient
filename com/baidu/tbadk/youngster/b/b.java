package com.baidu.tbadk.youngster.b;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private String fNd;
    private final SharedPreferences gbO = TbadkCoreApplication.getInst().getSharedPreferences("youngster_tip_sp", 0);
    private String mUid;

    public b(String str, String str2) {
        this.mUid = str;
        this.fNd = str2;
    }

    public long bJc() {
        if (ee(this.mUid, this.fNd)) {
            return this.gbO.getLong(this.mUid + '_' + this.fNd + "_youngster_tip_time", 0L);
        }
        return 0L;
    }

    public int bJd() {
        if (ee(this.mUid, this.fNd)) {
            return this.gbO.getInt(this.mUid + '_' + this.fNd + "_youngster_tip_times", 0);
        }
        return 0;
    }

    public void eQ(long j) {
        if (ee(this.mUid, this.fNd)) {
            String str = this.mUid + '_' + this.fNd + "_youngster_tip_times";
            String str2 = this.mUid + '_' + this.fNd + "_youngster_tip_time";
            int i = this.gbO.getInt(str, 0);
            SharedPreferences.Editor edit = this.gbO.edit();
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
