package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData clL;

    public UserData anh() {
        return this.clL;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.clL = new UserData();
            this.clL.parserProtobuf(dataRes.user);
        }
    }
}
