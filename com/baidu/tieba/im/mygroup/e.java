package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* loaded from: classes.dex */
final class e extends com.baidu.adp.framework.c.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MyGroupFragment myGroupFragment, int i) {
        super(0);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        a aVar;
        a aVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (this.a.getActivity() == null || this.a.a == null) {
            return;
        }
        jVar = this.a.c;
        if (jVar == null) {
            return;
        }
        if (socketResponsedMessage2.g() == 103003) {
            this.a.a.b();
        }
        ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage2;
        if (responseGroupsByUidMessage.e() != 0) {
            if (responseGroupsByUidMessage.e() == 0 || TextUtils.isEmpty(responseGroupsByUidMessage.f())) {
                return;
            }
            this.a.showToast(responseGroupsByUidMessage.f());
            return;
        }
        List<GroupInfoData> d = responseGroupsByUidMessage.d();
        if (d != null) {
            aVar = this.a.e;
            aVar.a(d);
            aVar2 = this.a.e;
            aVar2.notifyDataSetChanged();
            if (d.size() > 0) {
                enterGuideCenterView2 = this.a.f;
                enterGuideCenterView2.setVisibility(8);
                this.a.a();
            } else {
                enterGuideCenterView = this.a.f;
                enterGuideCenterView.setVisibility(0);
            }
        }
        if (socketResponsedMessage2.g() == 103003) {
            this.a.b = false;
        } else if (socketResponsedMessage2.g() == 2001106) {
            jVar2 = this.a.c;
            if (jVar2 != null) {
                jVar3 = this.a.c;
                jVar3.a();
            }
        }
    }
}
