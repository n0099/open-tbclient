package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements h {
    public static final BdUniqueId cUS = BdUniqueId.gen();
    private String cUT;
    private int fansNum;
    private String intro;
    private String name;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUS;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String aof() {
        return this.cUT;
    }

    public void lD(String str) {
        this.cUT = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
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
            lD(user.portrait);
            setName(user.name);
            setIntro(user.god_data.intro);
            setFansNum(user.fans_num.intValue());
        }
    }
}
