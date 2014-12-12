package com.baidu.tieba.im.more;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.GetPrivateInfo.GetPrivateInfoResIdl;
/* loaded from: classes.dex */
public class ResponsedPrivacySocketMessage extends SocketResponsedMessage {
    private a privacyData;

    public ResponsedPrivacySocketMessage() {
        super(303016);
        this.privacyData = new a();
    }

    public a getPrivacyData() {
        return this.privacyData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetPrivateInfoResIdl getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class);
        if (getPrivateInfoResIdl != null && getPrivateInfoResIdl.data != null) {
            if (getPrivateInfoResIdl.data.like != null) {
                this.privacyData.gk(getPrivateInfoResIdl.data.like.intValue());
            }
            if (getPrivateInfoResIdl.data.group != null) {
                this.privacyData.gl(getPrivateInfoResIdl.data.group.intValue());
            }
            if (getPrivateInfoResIdl.data.post != null) {
                this.privacyData.gj(getPrivateInfoResIdl.data.post.intValue());
            }
            if (getPrivateInfoResIdl.data.location != null) {
                this.privacyData.gm(getPrivateInfoResIdl.data.location.intValue());
            }
        }
    }
}
