package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends w {
    private final CustomMessageListener bbM;

    public b(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bbM = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bTw.registerListener(this.bbM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apG && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bTw.getUniqueId())) {
            this.bTw.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
        if (aau != null && (threadList = aau.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bl) {
                    bl blVar = (bl) next;
                    if (blVar.getAuthor() != null && blVar.getAuthor().getUserId() != null && blVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !blVar.getAuthor().equals(metaData2)) {
                        a(blVar, updateAttentionMessage);
                        metaData2 = blVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bl blVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (blVar != null && blVar.getAuthor() != null && blVar.getAuthor().getUserId() != null && blVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = blVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            blVar.getAuthor().setFansNum(i);
            if (blVar.getAuthor().getGodUserData() != null) {
                blVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                blVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
