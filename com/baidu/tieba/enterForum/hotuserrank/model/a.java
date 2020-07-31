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
/* loaded from: classes16.dex */
public class a {
    private BdUniqueId agB;
    private InterfaceC0619a hjV;
    private c hkW;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a dFJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.agB) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || x.isEmpty(cVar.hkT))) {
                            if (a.this.hjV != null) {
                                a.this.hjV.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.hkW.hkS = cVar.hkS;
                            a.this.hkW.hkT.addAll(cVar.hkT);
                            a.this.hkW.hkU = cVar.hkU;
                            a.this.hkW.fSF = cVar.fSF;
                            a.this.hkW.hkV = cVar.hkV;
                            a.this.hkW.hkK = cVar.hkK;
                            if (x.isEmpty(cVar.hkT)) {
                                a.this.hkW.hasMore = false;
                            } else {
                                a.this.hkW.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.hjV != null) {
                                a.this.hjV.a(cVar);
                            }
                        }
                    } else if (a.this.hjV != null) {
                        a.this.hjV.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0619a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.agB = bdUniqueId;
        this.dFJ.setTag(this.agB);
        MessageManager.getInstance().registerListener(this.dFJ);
        aZf();
        aZg();
        this.hkW = new c();
    }

    public void EY(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.agB);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void eo(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.agB);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.hkW;
    }

    public int bVH() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.hkW.hasMore;
    }

    private void aZf() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void aZg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.agB);
        MessageManager.getInstance().unRegisterListener(this.agB);
    }

    public void a(InterfaceC0619a interfaceC0619a) {
        this.hjV = interfaceC0619a;
    }
}
