package com.baidu.tieba.discover;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ab;
import com.baidu.tbadk.core.atomData.av;
import com.baidu.tbadk.core.atomData.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.x;
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
        DiscoverItemView discoverItemView9;
        BaseFragmentActivity baseFragmentActivity;
        String a;
        String str;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        DiscoverItemView discoverItemView10;
        BaseFragmentActivity baseFragmentActivity5;
        BaseFragmentActivity baseFragmentActivity6;
        BaseFragmentActivity baseFragmentActivity7;
        boolean z;
        BaseFragmentActivity baseFragmentActivity8;
        q qVar;
        BaseFragmentActivity baseFragmentActivity9;
        BaseFragmentActivity baseFragmentActivity10;
        DiscoverItemView discoverItemView11;
        BaseFragmentActivity baseFragmentActivity11;
        BaseFragmentActivity baseFragmentActivity12;
        BaseFragmentActivity baseFragmentActivity13;
        BaseFragmentActivity baseFragmentActivity14;
        BaseFragmentActivity baseFragmentActivity15;
        discoverItemView = this.a.k;
        if (view == discoverItemView) {
            baseFragmentActivity14 = this.a.b;
            com.baidu.tbadk.core.f.a(baseFragmentActivity14, "ftab_square");
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity15 = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.l(baseFragmentActivity15)));
            return;
        }
        discoverItemView2 = this.a.j;
        if (view == discoverItemView2) {
            baseFragmentActivity12 = this.a.b;
            com.baidu.tbadk.core.f.a(baseFragmentActivity12, "rand_chat_enter_button");
            MessageManager messageManager2 = MessageManager.getInstance();
            baseFragmentActivity13 = this.a.b;
            messageManager2.sendMessage(new CustomMessage(2008020, new com.baidu.tbadk.core.atomData.n(baseFragmentActivity13)));
            return;
        }
        discoverItemView3 = this.a.f;
        if (view != discoverItemView3) {
            discoverItemView4 = this.a.g;
            if (view != discoverItemView4) {
                discoverItemView5 = this.a.l;
                if (view != discoverItemView5) {
                    discoverItemView6 = this.a.h;
                    if (view == discoverItemView6) {
                        baseFragmentActivity6 = this.a.b;
                        com.baidu.tbadk.core.f.a(baseFragmentActivity6, "ftab_group");
                        MessageManager messageManager3 = MessageManager.getInstance();
                        baseFragmentActivity7 = this.a.b;
                        messageManager3.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.k(baseFragmentActivity7)));
                        return;
                    }
                    discoverItemView7 = this.a.m;
                    if (view != discoverItemView7) {
                        discoverItemView8 = this.a.n;
                        if (view != discoverItemView8) {
                            discoverItemView9 = this.a.i;
                            if (view == discoverItemView9) {
                                if (UtilHelper.isNetOk()) {
                                    if (TbadkApplication.m252getInst().getLocationShared()) {
                                        a aVar = this.a;
                                        baseFragmentActivity3 = this.a.b;
                                        aVar.a(new CustomMessage(2002001, new com.baidu.tieba.neighbors.k(baseFragmentActivity3, false)));
                                        return;
                                    }
                                    this.a.f();
                                    return;
                                }
                                this.a.a(x.neterror);
                                return;
                            } else if (view instanceof DiscoverItemView) {
                                TextView textView = ((DiscoverItemView) view).b;
                                if (textView != null && (a = com.baidu.adp.lib.util.i.a(textView.getText(), (String) null)) != null && !a.equals("")) {
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
                                String str2 = ((DiscoverItemView) view).c;
                                if (!ba.c(str2)) {
                                    bg a2 = bg.a();
                                    baseFragmentActivity = this.a.b;
                                    a2.a(baseFragmentActivity, new String[]{str2});
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        a aVar2 = this.a;
                        baseFragmentActivity4 = this.a.b;
                        aVar2.a(new CustomMessage(2002001, new av(baseFragmentActivity4)));
                        return;
                    }
                    TbadkApplication.m252getInst().setFaceShopVersion(TbadkApplication.m252getInst().getTempFaceShopVersion());
                    TbadkApplication.m252getInst().setFaceShopNew(false);
                    discoverItemView10 = this.a.m;
                    discoverItemView10.a(false);
                    MessageManager messageManager4 = MessageManager.getInstance();
                    baseFragmentActivity5 = this.a.b;
                    messageManager4.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.p(baseFragmentActivity5, "faceshop_from_more")));
                    return;
                }
                z = this.a.r;
                if (z) {
                    qVar = this.a.s;
                    if (qVar != null) {
                        MessageManager messageManager5 = MessageManager.getInstance();
                        baseFragmentActivity9 = this.a.b;
                        messageManager5.sendMessage(new CustomMessage(2010030, new bv(baseFragmentActivity9)));
                        return;
                    }
                }
                a aVar3 = this.a;
                baseFragmentActivity8 = this.a.b;
                aVar3.b(baseFragmentActivity8.getString(x.no_signall_data));
                return;
            }
            MessageManager messageManager6 = MessageManager.getInstance();
            baseFragmentActivity10 = this.a.b;
            messageManager6.sendMessage(new CustomMessage(2002001, new ab(baseFragmentActivity10)));
            return;
        }
        TbadkApplication.m252getInst().setFriendFeedNew(false);
        discoverItemView11 = this.a.f;
        discoverItemView11.a(false);
        MessageManager messageManager7 = MessageManager.getInstance();
        baseFragmentActivity11 = this.a.b;
        messageManager7.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.r(baseFragmentActivity11)));
    }
}
