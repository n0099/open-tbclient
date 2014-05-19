package com.baidu.tieba.im.hotGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ HotGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HotGroupFragment hotGroupFragment, int i) {
        super(i);
        this.a = hotGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        HotGroupActivity hotGroupActivity;
        BdListView bdListView;
        d dVar;
        d dVar2;
        BdListView bdListView2;
        d dVar3;
        d dVar4;
        HotGroupAdapter hotGroupAdapter;
        HotGroupAdapter hotGroupAdapter2;
        HotGroupAdapter hotGroupAdapter3;
        HotGroupAdapter hotGroupAdapter4;
        HotGroupAdapter hotGroupAdapter5;
        HotGroupAdapter hotGroupAdapter6;
        HotGroupAdapter hotGroupAdapter7;
        HotGroupAdapter hotGroupAdapter8;
        BdListView bdListView3;
        hotGroupActivity = this.a.d;
        if (hotGroupActivity != null) {
            bdListView = this.a.b;
            if (bdListView != null) {
                dVar = this.a.g;
                if (dVar != null) {
                    if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                        ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                        if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                            this.a.g();
                            return;
                        }
                    }
                    if (!(socketResponsedMessage instanceof ResponseHotGroupsMessage)) {
                        bdListView3 = this.a.b;
                        bdListView3.c();
                        return;
                    }
                    ResponseHotGroupsMessage responseHotGroupsMessage = (ResponseHotGroupsMessage) socketResponsedMessage;
                    dVar2 = this.a.g;
                    dVar2.c(false);
                    if (socketResponsedMessage.getCmd() == 103012) {
                        bdListView2 = this.a.b;
                        bdListView2.c();
                        if (responseHotGroupsMessage.getError() != 0) {
                            if (responseHotGroupsMessage.getError() > 0 && !TextUtils.isEmpty(responseHotGroupsMessage.getErrorString())) {
                                this.a.b(responseHotGroupsMessage.getErrorString());
                            }
                        } else if (responseHotGroupsMessage.getOrginalMessage() instanceof RequestHotGroupsMessage) {
                            RequestHotGroupsMessage requestHotGroupsMessage = (RequestHotGroupsMessage) responseHotGroupsMessage.getOrginalMessage();
                            List<GroupInfoData> groups = responseHotGroupsMessage.getGroups();
                            if (groups != null) {
                                if (requestHotGroupsMessage.isFirstPage()) {
                                    hotGroupAdapter8 = this.a.f;
                                    hotGroupAdapter8.b();
                                }
                                dVar3 = this.a.g;
                                dVar3.a(responseHotGroupsMessage.getHasMore());
                                dVar4 = this.a.g;
                                if (dVar4.a()) {
                                    hotGroupAdapter7 = this.a.f;
                                    hotGroupAdapter7.a(HotGroupAdapter.BOTTOM_TYPE.HAVE_MORE);
                                } else if (!requestHotGroupsMessage.isFirstPage()) {
                                    hotGroupAdapter = this.a.f;
                                    hotGroupAdapter.a(HotGroupAdapter.BOTTOM_TYPE.NO_MORE);
                                } else if (groups.size() == 0) {
                                    hotGroupAdapter3 = this.a.f;
                                    hotGroupAdapter3.a(false);
                                    return;
                                } else {
                                    hotGroupAdapter2 = this.a.f;
                                    hotGroupAdapter2.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                                }
                                if (groups.size() > 0) {
                                    hotGroupAdapter4 = this.a.f;
                                    hotGroupAdapter4.a(groups);
                                    hotGroupAdapter5 = this.a.f;
                                    hotGroupAdapter5.notifyDataSetChanged();
                                    this.a.h();
                                    hotGroupAdapter6 = this.a.f;
                                    hotGroupAdapter6.a(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
