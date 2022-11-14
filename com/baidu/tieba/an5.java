package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
/* loaded from: classes3.dex */
public interface an5 {
    int D();

    void G(Context context, String str);

    void I(Context context, String str);

    og<RelativeLayout> L();

    og<ImageView> N();

    og<View> O();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    og<TextView> W0();

    void Y(Context context, String str);

    og<ItemCardView> e0();

    void e1(Context context, String str);

    ListView getListView();

    og<GifView> w();

    og<TiebaPlusRecommendCard> w1();

    og<LinearLayout> z();
}
