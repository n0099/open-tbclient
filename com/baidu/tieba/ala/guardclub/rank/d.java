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
    private i haO;
    private a haX;
    private b hba;
    private n hbb;
    private int hbc;
    private Context mContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void bVU();

        void c(k kVar);

        void d(k kVar);

        void nr(boolean z);

        void uA(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bVW();

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
        this.hba = bVar;
    }

    public void a(a aVar) {
        this.haX = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bVZ() {
        if (this.haO == null) {
            this.haO = new i();
            this.haO.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.haO.c(this.buH, this.hbc, 20, this.mType);
    }

    public void uD(int i) {
        if (this.haX != null) {
            this.haX.uA(i);
        }
    }

    public void bWa() {
        if (this.hbb != null) {
            this.hbb.notifyDataSetChanged();
        }
    }

    public void x(String str, long j) {
        List<k> datas;
        if (this.hbb != null && (datas = this.hbb.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.haK = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.hbb.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.haX != null) {
            this.haX.c(kVar);
        }
    }

    public void bVU() {
        if (this.haX != null) {
            this.haX.bVU();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.hbc = 1;
        bWb();
        bVZ();
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
        this.hba = null;
        this.haX = null;
        if (this.haO != null) {
            this.haO.release();
        }
    }

    private void bWb() {
        this.hbb = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.hbb.setType(1);
                break;
            case 2:
                this.hbb.setType(0);
                break;
        }
        this.hbb.fi(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.hbb.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.haX != null) {
                    d.this.haX.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.haX != null) {
                    d.this.haX.d(kVar);
                }
            }
        });
        if (this.hba != null) {
            this.hba.a(this.hbb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.haX != null) {
            this.haX.nr(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.hbc = i + 1;
            if (this.hbb != null) {
                if (i == 1) {
                    if (this.hba != null) {
                        this.hba.cw(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.hbb.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.hbb.cv(list);
                }
            }
        } else if (this.hbc == 1) {
            if (this.hba != null) {
                this.hba.bVW();
                return;
            }
            return;
        }
        if (this.hba != null) {
            this.hba.M(z, i == 1);
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
                if (this.hba != null) {
                    this.hba.d(str, aVar.biR, aVar.biL, str2, aVar.liveStatus == 1 && !this.aUi);
                }
            }
        }
    }
}
