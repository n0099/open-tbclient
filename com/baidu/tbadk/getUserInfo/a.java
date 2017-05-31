package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aBZ;

    public UserData Dy() {
        return this.aBZ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aBZ = new UserData();
            this.aBZ.parserProtobuf(dataRes.user);
        }
    }
}
