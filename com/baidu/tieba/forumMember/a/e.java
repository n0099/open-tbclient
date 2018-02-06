package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements i {
    public static final BdUniqueId dBl = BdUniqueId.gen();
    private String dBm;
    private int fansNum;
    private String intro;
    private String name;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBl;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String atR() {
        return this.dBm;
    }

    public void lx(String str) {
        this.dBm = str;
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
            lx(user.portrait);
            setName(user.name);
            setIntro(user.god_data.intro);
            setFansNum(user.fans_num.intValue());
        }
    }
}
