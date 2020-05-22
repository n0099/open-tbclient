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
public class d implements e {
    private String aWr;
    private a fAh;
    private b fAk;
    private m fAl;
    private int fAm;
    private boolean fzW;
    private i fzY;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void buR();

        void c(k kVar);

        void d(k kVar);

        void kb(boolean z);

        void qo(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bD(List<k> list);

        void buT();

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aWr = str;
        this.fzW = z;
    }

    public void a(b bVar) {
        this.fAk = bVar;
    }

    public void a(a aVar) {
        this.fAh = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void buX() {
        if (this.fzY == null) {
            this.fzY = new i();
            this.fzY.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fzY.b(this.aWr, this.fAm, 20, this.mType);
    }

    public void qr(int i) {
        if (this.fAh != null) {
            this.fAh.qo(i);
        }
    }

    public void buY() {
        if (this.fAl != null) {
            this.fAl.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.fAl != null && (datas = this.fAl.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fzT = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fAl.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fAh != null) {
            this.fAh.c(kVar);
        }
    }

    public void buR() {
        if (this.fAh != null) {
            this.fAh.buR();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.fAm = 1;
        buZ();
        buX();
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
        this.fAk = null;
        this.fAh = null;
    }

    private void buZ() {
        this.fAl = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fAl.setType(1);
                break;
            case 2:
                this.fAl.setType(0);
                break;
        }
        this.fAl.BP(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fAl.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.fAh != null) {
                    d.this.fAh.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.fAh != null) {
                    d.this.fAh.d(kVar);
                }
            }
        });
        if (this.fAk != null) {
            this.fAk.a(this.fAl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fAh != null) {
            this.fAh.kb(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fAm = i + 1;
            if (this.fAl != null) {
                if (i == 1) {
                    if (this.fAk != null) {
                        this.fAk.bD(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fAl.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fAl.bC(list);
                }
            }
        } else if (this.fAm == 1) {
            if (this.fAk != null) {
                this.fAk.buT();
                return;
            }
            return;
        }
        if (this.fAk != null) {
            this.fAk.E(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aOW))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aOw));
                        break;
                    case 2:
                        str = aVar.aOC;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aOx));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.fAk != null) {
                    this.fAk.c(str, aVar.aOB, aVar.aOu, str2, aVar.liveStatus == 1 && !this.fzW);
                }
            }
        }
    }
}
