package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17279a;

    /* renamed from: b  reason: collision with root package name */
    public View f17280b;

    /* renamed from: c  reason: collision with root package name */
    public View f17281c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17282d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17283e;

    /* renamed from: f  reason: collision with root package name */
    public View f17284f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17285g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17286h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f17279a = 3;
        this.f17280b = null;
        this.f17281c = null;
        this.f17282d = null;
        this.f17283e = null;
        this.f17284f = null;
        this.f17285g = null;
        this.f17280b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17281c = view.findViewById(R.id.top_divider_line);
        this.f17282d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17284f = view.findViewById(R.id.divider_line);
        this.f17283e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17285g = (TbImageView) view.findViewById(R.id.img);
        this.f17286h = (TextView) view.findViewById(R.id.title);
        this.i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
