package com.baidu.tbadk.coreExtra.message;

import android.support.v4.view.PointerIconCompat;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
/* loaded from: classes.dex */
public class PingMessage extends TbSocketMessage {
    public PingMessage() {
        super(PointerIconCompat.TYPE_HELP);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return null;
    }
}
