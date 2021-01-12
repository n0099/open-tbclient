package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gpu = new f();
    private boolean cfU;
    private i gpq;
    private com.baidu.tieba.ala.alaar.makeup.c.a gpr;
    private com.baidu.tieba.ala.alaar.makeup.a.c gps;
    private boolean gpt;
    private BdLoadDataCallBack gpv;

    static {
        gpu.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bOo();
        bOp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static g gpx = new g();
    }

    private g() {
        this.gpq = new i();
        this.gpt = true;
        this.gpv = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bOH();
            }
        };
        this.cfU = true;
    }

    public static g bOI() {
        return a.gpx;
    }

    public boolean bOJ() {
        boolean z = this.gps != null && this.gps.yO();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bOm() {
        return this.gps == null || this.gps.bOQ() == null || this.gps.bOQ().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bOn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.gps = bOM();
        }
        this.gpq.setLoadDataCallBack(this.gpv);
        this.gpq.loadData();
        if (isEmpty()) {
            return true;
        }
        bOH();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gps == null || this.gps.bOQ() == null || this.gps.bOQ().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bOK() {
        return this.gps;
    }

    public List<d> bOL() {
        com.baidu.tieba.ala.alaar.makeup.a.b bOQ;
        if (this.gps == null || !this.gps.yO() || (bOQ = this.gps.bOQ()) == null || bOQ.getData() == null) {
            return null;
        }
        return bOQ.getData();
    }

    public void init() {
        this.gpq.init();
    }

    public void onDestroy() {
        bON();
        this.gpq.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bOM() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gpr == null) {
            this.gpr = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gpr.getValue().intValue() < 0) {
            com.baidu.live.d.xf().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.xf().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bON() {
        JSONObject json;
        if (this.gpr == null) {
            this.gpr = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gps != null && (json = this.gps.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.xf().putString("AR_user_makeup_net_data", str);
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
        if (this.gps == null) {
            this.gps = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gps.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gps.getPosition() != 0) {
                cVar.setPosition(this.gps.getPosition());
            }
            cVar.mh(this.gps.bOS());
            com.baidu.tieba.ala.alaar.makeup.a.b bOQ = cVar.bOQ();
            cVar.mh(this.gps.bOS());
            cVar.setData(r(bOQ.getData(), this.gps.bOQ().getData()));
            this.gps = cVar;
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
                if (ut2.getValue() != ut2.bOv()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).cf(r(((d) ut).bOE(), ut2.bOE()));
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
