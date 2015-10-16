package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class MyGiftNotifyMessage extends CustomResponsedMessage<Object> {
    public MyGiftNotifyMessage() {
        super(CmdConfigCustom.CMD_SHOW_GIFT_MSG_TIP);
    }
}
