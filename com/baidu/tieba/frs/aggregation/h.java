package com.baidu.tieba.frs.aggregation;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a ard;
    private c doQ;
    private TbPageContext mPageContext;
    private BdUniqueId aqU = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.doQ != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.Gr) {
                    h.this.doQ.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.doQ.fQ(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.doQ = cVar;
        this.ard = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.aqU);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(g gVar) {
        if (!j.jD()) {
            this.mPageContext.showToast(d.k.no_network);
        } else if (gVar != null && gVar.doE != null && this.ard != null && bb.aU(this.mPageContext.getPageActivity())) {
            this.ard.a(!gVar.doE.hasFocus, gVar.doE.portrait, gVar.doE.userId, this.aqU);
        }
    }

    public void g(g gVar) {
        if (!j.jD()) {
            this.mPageContext.showToast(d.k.no_network);
        } else if (gVar != null && this.doQ != null && bb.aU(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", gVar.hasAgree ? 1 : 0);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            MessageManager.getInstance().sendMessage(httpMessage);
            this.doQ.avC();
        }
    }

    public void avN() {
        if (this.ard != null) {
            this.ard.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
