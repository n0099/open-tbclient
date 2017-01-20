package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends r {
    private final CustomMessageListener aTR;

    public b(FrsActivity frsActivity) {
        super(frsActivity);
        this.aTR = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bLZ.registerListener(this.aTR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akj && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().isAttention && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bLZ.getUniqueId())) {
            this.bLZ.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<v> threadList;
        com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
        if (XW != null && (threadList = XW.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                v next = it.next();
                if (next instanceof bh) {
                    bh bhVar = (bh) next;
                    if (bhVar.getAuthor() != null && bhVar.getAuthor().getUserId() != null && bhVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bhVar.getAuthor().equals(metaData2)) {
                        a(bhVar, updateAttentionMessage);
                        metaData2 = bhVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bh bhVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (bhVar != null && bhVar.getAuthor() != null && bhVar.getAuthor().getUserId() != null && bhVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bhVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            bhVar.getAuthor().setFansNum(i);
            if (bhVar.getAuthor().getGodUserData() != null) {
                bhVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                bhVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
