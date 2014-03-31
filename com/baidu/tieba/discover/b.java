package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.b.an;
import com.baidu.tbadk.core.b.ao;
import com.baidu.tbadk.core.b.aq;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
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
        k kVar;
        k kVar2;
        k kVar3;
        com.baidu.tbadk.core.e eVar5;
        com.baidu.tbadk.core.e eVar6;
        com.baidu.tbadk.core.e eVar7;
        com.baidu.tbadk.core.e eVar8;
        discoverItemView = this.a.e;
        if (view != discoverItemView) {
            discoverItemView2 = this.a.f;
            if (view != discoverItemView2) {
                discoverItemView3 = this.a.g;
                if (view != discoverItemView3) {
                    discoverItemView4 = this.a.h;
                    if (view != discoverItemView4) {
                        discoverItemView5 = this.a.i;
                        if (view != discoverItemView5) {
                            discoverItemView6 = this.a.j;
                            if (view != discoverItemView6) {
                                discoverItemView7 = this.a.k;
                                if (view == discoverItemView7) {
                                    com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
                                    eVar2 = this.a.a;
                                    TbWebViewActivity.a(eVar2, this.a.getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + n.c());
                                    return;
                                } else if (view instanceof DiscoverItemView) {
                                    String str = ((DiscoverItemView) view).b;
                                    if (!bc.c(str)) {
                                        bg a = bg.a();
                                        eVar = this.a.a;
                                        a.a(eVar, new String[]{str});
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            TbadkApplication.j().g(TbadkApplication.j().at());
                            TbadkApplication.j().f(false);
                            discoverItemView8 = this.a.j;
                            discoverItemView8.a(false);
                            com.baidu.adp.framework.c a2 = com.baidu.adp.framework.c.a();
                            eVar3 = this.a.a;
                            a2.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.j(eVar3, "faceshop_from_more")));
                            return;
                        }
                        com.baidu.adp.framework.c a3 = com.baidu.adp.framework.c.a();
                        eVar4 = this.a.a;
                        a3.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.e(eVar4, 16003)));
                        return;
                    }
                    z = this.a.m;
                    if (z) {
                        kVar = this.a.n;
                        if (kVar != null) {
                            kVar2 = this.a.n;
                            if (kVar2.b) {
                                com.baidu.adp.framework.c a4 = com.baidu.adp.framework.c.a();
                                eVar5 = this.a.a;
                                a4.a(new com.baidu.adp.framework.message.a(2010030, new an(eVar5)));
                                return;
                            }
                            a aVar = this.a;
                            kVar3 = this.a.n;
                            aVar.showToast(kVar3.a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.adp.framework.c a5 = com.baidu.adp.framework.c.a();
                eVar6 = this.a.a;
                a5.a(new com.baidu.adp.framework.message.a(2010011, new ao(eVar6)));
                return;
            }
            com.baidu.adp.framework.c a6 = com.baidu.adp.framework.c.a();
            eVar7 = this.a.a;
            a6.a(new com.baidu.adp.framework.message.a(2010020, new com.baidu.tbadk.core.b.g(eVar7, "faxian")));
            return;
        }
        com.baidu.adp.framework.c a7 = com.baidu.adp.framework.c.a();
        eVar8 = this.a.a;
        a7.a(new com.baidu.adp.framework.message.a(2010010, new aq(eVar8)));
    }
}
