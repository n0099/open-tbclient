package com.baidu.tieba.forumsearch.controller;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumRequestMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
/* loaded from: classes11.dex */
public class d {
    private a gWB;
    private com.baidu.adp.framework.listener.a gWF = new com.baidu.adp.framework.listener.a(1003335, CmdConfigSocket.CMD_SEARCH_POST_FORUM) { // from class: com.baidu.tieba.forumsearch.controller.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError() || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != d.this.mPageId) {
                if (d.this.gWB != null) {
                    d.this.gWB.a(false, null);
                    return;
                }
                return;
            }
            com.baidu.tieba.forumsearch.b.c searchData = responsedMessage instanceof SearchPostForumHttpResponseMessage ? ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData() : null;
            if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                searchData = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
            }
            if (d.this.gWB != null) {
                d.this.gWB.a(searchData != null, searchData);
            }
        }
    };
    TbPageContext mPageContext;
    private final BdUniqueId mPageId;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.gWF.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.gWF);
    }

    public void a(a aVar) {
        this.gWB = aVar;
    }

    public void CN(String str) {
        if (!StringUtils.isNull(str)) {
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
                return;
            }
            cancelMessage();
            MessageManager.getInstance().removeMessage(1003335, this.mPageId);
            SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
            searchPostForumRequestMessage.setTag(this.mPageId);
            searchPostForumRequestMessage.set_word(str);
            MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
        }
    }

    public void cancelMessage() {
        MessageManager.getInstance().removeMessage(1003335, this.mPageId);
    }
}
