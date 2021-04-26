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
    public int f17556a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17557b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17558c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17559d;

    /* renamed from: e  reason: collision with root package name */
    public View f17560e;

    /* renamed from: f  reason: collision with root package name */
    public View f17561f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17562g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17563h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17564i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f17556a = 3;
        this.f17557b = null;
        this.f17558c = null;
        this.f17559d = null;
        this.f17560e = null;
        this.f17561f = null;
        this.f17562g = null;
        this.f17563h = null;
        this.f17564i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17557b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17558c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17559d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17560e = view.findViewById(R.id.devide_line_top);
        this.f17561f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17562g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17563h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f17564i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
