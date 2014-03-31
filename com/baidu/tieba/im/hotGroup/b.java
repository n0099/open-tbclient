package com.baidu.tieba.im.hotGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.c.g;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.an;
import java.util.List;
/* loaded from: classes.dex */
final class b extends g {
    final /* synthetic */ HotGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HotGroupFragment hotGroupFragment, int i) {
        super(0);
        this.a = hotGroupFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
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
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        hotGroupActivity = this.a.c;
        if (hotGroupActivity != null) {
            bdListView = this.a.a;
            if (bdListView != null) {
                dVar = this.a.f;
                if (dVar == null) {
                    return;
                }
                if (socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) {
                    ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage2;
                    if (responseUpgradeMemberGroupMessage.e() == 0 || responseUpgradeMemberGroupMessage.e() == 2230110) {
                        this.a.c();
                        return;
                    }
                }
                if (!(socketResponsedMessage2 instanceof ResponseHotGroupsMessage)) {
                    bdListView3 = this.a.a;
                    bdListView3.b();
                    return;
                }
                ResponseHotGroupsMessage responseHotGroupsMessage = (ResponseHotGroupsMessage) socketResponsedMessage2;
                dVar2 = this.a.f;
                dVar2.c(false);
                if (socketResponsedMessage2.g() == 103012) {
                    bdListView2 = this.a.a;
                    bdListView2.b();
                    if (responseHotGroupsMessage.e() != 0) {
                        if (responseHotGroupsMessage.e() <= 0 || TextUtils.isEmpty(responseHotGroupsMessage.f())) {
                            return;
                        }
                        this.a.showToast(responseHotGroupsMessage.f());
                    } else if (responseHotGroupsMessage.h() instanceof an) {
                        an anVar = (an) responseHotGroupsMessage.h();
                        List<GroupInfoData> d = responseHotGroupsMessage.d();
                        if (d != null) {
                            if (anVar.i()) {
                                hotGroupAdapter8 = this.a.e;
                                hotGroupAdapter8.b();
                            }
                            dVar3 = this.a.f;
                            dVar3.a(responseHotGroupsMessage.i());
                            dVar4 = this.a.f;
                            if (dVar4.a()) {
                                hotGroupAdapter7 = this.a.e;
                                hotGroupAdapter7.a(HotGroupAdapter.BOTTOM_TYPE.HAVE_MORE);
                            } else if (!anVar.i()) {
                                hotGroupAdapter = this.a.e;
                                hotGroupAdapter.a(HotGroupAdapter.BOTTOM_TYPE.NO_MORE);
                            } else if (d.size() == 0) {
                                hotGroupAdapter3 = this.a.e;
                                hotGroupAdapter3.a(false);
                                return;
                            } else {
                                hotGroupAdapter2 = this.a.e;
                                hotGroupAdapter2.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                            }
                            if (d.size() > 0) {
                                hotGroupAdapter4 = this.a.e;
                                hotGroupAdapter4.a(d);
                                hotGroupAdapter5 = this.a.e;
                                hotGroupAdapter5.notifyDataSetChanged();
                                this.a.d();
                                hotGroupAdapter6 = this.a.e;
                                hotGroupAdapter6.a(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
