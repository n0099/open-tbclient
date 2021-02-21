package com.baidu.tieba.frs.aggregation;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a faF;
    private c joB;
    private TbPageContext mPageContext;
    private BdUniqueId agC = BdUniqueId.gen();
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.joB != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.isSucc) {
                    h.this.joB.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.joB.qW(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.joB = cVar;
        this.faF = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.faJ.setSelfListener(true);
        this.faJ.setTag(this.agC);
        MessageManager.getInstance().registerListener(this.faJ);
    }

    public void g(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && gVar.jof != null && this.faF != null && bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            this.faF.a(!gVar.jof.hasFocus, gVar.jof.portrait, gVar.jof.userId, this.agC);
        }
    }

    public void h(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && this.joB != null && bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("thread_id", gVar.threadId);
            httpMessage.addParam("op_type", Boolean.valueOf(gVar.hasAgree));
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", gVar.forumId);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            if (!StringUtil.isEmpty(gVar.objSource)) {
                httpMessage.addParam("obj_source", gVar.objSource);
            }
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
            this.joB.cFu();
        }
    }

    public void cFE() {
        if (this.faF != null) {
            this.faF.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.faJ);
    }
}
