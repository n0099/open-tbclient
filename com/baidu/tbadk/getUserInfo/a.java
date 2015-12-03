package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData atQ;

    public UserData CO() {
        return this.atQ;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.atQ = new UserData();
            this.atQ.parserProtobuf(dataRes.user);
        }
    }
}
