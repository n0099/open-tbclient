package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes3.dex */
public class PersonPrivateData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public int f13486e = 1;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("location", 1);
        this.f13486e = jSONObject.optInt("like", 1);
        jSONObject.optInt("group", 1);
        jSONObject.optInt("post", 1);
        jSONObject.optInt("friend", 1);
        jSONObject.optInt("live", 1);
    }

    public int s() {
        return this.f13486e;
    }

    public void t(PrivSets privSets) {
        if (privSets == null) {
            return;
        }
        try {
            privSets.location.intValue();
            this.f13486e = privSets.like.intValue();
            privSets.group.intValue();
            privSets.post.intValue();
            privSets.friend.intValue();
            privSets.live.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
