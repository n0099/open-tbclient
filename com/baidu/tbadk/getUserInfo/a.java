package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData btr;

    public UserData LG() {
        return this.btr;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.btr = new UserData();
            this.btr.parserProtobuf(dataRes.user);
        }
    }
}
