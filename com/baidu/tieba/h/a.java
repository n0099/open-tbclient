package com.baidu.tieba.h;

import android.content.Context;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.z;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean jL(int i) {
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

    public static boolean a(z zVar) {
        if (zVar == null) {
            return false;
        }
        if ((zVar.uI() ? zVar.uJ() : zVar.uK()) == 1990055) {
            agz();
            return true;
        }
        return false;
    }

    public static void agz() {
        if (!k.hA()) {
            TbadkCoreApplication.m9getInst().handler.post(new b());
        } else {
            agA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void agA() {
        Context applicationContext = TbadkCoreApplication.m9getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder("https://wappass.baidu.com/passport/realnamewidget?tpl=tieba&adapter=3&nomenu=1");
        sb.append("&u=").append(URLEncoder.encode("http://tieba.baidu.com/?jump=finish_this_page"));
        f.a(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
