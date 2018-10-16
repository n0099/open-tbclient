package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aXh;

    public UserData LU() {
        return this.aXh;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aXh = new UserData();
            this.aXh.parserProtobuf(dataRes.user);
        }
    }
}
