package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFt;

    public UserData Em() {
        return this.aFt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFt = new UserData();
            this.aFt.parserProtobuf(dataRes.user);
        }
    }
}
