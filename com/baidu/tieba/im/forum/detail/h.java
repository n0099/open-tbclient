package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<ForumDetailActivity> {
    private ForumDetailActivity baC;
    private l baD;

    public h(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.baC = forumDetailActivity;
        this.baD = forumDetailActivity;
        Ow();
        Ox();
        Oy();
    }

    private void Ow() {
        registerListener(new i(this, CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021));
    }

    private void Ox() {
        registerListener(new j(this, 104102));
    }

    private void Oy() {
        registerListener(new k(this, 2001155));
    }

    public void gL(String str) {
        ForumDetailRequestMessage forumDetailRequestMessage = new ForumDetailRequestMessage();
        forumDetailRequestMessage.setForumId(com.baidu.adp.lib.g.c.a(str, 0L));
        sendMessage(forumDetailRequestMessage);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void j(boolean z, String str) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(12);
        requestUpdateMaskInfoMessage.setList(str);
        sendMessage(requestUpdateMaskInfoMessage);
    }
}
