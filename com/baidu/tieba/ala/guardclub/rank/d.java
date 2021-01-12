package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.guardclub.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.n;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements e {
    private boolean aRd;
    private String bre;
    private i gYe;
    private a gYn;
    private b gYq;
    private n gYr;
    private int gYs;
    private Context mContext;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void bVp();

        void c(k kVar);

        void d(k kVar);

        void nm(boolean z);

        void uu(int i);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bVr();

        void cB(List<k> list);

        void h(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bre = str;
        this.aRd = z;
    }

    public void a(b bVar) {
        this.gYq = bVar;
    }

    public void a(a aVar) {
        this.gYn = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bVv() {
        if (this.gYe == null) {
            this.gYe = new i();
            this.gYe.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gYe.c(this.bre, this.gYs, 20, this.mType);
    }

    public void ux(int i) {
        if (this.gYn != null) {
            this.gYn.uu(i);
        }
    }

    public void bVw() {
        if (this.gYr != null) {
            this.gYr.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gYr != null && (datas = this.gYr.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gYa = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gYr.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gYn != null) {
            this.gYn.c(kVar);
        }
    }

    public void bVp() {
        if (this.gYn != null) {
            this.gYn.bVp();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gYs = 1;
        bVx();
        bVv();
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
        this.gYq = null;
        this.gYn = null;
        if (this.gYe != null) {
            this.gYe.release();
        }
    }

    private void bVx() {
        this.gYr = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.gYr.setType(1);
                break;
            case 2:
                this.gYr.setType(0);
                break;
        }
        this.gYr.eQ(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gYr.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.gYn != null) {
                    d.this.gYn.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.gYn != null) {
                    d.this.gYn.d(kVar);
                }
            }
        });
        if (this.gYq != null) {
            this.gYq.a(this.gYr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gYn != null) {
            this.gYn.nm(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gYs = i + 1;
            if (this.gYr != null) {
                if (i == 1) {
                    if (this.gYq != null) {
                        this.gYq.cB(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gYr.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gYr.cA(list);
                }
            }
        } else if (this.gYs == 1) {
            if (this.gYq != null) {
                this.gYq.bVr();
                return;
            }
            return;
        }
        if (this.gYq != null) {
            this.gYq.M(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bgg))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bfE));
                        break;
                    case 2:
                        str = aVar.bfJ;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.bfF));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gYq != null) {
                    this.gYq.h(str, aVar.bfI, aVar.bfC, str2, aVar.liveStatus == 1 && !this.aRd);
                }
            }
        }
    }
}
