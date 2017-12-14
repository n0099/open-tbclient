package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFm;

    public UserData Er() {
        return this.aFm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFm = new UserData();
            this.aFm.parserProtobuf(dataRes.user);
        }
    }
}
