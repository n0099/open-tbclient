package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData ctX;

    public UserData asg() {
        return this.ctX;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ctX = new UserData();
            this.ctX.parserProtobuf(dataRes.user);
        }
    }
}
