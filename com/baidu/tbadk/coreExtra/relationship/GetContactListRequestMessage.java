package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GetContactListRequestMessage extends CustomMessage<String> {
    public GetContactListRequestMessage() {
        super(CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    }
}
