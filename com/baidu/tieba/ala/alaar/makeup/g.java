package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gbp = new f();
    private boolean bYB;
    private i gbl;
    private com.baidu.tieba.ala.alaar.makeup.c.a gbm;
    private com.baidu.tieba.ala.alaar.makeup.a.c gbn;
    private boolean gbo;
    private BdLoadDataCallBack gbq;

    static {
        gbp.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMm() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bLV();
        bLW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static g gbs = new g();
    }

    private g() {
        this.gbl = new i();
        this.gbo = true;
        this.gbq = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bMm();
            }
        };
        this.bYB = true;
    }

    public static g bMn() {
        return a.gbs;
    }

    public boolean bMo() {
        boolean z = this.gbn != null && this.gbn.BJ();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bLT() {
        return this.gbn == null || this.gbn.bMv() == null || this.gbn.bMv().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bLU() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.gbn = bMr();
        }
        this.gbl.setLoadDataCallBack(this.gbq);
        this.gbl.loadData();
        if (isEmpty()) {
            return true;
        }
        bMm();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gbn == null || this.gbn.bMv() == null || this.gbn.bMv().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bMp() {
        return this.gbn;
    }

    public List<d> bMq() {
        com.baidu.tieba.ala.alaar.makeup.a.b bMv;
        if (this.gbn == null || !this.gbn.BJ() || (bMv = this.gbn.bMv()) == null || bMv.getData() == null) {
            return null;
        }
        return bMv.getData();
    }

    public void init() {
        this.gbl.init();
    }

    public void onDestroy() {
        bMs();
        this.gbl.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bMr() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gbm == null) {
            this.gbm = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gbm.getValue().intValue() < 0) {
            com.baidu.live.d.Aq().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.Aq().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bMs() {
        JSONObject json;
        if (this.gbm == null) {
            this.gbm = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gbn != null && (json = this.gbn.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.Aq().putString("AR_user_makeup_net_data", str);
        if (h.isDebug()) {
            h.d("MakeupDM", "saveUserMakeup " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        if (cVar == null || cVar.size() <= 0) {
            h.d("MakeupDM", "onMakeupNetDataUpdate: null");
            return false;
        }
        if (this.gbn == null) {
            this.gbn = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gbn.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gbn.getPosition() != 0) {
                cVar.setPosition(this.gbn.getPosition());
            }
            cVar.lt(this.gbn.bMx());
            com.baidu.tieba.ala.alaar.makeup.a.b bMv = cVar.bMv();
            cVar.lt(this.gbn.bMx());
            cVar.setData(q(bMv.getData(), this.gbn.bMv().getData()));
            this.gbn = cVar;
        }
        return true;
    }

    private <UT extends c> UT a(UT ut, List<UT> list) {
        if (ut != null && list != null && !list.isEmpty()) {
            UT ut2 = null;
            String typeName = ut.getTypeName();
            Iterator<UT> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UT next = it.next();
                if (next != null && TextUtils.equals(next.getId(), ut.getId()) && TextUtils.equals(next.getTypeName(), typeName)) {
                    ut2 = next;
                    break;
                }
            }
            if (ut2 != null) {
                if (ut2.getValue() != ut2.bMa()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).bU(q(((d) ut).bMj(), ut2.bMj()));
                }
            }
        }
        return ut;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<LS extends com.baidu.tieba.ala.alaar.makeup.c> */
    /* JADX WARN: Multi-variable type inference failed */
    private <LS extends c> List<LS> q(List<LS> list, List<LS> list2) {
        c a2;
        if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                c cVar = (c) list.get(i2);
                if (cVar != null && (a2 = a((g) cVar, (List<g>) list2)) != cVar) {
                    if (a2 != null) {
                        list.set(i2, a2);
                    } else {
                        list.remove(i2);
                        i2--;
                    }
                }
                i = i2 + 1;
            }
        }
        return list;
    }
}
