package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData dvy;

    public UserData aMR() {
        return this.dvy;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dvy = new UserData();
            this.dvy.parserProtobuf(dataRes.user);
        }
    }
}
