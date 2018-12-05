package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bbt;

    public UserData Nk() {
        return this.bbt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bbt = new UserData();
            this.bbt.parserProtobuf(dataRes.user);
        }
    }
}
