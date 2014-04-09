package com.baidu.tbadk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.c;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.b;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {
    public static final String a = PushMessageReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArrayExtra;
        JSONObject optJSONObject;
        if (intent != null && context != null) {
            if (intent.getAction().equals("com.baidu.android.pushservice.action.MESSAGE")) {
                try {
                    String string = intent.getExtras().getString("message_string");
                    if (string == null && (byteArrayExtra = intent.getByteArrayExtra("message")) != null) {
                        string = new String(byteArrayExtra, "utf-8");
                    }
                    if (TextUtils.isEmpty(string)) {
                        f.b("receive message is empty");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("tp");
                    String optString = jSONObject.optString("msg");
                    if (!TextUtils.isEmpty(optString)) {
                        switch (optInt) {
                            case 1:
                            case 4:
                            case 9:
                            case 13:
                                if (TbadkApplication.E() != null) {
                                    b bVar = new b();
                                    bVar.a(optString);
                                    if (TbadkApplication.E().equals(bVar.e())) {
                                        TbadkApplication.j();
                                        if (TbadkApplication.aG()) {
                                            c.a().a(new com.baidu.adp.framework.message.a(2006001, "start_once"));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 14:
                                if (TbadkApplication.E() != null) {
                                    UtilHelper.a(context, new k(-1L, "vote", optString, ""), 15);
                                    return;
                                }
                                return;
                            case 65535:
                                b bVar2 = new b();
                                bVar2.a(optString);
                                if (TbadkApplication.j().x() && !TextUtils.isEmpty(bVar2.a())) {
                                    TiebaStatic.a(TbadkApplication.j().b().getApplicationContext(), "push_noti:" + bVar2.a(), "msgID:" + bVar2.b());
                                }
                                if (!TextUtils.isEmpty(bVar2.c()) && !TextUtils.isEmpty(bVar2.a())) {
                                    TiebaStatic.a(bVar2.b(), 1, bVar2.c(), bVar2.a());
                                }
                                bVar2.b();
                                UtilHelper.a(TbadkApplication.j().b().getApplicationContext(), new k(bVar2.b(), bVar2.c(), bVar2.d(), bVar2.a()), 13);
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals("com.baidu.android.pushservice.action.RECEIVE")) {
                try {
                    String stringExtra = intent.getStringExtra("method");
                    int intExtra = intent.getIntExtra("error_msg", 0);
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("content");
                    if (byteArrayExtra2 != null && byteArrayExtra2.length != 0) {
                        String str = new String(byteArrayExtra2);
                        if ("method_bind".equals(stringExtra) && intExtra == 0 && (optJSONObject = new JSONObject(str).optJSONObject("response_params")) != null) {
                            String optString2 = optJSONObject.optString("channel_id");
                            String optString3 = optJSONObject.optString("user_id");
                            if (optString2 != null) {
                                TbadkApplication.j().e(optString2);
                            }
                            if (optString3 != null) {
                                TbadkApplication.j().f(optString3);
                            }
                            new a((byte) 0).start();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (intent.getAction().equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                f.e(a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra("extra_extra_custom_content"));
            }
        }
    }
}
