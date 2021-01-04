package com.baidu.tieba.frs.forumRule.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes2.dex */
public class a implements n {
    public static BdUniqueId jui = BdUniqueId.gen();
    private String avatar;
    private String forum_name;
    private String name_show;
    private String portrait;
    private String publish_time;

    public void a(DataRes dataRes) {
        this.publish_time = dataRes.publish_time;
        if (dataRes.bazhu != null) {
            this.portrait = dataRes.bazhu.portrait;
            this.name_show = dataRes.bazhu.name_show;
        }
        if (dataRes.forum != null) {
            this.avatar = dataRes.forum.avatar;
            this.forum_name = dataRes.forum.forum_name;
        }
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String cJB() {
        return this.publish_time;
    }

    public String bru() {
        return this.forum_name;
    }

    public void Bd(String str) {
        this.forum_name = str;
    }

    public String getName_show() {
        return this.name_show;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jui;
    }
}
