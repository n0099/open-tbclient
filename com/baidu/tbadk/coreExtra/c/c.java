package com.baidu.tbadk.coreExtra.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.bh;
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
                    dn(optString);
                } else if (!TextUtils.equals(loadString, optString2)) {
                    inst.saveString("launch_config_md5", optString2);
                    inst.saveString("launch_config_remote_url", optString);
                    dn(optString);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String sv() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void dn(String str) {
        String sv = sv();
        if (!TextUtils.equals(sv, str) || !dp(sv)) {
            ae(str, sv);
        }
    }

    public void sw() {
        if (com.baidu.adp.lib.util.i.fg()) {
            TbadkSettings inst = TbadkSettings.getInst();
            ae(inst.loadString("launch_config_remote_url", ""), inst.loadString("launch_config_local_url", ""));
        }
    }

    private boolean dp(String str) {
        File ch = s.ch(bh.cH(str));
        return ch != null && ch.exists() && ch.isFile();
    }

    private void ae(String str, String str2) {
        if (com.baidu.adp.lib.util.i.fg()) {
            new d(str, bh.cH(str), str2).execute(new String[0]);
        }
    }
}
