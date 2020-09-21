package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String ble;
    private String bln;
    private String blo;
    private String dZP;
    private String iMj;
    private b iMk;
    private String iMl;
    private String iMm;
    private String iMn;
    private String iMo;
    private String iMp;
    private List<C0702a> iMq;
    private boolean isSelected;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void JI(String str) {
        this.iMj = str;
    }

    public String cyT() {
        return this.ble;
    }

    public void JJ(String str) {
        this.ble = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void JK(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cyU() {
        return this.iMk;
    }

    public void a(b bVar) {
        this.iMk = bVar;
    }

    public void JL(String str) {
        this.iMl = str;
    }

    public String aek() {
        return this.iMm;
    }

    public void JM(String str) {
        this.iMm = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void JN(String str) {
        this.iMn = str;
    }

    public void JO(String str) {
        this.iMo = str;
    }

    public void JP(String str) {
        this.blo = str;
    }

    public void JQ(String str) {
        this.bln = str;
    }

    public void JR(String str) {
        this.iMp = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cyV() {
        return this.dZP;
    }

    public void JS(String str) {
        this.dZP = str;
    }

    public void pD(boolean z) {
        this.isSelected = z;
    }

    public List<C0702a> getImageList() {
        return this.iMq;
    }

    public void dg(List<C0702a> list) {
        this.iMq = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String iMr;
        private String iMs;
        private String iMt;

        public void JT(String str) {
            this.iMr = str;
        }

        public String cyW() {
            return this.iMs;
        }

        public void JU(String str) {
            this.iMs = str;
        }

        public String cyX() {
            return this.iMt;
        }

        public void JV(String str) {
            this.iMt = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0702a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a dR(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.JL(jSONObject.optString("commission"));
        aVar.JP(jSONObject.optString("coupon"));
        aVar.JS(jSONObject.optString("goodsId"));
        aVar.JN(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0702a c0702a = new C0702a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0702a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0702a);
                }
            }
            aVar.dg(arrayList);
        }
        aVar.JR(jSONObject.optString("isBindingVideo"));
        aVar.pD(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.JI(jSONObject.optString("originalGoodsId"));
        aVar.JK(jSONObject.optString("originalPrice"));
        aVar.JJ(jSONObject.optString("originalTitle"));
        aVar.JM(jSONObject.optString("platformName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.JQ(jSONObject.optString("saleNum"));
        aVar.JO(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.JU(optJSONObject2.optString("Android"));
            bVar.JT(optJSONObject2.optString("IOS"));
            bVar.JV(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
