package com.baidu.tbadk.coreExtra.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.o;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public void g(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("start_pic_url");
            String optString2 = jSONObject.optString("start_pic_md5");
            if (!StringUtils.isNull(optString2) && !StringUtils.isNull(optString)) {
                TbadkSettings inst = TbadkSettings.getInst();
                String loadString = inst.loadString("launch_config_md5", null);
                if (StringUtils.isNull(loadString)) {
                    inst.saveString("launch_config_md5", optString2);
                    inst.saveString("launch_config_remote_url", optString);
                    dw(optString);
                } else if (!TextUtils.equals(loadString, optString2)) {
                    inst.saveString("launch_config_md5", optString2);
                    inst.saveString("launch_config_remote_url", optString);
                    dw(optString);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (!StringUtils.isNull(loadString)) {
            TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
        }
    }

    public String vR() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void dw(String str) {
        String vR = vR();
        if (!TextUtils.equals(vR, str) || !dx(vR)) {
            ae(str, vR);
        }
    }

    public void vS() {
        if (k.iI()) {
            TbadkSettings inst = TbadkSettings.getInst();
            ae(inst.loadString("launch_config_remote_url", ""), inst.loadString("launch_config_local_url", ""));
        }
    }

    private boolean dx(String str) {
        File cm = o.cm(bf.cN(str));
        return cm != null && cm.exists() && cm.isFile();
    }

    private void ae(String str, String str2) {
        if (k.iI()) {
            new d(str, bf.cN(str), str2).execute(new String[0]);
        }
    }
}
