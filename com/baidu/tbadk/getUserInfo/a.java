package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData exa;

    public UserData bgr() {
        return this.exa;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.exa = new UserData();
            this.exa.parserProtobuf(dataRes.user);
        }
    }
}
