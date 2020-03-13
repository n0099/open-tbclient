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
    private String awp;
    private a eHI;
    private InterfaceC0436b eHL;
    private m eHM;
    private int eHN;
    private boolean eHx;
    private i eHz;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bfF();

        void c(k kVar);

        void d(k kVar);

        void iF(boolean z);

        void pr(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0436b {
        void C(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bfI();

        void bx(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.awp = str;
        this.eHx = z;
    }

    public void a(InterfaceC0436b interfaceC0436b) {
        this.eHL = interfaceC0436b;
    }

    public void a(a aVar) {
        this.eHI = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bfM() {
        if (this.eHz == null) {
            this.eHz = new i();
            this.eHz.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.eHz.b(this.awp, this.eHN, 20, this.mType);
    }

    public void pu(int i) {
        if (this.eHI != null) {
            this.eHI.pr(i);
        }
    }

    public void bfN() {
        if (this.eHM != null) {
            this.eHM.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.eHM != null && (datas = this.eHM.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.eHu = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.eHM.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.eHI != null) {
            this.eHI.c(kVar);
        }
    }

    public void bfF() {
        if (this.eHI != null) {
            this.eHI.bfF();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eHN = 1;
        bfO();
        bfM();
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
        this.eHL = null;
        this.eHI = null;
    }

    private void bfO() {
        this.eHM = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.eHM.setType(1);
                break;
            case 2:
                this.eHM.setType(0);
                break;
        }
        this.eHM.yw(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eHM.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.eHI != null) {
                    b.this.eHI.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.eHI != null) {
                    b.this.eHI.d(kVar);
                }
            }
        });
        if (this.eHL != null) {
            this.eHL.a(this.eHM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.eHI != null) {
            this.eHI.iF(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eHN = i + 1;
            if (this.eHM != null) {
                if (i == 1) {
                    if (this.eHL != null) {
                        this.eHL.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eHM.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eHM.bw(list);
                }
            }
        } else if (this.eHN == 1) {
            if (this.eHL != null) {
                this.eHL.bfI();
                return;
            }
            return;
        }
        if (this.eHL != null) {
            this.eHL.C(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aqo))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.apO));
                        break;
                    case 2:
                        str = aVar.apU;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.apP));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.eHL != null) {
                    this.eHL.c(str, aVar.apT, aVar.apM, str2, aVar.liveStatus == 1 && !this.eHx);
                }
            }
        }
    }
}
