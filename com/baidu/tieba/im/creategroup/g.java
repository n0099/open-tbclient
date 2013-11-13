package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateGroupStepActivity f1586a;

    public g(CreateGroupStepActivity createGroupStepActivity) {
        this.f1586a = createGroupStepActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        boolean z;
        if (message != null && message.getCmd() == 103101) {
            this.f1586a.a(false);
            if (!(message instanceof ResponseAddGroupMessage)) {
                this.f1586a.showToast(R.string.group_create_fail);
                return;
            }
            ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) message;
            if (responseAddGroupMessage.hasError()) {
                this.f1586a.a(responseAddGroupMessage.getErrMsg(), responseAddGroupMessage.getErrNo());
                return;
            }
            RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
            AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
            if (addGroupInfo == null) {
                this.f1586a.showToast(R.string.group_create_fail);
                return;
            }
            int groupId = addGroupInfo.getGroupId();
            GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
            groupUpdateMessage.setGroupId(groupId);
            groupUpdateMessage.setName(requestAddGroupMessage.getName());
            groupUpdateMessage.setPortrait(requestAddGroupMessage.getPortrait());
            groupUpdateMessage.setLastMsgId(0L);
            groupUpdateMessage.setAuthorId(String.valueOf(addGroupInfo.getAuthorId()));
            List<GroupUpdateMessage> l = com.baidu.tieba.im.pushNotify.a.g().l();
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
                com.baidu.tieba.im.pushNotify.a.g().a(linkedList);
            }
            a(addGroupInfo);
        }
    }

    private void a(AddGroupInfoData addGroupInfoData) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1586a.getResources().getString(R.string.group_create_name) + ":" + addGroupInfoData.getName() + "\n");
        sb.append(this.f1586a.getResources().getString(R.string.group_create_number) + ":" + addGroupInfoData.getGroupId() + "\n");
        sb.append(this.f1586a.getResources().getString(R.string.group_create_share));
        new AlertDialog.Builder(this.f1586a).setTitle(R.string.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(R.string.group_create_step_done_tip, new i(this)).setNegativeButton(R.string.group_create_step_share_tip, new h(this, addGroupInfoData)).create().show();
    }
}
