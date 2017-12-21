package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFp;

    public UserData Er() {
        return this.aFp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFp = new UserData();
            this.aFp.parserProtobuf(dataRes.user);
        }
    }
}
