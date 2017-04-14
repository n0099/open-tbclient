package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends w {
    private final CustomMessageListener aZX;

    public b(FrsActivity frsActivity) {
        super(frsActivity);
        this.aZX = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bST.registerListener(this.aZX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apU && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bST.getUniqueId())) {
            this.bST.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
        if (Zr != null && (threadList = Zr.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bi) {
                    bi biVar = (bi) next;
                    if (biVar.getAuthor() != null && biVar.getAuthor().getUserId() != null && biVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !biVar.getAuthor().equals(metaData2)) {
                        a(biVar, updateAttentionMessage);
                        metaData2 = biVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bi biVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (biVar != null && biVar.getAuthor() != null && biVar.getAuthor().getUserId() != null && biVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = biVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            biVar.getAuthor().setFansNum(i);
            if (biVar.getAuthor().getGodUserData() != null) {
                biVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                biVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
