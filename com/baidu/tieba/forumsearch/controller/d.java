package com.baidu.tieba.forumsearch.controller;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumRequestMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
/* loaded from: classes3.dex */
public class d {
    private a dyJ;
    private com.baidu.adp.framework.listener.a dyO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SEARCH_POST_FORUM, 309466) { // from class: com.baidu.tieba.forumsearch.controller.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.hasError() || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != d.this.mPageId) {
                if (d.this.dyJ != null) {
                    d.this.dyJ.a(false, null);
                    return;
                }
                return;
            }
            com.baidu.tieba.forumsearch.b.c searchData = responsedMessage instanceof SearchPostForumHttpResponseMessage ? ((SearchPostForumHttpResponseMessage) responsedMessage).getSearchData() : null;
            if (responsedMessage instanceof SearchPostForumSocketResponseMessage) {
                searchData = ((SearchPostForumSocketResponseMessage) responsedMessage).getSearchData();
            }
            if (d.this.dyJ != null) {
                d.this.dyJ.a(searchData != null, searchData);
            }
        }
    };
    TbPageContext mPageContext;
    private final BdUniqueId mPageId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, com.baidu.tieba.forumsearch.b.c cVar);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.dyO.setTag(this.mPageId);
        MessageManager.getInstance().registerListener(this.dyO);
    }

    public void a(a aVar) {
        this.dyJ = aVar;
    }

    public void nv(String str) {
        if (!StringUtils.isNull(str)) {
            if (!l.lo()) {
                this.mPageContext.showToast(e.j.neterror);
                return;
            }
            cancelMessage();
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.mPageId);
            SearchPostForumRequestMessage searchPostForumRequestMessage = new SearchPostForumRequestMessage();
            searchPostForumRequestMessage.setTag(this.mPageId);
            searchPostForumRequestMessage.set_word(str);
            MessageManager.getInstance().sendMessage(searchPostForumRequestMessage);
        }
    }

    public void cancelMessage() {
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_SEARCH_POST_FORUM, this.mPageId);
    }
}
