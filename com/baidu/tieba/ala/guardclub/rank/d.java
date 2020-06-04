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
    private boolean fAh;
    private i fAj;
    private a fAs;
    private b fAv;
    private m fAw;
    private int fAx;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void buT();

        void c(k kVar);

        void d(k kVar);

        void kb(boolean z);

        void qq(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void E(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bD(List<k> list);

        void buV();

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void j(int i, String str, boolean z) {
        this.mType = i;
        this.aWr = str;
        this.fAh = z;
    }

    public void a(b bVar) {
        this.fAv = bVar;
    }

    public void a(a aVar) {
        this.fAs = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void buZ() {
        if (this.fAj == null) {
            this.fAj = new i();
            this.fAj.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.fAj.b(this.aWr, this.fAx, 20, this.mType);
    }

    public void qt(int i) {
        if (this.fAs != null) {
            this.fAs.qq(i);
        }
    }

    public void bva() {
        if (this.fAw != null) {
            this.fAw.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.fAw != null && (datas = this.fAw.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.fAe = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.fAw.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.fAs != null) {
            this.fAs.c(kVar);
        }
    }

    public void buT() {
        if (this.fAs != null) {
            this.fAs.buT();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.fAx = 1;
        bvb();
        buZ();
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
        this.fAv = null;
        this.fAs = null;
    }

    private void bvb() {
        this.fAw = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.fAw.setType(1);
                break;
            case 2:
                this.fAw.setType(0);
                break;
        }
        this.fAw.BP(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.fAw.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.fAs != null) {
                    d.this.fAs.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.fAs != null) {
                    d.this.fAs.d(kVar);
                }
            }
        });
        if (this.fAv != null) {
            this.fAv.a(this.fAw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.fAs != null) {
            this.fAs.kb(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.fAx = i + 1;
            if (this.fAw != null) {
                if (i == 1) {
                    if (this.fAv != null) {
                        this.fAv.bD(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.fAw.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.fAw.bC(list);
                }
            }
        } else if (this.fAx == 1) {
            if (this.fAv != null) {
                this.fAv.buV();
                return;
            }
            return;
        }
        if (this.fAv != null) {
            this.fAv.E(z, i == 1);
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
                if (this.fAv != null) {
                    this.fAv.c(str, aVar.aOB, aVar.aOu, str2, aVar.liveStatus == 1 && !this.fAh);
                }
            }
        }
    }
}
