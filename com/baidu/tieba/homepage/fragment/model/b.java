package com.baidu.tieba.homepage.fragment.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.mvc.model.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.homepage.fragment.data.c byv;
    private com.baidu.tieba.homepage.fragment.model.a byw;
    private e byx;
    private a byu = null;
    private a.InterfaceC0054a<com.baidu.tieba.homepage.fragment.data.b> byy = new c(this);
    private NetModel.b<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> byz = new d(this);

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, String str, com.baidu.tieba.homepage.fragment.data.b bVar);

        void h(String str, String str2, int i);
    }

    public void a(a aVar) {
        this.byu = aVar;
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.byw = new com.baidu.tieba.homepage.fragment.model.a(tbPageContext);
        this.byw.setUniqueId(bdUniqueId);
        this.byw.a(this.byy);
        this.byv = new com.baidu.tieba.homepage.fragment.data.c();
        this.byx = new e(tbPageContext, this.byv);
        this.byx.setUniqueId(bdUniqueId);
        this.byx.setNeedCache(true);
        this.byx.a(this.byz);
    }

    public void IR() {
        this.byw.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.fragment.data.a("home_page_main"));
    }

    public void Hx() {
        if (!this.byx.isLoading() && i.iP()) {
            this.byv.setCacheKey("home_page_main");
            this.byx.DJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcNetMessage<com.baidu.tieba.homepage.fragment.data.c, com.baidu.tieba.homepage.fragment.data.b> mvcNetMessage, ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && mvcNetMessage != null) {
            com.baidu.tieba.homepage.fragment.data.c requestData = mvcNetMessage.getRequestData();
            String cacheKey = requestData != null ? requestData.getCacheKey() : null;
            if ((responsedMessage instanceof MvcHttpResponsedMessage) && ((MvcHttpResponsedMessage) responsedMessage).getError() == 0 && ((MvcHttpResponsedMessage) responsedMessage).getData() != null && (((MvcHttpResponsedMessage) responsedMessage).getData() instanceof com.baidu.tieba.homepage.fragment.data.b)) {
                com.baidu.tieba.homepage.fragment.data.b bVar = (com.baidu.tieba.homepage.fragment.data.b) ((MvcHttpResponsedMessage) responsedMessage).getData();
                if (this.byu != null) {
                    this.byu.a(true, cacheKey, bVar);
                }
            } else if ((responsedMessage instanceof MvcSocketResponsedMessage) && ((MvcSocketResponsedMessage) responsedMessage).getError() == 0 && ((MvcSocketResponsedMessage) responsedMessage).getData() != null && (((MvcSocketResponsedMessage) responsedMessage).getData() instanceof com.baidu.tieba.homepage.fragment.data.b)) {
                com.baidu.tieba.homepage.fragment.data.b bVar2 = (com.baidu.tieba.homepage.fragment.data.b) ((MvcSocketResponsedMessage) responsedMessage).getData();
                if (this.byu != null) {
                    this.byu.a(true, cacheKey, bVar2);
                }
            } else if (this.byu != null) {
                this.byu.a(true, cacheKey, null);
                this.byu.h(cacheKey, responsedMessage.getErrorString(), responsedMessage.getError());
            }
        }
    }
}
