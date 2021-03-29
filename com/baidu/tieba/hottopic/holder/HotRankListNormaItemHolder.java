package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17577a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17578b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17579c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17580d;

    /* renamed from: e  reason: collision with root package name */
    public View f17581e;

    /* renamed from: f  reason: collision with root package name */
    public View f17582f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17583g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17584h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f17577a = 3;
        this.f17578b = null;
        this.f17579c = null;
        this.f17580d = null;
        this.f17581e = null;
        this.f17582f = null;
        this.f17583g = null;
        this.f17584h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f17578b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f17579c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f17580d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f17581e = view.findViewById(R.id.devide_line_top);
        this.f17582f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f17583g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f17584h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
