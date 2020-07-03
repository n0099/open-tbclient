package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes8.dex */
public class h {
    public List<l> iEs;
    public long iEt;

    public void a(JoinUser joinUser) {
        this.iEt = joinUser.join_user_num.longValue();
        this.iEs = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.iEs.add(lVar);
            }
        }
    }
}
