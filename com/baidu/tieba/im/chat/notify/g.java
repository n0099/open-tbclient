package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ f a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = fVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.b != null) {
            this.b.setUnReadCount(0);
            if (this.b.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                com.baidu.tieba.im.db.d.a().a("apply_join_group");
            } else if (this.b.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.a().a("group_intro_change");
                com.baidu.tieba.im.db.d.a().a("group_name_change");
                com.baidu.tieba.im.db.d.a().a("group_notice_change");
                com.baidu.tieba.im.db.d.a().a("group_level_up");
                com.baidu.tieba.im.db.d.a().a("dismiss_group");
                com.baidu.tieba.im.db.d.a().a("kick_out");
                com.baidu.tieba.im.db.d.a().a("group_activitys_change");
            } else if (this.b.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.a().a("live_notify");
            }
        }
        return null;
    }
}
