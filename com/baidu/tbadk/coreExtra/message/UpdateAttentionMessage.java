package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import d.a.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12574a;

        /* renamed from: b  reason: collision with root package name */
        public String f12575b;

        /* renamed from: c  reason: collision with root package name */
        public String f12576c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f12577d;

        /* renamed from: g  reason: collision with root package name */
        public HttpResponse f12580g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f12581h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f12582i;
        public boolean j;
        public String k;
        public BlockPopInfoData l;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12578e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12579f = false;
        public int m = 0;

        public final void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.k = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            String optString2 = jSONObject.optString("block_confirm");
            String optString3 = jSONObject.optString("block_cancel");
            if (k.isEmpty(optString) || k.isEmpty(this.k) || k.isEmpty(optString2) || k.isEmpty(optString3)) {
                return;
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.l = blockPopInfoData;
            blockPopInfoData.block_info = optString;
            blockPopInfoData.ahead_url = this.k;
            blockPopInfoData.ahead_info = optString2;
            blockPopInfoData.ok_info = optString3;
        }

        public void b(String str, boolean z) {
            if (str == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f12581h = jSONObject;
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    return;
                }
                this.m = jSONObject.optInt("status");
                if (optJSONObject.optInt("is_toast", 0) == 1) {
                }
                optJSONObject.optString("toast_text");
                a(optJSONObject);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public UpdateAttentionMessage(a aVar) {
        super(2001115, aVar);
    }

    public boolean isAttention() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().f12577d;
    }

    public boolean isGod() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().f12579f;
    }

    public boolean isSucc() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().f12574a;
    }
}
