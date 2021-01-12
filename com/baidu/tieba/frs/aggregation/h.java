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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h {
    private com.baidu.tbadk.coreExtra.model.a eYq;
    private c jiG;
    private TbPageContext mPageContext;
    private BdUniqueId agN = BdUniqueId.gen();
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.aggregation.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && h.this.jiG != null && (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) != null) {
                if (!data.isSucc) {
                    h.this.jiG.showMsg(updateAttentionMessage.getData().errorString);
                } else {
                    h.this.jiG.qM(data.isAttention);
                }
            }
        }
    };

    public h(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jiG = cVar;
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(tbPageContext);
        this.eYu.setSelfListener(true);
        this.eYu.setTag(this.agN);
        MessageManager.getInstance().registerListener(this.eYu);
    }

    public void f(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && gVar.jik != null && this.eYq != null && bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            this.eYq.a(!gVar.jik.hasFocus, gVar.jik.portrait, gVar.jik.userId, this.agN);
        }
    }

    public void g(g gVar) {
        if (!j.isNetWorkAvailable()) {
            this.mPageContext.showToast(R.string.no_network);
        } else if (gVar != null && this.jiG != null && bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
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
            this.jiG.cEb();
        }
    }

    public void cEk() {
        if (this.eYq != null) {
            this.eYq.cancel();
        }
        MessageManager.getInstance().unRegisterListener(this.eYu);
    }
}
