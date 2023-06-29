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
import com.baidu.tieba.view.festivalview.FestivalTipView;
/* loaded from: classes5.dex */
public interface e26 {
    mg<LinearLayout> A();

    int E();

    mg<TiebaPlusRecommendCard> G1();

    void I(Context context, String str);

    void K(Context context, String str);

    mg<RelativeLayout> S();

    mg<FestivalTipView> U();

    mg<ImageView> W();

    mg<View> X();

    void Y(Context context, String str);

    void Z(Context context, String str, boolean z);

    mg<TextView> Z0();

    void e0(Context context, String str, String str2);

    ListView getListView();

    void i1(Context context, String str);

    void j0(Context context, String str);

    mg<ItemCardView> o0();

    mg<GifView> x();
}
