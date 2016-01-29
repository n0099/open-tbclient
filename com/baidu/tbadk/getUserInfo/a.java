package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData awm;

    public UserData DU() {
        return this.awm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.awm = new UserData();
            this.awm.parserProtobuf(dataRes.user);
        }
    }
}
