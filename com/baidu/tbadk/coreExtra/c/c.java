package com.baidu.tbadk.coreExtra.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.s;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("start_pic_url");
            String optString2 = jSONObject.optString("start_pic_md5");
            if (!StringUtils.isNull(optString2) && !StringUtils.isNull(optString)) {
                TbadkSettings inst = TbadkSettings.getInst();
                String loadString = inst.loadString("launch_config_md5", null);
                if (StringUtils.isNull(loadString)) {
                    inst.saveString("launch_config_md5", optString2);
                    inst.saveString("launch_config_remote_url", optString);
                    dp(optString);
                } else if (!TextUtils.equals(loadString, optString2)) {
                    inst.saveString("launch_config_md5", optString2);
                    inst.saveString("launch_config_remote_url", optString);
                    dp(optString);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String sf() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void dp(String str) {
        String sf = sf();
        if (!TextUtils.equals(sf, str) || !dq(sf)) {
            ab(str, sf);
        }
    }

    public void sg() {
        if (com.baidu.adp.lib.util.i.fh()) {
            TbadkSettings inst = TbadkSettings.getInst();
            ab(inst.loadString("launch_config_remote_url", ""), inst.loadString("launch_config_local_url", ""));
        }
    }

    private boolean dq(String str) {
        File cj = s.cj(bc.cI(str));
        return cj != null && cj.exists() && cj.isFile();
    }

    private void ab(String str, String str2) {
        if (com.baidu.adp.lib.util.i.fh()) {
            new d(str, bc.cI(str), str2).execute(new String[0]);
        }
    }
}
