package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
final class f extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MyGroupFragment myGroupFragment, int i) {
        super(0);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        a aVar;
        a aVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (this.a.getActivity() == null || this.a.b == null) {
            return;
        }
        jVar = this.a.d;
        if (jVar == null) {
            return;
        }
        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage2;
        if (responseGroupsByUidLocalMessage.e() != 0) {
            if (responseGroupsByUidLocalMessage.e() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.f())) {
                return;
            }
            this.a.a(responseGroupsByUidLocalMessage.f());
            return;
        }
        List<GroupInfoData> b = responseGroupsByUidLocalMessage.b();
        if (b != null) {
            aVar = this.a.f;
            aVar.a(b);
            aVar2 = this.a.f;
            aVar2.notifyDataSetChanged();
            if (b.size() > 0) {
                enterGuideCenterView2 = this.a.g;
                enterGuideCenterView2.setVisibility(8);
                this.a.a();
            } else {
                enterGuideCenterView = this.a.g;
                enterGuideCenterView.setVisibility(0);
            }
        }
        jVar2 = this.a.d;
        if (jVar2 != null) {
            jVar3 = this.a.d;
            jVar3.a();
        }
    }
}
