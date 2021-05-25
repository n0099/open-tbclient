package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import d.a.m0.r.q.o;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes3.dex */
public class PrivSetsData extends o implements Serializable {
    public int bazhuShowInside;
    public int bazhuShowOutside;
    public int friend;
    public int group;
    public int like;
    public int live;
    public int location;
    public int post;
    public int reply;

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.location = jSONObject.optInt("location", 0);
            this.like = jSONObject.optInt("like", 0);
            this.group = jSONObject.optInt("group", 0);
            this.post = jSONObject.optInt("post", 0);
            this.friend = jSONObject.optInt("friend", 0);
            this.live = jSONObject.optInt("live", 0);
            this.reply = jSONObject.optInt("reply", 0);
            this.bazhuShowInside = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
            this.bazhuShowOutside = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets == null) {
            return;
        }
        this.location = privSets.location.intValue();
        this.like = privSets.like.intValue();
        this.group = privSets.group.intValue();
        this.post = privSets.post.intValue();
        this.friend = privSets.friend.intValue();
        this.live = privSets.live.intValue();
        this.reply = privSets.reply.intValue();
        this.bazhuShowInside = privSets.bazhu_show_inside.intValue();
        this.bazhuShowOutside = privSets.bazhu_show_outside.intValue();
    }
}
