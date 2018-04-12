package com.baidu.tieba.addresslist.relationship;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes3.dex */
public class e {
    private List<com.baidu.tbadk.coreExtra.relationship.a> bem;
    private String mKey;

    public String getKey() {
        return this.mKey;
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> getContacts() {
        if (this.bem == null) {
            this.bem = new ArrayList();
        }
        return this.bem;
    }

    public void a(listData listdata) {
        if (listdata != null) {
            this.mKey = listdata.key;
            if (listdata.friend_list != null) {
                this.bem = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.a(friendlist);
                    aVar.fw(this.mKey);
                    this.bem.add(aVar);
                }
            }
        }
    }

    public void a(robotsList robotslist) {
        if (robotslist != null) {
            this.mKey = robotslist.key;
            if (robotslist.friend_list != null) {
                this.bem = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.a(friendlist);
                    aVar.fw(this.mKey);
                    this.bem.add(aVar);
                }
            }
        }
    }
}
