package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.ResponseHotGroupsLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ HotGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HotGroupFragment hotGroupFragment, int i) {
        super(i);
        this.a = hotGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d dVar;
        d dVar2;
        HotGroupAdapter hotGroupAdapter;
        HotGroupAdapter hotGroupAdapter2;
        HotGroupAdapter hotGroupAdapter3;
        HotGroupAdapter hotGroupAdapter4;
        d dVar3;
        BdListView bdListView;
        if (!(customResponsedMessage instanceof ResponseHotGroupsLocalMessage)) {
            bdListView = this.a.b;
            bdListView.c();
            return;
        }
        dVar = this.a.g;
        dVar.c(false);
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = (ResponseHotGroupsLocalMessage) customResponsedMessage;
        if (customResponsedMessage.getCmd() == 2003116) {
            List<GroupInfoData> groups = responseHotGroupsLocalMessage.getGroups();
            if (groups != null) {
                hotGroupAdapter = this.a.f;
                hotGroupAdapter.a(groups);
                hotGroupAdapter2 = this.a.f;
                hotGroupAdapter2.notifyDataSetChanged();
                hotGroupAdapter3 = this.a.f;
                hotGroupAdapter3.a(true);
                hotGroupAdapter4 = this.a.f;
                hotGroupAdapter4.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                dVar3 = this.a.g;
                dVar3.a(false);
            }
            dVar2 = this.a.g;
            dVar2.d(false);
        }
    }
}
