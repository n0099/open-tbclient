package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData arP;

    public UserData BN() {
        return this.arP;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.arP = new UserData();
            this.arP.parserProtobuf(dataRes.user);
        }
    }
}
