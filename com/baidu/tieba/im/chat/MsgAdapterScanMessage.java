package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes.dex */
public class MsgAdapterScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public TbPageContext<MsglistActivity<?>> context;
        public List<e> iea;
    }

    public MsgAdapterScanMessage(a aVar) {
        super(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN, aVar);
    }
}
