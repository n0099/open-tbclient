package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f fVR = new f();
    private boolean bUC;
    private i fVN;
    private com.baidu.tieba.ala.alaar.makeup.c.a fVO;
    private com.baidu.tieba.ala.alaar.makeup.a.c fVP;
    private boolean fVQ;
    private BdLoadDataCallBack fVS;

    static {
        fVR.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKu() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bKd();
        bKe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static g fVU = new g();
    }

    private g() {
        this.fVN = new i();
        this.fVQ = true;
        this.fVS = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bKu();
            }
        };
        this.bUC = true;
    }

    public static g bKv() {
        return a.fVU;
    }

    public boolean bKw() {
        boolean z = this.fVP != null && this.fVP.Ca();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bKb() {
        return this.fVP == null || this.fVP.bKD() == null || this.fVP.bKD().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bKc() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.fVP = bKz();
        }
        this.fVN.setLoadDataCallBack(this.fVS);
        this.fVN.loadData();
        if (isEmpty()) {
            return true;
        }
        bKu();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.fVP == null || this.fVP.bKD() == null || this.fVP.bKD().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bKx() {
        return this.fVP;
    }

    public List<d> bKy() {
        com.baidu.tieba.ala.alaar.makeup.a.b bKD;
        if (this.fVP == null || !this.fVP.Ca() || (bKD = this.fVP.bKD()) == null || bKD.getData() == null) {
            return null;
        }
        return bKD.getData();
    }

    public void init() {
        this.fVN.init();
    }

    public void onDestroy() {
        bKA();
        this.fVN.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bKz() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.fVO == null) {
            this.fVO = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.fVO.getValue().intValue() < 0) {
            com.baidu.live.d.AZ().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.AZ().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bKA() {
        JSONObject json;
        if (this.fVO == null) {
            this.fVO = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.fVP != null && (json = this.fVP.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.AZ().putString("AR_user_makeup_net_data", str);
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
        if (this.fVP == null) {
            this.fVP = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.fVP.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.fVP.getPosition() != 0) {
                cVar.setPosition(this.fVP.getPosition());
            }
            cVar.lj(this.fVP.bKF());
            com.baidu.tieba.ala.alaar.makeup.a.b bKD = cVar.bKD();
            cVar.lj(this.fVP.bKF());
            cVar.setData(p(bKD.getData(), this.fVP.bKD().getData()));
            this.fVP = cVar;
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
                if (ut2.getValue() != ut2.bKi()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).bN(p(((d) ut).bKr(), ut2.bKr()));
                }
            }
        }
        return ut;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<LS extends com.baidu.tieba.ala.alaar.makeup.c> */
    /* JADX WARN: Multi-variable type inference failed */
    private <LS extends c> List<LS> p(List<LS> list, List<LS> list2) {
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
