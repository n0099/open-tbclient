package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes7.dex */
public class h {
    public List<l> kmA;
    public long kmB;

    public void a(JoinUser joinUser) {
        this.kmB = joinUser.join_user_num.longValue();
        this.kmA = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.kmA.add(lVar);
            }
        }
    }
}
