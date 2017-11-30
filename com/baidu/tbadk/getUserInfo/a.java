package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFh;

    public UserData Eq() {
        return this.aFh;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFh = new UserData();
            this.aFh.parserProtobuf(dataRes.user);
        }
    }
}
