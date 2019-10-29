package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData cIy;

    public UserData avl() {
        return this.cIy;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cIy = new UserData();
            this.cIy.parserProtobuf(dataRes.user);
        }
    }
}
