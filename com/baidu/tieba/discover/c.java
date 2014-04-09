package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.b.an;
import com.baidu.tbadk.core.b.ao;
import com.baidu.tbadk.core.b.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DiscoverItemView discoverItemView;
        DiscoverItemView discoverItemView2;
        DiscoverItemView discoverItemView3;
        DiscoverItemView discoverItemView4;
        DiscoverItemView discoverItemView5;
        DiscoverItemView discoverItemView6;
        DiscoverItemView discoverItemView7;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        DiscoverItemView discoverItemView8;
        com.baidu.tbadk.core.e eVar3;
        com.baidu.tbadk.core.e eVar4;
        boolean z;
        com.baidu.tbadk.core.e eVar5;
        o oVar;
        o oVar2;
        o oVar3;
        com.baidu.tbadk.core.e eVar6;
        com.baidu.tbadk.core.e eVar7;
        com.baidu.tbadk.core.e eVar8;
        com.baidu.tbadk.core.e eVar9;
        discoverItemView = this.a.f;
        if (view != discoverItemView) {
            discoverItemView2 = this.a.g;
            if (view != discoverItemView2) {
                discoverItemView3 = this.a.h;
                if (view != discoverItemView3) {
                    discoverItemView4 = this.a.i;
                    if (view != discoverItemView4) {
                        discoverItemView5 = this.a.j;
                        if (view != discoverItemView5) {
                            discoverItemView6 = this.a.k;
                            if (view != discoverItemView6) {
                                discoverItemView7 = this.a.l;
                                if (view == discoverItemView7) {
                                    com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
                                    eVar2 = this.a.b;
                                    TbWebViewActivity.a(eVar2, this.a.getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + com.baidu.tbadk.core.data.n.c());
                                    return;
                                } else if (view instanceof DiscoverItemView) {
                                    String str = ((DiscoverItemView) view).b;
                                    if (!bc.c(str)) {
                                        bg a = bg.a();
                                        eVar = this.a.b;
                                        a.a(eVar, new String[]{str});
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TbadkApplication.j().g(TbadkApplication.j().av());
                            TbadkApplication.j().h(false);
                            discoverItemView8 = this.a.k;
                            discoverItemView8.a(false);
                            com.baidu.adp.framework.c a2 = com.baidu.adp.framework.c.a();
                            eVar3 = this.a.b;
                            a2.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.j(eVar3, "faceshop_from_more")));
                            return;
                        }
                        com.baidu.adp.framework.c a3 = com.baidu.adp.framework.c.a();
                        eVar4 = this.a.b;
                        a3.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.e(eVar4, 16003)));
                        return;
                    }
                    z = this.a.p;
                    if (z) {
                        oVar = this.a.q;
                        if (oVar != null) {
                            oVar2 = this.a.q;
                            if (oVar2.b) {
                                com.baidu.adp.framework.c a4 = com.baidu.adp.framework.c.a();
                                eVar6 = this.a.b;
                                a4.a(new com.baidu.adp.framework.message.a(2010030, new an(eVar6)));
                                return;
                            }
                            a aVar = this.a;
                            oVar3 = this.a.q;
                            aVar.a(oVar3.a);
                            return;
                        }
                    }
                    a aVar2 = this.a;
                    eVar5 = this.a.b;
                    aVar2.a(eVar5.getString(com.baidu.tieba.a.k.no_signall_data));
                    return;
                }
                com.baidu.adp.framework.c a5 = com.baidu.adp.framework.c.a();
                eVar7 = this.a.b;
                a5.a(new com.baidu.adp.framework.message.a(2010011, new ao(eVar7)));
                return;
            }
            com.baidu.adp.framework.c a6 = com.baidu.adp.framework.c.a();
            eVar8 = this.a.b;
            a6.a(new com.baidu.adp.framework.message.a(2010020, new com.baidu.tbadk.core.b.g(eVar8, "faxian")));
            return;
        }
        com.baidu.adp.framework.c a7 = com.baidu.adp.framework.c.a();
        eVar9 = this.a.b;
        a7.a(new com.baidu.adp.framework.message.a(2010010, new aq(eVar9)));
    }
}
