package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        q qVar;
        q qVar2;
        com.baidu.tieba.im.mygroup.j jVar;
        q qVar3;
        q qVar4;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        qVar = this.a.b;
        qVar.c();
        if (!(socketResponsedMessage2 instanceof ResponseGroupsByUidMessage) || this.a.getActivity() == null) {
            return;
        }
        qVar2 = this.a.b;
        if (qVar2 != null) {
            jVar = this.a.d;
            if (jVar == null) {
                return;
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
                qVar3 = this.a.b;
                qVar3.a().a(d);
                qVar4 = this.a.b;
                qVar4.a().notifyDataSetChanged();
            }
            this.a.a = false;
        }
    }
}
