package com.baidu.tieba.hottopic.data;

import tbclient.Hottopic.UserInfo;
/* loaded from: classes7.dex */
public class l {
    public String portrait;
    public long userId;
    public String userName;

    public void a(UserInfo userInfo) {
        this.userId = userInfo.user_id.longValue();
        this.userName = userInfo.user_name;
        this.portrait = userInfo.portrait;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.userId == ((l) obj).userId;
    }

    public int hashCode() {
        return (int) (this.userId ^ (this.userId >>> 32));
    }
}
