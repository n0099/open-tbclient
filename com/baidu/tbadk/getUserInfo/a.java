package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData atK;

    public UserData CH() {
        return this.atK;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.atK = new UserData();
            this.atK.parserProtobuf(dataRes.user);
        }
    }
}
