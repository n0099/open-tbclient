package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.a {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SnapGroupChatActivity snapGroupChatActivity, int i) {
        super(2001119);
        this.a = snapGroupChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.data.b a;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof ChatRoomEventResponseMessage) {
            String a2 = ((ChatRoomEventResponseMessage) customResponsedMessage2).a();
            if (TextUtils.isEmpty(a2) || (a = com.baidu.tieba.im.data.b.a(a2)) == null) {
                return;
            }
            switch (a.h) {
                case 202:
                    SnapGroupChatActivity.a(this.a, a);
                    return;
                default:
                    return;
            }
        }
    }
}
