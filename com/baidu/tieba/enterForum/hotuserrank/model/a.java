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
/* loaded from: classes21.dex */
public class a {
    private BdUniqueId aih;
    private InterfaceC0667a hDW;
    private c hEV;
    private int mPageNum = 1;
    private com.baidu.adp.framework.listener.a dRa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652) { // from class: com.baidu.tieba.enterForum.hotuserrank.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.aih) {
                    c cVar = null;
                    if (responsedMessage instanceof HotUserRankHttpResMsg) {
                        cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                        cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() == 0) {
                        if (a.this.mPageNum == 1 && (cVar == null || y.isEmpty(cVar.hES))) {
                            if (a.this.hDW != null) {
                                a.this.hDW.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            }
                        } else if (cVar != null) {
                            a.this.hEV.hER = cVar.hER;
                            a.this.hEV.hES.addAll(cVar.hES);
                            a.this.hEV.hET = cVar.hET;
                            a.this.hEV.ghT = cVar.ghT;
                            a.this.hEV.hEU = cVar.hEU;
                            a.this.hEV.hEJ = cVar.hEJ;
                            if (y.isEmpty(cVar.hES)) {
                                a.this.hEV.hasMore = false;
                            } else {
                                a.this.hEV.hasMore = cVar.hasMore;
                                a.e(a.this);
                            }
                            if (a.this.hDW != null) {
                                a.this.hDW.a(cVar);
                            }
                        }
                    } else if (a.this.hDW != null) {
                        a.this.hDW.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.enterForum.hotuserrank.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0667a {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int e(a aVar) {
        int i = aVar.mPageNum;
        aVar.mPageNum = i + 1;
        return i;
    }

    public a(BdUniqueId bdUniqueId) {
        this.aih = bdUniqueId;
        this.dRa.setTag(this.aih);
        MessageManager.getInstance().registerListener(this.dRa);
        biu();
        biv();
        this.hEV = new c();
    }

    public void HV(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.aih);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void eJ(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.mPageNum;
        hotUserRankReqMsg.setTag(this.aih);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public c getPageData() {
        return this.hEV;
    }

    public int cjm() {
        return this.mPageNum;
    }

    public boolean hasMore() {
        return this.hEV.hasMore;
    }

    private void biu() {
        b bVar = new b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void biv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().removeMessage(this.aih);
        MessageManager.getInstance().unRegisterListener(this.aih);
    }

    public void a(InterfaceC0667a interfaceC0667a) {
        this.hDW = interfaceC0667a;
    }
}
