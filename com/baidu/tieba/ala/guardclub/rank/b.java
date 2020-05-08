package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.guardclub.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.m;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c {
    private String aQi;
    private a fmA;
    private InterfaceC0492b fmD;
    private m fmE;
    private int fmF;
    private boolean fmp;
    private i fmr;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void boZ();

        void c(k kVar);

        void d(k kVar);

        void jI(boolean z);

        void pN(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0492b {
        void B(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bG(List<k> list);

        void bpc();

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aQi = str;
        this.fmp = z;
    }

    public void a(InterfaceC0492b interfaceC0492b) {
        this.fmD = interfaceC0492b;
    }

    public void a(a aVar) {
        this.fmA = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bpg() {
        if (this.fmr == null) {
            this.fmr = new i();
            this.fmr.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fmr.b(this.aQi, this.fmF, 20, this.mType);
    }

    public void pQ(int i) {
        if (this.fmA != null) {
            this.fmA.pN(i);
        }
    }

    public void bph() {
        if (this.fmE != null) {
            this.fmE.notifyDataSetChanged();
        }
    }

    public void x(String str, long j) {
        List<k> datas;
        if (this.fmE != null && (datas = this.fmE.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fmm = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fmE.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fmA != null) {
            this.fmA.c(kVar);
        }
    }

    public void boZ() {
        if (this.fmA != null) {
            this.fmA.boZ();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.fmF = 1;
        bpi();
        bpg();
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onVisibilityChanged(boolean z) {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onResume() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onPause() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onDestoryView() {
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onDestroy() {
        this.fmD = null;
        this.fmA = null;
    }

    private void bpi() {
        this.fmE = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fmE.setType(1);
                break;
            case 2:
                this.fmE.setType(0);
                break;
        }
        this.fmE.Ai(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fmE.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.fmA != null) {
                    b.this.fmA.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.fmA != null) {
                    b.this.fmA.d(kVar);
                }
            }
        });
        if (this.fmD != null) {
            this.fmD.a(this.fmE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fmA != null) {
            this.fmA.jI(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fmF = i + 1;
            if (this.fmE != null) {
                if (i == 1) {
                    if (this.fmD != null) {
                        this.fmD.bG(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fmE.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fmE.bF(list);
                }
            }
        } else if (this.fmF == 1) {
            if (this.fmD != null) {
                this.fmD.bpc();
                return;
            }
            return;
        }
        if (this.fmD != null) {
            this.fmD.B(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aJn))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aIN));
                        break;
                    case 2:
                        str = aVar.aIT;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aIO));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.fmD != null) {
                    this.fmD.c(str, aVar.aIS, aVar.aIL, str2, aVar.liveStatus == 1 && !this.fmp);
                }
            }
        }
    }
}
