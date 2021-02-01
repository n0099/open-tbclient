package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fFv;

    public UserData bCH() {
        return this.fFv;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fFv = new UserData();
            this.fFv.parserProtobuf(dataRes.user);
        }
    }
}
