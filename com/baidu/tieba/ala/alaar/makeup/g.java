package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gbI = new f();
    private boolean cam;
    private i gbE;
    private com.baidu.tieba.ala.alaar.makeup.c.a gbF;
    private com.baidu.tieba.ala.alaar.makeup.a.c gbG;
    private boolean gbH;
    private BdLoadDataCallBack gbJ;

    static {
        gbI.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMT() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bMC();
        bMD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static g gbL = new g();
    }

    private g() {
        this.gbE = new i();
        this.gbH = true;
        this.gbJ = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bMT();
            }
        };
        this.cam = true;
    }

    public static g bMU() {
        return a.gbL;
    }

    public boolean bMV() {
        boolean z = this.gbG != null && this.gbG.Cs();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bMA() {
        return this.gbG == null || this.gbG.bNc() == null || this.gbG.bNc().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bMB() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.gbG = bMY();
        }
        this.gbE.setLoadDataCallBack(this.gbJ);
        this.gbE.loadData();
        if (isEmpty()) {
            return true;
        }
        bMT();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gbG == null || this.gbG.bNc() == null || this.gbG.bNc().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bMW() {
        return this.gbG;
    }

    public List<d> bMX() {
        com.baidu.tieba.ala.alaar.makeup.a.b bNc;
        if (this.gbG == null || !this.gbG.Cs() || (bNc = this.gbG.bNc()) == null || bNc.getData() == null) {
            return null;
        }
        return bNc.getData();
    }

    public void init() {
        this.gbE.init();
    }

    public void onDestroy() {
        bMZ();
        this.gbE.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bMY() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gbF == null) {
            this.gbF = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gbF.getValue().intValue() < 0) {
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

    public void bMZ() {
        JSONObject json;
        if (this.gbF == null) {
            this.gbF = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gbG != null && (json = this.gbG.toJson()) != null) {
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
        if (this.gbG == null) {
            this.gbG = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gbG.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gbG.getPosition() != 0) {
                cVar.setPosition(this.gbG.getPosition());
            }
            cVar.ls(this.gbG.bNe());
            com.baidu.tieba.ala.alaar.makeup.a.b bNc = cVar.bNc();
            cVar.ls(this.gbG.bNe());
            cVar.setData(q(bNc.getData(), this.gbG.bNc().getData()));
            this.gbG = cVar;
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
                if (ut2.getValue() != ut2.bMH()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).bU(q(((d) ut).bMQ(), ut2.bMQ()));
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
