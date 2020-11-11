package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes21.dex */
public class h {
    public List<l> jPD;
    public long jPE;

    public void a(JoinUser joinUser) {
        this.jPE = joinUser.join_user_num.longValue();
        this.jPD = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.jPD.add(lVar);
            }
        }
    }
}
