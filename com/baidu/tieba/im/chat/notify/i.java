package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ h aTF;
    private final /* synthetic */ ImMessageCenterShowItemData aTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTF = hVar;
        this.aTG = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.aTG != null) {
            this.aTG.setUnReadCount(0);
            if (this.aTG.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.MR().gs("apply_join_group");
            } else if (this.aTG.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.MR().gs("group_intro_change");
                com.baidu.tieba.im.db.d.MR().gs("group_name_change");
                com.baidu.tieba.im.db.d.MR().gs("group_notice_change");
                com.baidu.tieba.im.db.d.MR().gs("group_level_up");
                com.baidu.tieba.im.db.d.MR().gs("dismiss_group");
                com.baidu.tieba.im.db.d.MR().gs("kick_out");
                com.baidu.tieba.im.db.d.MR().gs("group_activitys_change");
            } else if (this.aTG.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.MR().gs("live_notify");
            }
        }
        return null;
    }
}
