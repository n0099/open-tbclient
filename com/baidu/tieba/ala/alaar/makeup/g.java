package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gsd = new f();
    private boolean cke;
    private i grZ;
    private com.baidu.tieba.ala.alaar.makeup.c.a gsa;
    private com.baidu.tieba.ala.alaar.makeup.a.c gsb;
    private boolean gsc;
    private BdLoadDataCallBack gse;

    static {
        gsd.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPl() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bOS();
        bOT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static g gsg = new g();
    }

    private g() {
        this.grZ = new i();
        this.gsc = true;
        this.gse = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bPl();
            }
        };
        this.cke = true;
    }

    public static g bPm() {
        return a.gsg;
    }

    public boolean bPn() {
        boolean z = this.gsb != null && this.gsb.zv();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bOQ() {
        return this.gsb == null || this.gsb.bPu() == null || this.gsb.bPu().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bOR() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
            Log.d("bugbye", "bugbye");
        }
        if (isEmpty()) {
            this.gsb = bPq();
        }
        this.grZ.setLoadDataCallBack(this.gse);
        this.grZ.loadData();
        if (isEmpty()) {
            return true;
        }
        bPl();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gsb == null || this.gsb.bPu() == null || this.gsb.bPu().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bPo() {
        return this.gsb;
    }

    public List<d> bPp() {
        com.baidu.tieba.ala.alaar.makeup.a.b bPu;
        if (this.gsb == null || !this.gsb.zv() || (bPu = this.gsb.bPu()) == null || bPu.getData() == null) {
            return null;
        }
        return bPu.getData();
    }

    public void init() {
        this.grZ.init();
    }

    public void onDestroy() {
        bPr();
        this.grZ.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bPq() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gsa == null) {
            this.gsa = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gsa.getValue().intValue() < 0) {
            com.baidu.live.d.xc().putString("AR_user_makeup_net_data", null);
            cVar = null;
        } else {
            cVar = cVar2.parse(com.baidu.live.d.xc().getString("AR_user_makeup_net_data", null)) ? cVar2 : null;
        }
        if (h.isDebug()) {
            if (cVar2 != null && (json = cVar2.toJson()) != null) {
                str = json.toString();
            }
            h.d("MakeupDM", "readUserMakeup " + str);
        }
        return cVar;
    }

    public void bPr() {
        JSONObject json;
        if (this.gsa == null) {
            this.gsa = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gsb != null && (json = this.gsb.toJson()) != null) {
            str = json.toString();
        }
        com.baidu.live.d.xc().putString("AR_user_makeup_net_data", str);
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
        if (this.gsb == null) {
            this.gsb = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gsb.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gsb.getPosition() != 0) {
                cVar.setPosition(this.gsb.getPosition());
            }
            cVar.ml(this.gsb.bPw());
            com.baidu.tieba.ala.alaar.makeup.a.b bPu = cVar.bPu();
            cVar.ml(this.gsb.bPw());
            cVar.setData(q(bPu.getData(), this.gsb.bPu().getData()));
            this.gsb = cVar;
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
                if (ut2.getValue() != ut2.bOZ()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).ca(q(((d) ut).bPi(), ut2.bPi()));
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
