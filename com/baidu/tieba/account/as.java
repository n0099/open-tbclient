package com.baidu.tieba.account;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class as {
    public static void a(String str, String str2, at atVar) {
        au auVar = new au(str, str2, atVar);
        auVar.setPriority(3);
        auVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData b(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.i.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().aQ()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().aP()));
            com.baidu.tieba.util.bf.a();
            com.baidu.tieba.util.an a = com.baidu.tieba.util.bf.a(new com.baidu.tieba.util.bj());
            if (a == null) {
                return null;
            }
            Context baseContext = TiebaApplication.g().b().getBaseContext();
            a.b(sb.toString());
            a.a(arrayList);
            a.a((Boolean) true);
            a.a(baseContext);
            String u = a.u();
            if (a.p() && u != null) {
                com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
                atVar.a(u);
                String userId = atVar.a().getUserId();
                if (userId == null || userId.length() <= 0) {
                    a.c(a.l().getString(R.string.neterror));
                    return null;
                }
                AccountData accountData = new AccountData();
                accountData.setAccount(atVar.a().getUserName());
                if (atVar.a().getPassword() != null) {
                    accountData.setPassword(atVar.a().getPassword());
                } else {
                    accountData.setPassword(str2);
                }
                accountData.setID(atVar.a().getUserId());
                accountData.setBDUSS(atVar.a().getBDUSS());
                accountData.setPortrait(atVar.a().getPortrait());
                accountData.setIsActive(1);
                if (atVar.b() != null) {
                    accountData.setTbs(atVar.b().getTbs());
                }
                return accountData;
            } else if (a.q()) {
                switch (a.k()) {
                    case 1:
                    case 2:
                    case 5:
                        a.v();
                        return null;
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("LoginModel".toString(), "login", e.getMessage());
            return null;
        }
    }
}
