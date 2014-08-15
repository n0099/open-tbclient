package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.a = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonGroupActivity a;
        int i;
        t tVar;
        t tVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        a = this.a.a();
        if (this.a.getActivity() != null && this.a.b != null && a != null && a.j() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.a.b.d();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrorString())) {
                    this.a.b(responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.a.h;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!a.i()) {
                a.a(responseGroupsByUidMessage.getGroups());
                a.b(responseGroupsByUidMessage.getCommonGroups());
            }
            a.b(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                tVar = this.a.e;
                tVar.a(groups);
                tVar2 = this.a.e;
                tVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    enterGuideCenterView2 = this.a.f;
                    enterGuideCenterView2.b(8);
                } else {
                    enterGuideCenterView = this.a.f;
                    enterGuideCenterView.b(0);
                }
                this.a.b.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.a.c = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && a.j() != null) {
                a.j().a();
            }
        }
    }
}
