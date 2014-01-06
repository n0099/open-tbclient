package com.baidu.tieba.account;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ar {
    public static void a(String str, String str2, as asVar) {
        at atVar = new at(str, str2, asVar);
        atVar.setPriority(3);
        atVar.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountData b(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().bc()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().bb()));
            com.baidu.tieba.util.ai a = com.baidu.tieba.util.bc.a().a(new com.baidu.tieba.util.bh());
            if (a == null) {
                return null;
            }
            Context baseContext = TiebaApplication.g().getBaseContext();
            a.b(sb.toString());
            a.a(arrayList);
            a.a((Boolean) true);
            a.a(baseContext);
            String s = a.s();
            if (a.o() && s != null) {
                com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
                beVar.a(s);
                String id = beVar.a().getId();
                if (id == null || id.length() <= 0) {
                    a.c(a.k().getString(R.string.neterror));
                    return null;
                }
                AccountData accountData = new AccountData();
                accountData.setAccount(beVar.a().getName());
                if (beVar.a().getPassword() != null) {
                    accountData.setPassword(beVar.a().getPassword());
                } else {
                    accountData.setPassword(str2);
                }
                accountData.setID(beVar.a().getId());
                accountData.setBDUSS(beVar.a().getBDUSS());
                accountData.setPortrait(beVar.a().getPortrait());
                accountData.setIsActive(1);
                if (beVar.b() != null) {
                    accountData.setTbs(beVar.b().getTbs());
                }
                return accountData;
            } else if (a.p()) {
                switch (a.j()) {
                    case 1:
                    case 2:
                    case 5:
                        a.t();
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
            com.baidu.tieba.util.bo.b("LoginModel".toString(), "login", e.getMessage());
            return null;
        }
    }
}
