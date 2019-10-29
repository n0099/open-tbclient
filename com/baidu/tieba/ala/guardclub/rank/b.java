package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.model.n;
import com.baidu.tieba.ala.guardclub.model.p;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements c {
    private String dOY;
    private boolean dOZ;
    private n dPb;
    private a dPk;
    private InterfaceC0348b dPn;
    private l dPo;
    private int dPp;
    private Context mContext;
    private int mType;

    /* loaded from: classes6.dex */
    public interface a {
        void aLS();

        void c(p pVar);

        void d(p pVar);

        void hh(boolean z);

        void mK(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0348b {
        void a(BaseAdapter baseAdapter);

        void aLV();

        void by(List<p> list);

        void f(String str, String str2, String str3, String str4, boolean z);

        void z(boolean z, boolean z2);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void g(int i, String str, boolean z) {
        this.mType = i;
        this.dOY = str;
        this.dOZ = z;
    }

    public void a(InterfaceC0348b interfaceC0348b) {
        this.dPn = interfaceC0348b;
    }

    public void a(a aVar) {
        this.dPk = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void aLZ() {
        if (this.dPb == null) {
            this.dPb = new n();
            this.dPb.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(int i, com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, k kVar, int i2, boolean z, boolean z2) {
                    super.a(i, cVar, list, kVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(cVar, list, kVar, i2, z, z2);
                    }
                }
            });
        }
        this.dPb.b(this.dOY, this.dPp, 20, this.mType);
    }

    public void mS(int i) {
        if (this.dPk != null) {
            this.dPk.mK(i);
        }
    }

    public void aMa() {
        if (this.dPo != null) {
            this.dPo.notifyDataSetChanged();
        }
    }

    public void u(String str, long j) {
        List<p> datas;
        if (this.dPo != null && (datas = this.dPo.getDatas()) != null && !datas.isEmpty()) {
            for (p pVar : datas) {
                if (pVar.id.equals(str)) {
                    pVar.dOV = true;
                    if (j > 0) {
                        pVar.score = String.valueOf(j);
                    }
                }
            }
            this.dPo.notifyDataSetChanged();
        }
    }

    public void f(p pVar) {
        if (this.dPk != null) {
            this.dPk.c(pVar);
        }
    }

    public void aLS() {
        if (this.dPk != null) {
            this.dPk.aLS();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.dPp = 1;
        aMb();
        aLZ();
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
        this.dPn = null;
        this.dPk = null;
    }

    private void aMb() {
        this.dPo = new l(this.mContext);
        switch (this.mType) {
            case 1:
                this.dPo.setType(1);
                break;
            case 2:
                this.dPo.setType(0);
                break;
        }
        this.dPo.tk(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.dPo.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.l.a
            public void a(p pVar) {
                if (b.this.dPk != null) {
                    b.this.dPk.c(pVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.l.a
            public void b(p pVar) {
                if (b.this.dPk != null) {
                    b.this.dPk.d(pVar);
                }
            }
        });
        if (this.dPn != null) {
            this.dPn.a(this.dPo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, k kVar, int i, boolean z, boolean z2) {
        if (this.dPk != null) {
            this.dPk.hh(z2 && cVar != null && cVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.dPp = i + 1;
            if (this.dPo != null) {
                if (i == 1) {
                    if (this.dPn != null) {
                        this.dPn.by(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.dPo.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.dPo.bx(list);
                }
            }
        } else if (this.dPp == 1) {
            if (this.dPn != null) {
                this.dPn.aLV();
                return;
            }
            return;
        }
        if (this.dPn != null) {
            this.dPn.z(z, i == 1);
        }
        if (cVar != null) {
            if (z2 || (kVar != null && !TextUtils.isEmpty(kVar.dOH))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = cVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(cVar.dNZ));
                        break;
                    case 2:
                        str = cVar.dOf;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(cVar.dOa));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.dPn != null) {
                    this.dPn.f(str, cVar.dOe, cVar.dNX, str2, cVar.liveStatus == 1 && !this.dOZ);
                }
            }
        }
    }
}
