package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import tbclient.User;
/* loaded from: classes5.dex */
public class e implements m {
    public static final BdUniqueId fqB = BdUniqueId.gen();
    private int fansNum;
    private String fqC;
    private String intro;
    private String name;
    private String nameShow;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fqB;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String bkE() {
        return this.fqC;
    }

    public void wL(String str) {
        this.fqC = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public String getNameShow() {
        return StringUtils.isNull(this.nameShow) ? this.name : this.nameShow;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public int getFansNum() {
        return this.fansNum;
    }

    public void setFansNum(int i) {
        this.fansNum = i;
    }

    public void a(User user, int i) {
        if (user != null && user.god_data != null) {
            setUserId(user.id + "");
            wL(user.portrait);
            setName(user.name);
            setNameShow(user.name_show);
            setIntro(user.god_data.intro);
            setFansNum(user.fans_num.intValue());
        }
    }
}
