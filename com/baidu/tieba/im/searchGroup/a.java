package com.baidu.tieba.im.searchGroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ AddGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddGroupActivity addGroupActivity, int i) {
        super(103007);
        this.a = addGroupActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        b bVar;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        bVar = this.a.a;
        bVar.a(false);
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 103007) {
            this.a.showToast(com.baidu.tieba.im.j.add_group_toast_noresult);
            return;
        }
        if (socketResponsedMessage2 instanceof ResponseSearchGroupMessage) {
            ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage2;
            if (responseSearchGroupMessage.e() != 0) {
                AddGroupActivity.a(this.a, responseSearchGroupMessage.f(), responseSearchGroupMessage.e());
                return;
            }
            List<BaseGroupData> d = responseSearchGroupMessage.d();
            if (d != null && d.size() > 0) {
                AddGroupActivity.a(this.a, d.get(0));
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.im.j.add_group_toast_noresult);
    }
}
