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
    private f jIg;
    private LongSparseArray<Integer> jIh;
    private com.baidu.tieba.frs.gametab.c jIi;
    private d jIj;

    public e() {
        this.jIg = null;
        this.jIg = new f();
        this.jIh = new LongSparseArray<>();
    }

    public e(String str, String str2) {
        this.jIg = null;
        this.jIj = new d(str, str2);
    }

    public f cNf() {
        return this.jIg;
    }

    public int gr(long j) {
        if (j == 0) {
            return 0;
        }
        Integer num = this.jIh.get(j);
        if (num == null) {
            this.jIh.put(j, 1);
            return 1;
        }
        this.jIh.put(j, Integer.valueOf(num.intValue() + 1));
        return num.intValue() + 1;
    }

    public void gs(long j) {
        if (j != 0) {
            this.jIh.remove(j);
        }
    }

    public void ff(String str, String str2) {
        this.jIg.fl(str, str2);
    }

    public boolean fg(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || this.jIg == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jIg.fi(str, str2);
        if (currentTimeMillis >= BdKVCache.MILLS_1Hour) {
            if (this.jIg.fj(str, str2) <= 3 || currentTimeMillis >= BdKVCache.MILLS_30Days) {
                long fk = this.jIg.fk(str, str2);
                if (fk != 0 && System.currentTimeMillis() - fk <= 604800000) {
                    return true;
                }
                return this.jIg.fh(str, str2);
            }
            return false;
        }
        return false;
    }

    public void a(Activity activity, final String str, final String str2, String str3, final com.baidu.tieba.frs.vc.f fVar) {
        if (activity != null) {
            if (this.jIi == null) {
                this.jIi = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_tip);
            }
            if (!StringUtils.isNull(str3)) {
                this.jIi.Ll(str3);
            }
            this.jIi.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.d.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fVar != null) {
                        fVar.fm(str, str2);
                    }
                    TiebaStatic.log(new aq("c13982").dX("fid", str2).dX("uid", TbadkApplication.getCurrentAccount()));
                }
            });
            this.jIi.crL();
            TiebaStatic.log(new aq("c13894").dX("fid", str2).dX("uid", TbadkApplication.getCurrentAccount()));
        }
    }

    public void c(Activity activity, String str, String str2) {
        if (activity != null && this.jIj.cNe()) {
            if (this.jIi == null) {
                this.jIi = new com.baidu.tieba.frs.gametab.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.jIi.Lm(str);
            this.jIi.setForumId(str2);
            this.jIi.cLi();
        }
    }

    public void cNg() {
        if (this.jIi != null) {
            this.jIi.cLg();
        }
    }
}
