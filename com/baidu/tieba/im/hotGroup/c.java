package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.ResponseHotGroupsLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
final class c extends com.baidu.adp.framework.c.a {
    final /* synthetic */ HotGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HotGroupFragment hotGroupFragment, int i) {
        super(2001116);
        this.a = hotGroupFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        d dVar;
        d dVar2;
        HotGroupAdapter hotGroupAdapter;
        HotGroupAdapter hotGroupAdapter2;
        HotGroupAdapter hotGroupAdapter3;
        HotGroupAdapter hotGroupAdapter4;
        d dVar3;
        BdListView bdListView;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (!(customResponsedMessage2 instanceof ResponseHotGroupsLocalMessage)) {
            bdListView = this.a.a;
            bdListView.b();
            return;
        }
        dVar = this.a.f;
        dVar.c(false);
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = (ResponseHotGroupsLocalMessage) customResponsedMessage2;
        if (customResponsedMessage2.g() == 2001116) {
            List<GroupInfoData> b = responseHotGroupsLocalMessage.b();
            if (b != null) {
                hotGroupAdapter = this.a.e;
                hotGroupAdapter.a(b);
                hotGroupAdapter2 = this.a.e;
                hotGroupAdapter2.notifyDataSetChanged();
                hotGroupAdapter3 = this.a.e;
                hotGroupAdapter3.a(true);
                hotGroupAdapter4 = this.a.e;
                hotGroupAdapter4.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                dVar3 = this.a.f;
                dVar3.a(false);
            }
            dVar2 = this.a.f;
            dVar2.d(false);
        }
    }
}
