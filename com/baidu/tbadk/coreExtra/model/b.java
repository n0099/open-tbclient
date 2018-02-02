package com.baidu.tbadk.coreExtra.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public void h(JSONObject jSONObject) {
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
                        fh(str2);
                    } else if (!TextUtils.equals(loadString, str)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        fh(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String Ha() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void fh(String str) {
        String Ha = Ha();
        if (!TextUtils.equals(Ha, str) || !isFileExist(Ha)) {
            af(str, Ha);
        }
    }

    private boolean isFileExist(String str) {
        File dr = k.dr(ao.ej(str));
        return dr != null && dr.exists() && dr.isFile();
    }

    private void af(String str, String str2) {
        if (j.oK()) {
            new a(str, ao.ej(str), str2).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private final String bhA;
        private final String bhz;
        private final String mFile;
        private x mNetWork = null;

        public a(String str, String str2, String str3) {
            this.bhz = str;
            this.mFile = str2;
            this.bhA = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Boolean bool = false;
            try {
                this.mNetWork = new x(this.bhz);
                bool = Boolean.valueOf(this.mNetWork.a(this.mFile + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
                if (bool != null && bool.booleanValue()) {
                    if (!StringUtils.isNull(k.i(null, this.mFile + ".tmp", null, this.mFile)) && !TextUtils.isEmpty(this.bhz) && !this.bhz.equals(this.bhA)) {
                        k.dJ(ao.ej(this.bhA));
                    }
                } else {
                    k.dJ(this.mFile + ".tmp");
                }
            } catch (Exception e) {
            }
            return bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (bool != null && bool.booleanValue()) {
                new b().GZ();
            }
        }
    }
}
