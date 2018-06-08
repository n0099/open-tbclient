package com.baidu.tbadk.coreExtra.message;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public boolean Gp;
        public BlockPopInfoData aCA;
        public JSONObject aCx;
        public boolean aCy;
        public String aCz;
        public c arI;
        public String errorString;
        public boolean isAttention;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;

        public void k(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.aCx = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject(LoginActivityConfig.INFO);
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.isShowMessage = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        r(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void r(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aCz = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!ao.isEmpty(optString) && !ao.isEmpty(this.aCz) && !ao.isEmpty(optString2) && !ao.isEmpty(optString3)) {
                    this.aCA = new BlockPopInfoData();
                    this.aCA.block_info = optString;
                    this.aCA.ahead_url = this.aCz;
                    this.aCA.ahead_info = optString2;
                    this.aCA.ok_info = optString3;
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
        return getData().Gp;
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
