package com.baidu.tieba.ala.alaar.makeup;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.base.BdLoadDataCallBack;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g extends com.baidu.tieba.ala.alaar.makeup.a<com.baidu.tieba.ala.alaar.makeup.a.c> {
    private static f gua = new f();
    private boolean clE;
    private i gtW;
    private com.baidu.tieba.ala.alaar.makeup.c.a gtX;
    private com.baidu.tieba.ala.alaar.makeup.a.c gtY;
    private boolean gtZ;
    private BdLoadDataCallBack gub;

    static {
        gua.register();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if (h.isDebug()) {
            h.d("MakeupDM", "updateGender ...");
        }
        bPf();
        bPg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static g gud = new g();
    }

    private g() {
        this.gtW = new i();
        this.gtZ = true;
        this.gub = new BdLoadDataCallBack() { // from class: com.baidu.tieba.ala.alaar.makeup.g.1
            @Override // com.baidu.live.adp.base.BdLoadDataCallBack
            public void callback(Object obj) {
                if (obj instanceof com.baidu.tieba.ala.alaar.makeup.a.c) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) obj);
                } else if (obj == null) {
                    g.this.a((com.baidu.tieba.ala.alaar.makeup.a.c) null);
                }
                g.this.bPy();
            }
        };
        this.clE = true;
    }

    public static g bPz() {
        return a.gud;
    }

    public boolean bPA() {
        boolean z = this.gtY != null && this.gtY.zy();
        if (h.isDebug()) {
            d("shouldShowMakeup: " + z);
        }
        return z;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bPd() {
        return this.gtY == null || this.gtY.bPH() == null || this.gtY.bPH().size() <= 0;
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.a
    protected boolean bPe() {
        long currentTimeMillis = System.currentTimeMillis();
        if (isEmpty()) {
            Log.d("bugbye", "bugbye");
        }
        if (isEmpty()) {
            this.gtY = bPD();
        }
        this.gtW.setLoadDataCallBack(this.gub);
        this.gtW.loadData();
        if (isEmpty()) {
            return true;
        }
        bPy();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (h.isDebug()) {
            d("getAllData: cost time = " + (currentTimeMillis2 - currentTimeMillis));
        }
        return false;
    }

    private boolean isEmpty() {
        return this.gtY == null || this.gtY.bPH() == null || this.gtY.bPH().size() <= 0;
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bPB() {
        return this.gtY;
    }

    public List<d> bPC() {
        com.baidu.tieba.ala.alaar.makeup.a.b bPH;
        if (this.gtY == null || !this.gtY.zy() || (bPH = this.gtY.bPH()) == null || bPH.getData() == null) {
            return null;
        }
        return bPH.getData();
    }

    public void init() {
        this.gtW.init();
    }

    public void onDestroy() {
        bPE();
        this.gtW.onDestroy();
    }

    private void d(String str) {
        h.d("MakeupDM", str);
    }

    private com.baidu.tieba.ala.alaar.makeup.a.c bPD() {
        com.baidu.tieba.ala.alaar.makeup.a.c cVar;
        JSONObject json;
        String str = null;
        if (this.gtX == null) {
            this.gtX = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        com.baidu.tieba.ala.alaar.makeup.a.c cVar2 = new com.baidu.tieba.ala.alaar.makeup.a.c();
        if (this.gtX.getValue().intValue() < 0) {
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

    public void bPE() {
        JSONObject json;
        if (this.gtX == null) {
            this.gtX = new com.baidu.tieba.ala.alaar.makeup.c.a("AR_user_makeup_net_data_ver", 0);
        }
        String str = null;
        if (this.gtY != null && (json = this.gtY.toJson()) != null) {
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
        if (this.gtY == null) {
            this.gtY = cVar;
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate first: " + cVar.toJson());
            }
        } else if (!TextUtils.equals(this.gtY.getSign(), cVar.getSign())) {
            if (h.isDebug()) {
                h.d("MakeupDM", "onMakeupNetDataUpdate update: " + cVar.toJson());
            }
            if (this.gtY.getPosition() != 0) {
                cVar.setPosition(this.gtY.getPosition());
            }
            cVar.ml(this.gtY.bPJ());
            com.baidu.tieba.ala.alaar.makeup.a.b bPH = cVar.bPH();
            cVar.ml(this.gtY.bPJ());
            cVar.setData(p(bPH.getData(), this.gtY.bPH().getData()));
            this.gtY = cVar;
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
                if (ut2.getValue() != ut2.bPm()) {
                    ut.setValue(ut2.getValue());
                }
                if ((ut instanceof d) && (ut2 instanceof d)) {
                    ((d) ut).setPosition(ut2.getPosition());
                    ((d) ut).ca(p(((d) ut).bPv(), ut2.bPv()));
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
