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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.PbPage.DataRes;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class aj {
    private int j;
    private boolean l = true;
    private ArrayList<com.baidu.tieba.d.a.f> n = new ArrayList<>();
    private ForumData a = new ForumData();
    private com.baidu.tbadk.core.data.n b = new com.baidu.tbadk.core.data.n();
    private ArrayList<an> c = new ArrayList<>();
    private HashMap<String, MetaData> d = new HashMap<>();
    private com.baidu.tbadk.core.data.l e = new com.baidu.tbadk.core.data.l();
    private AntiData f = new AntiData();
    private ac g = new ac();
    private int i = 0;
    private boolean h = false;
    private final UserData k = new UserData();
    private AdditionData m = new AdditionData();

    public boolean a() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public aj() {
        this.j = 0;
        this.j = 0;
    }

    public boolean b() {
        return this.c != null && this.c.size() > 0;
    }

    public String[] a(Context context) {
        String str = "";
        if (b()) {
            an anVar = this.c.get(0);
            com.baidu.tbadk.core.util.au o = anVar.o();
            r1 = o != null ? o.a : null;
            str = anVar.d(context);
            if (this.b != null && this.b.E() != null && this.b.E().getGroup_id() != 0) {
                str = "[" + context.getString(com.baidu.tieba.x.msglist_live) + "] " + str;
            }
        }
        return new String[]{r1, str};
    }

    public ForumData c() {
        return this.a;
    }

    public com.baidu.tbadk.core.data.n d() {
        return this.b;
    }

    public ArrayList<an> e() {
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
        return this.b.v() != 0;
    }

    public void b(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.d(1);
            } else {
                this.b.d(0);
            }
        }
    }

    public String j() {
        if (this.b != null) {
            return this.b.w();
        }
        return null;
    }

    public void a(String str) {
        if (this.b != null) {
            this.b.d(str);
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
                        an anVar = new an();
                        anVar.a(this.d);
                        anVar.a(optJSONArray3.optJSONObject(i2), context);
                        this.c.add(anVar);
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
                this.m.parserJson(jSONObject.optJSONObject("add_post"));
                this.b.a(this.b.k() > 0 ? this.b.k() - 1 : 0);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("banner_list");
                if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("app")) != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.a(optJSONArray.getJSONObject(i3));
                        if (!this.n.contains(fVar)) {
                            this.n.add(fVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(DataRes dataRes, Context context) {
        if (dataRes != null) {
            try {
                List<User> list = dataRes.user_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.d.put(metaData.getUserId(), metaData);
                        }
                    }
                }
                a(dataRes.is_new_url.intValue());
                this.a.parserProtobuf(dataRes.forum);
                this.b.a(this.d);
                this.b.a(dataRes.thread);
                List<Post> list2 = dataRes.post_list;
                if (list2 != null && list2.size() > 0) {
                    for (Post post : dataRes.post_list) {
                        an anVar = new an();
                        anVar.a(this.d);
                        anVar.a(post, context);
                        this.c.add(anVar);
                    }
                }
                this.e.a(dataRes.page);
                this.f.parserProtobuf(dataRes.anti);
                this.g.a(dataRes.location);
                this.h = dataRes.has_floor.intValue() == 1;
                if (dataRes.user != null) {
                    this.i = dataRes.user.is_manager.intValue();
                }
                this.k.parserProtobuf(dataRes.user);
                this.m.parserProtoBuf(dataRes.add_post);
                this.b.a(this.b.k() > 0 ? this.b.k() - 1 : 0);
                if (dataRes.banner_list != null) {
                    for (App app : dataRes.banner_list.app) {
                        com.baidu.tieba.d.a.f fVar = new com.baidu.tieba.d.a.f();
                        fVar.a(app);
                        if (!this.n.contains(fVar)) {
                            this.n.add(fVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
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
        return this.m;
    }

    public ArrayList<com.baidu.tieba.d.a.f> o() {
        return this.n;
    }
}
