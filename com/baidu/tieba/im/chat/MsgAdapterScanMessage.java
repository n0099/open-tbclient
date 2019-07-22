package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes.dex */
public class MsgAdapterScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public TbPageContext<MsglistActivity<?>> context;
        public List<e> gyS;
    }

    public MsgAdapterScanMessage(a aVar) {
        super(2001275, aVar);
    }
}
