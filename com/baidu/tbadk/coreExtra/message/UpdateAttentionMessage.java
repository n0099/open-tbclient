package com.baidu.tbadk.coreExtra.message;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.am;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public c aYh;
        public boolean apP;
        public JSONObject biR;
        public boolean biS;
        public String biT;
        public BlockPopInfoData biU;
        public String errorString;
        public boolean isAttention;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean biQ = false;
        public int status = 0;

        public void k(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.biR = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject(LoginActivityConfig.INFO);
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.biQ = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        k(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void k(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.biT = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!am.isEmpty(optString) && !am.isEmpty(this.biT) && !am.isEmpty(optString2) && !am.isEmpty(optString3)) {
                    this.biU = new BlockPopInfoData();
                    this.biU.block_info = optString;
                    this.biU.ahead_url = this.biT;
                    this.biU.ahead_info = optString2;
                    this.biU.ok_info = optString3;
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
        return getData().apP;
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
