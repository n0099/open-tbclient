package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface cd5 extends vc5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
