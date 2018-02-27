package com.baidu.tieba.frs.aggregation;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a bfq;
    private b dIQ;
    private TbPageContext mPageContext;
    private BdUniqueId bri = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.dIQ != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.apG) {
                    h.this.dIQ.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.dIQ.ga(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dIQ = bVar;
        this.bfq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.bri);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(f fVar) {
        if (!j.oJ()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (fVar != null && fVar.dIE != null && this.bfq != null && ay.ba(this.mPageContext.getPageActivity())) {
            this.bfq.a(!fVar.dIE.hasFocus, fVar.dIE.portrait, fVar.dIE.userId, this.bri);
        }
    }

    public void g(f fVar) {
        if (!j.oJ()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (fVar != null && this.dIQ != null && ay.ba(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", fVar.threadId);
            httpMessage.addParam("op_type", fVar.hasAgree ? 1 : 0);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", fVar.forumId);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.dIQ.awz();
        }
    }

    public void awO() {
        if (this.bfq != null) {
            this.bfq.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
