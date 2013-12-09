package com.baidu.tieba.im.hotGroup;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import com.baidu.tieba.im.messageCenter.g;
import java.util.List;
/* loaded from: classes.dex */
class b implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HotGroupFragment f1783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HotGroupFragment hotGroupFragment) {
        this.f1783a = hotGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        HotGroupActivity hotGroupActivity;
        BdListView bdListView;
        c cVar;
        c cVar2;
        c cVar3;
        HotGroupAdapter hotGroupAdapter;
        HotGroupAdapter hotGroupAdapter2;
        HotGroupAdapter hotGroupAdapter3;
        HotGroupAdapter hotGroupAdapter4;
        c cVar4;
        BdListView bdListView2;
        c cVar5;
        c cVar6;
        HotGroupAdapter hotGroupAdapter5;
        HotGroupAdapter hotGroupAdapter6;
        HotGroupAdapter hotGroupAdapter7;
        HotGroupAdapter hotGroupAdapter8;
        HotGroupAdapter hotGroupAdapter9;
        HotGroupAdapter hotGroupAdapter10;
        HotGroupAdapter hotGroupAdapter11;
        HotGroupAdapter hotGroupAdapter12;
        BdListView bdListView3;
        hotGroupActivity = this.f1783a.c;
        if (hotGroupActivity != null) {
            bdListView = this.f1783a.f1781a;
            if (bdListView != null) {
                cVar = this.f1783a.f;
                if (cVar != null) {
                    if (!(message instanceof ResponseHotGroupsMessage)) {
                        bdListView3 = this.f1783a.f1781a;
                        bdListView3.a();
                        return;
                    }
                    ResponseHotGroupsMessage responseHotGroupsMessage = (ResponseHotGroupsMessage) message;
                    cVar2 = this.f1783a.f;
                    cVar2.c(false);
                    if (message.getCmd() == 103012) {
                        bdListView2 = this.f1783a.f1781a;
                        bdListView2.a();
                        if (responseHotGroupsMessage.hasError()) {
                            if (responseHotGroupsMessage.getErrNo() > 0 && !TextUtils.isEmpty(responseHotGroupsMessage.getErrMsg())) {
                                this.f1783a.a(responseHotGroupsMessage.getErrMsg());
                            }
                        } else if (responseHotGroupsMessage.getOrginalMessage() instanceof RequestHotGroupsMessage) {
                            RequestHotGroupsMessage requestHotGroupsMessage = (RequestHotGroupsMessage) responseHotGroupsMessage.getOrginalMessage();
                            List<GroupInfoData> groups = responseHotGroupsMessage.getGroups();
                            if (groups != null) {
                                if (requestHotGroupsMessage.isFirstPage()) {
                                    hotGroupAdapter12 = this.f1783a.e;
                                    hotGroupAdapter12.b();
                                }
                                cVar5 = this.f1783a.f;
                                cVar5.a(responseHotGroupsMessage.getHasMore());
                                cVar6 = this.f1783a.f;
                                if (cVar6.a()) {
                                    hotGroupAdapter11 = this.f1783a.e;
                                    hotGroupAdapter11.a(HotGroupAdapter.BOTTOM_TYPE.HAVE_MORE);
                                } else if (!requestHotGroupsMessage.isFirstPage()) {
                                    hotGroupAdapter5 = this.f1783a.e;
                                    hotGroupAdapter5.a(HotGroupAdapter.BOTTOM_TYPE.NO_MORE);
                                } else if (groups.size() == 0) {
                                    hotGroupAdapter7 = this.f1783a.e;
                                    hotGroupAdapter7.a(false);
                                    return;
                                } else {
                                    hotGroupAdapter6 = this.f1783a.e;
                                    hotGroupAdapter6.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                                }
                                if (groups.size() > 0) {
                                    hotGroupAdapter8 = this.f1783a.e;
                                    hotGroupAdapter8.a(groups);
                                    hotGroupAdapter9 = this.f1783a.e;
                                    hotGroupAdapter9.notifyDataSetChanged();
                                    this.f1783a.I();
                                    hotGroupAdapter10 = this.f1783a.e;
                                    hotGroupAdapter10.a(true);
                                }
                            }
                        }
                    } else if (message.getCmd() == -116) {
                        List<GroupInfoData> groups2 = responseHotGroupsMessage.getGroups();
                        if (groups2 != null) {
                            hotGroupAdapter = this.f1783a.e;
                            hotGroupAdapter.a(groups2);
                            hotGroupAdapter2 = this.f1783a.e;
                            hotGroupAdapter2.notifyDataSetChanged();
                            hotGroupAdapter3 = this.f1783a.e;
                            hotGroupAdapter3.a(true);
                            hotGroupAdapter4 = this.f1783a.e;
                            hotGroupAdapter4.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                            cVar4 = this.f1783a.f;
                            cVar4.a(false);
                        }
                        cVar3 = this.f1783a.f;
                        cVar3.d(false);
                    }
                }
            }
        }
    }
}
