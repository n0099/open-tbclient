package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface hk5 extends ak5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
