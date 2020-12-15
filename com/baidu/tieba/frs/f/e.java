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
/* loaded from: classes22.dex */
public class e {
    private f jvL;
    private LongSparseArray<Integer> jvM;
    private com.baidu.tieba.frs.gametab.c jvN;
    private d jvO;

    public e() {
        this.jvL = null;
        this.jvL = new f();
        this.jvM = new LongSparseArray<>();
    }

    public e(String str, String str2) {
        this.jvL = null;
        this.jvO = new d(str, str2);
    }

    public f cKd() {
        return this.jvL;
    }

    public int gr(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jvM.get(j);
        if (num == null) {
            this.jvM.put(j, 1);
            return 1;
        }
        this.jvM.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void gs(long j) {
        if (j != 0) {
            this.jvM.remove(j);
        }
    }

    public void fe(String str, String str2) {
        this.jvL.fk(str, str2);
    }

    public boolean ff(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jvL == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jvL.fh(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jvL.fi(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fj = this.jvL.fj(str, str2);
                if (fj != 0 && System.currentTimeMillis() - fj <= 604800000) {
                    return true;
                }
                return this.jvL.fg(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jvN == null) {
                this.jvN = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jvN.Lm(str3);
            }
            this.jvN.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fl(str, str2);
                    }
                    TiebaStatic.log(new ar("c13982").dY("fid", str2).dY("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jvN.coR();
            TiebaStatic.log(new ar("c13894").dY("fid", str2).dY("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void c(Activity activity, String str, String str2) {
        if (activity != null && this.jvO.cKc()) {
            if (this.jvN == null) {
                this.jvN = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.jvN.Ln(str);
            this.jvN.setForumId(str2);
            this.jvN.cIh();
        }
    }

    public void cKe() {
        if (this.jvN != null) {
            this.jvN.cIf();
        }
    }
}
