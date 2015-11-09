package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public interface l {
    com.baidu.adp.lib.e.b<GifView> getGifViewPool();

    com.baidu.adp.lib.e.b<ImageView> getImageViewPool();

    ListView getListView();

    int getRichTextViewId();

    com.baidu.adp.lib.e.b<TextView> getTextViewPool();

    com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool();

    com.baidu.adp.lib.e.b<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
