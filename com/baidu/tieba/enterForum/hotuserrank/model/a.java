package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
/* loaded from: classes9.dex */
public class a {
    private BdUniqueId afD;
    private InterfaceC0552a gCI;
    private c gDJ;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a dho = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.afD) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || v.isEmpty(cVar.gDG))) {
                            if (a.this.gCI != null) {
                                a.this.gCI.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.gDJ.gDF = cVar.gDF;
                            a.this.gDJ.gDG.addAll(cVar.gDG);
                            a.this.gDJ.gDH = cVar.gDH;
                            a.this.gDJ.fof = cVar.fof;
                            a.this.gDJ.gDI = cVar.gDI;
                            a.this.gDJ.gDx = cVar.gDx;
                            if (v.isEmpty(cVar.gDG)) {
                                a.this.gDJ.hasMore = false;
                            } else {
                                a.this.gDJ.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.gCI != null) {
                                a.this.gCI.a(cVar);
                            }
                        }
                    } else if (a.this.gCI != null) {
                        a.this.gCI.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0552a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.afD = bdUniqueId;
        this.dho.setTag(this.afD);
        MessageManager.getInstance().registerListener(this.dho);
        bFD();
        bqo();
        this.gDJ = new c();
    }

    public void Cd(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.afD);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void dX(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.afD);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.gDJ;
    }

    public int bIR() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.gDJ.hasMore;
    }

    private void bFD() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bqo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.afD);
        MessageManager.getInstance().unRegisterListener(this.afD);
    }

    public void a(InterfaceC0552a interfaceC0552a) {
        this.gCI = interfaceC0552a;
    }
}
