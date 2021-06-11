package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class LoadHistoryResponsedMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17356a;

        /* renamed from: b  reason: collision with root package name */
        public List<ChatMessage> f17357b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17358c;
    }

    public LoadHistoryResponsedMessage(int i2) {
        super(i2);
    }
}
