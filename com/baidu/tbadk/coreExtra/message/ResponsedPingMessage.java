package com.baidu.tbadk.coreExtra.message;

import android.support.v4.view.PointerIconCompat;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
/* loaded from: classes.dex */
public class ResponsedPingMessage extends TbSocketReponsedMessage {
    public ResponsedPingMessage() {
        super(PointerIconCompat.TYPE_HELP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
    }
}
