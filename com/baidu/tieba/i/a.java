package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String boR;
    private String bpa;
    private String bpb;
    private String elR;
    private boolean isSelected;
    private String jbb;
    private b jbc;
    private String jbd;
    private String jbe;
    private String jbf;
    private String jbg;
    private String jbh;
    private List<C0720a> jbi;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Kv(String str) {
        this.jbb = str;
    }

    public String cCq() {
        return this.boR;
    }

    public void Kw(String str) {
        this.boR = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void Kx(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cCr() {
        return this.jbc;
    }

    public void a(b bVar) {
        this.jbc = bVar;
    }

    public void Ky(String str) {
        this.jbd = str;
    }

    public String cCs() {
        return this.jbe;
    }

    public void Kz(String str) {
        this.jbe = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void KA(String str) {
        this.jbf = str;
    }

    public void KB(String str) {
        this.jbg = str;
    }

    public void KC(String str) {
        this.bpb = str;
    }

    public void KD(String str) {
        this.bpa = str;
    }

    public void KE(String str) {
        this.jbh = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cCt() {
        return this.elR;
    }

    public void KF(String str) {
        this.elR = str;
    }

    public void qi(boolean z) {
        this.isSelected = z;
    }

    public List<C0720a> getImageList() {
        return this.jbi;
    }

    public void dj(List<C0720a> list) {
        this.jbi = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jbj;
        private String jbk;
        private String jbl;

        public void KG(String str) {
            this.jbj = str;
        }

        public String cCu() {
            return this.jbk;
        }

        public void KH(String str) {
            this.jbk = str;
        }

        public String cCv() {
            return this.jbl;
        }

        public void KI(String str) {
            this.jbl = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0720a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a dV(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.Ky(jSONObject.optString("commission"));
        aVar.KC(jSONObject.optString("coupon"));
        aVar.KF(jSONObject.optString("goodsId"));
        aVar.KA(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0720a c0720a = new C0720a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0720a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0720a);
                }
            }
            aVar.dj(arrayList);
        }
        aVar.KE(jSONObject.optString("isBindingVideo"));
        aVar.qi(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.Kv(jSONObject.optString("originalGoodsId"));
        aVar.Kx(jSONObject.optString("originalPrice"));
        aVar.Kw(jSONObject.optString("originalTitle"));
        aVar.Kz(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.KD(jSONObject.optString("saleNum"));
        aVar.KB(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.KH(optJSONObject2.optString("Android"));
            bVar.KG(optJSONObject2.optString("IOS"));
            bVar.KI(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
