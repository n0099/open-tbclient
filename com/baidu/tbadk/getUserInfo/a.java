package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData awB;

    public UserData DJ() {
        return this.awB;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.awB = new UserData();
            this.awB.parserProtobuf(dataRes.user);
        }
    }
}
