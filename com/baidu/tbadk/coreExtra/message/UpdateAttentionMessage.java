package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.aq;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public boolean Hs;
        public c bUD;
        public JSONObject chC;
        public boolean chD;
        public String chE;
        public BlockPopInfoData chF;
        public String errorString;
        public boolean isAttention;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;

        public void R(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.chC = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject(Config.LAUNCH_INFO);
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt("status");
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.isShowMessage = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        ba(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void ba(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.chE = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!aq.isEmpty(optString) && !aq.isEmpty(this.chE) && !aq.isEmpty(optString2) && !aq.isEmpty(optString3)) {
                    this.chF = new BlockPopInfoData();
                    this.chF.block_info = optString;
                    this.chF.ahead_url = this.chE;
                    this.chF.ahead_info = optString2;
                    this.chF.ok_info = optString3;
                }
            }
        }
    }

    public UpdateAttentionMessage(a aVar) {
        super(2001115, aVar);
    }

    public boolean isSucc() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().Hs;
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
