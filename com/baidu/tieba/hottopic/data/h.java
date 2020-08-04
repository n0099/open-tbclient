package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes15.dex */
public class h {
    public List<l> iKy;
    public long iKz;

    public void a(JoinUser joinUser) {
        this.iKz = joinUser.join_user_num.longValue();
        this.iKy = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.iKy.add(lVar);
            }
        }
    }
}
