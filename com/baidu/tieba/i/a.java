package com.baidu.tieba.i;

import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String brX;
    private String bsg;
    private String bsh;
    private String eAk;
    private boolean isSelected;
    private List<C0750a> jtA;
    private String jtt;
    private b jtu;
    private String jtv;
    private String jtw;
    private String jtx;
    private String jty;
    private String jtz;
    private String nid;
    private String originalPrice;
    private String price;
    private String title;
    private String userName;

    public void Lk(String str) {
        this.jtt = str;
    }

    public String cHY() {
        return this.brX;
    }

    public void Ll(String str) {
        this.brX = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void Lm(String str) {
        this.originalPrice = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public b cHZ() {
        return this.jtu;
    }

    public void a(b bVar) {
        this.jtu = bVar;
    }

    public void Ln(String str) {
        this.jtv = str;
    }

    public String cIa() {
        return this.jtw;
    }

    public void Lo(String str) {
        this.jtw = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void Lp(String str) {
        this.jtx = str;
    }

    public void Lq(String str) {
        this.jty = str;
    }

    public void Lr(String str) {
        this.bsh = str;
    }

    public void Ls(String str) {
        this.bsg = str;
    }

    public void Lt(String str) {
        this.jtz = str;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public String cIb() {
        return this.eAk;
    }

    public void Lu(String str) {
        this.eAk = str;
    }

    public void qJ(boolean z) {
        this.isSelected = z;
    }

    public List<C0750a> getImageList() {
        return this.jtA;
    }

    public void dA(List<C0750a> list) {
        this.jtA = list;
    }

    /* loaded from: classes.dex */
    public static class b {
        private String jtB;
        private String jtC;
        private String jtD;

        public void Lv(String str) {
            this.jtB = str;
        }

        public String cIc() {
            return this.jtC;
        }

        public void Lw(String str) {
            this.jtC = str;
        }

        public String cId() {
            return this.jtD;
        }

        public void Lx(String str) {
            this.jtD = str;
        }
    }

    /* renamed from: com.baidu.tieba.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0750a {
        private String src;

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    public static a eh(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.Ln(jSONObject.optString("commission"));
        aVar.Lr(jSONObject.optString("coupon"));
        aVar.Lu(jSONObject.optString("goodsId"));
        aVar.Lp(jSONObject.optString("goodsStatus"));
        JSONArray optJSONArray = jSONObject.optJSONArray("imageList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0750a c0750a = new C0750a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    c0750a.setSrc(optJSONObject.optString("src"));
                    arrayList.add(c0750a);
                }
            }
            aVar.dA(arrayList);
        }
        aVar.Lt(jSONObject.optString("isBindingVideo"));
        aVar.qJ(jSONObject.optBoolean("isSelected"));
        aVar.setNid(jSONObject.optString("nid"));
        aVar.Lk(jSONObject.optString("originalGoodsId"));
        aVar.Lm(jSONObject.optString("originalPrice"));
        aVar.Ll(jSONObject.optString("originalTitle"));
        aVar.Lo(jSONObject.optString("tpName"));
        aVar.setPrice(jSONObject.optString("price"));
        aVar.Ls(jSONObject.optString("saleNum"));
        aVar.Lq(jSONObject.optString("shareStatus"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("slink");
        if (optJSONObject2 != null) {
            b bVar = new b();
            bVar.Lw(optJSONObject2.optString("Android"));
            bVar.Lv(optJSONObject2.optString("IOS"));
            bVar.Lx(optJSONObject2.optString("h5"));
            aVar.a(bVar);
        }
        aVar.setTitle(jSONObject.optString("title"));
        aVar.setUserName(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
        return aVar;
    }
}
