package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
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
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        this.a.b(responseGroupsByUidLocalMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
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
                kVar2 = this.a.d;
                if (kVar2 != null) {
                    kVar3 = this.a.d;
                    kVar3.a();
                }
            }
        }
    }
}
