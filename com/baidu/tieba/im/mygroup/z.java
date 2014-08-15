package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(v vVar, int i) {
        super(i);
        this.a = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonGroupActivity a;
        int i;
        t tVar;
        t tVar2;
        EnterGuideCenterView enterGuideCenterView;
        EnterGuideCenterView enterGuideCenterView2;
        a = this.a.a();
        if (this.a.getActivity() != null && this.a.b != null && a != null && a.j() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.a.b(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (a.i()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.a.h;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                a.b(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                if (groups != null) {
                    tVar = this.a.e;
                    tVar.a(groups);
                    tVar2 = this.a.e;
                    tVar2.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        enterGuideCenterView2 = this.a.f;
                        enterGuideCenterView2.b(8);
                    } else {
                        enterGuideCenterView = this.a.f;
                        enterGuideCenterView.b(0);
                    }
                    this.a.b.setVisibility(0);
                }
            }
            if (a.j() != null) {
                a.j().a();
            }
        }
    }
}
