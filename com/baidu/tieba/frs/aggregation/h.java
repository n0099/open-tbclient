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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a aqE;
    private c drK;
    private TbPageContext mPageContext;
    private BdUniqueId aqv = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.drK != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.Gp) {
                    h.this.drK.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.drK.fS(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.drK = cVar;
        this.aqE = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.aqv);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(g gVar) {
        if (!j.jE()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (gVar != null && gVar.drx != null && this.aqE != null && ba.aV(this.mPageContext.getPageActivity())) {
            this.aqE.a(!gVar.drx.hasFocus, gVar.drx.portrait, gVar.drx.userId, this.aqv);
        }
    }

    public void g(g gVar) {
        if (!j.jE()) {
            this.mPageContext.showToast(d.j.no_network);
        } else if (gVar != null && this.drK != null && ba.aV(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", gVar.hasAgree ? 1 : 0);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            MessageManager.getInstance().sendMessage(httpMessage);
            this.drK.awh();
        }
    }

    public void aws() {
        if (this.aqE != null) {
            this.aqE.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
