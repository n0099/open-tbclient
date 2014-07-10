package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bf;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private int j;
    private ah m;
    private ArrayList<ah> n = new ArrayList<>();
    private ForumData a = new ForumData();
    private com.baidu.tbadk.core.data.m b = new com.baidu.tbadk.core.data.m();
    private ArrayList<am> c = new ArrayList<>();
    private HashMap<String, MetaData> d = new HashMap<>();
    private com.baidu.tbadk.core.data.k e = new com.baidu.tbadk.core.data.k();
    private AntiData f = new AntiData();
    private ac g = new ac();
    private int i = 0;
    private boolean h = false;
    private final UserData k = new UserData();
    private AdditionData l = new AdditionData();

    public ai() {
        this.j = 0;
        this.j = 0;
    }

    public boolean a() {
        return this.c != null && this.c.size() > 0;
    }

    public String[] a(Context context) {
        String str = "";
        BdLog.e("获取PB页第一条数据是否有效:" + a());
        if (a()) {
            am amVar = this.c.get(0);
            bf w = amVar.w();
            r1 = w != null ? w.a : null;
            str = amVar.d(context);
            if (this.b != null && this.b.M() != null && this.b.M().getGroup_id() != 0) {
                str = "[" + context.getString(com.baidu.tieba.y.msglist_live) + "] " + str;
            }
        }
        BdLog.e("帖子信息的Content：" + str);
        if (r1 != null) {
            BdLog.e("第一张图片的URL：" + r1);
        }
        return new String[]{r1, str};
    }

    public ForumData b() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.m c() {
        return this.b;
    }

    public ArrayList<am> d() {
        return this.c;
    }

    public com.baidu.tbadk.core.data.k e() {
        return this.e;
    }

    public void a(com.baidu.tbadk.core.data.k kVar, int i) {
        this.e.c(kVar.c());
        this.e.b(kVar.b());
        this.e.a(kVar.a());
        this.e.d(kVar.d());
        if (i == 0) {
            this.e = kVar;
        } else if (i == 1) {
            this.e.e(kVar.e());
        } else if (i == 2) {
            this.e.f(kVar.f());
        }
    }

    public AntiData f() {
        return this.f;
    }

    public UserData g() {
        return this.k;
    }

    public boolean h() {
        return this.b.D() != 0;
    }

    public void a(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.e(1);
            } else {
                this.b.e(0);
            }
        }
    }

    public String i() {
        if (this.b != null) {
            return this.b.E();
        }
        return null;
    }

    public void a(String str) {
        if (this.b != null) {
            this.b.d(str);
        }
    }

    public void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("user_list");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserJson(optJSONArray2.optJSONObject(i));
                        if (metaData.getUserId() != null && metaData != null) {
                            this.d.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                a(jSONObject.optInt("is_new_url", 0));
                this.a.parserJson(jSONObject.optJSONObject("forum"));
                this.b.a(this.d);
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray3 = jSONObject.optJSONArray("post_list");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        am amVar = new am();
                        amVar.a(this.d);
                        amVar.a(optJSONArray3.optJSONObject(i2), context);
                        this.c.add(amVar);
                    }
                }
                this.e.a(jSONObject.optJSONObject("page"));
                this.f.parserJson(jSONObject.optJSONObject("anti"));
                this.g.a(jSONObject.optJSONObject("location"));
                this.h = jSONObject.optInt("has_floor") == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.i = optJSONObject.optInt("is_manager", 0);
                }
                this.k.parserJson(optJSONObject);
                this.l.parserJson(jSONObject.optJSONObject("add_post"));
                this.b.b(this.b.s() > 0 ? this.b.s() - 1 : 0);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("banner_list");
                if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("app")) != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        ah ahVar = new ah();
                        ahVar.a(optJSONArray.getJSONObject(i3));
                        if (!this.n.contains(ahVar)) {
                            this.n.add(ahVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public boolean j() {
        return this.h;
    }

    public int k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public AdditionData m() {
        return this.l;
    }

    public ah n() {
        return this.m;
    }

    public void a(ah ahVar) {
        this.m = ahVar;
    }

    public ArrayList<ah> o() {
        return this.n;
    }
}
