package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData flt;

    public UserData byw() {
        return this.flt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.flt = new UserData();
            this.flt.parserProtobuf(dataRes.user);
        }
    }
}
