package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ShareSDKResultMessage extends CustomResponsedMessage<Boolean> {
    public ShareSDKResultMessage(Boolean bool) {
        super(2001250, bool);
    }
}
