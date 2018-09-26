package com.baidu.tieba.frs.smartapp;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.SmartAppList.SmartAppListResIdl;
/* loaded from: classes2.dex */
public class FrsListProgramListSocketResponseMessage extends SocketResponsedMessage {
    public boolean hasMore;
    public ArrayList<b> smart_app_list;

    public FrsListProgramListSocketResponseMessage() {
        super(309623);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SmartAppListResIdl smartAppListResIdl;
        int i2 = 0;
        if (bArr != null && (smartAppListResIdl = (SmartAppListResIdl) new Wire(new Class[0]).parseFrom(bArr, SmartAppListResIdl.class)) != null) {
            if (smartAppListResIdl.error != null && smartAppListResIdl.error.errorno != null) {
                setError(smartAppListResIdl.error.errorno.intValue());
            }
            if (smartAppListResIdl.error != null && smartAppListResIdl.error.usermsg != null && smartAppListResIdl.error.usermsg.length() > 0) {
                setErrorString(smartAppListResIdl.error.usermsg);
            }
            if (smartAppListResIdl.data != null && smartAppListResIdl.data.smart_app_list != null) {
                this.smart_app_list = new ArrayList<>();
                while (true) {
                    int i3 = i2;
                    if (i3 < smartAppListResIdl.data.smart_app_list.size()) {
                        b bVar = new b();
                        bVar.a(smartAppListResIdl.data.smart_app_list.get(i3));
                        this.smart_app_list.add(bVar);
                        i2 = i3 + 1;
                    } else {
                        this.hasMore = smartAppListResIdl.data.has_more.booleanValue();
                        return;
                    }
                }
            }
        }
    }

    public ArrayList<b> getList() {
        return this.smart_app_list;
    }
}
