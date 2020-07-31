package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.as;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public String blockUrl;
        public c ebJ;
        public BlockPopInfoData erH;
        public String errorString;
        public boolean hasShownForbiddenAlert;
        public boolean isAttention;
        public boolean isSucc;
        public JSONObject resultJson;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;

        public void parserJson(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.resultJson = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject("info");
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt("status");
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.isShowMessage = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        parseBlockAnti(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void parseBlockAnti(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.blockUrl = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!as.isEmpty(optString) && !as.isEmpty(this.blockUrl) && !as.isEmpty(optString2) && !as.isEmpty(optString3)) {
                    this.erH = new BlockPopInfoData();
                    this.erH.block_info = optString;
                    this.erH.ahead_url = this.blockUrl;
                    this.erH.ahead_info = optString2;
                    this.erH.ok_info = optString3;
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
        return getData().isSucc;
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
