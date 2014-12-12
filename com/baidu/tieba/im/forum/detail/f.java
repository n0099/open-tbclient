package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<ForumDetailActivity> {
    private ForumDetailActivity aZf;
    private j aZg;

    public f(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.aZf = forumDetailActivity;
        this.aZg = forumDetailActivity;
        Oa();
        Ob();
        Oc();
    }

    private void Oa() {
        registerListener(new g(this, CmdConfigHttp.MSG_FORUM_DETAIL_CMD, 303021));
    }

    private void Ob() {
        registerListener(new h(this, 104102));
    }

    private void Oc() {
        registerListener(new i(this, 2001155));
    }

    public void gG(String str) {
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
