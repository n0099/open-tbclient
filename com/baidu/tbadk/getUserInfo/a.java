package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData awT;

    public UserData EF() {
        return this.awT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.awT = new UserData();
            this.awT.parserProtobuf(dataRes.user);
        }
    }
}
