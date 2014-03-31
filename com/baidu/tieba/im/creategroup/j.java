package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.framework.c.g {
    final /* synthetic */ CreateGroupStepActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(CreateGroupStepActivity createGroupStepActivity, int i) {
        super(0);
        this.a = createGroupStepActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 103101) {
            return;
        }
        this.a.a(false);
        if (!(socketResponsedMessage2 instanceof ResponseAddGroupMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.group_create_fail);
            return;
        }
        ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage2;
        if (responseAddGroupMessage.e() != 0) {
            CreateGroupStepActivity.a(this.a, responseAddGroupMessage.f(), responseAddGroupMessage.e());
            return;
        }
        y yVar = (y) responseAddGroupMessage.h();
        AddGroupInfoData d = responseAddGroupMessage.d();
        if (d == null) {
            this.a.showToast(com.baidu.tieba.im.j.group_create_fail);
            return;
        }
        int groupId = d.getGroupId();
        GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
        groupUpdateMessage.setGroupId(groupId);
        groupUpdateMessage.setName(yVar.i());
        groupUpdateMessage.setPortrait(yVar.j());
        groupUpdateMessage.setLastMsgId(0L);
        groupUpdateMessage.setAuthorId(String.valueOf(d.getAuthorId()));
        List<GroupUpdateMessage> g = com.baidu.tieba.im.pushNotify.a.d().g();
        if (g != null) {
            Iterator<GroupUpdateMessage> it = g.iterator();
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
                g.add(groupUpdateMessage);
            }
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(groupUpdateMessage);
            com.baidu.tieba.im.pushNotify.a.d().a(linkedList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.a.getResources().getString(com.baidu.tieba.im.j.group_create_name)) + ":" + d.getName() + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(String.valueOf(this.a.getResources().getString(com.baidu.tieba.im.j.group_create_number)) + ":" + d.getGroupId() + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(this.a.getResources().getString(com.baidu.tieba.im.j.group_create_share));
        new AlertDialog.Builder(this.a).setTitle(com.baidu.tieba.im.j.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(com.baidu.tieba.im.j.group_create_step_done_tip, new k(this)).setNegativeButton(com.baidu.tieba.im.j.group_create_step_share_tip, new l(this, d)).create().show();
    }
}
