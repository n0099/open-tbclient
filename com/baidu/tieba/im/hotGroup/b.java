package com.baidu.tieba.im.hotGroup;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.hotGroup.HotGroupAdapter;
import com.baidu.tieba.im.message.ak;
import com.baidu.tieba.im.message.bu;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.q;
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
    public void a(q qVar) {
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
        hotGroupActivity = this.a.c;
        if (hotGroupActivity != null) {
            bdListView = this.a.a;
            if (bdListView != null) {
                cVar = this.a.f;
                if (cVar != null) {
                    if (qVar instanceof cp) {
                        cp cpVar = (cp) qVar;
                        if (!cpVar.k() || cpVar.l() == 2230110) {
                            this.a.H();
                            return;
                        }
                    }
                    if (!(qVar instanceof bu)) {
                        bdListView3 = this.a.a;
                        bdListView3.a();
                        return;
                    }
                    bu buVar = (bu) qVar;
                    cVar2 = this.a.f;
                    cVar2.c(false);
                    if (qVar.w() == 103012) {
                        bdListView2 = this.a.a;
                        bdListView2.a();
                        if (buVar.k()) {
                            if (buVar.l() > 0 && !TextUtils.isEmpty(buVar.m())) {
                                this.a.a(buVar.m());
                            }
                        } else if (buVar.n() instanceof ak) {
                            ak akVar = (ak) buVar.n();
                            List<GroupInfoData> a = buVar.a();
                            if (a != null) {
                                if (akVar.f()) {
                                    hotGroupAdapter12 = this.a.e;
                                    hotGroupAdapter12.b();
                                }
                                cVar5 = this.a.f;
                                cVar5.a(buVar.b());
                                cVar6 = this.a.f;
                                if (cVar6.a()) {
                                    hotGroupAdapter11 = this.a.e;
                                    hotGroupAdapter11.a(HotGroupAdapter.BOTTOM_TYPE.HAVE_MORE);
                                } else if (!akVar.f()) {
                                    hotGroupAdapter5 = this.a.e;
                                    hotGroupAdapter5.a(HotGroupAdapter.BOTTOM_TYPE.NO_MORE);
                                } else if (a.size() == 0) {
                                    hotGroupAdapter7 = this.a.e;
                                    hotGroupAdapter7.a(false);
                                    return;
                                } else {
                                    hotGroupAdapter6 = this.a.e;
                                    hotGroupAdapter6.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                                }
                                if (a.size() > 0) {
                                    hotGroupAdapter8 = this.a.e;
                                    hotGroupAdapter8.a(a);
                                    hotGroupAdapter9 = this.a.e;
                                    hotGroupAdapter9.notifyDataSetChanged();
                                    this.a.I();
                                    hotGroupAdapter10 = this.a.e;
                                    hotGroupAdapter10.a(true);
                                }
                            }
                        }
                    } else if (qVar.w() == -116) {
                        List<GroupInfoData> a2 = buVar.a();
                        if (a2 != null) {
                            hotGroupAdapter = this.a.e;
                            hotGroupAdapter.a(a2);
                            hotGroupAdapter2 = this.a.e;
                            hotGroupAdapter2.notifyDataSetChanged();
                            hotGroupAdapter3 = this.a.e;
                            hotGroupAdapter3.a(true);
                            hotGroupAdapter4 = this.a.e;
                            hotGroupAdapter4.a(HotGroupAdapter.BOTTOM_TYPE.LINE);
                            cVar4 = this.a.f;
                            cVar4.a(false);
                        }
                        cVar3 = this.a.f;
                        cVar3.d(false);
                    }
                }
            }
        }
    }
}
