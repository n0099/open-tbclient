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
    private String dOh;
    private boolean dOi;
    private n dOk;
    private a dOt;
    private InterfaceC0348b dOw;
    private l dOx;
    private int dOy;
    private Context mContext;
    private int mType;

    /* loaded from: classes6.dex */
    public interface a {
        void aLQ();

        void c(p pVar);

        void d(p pVar);

        void hh(boolean z);

        void mJ(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0348b {
        void a(BaseAdapter baseAdapter);

        void aLT();

        void by(List<p> list);

        void f(String str, String str2, String str3, String str4, boolean z);

        void z(boolean z, boolean z2);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void g(int i, String str, boolean z) {
        this.mType = i;
        this.dOh = str;
        this.dOi = z;
    }

    public void a(InterfaceC0348b interfaceC0348b) {
        this.dOw = interfaceC0348b;
    }

    public void a(a aVar) {
        this.dOt = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void aLX() {
        if (this.dOk == null) {
            this.dOk = new n();
            this.dOk.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(int i, com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, k kVar, int i2, boolean z, boolean z2) {
                    super.a(i, cVar, list, kVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(cVar, list, kVar, i2, z, z2);
                    }
                }
            });
        }
        this.dOk.b(this.dOh, this.dOy, 20, this.mType);
    }

    public void mR(int i) {
        if (this.dOt != null) {
            this.dOt.mJ(i);
        }
    }

    public void aLY() {
        if (this.dOx != null) {
            this.dOx.notifyDataSetChanged();
        }
    }

    public void u(String str, long j) {
        List<p> datas;
        if (this.dOx != null && (datas = this.dOx.getDatas()) != null && !datas.isEmpty()) {
            for (p pVar : datas) {
                if (pVar.id.equals(str)) {
                    pVar.dOe = true;
                    if (j > 0) {
                        pVar.score = String.valueOf(j);
                    }
                }
            }
            this.dOx.notifyDataSetChanged();
        }
    }

    public void f(p pVar) {
        if (this.dOt != null) {
            this.dOt.c(pVar);
        }
    }

    public void aLQ() {
        if (this.dOt != null) {
            this.dOt.aLQ();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.dOy = 1;
        aLZ();
        aLX();
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
        this.dOw = null;
        this.dOt = null;
    }

    private void aLZ() {
        this.dOx = new l(this.mContext);
        switch (this.mType) {
            case 1:
                this.dOx.setType(1);
                break;
            case 2:
                this.dOx.setType(0);
                break;
        }
        this.dOx.tk(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.dOx.a(new l.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.l.a
            public void a(p pVar) {
                if (b.this.dOt != null) {
                    b.this.dOt.c(pVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.l.a
            public void b(p pVar) {
                if (b.this.dOt != null) {
                    b.this.dOt.d(pVar);
                }
            }
        });
        if (this.dOw != null) {
            this.dOw.a(this.dOx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, k kVar, int i, boolean z, boolean z2) {
        if (this.dOt != null) {
            this.dOt.hh(z2 && cVar != null && cVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.dOy = i + 1;
            if (this.dOx != null) {
                if (i == 1) {
                    if (this.dOw != null) {
                        this.dOw.by(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.dOx.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.dOx.bx(list);
                }
            }
        } else if (this.dOy == 1) {
            if (this.dOw != null) {
                this.dOw.aLT();
                return;
            }
            return;
        }
        if (this.dOw != null) {
            this.dOw.z(z, i == 1);
        }
        if (cVar != null) {
            if (z2 || (kVar != null && !TextUtils.isEmpty(kVar.dNQ))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = cVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(cVar.dNi));
                        break;
                    case 2:
                        str = cVar.dNo;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(cVar.dNj));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.dOw != null) {
                    this.dOw.f(str, cVar.dNn, cVar.dNg, str2, cVar.liveStatus == 1 && !this.dOi);
                }
            }
        }
    }
}
