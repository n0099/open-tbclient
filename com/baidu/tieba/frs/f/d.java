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
/* loaded from: classes21.dex */
public class d {
    private e iAj;
    private LongSparseArray<Integer> iAk = new LongSparseArray<>();
    private com.baidu.tieba.frs.gametab.c iAl;

    public d() {
        this.iAj = null;
        this.iAj = new e();
    }

    public e cwd() {
        return this.iAj;
    }

    public int eV(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.iAk.get(j);
        if (num == null) {
            this.iAk.put(j, 1);
            return 1;
        }
        this.iAk.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void eW(long j) {
        if (j != 0) {
            this.iAk.remove(j);
        }
    }

    public void eM(String str, String str2) {
        this.iAj.eS(str, str2);
    }

    public boolean eN(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.iAj == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.iAj.eP(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.iAj.eQ(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long eR = this.iAj.eR(str, str2);
                if (eR != 0 && System.currentTimeMillis() - eR <= 604800000) {
                    return true;
                }
                return this.iAj.eO(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.iAl == null) {
                this.iAl = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.iAl.Jc(str3);
            }
            this.iAl.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.eU(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dF("fid", str2).dF("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.iAl.ccj();
            TiebaStatic.log(new aq("c13894").dF("fid", str2).dF("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void cwe() {
        if (this.iAl != null) {
            this.iAl.cuk();
        }
    }
}
