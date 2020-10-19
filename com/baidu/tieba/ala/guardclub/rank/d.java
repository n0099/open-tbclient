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
    private boolean aYB;
    private String bla;
    private b gsB;
    private m gsC;
    private int gsD;
    private i gsp;
    private a gsy;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bOt();

        void c(k kVar);

        void d(k kVar);

        void lV(boolean z);

        void ui(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void I(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bOv();

        void bZ(List<k> list);

        void d(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bla = str;
        this.aYB = z;
    }

    public void a(b bVar) {
        this.gsB = bVar;
    }

    public void a(a aVar) {
        this.gsy = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bOz() {
        if (this.gsp == null) {
            this.gsp = new i();
            this.gsp.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gsp.c(this.bla, this.gsD, 20, this.mType);
    }

    public void ul(int i) {
        if (this.gsy != null) {
            this.gsy.ui(i);
        }
    }

    public void bOA() {
        if (this.gsC != null) {
            this.gsC.notifyDataSetChanged();
        }
    }

    public void v(String str, long j) {
        List<k> datas;
        if (this.gsC != null && (datas = this.gsC.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gsl = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gsC.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gsy != null) {
            this.gsy.c(kVar);
        }
    }

    public void bOt() {
        if (this.gsy != null) {
            this.gsy.bOt();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gsD = 1;
        bOB();
        bOz();
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
        this.gsB = null;
        this.gsy = null;
        if (this.gsp != null) {
            this.gsp.release();
        }
    }

    private void bOB() {
        this.gsC = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gsC.setType(1);
                break;
            case 2:
                this.gsC.setType(0);
                break;
        }
        this.gsC.fX(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gsC.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gsy != null) {
                    d.this.gsy.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gsy != null) {
                    d.this.gsy.d(kVar);
                }
            }
        });
        if (this.gsB != null) {
            this.gsB.a(this.gsC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gsy != null) {
            this.gsy.lV(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gsD = i + 1;
            if (this.gsC != null) {
                if (i == 1) {
                    if (this.gsB != null) {
                        this.gsB.bZ(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gsC.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gsC.bY(list);
                }
            }
        } else if (this.gsD == 1) {
            if (this.gsB != null) {
                this.gsB.bOv();
                return;
            }
            return;
        }
        if (this.gsB != null) {
            this.gsB.I(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bec))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bdD));
                        break;
                    case 2:
                        str = aVar.bdJ;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.bdE));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gsB != null) {
                    this.gsB.d(str, aVar.bdI, aVar.bdB, str2, aVar.liveStatus == 1 && !this.aYB);
                }
            }
        }
    }
}
