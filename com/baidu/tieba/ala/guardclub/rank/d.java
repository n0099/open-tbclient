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
    private i gQX;
    private a gRg;
    private b gRj;
    private n gRk;
    private int gRl;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bWB();

        void c(k kVar);

        void d(k kVar);

        void mQ(boolean z);

        void vP(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void K(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bWD();

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
        this.gRj = bVar;
    }

    public void a(a aVar) {
        this.gRg = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bWH() {
        if (this.gQX == null) {
            this.gQX = new i();
            this.gQX.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gQX.c(this.brl, this.gRl, 20, this.mType);
    }

    public void vS(int i) {
        if (this.gRg != null) {
            this.gRg.vP(i);
        }
    }

    public void bWI() {
        if (this.gRk != null) {
            this.gRk.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gRk != null && (datas = this.gRk.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gQT = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gRk.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gRg != null) {
            this.gRg.c(kVar);
        }
    }

    public void bWB() {
        if (this.gRg != null) {
            this.gRg.bWB();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gRl = 1;
        bWJ();
        bWH();
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
        this.gRj = null;
        this.gRg = null;
        if (this.gQX != null) {
            this.gQX.release();
        }
    }

    private void bWJ() {
        this.gRk = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.gRk.setType(1);
                break;
            case 2:
                this.gRk.setType(0);
                break;
        }
        this.gRk.gr(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gRk.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.gRg != null) {
                    d.this.gRg.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.gRg != null) {
                    d.this.gRg.d(kVar);
                }
            }
        });
        if (this.gRj != null) {
            this.gRj.a(this.gRk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gRg != null) {
            this.gRg.mQ(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gRl = i + 1;
            if (this.gRk != null) {
                if (i == 1) {
                    if (this.gRj != null) {
                        this.gRj.cu(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gRk.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gRk.ct(list);
                }
            }
        } else if (this.gRl == 1) {
            if (this.gRj != null) {
                this.gRj.bWD();
                return;
            }
            return;
        }
        if (this.gRj != null) {
            this.gRj.K(z, i == 1);
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
                if (this.gRj != null) {
                    this.gRj.g(str, aVar.biT, aVar.biN, str2, aVar.liveStatus == 1 && !this.aUy);
                }
            }
        }
    }
}
