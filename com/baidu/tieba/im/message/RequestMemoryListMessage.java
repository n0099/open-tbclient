package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes4.dex */
public class RequestMemoryListMessage extends CustomMessage<Integer> {
    public static final int TYPE_REQEST_FRIEND_SHOW = 4;
    public static final int TYPE_REQEST_STRANGE = 3;
    public static final int TYPE_REQUEST_ALL = 1;
    public static final int TYPE_REQUEST_OFFICIAL = 2;

    public RequestMemoryListMessage(Integer num) {
        super(2016007, num);
    }
}
