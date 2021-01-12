package com.baidu.tbadk.coreExtra.data;

import android.net.http.Headers;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PrivSetsData extends com.baidu.tbadk.core.data.n implements Serializable {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int friend;
    private int group;
    private int like;
    private int live;
    private int location;
    private int post;
    private int reply;

    @Override // com.baidu.tbadk.core.data.n
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.location = jSONObject.optInt(Headers.LOCATION, 0);
                this.like = jSONObject.optInt("like", 0);
                this.group = jSONObject.optInt(TbEnum.ParamKey.GROUP, 0);
                this.post = jSONObject.optInt("post", 0);
                this.friend = jSONObject.optInt("friend", 0);
                this.live = jSONObject.optInt("live", 0);
                this.reply = jSONObject.optInt("reply", 0);
                this.bazhuShowInside = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, 0);
                this.bazhuShowOutside = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
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

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }
}
