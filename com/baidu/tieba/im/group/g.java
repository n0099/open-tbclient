package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        q qVar;
        q qVar2;
        com.baidu.tieba.im.mygroup.j jVar;
        com.baidu.tieba.im.mygroup.j jVar2;
        q qVar3;
        com.baidu.tieba.im.mygroup.j jVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        q qVar7;
        q qVar8;
        if (!(customResponsedMessage instanceof ResponseGroupsByUidLocalMessage)) {
            qVar8 = this.a.c;
            qVar8.c();
            return;
        }
        if (this.a.getActivity() != null) {
            qVar2 = this.a.c;
            if (qVar2 != null) {
                jVar = this.a.e;
                if (jVar != null) {
                    ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                    if (responseGroupsByUidLocalMessage.getError() != 0) {
                        qVar7 = this.a.c;
                        qVar7.c();
                        if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                            this.a.b(responseGroupsByUidLocalMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (groups != null) {
                        qVar5 = this.a.c;
                        qVar5.a().a(groups);
                        qVar6 = this.a.c;
                        qVar6.a().notifyDataSetChanged();
                    }
                    jVar2 = this.a.e;
                    if (jVar2 == null) {
                        qVar3 = this.a.c;
                        qVar3.c();
                        return;
                    } else if (UtilHelper.getNetStatusInfo(this.a.getActivity()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                        qVar4 = this.a.c;
                        qVar4.c();
                        return;
                    } else {
                        jVar3 = this.a.e;
                        jVar3.a();
                        return;
                    }
                }
            }
        }
        qVar = this.a.c;
        qVar.c();
    }
}
