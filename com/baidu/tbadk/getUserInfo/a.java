package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData cwp;

    public UserData atB() {
        return this.cwp;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cwp = new UserData();
            this.cwp.parserProtobuf(dataRes.user);
        }
    }
}
