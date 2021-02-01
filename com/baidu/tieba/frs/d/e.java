package com.baidu.tieba.frs.d;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private f jJe;
    private LongSparseArray<Integer> jJf;
    private com.baidu.tieba.frs.gametab.c jJg;
    private d jJh;

    public e() {
        this.jJe = null;
        this.jJe = new f();
        this.jJf = new LongSparseArray<>();
    }

    public e(String str, String str2) {
        this.jJe = null;
        this.jJh = new d(str, str2);
    }

    public f cKA() {
        return this.jJe;
    }

    public int gw(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jJf.get(j);
        if (num == null) {
            this.jJf.put(j, 1);
            return 1;
        }
        this.jJf.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void gx(long j) {
        if (j != 0) {
            this.jJf.remove(j);
        }
    }

    public void fe(String str, String str2) {
        this.jJe.fk(str, str2);
    }

    public boolean ff(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jJe == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jJe.fh(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jJe.fi(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fj = this.jJe.fj(str, str2);
                if (fj != 0 && System.currentTimeMillis() - fj <= 604800000) {
                    return true;
                }
                return this.jJe.fg(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jJg == null) {
                this.jJg = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jJg.KM(str3);
            }
            this.jJg.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fl(str, str2);
                    }
                    TiebaStatic.log(new ar("c13982").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jJg.coY();
            TiebaStatic.log(new ar("c13894").dR("fid", str2).dR("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void c(Activity activity, String str, String str2) {
        if (activity != null && this.jJh.cKz()) {
            if (this.jJg == null) {
                this.jJg = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.jJg.KN(str);
            this.jJg.setForumId(str2);
            this.jJg.cID();
        }
    }

    public void cKB() {
        if (this.jJg != null) {
            this.jJg.cIB();
        }
    }
}
