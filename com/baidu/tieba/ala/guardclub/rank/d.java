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
    private boolean aVQ;
    private String bvS;
    private i hcK;
    private a hcT;
    private b hcW;
    private n hcX;
    private int hcY;
    private Context mContext;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void bZg();

        void c(k kVar);

        void d(k kVar);

        void nq(boolean z);

        void wa(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void M(boolean z, boolean z2);

        void a(BaseAdapter baseAdapter);

        void bZi();

        void cB(List<k> list);

        void h(String str, String str2, String str3, String str4, boolean z);
    }

    public d(Context context) {
        this.mContext = context;
    }

    public void k(int i, String str, boolean z) {
        this.mType = i;
        this.bvS = str;
        this.aVQ = z;
    }

    public void a(b bVar) {
        this.hcW = bVar;
    }

    public void a(a aVar) {
        this.hcT = aVar;
    }

    public int getType() {
        return this.mType;
    }

    public void bZm() {
        if (this.hcK == null) {
            this.hcK = new i();
            this.hcK.a(new com.baidu.tieba.ala.guardclub.model.b() { // from class: com.baidu.tieba.ala.guardclub.rank.d.1
                @Override // com.baidu.tieba.ala.guardclub.model.b, com.baidu.tieba.ala.guardclub.model.m.a
                public void a(int i, com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i2, boolean z, boolean z2) {
                    super.a(i, aVar, list, fVar, i2, z, z2);
                    if (i == d.this.mType) {
                        d.this.a(aVar, list, fVar, i2, z, z2);
                    }
                }
            });
        }
        this.hcK.c(this.bvS, this.hcY, 20, this.mType);
    }

    public void wd(int i) {
        if (this.hcT != null) {
            this.hcT.wa(i);
        }
    }

    public void bZn() {
        if (this.hcX != null) {
            this.hcX.notifyDataSetChanged();
        }
    }

    public void y(String str, long j) {
        List<k> datas;
        if (this.hcX != null && (datas = this.hcX.getDatas()) != null && !datas.isEmpty()) {
            for (k kVar : datas) {
                if (kVar.id.equals(str)) {
                    kVar.hcG = true;
                    if (j > 0) {
                        kVar.score = String.valueOf(j);
                    }
                }
            }
            this.hcX.notifyDataSetChanged();
        }
    }

    public void f(k kVar) {
        if (this.hcT != null) {
            this.hcT.c(kVar);
        }
    }

    public void bZg() {
        if (this.hcT != null) {
            this.hcT.bZg();
        }
    }

    @Override // com.baidu.tieba.ala.guardclub.rank.e
    public void onInitial() {
        this.hcY = 1;
        bZo();
        bZm();
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
        this.hcW = null;
        this.hcT = null;
        if (this.hcK != null) {
            this.hcK.release();
        }
    }

    private void bZo() {
        this.hcX = new n(this.mContext);
        switch (this.mType) {
            case 1:
                this.hcX.setType(1);
                break;
            case 2:
                this.hcX.setType(0);
                break;
        }
        this.hcX.gb(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
        this.hcX.a(new n.a() { // from class: com.baidu.tieba.ala.guardclub.rank.d.2
            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void a(k kVar) {
                if (d.this.hcT != null) {
                    d.this.hcT.c(kVar);
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.n.a
            public void b(k kVar) {
                if (d.this.hcT != null) {
                    d.this.hcT.d(kVar);
                }
            }
        });
        if (this.hcW != null) {
            this.hcW.a(this.hcX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.guardclub.a aVar, List<k> list, f fVar, int i, boolean z, boolean z2) {
        if (this.hcT != null) {
            this.hcT.nq(z2 && aVar != null && aVar.liveStatus == 1);
        }
        if (list != null && !list.isEmpty()) {
            this.hcY = i + 1;
            if (this.hcX != null) {
                if (i == 1) {
                    if (this.hcW != null) {
                        this.hcW.cB(list.subList(0, list.size() >= 3 ? 3 : list.size()));
                    }
                    if (list.size() > 3) {
                        this.hcX.setData(list.subList(3, list.size()));
                    }
                } else {
                    this.hcX.cA(list);
                }
            }
        } else if (this.hcY == 1) {
            if (this.hcW != null) {
                this.hcW.bZi();
                return;
            }
            return;
        }
        if (this.hcW != null) {
            this.hcW.M(z, i == 1);
        }
        if (aVar != null) {
            if (z2 || (fVar != null && !TextUtils.isEmpty(fVar.bkW))) {
                String str = null;
                String str2 = null;
                switch (this.mType) {
                    case 1:
                        str = aVar.rank;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_total), Long.valueOf(aVar.bku));
                        break;
                    case 2:
                        str = aVar.bkz;
                        str2 = String.format(this.mContext.getString(a.h.guard_club_rank_list_contribution_week), Long.valueOf(aVar.bkv));
                        break;
                }
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (this.hcW != null) {
                    this.hcW.h(str, aVar.bky, aVar.bks, str2, aVar.liveStatus == 1 && !this.aVQ);
                }
            }
        }
    }
}
