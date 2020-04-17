package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData dZV;

    public UserData aYe() {
        return this.dZV;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dZV = new UserData();
            this.dZV.parserProtobuf(dataRes.user);
        }
    }
}
