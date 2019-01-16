package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.Userlike.UserList;
/* loaded from: classes6.dex */
public class c implements com.baidu.tbadk.core.view.userLike.a {
    private int is_like;
    private int likeStatus = 1;
    private String name = null;
    private String prefix = null;
    private String intro = null;
    private int fans_num = 0;
    private int post_num = 0;
    private String recom_reason = null;
    private String portrait = null;
    private long id = 0;
    private int is_god = 0;

    public c() {
        this.is_like = 0;
        this.is_like = 0;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean getIsLike() {
        return this.is_like == 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setIsLike(boolean z) {
        this.is_like = z ? 1 : 0;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setFansNum(int i) {
        this.fans_num = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public int getFansNum() {
        return this.fans_num;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public String getUserId() {
        return String.valueOf(this.id);
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setIsFromNetWork(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean isGod() {
        return this.is_god == 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public String getPortrait() {
        return this.portrait;
    }

    public String aLx() {
        return this.recom_reason;
    }

    public long getId() {
        return this.id;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setLikeStatus(int i) {
        this.likeStatus = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public int getLikeStatus() {
        return this.likeStatus;
    }

    public void b(UserList userList) {
        if (userList != null && !StringUtils.isNull(userList.name) && !StringUtils.isNull(userList.id.toString())) {
            this.name = userList.name;
            this.prefix = userList.prefix;
            this.intro = userList.intro;
            this.fans_num = userList.fans_num.intValue();
            this.post_num = userList.post_num.intValue();
            this.recom_reason = userList.recom_reason;
            this.portrait = userList.portrait;
            this.id = userList.id.longValue();
            this.is_god = userList.is_god.intValue();
        }
    }
}
