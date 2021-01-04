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
    private BdUniqueId ahE;
    private InterfaceC0723a iJn;
    private c iKl;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a eFZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.ahE) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || x.isEmpty(cVar.iKi))) {
                            if (a.this.iJn != null) {
                                a.this.iJn.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.iKl.iKh = cVar.iKh;
                            a.this.iKl.iKi.addAll(cVar.iKi);
                            a.this.iKl.iKj = cVar.iKj;
                            a.this.iKl.heG = cVar.heG;
                            a.this.iKl.iKk = cVar.iKk;
                            a.this.iKl.iKa = cVar.iKa;
                            if (x.isEmpty(cVar.iKi)) {
                                a.this.iKl.hasMore = false;
                            } else {
                                a.this.iKl.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.iJn != null) {
                                a.this.iJn.a(cVar);
                            }
                        }
                    } else if (a.this.iJn != null) {
                        a.this.iJn.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0723a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.ahE = bdUniqueId;
        this.eFZ.setTag(this.ahE);
        MessageManager.getInstance().registerListener(this.eFZ);
        buF();
        buG();
        this.iKl = new c();
    }

    public void JN(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ahE);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void ge(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ahE);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.iKl;
    }

    public int czc() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.iKl.hasMore;
    }

    private void buF() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void buG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ahE);
        MessageManager.getInstance().unRegisterListener(this.ahE);
    }

    public void a(InterfaceC0723a interfaceC0723a) {
        this.iJn = interfaceC0723a;
    }
}
