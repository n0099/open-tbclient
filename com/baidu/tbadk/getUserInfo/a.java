package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData ctW;

    public UserData asg() {
        return this.ctW;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ctW = new UserData();
            this.ctW.parserProtobuf(dataRes.user);
        }
    }
}
