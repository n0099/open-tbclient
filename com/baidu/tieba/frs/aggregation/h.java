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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a ayB;
    private c dHn;
    private TbPageContext mPageContext;
    private BdUniqueId ays = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.dHn != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.Jr) {
                    h.this.dHn.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.dHn.gR(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dHn = cVar;
        this.ayB = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.ays);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void g(g gVar) {
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.no_network);
        } else if (gVar != null && gVar.dGZ != null && this.ayB != null && ba.bG(this.mPageContext.getPageActivity())) {
            this.ayB.a(!gVar.dGZ.hasFocus, gVar.dGZ.portrait, gVar.dGZ.userId, this.ays);
        }
    }

    public void h(g gVar) {
        if (!j.kV()) {
            this.mPageContext.showToast(e.j.no_network);
        } else if (gVar != null && this.dHn != null && ba.bG(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.dHn.aBj();
        }
    }

    public void aBt() {
        if (this.ayB != null) {
            this.ayB.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
