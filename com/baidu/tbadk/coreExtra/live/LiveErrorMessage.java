package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class LiveErrorMessage extends CustomResponsedMessage<String> {
    public String errorPrompt;

    public LiveErrorMessage(String str) {
        super(2001163, str);
    }
}
