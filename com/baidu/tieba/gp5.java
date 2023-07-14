package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import java.util.List;
/* loaded from: classes6.dex */
public interface gp5 {
    void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> list);

    void onFailure(int i, String str);
}
