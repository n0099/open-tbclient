package com.baidu.tieba.im.recommend.detail;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<RecommendDetailActivity> {
    private TbPageContext<RecommendDetailActivity> LP;
    private boolean aQI;
    private long acV;
    private g bmn;
    private boolean bmo;
    private com.baidu.adp.framework.listener.a bmp;
    private CustomMessageListener bmq;

    public c(TbPageContext<RecommendDetailActivity> tbPageContext, g gVar) {
        super(tbPageContext);
        this.aQI = false;
        this.bmo = false;
        this.bmp = new d(this, CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, 303025);
        this.bmq = new e(this, 2001313);
        this.LP = tbPageContext;
        this.bmn = gVar;
        registerListener(this.bmp);
        registerListener(this.bmq);
        Qu();
    }

    public void ad(long j) {
        this.acV = j;
        sendMessage(new CustomMessage(2001313, Integer.valueOf((int) this.acV)));
    }

    private void Qu() {
        registerListener(new f(this, 104102));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tp() {
        RecommendDetailRequestMessage recommendDetailRequestMessage = new RecommendDetailRequestMessage();
        recommendDetailRequestMessage.setUserId((int) this.acV);
        sendMessage(recommendDetailRequestMessage);
    }

    public void cV(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setMaskType(6);
        sendMessage(requestUpdateMaskInfoMessage);
    }

    public boolean Tq() {
        return this.aQI;
    }

    public boolean Tr() {
        return this.bmo;
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
