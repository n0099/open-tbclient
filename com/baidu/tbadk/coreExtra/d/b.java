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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public void k(JSONObject jSONObject) {
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
                        es(str2);
                    } else if (!TextUtils.equals(loadString, str)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        es(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String Aj() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void es(String str) {
        String Aj = Aj();
        if (!TextUtils.equals(Aj, str) || !et(Aj)) {
            ai(str, Aj);
        }
    }

    private boolean et(String str) {
        File cU = m.cU(ba.dB(str));
        return cU != null && cU.exists() && cU.isFile();
    }

    private void ai(String str, String str2) {
        if (i.jg()) {
            new a(str, ba.dB(str), str2).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private ab QV = null;
        private final String Zn;
        private final String alu;
        private final String alv;

        public a(String str, String str2, String str3) {
            this.alu = str;
            this.Zn = str2;
            this.alv = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            Boolean bool = false;
            try {
                this.QV = new ab(this.alu);
                bool = Boolean.valueOf(this.QV.a(String.valueOf(this.Zn) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
                if (bool != null && bool.booleanValue()) {
                    if (!StringUtils.isNull(m.h(null, String.valueOf(this.Zn) + ".tmp", null, this.Zn)) && !TextUtils.isEmpty(this.alu) && !this.alu.equals(this.alv)) {
                        m.dc(ba.dB(this.alv));
                    }
                } else {
                    m.dc(String.valueOf(this.Zn) + ".tmp");
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
                new b().Ai();
            }
        }
    }
}
