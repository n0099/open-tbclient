package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bvC;

    public UserData Mo() {
        return this.bvC;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bvC = new UserData();
            this.bvC.parserProtobuf(dataRes.user);
        }
    }
}
