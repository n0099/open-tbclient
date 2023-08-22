package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyDetailListener;
import java.util.List;
/* loaded from: classes5.dex */
public interface bo5 {
    void a(int i, List<? extends IMEmojiReplyDetailListener.IMEmojiReplyReactionDetail> list);

    void onFailure(int i, String str);
}
