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
    private com.baidu.tbadk.coreExtra.model.a bfC;
    private b dJc;
    private TbPageContext mPageContext;
    private BdUniqueId brv = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.dJc != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.apP) {
                    h.this.dJc.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.dJc.ga(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, b bVar) {
        this.mPageContext = tbPageContext;
        this.dJc = bVar;
        this.bfC = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.brv);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(f fVar) {
        if (!j.oJ()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (fVar != null && fVar.dIQ != null && this.bfC != null && ay.ba(this.mPageContext.getPageActivity())) {
            this.bfC.a(!fVar.dIQ.hasFocus, fVar.dIQ.portrait, fVar.dIQ.userId, this.brv);
        }
    }

    public void g(f fVar) {
        if (!j.oJ()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (fVar != null && this.dJc != null && ay.ba(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", fVar.threadId);
            httpMessage.addParam("op_type", fVar.hasAgree ? 1 : 0);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", fVar.forumId);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.dJc.awA();
        }
    }

    public void awP() {
        if (this.bfC != null) {
            this.bfC.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
