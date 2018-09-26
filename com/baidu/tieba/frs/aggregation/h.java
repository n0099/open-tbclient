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
    private com.baidu.tbadk.coreExtra.model.a atd;
    private c dxX;
    private TbPageContext mPageContext;
    private BdUniqueId asU = BdUniqueId.gen();
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.dxX != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.IM) {
                    h.this.dxX.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.dxX.gp(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.dxX = cVar;
        this.atd = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.mAttentionListener.setSelfListener(true);
        this.mAttentionListener.setTag(this.asU);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    public void g(g gVar) {
        if (!j.kK()) {
            this.mPageContext.showToast(e.j.no_network);
        } else if (gVar != null && gVar.dxJ != null && this.atd != null && ba.bA(this.mPageContext.getPageActivity())) {
            this.atd.a(!gVar.dxJ.hasFocus, gVar.dxJ.portrait, gVar.dxJ.userId, this.asU);
        }
    }

    public void h(g gVar) {
        if (!j.kK()) {
            this.mPageContext.showToast(e.j.no_network);
        } else if (gVar != null && this.dxX != null && ba.bA(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.dxX.ayq();
        }
    }

    public void ayC() {
        if (this.atd != null) {
            this.atd.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }
}
