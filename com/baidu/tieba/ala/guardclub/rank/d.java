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
    private boolean aTh;
    private String bnP;
    private i gIh;
    private a gIq;
    private b gIt;
    private m gIu;
    private int gIv;
    private Context mContext;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void bTx();

        void c(k kVar);

        void d(k kVar);

        void mu(boolean z);

        void uK(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void K(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bTz();

        void cq(List<k> list);

        void g(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bnP = str;
        this.aTh = z;
    }

    public void a(b bVar) {
        this.gIt = bVar;
    }

    public void a(a aVar) {
        this.gIq = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bTD() {
        if (this.gIh == null) {
            this.gIh = new i();
            this.gIh.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gIh.c(this.bnP, this.gIv, 20, this.mType);
    }

    public void uN(int i) {
        if (this.gIq != null) {
            this.gIq.uK(i);
        }
    }

    public void bTE() {
        if (this.gIu != null) {
            this.gIu.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.gIu != null && (datas = this.gIu.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gId = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gIu.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gIq != null) {
            this.gIq.c(kVar);
        }
    }

    public void bTx() {
        if (this.gIq != null) {
            this.gIq.bTx();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gIv = 1;
        bTF();
        bTD();
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
        this.gIt = null;
        this.gIq = null;
        if (this.gIh != null) {
            this.gIh.release();
        }
    }

    private void bTF() {
        this.gIu = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gIu.setType(1);
                break;
            case 2:
                this.gIu.setType(0);
                break;
        }
        this.gIu.gc(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gIu.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gIq != null) {
                    d.this.gIq.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gIq != null) {
                    d.this.gIq.d(kVar);
                }
            }
        });
        if (this.gIt != null) {
            this.gIt.a(this.gIu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gIq != null) {
            this.gIq.mu(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gIv = i + 1;
            if (this.gIu != null) {
                if (i == 1) {
                    if (this.gIt != null) {
                        this.gIt.cq(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gIu.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gIu.cp(list);
                }
            }
        } else if (this.gIv == 1) {
            if (this.gIt != null) {
                this.gIt.bTz();
                return;
            }
            return;
        }
        if (this.gIt != null) {
            this.gIt.K(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bgO))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bgo));
                        break;
                    case 2:
                        str = aVar.bgv;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.bgp));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gIt != null) {
                    this.gIt.g(str, aVar.bgu, aVar.bgm, str2, aVar.liveStatus == 1 && !this.aTh);
                }
            }
        }
    }
}
