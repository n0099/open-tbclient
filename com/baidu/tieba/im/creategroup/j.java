package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
class j extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ CreateGroupStepActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(CreateGroupStepActivity createGroupStepActivity, int i) {
        super(i);
        this.a = createGroupStepActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103101) {
            this.a.a(false);
            if (!(socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                this.a.showToast(y.group_create_fail);
                return;
            }
            ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
            if (responseAddGroupMessage.getError() != 0) {
                this.a.a(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                return;
            }
            RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
            AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
            if (addGroupInfo == null) {
                this.a.showToast(y.group_create_fail);
                return;
            }
            int groupId = addGroupInfo.getGroupId();
            GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
            groupUpdateMessage.setGroupId(groupId);
            groupUpdateMessage.setName(requestAddGroupMessage.getName());
            groupUpdateMessage.setPortrait(requestAddGroupMessage.getPortrait());
            groupUpdateMessage.setLastMsgId(0L);
            groupUpdateMessage.setAuthorId(String.valueOf(addGroupInfo.getAuthorId()));
            List<GroupUpdateMessage> l = com.baidu.tieba.im.pushNotify.a.f().l();
            if (l != null) {
                Iterator<GroupUpdateMessage> it = l.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().getGroupId() == groupId) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    l.add(groupUpdateMessage);
                }
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(groupUpdateMessage);
                com.baidu.tieba.im.pushNotify.a.f().a(linkedList);
            }
            a(addGroupInfo);
        }
    }

    private void a(AddGroupInfoData addGroupInfoData) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.a.getResources().getString(y.group_create_name)) + ":" + addGroupInfoData.getName() + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(String.valueOf(this.a.getResources().getString(y.group_create_number)) + ":" + addGroupInfoData.getGroupId() + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(this.a.getResources().getString(y.group_create_share));
        new AlertDialog.Builder(this.a).setTitle(y.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(y.group_create_step_done_tip, new k(this)).setNegativeButton(y.group_create_step_share_tip, new l(this, addGroupInfoData)).create().show();
    }
}
