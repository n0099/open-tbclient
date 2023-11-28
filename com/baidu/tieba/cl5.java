package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.request.IMEmojiReplyListListener;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public interface cl5 {
    void onFailure(int i, String str);

    void onSuccess(Map<Long, ? extends ArrayList<IMEmojiReplyListListener.IMEmojiItem>> map);
}
