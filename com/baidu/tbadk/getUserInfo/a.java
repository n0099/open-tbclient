package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aEH;

    public UserData Ej() {
        return this.aEH;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aEH = new UserData();
            this.aEH.parserProtobuf(dataRes.user);
        }
    }
}
