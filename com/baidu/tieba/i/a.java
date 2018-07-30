package com.baidu.tieba.i;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean mx(int i) {
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

    public static boolean a(y yVar) {
        if (yVar == null) {
            return false;
        }
        if ((yVar.yR() ? yVar.yS() : yVar.yT()) == 1990055) {
            aCP();
            return true;
        }
        return false;
    }

    public static void aCP() {
        if (!l.jU()) {
            TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tieba.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.aCQ();
                }
            });
        } else {
            aCQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aCQ() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder("https://wappass.baidu.com/passport/realnamewidget?tpl=tieba&adapter=3&nomenu=1");
        sb.append("&u=").append(URLEncoder.encode("http://tieba.baidu.com/?jump=finish_this_page"));
        com.baidu.tbadk.browser.a.a(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
