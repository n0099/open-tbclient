package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bch;

    public UserData NC() {
        return this.bch;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bch = new UserData();
            this.bch.parserProtobuf(dataRes.user);
        }
    }
}
