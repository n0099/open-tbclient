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
public class b implements c {
    private String awn;
    private boolean eHj;
    private i eHl;
    private a eHu;
    private InterfaceC0436b eHx;
    private m eHy;
    private int eHz;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bfC();

        void c(k kVar);

        void d(k kVar);

        void iF(boolean z);

        void pr(int i);
    }

    /* renamed from: com.baidu.tieba.ala.guardclub.rank.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0436b {
        void B(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bfF();

        void bx(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.awn = str;
        this.eHj = z;
    }

    public void a(InterfaceC0436b interfaceC0436b) {
        this.eHx = interfaceC0436b;
    }

    public void a(a aVar) {
        this.eHu = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bfJ() {
        if (this.eHl == null) {
            this.eHl = new i();
            this.eHl.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.eHl.b(this.awn, this.eHz, 20, this.mType);
    }

    public void pu(int i) {
        if (this.eHu != null) {
            this.eHu.pr(i);
        }
    }

    public void bfK() {
        if (this.eHy != null) {
            this.eHy.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.eHy != null && (datas = this.eHy.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.eHg = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.eHy.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.eHu != null) {
            this.eHu.c(kVar);
        }
    }

    public void bfC() {
        if (this.eHu != null) {
            this.eHu.bfC();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eHz = 1;
        bfL();
        bfJ();
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
        this.eHx = null;
        this.eHu = null;
    }

    private void bfL() {
        this.eHy = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.eHy.setType(1);
                break;
            case 2:
                this.eHy.setType(0);
                break;
        }
        this.eHy.yv(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eHy.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.eHu != null) {
                    b.this.eHu.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.eHu != null) {
                    b.this.eHu.d(kVar);
                }
            }
        });
        if (this.eHx != null) {
            this.eHx.a(this.eHy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.eHu != null) {
            this.eHu.iF(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eHz = i + 1;
            if (this.eHy != null) {
                if (i == 1) {
                    if (this.eHx != null) {
                        this.eHx.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eHy.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eHy.bw(list);
                }
            }
        } else if (this.eHz == 1) {
            if (this.eHx != null) {
                this.eHx.bfF();
                return;
            }
            return;
        }
        if (this.eHx != null) {
            this.eHx.B(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aqn))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.apN));
                        break;
                    case 2:
                        str = aVar.apT;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.apO));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.eHx != null) {
                    this.eHx.c(str, aVar.apS, aVar.apL, str2, aVar.liveStatus == 1 && !this.eHj);
                }
            }
        }
    }
}
