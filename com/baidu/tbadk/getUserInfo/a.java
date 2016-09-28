package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData axj;

    public UserData Eb() {
        return this.axj;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.axj = new UserData();
            this.axj.parserProtobuf(dataRes.user);
        }
    }
}
