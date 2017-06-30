package com.baidu.tieba.h;

import android.content.Context;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ab;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean jW(int i) {
        switch (i) {
            case 202001:
            case 205001:
            case 309456:
            case CmdConfigHttp.CMD_CHECK_REAL_NAME /* 1003325 */:
                return true;
            default:
                return false;
        }
    }

    public static boolean a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        if ((abVar.uY() ? abVar.uZ() : abVar.va()) == 1990055) {
            akj();
            return true;
        }
        return false;
    }

    public static void akj() {
        if (!k.hz()) {
            TbadkCoreApplication.m9getInst().handler.post(new b());
        } else {
            akk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void akk() {
        Context applicationContext = TbadkCoreApplication.m9getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder("https://wappass.baidu.com/passport/realnamewidget?tpl=tieba&adapter=3&nomenu=1");
        sb.append("&u=").append(URLEncoder.encode("http://tieba.baidu.com/?jump=finish_this_page"));
        g.a(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
