package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
/* loaded from: classes3.dex */
public class ItemEmotionView extends RelativeLayout {
    public ItemEmotionView(Context context) {
        super(context);
        init(context);
    }

    public ItemEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.forum_emotion_msg_manage, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setEmotionData(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        if (forumEmotionData == null || forumEmotionData.forum_pkg_status != 1) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setEmotionOnClickListener(View.OnClickListener onClickListener) {
        findViewById(d.g.bar_info_emotion_layout).setOnClickListener(onClickListener);
    }
}
