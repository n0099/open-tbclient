package com.baidu.tieba.i;

import android.content.Context;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class a {
    public static boolean uK(int i) {
        switch (i) {
            case CmdConfigSocket.CMD_GROUP_CHAT_MSG /* 202001 */:
            case CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG /* 205001 */:
            case CmdConfigSocket.CMD_CHECK_REAL_NAME /* 309456 */:
            case 1003325:
                return true;
            default:
                return false;
        }
    }

    public static boolean b(x xVar) {
        if (xVar == null) {
            return false;
        }
        if ((xVar.isNetSuccess() ? xVar.getServerErrorCode() : xVar.getNetErrorCode()) == 1990055) {
            bJU();
            return true;
        }
        return false;
    }

    public static void bJU() {
        if (!l.isMainThread()) {
            TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tieba.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.bJV();
                }
            });
        } else {
            bJV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bJV() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder(UrlSchemaHelper.REAL_NAME_AUTH_URL);
        sb.append("&u=").append(URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW));
        com.baidu.tbadk.browser.a.startWebActivity(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
