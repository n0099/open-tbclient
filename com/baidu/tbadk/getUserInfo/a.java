package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData eDt;

    public UserData bkc() {
        return this.eDt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eDt = new UserData();
            this.eDt.parserProtobuf(dataRes.user);
        }
    }
}
