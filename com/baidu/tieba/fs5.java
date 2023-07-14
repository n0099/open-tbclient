package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface fs5 extends yr5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
