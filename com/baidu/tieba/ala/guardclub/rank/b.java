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
    private String awo;
    private int eHA;
    private boolean eHk;
    private i eHm;
    private a eHv;
    private InterfaceC0436b eHy;
    private m eHz;
    private Context mContext;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void bfE();

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

        void bfH();

        void bx(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.awo = str;
        this.eHk = z;
    }

    public void a(InterfaceC0436b interfaceC0436b) {
        this.eHy = interfaceC0436b;
    }

    public void a(a aVar) {
        this.eHv = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bfL() {
        if (this.eHm == null) {
            this.eHm = new i();
            this.eHm.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.b.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == b.this.mType) {
                        b.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.eHm.b(this.awo, this.eHA, 20, this.mType);
    }

    public void pu(int i) {
        if (this.eHv != null) {
            this.eHv.pr(i);
        }
    }

    public void bfM() {
        if (this.eHz != null) {
            this.eHz.notifyDataSetChanged();
        }
    }

    public void w(String str, long j) {
        List<k> datas;
        if (this.eHz != null && (datas = this.eHz.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.eHh = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.eHz.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.eHv != null) {
            this.eHv.c(kVar);
        }
    }

    public void bfE() {
        if (this.eHv != null) {
            this.eHv.bfE();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.c
    public void onInitial() {
        this.eHA = 1;
        bfN();
        bfL();
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
        this.eHy = null;
        this.eHv = null;
    }

    private void bfN() {
        this.eHz = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.eHz.setType(1);
                break;
            case 2:
                this.eHz.setType(0);
                break;
        }
        this.eHz.yv(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.eHz.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.b.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (b.this.eHv != null) {
                    b.this.eHv.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (b.this.eHv != null) {
                    b.this.eHv.d(kVar);
                }
            }
        });
        if (this.eHy != null) {
            this.eHy.a(this.eHz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.eHv != null) {
            this.eHv.iF(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.eHA = i + 1;
            if (this.eHz != null) {
                if (i == 1) {
                    if (this.eHy != null) {
                        this.eHy.bx(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.eHz.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.eHz.bw(list);
                }
            }
        } else if (this.eHA == 1) {
            if (this.eHy != null) {
                this.eHy.bfH();
                return;
            }
            return;
        }
        if (this.eHy != null) {
            this.eHy.B(z, i == 1);
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
                if (this.eHy != null) {
                    this.eHy.c(str, aVar.apS, aVar.apL, str2, aVar.liveStatus == 1 && !this.eHk);
                }
            }
        }
    }
}
