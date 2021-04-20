package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import d.b.c.e.p.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UpdateAttentionMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f13354a;

        /* renamed from: b  reason: collision with root package name */
        public String f13355b;

        /* renamed from: c  reason: collision with root package name */
        public String f13356c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f13357d;

        /* renamed from: f  reason: collision with root package name */
        public HttpResponse f13359f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f13360g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f13361h;
        public boolean i;
        public String j;
        public BlockPopInfoData k;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13358e = false;
        public int l = 0;

        public final void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.j = jSONObject.optString("block_dealurl");
            String optString = jSONObject.optString("block_content");
            String optString2 = jSONObject.optString("block_confirm");
            String optString3 = jSONObject.optString("block_cancel");
            if (k.isEmpty(optString) || k.isEmpty(this.j) || k.isEmpty(optString2) || k.isEmpty(optString3)) {
                return;
            }
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.k = blockPopInfoData;
            blockPopInfoData.block_info = optString;
            blockPopInfoData.ahead_url = this.j;
            blockPopInfoData.ahead_info = optString2;
            blockPopInfoData.ok_info = optString3;
        }

        public void b(String str, boolean z) {
            if (str == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f13360g = jSONObject;
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject == null) {
                    return;
                }
                this.l = jSONObject.optInt("status");
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
        return getData().f13357d;
    }

    public boolean isGod() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().f13358e;
    }

    public boolean isSucc() {
        if (getData() == null || !(getData() instanceof a)) {
            return false;
        }
        return getData().f13354a;
    }
}
