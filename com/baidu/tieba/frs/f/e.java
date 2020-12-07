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
    private f jvJ;
    private LongSparseArray<Integer> jvK;
    private com.baidu.tieba.frs.gametab.c jvL;
    private d jvM;

    public e() {
        this.jvJ = null;
        this.jvJ = new f();
        this.jvK = new LongSparseArray<>();
    }

    public e(String str, String str2) {
        this.jvJ = null;
        this.jvM = new d(str, str2);
    }

    public f cKc() {
        return this.jvJ;
    }

    public int gr(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jvK.get(j);
        if (num == null) {
            this.jvK.put(j, 1);
            return 1;
        }
        this.jvK.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void gs(long j) {
        if (j != 0) {
            this.jvK.remove(j);
        }
    }

    public void fe(String str, String str2) {
        this.jvJ.fk(str, str2);
    }

    public boolean ff(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jvJ == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jvJ.fh(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jvJ.fi(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fj = this.jvJ.fj(str, str2);
                if (fj != 0 && System.currentTimeMillis() - fj <= 604800000) {
                    return true;
                }
                return this.jvJ.fg(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jvL == null) {
                this.jvL = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jvL.Lm(str3);
            }
            this.jvL.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fl(str, str2);
                    }
                    TiebaStatic.log(new ar("c13982").dY("fid", str2).dY("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jvL.coQ();
            TiebaStatic.log(new ar("c13894").dY("fid", str2).dY("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void c(Activity activity, String str, String str2) {
        if (activity != null && this.jvM.cKb()) {
            if (this.jvL == null) {
                this.jvL = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.jvL.Ln(str);
            this.jvL.setForumId(str2);
            this.jvL.cIg();
        }
    }

    public void cKd() {
        if (this.jvL != null) {
            this.jvL.cIe();
        }
    }
}
