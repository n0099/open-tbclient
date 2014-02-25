package com.baidu.tieba.im.hotGroup;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.message.cd;
import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.messageCenter.g;
import java.util.List;
/* loaded from: classes.dex */
class b implements g {
    final /* synthetic */ HotGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HotGroupFragment hotGroupFragment) {
        this.a = hotGroupFragment;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
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
        hotGroupActivity = this.a.d;
        if (hotGroupActivity != null) {
            bdListView = this.a.b;
            if (bdListView != null) {
                cVar = this.a.g;
                if (cVar != null) {
                    if (sVar instanceof cy) {
                        cy cyVar = (cy) sVar;
                        if (!cyVar.l() || cyVar.m() == 2230110) {
                            this.a.d();
                            return;
                        }
                    }
                    if (!(sVar instanceof cd)) {
                        bdListView3 = this.a.b;
                        bdListView3.a();
                        return;
                    }
                    cd cdVar = (cd) sVar;
                    cVar2 = this.a.g;
                    cVar2.c(false);
                    if (sVar.w() == 103012) {
                        bdListView2 = this.a.b;
                        bdListView2.a();
                        if (cdVar.l()) {
                            if (cdVar.m() > 0 && !TextUtils.isEmpty(cdVar.n())) {
                                this.a.a(cdVar.n());
                            }
                        } else if (cdVar.o() instanceof aq) {
                            aq aqVar = (aq) cdVar.o();
                            List<GroupInfoData> a = cdVar.a();
                            if (a != null) {
                                if (aqVar.f()) {
                                    hotGroupAdapter12 = this.a.f;
                                    hotGroupAdapter12.b();
                                }
                                cVar5 = this.a.g;
                                cVar5.a(cdVar.b());
                                cVar6 = this.a.g;
                                if (cVar6.a()) {
                                    hotGroupAdapter11 = this.a.f;
                                    hotGroupAdapter11.a(HotGroupAdapter.BOTTOM_TYPE.HAVE_MORE);
                                } else if (!aqVar.f()) {
                                    hotGroupAdapter5 = this.a.f;
                                    hotGroupAdapter5.a(HotGroupAdapter.BOTTOM_TYPE.NO_MORE);
                                } else if (a.size() == 0) {
                                    hotGroupAdapter7 = this.a.f;
                                    hotGroupAdapter7.a(false);
                                    return;
                                } else {
                                    hotGroupAdapter6 = this.a.f;
                                    hotGroupAdapter6.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                                }
                                if (a.size() > 0) {
                                    hotGroupAdapter8 = this.a.f;
                                    hotGroupAdapter8.a(a);
                                    hotGroupAdapter9 = this.a.f;
                                    hotGroupAdapter9.notifyDataSetChanged();
                                    this.a.e();
                                    hotGroupAdapter10 = this.a.f;
                                    hotGroupAdapter10.a(true);
                                }
                            }
                        }
                    } else if (sVar.w() == -116) {
                        List<GroupInfoData> a2 = cdVar.a();
                        if (a2 != null) {
                            hotGroupAdapter = this.a.f;
                            hotGroupAdapter.a(a2);
                            hotGroupAdapter2 = this.a.f;
                            hotGroupAdapter2.notifyDataSetChanged();
                            hotGroupAdapter3 = this.a.f;
                            hotGroupAdapter3.a(true);
                            hotGroupAdapter4 = this.a.f;
                            hotGroupAdapter4.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                            cVar4 = this.a.g;
                            cVar4.a(false);
                        }
                        cVar3 = this.a.g;
                        cVar3.d(false);
                    }
                }
            }
        }
    }
}
