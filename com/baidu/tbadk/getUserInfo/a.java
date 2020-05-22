package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData eom;

    public UserData bel() {
        return this.eom;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eom = new UserData();
            this.eom.parserProtobuf(dataRes.user);
        }
    }
}
