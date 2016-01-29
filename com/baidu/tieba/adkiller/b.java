package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.be;
import java.net.URL;
/* loaded from: classes.dex */
public class b {
    public static void gE(String str) {
        o<String> Q;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillergame?tag=")) {
            String gJ = gJ(str);
            if (!StringUtils.isNull(gJ) && (Q = com.baidu.tbadk.core.b.a.ug().Q("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                Q.a("ad_killer_tag_key", new c(gJ, Q));
            }
        }
    }

    public static void gF(String str) {
        o<String> Q;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillerkill?tag=")) {
            String gJ = gJ(str);
            if (!StringUtils.isNull(gJ) && (Q = com.baidu.tbadk.core.b.a.ug().Q("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                Q.a("ad_killer_tag_key", new d(gJ));
            }
        }
    }

    public static void gG(String str) {
        o<String> Q;
        if (!StringUtils.isNull(str) && str.toLowerCase().startsWith("http://tieba.baidu.com/mo/q/adkillerclose?tag=")) {
            String gJ = gJ(str);
            if (!StringUtils.isNull(gJ) && (Q = com.baidu.tbadk.core.b.a.ug().Q("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
                Q.a("ad_killer_tag_key", new f(gJ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gH(String str) {
        o<String> Q;
        if (!StringUtils.isNull(str) && (Q = com.baidu.tbadk.core.b.a.ug().Q("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
            Q.a("ad_killer_tag_key", new h(str, Q));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gI(String str) {
        o<String> Q;
        if (!StringUtils.isNull(str) && (Q = com.baidu.tbadk.core.b.a.ug().Q("tb.ad_killer_tags", TbadkCoreApplication.getCurrentAccount())) != null) {
            Q.a("ad_killer_tag_key", new i(str, Q));
        }
    }

    public static void Jh() {
        com.baidu.tieba.tbadkCore.a.a.c(309266, SubmitCloseSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309266, CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER, TbConfig.SUBMIT_CLOSE_ADKILLER, SubmitCloseHttpResponseMessage.class, true, true, true, true);
        MessageManager.getInstance().registerListener(new j(CmdConfigHttp.CMD_SUBMIT_CLOSE_ADKILLER, 309266));
        be.wt().a(new k());
        be.wt().a(new l());
        be.wt().a(new m());
    }

    private static String gJ(String str) {
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
