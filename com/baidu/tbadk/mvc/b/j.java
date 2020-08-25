package com.baidu.tbadk.mvc.b;

import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface j extends a {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
