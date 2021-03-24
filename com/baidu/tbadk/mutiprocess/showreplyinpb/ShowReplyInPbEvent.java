package com.baidu.tbadk.mutiprocess.showreplyinpb;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class ShowReplyInPbEvent extends SerializableEvent {
    public boolean isSubPbReply;
    public PostWriteCallBackData writeData;

    public ShowReplyInPbEvent() {
        setType(3);
    }
}
