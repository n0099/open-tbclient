package com.baidu.tieba.frs.aggregation;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a aqA;
    private c dme;
    private TbPageContext mPageContext;
    private BdUniqueId aKh = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.dme != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.Gp) {
                    h.this.dme.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.dme.fK(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dme = cVar;
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.aKh);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(g gVar) {
        if (!j.jD()) {
            this.mPageContext.showToast(d.k.no_network);
        } else if (gVar != null && gVar.dlS != null && this.aqA != null && ba.aU(this.mPageContext.getPageActivity())) {
            this.aqA.a(!gVar.dlS.hasFocus, gVar.dlS.portrait, gVar.dlS.userId, this.aKh);
        }
    }

    public void g(g gVar) {
        if (!j.jD()) {
            this.mPageContext.showToast(d.k.no_network);
        } else if (gVar != null && this.dme != null && ba.aU(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", gVar.hasAgree ? 1 : 0);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.dme.auY();
        }
    }

    public void avk() {
        if (this.aqA != null) {
            this.aqA.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
