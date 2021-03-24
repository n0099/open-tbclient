package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewMsgArriveResponsedMessage extends CustomResponsedMessage<Integer> {
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_OFFICIAL = 4;
    public static final int TYPE_PERSONAL = 3;
    public static final int TYPE_REPLY_OR_AT = 2;

    public NewMsgArriveResponsedMessage(int i) {
        super(2012111, Integer.valueOf(i));
    }
}
