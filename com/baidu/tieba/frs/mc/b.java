package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends w {
    private final CustomMessageListener bax;

    public b(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bax = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bNK.registerListener(this.bax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apW && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bNK.getUniqueId())) {
            this.bNK.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
        if (Zq != null && (threadList = Zq.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bk) {
                    bk bkVar = (bk) next;
                    if (bkVar.getAuthor() != null && bkVar.getAuthor().getUserId() != null && bkVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bkVar.getAuthor().equals(metaData2)) {
                        a(bkVar, updateAttentionMessage);
                        metaData2 = bkVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bk bkVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (bkVar != null && bkVar.getAuthor() != null && bkVar.getAuthor().getUserId() != null && bkVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bkVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            bkVar.getAuthor().setFansNum(i);
            if (bkVar.getAuthor().getGodUserData() != null) {
                bkVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                bkVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
