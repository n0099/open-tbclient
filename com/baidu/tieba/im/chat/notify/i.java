package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ h aSv;
    private final /* synthetic */ ImMessageCenterShowItemData aSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.aSv = hVar;
        this.aSw = imMessageCenterShowItemData;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && this.aSw != null) {
            this.aSw.setUnReadCount(0);
            if (this.aSw.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.Mv().gn("apply_join_group");
            } else if (this.aSw.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.db.d.Mv().gn("group_intro_change");
                com.baidu.tieba.im.db.d.Mv().gn("group_name_change");
                com.baidu.tieba.im.db.d.Mv().gn("group_notice_change");
                com.baidu.tieba.im.db.d.Mv().gn("group_level_up");
                com.baidu.tieba.im.db.d.Mv().gn("dismiss_group");
                com.baidu.tieba.im.db.d.Mv().gn("kick_out");
                com.baidu.tieba.im.db.d.Mv().gn("group_activitys_change");
            } else if (this.aSw.getOwnerName().equals("6")) {
                com.baidu.tieba.im.db.d.Mv().gn("live_notify");
            }
        }
        return null;
    }
}
