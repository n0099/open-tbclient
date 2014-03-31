package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageForumListResponsedMessage extends JsonHttpResponsedMessage {
    public ForumData a;
    public ArrayList<com.baidu.tieba.data.ar> b;
    public ArrayList<String> c;
    public int d;
    public int e;
    public int f;
    public AntiData g;
    public com.baidu.tieba.data.ac h;
    public JSONObject i;

    public ImageForumListResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        int d = d();
        int e = e();
        if (d == 200 && e == 0 && jSONObject != null && jSONObject != null) {
            try {
                this.a = new ForumData();
                this.b = new ArrayList<>();
                this.c = new ArrayList<>();
                this.d = 0;
                this.e = 0;
                this.f = 0;
                this.g = new AntiData();
                this.h = new com.baidu.tieba.data.ac();
                this.a.parserJson(jSONObject.optJSONObject("forum"));
                this.h.a(jSONObject.optJSONObject("user"));
                this.g.parserJson(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.data.ar arVar = new com.baidu.tieba.data.ar();
                            arVar.a(optJSONArray.optJSONObject(i));
                            this.b.add(arVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.c.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.d = optJSONObject.optInt("has_more", 0);
                    this.e = optJSONObject.optInt("amount", 0);
                    this.f = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e2) {
            }
        }
        this.i = jSONObject;
    }
}
