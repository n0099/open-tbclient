package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.framework.c.a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        q qVar;
        q qVar2;
        q qVar3;
        com.baidu.tieba.im.mygroup.j jVar;
        com.baidu.tieba.im.mygroup.j jVar2;
        com.baidu.tieba.im.mygroup.j jVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof ResponseGroupsByUidLocalMessage) {
            if (this.a.getActivity() != null) {
                qVar3 = this.a.c;
                if (qVar3 != null) {
                    jVar = this.a.e;
                    if (jVar != null) {
                        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage2;
                        if (responseGroupsByUidLocalMessage.e() != 0) {
                            qVar6 = this.a.c;
                            qVar6.c();
                            if (responseGroupsByUidLocalMessage.e() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.f())) {
                                return;
                            }
                            this.a.a(responseGroupsByUidLocalMessage.f());
                            return;
                        }
                        List<GroupInfoData> b = responseGroupsByUidLocalMessage.b();
                        if (b != null) {
                            qVar4 = this.a.c;
                            qVar4.a().a(b);
                            qVar5 = this.a.c;
                            qVar5.a().notifyDataSetChanged();
                        }
                        jVar2 = this.a.e;
                        if (jVar2 != null && UtilHelper.d(this.a.getActivity()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                            jVar3 = this.a.e;
                            jVar3.a();
                            return;
                        }
                    }
                }
            }
            qVar2 = this.a.c;
            qVar2.c();
            return;
        }
        qVar = this.a.c;
        qVar.c();
    }
}
