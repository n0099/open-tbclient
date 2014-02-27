package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.ad;
import com.baidu.tieba.im.message.bm;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class j implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ CreateGroupStepActivity a;

    public j(CreateGroupStepActivity createGroupStepActivity) {
        this.a = createGroupStepActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        boolean z;
        if (sVar != null && sVar.w() == 103101) {
            this.a.a(false);
            if (!(sVar instanceof bm)) {
                this.a.showToast(R.string.group_create_fail);
                return;
            }
            bm bmVar = (bm) sVar;
            if (bmVar.l()) {
                CreateGroupStepActivity.a(this.a, bmVar.n(), bmVar.m());
                return;
            }
            ad adVar = (ad) bmVar.o();
            AddGroupInfoData a = bmVar.a();
            if (a == null) {
                this.a.showToast(R.string.group_create_fail);
                return;
            }
            int groupId = a.getGroupId();
            GroupUpdateMessage groupUpdateMessage = new GroupUpdateMessage();
            groupUpdateMessage.setGroupId(groupId);
            groupUpdateMessage.setName(adVar.b());
            groupUpdateMessage.setPortrait(adVar.c());
            groupUpdateMessage.setLastMsgId(0L);
            groupUpdateMessage.setAuthorId(String.valueOf(a.getAuthorId()));
            List<GroupUpdateMessage> g = com.baidu.tieba.im.c.a.d().g();
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
                com.baidu.tieba.im.c.a.d().a(linkedList);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.a.getResources().getString(R.string.group_create_name)) + ":" + a.getName() + IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(String.valueOf(this.a.getResources().getString(R.string.group_create_number)) + ":" + a.getGroupId() + IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(this.a.getResources().getString(R.string.group_create_share));
            new AlertDialog.Builder(this.a).setTitle(R.string.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(R.string.group_create_step_done_tip, new k(this)).setNegativeButton(R.string.group_create_step_share_tip, new l(this, a)).create().show();
        }
    }
}
