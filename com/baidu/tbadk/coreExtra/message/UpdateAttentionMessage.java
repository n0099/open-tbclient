package com.baidu.tbadk.coreExtra.message;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.a.c;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public boolean Gp;
        public JSONObject aDq;
        public boolean aDr;
        public String aDs;
        public BlockPopInfoData aDt;
        public c arP;
        public String errorString;
        public boolean isAttention;
        public String showMsg;
        public String toUid;
        public boolean isGod = false;
        public boolean isShowMessage = false;
        public int status = 0;

        public void j(String str, boolean z) {
            boolean z2 = true;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.aDq = jSONObject;
                    JSONObject optJSONObject = jSONObject.optJSONObject("info");
                    if (optJSONObject != null) {
                        this.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                        boolean z3 = optJSONObject.optInt("is_toast", 0) == 1;
                        if (!z || !z3) {
                            z2 = false;
                        }
                        this.isShowMessage = z2;
                        this.showMsg = optJSONObject.optString("toast_text");
                        q(optJSONObject);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        private void q(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aDs = jSONObject.optString("block_dealurl");
                String optString = jSONObject.optString("block_content");
                String optString2 = jSONObject.optString("block_confirm");
                String optString3 = jSONObject.optString("block_cancel");
                if (!ap.isEmpty(optString) && !ap.isEmpty(this.aDs) && !ap.isEmpty(optString2) && !ap.isEmpty(optString3)) {
                    this.aDt = new BlockPopInfoData();
                    this.aDt.block_info = optString;
                    this.aDt.ahead_url = this.aDs;
                    this.aDt.ahead_info = optString2;
                    this.aDt.ok_info = optString3;
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
