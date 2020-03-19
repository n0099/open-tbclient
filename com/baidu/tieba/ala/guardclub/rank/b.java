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
    private String awz;
    private boolean eHT;
    private i eHV;
    private a eIe;
    private InterfaceC0436b eIh;
    private m eIi;
    private int eIj;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bfK();

        void c(k kVar);

        void d(k kVar);

        void iH(boolean z);

        void pt(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0436b {
        void C(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bfN();

        void bx(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.awz = str;
        this.eHT = z;
    }

    public void a(InterfaceC0436b interfaceC0436b) {
        this.eIh = interfaceC0436b;
    }

    public void a(a aVar) {
        this.eIe = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bfR() {
        if (this.eHV == null) {
            this.eHV = new i();
            this.eHV.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.eHV.b(this.awz, this.eIj, 20, this.mType);
    }

    public void pw(int i) {
        if (this.eIe != null) {
            this.eIe.pt(i);
        }
    }

    public void bfS() {
        if (this.eIi != null) {
            this.eIi.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.eIi != null && (datas = this.eIi.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.eHQ = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.eIi.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.eIe != null) {
            this.eIe.c(kVar);
        }
    }

    public void bfK() {
        if (this.eIe != null) {
            this.eIe.bfK();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eIj = 1;
        bfT();
        bfR();
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
        this.eIh = null;
        this.eIe = null;
    }

    private void bfT() {
        this.eIi = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.eIi.setType(1);
                break;
            case 2:
                this.eIi.setType(0);
                break;
        }
        this.eIi.yx(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eIi.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.eIe != null) {
                    b.this.eIe.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.eIe != null) {
                    b.this.eIe.d(kVar);
                }
            }
        });
        if (this.eIh != null) {
            this.eIh.a(this.eIi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.eIe != null) {
            this.eIe.iH(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eIj = i + 1;
            if (this.eIi != null) {
                if (i == 1) {
                    if (this.eIh != null) {
                        this.eIh.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eIi.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eIi.bw(list);
                }
            }
        } else if (this.eIj == 1) {
            if (this.eIh != null) {
                this.eIh.bfN();
                return;
            }
            return;
        }
        if (this.eIh != null) {
            this.eIh.C(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aqy))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.apY));
                        break;
                    case 2:
                        str = aVar.aqe;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.apZ));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.eIh != null) {
                    this.eIh.c(str, aVar.aqd, aVar.apW, str2, aVar.liveStatus == 1 && !this.eHT);
                }
            }
        }
    }
}
