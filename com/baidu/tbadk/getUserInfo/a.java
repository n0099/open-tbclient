package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEa;

    public UserData DN() {
        return this.aEa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEa = new UserData();
            this.aEa.parserProtobuf(dataRes.user);
        }
    }
}
