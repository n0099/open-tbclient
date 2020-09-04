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
/* loaded from: classes7.dex */
public class d implements e {
    private String beu;
    private boolean gcM;
    private i gcO;
    private a gcX;
    private b gda;
    private m gdb;
    private int gdc;
    private Context mContext;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void bKz();

        void c(k kVar);

        void d(k kVar);

        void lv(boolean z);

        void tr(int i);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void I(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bKB();

        void bR(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.beu = str;
        this.gcM = z;
    }

    public void a(b bVar) {
        this.gda = bVar;
    }

    public void a(a aVar) {
        this.gcX = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bKF() {
        if (this.gcO == null) {
            this.gcO = new i();
            this.gcO.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gcO.c(this.beu, this.gdc, 20, this.mType);
    }

    public void tu(int i) {
        if (this.gcX != null) {
            this.gcX.tr(i);
        }
    }

    public void bKG() {
        if (this.gdb != null) {
            this.gdb.notifyDataSetChanged();
        }
    }

    public void v(String str, long j) {
        List<k> datas;
        if (this.gdb != null && (datas = this.gdb.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gcJ = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gdb.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gcX != null) {
            this.gcX.c(kVar);
        }
    }

    public void bKz() {
        if (this.gcX != null) {
            this.gcX.bKz();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gdc = 1;
        bKH();
        bKF();
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
        this.gda = null;
        this.gcX = null;
        if (this.gcO != null) {
            this.gcO.release();
        }
    }

    private void bKH() {
        this.gdb = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gdb.setType(1);
                break;
            case 2:
                this.gdb.setType(0);
                break;
        }
        this.gdb.Fv(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gdb.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gcX != null) {
                    d.this.gcX.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gcX != null) {
                    d.this.gcX.d(kVar);
                }
            }
        });
        if (this.gda != null) {
            this.gda.a(this.gdb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gcX != null) {
            this.gcX.lv(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gdc = i + 1;
            if (this.gdb != null) {
                if (i == 1) {
                    if (this.gda != null) {
                        this.gda.bR(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gdb.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gdb.bQ(list);
                }
            }
        } else if (this.gdc == 1) {
            if (this.gda != null) {
                this.gda.bKB();
                return;
            }
            return;
        }
        if (this.gda != null) {
            this.gda.I(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aYl))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aXL));
                        break;
                    case 2:
                        str = aVar.aXR;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aXM));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gda != null) {
                    this.gda.c(str, aVar.aXQ, aVar.aXJ, str2, aVar.liveStatus == 1 && !this.gcM);
                }
            }
        }
    }
}
