package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData akn;

    public UserData zr() {
        return this.akn;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.akn = new UserData();
            this.akn.parserProtobuf(dataRes.user);
        }
    }
}
