package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ h aQD;
    private final /* synthetic */ ImMessageCenterShowItemData aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aQD = hVar;
        this.aQE = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.aQE != null) {
            this.aQE.setUnReadCount(0);
            if (this.aQE.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                com.baidu.tieba.im.db.d.Mx().fY("apply_join_group");
            } else if (this.aQE.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Mx().fY("group_intro_change");
                com.baidu.tieba.im.db.d.Mx().fY("group_name_change");
                com.baidu.tieba.im.db.d.Mx().fY("group_notice_change");
                com.baidu.tieba.im.db.d.Mx().fY("group_level_up");
                com.baidu.tieba.im.db.d.Mx().fY("dismiss_group");
                com.baidu.tieba.im.db.d.Mx().fY("kick_out");
                com.baidu.tieba.im.db.d.Mx().fY("group_activitys_change");
            } else if (this.aQE.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Mx().fY("live_notify");
            }
        }
        return null;
    }
}
