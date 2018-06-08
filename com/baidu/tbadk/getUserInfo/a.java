package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aOw;

    public UserData It() {
        return this.aOw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aOw = new UserData();
            this.aOw.parserProtobuf(dataRes.user);
        }
    }
}
