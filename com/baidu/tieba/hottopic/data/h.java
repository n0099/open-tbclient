package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes20.dex */
public class h {
    public List<l> jii;
    public long jij;

    public void a(JoinUser joinUser) {
        this.jij = joinUser.join_user_num.longValue();
        this.jii = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.jii.add(lVar);
            }
        }
    }
}
