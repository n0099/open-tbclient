package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String bif;
    private String biq;
    private String bir;
    private String dXB;
    private String iEI;
    private b iEJ;
    private String iEK;
    private String iEL;
    private String iEM;
    private String iEN;
    private String iEO;
    private List<C0705a> iEP;
    private boolean isSelected;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Jj(String str) {
        this.iEI = str;
    }

    public String cvz() {
        return this.bif;
    }

    public void Jk(String str) {
        this.bif = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void Jl(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cvA() {
        return this.iEJ;
    }

    public void a(b bVar) {
        this.iEJ = bVar;
    }

    public void Jm(String str) {
        this.iEK = str;
    }

    public String adA() {
        return this.iEL;
    }

    public void Jn(String str) {
        this.iEL = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void Jo(String str) {
        this.iEM = str;
    }

    public void Jp(String str) {
        this.iEN = str;
    }

    public void Jq(String str) {
        this.bir = str;
    }

    public void Jr(String str) {
        this.biq = str;
    }

    public void Js(String str) {
        this.iEO = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cvB() {
        return this.dXB;
    }

    public void Jt(String str) {
        this.dXB = str;
    }

    public void pv(boolean z) {
        this.isSelected = z;
    }

    public List<C0705a> getImageList() {
        return this.iEP;
    }

    public void da(List<C0705a> list) {
        this.iEP = list;
    }

    /* loaded from: classes2.dex */
    public static class b {
        private String iEQ;
        private String iER;
        private String iES;

        public void Ju(String str) {
            this.iEQ = str;
        }

        public String cvC() {
            return this.iER;
        }

        public void Jv(String str) {
            this.iER = str;
        }

        public String cvD() {
            return this.iES;
        }

        public void Jw(String str) {
            this.iES = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0705a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a dJ(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.Jm(jSONObject.optString("commission"));
        aVar.Jq(jSONObject.optString("coupon"));
        aVar.Jt(jSONObject.optString("goodsId"));
        aVar.Jo(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0705a c0705a = new C0705a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0705a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0705a);
                }
            }
            aVar.da(arrayList);
        }
        aVar.Js(jSONObject.optString("isBindingVideo"));
        aVar.pv(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.Jj(jSONObject.optString("originalGoodsId"));
        aVar.Jl(jSONObject.optString("originalPrice"));
        aVar.Jk(jSONObject.optString("originalTitle"));
        aVar.Jn(jSONObject.optString("platformName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Jr(jSONObject.optString("saleNum"));
        aVar.Jp(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Jv(optJSONObject2.optString("Android"));
            bVar.Ju(optJSONObject2.optString("IOS"));
            bVar.Jw(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
