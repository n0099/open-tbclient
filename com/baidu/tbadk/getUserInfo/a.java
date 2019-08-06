package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData cvt;

    public UserData atp() {
        return this.cvt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cvt = new UserData();
            this.cvt.parserProtobuf(dataRes.user);
        }
    }
}
