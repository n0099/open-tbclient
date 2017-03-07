package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends u {
    private final CustomMessageListener bad;

    public b(FrsActivity frsActivity) {
        super(frsActivity);
        this.bad = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bTf.registerListener(this.bad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apE && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bTf.getUniqueId())) {
            this.bTf.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        if (YV != null && (threadList = YV.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bj) {
                    bj bjVar = (bj) next;
                    if (bjVar.getAuthor() != null && bjVar.getAuthor().getUserId() != null && bjVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bjVar.getAuthor().equals(metaData2)) {
                        a(bjVar, updateAttentionMessage);
                        metaData2 = bjVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bj bjVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (bjVar != null && bjVar.getAuthor() != null && bjVar.getAuthor().getUserId() != null && bjVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bjVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            bjVar.getAuthor().setFansNum(i);
            if (bjVar.getAuthor().getGodUserData() != null) {
                bjVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                bjVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
