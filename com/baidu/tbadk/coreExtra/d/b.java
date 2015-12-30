package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.n;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public void j(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject optJSONObject2;
        if (jSONObject != null) {
            try {
                jSONArray = jSONObject.getJSONArray("APP_INDEX_START");
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            TbadkSettings inst = TbadkSettings.getInst();
            if (jSONArray != null && jSONArray.length() != 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
                int optInt = optJSONObject.optInt("url_type");
                String optString = optJSONObject.optString("url");
                String optString2 = optJSONObject.optString("apk_url");
                String optString3 = optJSONObject.optString("apk_name");
                String optString4 = optJSONObject.optString("app_name");
                inst.saveString("url", optString);
                inst.saveInt("url_type", optInt);
                inst.saveString("apk_url", optString2);
                inst.saveString("apk_name", optString3);
                inst.saveString("app_name", optString4);
                JSONArray optJSONArray = optJSONObject.optJSONArray("goods_info");
                if (optJSONArray == null || optJSONArray.length() == 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = optJSONObject2.optString("thread_pic");
                    str = optJSONObject2.optString("thread_pic_md5");
                    inst.saveString("apk_size", optJSONObject2.optString("apk_size"));
                }
                if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                    String loadString = inst.loadString("launch_config_md5", null);
                    if (StringUtils.isNull(loadString)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        em(str2);
                    } else if (!TextUtils.equals(loadString, str)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        em(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String yo() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void em(String str) {
        String yo = yo();
        if (!TextUtils.equals(yo, str) || !en(yo)) {
            ae(str, yo);
        }
    }

    private boolean en(String str) {
        File cU = n.cU(az.dB(str));
        return cU != null && cU.exists() && cU.isFile();
    }

    private void ae(String str, String str2) {
        if (i.iR()) {
            new a(str, az.dB(str), str2).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private ab Ua = null;
        private final String ZE;
        private final String akn;
        private final String ako;

        public a(String str, String str2, String str3) {
            this.akn = str;
            this.ZE = str2;
            this.ako = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            Boolean bool = false;
            try {
                this.Ua = new ab(this.akn);
                bool = Boolean.valueOf(this.Ua.a(String.valueOf(this.ZE) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
                if (bool != null && bool.booleanValue()) {
                    if (!StringUtils.isNull(n.g(null, String.valueOf(this.ZE) + ".tmp", null, this.ZE)) && !TextUtils.isEmpty(this.akn) && !this.akn.equals(this.ako)) {
                        n.dc(az.dB(this.ako));
                    }
                } else {
                    n.dc(String.valueOf(this.ZE) + ".tmp");
                }
            } catch (Exception e) {
            }
            return bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool != null && bool.booleanValue()) {
                new b().yn();
            }
        }
    }
}
