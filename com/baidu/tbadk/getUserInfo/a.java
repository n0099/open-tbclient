package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bvM;

    public UserData Mo() {
        return this.bvM;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bvM = new UserData();
            this.bvM.parserProtobuf(dataRes.user);
        }
    }
}
