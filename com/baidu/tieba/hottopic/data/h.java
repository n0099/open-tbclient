package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes21.dex */
public class h {
    public List<l> jxg;
    public long jxh;

    public void a(JoinUser joinUser) {
        this.jxh = joinUser.join_user_num.longValue();
        this.jxg = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.jxg.add(lVar);
            }
        }
    }
}
