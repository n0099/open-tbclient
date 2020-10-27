package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes21.dex */
public class h {
    public List<l> jJF;
    public long jJG;

    public void a(JoinUser joinUser) {
        this.jJG = joinUser.join_user_num.longValue();
        this.jJF = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.jJF.add(lVar);
            }
        }
    }
}
