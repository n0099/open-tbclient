package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData dzN;

    public UserData aPI() {
        return this.dzN;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dzN = new UserData();
            this.dzN.parserProtobuf(dataRes.user);
        }
    }
}
