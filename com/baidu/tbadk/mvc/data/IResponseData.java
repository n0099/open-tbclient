package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.nr5;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IResponseData extends nr5 {
    void initByJson(JSONObject jSONObject);

    void initByProtobuf(Message message);
}
