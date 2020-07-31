package com.baidu.tieba.frs.aggregation;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a eaU;
    private c hMM;
    private TbPageContext mPageContext;
    private BdUniqueId agB = BdUniqueId.gen();
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.hMM != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.isSucc) {
                    h.this.hMM.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.hMM.oa(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.hMM = cVar;
        this.eaU = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eaY.setSelfListener(true);
        this.eaY.setTag(this.agB);
        MessageManager.getInstance().registerListener(this.eaY);
    }

    public void f(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && gVar.hMq != null && this.eaU != null && bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            this.eaU.a(!gVar.hMq.hasFocus, gVar.hMq.portrait, gVar.hMq.userId, this.agB);
        }
    }

    public void g(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && this.hMM != null && bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.hMM.ceh();
        }
    }

    public void ceq() {
        if (this.eaU != null) {
            this.eaU.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.eaY);
    }
}
