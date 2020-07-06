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
/* loaded from: classes3.dex */
public class d implements e {
    private String aZa;
    private a fLB;
    private b fLE;
    private m fLF;
    private int fLG;
    private boolean fLq;
    private i fLs;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bxP();

        void c(k kVar);

        void d(k kVar);

        void kp(boolean z);

        void qP(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bM(List<k> list);

        void bxR();

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aZa = str;
        this.fLq = z;
    }

    public void a(b bVar) {
        this.fLE = bVar;
    }

    public void a(a aVar) {
        this.fLB = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bxV() {
        if (this.fLs == null) {
            this.fLs = new i();
            this.fLs.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fLs.b(this.aZa, this.fLG, 20, this.mType);
    }

    public void qS(int i) {
        if (this.fLB != null) {
            this.fLB.qP(i);
        }
    }

    public void bxW() {
        if (this.fLF != null) {
            this.fLF.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.fLF != null && (datas = this.fLF.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fLn = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fLF.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fLB != null) {
            this.fLB.c(kVar);
        }
    }

    public void bxP() {
        if (this.fLB != null) {
            this.fLB.bxP();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.fLG = 1;
        bxX();
        bxV();
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
        this.fLE = null;
        this.fLB = null;
        if (this.fLs != null) {
            this.fLs.release();
        }
    }

    private void bxX() {
        this.fLF = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fLF.setType(1);
                break;
            case 2:
                this.fLF.setType(0);
                break;
        }
        this.fLF.Cn(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fLF.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.fLB != null) {
                    d.this.fLB.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.fLB != null) {
                    d.this.fLB.d(kVar);
                }
            }
        });
        if (this.fLE != null) {
            this.fLE.a(this.fLF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fLB != null) {
            this.fLB.kp(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fLG = i + 1;
            if (this.fLF != null) {
                if (i == 1) {
                    if (this.fLE != null) {
                        this.fLE.bM(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fLF.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fLF.bL(list);
                }
            }
        } else if (this.fLG == 1) {
            if (this.fLE != null) {
                this.fLE.bxR();
                return;
            }
            return;
        }
        if (this.fLE != null) {
            this.fLE.E(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aRC))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aRc));
                        break;
                    case 2:
                        str = aVar.aRi;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aRd));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.fLE != null) {
                    this.fLE.c(str, aVar.aRh, aVar.aRa, str2, aVar.liveStatus == 1 && !this.fLq);
                }
            }
        }
    }
}
