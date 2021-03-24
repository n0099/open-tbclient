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
    public int f17576a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17577b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17578c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17579d;

    /* renamed from: e  reason: collision with root package name */
    public View f17580e;

    /* renamed from: f  reason: collision with root package name */
    public View f17581f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17582g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17583h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f17576a = 3;
        this.f17577b = null;
        this.f17578c = null;
        this.f17579d = null;
        this.f17580e = null;
        this.f17581f = null;
        this.f17582g = null;
        this.f17583h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17577b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17578c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17579d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17580e = view.findViewById(R.id.devide_line_top);
        this.f17581f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17582g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17583h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
