package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFr;

    public UserData Em() {
        return this.aFr;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFr = new UserData();
            this.aFr.parserProtobuf(dataRes.user);
        }
    }
}
