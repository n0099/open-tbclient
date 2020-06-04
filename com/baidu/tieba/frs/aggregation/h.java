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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a dNL;
    private c hub;
    private TbPageContext mPageContext;
    private BdUniqueId afZ = BdUniqueId.gen();
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.hub != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.isSucc) {
                    h.this.hub.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.hub.nk(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.hub = cVar;
        this.dNL = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.dNP.setSelfListener(true);
        this.dNP.setTag(this.afZ);
        MessageManager.getInstance().registerListener(this.dNP);
    }

    public void f(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && gVar.htE != null && this.dNL != null && bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            this.dNL.a(!gVar.htE.hasFocus, gVar.htE.portrait, gVar.htE.userId, this.afZ);
        }
    }

    public void g(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && this.hub != null && bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.hub.bXx();
        }
    }

    public void bXG() {
        if (this.dNL != null) {
            this.dNL.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.dNP);
    }
}
