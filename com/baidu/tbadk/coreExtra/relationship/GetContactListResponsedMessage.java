package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.List;
/* loaded from: classes2.dex */
public class GetContactListResponsedMessage extends CustomResponsedMessage<String> {
    private List<a> contacts;

    public GetContactListResponsedMessage() {
        super(CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    }

    public List<a> getContacts() {
        return this.contacts;
    }

    public void setContacts(List<a> list) {
        this.contacts = list;
    }
}
