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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tieba.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a anC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.anC = aVar;
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
        discoverItemView = this.anC.anh;
        if (view == discoverItemView) {
            baseFragmentActivity14 = a.mActivity;
            com.baidu.tbadk.core.i.l(baseFragmentActivity14, "ftab_square");
            MessageManager messageManager = MessageManager.getInstance();
            baseFragmentActivity15 = a.mActivity;
            messageManager.sendMessage(new CustomMessage(2002001, new DiscoverSquareActivityConfig(baseFragmentActivity15)));
            return;
        }
        discoverItemView2 = this.anC.ane;
        if (view != discoverItemView2) {
            discoverItemView3 = this.anC.anf;
            if (view != discoverItemView3) {
                discoverItemView4 = this.anC.ani;
                if (view != discoverItemView4) {
                    discoverItemView5 = this.anC.ang;
                    if (view == discoverItemView5) {
                        baseFragmentActivity7 = a.mActivity;
                        com.baidu.tbadk.core.i.l(baseFragmentActivity7, "ftab_group");
                        MessageManager messageManager2 = MessageManager.getInstance();
                        baseFragmentActivity8 = a.mActivity;
                        messageManager2.sendMessage(new CustomMessage(2002001, new DiscoverMoreActivityConfig(baseFragmentActivity8)));
                        return;
                    }
                    discoverItemView6 = this.anC.anj;
                    if (view == discoverItemView6) {
                        a aVar = this.anC;
                        baseFragmentActivity6 = a.mActivity;
                        aVar.sendMessage(new CustomMessage(2002001, new MemberPrivilegeActivityConfig(baseFragmentActivity6)));
                        return;
                    } else if (view instanceof DiscoverItemView) {
                        String str3 = "";
                        TextView textView = ((DiscoverItemView) view).JM;
                        if (textView != null && (str3 = com.baidu.adp.lib.util.l.a(textView.getText(), null)) != null && !str3.equals("")) {
                            try {
                                str2 = URLEncoder.encode(str3, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str2 = "";
                            }
                            if (!str2.equals("")) {
                                baseFragmentActivity5 = a.mActivity;
                                com.baidu.tbadk.core.i.l(baseFragmentActivity5, str2);
                            }
                        }
                        String str4 = str3;
                        String str5 = ((DiscoverItemView) view).abo;
                        if (!ay.aA(str5)) {
                            if (ay.aA(str4)) {
                                str4 = "";
                            }
                            str = this.anC.anq;
                            if (str5.equals(str)) {
                                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_is_show_tip", false);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                                bf mR = bf.mR();
                                baseFragmentActivity4 = a.mActivity;
                                mR.a(baseFragmentActivity4, str4, new String[]{str5});
                                return;
                            } else if (str5.startsWith("xiuba:")) {
                                baseFragmentActivity2 = a.mActivity;
                                if (PluginHelper.isXiubaCanuse(baseFragmentActivity2)) {
                                    baseFragmentActivity3 = a.mActivity;
                                    TiebaStatic.eventStat(baseFragmentActivity3, "discover_xiu8", "click");
                                    this.anC.AL();
                                    return;
                                }
                                return;
                            } else {
                                bf mR2 = bf.mR();
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
                z = this.anC.ann;
                if (z) {
                    rVar = this.anC.ano;
                    if (rVar != null) {
                        MessageManager messageManager3 = MessageManager.getInstance();
                        baseFragmentActivity10 = a.mActivity;
                        messageManager3.sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(baseFragmentActivity10)));
                        return;
                    }
                }
                a aVar2 = this.anC;
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
        discoverItemView7 = this.anC.ane;
        discoverItemView7.bw(false);
        MessageManager messageManager6 = MessageManager.getInstance();
        baseFragmentActivity13 = a.mActivity;
        messageManager6.sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(baseFragmentActivity13)));
    }
}
