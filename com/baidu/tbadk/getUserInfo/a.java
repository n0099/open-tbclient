package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aXV;

    public UserData Mg() {
        return this.aXV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aXV = new UserData();
            this.aXV.parserProtobuf(dataRes.user);
        }
    }
}
