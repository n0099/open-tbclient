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
    public int f17254a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17255b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17256c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17257d;

    /* renamed from: e  reason: collision with root package name */
    public View f17258e;

    /* renamed from: f  reason: collision with root package name */
    public View f17259f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17260g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17261h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f17254a = 3;
        this.f17255b = null;
        this.f17256c = null;
        this.f17257d = null;
        this.f17258e = null;
        this.f17259f = null;
        this.f17260g = null;
        this.f17261h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17255b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17256c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17257d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17258e = view.findViewById(R.id.devide_line_top);
        this.f17259f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17260g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17261h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
