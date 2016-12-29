package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public boolean akY;
        public String errorString;
        public String showMsg;
        public String toUid;
        public boolean vS;
        public boolean isGod = false;
        public boolean akZ = false;

        public void n(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(LoginActivityConfig.INFO);
                    if (optJSONObject != null) {
                        if (!z || optJSONObject.optInt("is_toast", 0) != 1) {
                            z2 = false;
                        }
                        this.akZ = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    public UpdateAttentionMessage(a aVar) {
        super(CmdConfigCustom.CMD_UPDATE_ATTENTION, aVar);
    }

    public boolean isSucc() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().vS;
    }

    public boolean isAttention() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().akY;
    }

    public boolean isGod() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().isGod;
    }
}
