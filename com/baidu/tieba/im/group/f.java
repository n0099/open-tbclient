package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        q qVar;
        q qVar2;
        com.baidu.tieba.im.mygroup.j jVar;
        q qVar3;
        q qVar4;
        qVar = this.a.c;
        qVar.c();
        if ((socketResponsedMessage instanceof ResponseGroupsByUidMessage) && this.a.getActivity() != null) {
            qVar2 = this.a.c;
            if (qVar2 != null) {
                jVar = this.a.e;
                if (jVar != null) {
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
                        qVar3 = this.a.c;
                        qVar3.a().a(groups);
                        qVar4 = this.a.c;
                        qVar4.a().notifyDataSetChanged();
                    }
                    this.a.b = false;
                }
            }
        }
    }
}
