package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aBV;

    public UserData Ec() {
        return this.aBV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aBV = new UserData();
            this.aBV.parserProtobuf(dataRes.user);
        }
    }
}
