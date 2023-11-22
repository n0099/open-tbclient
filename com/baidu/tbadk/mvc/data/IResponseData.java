package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.mn5;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface IResponseData extends mn5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
