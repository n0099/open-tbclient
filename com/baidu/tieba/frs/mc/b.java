package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends i {
    private final CustomMessageListener bgL;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.bgL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof UpdateAttentionMessage) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                        if (updateAttentionMessage.getData().Ea) {
                            b.this.b(updateAttentionMessage);
                            b.this.f5com.a(updateAttentionMessage);
                            b.this.c(updateAttentionMessage);
                        } else if (updateAttentionMessage.getData().errorString != null) {
                            b.this.f5com.showToast(updateAttentionMessage.getData().errorString);
                        }
                    }
                }
            }
        };
        this.f5com.registerListener(this.bgL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().asQ && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.f5com.getUniqueId())) {
            this.f5com.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList;
        com.baidu.tieba.tbadkCore.i afr = this.f5com.afr();
        if (afr != null && (threadList = afr.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
            while (true) {
                MetaData metaData2 = metaData;
                if (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next instanceof bl) {
                        bl blVar = (bl) next;
                        if (blVar.getAuthor() != null && blVar.getAuthor().getUserId() != null && blVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !blVar.getAuthor().equals(metaData2)) {
                            a(blVar, updateAttentionMessage);
                            metaData2 = blVar.getAuthor();
                        }
                    }
                    metaData = metaData2;
                } else {
                    return;
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
