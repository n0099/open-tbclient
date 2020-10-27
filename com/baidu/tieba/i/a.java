package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bqE;
    private String bqN;
    private String bqO;
    private String eur;
    private boolean isSelected;
    private String jnA;
    private String jnB;
    private String jnC;
    private List<C0736a> jnD;
    private String jnw;
    private b jnx;
    private String jny;
    private String jnz;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void KT(String str) {
        this.jnw = str;
    }

    public String cFx() {
        return this.bqE;
    }

    public void KU(String str) {
        this.bqE = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void KV(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cFy() {
        return this.jnx;
    }

    public void a(b bVar) {
        this.jnx = bVar;
    }

    public void KW(String str) {
        this.jny = str;
    }

    public String cFz() {
        return this.jnz;
    }

    public void KX(String str) {
        this.jnz = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void KY(String str) {
        this.jnA = str;
    }

    public void KZ(String str) {
        this.jnB = str;
    }

    public void La(String str) {
        this.bqO = str;
    }

    public void Lb(String str) {
        this.bqN = str;
    }

    public void Lc(String str) {
        this.jnC = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cFA() {
        return this.eur;
    }

    public void Ld(String str) {
        this.eur = str;
    }

    public void qA(boolean z) {
        this.isSelected = z;
    }

    public List<C0736a> getImageList() {
        return this.jnD;
    }

    public void ds(List<C0736a> list) {
        this.jnD = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jnE;
        private String jnF;
        private String jnG;

        public void Le(String str) {
            this.jnE = str;
        }

        public String cFB() {
            return this.jnF;
        }

        public void Lf(String str) {
            this.jnF = str;
        }

        public String cFC() {
            return this.jnG;
        }

        public void Lg(String str) {
            this.jnG = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0736a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a eb(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.KW(jSONObject.optString("commission"));
        aVar.La(jSONObject.optString("coupon"));
        aVar.Ld(jSONObject.optString("goodsId"));
        aVar.KY(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0736a c0736a = new C0736a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0736a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0736a);
                }
            }
            aVar.ds(arrayList);
        }
        aVar.Lc(jSONObject.optString("isBindingVideo"));
        aVar.qA(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.KT(jSONObject.optString("originalGoodsId"));
        aVar.KV(jSONObject.optString("originalPrice"));
        aVar.KU(jSONObject.optString("originalTitle"));
        aVar.KX(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Lb(jSONObject.optString("saleNum"));
        aVar.KZ(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Lf(optJSONObject2.optString("Android"));
            bVar.Le(optJSONObject2.optString("IOS"));
            bVar.Lg(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
