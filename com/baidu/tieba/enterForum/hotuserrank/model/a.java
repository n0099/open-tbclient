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
/* loaded from: classes16.dex */
public class a {
    private BdUniqueId ahK;
    private InterfaceC0670a hwM;
    private c hxN;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a dOR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.ahK) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || y.isEmpty(cVar.hxK))) {
                            if (a.this.hwM != null) {
                                a.this.hwM.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.hxN.hxJ = cVar.hxJ;
                            a.this.hxN.hxK.addAll(cVar.hxK);
                            a.this.hxN.hxL = cVar.hxL;
                            a.this.hxN.geE = cVar.geE;
                            a.this.hxN.hxM = cVar.hxM;
                            a.this.hxN.hxB = cVar.hxB;
                            if (y.isEmpty(cVar.hxK)) {
                                a.this.hxN.hasMore = false;
                            } else {
                                a.this.hxN.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.hwM != null) {
                                a.this.hwM.a(cVar);
                            }
                        }
                    } else if (a.this.hwM != null) {
                        a.this.hwM.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0670a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.ahK = bdUniqueId;
        this.dOR.setTag(this.ahK);
        MessageManager.getInstance().registerListener(this.dOR);
        bhA();
        bhB();
        this.hxN = new c();
    }

    public void Hx(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ahK);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void ez(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.ahK);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.hxN;
    }

    public int cfU() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.hxN.hasMore;
    }

    private void bhA() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bhB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.ahK);
        MessageManager.getInstance().unRegisterListener(this.ahK);
    }

    public void a(InterfaceC0670a interfaceC0670a) {
        this.hwM = interfaceC0670a;
    }
}
