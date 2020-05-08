package com.baidu.tieba.frs.profession.permission;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import org.json.JSONObject;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes.dex */
public class b implements j {
    public int errorCode;
    public String errorString;
    public boolean hsN;
    public int hsO;
    public String hsP;

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            if (zoneRightResIdl.error != null) {
                this.errorCode = zoneRightResIdl.error.errorno.intValue();
                this.errorString = zoneRightResIdl.error.usermsg;
            }
            if (zoneRightResIdl.data != null) {
                this.hsN = zoneRightResIdl.data.has_right.intValue() == 1;
                if (zoneRightResIdl.data.toast != null) {
                    this.hsO = zoneRightResIdl.data.toast.type.intValue();
                    this.hsP = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
