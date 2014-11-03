package com.baidu.tieba.discover;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.BackupHotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.DiscoverMoreActivityConfig;
import com.baidu.tbadk.core.atomData.DiscoverSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tieba.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a anL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.anL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DiscoverItemView discoverItemView;
        DiscoverItemView discoverItemView2;
        DiscoverItemView discoverItemView3;
        DiscoverItemView discoverItemView4;
        DiscoverItemView discoverItemView5;
        DiscoverItemView discoverItemView6;
        String str;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        BaseFragmentActivity baseFragmentActivity4;
        String str2;
        BaseFragmentActivity baseFragmentActivity5;
        BaseFragmentActivity baseFragmentActivity6;
        BaseFragmentActivity baseFragmentActivity7;
        BaseFragmentActivity baseFragmentActivity8;
        boolean z;
        BaseFragmentActivity baseFragmentActivity9;
        r rVar;
        BaseFragmentActivity baseFragmentActivity10;
        BaseFragmentActivity baseFragmentActivity11;
        BaseFragmentActivity baseFragmentActivity12;
        DiscoverItemView discoverItemView7;
        BaseFragmentActivity baseFragmentActivity13;
        BaseFragmentActivity baseFragmentActivity14;
        BaseFragmentActivity baseFragmentActivity15;
        discoverItemView = this.anL.anq;
        if (view == discoverItemView) {
            baseFragmentActivity14 = a.mActivity;
            com.baidu.tbadk.core.j.l(baseFragmentActivity14, "ftab_square");
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity15 = a.mActivity;
            messageManager.sendMessage(new CustomMessage(2002001, new DiscoverSquareActivityConfig(baseFragmentActivity15)));
            return;
        }
        discoverItemView2 = this.anL.ann;
        if (view != discoverItemView2) {
            discoverItemView3 = this.anL.ano;
            if (view != discoverItemView3) {
                discoverItemView4 = this.anL.anr;
                if (view != discoverItemView4) {
                    discoverItemView5 = this.anL.anp;
                    if (view == discoverItemView5) {
                        baseFragmentActivity7 = a.mActivity;
                        com.baidu.tbadk.core.j.l(baseFragmentActivity7, "ftab_group");
                        MessageManager messageManager2 = MessageManager.getInstance();
                        baseFragmentActivity8 = a.mActivity;
                        messageManager2.sendMessage(new CustomMessage(2002001, new DiscoverMoreActivityConfig(baseFragmentActivity8)));
                        return;
                    }
                    discoverItemView6 = this.anL.ans;
                    if (view == discoverItemView6) {
                        a aVar = this.anL;
                        baseFragmentActivity6 = a.mActivity;
                        aVar.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(baseFragmentActivity6)));
                        return;
                    } else if (view instanceof DiscoverItemView) {
                        String str3 = "";
                        TextView textView = ((DiscoverItemView) view).JN;
                        if (textView != null && (str3 = com.baidu.adp.lib.util.l.a(textView.getText(), null)) != null && !str3.equals("")) {
                            try {
                                str2 = URLEncoder.encode(str3, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str2 = "";
                            }
                            if (!str2.equals("")) {
                                baseFragmentActivity5 = a.mActivity;
                                com.baidu.tbadk.core.j.l(baseFragmentActivity5, str2);
                            }
                        }
                        String str4 = str3;
                        String str5 = ((DiscoverItemView) view).abu;
                        if (!az.aA(str5)) {
                            if (az.aA(str4)) {
                                str4 = "";
                            }
                            str = this.anL.anz;
                            if (str5.equals(str)) {
                                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_is_show_tip", false);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                                bg mR = bg.mR();
                                baseFragmentActivity4 = a.mActivity;
                                mR.a(baseFragmentActivity4, str4, new String[]{str5});
                                return;
                            } else if (str5.startsWith("xiuba:")) {
                                baseFragmentActivity2 = a.mActivity;
                                if (PluginHelper.isXiubaCanuse(baseFragmentActivity2)) {
                                    baseFragmentActivity3 = a.mActivity;
                                    TiebaStatic.eventStat(baseFragmentActivity3, "discover_xiu8", "click");
                                    this.anL.AN();
                                    return;
                                }
                                return;
                            } else {
                                bg mR2 = bg.mR();
                                baseFragmentActivity = a.mActivity;
                                mR2.a(baseFragmentActivity, str4, new String[]{str5});
                                return;
                            }
                        }
                        return;
                    } else {
                        return;
                    }
                }
                z = this.anL.anw;
                if (z) {
                    rVar = this.anL.anx;
                    if (rVar != null) {
                        MessageManager messageManager3 = MessageManager.getInstance();
                        baseFragmentActivity10 = a.mActivity;
                        messageManager3.sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(baseFragmentActivity10)));
                        return;
                    }
                }
                a aVar2 = this.anL;
                baseFragmentActivity9 = a.mActivity;
                aVar2.showToast(baseFragmentActivity9.getString(y.no_signall_data));
                return;
            } else if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                MessageManager messageManager4 = MessageManager.getInstance();
                baseFragmentActivity12 = a.mActivity;
                messageManager4.sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(baseFragmentActivity12)));
                return;
            } else {
                MessageManager messageManager5 = MessageManager.getInstance();
                baseFragmentActivity11 = a.mActivity;
                messageManager5.sendMessage(new CustomMessage(2002001, new BackupHotLiveListActivityConfig(baseFragmentActivity11)));
                return;
            }
        }
        TbadkApplication.m251getInst().setFriendFeedNew(false);
        discoverItemView7 = this.anL.ann;
        discoverItemView7.bw(false);
        MessageManager messageManager6 = MessageManager.getInstance();
        baseFragmentActivity13 = a.mActivity;
        messageManager6.sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(baseFragmentActivity13)));
    }
}
