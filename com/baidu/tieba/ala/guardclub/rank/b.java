package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.k;
import com.baidu.tieba.ala.guardclub.model.n;
import com.baidu.tieba.ala.guardclub.model.p;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements c {
    private String asd;
    private n eDB;
    private a eDK;
    private InterfaceC0425b eDN;
    private k eDO;
    private int eDP;
    private boolean eDz;
    private Context mContext;
    private int mType;

    /* loaded from: classes2.dex */
    public interface a {
        void bdu();

        void c(p pVar);

        void d(p pVar);

        void iy(boolean z);

        void pa(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0425b {
        void a(BaseAdapter baseAdapter);

        void bdx();

        void bx(List<p> list);

        void f(String str, String str2, String str3, String str4, boolean z);

        void y(boolean z, boolean z2);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.asd = str;
        this.eDz = z;
    }

    public void a(InterfaceC0425b interfaceC0425b) {
        this.eDN = interfaceC0425b;
    }

    public void a(a aVar) {
        this.eDK = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bdB() {
        if (this.eDB == null) {
            this.eDB = new n();
            this.eDB.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.r.a
                public void a(int i, com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, com.baidu.tieba.ala.guardclub.model.k kVar, int i2, boolean z, boolean z2) {
                    super.a(i, cVar, list, kVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(cVar, list, kVar, i2, z, z2);
                    }
                }
            });
        }
        this.eDB.b(this.asd, this.eDP, 20, this.mType);
    }

    public void pi(int i) {
        if (this.eDK != null) {
            this.eDK.pa(i);
        }
    }

    public void bdC() {
        if (this.eDO != null) {
            this.eDO.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<p> datas;
        if (this.eDO != null && (datas = this.eDO.getDatas()) != null && !datas.isEmpty()) {
            for (p pVar : datas) {
                if (pVar.id.equals(str)) {
                    pVar.eDw = true;
                    if (j > 0) {
                        pVar.score = String.valueOf(j);
                    }
                }
            }
            this.eDO.notifyDataSetChanged();
        }
    }

    public void f(p pVar) {
        if (this.eDK != null) {
            this.eDK.c(pVar);
        }
    }

    public void bdu() {
        if (this.eDK != null) {
            this.eDK.bdu();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eDP = 1;
        bdD();
        bdB();
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
        this.eDN = null;
        this.eDK = null;
    }

    private void bdD() {
        this.eDO = new k(this.mContext);
        switch (this.mType) {
            case 1:
                this.eDO.setType(1);
                break;
            case 2:
                this.eDO.setType(0);
                break;
        }
        this.eDO.ya(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eDO.a(new k.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.k.a
            public void a(p pVar) {
                if (b.this.eDK != null) {
                    b.this.eDK.c(pVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.k.a
            public void b(p pVar) {
                if (b.this.eDK != null) {
                    b.this.eDK.d(pVar);
                }
            }
        });
        if (this.eDN != null) {
            this.eDN.a(this.eDO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, List<p> list, com.baidu.tieba.ala.guardclub.model.k kVar, int i, boolean z, boolean z2) {
        if (this.eDK != null) {
            this.eDK.iy(z2 && cVar != null && cVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eDP = i + 1;
            if (this.eDO != null) {
                if (i == 1) {
                    if (this.eDN != null) {
                        this.eDN.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eDO.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eDO.bw(list);
                }
            }
        } else if (this.eDP == 1) {
            if (this.eDN != null) {
                this.eDN.bdx();
                return;
            }
            return;
        }
        if (this.eDN != null) {
            this.eDN.y(z, i == 1);
        }
        if (cVar != null) {
            if (z2 || (kVar != null && !TextUtils.isEmpty(kVar.eDi))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = cVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(cVar.eCB));
                        break;
                    case 2:
                        str = cVar.eCH;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(cVar.eCC));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.eDN != null) {
                    this.eDN.f(str, cVar.eCG, cVar.eCz, str2, cVar.liveStatus == 1 && !this.eDz);
                }
            }
        }
    }
}
