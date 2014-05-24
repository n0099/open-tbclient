package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private int j;
    private ae m;
    private ArrayList<ae> n = new ArrayList<>();
    private ForumData a = new ForumData();
    private com.baidu.tbadk.core.data.n b = new com.baidu.tbadk.core.data.n();
    private ArrayList<ai> c = new ArrayList<>();
    private HashMap<String, MetaData> d = new HashMap<>();
    private com.baidu.tbadk.core.data.l e = new com.baidu.tbadk.core.data.l();
    private AntiData f = new AntiData();
    private aa g = new aa();
    private int i = 0;
    private boolean h = false;
    private final UserData k = new UserData();
    private AdditionData l = new AdditionData();

    public af() {
        this.j = 0;
        this.j = 0;
    }

    public boolean a() {
        return this.c != null && this.c.size() > 0;
    }

    public String[] b() {
        String str = null;
        String str2 = "";
        if (a()) {
            ai aiVar = this.c.get(0);
            LinkedList<String> imageUrl = aiVar.getImageUrl();
            if (imageUrl != null && imageUrl.size() > 0) {
                str = imageUrl.get(0);
            }
            str2 = aiVar.u();
        }
        return new String[]{str, str2};
    }

    public ForumData c() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.n d() {
        return this.b;
    }

    public ArrayList<ai> e() {
        return this.c;
    }

    public com.baidu.tbadk.core.data.l f() {
        return this.e;
    }

    public void a(com.baidu.tbadk.core.data.l lVar, int i) {
        this.e.c(lVar.d());
        this.e.b(lVar.b());
        this.e.a(lVar.a());
        this.e.d(lVar.e());
        if (i == 0) {
            this.e = lVar;
        } else if (i == 1) {
            this.e.e(lVar.f());
        } else if (i == 2) {
            this.e.f(lVar.g());
        }
    }

    public AntiData g() {
        return this.f;
    }

    public UserData h() {
        return this.k;
    }

    public boolean i() {
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

    public String j() {
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
            BdLog.e("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e("PbData", "parserJson", "error = " + e.getMessage());
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
                        ai aiVar = new ai();
                        aiVar.a(this.d);
                        aiVar.a(optJSONArray3.optJSONObject(i2), context);
                        this.c.add(aiVar);
                    }
                }
                this.e.a(jSONObject.optJSONObject("page"));
                this.f.parserJson(jSONObject.optJSONObject("anti"));
                this.g.a(jSONObject.optJSONObject("location"));
                this.h = jSONObject.optInt("has_floor") == 1;
                this.i = jSONObject.optJSONObject("user").optInt("is_manager", 0);
                this.k.parserJson(jSONObject.optJSONObject("user"));
                this.l.parserJson(jSONObject.optJSONObject("add_post"));
                this.b.b(this.b.s() > 0 ? this.b.s() - 1 : 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("banner_list");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("app")) != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        ae aeVar = new ae();
                        aeVar.a(optJSONArray.getJSONObject(i3));
                        if (!this.n.contains(aeVar)) {
                            this.n.add(aeVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean k() {
        return this.h;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public AdditionData n() {
        return this.l;
    }

    public ae o() {
        return this.m;
    }

    public void a(ae aeVar) {
        this.m = aeVar;
    }

    public ArrayList<ae> p() {
        return this.n;
    }
}
