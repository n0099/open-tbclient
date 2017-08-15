package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aFs;

    public UserData Em() {
        return this.aFs;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aFs = new UserData();
            this.aFs.parserProtobuf(dataRes.user);
        }
    }
}
