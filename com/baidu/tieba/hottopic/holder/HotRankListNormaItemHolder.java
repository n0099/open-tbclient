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
    public int f16857a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16858b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16859c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16860d;

    /* renamed from: e  reason: collision with root package name */
    public View f16861e;

    /* renamed from: f  reason: collision with root package name */
    public View f16862f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16863g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16864h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16865i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.f16857a = 3;
        this.f16858b = null;
        this.f16859c = null;
        this.f16860d = null;
        this.f16861e = null;
        this.f16862f = null;
        this.f16863g = null;
        this.f16864h = null;
        this.f16865i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f16858b = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.f16859c = (TextView) view.findViewById(R.id.hot_topic_title);
        this.f16860d = (TextView) view.findViewById(R.id.hot_topic_num);
        this.f16861e = view.findViewById(R.id.devide_line_top);
        this.f16862f = view.findViewById(R.id.topic_devide_line_bottom);
        this.f16863g = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.f16864h = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.f16865i = (TextView) view.findViewById(R.id.tip_info_title);
        this.j = (TextView) view.findViewById(R.id.tip_info_rule);
        this.k = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.l = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
