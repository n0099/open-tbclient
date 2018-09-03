package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aPp;

    public UserData IG() {
        return this.aPp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aPp = new UserData();
            this.aPp.parserProtobuf(dataRes.user);
        }
    }
}
