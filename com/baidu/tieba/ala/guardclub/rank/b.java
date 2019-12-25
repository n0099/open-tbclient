package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.k;
import com.baidu.tieba.ala.guardclub.model.n;
import com.baidu.tieba.ala.guardclub.model.p;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements c {
    private String arr;
    private InterfaceC0422b eCC;
    private k eCD;
    private int eCE;
    private boolean eCo;
    private n eCq;
    private a eCz;
    private Context mContext;
    private int mType;

    /* loaded from: classes2.dex */
    public interface a {
        void bcZ();

        void c(p pVar);

        void d(p pVar);

        void io(boolean z);

        void oZ(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0422b {
        void a(BaseAdapter baseAdapter);

        void bdc();

        void bx(List<p> list);

        void f(String str, String str2, String str3, String str4, boolean z);

        void z(boolean z, boolean z2);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.arr = str;
        this.eCo = z;
    }

    public void a(InterfaceC0422b interfaceC0422b) {
        this.eCC = interfaceC0422b;
    }

    public void a(a aVar) {
        this.eCz = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bdg() {
        if (this.eCq == null) {
            this.eCq = new n();
            this.eCq.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(int i, com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, com.baidu.tieba.ala.guardclub.model.k kVar, int i2, boolean z, boolean z2) {
                    super.a(i, cVar, list, kVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(cVar, list, kVar, i2, z, z2);
                    }
                }
            });
        }
        this.eCq.b(this.arr, this.eCE, 20, this.mType);
    }

    public void ph(int i) {
        if (this.eCz != null) {
            this.eCz.oZ(i);
        }
    }

    public void bdh() {
        if (this.eCD != null) {
            this.eCD.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<p> datas;
        if (this.eCD != null && (datas = this.eCD.getDatas()) != null && !datas.isEmpty()) {
            for (p pVar : datas) {
                if (pVar.id.equals(str)) {
                    pVar.eCl = true;
                    if (j > 0) {
                        pVar.score = String.valueOf(j);
                    }
                }
            }
            this.eCD.notifyDataSetChanged();
        }
    }

    public void f(p pVar) {
        if (this.eCz != null) {
            this.eCz.c(pVar);
        }
    }

    public void bcZ() {
        if (this.eCz != null) {
            this.eCz.bcZ();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eCE = 1;
        bdi();
        bdg();
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
        this.eCC = null;
        this.eCz = null;
    }

    private void bdi() {
        this.eCD = new k(this.mContext);
        switch (this.mType) {
            case 1:
                this.eCD.setType(1);
                break;
            case 2:
                this.eCD.setType(0);
                break;
        }
        this.eCD.xV(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eCD.a(new k.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.k.a
            public void a(p pVar) {
                if (b.this.eCz != null) {
                    b.this.eCz.c(pVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.k.a
            public void b(p pVar) {
                if (b.this.eCz != null) {
                    b.this.eCz.d(pVar);
                }
            }
        });
        if (this.eCC != null) {
            this.eCC.a(this.eCD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, com.baidu.tieba.ala.guardclub.model.k kVar, int i, boolean z, boolean z2) {
        if (this.eCz != null) {
            this.eCz.io(z2 && cVar != null && cVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eCE = i + 1;
            if (this.eCD != null) {
                if (i == 1) {
                    if (this.eCC != null) {
                        this.eCC.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eCD.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eCD.bw(list);
                }
            }
        } else if (this.eCE == 1) {
            if (this.eCC != null) {
                this.eCC.bdc();
                return;
            }
            return;
        }
        if (this.eCC != null) {
            this.eCC.z(z, i == 1);
        }
        if (cVar != null) {
            if (z2 || (kVar != null && !TextUtils.isEmpty(kVar.eBX))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = cVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(cVar.eBq));
                        break;
                    case 2:
                        str = cVar.eBw;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(cVar.eBr));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.eCC != null) {
                    this.eCC.f(str, cVar.eBv, cVar.eBo, str2, cVar.liveStatus == 1 && !this.eCo);
                }
            }
        }
    }
}
