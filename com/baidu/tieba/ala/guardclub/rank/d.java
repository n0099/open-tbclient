package com.baidu.tieba.ala.guardclub.rank;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.live.guardclub.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.guardclub.model.i;
import com.baidu.tieba.ala.guardclub.model.k;
import com.baidu.tieba.ala.guardclub.n;
import java.util.List;
/* loaded from: classes11.dex */
public class d implements e {
    private boolean aUi;
    private String buH;
    private i hbc;
    private a hbl;
    private b hbo;
    private n hbp;
    private int hbq;
    private Context mContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void bWb();

        void c(k kVar);

        void d(k kVar);

        void nr(boolean z);

        void uA(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bWd();

        void cw(List<k> list);

        void d(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.buH = str;
        this.aUi = z;
    }

    public void a(b bVar) {
        this.hbo = bVar;
    }

    public void a(a aVar) {
        this.hbl = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bWg() {
        if (this.hbc == null) {
            this.hbc = new i();
            this.hbc.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.hbc.c(this.buH, this.hbq, 20, this.mType);
    }

    public void uD(int i) {
        if (this.hbl != null) {
            this.hbl.uA(i);
        }
    }

    public void bWh() {
        if (this.hbp != null) {
            this.hbp.notifyDataSetChanged();
        }
    }

    public void x(String str, long j) {
        List<k> datas;
        if (this.hbp != null && (datas = this.hbp.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.haY = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.hbp.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.hbl != null) {
            this.hbl.c(kVar);
        }
    }

    public void bWb() {
        if (this.hbl != null) {
            this.hbl.bWb();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.hbq = 1;
        bWi();
        bWg();
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
        this.hbo = null;
        this.hbl = null;
        if (this.hbc != null) {
            this.hbc.release();
        }
    }

    private void bWi() {
        this.hbp = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.hbp.setType(1);
                break;
            case 2:
                this.hbp.setType(0);
                break;
        }
        this.hbp.fi(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.hbp.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.hbl != null) {
                    d.this.hbl.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.hbl != null) {
                    d.this.hbl.d(kVar);
                }
            }
        });
        if (this.hbo != null) {
            this.hbo.a(this.hbp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.hbl != null) {
            this.hbl.nr(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.hbq = i + 1;
            if (this.hbp != null) {
                if (i == 1) {
                    if (this.hbo != null) {
                        this.hbo.cw(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.hbp.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.hbp.cv(list);
                }
            }
        } else if (this.hbq == 1) {
            if (this.hbo != null) {
                this.hbo.bWd();
                return;
            }
            return;
        }
        if (this.hbo != null) {
            this.hbo.M(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bjp))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.biN));
                        break;
                    case 2:
                        str = aVar.biS;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.biO));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.hbo != null) {
                    this.hbo.d(str, aVar.biR, aVar.biL, str2, aVar.liveStatus == 1 && !this.aUi);
                }
            }
        }
    }
}
