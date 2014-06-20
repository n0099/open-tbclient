package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.atomData.ay;
import com.baidu.tbadk.core.atomData.az;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.y;
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
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        DiscoverItemView discoverItemView9;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        boolean z;
        BaseFragmentActivity baseFragmentActivity5;
        o oVar;
        o oVar2;
        o oVar3;
        BaseFragmentActivity baseFragmentActivity6;
        BaseFragmentActivity baseFragmentActivity7;
        BaseFragmentActivity baseFragmentActivity8;
        BaseFragmentActivity baseFragmentActivity9;
        BaseFragmentActivity baseFragmentActivity10;
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
                                        baseFragmentActivity2 = this.a.b;
                                        TbWebViewActivity.a(baseFragmentActivity2, this.a.getString(y.member_benefits), str, true, false, true, true, null);
                                        return;
                                    } else if (view instanceof DiscoverItemView) {
                                        String str2 = ((DiscoverItemView) view).b;
                                        if (!bg.c(str2)) {
                                            bk a = bk.a();
                                            baseFragmentActivity = this.a.b;
                                            a.a(baseFragmentActivity, new String[]{str2});
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
                                baseFragmentActivity3 = this.a.b;
                                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.k(baseFragmentActivity3, "faceshop_from_more")));
                                return;
                            }
                            MessageManager messageManager2 = MessageManager.getInstance();
                            baseFragmentActivity4 = this.a.b;
                            messageManager2.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.f(baseFragmentActivity4, 16003)));
                            return;
                        }
                        z = this.a.q;
                        if (z) {
                            oVar = this.a.r;
                            if (oVar != null) {
                                oVar2 = this.a.r;
                                if (oVar2.b) {
                                    MessageManager messageManager3 = MessageManager.getInstance();
                                    baseFragmentActivity6 = this.a.b;
                                    messageManager3.sendMessage(new CustomMessage((int) CmdConfig.SIGN_ALL_FORUM_CUSTOM_CMD, new ay(baseFragmentActivity6)));
                                    return;
                                }
                                a aVar = this.a;
                                oVar3 = this.a.r;
                                aVar.b(oVar3.a);
                                return;
                            }
                        }
                        a aVar2 = this.a;
                        baseFragmentActivity5 = this.a.b;
                        aVar2.b(baseFragmentActivity5.getString(y.no_signall_data));
                        return;
                    }
                    MessageManager messageManager4 = MessageManager.getInstance();
                    baseFragmentActivity7 = this.a.b;
                    messageManager4.sendMessage(new CustomMessage(2003001, new am(baseFragmentActivity7)));
                    return;
                }
                MessageManager messageManager5 = MessageManager.getInstance();
                baseFragmentActivity8 = this.a.b;
                messageManager5.sendMessage(new CustomMessage((int) CmdConfig.SINGLE_FORUM_FEED_CUSTOM_CMD, new az(baseFragmentActivity8)));
                return;
            }
            MessageManager messageManager6 = MessageManager.getInstance();
            baseFragmentActivity9 = this.a.b;
            messageManager6.sendMessage(new CustomMessage((int) CmdConfig.DAILY_RECOMMEND_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.h(baseFragmentActivity9, "faxian")));
            return;
        }
        MessageManager messageManager7 = MessageManager.getInstance();
        baseFragmentActivity10 = this.a.b;
        messageManager7.sendMessage(new CustomMessage((int) CmdConfig.SINGLE_SQUARE_CUSTOM_CMD, new bb(baseFragmentActivity10)));
    }
}
