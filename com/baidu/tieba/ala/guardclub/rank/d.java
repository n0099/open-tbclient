package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.guardclub.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements e {
    private boolean aVq;
    private String bhk;
    private i gga;
    private a ggj;
    private b ggm;
    private m ggn;
    private int ggo;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bLJ();

        void c(k kVar);

        void d(k kVar);

        void lx(boolean z);

        void tK(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void I(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bLL();

        void bW(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.bhk = str;
        this.aVq = z;
    }

    public void a(b bVar) {
        this.ggm = bVar;
    }

    public void a(a aVar) {
        this.ggj = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bLP() {
        if (this.gga == null) {
            this.gga = new i();
            this.gga.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gga.c(this.bhk, this.ggo, 20, this.mType);
    }

    public void tN(int i) {
        if (this.ggj != null) {
            this.ggj.tK(i);
        }
    }

    public void bLQ() {
        if (this.ggn != null) {
            this.ggn.notifyDataSetChanged();
        }
    }

    public void v(String str, long j) {
        List<k> datas;
        if (this.ggn != null && (datas = this.ggn.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gfW = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.ggn.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.ggj != null) {
            this.ggj.c(kVar);
        }
    }

    public void bLJ() {
        if (this.ggj != null) {
            this.ggj.bLJ();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.ggo = 1;
        bLR();
        bLP();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onResume() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onPause() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onDestoryView() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onDestroy() {
        this.ggm = null;
        this.ggj = null;
        if (this.gga != null) {
            this.gga.release();
        }
    }

    private void bLR() {
        this.ggn = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.ggn.setType(1);
                break;
            case 2:
                this.ggn.setType(0);
                break;
        }
        this.ggn.fJ(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.ggn.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.ggj != null) {
                    d.this.ggj.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.ggj != null) {
                    d.this.ggj.d(kVar);
                }
            }
        });
        if (this.ggm != null) {
            this.ggm.a(this.ggn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.ggj != null) {
            this.ggj.lx(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.ggo = i + 1;
            if (this.ggn != null) {
                if (i == 1) {
                    if (this.ggm != null) {
                        this.ggm.bW(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.ggn.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.ggn.bV(list);
                }
            }
        } else if (this.ggo == 1) {
            if (this.ggm != null) {
                this.ggm.bLL();
                return;
            }
            return;
        }
        if (this.ggm != null) {
            this.ggm.I(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.baI))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bai));
                        break;
                    case 2:
                        str = aVar.bao;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.baj));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.ggm != null) {
                    this.ggm.c(str, aVar.ban, aVar.bag, str2, aVar.liveStatus == 1 && !this.aVq);
                }
            }
        }
    }
}
