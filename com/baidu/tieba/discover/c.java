package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.an;
import com.baidu.tbadk.core.atomData.az;
import com.baidu.tbadk.core.atomData.ba;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DiscoverItemView discoverItemView;
        DiscoverItemView discoverItemView2;
        DiscoverItemView discoverItemView3;
        DiscoverItemView discoverItemView4;
        DiscoverItemView discoverItemView5;
        DiscoverItemView discoverItemView6;
        DiscoverItemView discoverItemView7;
        DiscoverItemView discoverItemView8;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tbadk.core.e eVar2;
        DiscoverItemView discoverItemView9;
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
        com.baidu.tbadk.core.e eVar10;
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
                                if (view != discoverItemView7) {
                                    discoverItemView8 = this.a.m;
                                    if (view == discoverItemView8) {
                                        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_member_benifit", true);
                                        String str = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion();
                                        TbadkApplication.m252getInst().settShopUrl(str);
                                        eVar2 = this.a.b;
                                        TbWebViewActivity.a(eVar2, this.a.getString(u.member_benefits), str);
                                        return;
                                    } else if (view instanceof DiscoverItemView) {
                                        String str2 = ((DiscoverItemView) view).b;
                                        if (!be.c(str2)) {
                                            bi a = bi.a();
                                            eVar = this.a.b;
                                            a.a(eVar, new String[]{str2});
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                TbadkApplication.m252getInst().setFaceShopVersion(TbadkApplication.m252getInst().getTempFaceShopVersion());
                                TbadkApplication.m252getInst().setFaceShopNew(false);
                                discoverItemView9 = this.a.l;
                                discoverItemView9.a(false);
                                MessageManager messageManager = MessageManager.getInstance();
                                eVar3 = this.a.b;
                                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.k(eVar3, "faceshop_from_more")));
                                return;
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            eVar4 = this.a.b;
                            messageManager2.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.f(eVar4, 16003)));
                            return;
                        }
                        z = this.a.q;
                        if (z) {
                            oVar = this.a.r;
                            if (oVar != null) {
                                oVar2 = this.a.r;
                                if (oVar2.b) {
                                    MessageManager messageManager3 = MessageManager.getInstance();
                                    eVar6 = this.a.b;
                                    messageManager3.sendMessage(new CustomMessage((int) CmdConfig.SIGN_ALL_FORUM_CUSTOM_CMD, new az(eVar6)));
                                    return;
                                }
                                a aVar = this.a;
                                oVar3 = this.a.r;
                                aVar.b(oVar3.a);
                                return;
                            }
                        }
                        a aVar2 = this.a;
                        eVar5 = this.a.b;
                        aVar2.b(eVar5.getString(u.no_signall_data));
                        return;
                    }
                    MessageManager messageManager4 = MessageManager.getInstance();
                    eVar7 = this.a.b;
                    messageManager4.sendMessage(new CustomMessage(2003001, new an(eVar7)));
                    return;
                }
                MessageManager messageManager5 = MessageManager.getInstance();
                eVar8 = this.a.b;
                messageManager5.sendMessage(new CustomMessage((int) CmdConfig.SINGLE_FORUM_FEED_CUSTOM_CMD, new ba(eVar8)));
                return;
            }
            MessageManager messageManager6 = MessageManager.getInstance();
            eVar9 = this.a.b;
            messageManager6.sendMessage(new CustomMessage((int) CmdConfig.DAILY_RECOMMEND_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.h(eVar9, "faxian")));
            return;
        }
        MessageManager messageManager7 = MessageManager.getInstance();
        eVar10 = this.a.b;
        messageManager7.sendMessage(new CustomMessage((int) CmdConfig.SINGLE_SQUARE_CUSTOM_CMD, new bc(eVar10)));
    }
}
