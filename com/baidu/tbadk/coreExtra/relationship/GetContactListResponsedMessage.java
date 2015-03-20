package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class GetContactListResponsedMessage extends CustomResponsedMessage<String> {
    private List<a> contacts;

    public GetContactListResponsedMessage() {
        super(2001188);
    }

    public List<a> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<a> list) {
        this.contacts = list;
    }
}
