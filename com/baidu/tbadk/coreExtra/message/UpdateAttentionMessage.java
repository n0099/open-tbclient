package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.am;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public boolean BJ;
        public c ahT;
        public JSONObject arJ;
        public boolean arK;
        public BlockPopInfoData arL;
        public String errorString;
        public boolean isAttention;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean arI = false;

        public void k(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.arJ = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject(LoginActivityConfig.INFO);
                    if (optJSONObject != null) {
                        if (!z || optJSONObject.optInt("is_toast", 0) != 1) {
                            z2 = false;
                        }
                        this.arI = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        String optString = optJSONObject.optString("block_content");
                        String optString2 = optJSONObject.optString("block_dealurl");
                        String optString3 = optJSONObject.optString("block_confirm");
                        String optString4 = optJSONObject.optString("block_cancel");
                        if (!am.isEmpty(optString) && !am.isEmpty(optString2) && !am.isEmpty(optString3) && !am.isEmpty(optString4)) {
                            this.arL = new BlockPopInfoData();
                            this.arL.block_info = optString;
                            this.arL.ahead_url = optString2;
                            this.arL.ahead_info = optString3;
                            this.arL.ok_info = optString4;
                        }
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
        return getData().BJ;
    }

    public boolean isAttention() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().isAttention;
    }

    public boolean isGod() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().isGod;
    }
}
