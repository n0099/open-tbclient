package com.baidu.tbadk.coreExtra.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.o;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public void g(JSONObject jSONObject) {
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
                String optString = optJSONObject.optString(ImageViewerConfig.URL);
                String optString2 = optJSONObject.optString("apk_url");
                String optString3 = optJSONObject.optString("apk_name");
                String optString4 = optJSONObject.optString("app_name");
                inst.saveString(ImageViewerConfig.URL, optString);
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
                        dN(str2);
                    } else if (!TextUtils.equals(loadString, str)) {
                        inst.saveString("launch_config_md5", str);
                        inst.saveString("launch_config_remote_url", str2);
                        dN(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String wB() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void dN(String str) {
        String wB = wB();
        if (!TextUtils.equals(wB, str) || !dO(wB)) {
            aj(str, wB);
        }
    }

    public void wC() {
        if (k.iY()) {
            TbadkSettings inst = TbadkSettings.getInst();
            aj(inst.loadString("launch_config_remote_url", ""), inst.loadString("launch_config_local_url", ""));
        }
    }

    private boolean dO(String str) {
        File cB = o.cB(bd.db(str));
        return cB != null && cB.exists() && cB.isFile();
    }

    private void aj(String str, String str2) {
        if (k.iY()) {
            new d(str, bd.db(str), str2).execute(new String[0]);
        }
    }
}
