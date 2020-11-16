package com.baidu.tieba.frs.f;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class d {
    private e jih;
    private LongSparseArray<Integer> jii = new LongSparseArray<>();
    private com.baidu.tieba.frs.gametab.c jij;

    public d() {
        this.jih = null;
        this.jih = new e();
    }

    public e cEN() {
        return this.jih;
    }

    public int fM(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jii.get(j);
        if (num == null) {
            this.jii.put(j, 1);
            return 1;
        }
        this.jii.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void fN(long j) {
        if (j != 0) {
            this.jii.remove(j);
        }
    }

    public void eY(String str, String str2) {
        this.jih.fe(str, str2);
    }

    public boolean eZ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jih == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jih.fb(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jih.fc(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fd = this.jih.fd(str, str2);
                if (fd != 0 && System.currentTimeMillis() - fd <= 604800000) {
                    return true;
                }
                return this.jih.fa(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jij == null) {
                this.jij = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jij.Kg(str3);
            }
            this.jij.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.ff(str, str2);
                    }
                    TiebaStatic.log(new ar("c13982").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jij.ckB();
            TiebaStatic.log(new ar("c13894").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void cEO() {
        if (this.jij != null) {
            this.jij.cCT();
        }
    }
}
