package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class MemoryModifyLastMsgMessage extends CustomResponsedMessage<a> {
    public static final int TYPE_CLEAR_ALL = 1;
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_SEND_MSG = 3;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18050a;

        /* renamed from: b  reason: collision with root package name */
        public int f18051b;

        /* renamed from: c  reason: collision with root package name */
        public ChatMessage f18052c;

        /* renamed from: d  reason: collision with root package name */
        public int f18053d;

        public a() {
        }

        public a(String str, int i, ChatMessage chatMessage, int i2) {
            this.f18050a = str;
            this.f18051b = i;
            this.f18052c = chatMessage;
            this.f18053d = i2;
        }
    }

    public MemoryModifyLastMsgMessage(a aVar) {
        super(2016003, aVar);
    }
}
