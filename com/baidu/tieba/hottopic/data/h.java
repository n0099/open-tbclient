package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes20.dex */
public class h {
    public List<l> jQn;
    public long jQo;

    public void a(JoinUser joinUser) {
        this.jQo = joinUser.join_user_num.longValue();
        this.jQn = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.jQn.add(lVar);
            }
        }
    }
}
