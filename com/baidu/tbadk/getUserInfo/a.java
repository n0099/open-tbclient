package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData dAa;

    public UserData aPJ() {
        return this.dAa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dAa = new UserData();
            this.dAa.parserProtobuf(dataRes.user);
        }
    }
}
