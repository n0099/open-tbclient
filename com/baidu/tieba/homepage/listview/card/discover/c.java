package com.baidu.tieba.homepage.listview.card.discover;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EnterChatRoomConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.baidu.tieba.n;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, Integer> aOi;

    private static void IS() {
        aOi = new HashMap<>();
        aOi.put("discover_friend", Integer.valueOf(n.e.icon_find_trends));
        aOi.put("discover_nearby", Integer.valueOf(n.e.icon_find_nearby));
        aOi.put("discover_hot_video", Integer.valueOf(n.e.icon_find_voice));
        aOi.put("discover_look_shop", Integer.valueOf(n.e.icon_find_store));
        aOi.put("discover_rand_friend", Integer.valueOf(n.e.icon_find_chat));
        aOi.put("discover_square_trend", Integer.valueOf(n.e.icon_find_myba));
    }

    public static int gG(String str) {
        if (aOi == null) {
            IS();
        }
        Integer num = aOi.get(str);
        return num == null ? n.e.img_default_100 : num.intValue();
    }

    public static void a(TbPageContext<?> tbPageContext, h.b bVar) {
        URI uri;
        int g;
        if (tbPageContext != null && bVar != null) {
            String str = bVar.statistics;
            String str2 = bVar.title;
            String str3 = bVar.linkUrl;
            if ("discover_friend".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(tbPageContext.getPageActivity())));
                }
            } else if ("discover_nearby".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    if (!l.aC("discover_nearby", str3)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(tbPageContext.getPageActivity(), 1)));
                    }
                    if (PluginPackageManager.lU().bv("com.baidu.tieba.pluginNeighbors")) {
                        a(tbPageContext, PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                    } else {
                        k(tbPageContext);
                    }
                    TiebaStatic.log("c10086");
                }
            } else if ("discover_hot_video".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(tbPageContext.getPageActivity())));
                }
            } else if ("discover_look_shop".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(tbPageContext.getPageActivity(), "faceshop_from_more")));
                }
            } else if ("discover_rand_friend".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    if (!l.aC("discover_rand_friend", str3)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(tbPageContext.getPageActivity(), 1)));
                    } else if (PluginPackageManager.lU().bv("com.baidu.tieba.pluginRandomChat")) {
                        a(tbPageContext, PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(tbPageContext.getPageActivity())));
                    }
                }
            } else if ("discover_game_center".equals(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(tbPageContext.getPageActivity())));
            } else if ("discover_square_trend".equals(str)) {
                if (bj.ah(tbPageContext.getPageActivity())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(tbPageContext.getPageActivity())));
                }
            } else if (str3 != null) {
                if (str3.startsWith("game:detail:")) {
                    bf.vD().a(tbPageContext, str2, new String[]{str3, "1000501"});
                } else if (str3.startsWith("http://m.xiu8.com")) {
                    if (bj.ah(tbPageContext.getPageActivity())) {
                        TiebaStatic.log("c10104");
                        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity)) {
                            g(tbPageContext, str3);
                        }
                    }
                } else if (str3.startsWith("live:detail:TBCLiveID=")) {
                    if (bj.ah(tbPageContext.getPageActivity()) && (g = com.baidu.adp.lib.h.b.g(str3.replace("live:detail:TBCLiveID=", ""), -1)) != -1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(tbPageContext.getPageActivity(), g)));
                    }
                } else if (o.di(str3) == 3) {
                    if (bj.ah(tbPageContext.getPageActivity())) {
                        o.a(tbPageContext, str3);
                    }
                } else {
                    try {
                        uri = new URI(str3);
                    } catch (URISyntaxException e) {
                        BdLog.e(e);
                        uri = null;
                    }
                    TiebaStatic.log(new av("c10116").ab("obj_url", uri != null ? uri.getHost() : str3));
                    bf.vD().a(tbPageContext, str2, new String[]{str3}, true);
                }
            }
        }
    }

    private static void a(TbPageContext<?> tbPageContext, PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cC(String.format(TbadkCoreApplication.m411getInst().getString(n.i.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(n.i.download), new d(pluginConfig, tbPageContext));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new e());
            aVar.b(tbPageContext);
            aVar.tv();
        }
    }

    public static void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            if (TbadkCoreApplication.m411getInst().getLocationShared()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(tbPageContext.getPageActivity())));
                return;
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.bN(n.i.warning_location_switch_off);
            aVar.a(n.i.isopen, new f(tbPageContext));
            aVar.b(n.i.cancel, new g());
            aVar.b(tbPageContext);
            aVar.tv();
        }
    }

    private static void g(TbPageContext<BaseFragmentActivity> tbPageContext, String str) {
        if (!TbadkCoreApplication.isLogin()) {
            a(tbPageContext, str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            h(tbPageContext, str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            h(tbPageContext, str);
        } else {
            a(tbPageContext, str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    private static void h(TbPageContext<BaseFragmentActivity> tbPageContext, String str) {
        if (tbPageContext != null) {
            tbPageContext.getOrignalPage().showLoadingDialog(TbadkCoreApplication.m411getInst().getResources().getString(n.i.loading), null);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
            httpMessage.setExtra(str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(TbPageContext<?> tbPageContext, String str, String str2, String str3) {
        if (tbPageContext != null) {
            String string = TbadkCoreApplication.m411getInst().getResources().getString(n.i.xiuba_title);
            com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
        }
    }
}
