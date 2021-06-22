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
    public int f16939a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16940b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16941c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16942d;

    /* renamed from: e  reason: collision with root package name */
    public View f16943e;

    /* renamed from: f  reason: collision with root package name */
    public View f16944f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16945g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16946h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16947i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f16939a = 3;
        this.f16940b = null;
        this.f16941c = null;
        this.f16942d = null;
        this.f16943e = null;
        this.f16944f = null;
        this.f16945g = null;
        this.f16946h = null;
        this.f16947i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f16940b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f16941c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f16942d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f16943e = view.findViewById(R.id.devide_line_top);
        this.f16944f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f16945g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f16946h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f16947i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
