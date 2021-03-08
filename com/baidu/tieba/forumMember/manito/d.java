package com.baidu.tieba.forumMember.manito;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import tbclient.User;
/* loaded from: classes7.dex */
public class d implements n {
    public static final BdUniqueId jdY = BdUniqueId.gen();
    private int fansNum;
    private String headUrl;
    private String intro;
    private String name;
    private String nameShow;
    private String userId;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdY;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public void setHeadUrl(String str) {
        this.headUrl = str;
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
            setHeadUrl(user.portrait);
            setName(user.name);
            setNameShow(user.name_show);
            setIntro(user.god_data.intro);
            setFansNum(user.fans_num.intValue());
        }
    }
}
