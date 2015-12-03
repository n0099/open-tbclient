package com.baidu.tieba.homepage.listview.card.discover;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.discover.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static boolean aB(String str, String str2) {
        if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
            return false;
        }
        if ("discover_square".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (aD(str, str2)) {
            return TbadkCoreApplication.m411getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if (aE(str, str2)) {
            return TbadkCoreApplication.m411getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    public static boolean aC(String str, String str2) {
        if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
            return false;
        }
        if ("discover_nearby".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_rand_friend".equals(str)) {
            return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        return true;
    }

    private static boolean aD(String str, String str2) {
        if ("discover_hot_video".equals(str)) {
            return true;
        }
        return str2 != null && str2.startsWith("live:detail:TBCLiveID=");
    }

    private static boolean aE(String str, String str2) {
        if ("discover_game_center".equals(str)) {
            return true;
        }
        return str2 != null && (str2.startsWith("gamecenter:") || str2.startsWith("game:detail:"));
    }

    public static void a(List<h.b> list, List<h.b> list2, boolean z) {
        String str;
        if (list != null) {
            int k = y.k(list);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < k; i++) {
                h.b bVar = list.get(i);
                if (bVar != null && !StringUtils.isNull(bVar.title) && aB(bVar.statistics, bVar.linkUrl) && aC(bVar.statistics, bVar.linkUrl)) {
                    if (z) {
                        c(bVar);
                    }
                } else {
                    arrayList.add(bVar);
                }
            }
            list.removeAll(arrayList);
            List<h.b> IM = IM();
            int k2 = y.k(IM);
            for (int i2 = 0; i2 < k2; i2++) {
                h.b bVar2 = (h.b) y.b(IM, i2);
                if (bVar2 != null && (str = bVar2.statistics) != null) {
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h.b bVar3 = (h.b) y.b(list, i3);
                        if (bVar3 != null && str.equals(bVar3.statistics)) {
                            int indexOf = list.indexOf(bVar3);
                            list.remove(bVar3);
                            list.add(indexOf, bVar2);
                        }
                    }
                    list.add(bVar2);
                }
            }
        }
    }

    public static List<h.b> IM() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] Fi = Fi();
        if (Fi == null || Fi.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Fi) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lU().bt(str) && !PluginPackageManager.lU().bu(str) && (pluginConfig = PluginPackageManager.lU().getPluginConfig(str)) != null) {
                h.b bVar = new h.b();
                bVar.title = pluginConfig.display_name;
                bVar.iconUrl = pluginConfig.icon;
                bVar.statistics = gH(str);
                if (!StringUtils.isNull(bVar.statistics)) {
                    bVar.bze = PluginPackageManager.lU().bv(str);
                    bVar.cZ(true);
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public static String[] Fi() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getString("key_discover_show_plugin_list", "").split("#");
    }

    private static void fU(String str) {
        String string;
        if (!StringUtils.isNull(str)) {
            for (String str2 : com.baidu.tbadk.core.sharedPref.b.tZ().getString("key_discover_show_plugin_list", "").split("#")) {
                if (str.equals(str2)) {
                    return;
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("key_discover_show_plugin_list", String.valueOf(string) + "#" + str);
        }
    }

    private static int fV(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return new JSONObject(str).optInt("plugintype", 0);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean fW(String str) {
        return fV(str) == 1;
    }

    private static String gH(String str) {
        if ("com.baidu.tieba.pluginNeighbors".equals(str)) {
            return "discover_nearby";
        }
        if ("com.baidu.tieba.pluginRandomChat".equals(str)) {
            return "discover_rand_friend";
        }
        return null;
    }

    private static void c(h.b bVar) {
        if (bVar != null) {
            if ("discover_friend".equals(bVar.statistics)) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "friend_feed_tip_show", false);
                bVar.auC = false;
                bVar.bze = z;
            } else if (!com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("discover_tip_show_" + bVar.title, true)) {
                bVar.auC = false;
                bVar.bze = false;
            }
        }
    }

    public static void IG() {
        PluginNetConfigInfos mm = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm();
        if (mm != null && mm.getConfigs() != null && !mm.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mm.getConfigs()) {
                if (pluginConfig != null && fW(pluginConfig.ext)) {
                    fU(pluginConfig.package_name);
                }
            }
        }
    }
}
