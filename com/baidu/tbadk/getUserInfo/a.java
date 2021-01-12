package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData fDj;

    public UserData bCp() {
        return this.fDj;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fDj = new UserData();
            this.fDj.parserProtobuf(dataRes.user);
        }
    }
}
