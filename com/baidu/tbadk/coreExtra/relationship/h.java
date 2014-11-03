package com.baidu.tbadk.coreExtra.relationship;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
/* loaded from: classes.dex */
public class h {
    private List<b> Mu;
    private String mKey;

    public String getKey() {
        return this.mKey;
    }

    public List<b> getContacts() {
        if (this.Mu == null) {
            this.Mu = new ArrayList();
        }
        return this.Mu;
    }

    public void a(listData listdata) {
        if (listdata != null) {
            this.mKey = listdata.key;
            if (listdata.friend_list != null) {
                this.Mu = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    b bVar = new b();
                    bVar.a(friendlist);
                    bVar.cF(this.mKey);
                    this.Mu.add(bVar);
                }
            }
        }
    }
}
