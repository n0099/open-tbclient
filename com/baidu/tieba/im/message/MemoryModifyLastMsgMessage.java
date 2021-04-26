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
        public String f18061a;

        /* renamed from: b  reason: collision with root package name */
        public int f18062b;

        /* renamed from: c  reason: collision with root package name */
        public ChatMessage f18063c;

        /* renamed from: d  reason: collision with root package name */
        public int f18064d;

        public a() {
        }

        public a(String str, int i2, ChatMessage chatMessage, int i3) {
            this.f18061a = str;
            this.f18062b = i2;
            this.f18063c = chatMessage;
            this.f18064d = i3;
        }
    }

    public MemoryModifyLastMsgMessage(a aVar) {
        super(2016003, aVar);
    }
}
