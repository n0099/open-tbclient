package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData axx;

    public UserData DO() {
        return this.axx;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.axx = new UserData();
            this.axx.parserProtobuf(dataRes.user);
        }
    }
}
