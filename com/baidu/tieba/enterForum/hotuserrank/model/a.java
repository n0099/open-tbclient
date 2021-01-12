package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId agN;
    private InterfaceC0706a iEG;
    private c iFE;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a eBn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.agN) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || x.isEmpty(cVar.iFB))) {
                            if (a.this.iEG != null) {
                                a.this.iEG.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.iFE.iFA = cVar.iFA;
                            a.this.iFE.iFB.addAll(cVar.iFB);
                            a.this.iFE.iFC = cVar.iFC;
                            a.this.iFE.haa = cVar.haa;
                            a.this.iFE.iFD = cVar.iFD;
                            a.this.iFE.iFt = cVar.iFt;
                            if (x.isEmpty(cVar.iFB)) {
                                a.this.iFE.hasMore = false;
                            } else {
                                a.this.iFE.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.iEG != null) {
                                a.this.iEG.a(cVar);
                            }
                        }
                    } else if (a.this.iEG != null) {
                        a.this.iEG.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0706a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
        this.eBn.setTag(this.agN);
        MessageManager.getInstance().registerListener(this.eBn);
        bqM();
        bqN();
        this.iFE = new c();
    }

    public void IB(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.agN);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void ge(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.agN);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.iFE;
    }

    public int cvl() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.iFE.hasMore;
    }

    private void bqM() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bqN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.agN);
        MessageManager.getInstance().unRegisterListener(this.agN);
    }

    public void a(InterfaceC0706a interfaceC0706a) {
        this.iEG = interfaceC0706a;
    }
}
