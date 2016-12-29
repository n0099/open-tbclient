package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends s {
    private final CustomMessageListener bIg;

    public b(FrsActivity frsActivity) {
        super(frsActivity);
        this.bIg = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.bFI.registerListener(this.bIg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akZ && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().akY && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.bFI.getUniqueId())) {
            this.bFI.showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<v> threadList;
        com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
        if (WF != null && (threadList = WF.getThreadList()) != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                v next = it.next();
                if (next instanceof bg) {
                    bg bgVar = (bg) next;
                    if (bgVar.getAuthor() != null && bgVar.getAuthor().getUserId() != null && bgVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bgVar.getAuthor().equals(metaData2)) {
                        a(bgVar, updateAttentionMessage);
                        metaData2 = bgVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(bg bgVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        if (bgVar != null && bgVar.getAuthor() != null && bgVar.getAuthor().getUserId() != null && bgVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bgVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
            } else {
                i = fansNum - 1;
            }
            bgVar.getAuthor().setFansNum(i);
            if (bgVar.getAuthor().getGodUserData() != null) {
                bgVar.getAuthor().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                bgVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }
}
