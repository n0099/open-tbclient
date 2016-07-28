package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData auz;

    public UserData CG() {
        return this.auz;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.auz = new UserData();
            this.auz.parserProtobuf(dataRes.user);
        }
    }
}
