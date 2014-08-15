package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        b bVar;
        b bVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        if (this.a.getActivity() != null && this.a.b != null) {
            jVar = this.a.d;
            if (jVar != null) {
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
                if (groups != null) {
                    bVar = this.a.f;
                    bVar.a(groups);
                    bVar2 = this.a.f;
                    bVar2.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        enterGuideCenterView2 = this.a.g;
                        enterGuideCenterView2.b(8);
                    } else {
                        enterGuideCenterView = this.a.g;
                        enterGuideCenterView.b(0);
                    }
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.a.c = false;
                } else if (socketResponsedMessage.getCmd() == 2001106) {
                    jVar2 = this.a.d;
                    if (jVar2 != null) {
                        jVar3 = this.a.d;
                        jVar3.a();
                    }
                }
            }
        }
    }
}
