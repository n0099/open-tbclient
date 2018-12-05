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
    int SG();

    com.baidu.adp.lib.e.b<ImageView> SH();

    com.baidu.adp.lib.e.b<TextView> SI();

    com.baidu.adp.lib.e.b<GifView> SJ();

    com.baidu.adp.lib.e.b<View> SK();

    com.baidu.adp.lib.e.b<LinearLayout> SL();

    com.baidu.adp.lib.e.b<RelativeLayout> SM();

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    void aq(Context context, String str);

    void ar(Context context, String str);

    void e(Context context, String str, boolean z);

    ListView getListView();

    void i(Context context, String str, String str2);
}
