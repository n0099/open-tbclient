package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class LoadDraftResponsedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public String id;
        public String mDraft;
    }

    public LoadDraftResponsedMessage(int i) {
        super(i);
    }
}
