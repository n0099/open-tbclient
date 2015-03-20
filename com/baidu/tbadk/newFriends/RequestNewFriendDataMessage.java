package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class RequestNewFriendDataMessage extends CustomMessage<Long> {
    public RequestNewFriendDataMessage(long j) {
        super(2001312, Long.valueOf(j));
    }
}
