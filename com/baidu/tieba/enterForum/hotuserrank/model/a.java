package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
/* loaded from: classes22.dex */
public class a {
    private BdUniqueId ajD;
    private c ixY;
    private InterfaceC0732a ixa;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a ewJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.ajD) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || y.isEmpty(cVar.ixV))) {
                            if (a.this.ixa != null) {
                                a.this.ixa.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.ixY.ixU = cVar.ixU;
                            a.this.ixY.ixV.addAll(cVar.ixV);
                            a.this.ixY.ixW = cVar.ixW;
                            a.this.ixY.gST = cVar.gST;
                            a.this.ixY.ixX = cVar.ixX;
                            a.this.ixY.ixN = cVar.ixN;
                            if (y.isEmpty(cVar.ixV)) {
                                a.this.ixY.hasMore = false;
                            } else {
                                a.this.ixY.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.ixa != null) {
                                a.this.ixa.a(cVar);
                            }
                        }
                    } else if (a.this.ixa != null) {
                        a.this.ixa.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0732a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
        this.ewJ.setTag(this.ajD);
        MessageManager.getInstance().registerListener(this.ewJ);
        bsd();
        bse();
        this.ixY = new c();
    }

    public void JP(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ajD);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void ge(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ajD);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.ixY;
    }

    public int cwj() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.ixY.hasMore;
    }

    private void bsd() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bse() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bN(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ajD);
        MessageManager.getInstance().unRegisterListener(this.ajD);
    }

    public void a(InterfaceC0732a interfaceC0732a) {
        this.ixa = interfaceC0732a;
    }
}
