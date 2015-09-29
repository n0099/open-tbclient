package com.baidu.tbadk.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class ShareBaseMsgData implements Serializable {
    protected int subType;

    public abstract String toChatMessageContent();
}
