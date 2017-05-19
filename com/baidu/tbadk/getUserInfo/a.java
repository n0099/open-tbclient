package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aCm;

    public UserData DE() {
        return this.aCm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aCm = new UserData();
            this.aCm.parserProtobuf(dataRes.user);
        }
    }
}
