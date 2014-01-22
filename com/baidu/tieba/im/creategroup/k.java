package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.aa;
import com.baidu.tieba.im.message.bg;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ CreateGroupStepActivity a;

    public k(CreateGroupStepActivity createGroupStepActivity) {
        this.a = createGroupStepActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        boolean z;
        if (qVar != null && qVar.w() == 103101) {
            this.a.a(false);
            if (!(qVar instanceof bg)) {
                this.a.showToast(R.string.group_create_fail);
                return;
            }
            bg bgVar = (bg) qVar;
            if (bgVar.k()) {
                this.a.a(bgVar.m(), bgVar.l());
                return;
            }
            aa aaVar = (aa) bgVar.n();
            AddGroupInfoData a = bgVar.a();
            if (a == null) {
                this.a.showToast(R.string.group_create_fail);
                return;
            }
            int groupId = a.getGroupId();
            GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
            groupUpdateMessage.setGroupId(groupId);
            groupUpdateMessage.setName(aaVar.c());
            groupUpdateMessage.setPortrait(aaVar.e());
            groupUpdateMessage.setLastMsgId(0L);
            groupUpdateMessage.setAuthorId(String.valueOf(a.getAuthorId()));
            List<GroupUpdateMessage> m = com.baidu.tieba.im.c.a.h().m();
            if (m != null) {
                Iterator<GroupUpdateMessage> it = m.iterator();
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
                    m.add(groupUpdateMessage);
                }
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(groupUpdateMessage);
                com.baidu.tieba.im.c.a.h().a(linkedList);
            }
            a(a);
        }
    }

    private void a(AddGroupInfoData addGroupInfoData) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.getResources().getString(R.string.group_create_name) + ":" + addGroupInfoData.getName() + "\n");
        sb.append(this.a.getResources().getString(R.string.group_create_number) + ":" + addGroupInfoData.getGroupId() + "\n");
        sb.append(this.a.getResources().getString(R.string.group_create_share));
        new AlertDialog.Builder(this.a).setTitle(R.string.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(R.string.group_create_step_done_tip, new m(this)).setNegativeButton(R.string.group_create_step_share_tip, new l(this, addGroupInfoData)).create().show();
    }
}
