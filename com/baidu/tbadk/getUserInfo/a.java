package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData atb;

    public UserData BU() {
        return this.atb;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.atb = new UserData();
            this.atb.parserProtobuf(dataRes.user);
        }
    }
}
