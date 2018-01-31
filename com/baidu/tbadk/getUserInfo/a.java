package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData btA;

    public UserData LI() {
        return this.btA;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.btA = new UserData();
            this.btA.parserProtobuf(dataRes.user);
        }
    }
}
