package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String bij;
    private String bit;
    private String biu;
    private String dXF;
    private String iEO;
    private b iEP;
    private String iEQ;
    private String iER;
    private String iES;
    private String iET;
    private String iEU;
    private List<C0705a> iEV;
    private boolean isSelected;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Jk(String str) {
        this.iEO = str;
    }

    public String cvA() {
        return this.bij;
    }

    public void Jl(String str) {
        this.bij = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void Jm(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cvB() {
        return this.iEP;
    }

    public void a(b bVar) {
        this.iEP = bVar;
    }

    public void Jn(String str) {
        this.iEQ = str;
    }

    public String adA() {
        return this.iER;
    }

    public void Jo(String str) {
        this.iER = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void Jp(String str) {
        this.iES = str;
    }

    public void Jq(String str) {
        this.iET = str;
    }

    public void Jr(String str) {
        this.biu = str;
    }

    public void Js(String str) {
        this.bit = str;
    }

    public void Jt(String str) {
        this.iEU = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cvC() {
        return this.dXF;
    }

    public void Ju(String str) {
        this.dXF = str;
    }

    public void px(boolean z) {
        this.isSelected = z;
    }

    public List<C0705a> getImageList() {
        return this.iEV;
    }

    public void da(List<C0705a> list) {
        this.iEV = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String iEW;
        private String iEX;
        private String iEY;

        public void Jv(String str) {
            this.iEW = str;
        }

        public String cvD() {
            return this.iEX;
        }

        public void Jw(String str) {
            this.iEX = str;
        }

        public String cvE() {
            return this.iEY;
        }

        public void Jx(String str) {
            this.iEY = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
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
        aVar.Jn(jSONObject.optString("commission"));
        aVar.Jr(jSONObject.optString("coupon"));
        aVar.Ju(jSONObject.optString("goodsId"));
        aVar.Jp(jSONObject.optString("goodsStatus"));
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
        aVar.Jt(jSONObject.optString("isBindingVideo"));
        aVar.px(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.Jk(jSONObject.optString("originalGoodsId"));
        aVar.Jm(jSONObject.optString("originalPrice"));
        aVar.Jl(jSONObject.optString("originalTitle"));
        aVar.Jo(jSONObject.optString("platformName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Js(jSONObject.optString("saleNum"));
        aVar.Jq(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Jw(optJSONObject2.optString("Android"));
            bVar.Jv(optJSONObject2.optString("IOS"));
            bVar.Jx(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
