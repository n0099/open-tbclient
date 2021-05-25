package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16781a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16782b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16783c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16784d;

    /* renamed from: e  reason: collision with root package name */
    public View f16785e;

    /* renamed from: f  reason: collision with root package name */
    public View f16786f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16787g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16788h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16789i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f16781a = 3;
        this.f16782b = null;
        this.f16783c = null;
        this.f16784d = null;
        this.f16785e = null;
        this.f16786f = null;
        this.f16787g = null;
        this.f16788h = null;
        this.f16789i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f16782b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f16783c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f16784d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f16785e = view.findViewById(R.id.devide_line_top);
        this.f16786f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f16787g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f16788h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f16789i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
