package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aDN;

    public UserData DH() {
        return this.aDN;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aDN = new UserData();
            this.aDN.parserProtobuf(dataRes.user);
        }
    }
}
