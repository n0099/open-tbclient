package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17548a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17549b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17550c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17551d;

    /* renamed from: e  reason: collision with root package name */
    public View f17552e;

    /* renamed from: f  reason: collision with root package name */
    public View f17553f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17554g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17555h;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.f17548a = 3;
        this.f17549b = null;
        this.f17550c = null;
        this.f17551d = null;
        this.f17552e = null;
        this.f17553f = null;
        this.f17554g = null;
        this.f17555h = null;
        this.f17549b = (TextView) view.findViewById(R.id.topic_module);
        this.f17551d = (TextView) view.findViewById(R.id.topic_desc);
        this.f17550c = (TextView) view.findViewById(R.id.topic_title);
        this.f17554g = (TbImageView) view.findViewById(R.id.topic_pic);
        this.f17552e = view.findViewById(R.id.devide_line_top);
        this.f17553f = view.findViewById(R.id.devide_line_bottom);
        this.f17555h = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
