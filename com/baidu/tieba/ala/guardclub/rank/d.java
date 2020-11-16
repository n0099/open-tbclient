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
    private boolean aRw;
    private String bme;
    private i gHO;
    private a gHX;
    private b gIa;
    private m gIb;
    private int gIc;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bSQ();

        void c(k kVar);

        void d(k kVar);

        void mv(boolean z);

        void vi(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void K(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bSS();

        void cq(List<k> list);

        void g(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bme = str;
        this.aRw = z;
    }

    public void a(b bVar) {
        this.gIa = bVar;
    }

    public void a(a aVar) {
        this.gHX = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bSW() {
        if (this.gHO == null) {
            this.gHO = new i();
            this.gHO.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gHO.c(this.bme, this.gIc, 20, this.mType);
    }

    public void vl(int i) {
        if (this.gHX != null) {
            this.gHX.vi(i);
        }
    }

    public void bSX() {
        if (this.gIb != null) {
            this.gIb.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gIb != null && (datas = this.gIb.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gHK = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gIb.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gHX != null) {
            this.gHX.c(kVar);
        }
    }

    public void bSQ() {
        if (this.gHX != null) {
            this.gHX.bSQ();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gIc = 1;
        bSY();
        bSW();
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
        this.gIa = null;
        this.gHX = null;
        if (this.gHO != null) {
            this.gHO.release();
        }
    }

    private void bSY() {
        this.gIb = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gIb.setType(1);
                break;
            case 2:
                this.gIb.setType(0);
                break;
        }
        this.gIb.fW(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gIb.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gHX != null) {
                    d.this.gHX.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gHX != null) {
                    d.this.gHX.d(kVar);
                }
            }
        });
        if (this.gIa != null) {
            this.gIa.a(this.gIb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gHX != null) {
            this.gHX.mv(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gIc = i + 1;
            if (this.gIb != null) {
                if (i == 1) {
                    if (this.gIa != null) {
                        this.gIa.cq(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gIb.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gIb.cp(list);
                }
            }
        } else if (this.gIc == 1) {
            if (this.gIa != null) {
                this.gIa.bSS();
                return;
            }
            return;
        }
        if (this.gIa != null) {
            this.gIa.K(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bfa))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.beB));
                        break;
                    case 2:
                        str = aVar.beH;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.beC));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gIa != null) {
                    this.gIa.g(str, aVar.beG, aVar.bez, str2, aVar.liveStatus == 1 && !this.aRw);
                }
            }
        }
    }
}
