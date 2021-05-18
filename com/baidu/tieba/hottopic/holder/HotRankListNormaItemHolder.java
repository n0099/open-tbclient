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
    public int f16871a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16872b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16873c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16874d;

    /* renamed from: e  reason: collision with root package name */
    public View f16875e;

    /* renamed from: f  reason: collision with root package name */
    public View f16876f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16877g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16878h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16879i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f16871a = 3;
        this.f16872b = null;
        this.f16873c = null;
        this.f16874d = null;
        this.f16875e = null;
        this.f16876f = null;
        this.f16877g = null;
        this.f16878h = null;
        this.f16879i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f16872b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f16873c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f16874d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f16875e = view.findViewById(R.id.devide_line_top);
        this.f16876f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f16877g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f16878h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f16879i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
