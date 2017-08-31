package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEK;

    public UserData Ej() {
        return this.aEK;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEK = new UserData();
            this.aEK.parserProtobuf(dataRes.user);
        }
    }
}
