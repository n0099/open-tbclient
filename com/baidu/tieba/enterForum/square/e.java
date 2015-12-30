package com.baidu.tieba.enterForum.square;

import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e<BaseFragmentActivity> {
    public e(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private ForumClassRequestNetMessage KL() {
        return new ForumClassRequestNetMessage();
    }

    public void sendMessage() {
        sendMessage(KL());
    }
}
