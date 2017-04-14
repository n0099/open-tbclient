package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData aCl;

    public UserData EA() {
        return this.aCl;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.aCl = new UserData();
            this.aCl.parserProtobuf(dataRes.user);
        }
    }
}
