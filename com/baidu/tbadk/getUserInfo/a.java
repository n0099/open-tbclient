package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aCn;

    public UserData EA() {
        return this.aCn;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aCn = new UserData();
            this.aCn.parserProtobuf(dataRes.user);
        }
    }
}
