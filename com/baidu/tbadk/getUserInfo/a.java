package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData clN;

    public UserData and() {
        return this.clN;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.clN = new UserData();
            this.clN.parserProtobuf(dataRes.user);
        }
    }
}
