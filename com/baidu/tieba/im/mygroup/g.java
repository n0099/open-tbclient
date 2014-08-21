package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        k kVar;
        k kVar2;
        k kVar3;
        c cVar;
        c cVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        if (this.a.getActivity() != null && this.a.b != null) {
            kVar = this.a.d;
            if (kVar != null) {
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
                    cVar = this.a.f;
                    cVar.a(groups);
                    cVar2 = this.a.f;
                    cVar2.notifyDataSetChanged();
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
                    kVar2 = this.a.d;
                    if (kVar2 != null) {
                        kVar3 = this.a.d;
                        kVar3.a();
                    }
                }
            }
        }
    }
}
