package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aPs;

    public UserData IL() {
        return this.aPs;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aPs = new UserData();
            this.aPs.parserProtobuf(dataRes.user);
        }
    }
}
