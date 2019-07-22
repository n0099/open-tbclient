package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData cvm;

    public UserData atn() {
        return this.cvm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cvm = new UserData();
            this.cvm.parserProtobuf(dataRes.user);
        }
    }
}
