package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.i0.s.f.a;
import java.util.List;
/* loaded from: classes3.dex */
public class GetContactListResponsedMessage extends CustomResponsedMessage<String> {
    public List<a> contacts;

    public GetContactListResponsedMessage() {
        super(2001184);
    }

    public List<a> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<a> list) {
        this.contacts = list;
    }
}
