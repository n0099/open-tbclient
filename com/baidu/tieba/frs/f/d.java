package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.tieba.frs.gametab.c jbA;
    private e jby;
    private LongSparseArray<Integer> jbz = new LongSparseArray<>();

    public d() {
        this.jby = null;
        this.jby = new e();
    }

    public e cCH() {
        return this.jby;
    }

    public int fn(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jbz.get(j);
        if (num == null) {
            this.jbz.put(j, 1);
            return 1;
        }
        this.jbz.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void fo(long j) {
        if (j != 0) {
            this.jbz.remove(j);
        }
    }

    public void eY(String str, String str2) {
        this.jby.fe(str, str2);
    }

    public boolean eZ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jby == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jby.fb(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jby.fc(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fd = this.jby.fd(str, str2);
                if (fd != 0 && System.currentTimeMillis() - fd <= 604800000) {
                    return true;
                }
                return this.jby.fa(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jbA == null) {
                this.jbA = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jbA.Ko(str3);
            }
            this.jbA.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.ff(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jbA.ciG();
            TiebaStatic.log(new aq("c13894").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void cCI() {
        if (this.jbA != null) {
            this.jbA.cAO();
        }
    }
}
