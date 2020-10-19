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
    private e iPc;
    private LongSparseArray<Integer> iPd = new LongSparseArray<>();
    private com.baidu.tieba.frs.gametab.c iPe;

    public d() {
        this.iPc = null;
        this.iPc = new e();
    }

    public e czA() {
        return this.iPc;
    }

    public int fm(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.iPd.get(j);
        if (num == null) {
            this.iPd.put(j, 1);
            return 1;
        }
        this.iPd.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void fn(long j) {
        if (j != 0) {
            this.iPd.remove(j);
        }
    }

    public void eT(String str, String str2) {
        this.iPc.eZ(str, str2);
    }

    public boolean eU(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.iPc == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.iPc.eW(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.iPc.eX(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long eY = this.iPc.eY(str, str2);
                if (eY != 0 && System.currentTimeMillis() - eY <= 604800000) {
                    return true;
                }
                return this.iPc.eV(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.iPe == null) {
                this.iPe = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.iPe.JP(str3);
            }
            this.iPe.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fa(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dK("fid", str2).dK("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.iPe.cfF();
            TiebaStatic.log(new aq("c13894").dK("fid", str2).dK("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void czB() {
        if (this.iPe != null) {
            this.iPe.cxH();
        }
    }
}
