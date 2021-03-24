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
    public int f17593a;

    /* renamed from: b  reason: collision with root package name */
    public View f17594b;

    /* renamed from: c  reason: collision with root package name */
    public View f17595c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17596d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17597e;

    /* renamed from: f  reason: collision with root package name */
    public View f17598f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17599g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17600h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f17593a = 3;
        this.f17594b = null;
        this.f17595c = null;
        this.f17596d = null;
        this.f17597e = null;
        this.f17598f = null;
        this.f17599g = null;
        this.f17594b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17595c = view.findViewById(R.id.top_divider_line);
        this.f17596d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17598f = view.findViewById(R.id.divider_line);
        this.f17597e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17599g = (TbImageView) view.findViewById(R.id.img);
        this.f17600h = (TextView) view.findViewById(R.id.title);
        this.i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
