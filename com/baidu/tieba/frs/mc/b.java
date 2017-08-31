package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends i {
    private final CustomMessageListener bgO;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.bgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof UpdateAttentionMessage) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                        if (updateAttentionMessage.getData().BW) {
                            b.this.b(updateAttentionMessage);
                            b.this.cvA.a(updateAttentionMessage);
                            b.this.c(updateAttentionMessage);
                        } else if (updateAttentionMessage.getData().errorString != null) {
                            b.this.cvA.showToast(updateAttentionMessage.getData().errorString);
                        }
                    }
                }
            }
        };
        this.cvA.registerListener(this.bgO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asy && !StringUtils.isNull(updateAttentionMessage.getData().asz, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.cvA.getUniqueId())) {
            this.cvA.showToast(updateAttentionMessage.getData().asz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i ahf = this.cvA.ahf();
        if (ahf != null && (threadList = ahf.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                MetaData metaData2 = metaData;
                if (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next instanceof bj) {
                        bj bjVar = (bj) next;
                        if (bjVar.getAuthor() != null && bjVar.getAuthor().getUserId() != null && bjVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bjVar.getAuthor().equals(metaData2)) {
                            a(bjVar, updateAttentionMessage);
                            metaData2 = bjVar.getAuthor();
                        }
                    }
                    metaData = metaData2;
                } else {
                    return;
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
