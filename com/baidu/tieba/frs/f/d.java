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
    private e jhv;
    private LongSparseArray<Integer> jhw = new LongSparseArray<>();
    private com.baidu.tieba.frs.gametab.c jhx;

    public d() {
        this.jhv = null;
        this.jhv = new e();
    }

    public e cFi() {
        return this.jhv;
    }

    public int fJ(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jhw.get(j);
        if (num == null) {
            this.jhw.put(j, 1);
            return 1;
        }
        this.jhw.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void fK(long j) {
        if (j != 0) {
            this.jhw.remove(j);
        }
    }

    public void eY(String str, String str2) {
        this.jhv.fe(str, str2);
    }

    public boolean eZ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jhv == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jhv.fb(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jhv.fc(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fd = this.jhv.fd(str, str2);
                if (fd != 0 && System.currentTimeMillis() - fd <= 604800000) {
                    return true;
                }
                return this.jhv.fa(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jhx == null) {
                this.jhx = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jhx.KF(str3);
            }
            this.jhx.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.ff(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jhx.cli();
            TiebaStatic.log(new aq("c13894").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void cFj() {
        if (this.jhx != null) {
            this.jhx.cDp();
        }
    }
}
