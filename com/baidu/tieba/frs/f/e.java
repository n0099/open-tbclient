package com.baidu.tieba.frs.f;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Set;
/* loaded from: classes21.dex */
public class e {
    private final SharedPreferences iAo = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);

    public boolean eO(String str, String str2) {
        if (eT(str, str2)) {
            return this.iAo.getBoolean(str + '_' + str2 + "_show", false);
        }
        return false;
    }

    public long eP(String str, String str2) {
        if (eT(str, str2)) {
            return this.iAo.getLong(str + '_' + str2 + "_show_time", 0L);
        }
        return 0L;
    }

    public void a(String str, String str2, long j, boolean z) {
        if (eT(str, str2)) {
            String str3 = str + '_' + str2 + "_show_time";
            String str4 = str + '_' + str2 + "_show_cnt";
            int i = this.iAo.getInt(str4, 0);
            SharedPreferences.Editor edit = this.iAo.edit();
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

    public int eQ(String str, String str2) {
        if (eT(str, str2)) {
            return this.iAo.getInt(str + '_' + str2 + "_show_cnt", 0);
        }
        return 0;
    }

    public void h(String str, String str2, long j) {
        if (eT(str, str2)) {
            SharedPreferences.Editor edit = this.iAo.edit();
            edit.putLong(str + '_' + str2 + "_visit_time", j);
            edit.apply();
        }
    }

    public long eR(String str, String str2) {
        if (eT(str, str2)) {
            return this.iAo.getLong(str + '_' + str2 + "_visit_time", 0L);
        }
        return 0L;
    }

    public void eS(String str, String str2) {
        if (eT(str, str2)) {
            String str3 = str + '_' + str2;
            Set<String> keySet = this.iAo.getAll().keySet();
            SharedPreferences.Editor edit = this.iAo.edit();
            for (String str4 : keySet) {
                if (str4.startsWith(str3)) {
                    edit.remove(str4);
                }
            }
            edit.apply();
        }
    }

    private boolean eT(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
