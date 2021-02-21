package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes8.dex */
public class h {
    public List<l> kuV;
    public long kuW;

    public void a(JoinUser joinUser) {
        this.kuW = joinUser.join_user_num.longValue();
        this.kuV = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.kuV.add(lVar);
            }
        }
    }
}
