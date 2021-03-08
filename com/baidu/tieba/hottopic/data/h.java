package com.baidu.tieba.hottopic.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes7.dex */
public class h {
    public List<l> kwX;
    public long kwY;

    public void a(JoinUser joinUser) {
        this.kwY = joinUser.join_user_num.longValue();
        this.kwX = new ArrayList();
        for (UserInfo userInfo : joinUser.join_user) {
            if (userInfo != null) {
                l lVar = new l();
                lVar.a(userInfo);
                this.kwX.add(lVar);
            }
        }
    }
}
