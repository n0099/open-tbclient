package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData dAn;

    public UserData aPN() {
        return this.dAn;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dAn = new UserData();
            this.dAn.parserProtobuf(dataRes.user);
        }
    }
}
