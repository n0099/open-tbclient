package com.baidu.tbadk.coreExtra.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public void dd(JSONObject jSONObject) {
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
                int optInt = optJSONObject.optInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE);
                String optString = optJSONObject.optString("url");
                String optString2 = optJSONObject.optString(ConstantData.Logo.LOGO_AD_APK_URL);
                String optString3 = optJSONObject.optString(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME);
                String optString4 = optJSONObject.optString("app_name");
                inst.saveString("url", optString);
                inst.saveInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE, optInt);
                inst.saveString(ConstantData.Logo.LOGO_AD_APK_URL, optString2);
                inst.saveString(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME, optString3);
                inst.saveString("app_name", optString4);
                JSONArray optJSONArray = optJSONObject.optJSONArray("goods_info");
                if (optJSONArray == null || optJSONArray.length() == 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = optJSONObject2.optString("thread_pic");
                    str = optJSONObject2.optString("thread_pic_md5");
                    inst.saveString(ConstantData.Logo.LOGO_AD_APK_SIZE, optJSONObject2.optString(ConstantData.Logo.LOGO_AD_APK_SIZE));
                }
                if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                    String loadString = inst.loadString("launch_config_md5", null);
                    if (StringUtils.isNull(loadString)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        BC(str2);
                    } else if (!TextUtils.equals(loadString, str)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        BC(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpS() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String getLocalUrl() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void BC(String str) {
        String localUrl = getLocalUrl();
        if (!TextUtils.equals(localUrl, str) || !isFileExist(localUrl)) {
            dI(str, localUrl);
        }
    }

    private boolean isFileExist(String str) {
        File GetFile = n.GetFile(av.getNameMd5FromUrl(str));
        return GetFile != null && GetFile.exists() && GetFile.isFile();
    }

    private void dI(String str, String str2) {
        if (j.isWifiNet()) {
            new a(str, av.getNameMd5FromUrl(str), str2).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {
        private aa bGb = null;
        private final String mFile;
        private final String mLocalUrl;
        private final String mRemoteUrl;

        public a(String str, String str2, String str3) {
            this.mRemoteUrl = str;
            this.mFile = str2;
            this.mLocalUrl = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Boolean bool = false;
            try {
                this.bGb = new aa(this.mRemoteUrl);
                bool = Boolean.valueOf(this.bGb.a(this.mFile + ".tmp", new Handler(Looper.getMainLooper()), 900002));
                if (bool != null && bool.booleanValue()) {
                    if (!StringUtils.isNull(n.renameTo(null, this.mFile + ".tmp", null, this.mFile)) && !TextUtils.isEmpty(this.mRemoteUrl) && !this.mRemoteUrl.equals(this.mLocalUrl)) {
                        n.DelFile(av.getNameMd5FromUrl(this.mLocalUrl));
                    }
                } else {
                    n.DelFile(this.mFile + ".tmp");
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
                new c().bpS();
            }
        }
    }
}
