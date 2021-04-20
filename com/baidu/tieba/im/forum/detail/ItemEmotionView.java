package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
/* loaded from: classes4.dex */
public class ItemEmotionView extends RelativeLayout {
    public ItemEmotionView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_emotion_msg_manage, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setEmotionData(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        if (forumEmotionData != null && forumEmotionData.forum_pkg_status == 1) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void setEmotionOnClickListener(View.OnClickListener onClickListener) {
        findViewById(R.id.bar_info_emotion_layout).setOnClickListener(onClickListener);
    }

    public ItemEmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
