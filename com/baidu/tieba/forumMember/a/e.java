package com.baidu.tieba.forumMember.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements h {
    public static final BdUniqueId dwE = BdUniqueId.gen();
    private String dwF;
    private int fansNum;
    private String intro;
    private String name;
    private String nameShow;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dwE;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String ayj() {
        return this.dwF;
    }

    public void np(String str) {
        this.dwF = str;
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
            np(user.portrait);
            setName(user.name);
            setNameShow(user.name_show);
            setIntro(user.god_data.intro);
            setFansNum(user.fans_num.intValue());
        }
    }
}
