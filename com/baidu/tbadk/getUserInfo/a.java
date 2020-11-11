package com.baidu.tbadk.getUserInfo;

import com.baidu.tbadk.data.UserData;
import tbclient.GetUserInfo.DataRes;
/* loaded from: classes.dex */
public class a {
    private UserData frm;

    public UserData bAV() {
        return this.frm;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.frm = new UserData();
            this.frm.parserProtobuf(dataRes.user);
        }
    }
}
