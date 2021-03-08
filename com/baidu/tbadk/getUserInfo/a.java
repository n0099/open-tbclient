package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fGU;

    public UserData bCK() {
        return this.fGU;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fGU = new UserData();
            this.fGU.parserProtobuf(dataRes.user);
        }
    }
}
