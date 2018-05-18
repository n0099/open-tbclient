package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aGa;

    public UserData EP() {
        return this.aGa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aGa = new UserData();
            this.aGa.parserProtobuf(dataRes.user);
        }
    }
}
