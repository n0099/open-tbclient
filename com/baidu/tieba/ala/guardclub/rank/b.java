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
    private String aQc;
    private int fmA;
    private boolean fmk;
    private i fmm;
    private a fmv;
    private InterfaceC0471b fmy;
    private m fmz;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bpb();

        void c(k kVar);

        void d(k kVar);

        void jI(boolean z);

        void pN(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0471b {
        void B(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bG(List<k> list);

        void bpe();

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aQc = str;
        this.fmk = z;
    }

    public void a(InterfaceC0471b interfaceC0471b) {
        this.fmy = interfaceC0471b;
    }

    public void a(a aVar) {
        this.fmv = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bpi() {
        if (this.fmm == null) {
            this.fmm = new i();
            this.fmm.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fmm.b(this.aQc, this.fmA, 20, this.mType);
    }

    public void pQ(int i) {
        if (this.fmv != null) {
            this.fmv.pN(i);
        }
    }

    public void bpj() {
        if (this.fmz != null) {
            this.fmz.notifyDataSetChanged();
        }
    }

    public void x(String str, long j) {
        List<k> datas;
        if (this.fmz != null && (datas = this.fmz.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fmh = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fmz.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fmv != null) {
            this.fmv.c(kVar);
        }
    }

    public void bpb() {
        if (this.fmv != null) {
            this.fmv.bpb();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.fmA = 1;
        bpk();
        bpi();
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
        this.fmy = null;
        this.fmv = null;
    }

    private void bpk() {
        this.fmz = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fmz.setType(1);
                break;
            case 2:
                this.fmz.setType(0);
                break;
        }
        this.fmz.Af(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fmz.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.fmv != null) {
                    b.this.fmv.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.fmv != null) {
                    b.this.fmv.d(kVar);
                }
            }
        });
        if (this.fmy != null) {
            this.fmy.a(this.fmz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fmv != null) {
            this.fmv.jI(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fmA = i + 1;
            if (this.fmz != null) {
                if (i == 1) {
                    if (this.fmy != null) {
                        this.fmy.bG(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fmz.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fmz.bF(list);
                }
            }
        } else if (this.fmA == 1) {
            if (this.fmy != null) {
                this.fmy.bpe();
                return;
            }
            return;
        }
        if (this.fmy != null) {
            this.fmy.B(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aJh))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aIH));
                        break;
                    case 2:
                        str = aVar.aIN;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aII));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.fmy != null) {
                    this.fmy.c(str, aVar.aIM, aVar.aIF, str2, aVar.liveStatus == 1 && !this.fmk);
                }
            }
        }
    }
}
