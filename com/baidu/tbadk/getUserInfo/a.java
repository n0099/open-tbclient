package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEb;

    public UserData Ee() {
        return this.aEb;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEb = new UserData();
            this.aEb.parserProtobuf(dataRes.user);
        }
    }
}
