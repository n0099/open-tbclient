package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class MemoryModifyLastMsgMessage extends CustomResponsedMessage<a> {
    public static final int TYPE_CLEAR_ALL = 1;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SEND_MSG = 3;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17362a;

        /* renamed from: b  reason: collision with root package name */
        public int f17363b;

        /* renamed from: c  reason: collision with root package name */
        public ChatMessage f17364c;

        /* renamed from: d  reason: collision with root package name */
        public int f17365d;

        public a() {
        }

        public a(String str, int i2, ChatMessage chatMessage, int i3) {
            this.f17362a = str;
            this.f17363b = i2;
            this.f17364c = chatMessage;
            this.f17365d = i3;
        }
    }

    public MemoryModifyLastMsgMessage(a aVar) {
        super(2016003, aVar);
    }
}
