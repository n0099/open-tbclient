package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData bbw;

    public UserData Nl() {
        return this.bbw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bbw = new UserData();
            this.bbw.parserProtobuf(dataRes.user);
        }
    }
}
