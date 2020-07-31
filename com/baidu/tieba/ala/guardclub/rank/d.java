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
    private String aYY;
    private boolean fQK;
    private i fQM;
    private a fQV;
    private b fQY;
    private m fQZ;
    private int fRa;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bBe();

        void c(k kVar);

        void d(k kVar);

        void kT(boolean z);

        void rf(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void F(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bBg();

        void bQ(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aYY = str;
        this.fQK = z;
    }

    public void a(b bVar) {
        this.fQY = bVar;
    }

    public void a(a aVar) {
        this.fQV = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bBk() {
        if (this.fQM == null) {
            this.fQM = new i();
            this.fQM.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fQM.b(this.aYY, this.fRa, 20, this.mType);
    }

    public void ri(int i) {
        if (this.fQV != null) {
            this.fQV.rf(i);
        }
    }

    public void bBl() {
        if (this.fQZ != null) {
            this.fQZ.notifyDataSetChanged();
        }
    }

    public void u(String str, long j) {
        List<k> datas;
        if (this.fQZ != null && (datas = this.fQZ.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fQH = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fQZ.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fQV != null) {
            this.fQV.c(kVar);
        }
    }

    public void bBe() {
        if (this.fQV != null) {
            this.fQV.bBe();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.fRa = 1;
        bBm();
        bBk();
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
        this.fQY = null;
        this.fQV = null;
        if (this.fQM != null) {
            this.fQM.release();
        }
    }

    private void bBm() {
        this.fQZ = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fQZ.setType(1);
                break;
            case 2:
                this.fQZ.setType(0);
                break;
        }
        this.fQZ.CZ(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fQZ.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.fQV != null) {
                    d.this.fQV.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.fQV != null) {
                    d.this.fQV.d(kVar);
                }
            }
        });
        if (this.fQY != null) {
            this.fQY.a(this.fQZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fQV != null) {
            this.fQV.kT(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fRa = i + 1;
            if (this.fQZ != null) {
                if (i == 1) {
                    if (this.fQY != null) {
                        this.fQY.bQ(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fQZ.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fQZ.bP(list);
                }
            }
        } else if (this.fRa == 1) {
            if (this.fQY != null) {
                this.fQY.bBg();
                return;
            }
            return;
        }
        if (this.fQY != null) {
            this.fQY.F(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aSV))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aSv));
                        break;
                    case 2:
                        str = aVar.aSB;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aSw));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.fQY != null) {
                    this.fQY.c(str, aVar.aSA, aVar.aSt, str2, aVar.liveStatus == 1 && !this.fQK);
                }
            }
        }
    }
}
