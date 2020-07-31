package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes15.dex */
public class h {
    public List<l> iKw;
    public long iKx;

    public void a(JoinUser joinUser) {
        this.iKx = joinUser.join_user_num.longValue();
        this.iKw = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.iKw.add(lVar);
            }
        }
    }
}
