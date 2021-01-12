package com.baidu.tieba.frs.d;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private f jDA;
    private LongSparseArray<Integer> jDB;
    private com.baidu.tieba.frs.gametab.c jDC;
    private d jDD;

    public e() {
        this.jDA = null;
        this.jDA = new f();
        this.jDB = new LongSparseArray<>();
    }

    public e(String str, String str2) {
        this.jDA = null;
        this.jDD = new d(str, str2);
    }

    public f cJn() {
        return this.jDA;
    }

    public int gr(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jDB.get(j);
        if (num == null) {
            this.jDB.put(j, 1);
            return 1;
        }
        this.jDB.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void gs(long j) {
        if (j != 0) {
            this.jDB.remove(j);
        }
    }

    public void fe(String str, String str2) {
        this.jDA.fk(str, str2);
    }

    public boolean ff(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jDA == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jDA.fh(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jDA.fi(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fj = this.jDA.fj(str, str2);
                if (fj != 0 && System.currentTimeMillis() - fj <= 604800000) {
                    return true;
                }
                return this.jDA.fg(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jDC == null) {
                this.jDC = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jDC.Kb(str3);
            }
            this.jDC.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fl(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dW("fid", str2).dW("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jDC.cnT();
            TiebaStatic.log(new aq("c13894").dW("fid", str2).dW("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void c(Activity activity, String str, String str2) {
        if (activity != null && this.jDD.cJm()) {
            if (this.jDC == null) {
                this.jDC = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.jDC.Kc(str);
            this.jDC.setForumId(str2);
            this.jDC.cHq();
        }
    }

    public void cJo() {
        if (this.jDC != null) {
            this.jDC.cHo();
        }
    }
}
