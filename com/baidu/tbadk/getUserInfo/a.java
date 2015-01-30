package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData ZK;

    public UserData vR() {
        return this.ZK;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ZK = new UserData();
            this.ZK.parserProtobuf(dataRes.user);
        }
    }
}
