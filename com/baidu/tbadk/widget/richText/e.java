package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public interface e {
    void ai(Context context, String str);

    void aj(Context context, String str);

    void ak(Context context, String str);

    void al(Context context, String str);

    void am(Context context, String str);

    int azN();

    com.baidu.adp.lib.e.b<ImageView> azO();

    com.baidu.adp.lib.e.b<TextView> azP();

    com.baidu.adp.lib.e.b<GifView> azQ();

    com.baidu.adp.lib.e.b<View> azR();

    com.baidu.adp.lib.e.b<LinearLayout> azS();

    com.baidu.adp.lib.e.b<RelativeLayout> azT();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void o(Context context, String str, String str2);
}
