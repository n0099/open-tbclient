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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a bTT;
    private c fCM;
    private TbPageContext mPageContext;
    private BdUniqueId XD = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.fCM != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.Hs) {
                    h.this.fCM.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.fCM.kt(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.fCM = cVar;
        this.bTT = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.XD);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void f(g gVar) {
        if (!j.kc()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && gVar.fCq != null && this.bTT != null && bc.cF(this.mPageContext.getPageActivity())) {
            this.bTT.a(!gVar.fCq.hasFocus, gVar.fCq.portrait, gVar.fCq.userId, this.XD);
        }
    }

    public void g(g gVar) {
        if (!j.kc()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && this.fCM != null && bc.cF(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.fCM.bpg();
        }
    }

    public void bpq() {
        if (this.bTT != null) {
            this.bTT.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
