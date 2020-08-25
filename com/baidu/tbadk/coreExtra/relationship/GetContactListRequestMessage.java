package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class GetContactListRequestMessage extends CustomMessage<String> {
    public GetContactListRequestMessage() {
        super(CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    }
}
