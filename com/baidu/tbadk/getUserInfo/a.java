package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bth;

    public UserData LS() {
        return this.bth;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bth = new UserData();
            this.bth.parserProtobuf(dataRes.user);
        }
    }
}
