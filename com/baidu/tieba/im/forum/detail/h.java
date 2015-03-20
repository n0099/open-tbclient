package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f<ForumDetailActivity> {
    private ForumDetailActivity bcE;
    private l bcF;

    public h(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.bcE = forumDetailActivity;
        this.bcF = forumDetailActivity;
        Qg();
        Qh();
        Qi();
    }

    private void Qg() {
        registerListener(new i(this, CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021));
    }

    private void Qh() {
        registerListener(new j(this, 104102));
    }

    private void Qi() {
        registerListener(new k(this, 2001155));
    }

    public void gz(String str) {
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

    public void h(boolean z, String str) {
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
