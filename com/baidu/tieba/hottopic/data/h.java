package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes15.dex */
public class h {
    public List<l> iZC;
    public long iZD;

    public void a(JoinUser joinUser) {
        this.iZD = joinUser.join_user_num.longValue();
        this.iZC = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.iZC.add(lVar);
            }
        }
    }
}
