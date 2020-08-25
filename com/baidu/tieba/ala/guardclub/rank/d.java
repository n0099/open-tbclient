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
    private String ber;
    private boolean gcI;
    private i gcK;
    private a gcT;
    private b gcW;
    private m gcX;
    private int gcY;
    private Context mContext;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void bKy();

        void c(k kVar);

        void d(k kVar);

        void lt(boolean z);

        void tr(int i);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void I(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bKA();

        void bR(List<k> list);

        void c(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void i(int i, String str, boolean z) {
        this.mType = i;
        this.ber = str;
        this.gcI = z;
    }

    public void a(b bVar) {
        this.gcW = bVar;
    }

    public void a(a aVar) {
        this.gcT = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bKE() {
        if (this.gcK == null) {
            this.gcK = new i();
            this.gcK.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.gcK.c(this.ber, this.gcY, 20, this.mType);
    }

    public void tu(int i) {
        if (this.gcT != null) {
            this.gcT.tr(i);
        }
    }

    public void bKF() {
        if (this.gcX != null) {
            this.gcX.notifyDataSetChanged();
        }
    }

    public void v(String str, long j) {
        List<k> datas;
        if (this.gcX != null && (datas = this.gcX.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.gcF = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.gcX.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.gcT != null) {
            this.gcT.c(kVar);
        }
    }

    public void bKy() {
        if (this.gcT != null) {
            this.gcT.bKy();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.gcY = 1;
        bKG();
        bKE();
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
        this.gcW = null;
        this.gcT = null;
        if (this.gcK != null) {
            this.gcK.release();
        }
    }

    private void bKG() {
        this.gcX = new m(this.mContext);
        switch (this.mType) {
            case 1:
                this.gcX.setType(1);
                break;
            case 2:
                this.gcX.setType(0);
                break;
        }
        this.gcX.Fu(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.gcX.a(new m.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void a(k kVar) {
                if (d.this.gcT != null) {
                    d.this.gcT.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.m.a
            public void b(k kVar) {
                if (d.this.gcT != null) {
                    d.this.gcT.d(kVar);
                }
            }
        });
        if (this.gcW != null) {
            this.gcW.a(this.gcX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.gcT != null) {
            this.gcT.lt(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.gcY = i + 1;
            if (this.gcX != null) {
                if (i == 1) {
                    if (this.gcW != null) {
                        this.gcW.bR(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.gcX.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.gcX.bQ(list);
                }
            }
        } else if (this.gcY == 1) {
            if (this.gcW != null) {
                this.gcW.bKA();
                return;
            }
            return;
        }
        if (this.gcW != null) {
            this.gcW.I(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.aYj))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_total), Long.valueOf(aVar.aXJ));
                        break;
                    case 2:
                        str = aVar.aXP;
                        str2 = String.format(this.mContext.getString(a.i.guard_club_rank_list_contribution_week), Long.valueOf(aVar.aXK));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.gcW != null) {
                    this.gcW.c(str, aVar.aXO, aVar.aXH, str2, aVar.liveStatus == 1 && !this.gcI);
                }
            }
        }
    }
}
