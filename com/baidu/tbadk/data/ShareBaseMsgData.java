package com.baidu.tbadk.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class ShareBaseMsgData implements Serializable {
    public int subType;

    public abstract String toChatMessageContent();
}
