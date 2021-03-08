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
/* loaded from: classes10.dex */
public class d implements e {
    private boolean aVI;
    private String bwh;
    private i hcL;
    private a hcU;
    private b hcX;
    private n hcY;
    private int hcZ;
    private Context mContext;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void bWh();

        void c(k kVar);

        void d(k kVar);

        void nr(boolean z);

        void uC(int i);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bWj();

        void cw(List<k> list);

        void d(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.bwh = str;
        this.aVI = z;
    }

    public void a(b bVar) {
        this.hcX = bVar;
    }

    public void a(a aVar) {
        this.hcU = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bWm() {
        if (this.hcL == null) {
            this.hcL = new i();
            this.hcL.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.hcL.c(this.bwh, this.hcZ, 20, this.mType);
    }

    public void uF(int i) {
        if (this.hcU != null) {
            this.hcU.uC(i);
        }
    }

    public void bWn() {
        if (this.hcY != null) {
            this.hcY.notifyDataSetChanged();
        }
    }

    public void x(String str, long j) {
        List<k> datas;
        if (this.hcY != null && (datas = this.hcY.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.hcH = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.hcY.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.hcU != null) {
            this.hcU.c(kVar);
        }
    }

    public void bWh() {
        if (this.hcU != null) {
            this.hcU.bWh();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.hcZ = 1;
        bWo();
        bWm();
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
        this.hcX = null;
        this.hcU = null;
        if (this.hcL != null) {
            this.hcL.release();
        }
    }

    private void bWo() {
        this.hcY = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.hcY.setType(1);
                break;
            case 2:
                this.hcY.setType(0);
                break;
        }
        this.hcY.fo(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.hcY.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.hcU != null) {
                    d.this.hcU.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.hcU != null) {
                    d.this.hcU.d(kVar);
                }
            }
        });
        if (this.hcX != null) {
            this.hcX.a(this.hcY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.hcU != null) {
            this.hcU.nr(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.hcZ = i + 1;
            if (this.hcY != null) {
                if (i == 1) {
                    if (this.hcX != null) {
                        this.hcX.cw(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.hcY.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.hcY.cv(list);
                }
            }
        } else if (this.hcZ == 1) {
            if (this.hcX != null) {
                this.hcX.bWj();
                return;
            }
            return;
        }
        if (this.hcX != null) {
            this.hcX.M(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bkP))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bkn));
                        break;
                    case 2:
                        str = aVar.bks;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.bko));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.hcX != null) {
                    this.hcX.d(str, aVar.bkr, aVar.bkl, str2, aVar.liveStatus == 1 && !this.aVI);
                }
            }
        }
    }
}
