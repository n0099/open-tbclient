package com.baidu.tieba.discover;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bl;
import com.baidu.tbadk.core.atomData.x;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tieba.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        String a;
        String str;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        DiscoverItemView discoverItemView9;
        BaseFragmentActivity baseFragmentActivity4;
        BaseFragmentActivity baseFragmentActivity5;
        BaseFragmentActivity baseFragmentActivity6;
        boolean z;
        BaseFragmentActivity baseFragmentActivity7;
        o oVar;
        o oVar2;
        o oVar3;
        BaseFragmentActivity baseFragmentActivity8;
        BaseFragmentActivity baseFragmentActivity9;
        DiscoverItemView discoverItemView10;
        BaseFragmentActivity baseFragmentActivity10;
        BaseFragmentActivity baseFragmentActivity11;
        BaseFragmentActivity baseFragmentActivity12;
        BaseFragmentActivity baseFragmentActivity13;
        BaseFragmentActivity baseFragmentActivity14;
        discoverItemView = this.a.j;
        if (view == discoverItemView) {
            baseFragmentActivity13 = this.a.b;
            com.baidu.tbadk.core.f.a(baseFragmentActivity13, "ftab_square");
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity14 = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.k(baseFragmentActivity14)));
            return;
        }
        discoverItemView2 = this.a.i;
        if (view == discoverItemView2) {
            baseFragmentActivity11 = this.a.b;
            com.baidu.tbadk.core.f.a(baseFragmentActivity11, "rand_chat_enter_button");
            MessageManager messageManager2 = MessageManager.getInstance();
            baseFragmentActivity12 = this.a.b;
            messageManager2.sendMessage(new CustomMessage(2008020, new com.baidu.tbadk.core.atomData.m(baseFragmentActivity12)));
            return;
        }
        discoverItemView3 = this.a.f;
        if (view != discoverItemView3) {
            discoverItemView4 = this.a.g;
            if (view != discoverItemView4) {
                discoverItemView5 = this.a.k;
                if (view != discoverItemView5) {
                    discoverItemView6 = this.a.h;
                    if (view == discoverItemView6) {
                        baseFragmentActivity5 = this.a.b;
                        com.baidu.tbadk.core.f.a(baseFragmentActivity5, "ftab_group");
                        MessageManager messageManager3 = MessageManager.getInstance();
                        baseFragmentActivity6 = this.a.b;
                        messageManager3.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.j(baseFragmentActivity6)));
                        return;
                    }
                    discoverItemView7 = this.a.l;
                    if (view != discoverItemView7) {
                        discoverItemView8 = this.a.m;
                        if (view == discoverItemView8) {
                            com.baidu.tbadk.core.sharedPref.b.a().c("has_shown_member_benifit", true);
                            String str2 = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion();
                            TbadkApplication.m252getInst().settShopUrl(str2);
                            baseFragmentActivity3 = this.a.b;
                            TbWebViewActivity.startActivity(baseFragmentActivity3, this.a.getString(y.member_benefits), str2, true, false, true, true, null);
                            return;
                        } else if (view instanceof DiscoverItemView) {
                            TextView textView = ((DiscoverItemView) view).b;
                            if (textView != null && (a = com.baidu.adp.lib.util.i.a(textView.getText(), null)) != null && !a.equals("")) {
                                try {
                                    str = URLEncoder.encode(a, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                    str = "";
                                }
                                if (!str.equals("")) {
                                    baseFragmentActivity2 = this.a.b;
                                    com.baidu.tbadk.core.f.a(baseFragmentActivity2, str);
                                }
                            }
                            String str3 = ((DiscoverItemView) view).c;
                            if (!bm.c(str3)) {
                                bq a2 = bq.a();
                                baseFragmentActivity = this.a.b;
                                a2.a(baseFragmentActivity, new String[]{str3});
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
                    MessageManager messageManager4 = MessageManager.getInstance();
                    baseFragmentActivity4 = this.a.b;
                    messageManager4.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.o(baseFragmentActivity4, "faceshop_from_more")));
                    return;
                }
                z = this.a.q;
                if (z) {
                    oVar = this.a.r;
                    if (oVar != null) {
                        oVar2 = this.a.r;
                        if (oVar2.b) {
                            MessageManager messageManager5 = MessageManager.getInstance();
                            baseFragmentActivity8 = this.a.b;
                            messageManager5.sendMessage(new CustomMessage(2010030, new bl(baseFragmentActivity8)));
                            return;
                        }
                        a aVar = this.a;
                        oVar3 = this.a.r;
                        aVar.b(oVar3.a);
                        return;
                    }
                }
                a aVar2 = this.a;
                baseFragmentActivity7 = this.a.b;
                aVar2.b(baseFragmentActivity7.getString(y.no_signall_data));
                return;
            }
            MessageManager messageManager6 = MessageManager.getInstance();
            baseFragmentActivity9 = this.a.b;
            messageManager6.sendMessage(new CustomMessage(2002001, new x(baseFragmentActivity9)));
            return;
        }
        TbadkApplication.m252getInst().setFriendFeedNew(false);
        discoverItemView10 = this.a.f;
        discoverItemView10.a(false);
        MessageManager messageManager7 = MessageManager.getInstance();
        baseFragmentActivity10 = this.a.b;
        messageManager7.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.q(baseFragmentActivity10)));
    }
}
