package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bg;
import java.net.URL;
/* loaded from: classes.dex */
public class b {
    public static void gR(String str) {
        o<String> O;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillergame?tag=")) {
            String gW = gW(str);
            if (!StringUtils.isNull(gW) && (O = com.baidu.tbadk.core.b.a.rR().O("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                O.a("ad_killer_tag_key", new c(gW, O));
            }
        }
    }

    public static void gS(String str) {
        o<String> O;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillerkill?tag=")) {
            String gW = gW(str);
            if (!StringUtils.isNull(gW) && (O = com.baidu.tbadk.core.b.a.rR().O("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                O.a("ad_killer_tag_key", new d(gW));
            }
        }
    }

    public static void gT(String str) {
        o<String> O;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillerclose?tag=")) {
            String gW = gW(str);
            if (!StringUtils.isNull(gW) && (O = com.baidu.tbadk.core.b.a.rR().O("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                O.a("ad_killer_tag_key", new f(gW));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gU(String str) {
        o<String> O;
        if (!StringUtils.isNull(str) && (O = com.baidu.tbadk.core.b.a.rR().O("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
            O.a("ad_killer_tag_key", new h(str, O));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gV(String str) {
        o<String> O;
        if (!StringUtils.isNull(str) && (O = com.baidu.tbadk.core.b.a.rR().O("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
            O.a("ad_killer_tag_key", new i(str, O));
        }
    }

    public static void IT() {
        com.baidu.tieba.tbadkCore.a.a.c(309266, SubmitCloseSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309266, CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER, TbConfig.SUBMIT_CLOSE_ADKILLER, SubmitCloseHttpResponseMessage.class, true, true, true, true);
        MessageManager.getInstance().registerListener(new j(CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER, 309266));
        bg.us().a(new k());
        bg.us().a(new l());
        bg.us().a(new m());
    }

    private static String gW(String str) {
        String[] split;
        try {
            String query = new URL(str).getQuery();
            if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2) {
                    String str3 = split2[0];
                    String str4 = split2[1];
                    if ("tag".equalsIgnoreCase(str3)) {
                        return str4;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
