package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEy;

    public UserData DW() {
        return this.aEy;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEy = new UserData();
            this.aEy.parserProtobuf(dataRes.user);
        }
    }
}
