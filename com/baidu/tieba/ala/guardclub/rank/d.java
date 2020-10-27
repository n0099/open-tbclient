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
    private boolean aRP;
    private String bmv;
    private a gCC;
    private b gCF;
    private m gCG;
    private int gCH;
    private i gCt;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bQY();

        void c(k kVar);

        void d(k kVar);

        void ml(boolean z);

        void uA(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void K(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bRa();

        void cj(List<k> list);

        void g(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bmv = str;
        this.aRP = z;
    }

    public void a(b bVar) {
        this.gCF = bVar;
    }

    public void a(a aVar) {
        this.gCC = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bRe() {
        if (this.gCt == null) {
            this.gCt = new i();
            this.gCt.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gCt.c(this.bmv, this.gCH, 20, this.mType);
    }

    public void uD(int i) {
        if (this.gCC != null) {
            this.gCC.uA(i);
        }
    }

    public void bRf() {
        if (this.gCG != null) {
            this.gCG.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gCG != null && (datas = this.gCG.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gCp = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gCG.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gCC != null) {
            this.gCC.c(kVar);
        }
    }

    public void bQY() {
        if (this.gCC != null) {
            this.gCC.bQY();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gCH = 1;
        bRg();
        bRe();
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
        this.gCF = null;
        this.gCC = null;
        if (this.gCt != null) {
            this.gCt.release();
        }
    }

    private void bRg() {
        this.gCG = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gCG.setType(1);
                break;
            case 2:
                this.gCG.setType(0);
                break;
        }
        this.gCG.fX(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gCG.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gCC != null) {
                    d.this.gCC.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gCC != null) {
                    d.this.gCC.d(kVar);
                }
            }
        });
        if (this.gCF != null) {
            this.gCF.a(this.gCG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gCC != null) {
            this.gCC.ml(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gCH = i + 1;
            if (this.gCG != null) {
                if (i == 1) {
                    if (this.gCF != null) {
                        this.gCF.cj(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gCG.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gCG.ci(list);
                }
            }
        } else if (this.gCH == 1) {
            if (this.gCF != null) {
                this.gCF.bRa();
                return;
            }
            return;
        }
        if (this.gCF != null) {
            this.gCF.K(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bfu))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.beT));
                        break;
                    case 2:
                        str = aVar.beZ;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.beU));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gCF != null) {
                    this.gCF.g(str, aVar.beY, aVar.beR, str2, aVar.liveStatus == 1 && !this.aRP);
                }
            }
        }
    }
}
