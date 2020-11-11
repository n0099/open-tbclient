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
    private BdUniqueId aiz;
    private InterfaceC0715a ilq;
    private c imp;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a ers = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.aiz) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || y.isEmpty(cVar.imm))) {
                            if (a.this.ilq != null) {
                                a.this.ilq.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.imp.iml = cVar.iml;
                            a.this.imp.imm.addAll(cVar.imm);
                            a.this.imp.imn = cVar.imn;
                            a.this.imp.gJZ = cVar.gJZ;
                            a.this.imp.imo = cVar.imo;
                            a.this.imp.imd = cVar.imd;
                            if (y.isEmpty(cVar.imm)) {
                                a.this.imp.hasMore = false;
                            } else {
                                a.this.imp.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.ilq != null) {
                                a.this.ilq.a(cVar);
                            }
                        }
                    } else if (a.this.ilq != null) {
                        a.this.ilq.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0715a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.aiz = bdUniqueId;
        this.ers.setTag(this.aiz);
        MessageManager.getInstance().registerListener(this.ers);
        bpw();
        bpx();
        this.imp = new c();
    }

    public void Jy(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.aiz);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void fx(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.aiz);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.imp;
    }

    public int csq() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.imp.hasMore;
    }

    private void bpw() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bpx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bL(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.aiz);
        MessageManager.getInstance().unRegisterListener(this.aiz);
    }

    public void a(InterfaceC0715a interfaceC0715a) {
        this.ilq = interfaceC0715a;
    }
}
