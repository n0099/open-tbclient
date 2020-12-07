package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gjA = new f();
    private boolean cec;
    private BdLoadDataCallBack gjB;
    private i gjw;
    private com.baidu.tieba.ala.alaar.makeup.c.a gjx;
    private com.baidu.tieba.ala.alaar.makeup.a.c gjy;
    private boolean gjz;

    static {
        gjA.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPX() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bPE();
        bPF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static g gjD = new g();
    }

    private g() {
        this.gjw = new i();
        this.gjz = true;
        this.gjB = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bPX();
            }
        };
        this.cec = true;
    }

    public static g bPY() {
        return a.gjD;
    }

    public boolean bPZ() {
        boolean z = this.gjy != null && this.gjy.Dt();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bPC() {
        return this.gjy == null || this.gjy.bQg() == null || this.gjy.bQg().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bPD() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
        }
        if (isEmpty()) {
            this.gjy = bQc();
        }
        this.gjw.setLoadDataCallBack(this.gjB);
        this.gjw.loadData();
        if (isEmpty()) {
            return true;
        }
        bPX();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gjy == null || this.gjy.bQg() == null || this.gjy.bQg().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bQa() {
        return this.gjy;
    }

    public List<d> bQb() {
        com.baidu.tieba.ala.alaar.makeup.a.b bQg;
        if (this.gjy == null || !this.gjy.Dt() || (bQg = this.gjy.bQg()) == null || bQg.getData() == null) {
            return null;
        }
        return bQg.getData();
    }

    public void init() {
        this.gjw.init();
    }

    public void onDestroy() {
        bQd();
        this.gjw.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bQc() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gjx == null) {
            this.gjx = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gjx.getValue().intValue() < 0) {
            com.baidu.live.d.BM().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.BM().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bQd() {
        JSONObject json;
        if (this.gjx == null) {
            this.gjx = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gjy != null && (json = this.gjy.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.BM().putString("AR_user_makeup_net_data", str);
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
        if (this.gjy == null) {
            this.gjy = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gjy.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gjy.getPosition() != 0) {
                cVar.setPosition(this.gjy.getPosition());
            }
            cVar.lO(this.gjy.bQi());
            com.baidu.tieba.ala.alaar.makeup.a.b bQg = cVar.bQg();
            cVar.lO(this.gjy.bQi());
            cVar.setData(p(bQg.getData(), this.gjy.bQg().getData()));
            this.gjy = cVar;
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
                if (ut2.getValue() != ut2.bPL()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).bY(p(((d) ut).bPU(), ut2.bPU()));
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
