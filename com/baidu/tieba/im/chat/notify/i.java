package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ h aTE;
    private final /* synthetic */ ImMessageCenterShowItemData aTF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aTE = hVar;
        this.aTF = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.aTF != null) {
            this.aTF.setUnReadCount(0);
            if (this.aTF.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.MM().gp("apply_join_group");
            } else if (this.aTF.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.MM().gp("group_intro_change");
                com.baidu.tieba.im.db.d.MM().gp("group_name_change");
                com.baidu.tieba.im.db.d.MM().gp("group_notice_change");
                com.baidu.tieba.im.db.d.MM().gp("group_level_up");
                com.baidu.tieba.im.db.d.MM().gp("dismiss_group");
                com.baidu.tieba.im.db.d.MM().gp("kick_out");
                com.baidu.tieba.im.db.d.MM().gp("group_activitys_change");
            } else if (this.aTF.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.MM().gp("live_notify");
            }
        }
        return null;
    }
}
