package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData eNW;

    public UserData bsP() {
        return this.eNW;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eNW = new UserData();
            this.eNW.parserProtobuf(dataRes.user);
        }
    }
}
