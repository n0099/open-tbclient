package com.baidu.tieba.i;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean nz(int i) {
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

    public static boolean a(x xVar) {
        if (xVar == null) {
            return false;
        }
        if ((xVar.Cb() ? xVar.Cc() : xVar.Cd()) == 1990055) {
            aIr();
            return true;
        }
        return false;
    }

    public static void aIr() {
        if (!l.ln()) {
            TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tieba.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.aIs();
                }
            });
        } else {
            aIs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aIs() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder("https://wappass.baidu.com/passport/realnamewidget?tpl=tieba&adapter=3&nomenu=1");
        sb.append("&u=").append(URLEncoder.encode("http://tieba.baidu.com/?jump=finish_this_page"));
        com.baidu.tbadk.browser.a.a(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
