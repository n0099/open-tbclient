package com.baidu.tieba;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface ej5 extends xi5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
