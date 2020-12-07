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
/* loaded from: classes4.dex */
public class d implements e {
    private boolean aUy;
    private String brl;
    private i gQV;
    private a gRe;
    private b gRh;
    private n gRi;
    private int gRj;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bWA();

        void c(k kVar);

        void d(k kVar);

        void mQ(boolean z);

        void vP(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void K(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bWC();

        void cu(List<k> list);

        void g(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.brl = str;
        this.aUy = z;
    }

    public void a(b bVar) {
        this.gRh = bVar;
    }

    public void a(a aVar) {
        this.gRe = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bWG() {
        if (this.gQV == null) {
            this.gQV = new i();
            this.gQV.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gQV.c(this.brl, this.gRj, 20, this.mType);
    }

    public void vS(int i) {
        if (this.gRe != null) {
            this.gRe.vP(i);
        }
    }

    public void bWH() {
        if (this.gRi != null) {
            this.gRi.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gRi != null && (datas = this.gRi.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gQR = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gRi.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gRe != null) {
            this.gRe.c(kVar);
        }
    }

    public void bWA() {
        if (this.gRe != null) {
            this.gRe.bWA();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gRj = 1;
        bWI();
        bWG();
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
        this.gRh = null;
        this.gRe = null;
        if (this.gQV != null) {
            this.gQV.release();
        }
    }

    private void bWI() {
        this.gRi = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.gRi.setType(1);
                break;
            case 2:
                this.gRi.setType(0);
                break;
        }
        this.gRi.gr(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gRi.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.gRe != null) {
                    d.this.gRe.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.gRe != null) {
                    d.this.gRe.d(kVar);
                }
            }
        });
        if (this.gRh != null) {
            this.gRh.a(this.gRi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gRe != null) {
            this.gRe.mQ(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gRj = i + 1;
            if (this.gRi != null) {
                if (i == 1) {
                    if (this.gRh != null) {
                        this.gRh.cu(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gRi.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gRi.ct(list);
                }
            }
        } else if (this.gRj == 1) {
            if (this.gRh != null) {
                this.gRh.bWC();
                return;
            }
            return;
        }
        if (this.gRh != null) {
            this.gRh.K(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bjr))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.biP));
                        break;
                    case 2:
                        str = aVar.biU;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.biQ));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gRh != null) {
                    this.gRh.g(str, aVar.biT, aVar.biN, str2, aVar.liveStatus == 1 && !this.aUy);
                }
            }
        }
    }
}
