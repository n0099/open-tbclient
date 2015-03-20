package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<RecommendDetailActivity> {
    private TbPageContext<RecommendDetailActivity> LN;
    private boolean aQr;
    private long acN;
    private g blX;
    private boolean blY;
    private com.baidu.adp.framework.listener.a blZ;
    private CustomMessageListener bma;

    public c(TbPageContext<RecommendDetailActivity> tbPageContext, g gVar) {
        super(tbPageContext);
        this.aQr = false;
        this.blY = false;
        this.blZ = new d(this, CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.bma = new e(this, 2001313);
        this.LN = tbPageContext;
        this.blX = gVar;
        registerListener(this.blZ);
        registerListener(this.bma);
        Qh();
    }

    public void ad(long j) {
        this.acN = j;
        sendMessage(new CustomMessage(2001313, Integer.valueOf((int) this.acN)));
    }

    private void Qh() {
        registerListener(new f(this, 104102));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tc() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId((int) this.acN);
        sendMessage(recommendDetailRequestMessage);
    }

    public void cX(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(6);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    public boolean Td() {
        return this.aQr;
    }

    public boolean Te() {
        return this.blY;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
