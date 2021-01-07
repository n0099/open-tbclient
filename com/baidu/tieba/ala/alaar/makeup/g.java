package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gub = new f();
    private boolean ckH;
    private i gtX;
    private com.baidu.tieba.ala.alaar.makeup.c.a gtY;
    private com.baidu.tieba.ala.alaar.makeup.a.c gtZ;
    private boolean gua;
    private BdLoadDataCallBack guc;

    static {
        gub.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSz() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bSg();
        bSh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static g gue = new g();
    }

    private g() {
        this.gtX = new i();
        this.gua = true;
        this.guc = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bSz();
            }
        };
        this.ckH = true;
    }

    public static g bSA() {
        return a.gue;
    }

    public boolean bSB() {
        boolean z = this.gtZ != null && this.gtZ.CJ();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bSe() {
        return this.gtZ == null || this.gtZ.bSI() == null || this.gtZ.bSI().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bSf() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.gtZ = bSE();
        }
        this.gtX.setLoadDataCallBack(this.guc);
        this.gtX.loadData();
        if (isEmpty()) {
            return true;
        }
        bSz();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gtZ == null || this.gtZ.bSI() == null || this.gtZ.bSI().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bSC() {
        return this.gtZ;
    }

    public List<d> bSD() {
        com.baidu.tieba.ala.alaar.makeup.a.b bSI;
        if (this.gtZ == null || !this.gtZ.CJ() || (bSI = this.gtZ.bSI()) == null || bSI.getData() == null) {
            return null;
        }
        return bSI.getData();
    }

    public void init() {
        this.gtX.init();
    }

    public void onDestroy() {
        bSF();
        this.gtX.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bSE() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gtY == null) {
            this.gtY = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gtY.getValue().intValue() < 0) {
            com.baidu.live.d.Ba().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.Ba().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bSF() {
        JSONObject json;
        if (this.gtY == null) {
            this.gtY = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gtZ != null && (json = this.gtZ.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.Ba().putString("AR_user_makeup_net_data", str);
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
        if (this.gtZ == null) {
            this.gtZ = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gtZ.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gtZ.getPosition() != 0) {
                cVar.setPosition(this.gtZ.getPosition());
            }
            cVar.ml(this.gtZ.bSK());
            com.baidu.tieba.ala.alaar.makeup.a.b bSI = cVar.bSI();
            cVar.ml(this.gtZ.bSK());
            cVar.setData(r(bSI.getData(), this.gtZ.bSI().getData()));
            this.gtZ = cVar;
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
                if (ut2.getValue() != ut2.bSn()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).cf(r(((d) ut).bSw(), ut2.bSw()));
                }
            }
        }
        return ut;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<LS extends com.baidu.tieba.ala.alaar.makeup.c> */
    /* JADX WARN: Multi-variable type inference failed */
    private <LS extends c> List<LS> r(List<LS> list, List<LS> list2) {
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
