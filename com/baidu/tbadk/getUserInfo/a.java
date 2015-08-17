package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData asT;

    public UserData BW() {
        return this.asT;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.asT = new UserData();
            this.asT.parserProtobuf(dataRes.user);
        }
    }
}
