package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends z {
    private final CustomMessageListener bdP;

    public b(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bdP = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.cbE.registerListener(this.bdP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().aqH && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.cbE.getUniqueId())) {
            this.cbE.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList;
        com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
        if (aek != null && (threadList = aek.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof bm) {
                    bm bmVar = (bm) next;
                    if (bmVar.getAuthor() != null && bmVar.getAuthor().getUserId() != null && bmVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bmVar.getAuthor().equals(metaData2)) {
                        a(bmVar, updateAttentionMessage);
                        metaData2 = bmVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bm bmVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (bmVar != null && bmVar.getAuthor() != null && bmVar.getAuthor().getUserId() != null && bmVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bmVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            bmVar.getAuthor().setFansNum(i);
            if (bmVar.getAuthor().getGodUserData() != null) {
                bmVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                bmVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
