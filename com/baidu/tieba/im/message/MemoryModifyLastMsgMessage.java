package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class MemoryModifyLastMsgMessage extends CustomResponsedMessage<g> {
    public static final int TYPE_CLEAR_ALL = 1;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SEND_MSG = 3;

    public MemoryModifyLastMsgMessage(g gVar) {
        super(2016003, gVar);
    }
}
