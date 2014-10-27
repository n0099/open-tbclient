package com.baidu.tbadk.coreExtra.relationship;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
/* loaded from: classes.dex */
public class h {
    private List<b> Mr;
    private String mKey;

    public String getKey() {
        return this.mKey;
    }

    public List<b> getContacts() {
        if (this.Mr == null) {
            this.Mr = new ArrayList();
        }
        return this.Mr;
    }

    public void a(listData listdata) {
        if (listdata != null) {
            this.mKey = listdata.key;
            if (listdata.friend_list != null) {
                this.Mr = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    b bVar = new b();
                    bVar.a(friendlist);
                    bVar.cE(this.mKey);
                    this.Mr.add(bVar);
                }
            }
        }
    }
}
