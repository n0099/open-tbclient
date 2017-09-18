package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class MsgAdapterScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public TbPageContext<MsglistActivity<?>> context;
        public List<e> dqI;
    }

    public MsgAdapterScanMessage(a aVar) {
        super(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN, aVar);
    }
}
