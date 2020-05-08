package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData eaa;

    public UserData aYc() {
        return this.eaa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eaa = new UserData();
            this.eaa.parserProtobuf(dataRes.user);
        }
    }
}
