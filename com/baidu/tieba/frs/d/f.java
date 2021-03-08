package com.baidu.tieba.frs.d;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Set;
/* loaded from: classes2.dex */
public class f {
    private final SharedPreferences gdp = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);

    public boolean fg(String str, String str2) {
        if (ee(str, str2)) {
            return this.gdp.getBoolean(str + '_' + str2 + "_show", false);
        }
        return false;
    }

    public long fh(String str, String str2) {
        if (ee(str, str2)) {
            return this.gdp.getLong(str + '_' + str2 + "_show_time", 0L);
        }
        return 0L;
    }

    public void e(String str, String str2, long j, boolean z) {
        if (ee(str, str2)) {
            String str3 = str + '_' + str2 + "_show_time";
            String str4 = str + '_' + str2 + "_show_cnt";
            int i = this.gdp.getInt(str4, 0);
            SharedPreferences.Editor edit = this.gdp.edit();
            if (i > 3) {
                edit.putInt(str4, i + 1);
            }
            edit.putLong(str3, j);
            if (z) {
                edit.putBoolean(str + '_' + str2 + "_show", true);
            }
            edit.apply();
        }
    }

    public int fi(String str, String str2) {
        if (ee(str, str2)) {
            return this.gdp.getInt(str + '_' + str2 + "_show_cnt", 0);
        }
        return 0;
    }

    public void k(String str, String str2, long j) {
        if (ee(str, str2)) {
            SharedPreferences.Editor edit = this.gdp.edit();
            edit.putLong(str + '_' + str2 + "_visit_time", j);
            edit.apply();
        }
    }

    public long fj(String str, String str2) {
        if (ee(str, str2)) {
            return this.gdp.getLong(str + '_' + str2 + "_visit_time", 0L);
        }
        return 0L;
    }

    public void fk(String str, String str2) {
        if (ee(str, str2)) {
            String str3 = str + '_' + str2;
            Set<String> keySet = this.gdp.getAll().keySet();
            SharedPreferences.Editor edit = this.gdp.edit();
            for (String str4 : keySet) {
                if (str4.startsWith(str3)) {
                    edit.remove(str4);
                }
            }
            edit.apply();
        }
    }

    private boolean ee(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
