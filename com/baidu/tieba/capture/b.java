package com.baidu.tieba.capture;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Void, Void, Void> {
    private final PushNotifyMessage baw;
    private a bax = null;

    public b(PushNotifyMessage pushNotifyMessage) {
        this.baw = pushNotifyMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        try {
            this.bax = Op();
        } catch (Throwable th) {
        }
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        try {
            a(this.bax);
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a Op() {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z;
        boolean z2 = true;
        String str4 = "";
        String str5 = "";
        if (this.baw != null) {
            try {
                jSONObject = new JSONObject(this.baw.getContent());
                str4 = jSONObject.optString("server_host", "");
                str5 = jSONObject.optString("chat_host", "");
                z = TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5);
                if (!str4.endsWith("/")) {
                    str4 = String.valueOf(str4) + "/";
                }
                str = !str5.endsWith("/") ? String.valueOf(str5) + "/" : str5;
            } catch (JSONException e) {
                str = str5;
                str2 = str4;
            }
            try {
                String optString = jSONObject.optString("cuid_prefix", "");
                if (!TextUtils.isEmpty(optString)) {
                    String cuid = TbadkCoreApplication.m9getInst().getCuid();
                    if (!TextUtils.isEmpty(cuid) && !cuid.startsWith(optString)) {
                        BdLog.e("Not match, current device cuid:" + cuid + ", cuid_prefix:" + optString);
                        return null;
                    }
                }
                z2 = z;
                str3 = str;
            } catch (JSONException e2) {
                str2 = str4;
                str3 = str;
                str4 = str2;
                if (!z2) {
                }
                if (z2) {
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                return new a(r1, str4, str3, null);
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.tW().getLong("tbpp_key_capture_initial_time", 1L);
            if (j < 1) {
                return null;
            }
            str4 = com.baidu.tbadk.core.sharedPref.b.tW().getString("tbpp_key_capture_server_host", "");
            str3 = com.baidu.tbadk.core.sharedPref.b.tW().getString("tbpp_key_capture_chat_host", "");
            if (System.currentTimeMillis() - j <= TimeUnit.HOURS.toMillis(3L)) {
                z2 = false;
            }
        }
        long currentTimeMillis = !z2 ? 0L : System.currentTimeMillis();
        if (z2) {
            str4 = "";
            str3 = "";
            BdLog.e("Reset host to original.");
        }
        if (!TextUtils.isEmpty(str4)) {
            TbConfig.setAppServer(str4);
            BdLog.e("Change server host to " + str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            TiebaIMConfig.url = str3;
            BdLog.e("Change im host to " + str3);
        }
        return new a(currentTimeMillis, str4, str3, null);
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.tW().putLong("tbpp_key_capture_initial_time", aVar.time);
        com.baidu.tbadk.core.sharedPref.b.tW().putString("tbpp_key_capture_server_host", aVar.bay);
        com.baidu.tbadk.core.sharedPref.b.tW().putString("tbpp_key_capture_chat_host", aVar.baz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final String bay;
        private final String baz;
        private final long time;

        private a(long j, String str, String str2) {
            this.time = j;
            this.bay = str;
            this.baz = str2;
        }

        /* synthetic */ a(long j, String str, String str2, a aVar) {
            this(j, str, str2);
        }
    }
}
